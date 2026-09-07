package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0090\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt {
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:105:0x0170 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x0192  */
    /* JADX WARN: Code duplicated, block: B:109:0x0195 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:110:0x0197 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:76:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0102  */
    /* JADX WARN: Code duplicated, block: B:86:0x0107  */
    /* JADX WARN: Code duplicated, block: B:89:0x010c  */
    /* JADX WARN: Code duplicated, block: B:90:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:93:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0118  */
    /* JADX WARN: Code duplicated, block: B:97:0x011b  */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    @ExperimentalMaterialApi
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> text, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i11;
        int i12;
        final Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        boolean z3;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle2;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle3;
        Function2<Composer, Integer, Unit> function2ApplyTextStyle4;
        Modifier modifierSemantics;
        Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItem)P(1!1,3,4!1,6)81@3397L10,83@3480L4,84@3570L6,85@3671L4,86@3764L4:ListItem.kt#jmzs0o");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changed(function6)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            function7 = function4;
                            if (composerStartRestartGroup.changed(function7)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            if ((458752 & i) == 0) {
                                function8 = function5;
                                if (composerStartRestartGroup.changed(function8)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                            if ((i2 & 64) != 0) {
                                i3 |= 1572864;
                            } else if ((i & 3670016) == 0) {
                                if (composerStartRestartGroup.changed(text)) {
                                    i12 = 1048576;
                                } else {
                                    i12 = 524288;
                                }
                                i3 |= i12;
                            }
                            if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                if (i13 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i14 != 0) {
                                    function9 = null;
                                } else {
                                    function9 = function2;
                                }
                                if (i4 != 0) {
                                    function10 = null;
                                } else {
                                    function10 = function6;
                                }
                                if (i6 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i8 != 0) {
                                    function7 = null;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function16 = i10 == 0 ? function8 : null;
                                Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                function2ApplyTextStyle = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                                Intrinsics.checkNotNull(function2ApplyTextStyle);
                                function2ApplyTextStyle2 = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                                function2ApplyTextStyle3 = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                                function2ApplyTextStyle4 = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (function2ApplyTextStyle2 == null || function2ApplyTextStyle3 != null) {
                                    function11 = function7;
                                    if ((function2ApplyTextStyle3 != null && z3) || function2ApplyTextStyle2 == null) {
                                        composerStartRestartGroup.startReplaceableGroup(-210280382);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4139L184");
                                        TwoLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                        composerStartRestartGroup.endReplaceableGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                        composerStartRestartGroup.endReplaceableGroup();
                                    }
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280579);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "91@3942L61");
                                    function11 = function7;
                                    OneLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 24576, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                                function12 = function10;
                                function13 = function11;
                                function14 = function16;
                                function15 = function9;
                                z4 = z3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                function15 = function2;
                                function12 = function6;
                                z4 = z2;
                                function13 = function7;
                                function14 = function8;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                                public final void invoke(Composer composer2, int i15) {
                                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                                }
                            });
                        }
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function8 = function5;
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(text)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography2.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography2.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography2.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography2.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography3 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography3.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography3.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography3.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography3.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(Composer composer2, int i15) {
                                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= 24576;
                    function7 = function4;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            function8 = function5;
                            if (composerStartRestartGroup.changed(function8)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(text)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography4.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography4.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography4.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography4.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography5 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography5.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography5.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography5.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography5.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(Composer composer2, int i15) {
                                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography6.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography6.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography6.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography6.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography7.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography7.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography7.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography7.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                z2 = z;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changed(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            function8 = function5;
                            if (composerStartRestartGroup.changed(function8)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(text)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography8.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography8.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography8.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography8.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography9.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography9.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography9.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography9.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(Composer composer2, int i15) {
                                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography10.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography10.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography10.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography10.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography11.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography11.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography11.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography11.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography12.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography12.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography12.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography12.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography13.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography13.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography13.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography13.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography14 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography14.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography14.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography14.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography14.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography15 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography15.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography15.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography15.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography15.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            function6 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changed(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            function8 = function5;
                            if (composerStartRestartGroup.changed(function8)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(text)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography16 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography16.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography16.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography16.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography16.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography17 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography17.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography17.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography17.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography17.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(Composer composer2, int i15) {
                                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography18 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography18.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography18.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography18.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography18.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography19 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography19.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography19.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography19.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography19.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography110.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography110.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography110.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography110.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography111.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography111.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography111.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography111.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography112.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography112.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography112.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography112.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography113.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography113.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography113.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography113.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z2 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changed(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography114.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography114.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography114.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography114.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography115.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography115.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography115.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography115.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography116.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography116.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography116.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography116.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography117.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography117.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography117.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography117.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changed(function8)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography118.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography118.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography118.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography118.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography119.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography119.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography119.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography119.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography1110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography1110.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography1110.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography1110.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography1110.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography1111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography1111.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography1111.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography1111.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography1111.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer2, int i15) {
                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                function6 = function3;
                if (composerStartRestartGroup.changed(function6)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changed(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            function8 = function5;
                            if (composerStartRestartGroup.changed(function8)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(text)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography1112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography1112.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography1112.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography1112.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography1112.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i14 != 0) {
                                function9 = null;
                            } else {
                                function9 = function2;
                            }
                            if (i4 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if (i6 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i8 != 0) {
                                function7 = null;
                            }
                            if (i10 == 0) {
                            }
                            Typography typography1113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            function2ApplyTextStyle = applyTextStyle(typography1113.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            function2ApplyTextStyle2 = applyTextStyle(typography1113.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                            function2ApplyTextStyle3 = applyTextStyle(typography1113.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                            function2ApplyTextStyle4 = applyTextStyle(typography1113.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (function2ApplyTextStyle2 == null) {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                function11 = function7;
                                if (function2ApplyTextStyle3 != null) {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                            }
                            function12 = function10;
                            function13 = function11;
                            function14 = function16;
                            function15 = function9;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                            public final void invoke(Composer composer2, int i15) {
                                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography1114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography1114.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography1114.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography1114.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography1114.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography1115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography1115.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography1115.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography1115.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography1115.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography1116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography1116.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography1116.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography1116.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography1116.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography1117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography1117.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography1117.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography1117.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography1117.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography1118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography1118.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography1118.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography1118.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography1118.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography1119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography1119.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography1119.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography1119.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography1119.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z2 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changed(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography11110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography11110.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography11110.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography11110.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography11110.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography11111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography11111.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography11111.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography11111.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography11111.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography11112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography11112.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography11112.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography11112.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography11112.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography11113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography11113.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography11113.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography11113.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography11113.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changed(function8)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography11114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography11114.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography11114.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography11114.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography11114.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography11115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography11115.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography11115.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography11115.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography11115.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography11116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography11116.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography11116.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography11116.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography11116.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography11117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography11117.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography11117.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography11117.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography11117.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer2, int i15) {
                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        function6 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changed(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changed(function8)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(text)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography11118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography11118.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography11118.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography11118.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography11118.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i14 != 0) {
                            function9 = null;
                        } else {
                            function9 = function2;
                        }
                        if (i4 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i8 != 0) {
                            function7 = null;
                        }
                        if (i10 == 0) {
                        }
                        Typography typography11119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        function2ApplyTextStyle = applyTextStyle(typography11119.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                        Intrinsics.checkNotNull(function2ApplyTextStyle);
                        function2ApplyTextStyle2 = applyTextStyle(typography11119.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                        function2ApplyTextStyle3 = applyTextStyle(typography11119.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                        function2ApplyTextStyle4 = applyTextStyle(typography11119.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                        modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        if (function2ApplyTextStyle2 == null) {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            function11 = function7;
                            if (function2ApplyTextStyle3 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-210280168);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        function12 = function10;
                        function13 = function11;
                        function14 = function16;
                        function15 = function9;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                        public final void invoke(Composer composer2, int i15) {
                            ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111110.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111110.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111110.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111110.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111111.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111111.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111111.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111111.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changed(function8)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111112.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111112.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111112.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111112.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111113.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111113.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111113.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111113.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography111114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography111114.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography111114.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography111114.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography111114.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography111115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography111115.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography111115.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography111115.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography111115.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer2, int i15) {
                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z2 = z;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changed(function7)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changed(function8)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(text)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111116.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111116.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111116.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111116.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i14 != 0) {
                        function9 = null;
                    } else {
                        function9 = function2;
                    }
                    if (i4 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if (i6 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i8 != 0) {
                        function7 = null;
                    }
                    if (i10 == 0) {
                    }
                    Typography typography111117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    function2ApplyTextStyle = applyTextStyle(typography111117.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                    Intrinsics.checkNotNull(function2ApplyTextStyle);
                    function2ApplyTextStyle2 = applyTextStyle(typography111117.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                    function2ApplyTextStyle3 = applyTextStyle(typography111117.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                    function2ApplyTextStyle4 = applyTextStyle(typography111117.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                    modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (function2ApplyTextStyle2 == null) {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    } else {
                        function11 = function7;
                        if (function2ApplyTextStyle3 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-210280168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                            ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                    }
                    function12 = function10;
                    function13 = function11;
                    function14 = function16;
                    function15 = function9;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                    public final void invoke(Composer composer2, int i15) {
                        ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography111118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography111118.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography111118.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography111118.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography111118.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography111119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography111119.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography111119.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography111119.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography111119.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer2, int i15) {
                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        function7 = function4;
        i10 = i2 & 32;
        if (i10 != 0) {
            if ((458752 & i) == 0) {
                function8 = function5;
                if (composerStartRestartGroup.changed(function8)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography1111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography1111110.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography1111110.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography1111110.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography1111110.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i14 != 0) {
                    function9 = null;
                } else {
                    function9 = function2;
                }
                if (i4 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (i6 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i8 != 0) {
                    function7 = null;
                }
                if (i10 == 0) {
                }
                Typography typography1111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                function2ApplyTextStyle = applyTextStyle(typography1111111.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
                Intrinsics.checkNotNull(function2ApplyTextStyle);
                function2ApplyTextStyle2 = applyTextStyle(typography1111111.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
                function2ApplyTextStyle3 = applyTextStyle(typography1111111.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
                function2ApplyTextStyle4 = applyTextStyle(typography1111111.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
                modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (function2ApplyTextStyle2 == null) {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                } else {
                    function11 = function7;
                    if (function2ApplyTextStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-210280168);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                        ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                function12 = function10;
                function13 = function11;
                function14 = function16;
                function15 = function9;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer2, int i15) {
                    ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function8 = function5;
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(text)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        if ((i3 & 2995931) == 599186) {
            if (i13 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i14 != 0) {
                function9 = null;
            } else {
                function9 = function2;
            }
            if (i4 != 0) {
                function10 = null;
            } else {
                function10 = function6;
            }
            if (i6 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i8 != 0) {
                function7 = null;
            }
            if (i10 == 0) {
            }
            Typography typography1111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            function2ApplyTextStyle = applyTextStyle(typography1111112.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
            Intrinsics.checkNotNull(function2ApplyTextStyle);
            function2ApplyTextStyle2 = applyTextStyle(typography1111112.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
            function2ApplyTextStyle3 = applyTextStyle(typography1111112.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
            function2ApplyTextStyle4 = applyTextStyle(typography1111112.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            });
            if (function2ApplyTextStyle2 == null) {
                function11 = function7;
                if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                function11 = function7;
                if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            function12 = function10;
            function13 = function11;
            function14 = function16;
            function15 = function9;
            z4 = z3;
        } else {
            if (i13 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i14 != 0) {
                function9 = null;
            } else {
                function9 = function2;
            }
            if (i4 != 0) {
                function10 = null;
            } else {
                function10 = function6;
            }
            if (i6 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i8 != 0) {
                function7 = null;
            }
            if (i10 == 0) {
            }
            Typography typography1111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            function2ApplyTextStyle = applyTextStyle(typography1111113.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), text);
            Intrinsics.checkNotNull(function2ApplyTextStyle);
            function2ApplyTextStyle2 = applyTextStyle(typography1111113.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function10);
            function2ApplyTextStyle3 = applyTextStyle(typography1111113.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function7);
            function2ApplyTextStyle4 = applyTextStyle(typography1111113.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function16);
            modifierSemantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            });
            if (function2ApplyTextStyle2 == null) {
                function11 = function7;
                if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                function11 = function7;
                if (function2ApplyTextStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-210280168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4355L184");
                    ThreeLine.INSTANCE.ListItem(modifierSemantics, function9, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            function12 = function10;
            function13 = function11;
            function14 = function16;
            function15 = function9;
            z4 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

            public final void invoke(Composer composer2, int i15) {
                ListItemKt.ListItem(companion, function15, function12, z4, function13, function14, text, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(final List<Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1631148337);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BaselinesOffsetColumn)P(2,1)352@13107L1127:ListItem.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                int height;
                Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                long jM3790copyZbe2FdA$default = Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
                List<? extends Measurable> list2 = measurables;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Measurable) it.next()).mo3124measureBRTryo0(jM3790copyZbe2FdA$default));
                }
                final ArrayList arrayList2 = arrayList;
                Iterator it2 = arrayList2.iterator();
                int iMax = 0;
                while (it2.hasNext()) {
                    iMax = Math.max(iMax, ((Placeable) it2.next()).getWidth());
                }
                int size = arrayList2.size();
                final Integer[] numArr = new Integer[size];
                for (int i3 = 0; i3 < size; i3++) {
                    numArr[i3] = 0;
                }
                List<Dp> list3 = list;
                int size2 = arrayList2.size();
                int height2 = 0;
                for (int i4 = 0; i4 < size2; i4++) {
                    Placeable placeable = (Placeable) arrayList2.get(i4);
                    if (i4 > 0) {
                        int i5 = i4 - 1;
                        height = ((Placeable) arrayList2.get(i5)).getHeight() - ((Placeable) arrayList2.get(i5)).get(AlignmentLineKt.getLastBaseline());
                    } else {
                        height = 0;
                    }
                    int iMax2 = Math.max(0, (Layout.mo312roundToPx0680j_4(list3.get(i4).m3857unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - height);
                    numArr[i4] = Integer.valueOf(iMax2 + height2);
                    height2 += iMax2 + placeable.getHeight();
                }
                return MeasureScope.layout$default(Layout, iMax, height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        List<Placeable> list4 = arrayList2;
                        Integer[] numArr2 = numArr;
                        int size3 = list4.size();
                        for (int i6 = 0; i6 < size3; i6++) {
                            Placeable.PlacementScope.placeRelative$default(layout, list4.get(i6), 0, numArr2[i6].intValue(), 0.0f, 4, null);
                        }
                    }
                }, 4, null);
            }
        };
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        int i3 = (((((i >> 6) & 14) | (i & 112)) << 9) & 7168) | 6;
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
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.2
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
                ListItemKt.BaselinesOffsetColumn(list, modifier2, function2, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m1079OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1062692685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)394@14762L806:ListItem.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    int iMax;
                    final int iM3962getYimpl;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final Placeable placeableMo3124measureBRTryo0 = measurables.get(0).mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                    int i5 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                    if (i5 != Integer.MIN_VALUE) {
                        iM3962getYimpl = Layout.mo312roundToPx0680j_4(f) - i5;
                        iMax = Math.max(Constraints.m3800getMinHeightimpl(j), placeableMo3124measureBRTryo0.getHeight() + iM3962getYimpl);
                    } else {
                        iMax = Math.max(Constraints.m3800getMinHeightimpl(j), placeableMo3124measureBRTryo0.getHeight());
                        iM3962getYimpl = IntOffset.m3962getYimpl(Alignment.INSTANCE.getCenter().mo1303alignKFBX0sM(IntSize.INSTANCE.m4008getZeroYbymL2g(), IntSizeKt.IntSize(0, iMax - placeableMo3124measureBRTryo0.getHeight()), Layout.getLayoutDirection()));
                    }
                    return MeasureScope.layout$default(Layout, placeableMo3124measureBRTryo0.getWidth(), iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo3124measureBRTryo0, 0, iM3962getYimpl, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            int i5 = ((((i3 & 112) | ((i3 >> 6) & 14)) << 9) & 7168) | 6;
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
            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$2
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

            public final void invoke(Composer composer2, int i6) {
                ListItemKt.m1079OffsetToBaselineOrCenterKz89ssw(f, modifier2, function2, composer2, i | 1, i2);
            }
        });
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C423@15773L123:ListItem.kt#jmzs0o");
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f))};
                    final TextStyle textStyle2 = textStyle;
                    final Function2<Composer, Integer, Unit> function3 = function2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer, 1665877604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1.1
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

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C424@15853L33:ListItem.kt#jmzs0o");
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                TextKt.ProvideTextStyle(textStyle2, function3, composer2, 0);
                            }
                        }
                    }), composer, 56);
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
