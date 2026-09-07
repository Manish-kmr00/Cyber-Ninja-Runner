package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m3843constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m3843constructorimpl(12);

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> innerTextField, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        InputPhase inputPhase;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)80@3167L105,84@3322L25,101@3932L10,*113@4554L10,114@4648L22,108@4267L5060:TextFieldImpl.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(type) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(innerTextField) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        int i6 = i3 & 32;
        if (i6 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(function3) ? 131072 : 65536;
        }
        int i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(function4) ? 1048576 : 524288;
        }
        int i8 = i3 & 128;
        if (i8 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(function5) ? 8388608 : 4194304;
        }
        int i9 = i3 & 256;
        if (i9 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= C.ENCODING_PCM_32BIT;
        } else if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        final int i11 = i4;
        int i12 = i3 & 1024;
        if (i12 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i3 & 2048) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int i13 = i5;
        if ((i3 & 4096) != 0) {
            i13 |= 384;
        } else if ((i2 & 896) == 0) {
            i13 |= composerStartRestartGroup.changed(contentPadding) ? 256 : 128;
        }
        if ((i3 & 8192) != 0) {
            i13 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i13 |= composerStartRestartGroup.changed(colors) ? 2048 : 1024;
        }
        int i14 = i3 & 16384;
        if (i14 != 0) {
            i13 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i13 |= composerStartRestartGroup.changed(function6) ? 16384 : 8192;
        }
        if ((i11 & 1533916891) != 306783378 || (46811 & i13) != 9362 || !composerStartRestartGroup.getSkipping()) {
            Function2<? super Composer, ? super Integer, Unit> function11 = i6 != 0 ? null : function3;
            Function2<? super Composer, ? super Integer, Unit> function12 = i7 != 0 ? null : function4;
            Function2<? super Composer, ? super Integer, Unit> function13 = i8 != 0 ? null : function5;
            boolean z7 = i9 != 0 ? false : z;
            boolean z8 = i10 != 0 ? true : z2;
            boolean z9 = i12 != 0 ? false : z3;
            Function2<? super Composer, ? super Integer, Unit> function14 = i14 != 0 ? null : function6;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(visualTransformation);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final String text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i13 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            final boolean z10 = z8;
            final boolean z11 = z9;
            final int i15 = i13;
            Function3<InputPhase, Composer, Integer, Color> function15 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase3, Composer composer3, Integer num) {
                    return Color.m1621boximpl(m1235invokeXeAY9LY(inputPhase3, composer3, num.intValue()));
                }

                /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m1235invokeXeAY9LY(InputPhase it, Composer composer3, int i16) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    composer3.startReplaceableGroup(697243846);
                    ComposerKt.sourceInformation(composer3, "C92@3610L273:TextFieldImpl.kt#jmzs0o");
                    TextFieldColors textFieldColors = colors;
                    boolean z12 = z10;
                    boolean z13 = it == InputPhase.UnfocusedEmpty ? false : z11;
                    InteractionSource interactionSource2 = interactionSource;
                    int i17 = (i11 >> 27) & 14;
                    int i18 = i15;
                    long jM1641unboximpl = textFieldColors.labelColor(z12, z13, interactionSource2, composer3, i17 | ((i18 << 3) & 896) | (i18 & 7168)).getValue().m1641unboximpl();
                    composer3.endReplaceableGroup();
                    return jM1641unboximpl;
                }
            };
            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            boolean z12 = (Color.m1632equalsimpl0(subtitle1.m3505getColor0d7_KjU(), Color.INSTANCE.m1667getUnspecified0d7_KjU()) && !Color.m1632equalsimpl0(caption.m3505getColor0d7_KjU(), Color.INSTANCE.m1667getUnspecified0d7_KjU())) || (!Color.m1632equalsimpl0(subtitle1.m3505getColor0d7_KjU(), Color.INSTANCE.m1667getUnspecified0d7_KjU()) && Color.m1632equalsimpl0(caption.m3505getColor0d7_KjU(), Color.INSTANCE.m1667getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(2129141006);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*110@4363L10,111@4455L22");
            long jM3505getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getCaption().m3505getColor0d7_KjU();
            if (z12 && jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = function15.invoke(inputPhase2, composerStartRestartGroup, 0).m1641unboximpl();
            }
            long j = jM3505getColor0d7_KjU;
            composerStartRestartGroup.endReplaceableGroup();
            long jM3505getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1().m3505getColor0d7_KjU();
            if (z12 && jM3505getColor0d7_KjU2 == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU2 = function15.invoke(inputPhase2, composerStartRestartGroup, 0).m1641unboximpl();
            }
            final Function2<? super Composer, ? super Integer, Unit> function16 = function11;
            final boolean z13 = z9;
            final int i16 = i13;
            final boolean z14 = z8;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function13;
            final boolean z15 = z7;
            final boolean z16 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function14;
            composer2 = composerStartRestartGroup;
            textFieldTransitionScope.m1244TransitionDTcfvLk(inputPhase2, j, jM3505getColor0d7_KjU2, function15, function2 != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.3

                /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
                /* JADX INFO: compiled from: TextFieldImpl.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        iArr[TextFieldType.Filled.ordinal()] = 1;
                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                    m1233invokeRIQooxk(f.floatValue(), color.m1641unboximpl(), color2.m1641unboximpl(), f2.floatValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.runtime.Composer] */
                /* JADX WARN: Type inference failed for: r5v14, types: [kotlin.jvm.functions.Function2] */
                /* JADX WARN: Type inference failed for: r5v23, types: [kotlin.jvm.functions.Function2] */
                /* JADX WARN: Type inference failed for: r6v5 */
                /* JADX WARN: Type inference failed for: r6v6, types: [kotlin.jvm.functions.Function2] */
                /* JADX WARN: Type inference failed for: r6v7 */
                /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                public final void m1233invokeRIQooxk(final float f, final long j2, final long j3, final float f2, Composer composer3, int i17) {
                    int i18;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    SnapshotMutationPolicy snapshotMutationPolicy;
                    final long jM1641unboximpl;
                    final long jM1641unboximpl2;
                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)149@6201L30,150@6287L43:TextFieldImpl.kt#jmzs0o");
                    if ((i17 & 14) == 0) {
                        i18 = (composer3.changed(f) ? 4 : 2) | i17;
                    } else {
                        i18 = i17;
                    }
                    if ((i17 & 112) == 0) {
                        i18 |= composer3.changed(j2) ? 32 : 16;
                    }
                    if ((i17 & 896) == 0) {
                        i18 |= composer3.changed(j3) ? 256 : 128;
                    }
                    if ((i17 & 7168) == 0) {
                        i18 |= composer3.changed(f2) ? 2048 : 1024;
                    }
                    final int i19 = i18;
                    if ((46811 & i19) != 9362 || !composer3.getSkipping()) {
                        final Function2<Composer, Integer, Unit> function20 = function2;
                        if (function20 != null) {
                            final boolean z17 = z16;
                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                public final void invoke(Composer composer4, int i20) {
                                    TextStyle textStyleM3500copyHL5avdY;
                                    ComposerKt.sourceInformation(composer4, "C*123@5027L10,124@5083L10,129@5294L55:TextFieldImpl.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle textStyleLerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f);
                                        boolean z18 = z17;
                                        long j4 = j2;
                                        if (z18) {
                                            textStyleM3500copyHL5avdY = textStyleLerp.m3500copyHL5avdY((262111 & 1) != 0 ? textStyleLerp.spanStyle.m3462getColor0d7_KjU() : j4, (262111 & 2) != 0 ? textStyleLerp.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? textStyleLerp.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? textStyleLerp.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? textStyleLerp.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? textStyleLerp.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? textStyleLerp.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? textStyleLerp.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? textStyleLerp.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? textStyleLerp.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? textStyleLerp.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? textStyleLerp.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? textStyleLerp.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? textStyleLerp.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? textStyleLerp.paragraphStyle.getTextAlign() : null, (262111 & 32768) != 0 ? textStyleLerp.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? textStyleLerp.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? textStyleLerp.paragraphStyle.getTextIndent() : null);
                                        } else {
                                            textStyleM3500copyHL5avdY = textStyleLerp;
                                        }
                                        TextFieldImplKt.m1232DecorationeuL9pac(j3, textStyleM3500copyHL5avdY, null, function20, composer4, ((i19 >> 6) & 14) | 384, 0);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        if (function16 == null || text.length() != 0) {
                            composableLambda2 = null;
                        } else {
                            final TextFieldColors textFieldColors = colors;
                            final boolean z18 = z14;
                            final int i20 = i11;
                            final int i21 = i16;
                            final Function2<Composer, Integer, Unit> function21 = function16;
                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                    invoke(modifier, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                                    ComposerKt.sourceInformation(composer4, "C136@5575L341:TextFieldImpl.kt#jmzs0o");
                                    if ((i22 & 14) == 0) {
                                        i22 |= composer4.changed(modifier) ? 4 : 2;
                                    }
                                    if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                        Modifier modifierAlpha = AlphaKt.alpha(modifier, f2);
                                        TextFieldColors textFieldColors2 = textFieldColors;
                                        boolean z19 = z18;
                                        int i23 = i20;
                                        int i24 = i21;
                                        Function2<Composer, Integer, Unit> function22 = function21;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer4.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer4.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer4.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlpha);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        composer4.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer4);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer4.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        composer4.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation(composer4, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer4.startReplaceableGroup(1188063364);
                                        ComposerKt.sourceInformation(composer4, "C138@5709L25,139@5797L10,137@5647L247:TextFieldImpl.kt#jmzs0o");
                                        TextFieldImplKt.m1232DecorationeuL9pac(textFieldColors2.placeholderColor(z19, composer4, ((i23 >> 27) & 14) | ((i24 >> 6) & 112)).getValue().m1641unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function22, composer4, (i23 >> 6) & 7168, 4);
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                        }
                        final String strM1173getString4foXLRw = Strings_androidKt.m1173getString4foXLRw(Strings.INSTANCE.m1168getDefaultErrorMessageUdPEhr4(), composer3, 6);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Boolean boolValueOf = Boolean.valueOf(z13);
                        final boolean z19 = z13;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged2 = composer3.changed(boolValueOf) | composer3.changed(strM1173getString4foXLRw);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    if (z19) {
                                        SemanticsPropertiesKt.error(semantics, strM1173getString4foXLRw);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue2, 1, null);
                        if (colors instanceof TextFieldColorsWithIcons) {
                            composer3.startReplaceableGroup(-1083197894);
                            ComposerKt.sourceInformation(composer3, "153@6424L53");
                            TextFieldColorsWithIcons textFieldColorsWithIcons = (TextFieldColorsWithIcons) colors;
                            boolean z20 = z14;
                            boolean z21 = z13;
                            InteractionSource interactionSource2 = interactionSource;
                            int i22 = (i11 >> 27) & 14;
                            int i23 = i16;
                            snapshotMutationPolicy = null;
                            jM1641unboximpl = textFieldColorsWithIcons.leadingIconColor(z20, z21, interactionSource2, composer3, ((i23 << 3) & 896) | i22 | ((i23 << 3) & 112)).getValue().m1641unboximpl();
                            composer3.endReplaceableGroup();
                        } else {
                            snapshotMutationPolicy = null;
                            composer3.startReplaceableGroup(-1083197798);
                            ComposerKt.sourceInformation(composer3, "155@6520L34");
                            TextFieldColors textFieldColors2 = colors;
                            boolean z22 = z14;
                            boolean z23 = z13;
                            int i24 = (i11 >> 27) & 14;
                            int i25 = i16;
                            jM1641unboximpl = textFieldColors2.leadingIconColor(z22, z23, composer3, i24 | ((i25 << 3) & 112) | ((i25 >> 3) & 896)).getValue().m1641unboximpl();
                            composer3.endReplaceableGroup();
                        }
                        final Function2<Composer, Integer, Unit> function22 = function17;
                        Object objComposableLambda = function22 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                            public final void invoke(Composer composer4, int i26) {
                                ComposerKt.sourceInformation(composer4, "C159@6690L57:TextFieldImpl.kt#jmzs0o");
                                if ((i26 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    TextFieldImplKt.m1232DecorationeuL9pac(jM1641unboximpl, null, null, function22, composer4, 0, 6);
                                }
                            }
                        }) : snapshotMutationPolicy;
                        if (colors instanceof TextFieldColorsWithIcons) {
                            composer3.startReplaceableGroup(-1083197452);
                            ComposerKt.sourceInformation(composer3, "164@6866L54");
                            TextFieldColorsWithIcons textFieldColorsWithIcons2 = (TextFieldColorsWithIcons) colors;
                            boolean z24 = z14;
                            boolean z25 = z13;
                            InteractionSource interactionSource3 = interactionSource;
                            int i26 = (i11 >> 27) & 14;
                            int i27 = i16;
                            jM1641unboximpl2 = textFieldColorsWithIcons2.trailingIconColor(z24, z25, interactionSource3, composer3, ((i27 << 3) & 896) | i26 | ((i27 << 3) & 112)).getValue().m1641unboximpl();
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1083197355);
                            ComposerKt.sourceInformation(composer3, "166@6963L35");
                            TextFieldColors textFieldColors3 = colors;
                            boolean z26 = z14;
                            boolean z27 = z13;
                            int i28 = (i11 >> 27) & 14;
                            int i29 = i16;
                            jM1641unboximpl2 = textFieldColors3.trailingIconColor(z26, z27, composer3, i28 | ((i29 << 3) & 112) | ((i29 >> 3) & 896)).getValue().m1641unboximpl();
                            composer3.endReplaceableGroup();
                        }
                        final Function2<Composer, Integer, Unit> function23 = function18;
                        ?? ComposableLambda = function23 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                            public final void invoke(Composer composer4, int i30) {
                                ComposerKt.sourceInformation(composer4, "C170@7136L58:TextFieldImpl.kt#jmzs0o");
                                if ((i30 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    TextFieldImplKt.m1232DecorationeuL9pac(jM1641unboximpl2, null, null, function23, composer4, 0, 6);
                                }
                            }
                        }) : snapshotMutationPolicy;
                        int i30 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                        if (i30 == 1) {
                            composer3.startReplaceableGroup(-1083197019);
                            ComposerKt.sourceInformation(composer3, "176@7296L485");
                            Function2<Composer, Integer, Unit> function24 = innerTextField;
                            boolean z28 = z15;
                            PaddingValues paddingValues = contentPadding;
                            int i31 = i11;
                            TextFieldKt.TextFieldLayout(modifierSemantics$default, function24, composableLambda, composableLambda2, objComposableLambda, ComposableLambda, z28, f, paddingValues, composer3, ((i31 >> 6) & 3670016) | ((i31 >> 3) & 112) | ((i19 << 21) & 29360128) | ((i16 << 18) & 234881024));
                            composer3.endReplaceableGroup();
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        if (i30 == 2) {
                            composer3.startReplaceableGroup(-1083196463);
                            ComposerKt.sourceInformation(composer3, "190@7903L38,208@8711L420,200@8303L994");
                            composer3.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composer3, "C(remember):Composables.kt#9igjgp");
                            Object objRememberedValue3 = composer3.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1452boximpl(Size.INSTANCE.m1473getZeroNHjbRc()), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                                composer3.updateRememberedValue(objRememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) objRememberedValue3;
                            final PaddingValues paddingValues2 = contentPadding;
                            final Function2<Composer, Integer, Unit> function25 = function19;
                            final int i32 = i16;
                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                public final void invoke(Composer composer4, int i33) {
                                    ComposerKt.sourceInformation(composer4, "C192@8021L246:TextFieldImpl.kt#jmzs0o");
                                    if ((i33 & 11) != 2 || !composer4.getSkipping()) {
                                        Modifier modifierM1114outlineCutout12SF9DM = OutlinedTextFieldKt.m1114outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                        Function2<Composer, Integer, Unit> function26 = function25;
                                        int i34 = i32;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer4.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer4.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer4.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM1114outlineCutout12SF9DM);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        composer4.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer4);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer4.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        composer4.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation(composer4, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer4.startReplaceableGroup(1029492925);
                                        ComposerKt.sourceInformation(composer4, "C196@8237L8:TextFieldImpl.kt#jmzs0o");
                                        if (function26 != null) {
                                            function26.invoke(composer4, Integer.valueOf((i34 >> 12) & 14));
                                        }
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            Function2<Composer, Integer, Unit> function26 = innerTextField;
                            boolean z29 = z15;
                            Float fValueOf = Float.valueOf(f);
                            composer3.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                            boolean zChanged3 = composer3.changed(fValueOf) | composer3.changed(mutableState);
                            Object objRememberedValue4 = composer3.rememberedValue();
                            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                        m1234invokeuvyYCjk(size.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                    public final void m1234invokeuvyYCjk(long j4) {
                                        float fM1464getWidthimpl = Size.m1464getWidthimpl(j4) * f;
                                        float fM1461getHeightimpl = Size.m1461getHeightimpl(j4) * f;
                                        if (Size.m1464getWidthimpl(mutableState.getValue().getPackedValue()) == fM1464getWidthimpl && Size.m1461getHeightimpl(mutableState.getValue().getPackedValue()) == fM1461getHeightimpl) {
                                            return;
                                        }
                                        mutableState.setValue(Size.m1452boximpl(SizeKt.Size(fM1464getWidthimpl, fM1461getHeightimpl)));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            PaddingValues paddingValues3 = contentPadding;
                            int i33 = i11;
                            OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function26, composableLambda2, composableLambda, objComposableLambda, ComposableLambda, z29, f, (Function1) objRememberedValue4, composableLambda3, paddingValues3, composer3, ((i33 >> 6) & 3670016) | ((i33 >> 3) & 112) | C.ENCODING_PCM_32BIT | ((i19 << 21) & 29360128), (i16 >> 6) & 14);
                            composer3.endReplaceableGroup();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        composer3.startReplaceableGroup(-1083194976);
                        composer3.endReplaceableGroup();
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 1769472);
            function7 = function11;
            function8 = function12;
            function9 = function13;
            z4 = z7;
            z5 = z8;
            z6 = z9;
            function10 = function14;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function7 = function3;
            function8 = function4;
            function9 = function5;
            z4 = z;
            z5 = z2;
            z6 = z3;
            function10 = function6;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.4
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
                TextFieldImplKt.CommonDecorationBox(type, value, innerTextField, visualTransformation, function2, function7, function8, function9, z4, z5, z6, interactionSource, contentPadding, colors, function10, composer3, i | 1, i2, i3);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1232DecorationeuL9pac(final long j, TextStyle textStyle, Float f, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        TextStyle textStyle2;
        int i4;
        final Float f2;
        int i5;
        int i6;
        final int i7;
        TextStyle textStyle3;
        Float f3;
        ComposableLambda composableLambda;
        final TextStyle textStyle4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                textStyle2 = textStyle;
                i3 |= composerStartRestartGroup.changed(textStyle2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i3;
                if ((i7 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i8 != 0) {
                        textStyle3 = null;
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i4 != 0) {
                        f3 = null;
                    } else {
                        f3 = f2;
                    }
                    final Float f4 = f3;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                        public final void invoke(Composer composer2, int i9) {
                            ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                            if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                                final Float f5 = f4;
                                final Function2<Composer, Integer, Unit> function2 = content;
                                final int i10 = i7;
                                final long j2 = j;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                                    public final void invoke(Composer composer3, int i11) {
                                        ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                        if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                            if (f5 != null) {
                                                composer3.startReplaceableGroup(-452622131);
                                                ComposerKt.sourceInformation(composer3, "240@9843L142");
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f5)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                                composer3.endReplaceableGroup();
                                                return;
                                            }
                                            composer3.startReplaceableGroup(-452621951);
                                            ComposerKt.sourceInformation(composer3, "245@10023L148");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                            composer3.endReplaceableGroup();
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (textStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-2009952864);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                        TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-2009952812);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                        composableLambda.invoke(composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textStyle4 = textStyle3;
                    f2 = f3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    textStyle4 = textStyle2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

                    public final void invoke(Composer composer2, int i9) {
                        TextFieldImplKt.m1232DecorationeuL9pac(j, textStyle4, f2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            f2 = f;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                final Float f5 = f3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                            final Float f6 = f5;
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i10 = i7;
                            final long j2 = j;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                    if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                        if (f6 != null) {
                                            composer3.startReplaceableGroup(-452622131);
                                            ComposerKt.sourceInformation(composer3, "240@9843L142");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f6)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                            composer3.endReplaceableGroup();
                                            return;
                                        }
                                        composer3.startReplaceableGroup(-452621951);
                                        ComposerKt.sourceInformation(composer3, "245@10023L148");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952812);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                    composableLambda.invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textStyle4 = textStyle3;
                f2 = f3;
            } else {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                final Float f6 = f3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                            final Float f7 = f6;
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i10 = i7;
                            final long j2 = j;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                    if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                        if (f7 != null) {
                                            composer3.startReplaceableGroup(-452622131);
                                            ComposerKt.sourceInformation(composer3, "240@9843L142");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f7)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                            composer3.endReplaceableGroup();
                                            return;
                                        }
                                        composer3.startReplaceableGroup(-452621951);
                                        ComposerKt.sourceInformation(composer3, "245@10023L148");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952812);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                    composableLambda.invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textStyle4 = textStyle3;
                f2 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer2, int i9) {
                    TextFieldImplKt.m1232DecorationeuL9pac(j, textStyle4, f2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        textStyle2 = textStyle;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                final Float f7 = f3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                            final Float f8 = f7;
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i10 = i7;
                            final long j2 = j;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                    if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                        if (f8 != null) {
                                            composer3.startReplaceableGroup(-452622131);
                                            ComposerKt.sourceInformation(composer3, "240@9843L142");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f8)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                            composer3.endReplaceableGroup();
                                            return;
                                        }
                                        composer3.startReplaceableGroup(-452621951);
                                        ComposerKt.sourceInformation(composer3, "245@10023L148");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952812);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                    composableLambda.invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textStyle4 = textStyle3;
                f2 = f3;
            } else {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                final Float f8 = f3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                            final Float f9 = f8;
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i10 = i7;
                            final long j2 = j;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                    if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                        if (f9 != null) {
                                            composer3.startReplaceableGroup(-452622131);
                                            ComposerKt.sourceInformation(composer3, "240@9843L142");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f9)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                            composer3.endReplaceableGroup();
                                            return;
                                        }
                                        composer3.startReplaceableGroup(-452621951);
                                        ComposerKt.sourceInformation(composer3, "245@10023L148");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952812);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                    composableLambda.invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textStyle4 = textStyle3;
                f2 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer2, int i9) {
                    TextFieldImplKt.m1232DecorationeuL9pac(j, textStyle4, f2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        f2 = f;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i7 = i3;
        if ((i7 & 5851) == 1170) {
            if (i8 != 0) {
                textStyle3 = null;
            } else {
                textStyle3 = textStyle2;
            }
            if (i4 != 0) {
                f3 = null;
            } else {
                f3 = f2;
            }
            final Float f9 = f3;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                    if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                        final Float f10 = f9;
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        final int i10 = i7;
                        final long j2 = j;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                            public final void invoke(Composer composer3, int i11) {
                                ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                    if (f10 != null) {
                                        composer3.startReplaceableGroup(-452622131);
                                        ComposerKt.sourceInformation(composer3, "240@9843L142");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f10)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.startReplaceableGroup(-452621951);
                                    ComposerKt.sourceInformation(composer3, "245@10023L148");
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                    composer3.endReplaceableGroup();
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (textStyle3 != null) {
                composerStartRestartGroup.startReplaceableGroup(-2009952864);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2009952812);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                composableLambda.invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textStyle4 = textStyle3;
            f2 = f3;
        } else {
            if (i8 != 0) {
                textStyle3 = null;
            } else {
                textStyle3 = textStyle2;
            }
            if (i4 != 0) {
                f3 = null;
            } else {
                f3 = f2;
            }
            final Float f10 = f3;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C238@9719L476:TextFieldImpl.kt#jmzs0o");
                    if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(j))};
                        final Float f11 = f10;
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        final int i10 = i7;
                        final long j2 = j;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                            public final void invoke(Composer composer3, int i11) {
                                ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                    if (f11 != null) {
                                        composer3.startReplaceableGroup(-452622131);
                                        ComposerKt.sourceInformation(composer3, "240@9843L142");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f11)}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                        composer3.endReplaceableGroup();
                                        return;
                                    }
                                    composer3.startReplaceableGroup(-452621951);
                                    ComposerKt.sourceInformation(composer3, "245@10023L148");
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j2)))}, function2, composer3, ((i10 >> 6) & 112) | 8);
                                    composer3.endReplaceableGroup();
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (textStyle3 != null) {
                composerStartRestartGroup.startReplaceableGroup(-2009952864);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10230L46");
                TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2009952812);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10282L18");
                composableLambda.invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textStyle4 = textStyle3;
            f2 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

            public final void invoke(Composer composer2, int i9) {
                TextFieldImplKt.m1232DecorationeuL9pac(j, textStyle4, f2, content, composer2, i | 1, i2);
            }
        });
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 48;
        IconDefaultSizeModifier = androidx.compose.foundation.layout.SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(f));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
