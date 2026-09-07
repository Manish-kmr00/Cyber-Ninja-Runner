package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
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
import androidx.compose.ui.unit.IntOffset;
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

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010,\u001aÄ\u0001\u0010-\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\r2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00106\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aU\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a)\u0010L\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010M\u001a\u0002042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a|\u0010P\u001a\u00020\t*\u00020Q2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010W\u001a\u00020U2\b\u0010X\u001a\u0004\u0018\u00010U2\b\u0010Y\u001a\u0004\u0018\u00010U2\u0006\u0010Z\u001a\u00020U2\u0006\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010A\u001a\u0002022\u0006\u0010[\u001a\u00020\\2\u0006\u00106\u001a\u000207H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m3843constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m3843constructorimpl(8);

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
    /* JADX WARN: Code duplicated, block: B:228:0x02f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:229:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:230:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:232:0x0300  */
    /* JADX WARN: Code duplicated, block: B:233:0x0302  */
    /* JADX WARN: Code duplicated, block: B:235:0x0306  */
    /* JADX WARN: Code duplicated, block: B:236:0x0308  */
    /* JADX WARN: Code duplicated, block: B:239:0x030e  */
    /* JADX WARN: Code duplicated, block: B:240:0x0330  */
    /* JADX WARN: Code duplicated, block: B:242:0x0338  */
    /* JADX WARN: Code duplicated, block: B:243:0x033a  */
    /* JADX WARN: Code duplicated, block: B:245:0x033e  */
    /* JADX WARN: Code duplicated, block: B:246:0x0340  */
    /* JADX WARN: Code duplicated, block: B:248:0x0344  */
    /* JADX WARN: Code duplicated, block: B:249:0x0346  */
    /* JADX WARN: Code duplicated, block: B:251:0x034a  */
    /* JADX WARN: Code duplicated, block: B:252:0x034c  */
    /* JADX WARN: Code duplicated, block: B:254:0x0350  */
    /* JADX WARN: Code duplicated, block: B:255:0x0352  */
    /* JADX WARN: Code duplicated, block: B:257:0x0356  */
    /* JADX WARN: Code duplicated, block: B:258:0x035d  */
    /* JADX WARN: Code duplicated, block: B:261:0x0363  */
    /* JADX WARN: Code duplicated, block: B:262:0x036c  */
    /* JADX WARN: Code duplicated, block: B:265:0x0374  */
    /* JADX WARN: Code duplicated, block: B:266:0x037d  */
    /* JADX WARN: Code duplicated, block: B:268:0x0381  */
    /* JADX WARN: Code duplicated, block: B:269:0x0383  */
    /* JADX WARN: Code duplicated, block: B:271:0x0387  */
    /* JADX WARN: Code duplicated, block: B:272:0x038d  */
    /* JADX WARN: Code duplicated, block: B:275:0x0393  */
    /* JADX WARN: Code duplicated, block: B:277:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:279:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:282:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:283:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:286:0x03df  */
    /* JADX WARN: Code duplicated, block: B:287:0x043e  */
    /* JADX WARN: Code duplicated, block: B:291:0x047a  */
    /* JADX WARN: Code duplicated, block: B:294:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:295:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:300:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:302:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        int i29;
        KeyboardActions keyboardActions2;
        boolean z8;
        int i30;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource2;
        CornerBasedShape small;
        Modifier modifier2;
        KeyboardActions keyboardActions4;
        Function2<? super Composer, ? super Integer, Unit> function10;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Composer, ? super Integer, Unit> function11;
        VisualTransformation visualTransformation2;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        boolean z9;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        boolean z11;
        Shape shape2;
        TextStyle textStyle3;
        boolean z12;
        TextFieldColors textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
        Object objRememberedValue;
        long jM3505getColor0d7_KjU;
        Modifier modifierM427paddingqDBjuR0$default;
        Composer composer2;
        final Modifier modifier3;
        final boolean z13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final Function2<? super Composer, ? super Integer, Unit> function17;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions5;
        final boolean z14;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z15;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final TextStyle textStyle4;
        final boolean z16;
        final int i31;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i32;
        int i33;
        int i34;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)137@7575L7,148@8135L39,149@8209L6,150@8271L25,166@8821L24,175@9187L20,159@8599L1801:OutlinedTextField.kt#jmzs0o");
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
        int i35 = i4 & 4;
        if (i35 == 0) {
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
                        i34 = 65536;
                    } else {
                        i34 = 131072;
                    }
                    i5 |= i34;
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
                        i33 = 4194304;
                    } else {
                        i33 = 8388608;
                    }
                    i23 |= i33;
                }
                if ((i3 & 234881024) != 0) {
                    if ((i4 & 262144) == 0 || !composerStartRestartGroup.changed(textFieldColors)) {
                        i32 = 33554432;
                    } else {
                        i32 = 67108864;
                    }
                    i23 |= i32;
                }
                if ((i5 & 1533916891) == 306783378 || (191739611 & i23) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
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
                        function13 = function2;
                        function12 = function3;
                        function10 = function4;
                        function11 = function5;
                        z12 = z3;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions3 = keyboardOptions;
                        keyboardActions4 = keyboardActions;
                        z9 = z4;
                        i30 = i;
                        mutableInteractionSource3 = mutableInteractionSource;
                        shape2 = shape;
                    } else {
                        if (i35 != 0) {
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
                        i29 = i5;
                        if ((i4 & 8192) != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
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
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i23 = (-29360129) & i23;
                        } else {
                            small = shape;
                        }
                        if ((262144 & i4) != 0) {
                            i23 &= -234881025;
                            modifier2 = companion;
                            keyboardActions4 = keyboardActions3;
                            function10 = function8;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            function11 = function9;
                            visualTransformation2 = none;
                            function12 = function7;
                            function13 = function6;
                            z9 = z8;
                            keyboardOptions3 = keyboardOptions2;
                            z10 = z6;
                            z11 = z5;
                            shape2 = small;
                            textStyle3 = textStyle2;
                            z12 = z7;
                            i5 = i29;
                            textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        } else {
                            modifier2 = companion;
                            keyboardActions4 = keyboardActions3;
                            function10 = function8;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            function11 = function9;
                            visualTransformation2 = none;
                            function12 = function7;
                            function13 = function6;
                            z9 = z8;
                            keyboardOptions3 = keyboardOptions2;
                            z10 = z6;
                            z11 = z5;
                            shape2 = small;
                            textStyle3 = textStyle2;
                            z12 = z7;
                            i5 = i29;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1961394975);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                        jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyleMerge = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                        if (function13 != null) {
                            modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM427paddingqDBjuR0$default = modifier2;
                        }
                        int i36 = (i23 >> 21) & 112;
                        final boolean z17 = z11;
                        final boolean z18 = z9;
                        final VisualTransformation visualTransformation4 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        final boolean z19 = z12;
                        final Function2<? super Composer, ? super Integer, Unit> function18 = function13;
                        final Function2<? super Composer, ? super Integer, Unit> function19 = function12;
                        final Function2<? super Composer, ? super Integer, Unit> function20 = function10;
                        final Function2<? super Composer, ? super Integer, Unit> function21 = function11;
                        final TextFieldColors textFieldColors3 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                        final int i37 = i5;
                        final int i38 = i23;
                        final Shape shape4 = shape2;
                        int i39 = i23 << 12;
                        Shape shape5 = shape2;
                        composer2 = composerStartRestartGroup;
                        TextStyle textStyle5 = textStyle3;
                        boolean z20 = z11;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i36).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i36 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
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
                                ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                                if ((i40 & 14) == 0) {
                                    i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                } else {
                                    i41 = i40;
                                }
                                if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    String str = value;
                                    boolean z21 = z17;
                                    boolean z22 = z18;
                                    VisualTransformation visualTransformation5 = visualTransformation4;
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                    boolean z23 = z19;
                                    Function2<Composer, Integer, Unit> function22 = function18;
                                    Function2<Composer, Integer, Unit> function23 = function19;
                                    Function2<Composer, Integer, Unit> function24 = function20;
                                    Function2<Composer, Integer, Unit> function25 = function21;
                                    TextFieldColors textFieldColors4 = textFieldColors3;
                                    final boolean z24 = z17;
                                    final boolean z25 = z19;
                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                    final TextFieldColors textFieldColors5 = textFieldColors3;
                                    final Shape shape6 = shape4;
                                    final int i42 = i37;
                                    final int i43 = i38;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i44) {
                                            ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                            if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                                TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                                boolean z26 = z24;
                                                boolean z27 = z25;
                                                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                                                TextFieldColors textFieldColors6 = textFieldColors5;
                                                Shape shape7 = shape6;
                                                int i45 = ((i42 >> 9) & 14) | 12582912;
                                                int i46 = i43;
                                                textFieldDefaults2.m1218BorderBoxnbWgWpA(z26, z27, mutableInteractionSource8, textFieldColors6, shape7, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                    int i44 = i37;
                                    int i45 = i38;
                                    textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z21, z22, visualTransformation5, mutableInteractionSource6, z23, function22, function23, function24, function25, textFieldColors4, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i5 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                        modifier3 = modifier2;
                        z13 = z10;
                        function14 = function13;
                        function15 = function12;
                        function16 = function10;
                        function17 = function11;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions4 = keyboardOptions3;
                        keyboardActions5 = keyboardActions4;
                        z14 = z9;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z15 = z12;
                        textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                        shape3 = shape5;
                        textStyle4 = textStyle5;
                        z16 = z20;
                        i31 = i30;
                    }
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1961394975);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                    jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyleMerge2 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                    if (function13 != null) {
                        modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                    } else {
                        modifierM427paddingqDBjuR0$default = modifier2;
                    }
                    int i310 = (i23 >> 21) & 112;
                    final boolean z110 = z11;
                    final boolean z111 = z9;
                    final VisualTransformation visualTransformation5 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                    final boolean z112 = z12;
                    final Function2<? super Composer, ? super Integer, Unit> function110 = function13;
                    final Function2<? super Composer, ? super Integer, Unit> function111 = function12;
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function10;
                    final Function2<? super Composer, ? super Integer, Unit> function23 = function11;
                    final TextFieldColors textFieldColors4 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                    final int i311 = i5;
                    final int i312 = i23;
                    final Shape shape6 = shape2;
                    int i313 = i23 << 12;
                    Shape shape7 = shape2;
                    composer2 = composerStartRestartGroup;
                    TextStyle textStyle6 = textStyle3;
                    boolean z21 = z11;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i310).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge2, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i310 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
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
                            ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                            if ((i40 & 14) == 0) {
                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                            } else {
                                i41 = i40;
                            }
                            if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                String str = value;
                                boolean z22 = z110;
                                boolean z23 = z111;
                                VisualTransformation visualTransformation6 = visualTransformation5;
                                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                boolean z24 = z112;
                                Function2<Composer, Integer, Unit> function24 = function110;
                                Function2<Composer, Integer, Unit> function25 = function111;
                                Function2<Composer, Integer, Unit> function26 = function22;
                                Function2<Composer, Integer, Unit> function27 = function23;
                                TextFieldColors textFieldColors5 = textFieldColors4;
                                final boolean z25 = z110;
                                final boolean z26 = z112;
                                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                final TextFieldColors textFieldColors6 = textFieldColors4;
                                final Shape shape8 = shape6;
                                final int i42 = i311;
                                final int i43 = i312;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i44) {
                                        ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                        if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            boolean z27 = z25;
                                            boolean z28 = z26;
                                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                                            TextFieldColors textFieldColors7 = textFieldColors6;
                                            Shape shape9 = shape8;
                                            int i45 = ((i42 >> 9) & 14) | 12582912;
                                            int i46 = i43;
                                            textFieldDefaults2.m1218BorderBoxnbWgWpA(z27, z28, mutableInteractionSource9, textFieldColors7, shape9, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                                int i44 = i311;
                                int i45 = i312;
                                textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z22, z23, visualTransformation6, mutableInteractionSource7, z24, function24, function25, function26, function27, textFieldColors5, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i5 & 64638) | (i313 & 3670016) | (KeyboardActions.$stable << 21) | (i313 & 29360128) | (i313 & 234881024) | (i313 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                    modifier3 = modifier2;
                    z13 = z10;
                    function14 = function13;
                    function15 = function12;
                    function16 = function10;
                    function17 = function11;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions5 = keyboardActions4;
                    z14 = z9;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z15 = z12;
                    textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                    shape3 = shape7;
                    textStyle4 = textStyle6;
                    z16 = z21;
                    i31 = i30;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z16 = z;
                    z13 = z2;
                    textStyle4 = textStyle;
                    function15 = function3;
                    function16 = function4;
                    function17 = function5;
                    z15 = z3;
                    visualTransformation3 = visualTransformation;
                    keyboardOptions4 = keyboardOptions;
                    keyboardActions5 = keyboardActions;
                    z14 = z4;
                    i31 = i;
                    mutableInteractionSource4 = mutableInteractionSource;
                    shape3 = shape;
                    textFieldColors2 = textFieldColors;
                    composer2 = composerStartRestartGroup;
                    function14 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                        OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                    i34 = 65536;
                } else {
                    i34 = 65536;
                }
                i5 |= i34;
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
                    i33 = 4194304;
                } else {
                    i33 = 4194304;
                }
                i23 |= i33;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i32 = 33554432;
                } else {
                    i32 = 33554432;
                }
                i23 |= i32;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961394975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge3 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i314 = (i23 >> 21) & 112;
                final boolean z113 = z11;
                final boolean z114 = z9;
                final VisualTransformation visualTransformation6 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                final boolean z115 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function112 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function113 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function25 = function11;
                final TextFieldColors textFieldColors5 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i315 = i5;
                final int i316 = i23;
                final Shape shape8 = shape2;
                int i317 = i23 << 12;
                Shape shape9 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle7 = textStyle3;
                boolean z22 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i314).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge3, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i314 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
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
                        ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z23 = z113;
                            boolean z24 = z114;
                            VisualTransformation visualTransformation7 = visualTransformation6;
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                            boolean z25 = z115;
                            Function2<Composer, Integer, Unit> function26 = function112;
                            Function2<Composer, Integer, Unit> function27 = function113;
                            Function2<Composer, Integer, Unit> function28 = function24;
                            Function2<Composer, Integer, Unit> function29 = function25;
                            TextFieldColors textFieldColors6 = textFieldColors5;
                            final boolean z26 = z113;
                            final boolean z27 = z115;
                            final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource7;
                            final TextFieldColors textFieldColors7 = textFieldColors5;
                            final Shape shape10 = shape8;
                            final int i42 = i315;
                            final int i43 = i316;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z28 = z26;
                                        boolean z29 = z27;
                                        MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                                        TextFieldColors textFieldColors8 = textFieldColors7;
                                        Shape shape11 = shape10;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z28, z29, mutableInteractionSource10, textFieldColors8, shape11, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i315;
                            int i45 = i316;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z23, z24, visualTransformation7, mutableInteractionSource8, z25, function26, function27, function28, function29, textFieldColors6, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i317 & 3670016) | (KeyboardActions.$stable << 21) | (i317 & 29360128) | (i317 & 234881024) | (i317 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape9;
                textStyle4 = textStyle7;
                z16 = z22;
                i31 = i30;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961394975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge4 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i318 = (i23 >> 21) & 112;
                final boolean z116 = z11;
                final boolean z117 = z9;
                final VisualTransformation visualTransformation7 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                final boolean z118 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function114 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function115 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function26 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function27 = function11;
                final TextFieldColors textFieldColors6 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i319 = i5;
                final int i3110 = i23;
                final Shape shape10 = shape2;
                int i3111 = i23 << 12;
                Shape shape11 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle8 = textStyle3;
                boolean z23 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i318).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge4, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i318 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function28, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function28, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z24 = z116;
                            boolean z25 = z117;
                            VisualTransformation visualTransformation8 = visualTransformation7;
                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                            boolean z26 = z118;
                            Function2<Composer, Integer, Unit> function28 = function114;
                            Function2<Composer, Integer, Unit> function29 = function115;
                            Function2<Composer, Integer, Unit> function210 = function26;
                            Function2<Composer, Integer, Unit> function211 = function27;
                            TextFieldColors textFieldColors7 = textFieldColors6;
                            final boolean z27 = z116;
                            final boolean z28 = z118;
                            final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource8;
                            final TextFieldColors textFieldColors8 = textFieldColors6;
                            final Shape shape12 = shape10;
                            final int i42 = i319;
                            final int i43 = i3110;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z29 = z27;
                                        boolean z210 = z28;
                                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                                        TextFieldColors textFieldColors9 = textFieldColors8;
                                        Shape shape13 = shape12;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z29, z210, mutableInteractionSource11, textFieldColors9, shape13, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i319;
                            int i45 = i3110;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z24, z25, visualTransformation8, mutableInteractionSource9, z26, function28, function29, function210, function211, textFieldColors7, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3111 & 3670016) | (KeyboardActions.$stable << 21) | (i3111 & 29360128) | (i3111 & 234881024) | (i3111 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape11;
                textStyle4 = textStyle8;
                z16 = z23;
                i31 = i30;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                    i34 = 65536;
                } else {
                    i34 = 65536;
                }
                i5 |= i34;
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
                    i33 = 4194304;
                } else {
                    i33 = 4194304;
                }
                i23 |= i33;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i32 = 33554432;
                } else {
                    i32 = 33554432;
                }
                i23 |= i32;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961394975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge5 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i3112 = (i23 >> 21) & 112;
                final boolean z119 = z11;
                final boolean z1110 = z9;
                final VisualTransformation visualTransformation8 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                final boolean z1111 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function116 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function117 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function28 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function29 = function11;
                final TextFieldColors textFieldColors7 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i3113 = i5;
                final int i3114 = i23;
                final Shape shape12 = shape2;
                int i3115 = i23 << 12;
                Shape shape13 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle9 = textStyle3;
                boolean z24 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3112).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge5, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i3112 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function210, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function210, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z25 = z119;
                            boolean z26 = z1110;
                            VisualTransformation visualTransformation9 = visualTransformation8;
                            MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                            boolean z27 = z1111;
                            Function2<Composer, Integer, Unit> function210 = function116;
                            Function2<Composer, Integer, Unit> function211 = function117;
                            Function2<Composer, Integer, Unit> function212 = function28;
                            Function2<Composer, Integer, Unit> function213 = function29;
                            TextFieldColors textFieldColors8 = textFieldColors7;
                            final boolean z28 = z119;
                            final boolean z29 = z1111;
                            final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource9;
                            final TextFieldColors textFieldColors9 = textFieldColors7;
                            final Shape shape14 = shape12;
                            final int i42 = i3113;
                            final int i43 = i3114;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z210 = z28;
                                        boolean z211 = z29;
                                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource11;
                                        TextFieldColors textFieldColors10 = textFieldColors9;
                                        Shape shape15 = shape14;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z210, z211, mutableInteractionSource12, textFieldColors10, shape15, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i3113;
                            int i45 = i3114;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z25, z26, visualTransformation9, mutableInteractionSource10, z27, function210, function211, function212, function213, textFieldColors8, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3115 & 3670016) | (KeyboardActions.$stable << 21) | (i3115 & 29360128) | (i3115 & 234881024) | (i3115 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape13;
                textStyle4 = textStyle9;
                z16 = z24;
                i31 = i30;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i23 = (-29360129) & i23;
                    } else {
                        small = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = small;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961394975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge6 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i3116 = (i23 >> 21) & 112;
                final boolean z1112 = z11;
                final boolean z1113 = z9;
                final VisualTransformation visualTransformation9 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                final boolean z1114 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function118 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function119 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function210 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function211 = function11;
                final TextFieldColors textFieldColors8 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i3117 = i5;
                final int i3118 = i23;
                final Shape shape14 = shape2;
                int i3119 = i23 << 12;
                Shape shape15 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle10 = textStyle3;
                boolean z25 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3116).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge6, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i3116 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function212, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function212, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z26 = z1112;
                            boolean z27 = z1113;
                            VisualTransformation visualTransformation10 = visualTransformation9;
                            MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                            boolean z28 = z1114;
                            Function2<Composer, Integer, Unit> function212 = function118;
                            Function2<Composer, Integer, Unit> function213 = function119;
                            Function2<Composer, Integer, Unit> function214 = function210;
                            Function2<Composer, Integer, Unit> function215 = function211;
                            TextFieldColors textFieldColors9 = textFieldColors8;
                            final boolean z29 = z1112;
                            final boolean z210 = z1114;
                            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource10;
                            final TextFieldColors textFieldColors10 = textFieldColors8;
                            final Shape shape16 = shape14;
                            final int i42 = i3117;
                            final int i43 = i3118;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z211 = z29;
                                        boolean z212 = z210;
                                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource12;
                                        TextFieldColors textFieldColors11 = textFieldColors10;
                                        Shape shape17 = shape16;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z211, z212, mutableInteractionSource13, textFieldColors11, shape17, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i3117;
                            int i45 = i3118;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z26, z27, visualTransformation10, mutableInteractionSource11, z28, function212, function213, function214, function215, textFieldColors9, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3119 & 3670016) | (KeyboardActions.$stable << 21) | (i3119 & 29360128) | (i3119 & 234881024) | (i3119 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape15;
                textStyle4 = textStyle10;
                z16 = z25;
                i31 = i30;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                i34 = 65536;
            } else {
                i34 = 65536;
            }
            i5 |= i34;
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
                i33 = 4194304;
            } else {
                i33 = 4194304;
            }
            i23 |= i33;
        }
        if ((i3 & 234881024) != 0) {
            if ((i4 & 262144) == 0) {
                i32 = 33554432;
            } else {
                i32 = 33554432;
            }
            i23 |= i32;
        }
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i35 != 0) {
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
                i29 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i23 = (-29360129) & i23;
                } else {
                    small = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            } else {
                if (i35 != 0) {
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
                i29 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i23 = (-29360129) & i23;
                } else {
                    small = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1961394975);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyleMerge7 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            if (function13 != null) {
                modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
            } else {
                modifierM427paddingqDBjuR0$default = modifier2;
            }
            int i31110 = (i23 >> 21) & 112;
            final boolean z1115 = z11;
            final boolean z1116 = z9;
            final VisualTransformation visualTransformation10 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
            final boolean z1117 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function1110 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function1111 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function212 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function213 = function11;
            final TextFieldColors textFieldColors9 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            final int i31111 = i5;
            final int i31112 = i23;
            final Shape shape16 = shape2;
            int i31113 = i23 << 12;
            Shape shape17 = shape2;
            composer2 = composerStartRestartGroup;
            TextStyle textStyle11 = textStyle3;
            boolean z26 = z11;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31110).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge7, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i31110 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function214, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function214, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z27 = z1115;
                        boolean z28 = z1116;
                        VisualTransformation visualTransformation11 = visualTransformation10;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource11;
                        boolean z29 = z1117;
                        Function2<Composer, Integer, Unit> function214 = function1110;
                        Function2<Composer, Integer, Unit> function215 = function1111;
                        Function2<Composer, Integer, Unit> function216 = function212;
                        Function2<Composer, Integer, Unit> function217 = function213;
                        TextFieldColors textFieldColors10 = textFieldColors9;
                        final boolean z210 = z1115;
                        final boolean z211 = z1117;
                        final MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource11;
                        final TextFieldColors textFieldColors11 = textFieldColors9;
                        final Shape shape18 = shape16;
                        final int i42 = i31111;
                        final int i43 = i31112;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i44) {
                                ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    boolean z212 = z210;
                                    boolean z213 = z211;
                                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource13;
                                    TextFieldColors textFieldColors12 = textFieldColors11;
                                    Shape shape19 = shape18;
                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                    int i46 = i43;
                                    textFieldDefaults2.m1218BorderBoxnbWgWpA(z212, z213, mutableInteractionSource14, textFieldColors12, shape19, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                        int i44 = i31111;
                        int i45 = i31112;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z27, z28, visualTransformation11, mutableInteractionSource12, z29, function214, function215, function216, function217, textFieldColors10, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31113 & 3670016) | (KeyboardActions.$stable << 21) | (i31113 & 29360128) | (i31113 & 234881024) | (i31113 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            modifier3 = modifier2;
            z13 = z10;
            function14 = function13;
            function15 = function12;
            function16 = function10;
            function17 = function11;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            z14 = z9;
            mutableInteractionSource4 = mutableInteractionSource3;
            z15 = z12;
            textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            shape3 = shape17;
            textStyle4 = textStyle11;
            z16 = z26;
            i31 = i30;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i35 != 0) {
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
                i29 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i23 = (-29360129) & i23;
                } else {
                    small = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            } else {
                if (i35 != 0) {
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
                i29 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i23 = (-29360129) & i23;
                } else {
                    small = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = small;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1961394975);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*154@8448L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyleMerge8 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            if (function13 != null) {
                modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
            } else {
                modifierM427paddingqDBjuR0$default = modifier2;
            }
            int i31114 = (i23 >> 21) & 112;
            final boolean z1118 = z11;
            final boolean z1119 = z9;
            final VisualTransformation visualTransformation11 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
            final boolean z11110 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function1112 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function1113 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function214 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function11;
            final TextFieldColors textFieldColors10 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            final int i31115 = i5;
            final int i31116 = i23;
            final Shape shape18 = shape2;
            int i31117 = i23 << 12;
            Shape shape19 = shape2;
            composer2 = composerStartRestartGroup;
            TextStyle textStyle12 = textStyle3;
            boolean z27 = z11;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31114).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge8, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i31114 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function216, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function216, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C183@9550L834:OutlinedTextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z28 = z1118;
                        boolean z29 = z1119;
                        VisualTransformation visualTransformation12 = visualTransformation11;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource12;
                        boolean z210 = z11110;
                        Function2<Composer, Integer, Unit> function216 = function1112;
                        Function2<Composer, Integer, Unit> function217 = function1113;
                        Function2<Composer, Integer, Unit> function218 = function214;
                        Function2<Composer, Integer, Unit> function219 = function215;
                        TextFieldColors textFieldColors11 = textFieldColors10;
                        final boolean z211 = z1118;
                        final boolean z212 = z11110;
                        final MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource12;
                        final TextFieldColors textFieldColors12 = textFieldColors10;
                        final Shape shape110 = shape18;
                        final int i42 = i31115;
                        final int i43 = i31116;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i44) {
                                ComposerKt.sourceInformation(composer4, "C197@10149L203:OutlinedTextField.kt#jmzs0o");
                                if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    boolean z213 = z211;
                                    boolean z214 = z212;
                                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource14;
                                    TextFieldColors textFieldColors13 = textFieldColors12;
                                    Shape shape111 = shape110;
                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                    int i46 = i43;
                                    textFieldDefaults2.m1218BorderBoxnbWgWpA(z213, z214, mutableInteractionSource15, textFieldColors13, shape111, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                        int i44 = i31115;
                        int i45 = i31116;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z28, z29, visualTransformation12, mutableInteractionSource13, z210, function216, function217, function218, function219, textFieldColors11, null, composableLambda, composer3, (i44 & 14) | ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31117 & 3670016) | (KeyboardActions.$stable << 21) | (i31117 & 29360128) | (i31117 & 234881024) | (i31117 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            modifier3 = modifier2;
            z13 = z10;
            function14 = function13;
            function15 = function12;
            function16 = function10;
            function17 = function11;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            z14 = z9;
            mutableInteractionSource4 = mutableInteractionSource3;
            z15 = z12;
            textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            shape3 = shape19;
            textStyle4 = textStyle12;
            z16 = z27;
            i31 = i30;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
    /* JADX WARN: Code duplicated, block: B:228:0x02f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:229:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:230:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:232:0x0300  */
    /* JADX WARN: Code duplicated, block: B:233:0x0302  */
    /* JADX WARN: Code duplicated, block: B:235:0x0306  */
    /* JADX WARN: Code duplicated, block: B:236:0x0308  */
    /* JADX WARN: Code duplicated, block: B:239:0x030e  */
    /* JADX WARN: Code duplicated, block: B:240:0x0330  */
    /* JADX WARN: Code duplicated, block: B:242:0x0338  */
    /* JADX WARN: Code duplicated, block: B:243:0x033a  */
    /* JADX WARN: Code duplicated, block: B:245:0x033e  */
    /* JADX WARN: Code duplicated, block: B:246:0x0340  */
    /* JADX WARN: Code duplicated, block: B:248:0x0344  */
    /* JADX WARN: Code duplicated, block: B:249:0x0346  */
    /* JADX WARN: Code duplicated, block: B:251:0x034a  */
    /* JADX WARN: Code duplicated, block: B:252:0x034c  */
    /* JADX WARN: Code duplicated, block: B:254:0x0350  */
    /* JADX WARN: Code duplicated, block: B:255:0x0352  */
    /* JADX WARN: Code duplicated, block: B:257:0x0356  */
    /* JADX WARN: Code duplicated, block: B:258:0x035d  */
    /* JADX WARN: Code duplicated, block: B:261:0x0363  */
    /* JADX WARN: Code duplicated, block: B:262:0x036c  */
    /* JADX WARN: Code duplicated, block: B:265:0x0374  */
    /* JADX WARN: Code duplicated, block: B:266:0x039e  */
    /* JADX WARN: Code duplicated, block: B:268:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:269:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:271:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:272:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:275:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:277:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:279:0x03da  */
    /* JADX WARN: Code duplicated, block: B:282:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:283:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:286:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:287:0x0459  */
    /* JADX WARN: Code duplicated, block: B:291:0x0495  */
    /* JADX WARN: Code duplicated, block: B:294:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:295:0x0501  */
    /* JADX WARN: Code duplicated, block: B:300:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:302:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        int i29;
        KeyboardActions keyboardActions2;
        boolean z8;
        int i30;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource2;
        Shape outlinedTextFieldShape;
        Modifier modifier2;
        KeyboardActions keyboardActions4;
        Function2<? super Composer, ? super Integer, Unit> function10;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Composer, ? super Integer, Unit> function11;
        VisualTransformation visualTransformation2;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        boolean z9;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        boolean z11;
        Shape shape2;
        TextStyle textStyle3;
        boolean z12;
        TextFieldColors textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
        Object objRememberedValue;
        long jM3505getColor0d7_KjU;
        Modifier modifierM427paddingqDBjuR0$default;
        Composer composer2;
        final Modifier modifier3;
        final boolean z13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final Function2<? super Composer, ? super Integer, Unit> function17;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions5;
        final boolean z14;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z15;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final TextStyle textStyle4;
        final boolean z16;
        final int i31;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i32;
        int i33;
        int i34;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)281@15178L7,292@15732L39,293@15810L22,294@15882L25,310@16432L24,319@16798L20,303@16210L1806:OutlinedTextField.kt#jmzs0o");
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
        int i35 = i4 & 4;
        if (i35 == 0) {
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
                        i34 = 65536;
                    } else {
                        i34 = 131072;
                    }
                    i5 |= i34;
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
                        i33 = 4194304;
                    } else {
                        i33 = 8388608;
                    }
                    i23 |= i33;
                }
                if ((i3 & 234881024) != 0) {
                    if ((i4 & 262144) == 0 || !composerStartRestartGroup.changed(textFieldColors)) {
                        i32 = 33554432;
                    } else {
                        i32 = 67108864;
                    }
                    i23 |= i32;
                }
                if ((i5 & 1533916891) == 306783378 || (191739611 & i23) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
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
                        function13 = function2;
                        function12 = function3;
                        function10 = function4;
                        function11 = function5;
                        z12 = z3;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions3 = keyboardOptions;
                        keyboardActions4 = keyboardActions;
                        z9 = z4;
                        i30 = i;
                        mutableInteractionSource3 = mutableInteractionSource;
                        shape2 = shape;
                    } else {
                        if (i35 != 0) {
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
                        i29 = i5;
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
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
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
                            outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                            i23 = (-29360129) & i23;
                        } else {
                            outlinedTextFieldShape = shape;
                        }
                        if ((262144 & i4) != 0) {
                            i23 &= -234881025;
                            modifier2 = companion;
                            keyboardActions4 = keyboardActions3;
                            function10 = function8;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            function11 = function9;
                            visualTransformation2 = none;
                            function12 = function7;
                            function13 = function6;
                            z9 = z8;
                            keyboardOptions3 = keyboardOptions2;
                            z10 = z6;
                            z11 = z5;
                            shape2 = outlinedTextFieldShape;
                            textStyle3 = textStyle2;
                            z12 = z7;
                            i5 = i29;
                            textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        } else {
                            modifier2 = companion;
                            keyboardActions4 = keyboardActions3;
                            function10 = function8;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            function11 = function9;
                            visualTransformation2 = none;
                            function12 = function7;
                            function13 = function6;
                            z9 = z8;
                            keyboardOptions3 = keyboardOptions2;
                            z10 = z6;
                            z11 = z5;
                            shape2 = outlinedTextFieldShape;
                            textStyle3 = textStyle2;
                            z12 = z7;
                            i5 = i29;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1961402586);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                        jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyleMerge = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                        if (function13 != null) {
                            modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM427paddingqDBjuR0$default = modifier2;
                        }
                        int i36 = (i23 >> 21) & 112;
                        final boolean z17 = z11;
                        final boolean z18 = z9;
                        final VisualTransformation visualTransformation4 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        final boolean z19 = z12;
                        final Function2<? super Composer, ? super Integer, Unit> function18 = function13;
                        final Function2<? super Composer, ? super Integer, Unit> function19 = function12;
                        final Function2<? super Composer, ? super Integer, Unit> function20 = function10;
                        final Function2<? super Composer, ? super Integer, Unit> function21 = function11;
                        final TextFieldColors textFieldColors3 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                        final int i37 = i5;
                        final int i38 = i23;
                        final Shape shape4 = shape2;
                        int i39 = i23 << 12;
                        Shape shape5 = shape2;
                        composer2 = composerStartRestartGroup;
                        TextStyle textStyle5 = textStyle3;
                        boolean z20 = z11;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i36).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i36 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
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
                                ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                                if ((i40 & 14) == 0) {
                                    i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                                } else {
                                    i41 = i40;
                                }
                                if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    String text = value.getText();
                                    boolean z21 = z17;
                                    boolean z22 = z18;
                                    VisualTransformation visualTransformation5 = visualTransformation4;
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                    boolean z23 = z19;
                                    Function2<Composer, Integer, Unit> function22 = function18;
                                    Function2<Composer, Integer, Unit> function23 = function19;
                                    Function2<Composer, Integer, Unit> function24 = function20;
                                    Function2<Composer, Integer, Unit> function25 = function21;
                                    TextFieldColors textFieldColors4 = textFieldColors3;
                                    final boolean z24 = z17;
                                    final boolean z25 = z19;
                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                    final TextFieldColors textFieldColors5 = textFieldColors3;
                                    final Shape shape6 = shape4;
                                    final int i42 = i37;
                                    final int i43 = i38;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i44) {
                                            ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                            if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                                TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                                boolean z26 = z24;
                                                boolean z27 = z25;
                                                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                                                TextFieldColors textFieldColors6 = textFieldColors5;
                                                Shape shape7 = shape6;
                                                int i45 = ((i42 >> 9) & 14) | 12582912;
                                                int i46 = i43;
                                                textFieldDefaults2.m1218BorderBoxnbWgWpA(z26, z27, mutableInteractionSource8, textFieldColors6, shape7, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                    int i44 = i37;
                                    int i45 = i38;
                                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z21, z22, visualTransformation5, mutableInteractionSource6, z23, function22, function23, function24, function25, textFieldColors4, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i5 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                        modifier3 = modifier2;
                        z13 = z10;
                        function14 = function13;
                        function15 = function12;
                        function16 = function10;
                        function17 = function11;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions4 = keyboardOptions3;
                        keyboardActions5 = keyboardActions4;
                        z14 = z9;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z15 = z12;
                        textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                        shape3 = shape5;
                        textStyle4 = textStyle5;
                        z16 = z20;
                        i31 = i30;
                    }
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1961402586);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                    jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyleMerge2 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                    if (function13 != null) {
                        modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                    } else {
                        modifierM427paddingqDBjuR0$default = modifier2;
                    }
                    int i310 = (i23 >> 21) & 112;
                    final boolean z110 = z11;
                    final boolean z111 = z9;
                    final VisualTransformation visualTransformation5 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                    final boolean z112 = z12;
                    final Function2<? super Composer, ? super Integer, Unit> function110 = function13;
                    final Function2<? super Composer, ? super Integer, Unit> function111 = function12;
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function10;
                    final Function2<? super Composer, ? super Integer, Unit> function23 = function11;
                    final TextFieldColors textFieldColors4 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                    final int i311 = i5;
                    final int i312 = i23;
                    final Shape shape6 = shape2;
                    int i313 = i23 << 12;
                    Shape shape7 = shape2;
                    composer2 = composerStartRestartGroup;
                    TextStyle textStyle6 = textStyle3;
                    boolean z21 = z11;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i310).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge2, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i310 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
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
                            ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                            if ((i40 & 14) == 0) {
                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                            } else {
                                i41 = i40;
                            }
                            if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                String text = value.getText();
                                boolean z22 = z110;
                                boolean z23 = z111;
                                VisualTransformation visualTransformation6 = visualTransformation5;
                                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                boolean z24 = z112;
                                Function2<Composer, Integer, Unit> function24 = function110;
                                Function2<Composer, Integer, Unit> function25 = function111;
                                Function2<Composer, Integer, Unit> function26 = function22;
                                Function2<Composer, Integer, Unit> function27 = function23;
                                TextFieldColors textFieldColors5 = textFieldColors4;
                                final boolean z25 = z110;
                                final boolean z26 = z112;
                                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                final TextFieldColors textFieldColors6 = textFieldColors4;
                                final Shape shape8 = shape6;
                                final int i42 = i311;
                                final int i43 = i312;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i44) {
                                        ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                        if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            boolean z27 = z25;
                                            boolean z28 = z26;
                                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                                            TextFieldColors textFieldColors7 = textFieldColors6;
                                            Shape shape9 = shape8;
                                            int i45 = ((i42 >> 9) & 14) | 12582912;
                                            int i46 = i43;
                                            textFieldDefaults2.m1218BorderBoxnbWgWpA(z27, z28, mutableInteractionSource9, textFieldColors7, shape9, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                                int i44 = i311;
                                int i45 = i312;
                                textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z22, z23, visualTransformation6, mutableInteractionSource7, z24, function24, function25, function26, function27, textFieldColors5, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i5 & 64638) | (i313 & 3670016) | (KeyboardActions.$stable << 21) | (i313 & 29360128) | (i313 & 234881024) | (i313 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                    modifier3 = modifier2;
                    z13 = z10;
                    function14 = function13;
                    function15 = function12;
                    function16 = function10;
                    function17 = function11;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions5 = keyboardActions4;
                    z14 = z9;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z15 = z12;
                    textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                    shape3 = shape7;
                    textStyle4 = textStyle6;
                    z16 = z21;
                    i31 = i30;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z16 = z;
                    z13 = z2;
                    textStyle4 = textStyle;
                    function15 = function3;
                    function16 = function4;
                    function17 = function5;
                    z15 = z3;
                    visualTransformation3 = visualTransformation;
                    keyboardOptions4 = keyboardOptions;
                    keyboardActions5 = keyboardActions;
                    z14 = z4;
                    i31 = i;
                    mutableInteractionSource4 = mutableInteractionSource;
                    shape3 = shape;
                    textFieldColors2 = textFieldColors;
                    composer2 = composerStartRestartGroup;
                    function14 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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
                        OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                    i34 = 65536;
                } else {
                    i34 = 65536;
                }
                i5 |= i34;
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
                    i33 = 4194304;
                } else {
                    i33 = 4194304;
                }
                i23 |= i33;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i32 = 33554432;
                } else {
                    i32 = 33554432;
                }
                i23 |= i32;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961402586);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge3 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i314 = (i23 >> 21) & 112;
                final boolean z113 = z11;
                final boolean z114 = z9;
                final VisualTransformation visualTransformation6 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                final boolean z115 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function112 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function113 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function25 = function11;
                final TextFieldColors textFieldColors5 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i315 = i5;
                final int i316 = i23;
                final Shape shape8 = shape2;
                int i317 = i23 << 12;
                Shape shape9 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle7 = textStyle3;
                boolean z22 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i314).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge3, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i314 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
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
                        ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z23 = z113;
                            boolean z24 = z114;
                            VisualTransformation visualTransformation7 = visualTransformation6;
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                            boolean z25 = z115;
                            Function2<Composer, Integer, Unit> function26 = function112;
                            Function2<Composer, Integer, Unit> function27 = function113;
                            Function2<Composer, Integer, Unit> function28 = function24;
                            Function2<Composer, Integer, Unit> function29 = function25;
                            TextFieldColors textFieldColors6 = textFieldColors5;
                            final boolean z26 = z113;
                            final boolean z27 = z115;
                            final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource7;
                            final TextFieldColors textFieldColors7 = textFieldColors5;
                            final Shape shape10 = shape8;
                            final int i42 = i315;
                            final int i43 = i316;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z28 = z26;
                                        boolean z29 = z27;
                                        MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                                        TextFieldColors textFieldColors8 = textFieldColors7;
                                        Shape shape11 = shape10;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z28, z29, mutableInteractionSource10, textFieldColors8, shape11, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i315;
                            int i45 = i316;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z23, z24, visualTransformation7, mutableInteractionSource8, z25, function26, function27, function28, function29, textFieldColors6, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i317 & 3670016) | (KeyboardActions.$stable << 21) | (i317 & 29360128) | (i317 & 234881024) | (i317 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape9;
                textStyle4 = textStyle7;
                z16 = z22;
                i31 = i30;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961402586);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge4 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i318 = (i23 >> 21) & 112;
                final boolean z116 = z11;
                final boolean z117 = z9;
                final VisualTransformation visualTransformation7 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                final boolean z118 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function114 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function115 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function26 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function27 = function11;
                final TextFieldColors textFieldColors6 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i319 = i5;
                final int i3110 = i23;
                final Shape shape10 = shape2;
                int i3111 = i23 << 12;
                Shape shape11 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle8 = textStyle3;
                boolean z23 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i318).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge4, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i318 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function28, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function28, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z24 = z116;
                            boolean z25 = z117;
                            VisualTransformation visualTransformation8 = visualTransformation7;
                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                            boolean z26 = z118;
                            Function2<Composer, Integer, Unit> function28 = function114;
                            Function2<Composer, Integer, Unit> function29 = function115;
                            Function2<Composer, Integer, Unit> function210 = function26;
                            Function2<Composer, Integer, Unit> function211 = function27;
                            TextFieldColors textFieldColors7 = textFieldColors6;
                            final boolean z27 = z116;
                            final boolean z28 = z118;
                            final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource8;
                            final TextFieldColors textFieldColors8 = textFieldColors6;
                            final Shape shape12 = shape10;
                            final int i42 = i319;
                            final int i43 = i3110;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z29 = z27;
                                        boolean z210 = z28;
                                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                                        TextFieldColors textFieldColors9 = textFieldColors8;
                                        Shape shape13 = shape12;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z29, z210, mutableInteractionSource11, textFieldColors9, shape13, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i319;
                            int i45 = i3110;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z24, z25, visualTransformation8, mutableInteractionSource9, z26, function28, function29, function210, function211, textFieldColors7, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3111 & 3670016) | (KeyboardActions.$stable << 21) | (i3111 & 29360128) | (i3111 & 234881024) | (i3111 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape11;
                textStyle4 = textStyle8;
                z16 = z23;
                i31 = i30;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                    i34 = 65536;
                } else {
                    i34 = 65536;
                }
                i5 |= i34;
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
                    i33 = 4194304;
                } else {
                    i33 = 4194304;
                }
                i23 |= i33;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i32 = 33554432;
                } else {
                    i32 = 33554432;
                }
                i23 |= i32;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961402586);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge5 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i3112 = (i23 >> 21) & 112;
                final boolean z119 = z11;
                final boolean z1110 = z9;
                final VisualTransformation visualTransformation8 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                final boolean z1111 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function116 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function117 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function28 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function29 = function11;
                final TextFieldColors textFieldColors7 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i3113 = i5;
                final int i3114 = i23;
                final Shape shape12 = shape2;
                int i3115 = i23 << 12;
                Shape shape13 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle9 = textStyle3;
                boolean z24 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3112).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge5, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i3112 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function210, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function210, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z25 = z119;
                            boolean z26 = z1110;
                            VisualTransformation visualTransformation9 = visualTransformation8;
                            MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                            boolean z27 = z1111;
                            Function2<Composer, Integer, Unit> function210 = function116;
                            Function2<Composer, Integer, Unit> function211 = function117;
                            Function2<Composer, Integer, Unit> function212 = function28;
                            Function2<Composer, Integer, Unit> function213 = function29;
                            TextFieldColors textFieldColors8 = textFieldColors7;
                            final boolean z28 = z119;
                            final boolean z29 = z1111;
                            final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource9;
                            final TextFieldColors textFieldColors9 = textFieldColors7;
                            final Shape shape14 = shape12;
                            final int i42 = i3113;
                            final int i43 = i3114;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z210 = z28;
                                        boolean z211 = z29;
                                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource11;
                                        TextFieldColors textFieldColors10 = textFieldColors9;
                                        Shape shape15 = shape14;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z210, z211, mutableInteractionSource12, textFieldColors10, shape15, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i3113;
                            int i45 = i3114;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z25, z26, visualTransformation9, mutableInteractionSource10, z27, function210, function211, function212, function213, textFieldColors8, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3115 & 3670016) | (KeyboardActions.$stable << 21) | (i3115 & 29360128) | (i3115 & 234881024) | (i3115 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape13;
                textStyle4 = textStyle9;
                z16 = z24;
                i31 = i30;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) == 0) {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                } else {
                    if (i35 != 0) {
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
                    i29 = i5;
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
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
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
                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        outlinedTextFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        i23 &= -234881025;
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    } else {
                        modifier2 = companion;
                        keyboardActions4 = keyboardActions3;
                        function10 = function8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function11 = function9;
                        visualTransformation2 = none;
                        function12 = function7;
                        function13 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        z11 = z5;
                        shape2 = outlinedTextFieldShape;
                        textStyle3 = textStyle2;
                        z12 = z7;
                        i5 = i29;
                        textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1961402586);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyleMerge6 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
                if (function13 != null) {
                    modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                } else {
                    modifierM427paddingqDBjuR0$default = modifier2;
                }
                int i3116 = (i23 >> 21) & 112;
                final boolean z1112 = z11;
                final boolean z1113 = z9;
                final VisualTransformation visualTransformation9 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                final boolean z1114 = z12;
                final Function2<? super Composer, ? super Integer, Unit> function118 = function13;
                final Function2<? super Composer, ? super Integer, Unit> function119 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function210 = function10;
                final Function2<? super Composer, ? super Integer, Unit> function211 = function11;
                final TextFieldColors textFieldColors8 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                final int i3117 = i5;
                final int i3118 = i23;
                final Shape shape14 = shape2;
                int i3119 = i23 << 12;
                Shape shape15 = shape2;
                composer2 = composerStartRestartGroup;
                TextStyle textStyle10 = textStyle3;
                boolean z25 = z11;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3116).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge6, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i3116 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function212, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function212, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z26 = z1112;
                            boolean z27 = z1113;
                            VisualTransformation visualTransformation10 = visualTransformation9;
                            MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                            boolean z28 = z1114;
                            Function2<Composer, Integer, Unit> function212 = function118;
                            Function2<Composer, Integer, Unit> function213 = function119;
                            Function2<Composer, Integer, Unit> function214 = function210;
                            Function2<Composer, Integer, Unit> function215 = function211;
                            TextFieldColors textFieldColors9 = textFieldColors8;
                            final boolean z29 = z1112;
                            final boolean z210 = z1114;
                            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource10;
                            final TextFieldColors textFieldColors10 = textFieldColors8;
                            final Shape shape16 = shape14;
                            final int i42 = i3117;
                            final int i43 = i3118;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i44) {
                                    ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                        TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                        boolean z211 = z29;
                                        boolean z212 = z210;
                                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource12;
                                        TextFieldColors textFieldColors11 = textFieldColors10;
                                        Shape shape17 = shape16;
                                        int i45 = ((i42 >> 9) & 14) | 12582912;
                                        int i46 = i43;
                                        textFieldDefaults2.m1218BorderBoxnbWgWpA(z211, z212, mutableInteractionSource13, textFieldColors11, shape17, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            int i44 = i3117;
                            int i45 = i3118;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z26, z27, visualTransformation10, mutableInteractionSource11, z28, function212, function213, function214, function215, textFieldColors9, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3119 & 3670016) | (KeyboardActions.$stable << 21) | (i3119 & 29360128) | (i3119 & 234881024) | (i3119 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                modifier3 = modifier2;
                z13 = z10;
                function14 = function13;
                function15 = function12;
                function16 = function10;
                function17 = function11;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions5 = keyboardActions4;
                z14 = z9;
                mutableInteractionSource4 = mutableInteractionSource3;
                z15 = z12;
                textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
                shape3 = shape15;
                textStyle4 = textStyle10;
                z16 = z25;
                i31 = i30;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
                i34 = 65536;
            } else {
                i34 = 65536;
            }
            i5 |= i34;
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
                i33 = 4194304;
            } else {
                i33 = 4194304;
            }
            i23 |= i33;
        }
        if ((i3 & 234881024) != 0) {
            if ((i4 & 262144) == 0) {
                i32 = 33554432;
            } else {
                i32 = 33554432;
            }
            i23 |= i32;
        }
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i35 != 0) {
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
                i29 = i5;
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    outlinedTextFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            } else {
                if (i35 != 0) {
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
                i29 = i5;
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    outlinedTextFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1961402586);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyleMerge7 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            if (function13 != null) {
                modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
            } else {
                modifierM427paddingqDBjuR0$default = modifier2;
            }
            int i31110 = (i23 >> 21) & 112;
            final boolean z1115 = z11;
            final boolean z1116 = z9;
            final VisualTransformation visualTransformation10 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
            final boolean z1117 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function1110 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function1111 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function212 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function213 = function11;
            final TextFieldColors textFieldColors9 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            final int i31111 = i5;
            final int i31112 = i23;
            final Shape shape16 = shape2;
            int i31113 = i23 << 12;
            Shape shape17 = shape2;
            composer2 = composerStartRestartGroup;
            TextStyle textStyle11 = textStyle3;
            boolean z26 = z11;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31110).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge7, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i31110 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function214, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function214, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        boolean z27 = z1115;
                        boolean z28 = z1116;
                        VisualTransformation visualTransformation11 = visualTransformation10;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource11;
                        boolean z29 = z1117;
                        Function2<Composer, Integer, Unit> function214 = function1110;
                        Function2<Composer, Integer, Unit> function215 = function1111;
                        Function2<Composer, Integer, Unit> function216 = function212;
                        Function2<Composer, Integer, Unit> function217 = function213;
                        TextFieldColors textFieldColors10 = textFieldColors9;
                        final boolean z210 = z1115;
                        final boolean z211 = z1117;
                        final MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource11;
                        final TextFieldColors textFieldColors11 = textFieldColors9;
                        final Shape shape18 = shape16;
                        final int i42 = i31111;
                        final int i43 = i31112;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i44) {
                                ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    boolean z212 = z210;
                                    boolean z213 = z211;
                                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource13;
                                    TextFieldColors textFieldColors12 = textFieldColors11;
                                    Shape shape19 = shape18;
                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                    int i46 = i43;
                                    textFieldDefaults2.m1218BorderBoxnbWgWpA(z212, z213, mutableInteractionSource14, textFieldColors12, shape19, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                        int i44 = i31111;
                        int i45 = i31112;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z27, z28, visualTransformation11, mutableInteractionSource12, z29, function214, function215, function216, function217, textFieldColors10, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31113 & 3670016) | (KeyboardActions.$stable << 21) | (i31113 & 29360128) | (i31113 & 234881024) | (i31113 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            modifier3 = modifier2;
            z13 = z10;
            function14 = function13;
            function15 = function12;
            function16 = function10;
            function17 = function11;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            z14 = z9;
            mutableInteractionSource4 = mutableInteractionSource3;
            z15 = z12;
            textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            shape3 = shape17;
            textStyle4 = textStyle11;
            z16 = z26;
            i31 = i30;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
                if (i35 != 0) {
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
                i29 = i5;
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    outlinedTextFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            } else {
                if (i35 != 0) {
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
                i29 = i5;
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
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
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
                    outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    outlinedTextFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    i23 &= -234881025;
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1224outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                } else {
                    modifier2 = companion;
                    keyboardActions4 = keyboardActions3;
                    function10 = function8;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function11 = function9;
                    visualTransformation2 = none;
                    function12 = function7;
                    function13 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    z11 = z5;
                    shape2 = outlinedTextFieldShape;
                    textStyle3 = textStyle2;
                    z12 = z7;
                    i5 = i29;
                    textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1961402586);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*298@16059L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyleMerge8 = textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            if (function13 != null) {
                modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifier2, 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
            } else {
                modifierM427paddingqDBjuR0$default = modifier2;
            }
            int i31114 = (i23 >> 21) & 112;
            final boolean z1118 = z11;
            final boolean z1119 = z9;
            final VisualTransformation visualTransformation11 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
            final boolean z11110 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function1112 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function1113 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function214 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function11;
            final TextFieldColors textFieldColors10 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            final int i31115 = i5;
            final int i31116 = i23;
            final Shape shape18 = shape2;
            int i31117 = i23 << 12;
            Shape shape19 = shape2;
            composer2 = composerStartRestartGroup;
            TextStyle textStyle12 = textStyle3;
            boolean z27 = z11;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(BackgroundKt.m175backgroundbw27NRU(modifierM427paddingqDBjuR0$default, textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31114).getValue().m1641unboximpl(), shape2), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyleMerge8, keyboardOptions3, keyboardActions4, z9, i30, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs.cursorColor(z12, composerStartRestartGroup, i31114 | (i23 & 14)).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function216, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function216, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        boolean z28 = z1118;
                        boolean z29 = z1119;
                        VisualTransformation visualTransformation12 = visualTransformation11;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource12;
                        boolean z210 = z11110;
                        Function2<Composer, Integer, Unit> function216 = function1112;
                        Function2<Composer, Integer, Unit> function217 = function1113;
                        Function2<Composer, Integer, Unit> function218 = function214;
                        Function2<Composer, Integer, Unit> function219 = function215;
                        TextFieldColors textFieldColors11 = textFieldColors10;
                        final boolean z211 = z1118;
                        final boolean z212 = z11110;
                        final MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource12;
                        final TextFieldColors textFieldColors12 = textFieldColors10;
                        final Shape shape110 = shape18;
                        final int i42 = i31115;
                        final int i43 = i31116;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i44) {
                                ComposerKt.sourceInformation(composer4, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                                if ((i44 & 11) != 2 || !composer4.getSkipping()) {
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    boolean z213 = z211;
                                    boolean z214 = z212;
                                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource14;
                                    TextFieldColors textFieldColors13 = textFieldColors12;
                                    Shape shape111 = shape110;
                                    int i45 = ((i42 >> 9) & 14) | 12582912;
                                    int i46 = i43;
                                    textFieldDefaults2.m1218BorderBoxnbWgWpA(z213, z214, mutableInteractionSource15, textFieldColors13, shape111, 0.0f, 0.0f, composer4, i45 | ((i46 << 3) & 112) | ((i46 >> 12) & 896) | ((i46 >> 15) & 7168) | ((i46 >> 9) & 57344), 96);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                        int i44 = i31115;
                        int i45 = i31116;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z28, z29, visualTransformation12, mutableInteractionSource13, z210, function216, function217, function218, function219, textFieldColors11, null, composableLambda, composer3, ((i41 << 3) & 112) | ((i44 >> 3) & 896) | ((i45 >> 3) & 7168) | ((i45 << 9) & 57344) | ((i45 >> 3) & 458752) | ((i45 << 18) & 3670016) | ((i44 << 3) & 29360128) | ((i44 << 3) & 234881024) | ((i44 << 3) & 1879048192), ((i44 >> 27) & 14) | 27648 | ((i45 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31117 & 3670016) | (KeyboardActions.$stable << 21) | (i31117 & 29360128) | (i31117 & 234881024) | (i31117 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            modifier3 = modifier2;
            z13 = z10;
            function14 = function13;
            function15 = function12;
            function16 = function10;
            function17 = function11;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            z14 = z9;
            mutableInteractionSource4 = mutableInteractionSource3;
            z15 = z12;
            textFieldColors2 = textFieldColorsM1224outlinedTextFieldColorsdx8h9Zs;
            shape3 = shape19;
            textStyle4 = textStyle12;
            z16 = z27;
            i31 = i30;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier3, z16, z13, textStyle4, function14, function15, function16, function17, z15, visualTransformation3, keyboardOptions4, keyboardActions5, z14, i31, mutableInteractionSource4, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
            }
        });
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean z, final float f, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> border, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)374@18737L239,382@19024L7,383@19036L2308:OutlinedTextField.kt#jmzs0o");
        int i4 = (i & 14) == 0 ? (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(function4) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(function5) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(onLabelMeasured) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(border) ? 536870912 : 268435456;
        }
        int i5 = (i2 & 14) == 0 ? i2 | (composerStartRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i4 & 1533916891) != 306783378 || (i5 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            int i6 = 0;
            boolean zChanged = false;
            for (int i7 = 4; i6 < i7; i7 = 4) {
                zChanged |= composerStartRestartGroup.changed(objArr[i6]);
                i6++;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
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
            Updater.m1293setimpl(composerM1286constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(118153609);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C391@19540L8,430@20988L182,438@21221L54:OutlinedTextField.kt#jmzs0o");
            border.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 27) & 14));
            composerStartRestartGroup.startReplaceableGroup(1169914108);
            ComposerKt.sourceInformation(composerStartRestartGroup, "394@19601L219");
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
                composerStartRestartGroup.startReplaceableGroup(1691709354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C398@19793L9:OutlinedTextField.kt#jmzs0o");
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1169914393);
            ComposerKt.sourceInformation(composerStartRestartGroup, "402@19887L221");
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
                composerStartRestartGroup.startReplaceableGroup(-1351586719);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C406@20080L10:OutlinedTextField.kt#jmzs0o");
                function5.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
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
            composerStartRestartGroup.startReplaceableGroup(1169915404);
            ComposerKt.sourceInformation(composerStartRestartGroup, "427@20901L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PlaceholderId).then(modifierM427paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(modifierM427paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
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
            composerStartRestartGroup.startReplaceableGroup(-1205597937);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C434@21145L11:OutlinedTextField.kt#jmzs0o");
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (function2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LabelId);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
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
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierLayoutId);
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
                composerStartRestartGroup.startReplaceableGroup(-55131805);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C438@21266L7:OutlinedTextField.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, textField, function3, function2, function4, function5, z, f, onLabelMeasured, border, paddingValues, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1113calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m3801getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-zUg2_y0, reason: not valid java name */
    public static final int m1112calculateHeightzUg2_y0(int i, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        return Math.max(Constraints.m3800getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(Math.max(i3, i5) + (paddingValues.getBottom() * f) + Math.max(paddingValues.getTop() * f, i4 / 2.0f)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            float f3 = 1 - f;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : f3 * (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding)) + iRoundToInt2, MathKt.roundToInt(((z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i) : iRoundToInt) * f3) - ((placeable4.getHeight() / 2) * f)), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i) : iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), iRoundToInt, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m3166place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m3971getZeronOccac(), 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1114outlineCutout12SF9DM(Modifier outlineCutout, final long j, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* JADX INFO: compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float fCoerceAtLeast;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float fM1464getWidthimpl = Size.m1464getWidthimpl(j);
                if (fM1464getWidthimpl > 0.0f) {
                    float f = drawWithContent.mo318toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float f2 = drawWithContent.mo318toPx0680j_4(paddingValues.mo404calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - f;
                    float f3 = 2;
                    float fM1464getWidthimpl2 = fM1464getWidthimpl + f2 + (f * f3);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        fCoerceAtLeast = Size.m1464getWidthimpl(drawWithContent.mo2125getSizeNHjbRc()) - fM1464getWidthimpl2;
                    } else {
                        fCoerceAtLeast = RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f4 = fCoerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        fM1464getWidthimpl2 = Size.m1464getWidthimpl(drawWithContent.mo2125getSizeNHjbRc()) - RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f5 = fM1464getWidthimpl2;
                    float fM1461getHeightimpl = Size.m1461getHeightimpl(j);
                    float f6 = (-fM1461getHeightimpl) / f3;
                    float f7 = fM1461getHeightimpl / f3;
                    int iM1619getDifferencertfAjoo = ClipOp.INSTANCE.m1619getDifferencertfAjoo();
                    DrawContext drawContext = drawWithContent.getDrawContext();
                    long jMo2050getSizeNHjbRc = drawContext.mo2050getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo2053clipRectN_I0leg(f4, f6, f5, f7, iM1619getDifferencertfAjoo);
                    drawWithContent.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo2051setSizeuvyYCjk(jMo2050getSizeNHjbRc);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
