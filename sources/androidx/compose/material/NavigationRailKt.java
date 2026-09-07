package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0091\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt {
    private static final float HeaderPadding;
    private static final float NavigationRailPadding;
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = Dp.m3843constructorimpl(72);
    private static final float NavigationRailItemCompactSize = Dp.m3843constructorimpl(56);
    private static final float ItemLabelBaselineBottomOffset = Dp.m3843constructorimpl(16);
    private static final float ItemIconTopOffset = Dp.m3843constructorimpl(14);

    /* JADX WARN: Code duplicated, block: B:103:0x0176  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f8 A[PHI: r1 r3 r4 r6 r11
  0x00f8: PHI (r1v8 androidx.compose.ui.Modifier) = (r1v4 androidx.compose.ui.Modifier), (r1v11 androidx.compose.ui.Modifier) binds: [B:97:0x012c, B:84:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r3v20 int) = (r3v15 int), (r3v23 int) binds: [B:97:0x012c, B:84:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r4v7 long) = (r4v3 long), (r4v2 long) binds: [B:97:0x012c, B:84:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r6v7 long) = (r6v3 long), (r6v2 long) binds: [B:97:0x012c, B:84:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r11v12 float) = (r11v3 float), (r11v2 float) binds: [B:97:0x012c, B:84:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX WARN: Code duplicated, block: B:96:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x012e  */
    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    public static final void m1100NavigationRailHsRjFd4(Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM983getSurface0d7_KjU;
        long jM997contentColorForek8zF_U;
        float fM1099getElevationD9Ej5fM;
        int i4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        int i5;
        int i6;
        final Modifier.Companion companion;
        final int i7;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5;
        float f2;
        final float f3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1790971523);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)94@4333L6,95@4375L32,100@4577L552:NavigationRail.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                jM983getSurface0d7_KjU = j;
                int i9 = composerStartRestartGroup.changed(jM983getSurface0d7_KjU) ? 32 : 16;
                i3 |= i9;
            } else {
                jM983getSurface0d7_KjU = j;
            }
            i3 |= i9;
        } else {
            jM983getSurface0d7_KjU = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM997contentColorForek8zF_U = j2;
                int i10 = composerStartRestartGroup.changed(jM997contentColorForek8zF_U) ? 256 : 128;
                i3 |= i10;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            i3 |= i10;
        } else {
            jM997contentColorForek8zF_U = j2;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 7168) == 0) {
                fM1099getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM1099getElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changed(function4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i2 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i6 = 131072;
                        } else {
                            i6 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if ((i2 & 2) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i11 != 0) {
                                fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                i7 = i3;
                                function5 = null;
                                f2 = fM1099getElevationD9Ej5fM;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i12 = i7 << 3;
                            SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                                public final void invoke(Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                                    if ((i13 & 11) != 2 || !composer2.getSkipping()) {
                                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                        int i14 = i7;
                                        Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                        composer2.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer2.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer2.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer2.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer2.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        composer2.startReplaceableGroup(-1163856341);
                                        ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        composer2.startReplaceableGroup(-497173955);
                                        ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                        composer2.startReplaceableGroup(65525382);
                                        ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                        if (function7 != null) {
                                            function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i14 >> 9) & 112) | 6));
                                            SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                        }
                                        composer2.endReplaceableGroup();
                                        function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i14 >> 12) & 112)));
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i12 & 896) | (i12 & 7168) | ((i7 << 6) & 458752), 18);
                            long j5 = jM997contentColorForek8zF_U;
                            f3 = f2;
                            function6 = function5;
                            j3 = jM983getSurface0d7_KjU;
                            j4 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            companion = modifier2;
                        }
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                        composerStartRestartGroup.endDefaults();
                        int i13 = i7 << 3;
                        SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                            public final void invoke(Composer composer2, int i14) {
                                ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                    Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                    int i15 = i7;
                                    Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                    composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer2.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Density density = (Density) objConsume;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer2.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composer2.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-497173955);
                                    ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                    composer2.startReplaceableGroup(65525382);
                                    ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                    if (function7 != null) {
                                        function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i15 >> 9) & 112) | 6));
                                        SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i15 >> 12) & 112)));
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i13 & 896) | (i13 & 7168) | ((i7 << 6) & 458752), 18);
                        long j6 = jM997contentColorForek8zF_U;
                        f3 = f2;
                        function6 = function5;
                        j3 = jM983getSurface0d7_KjU;
                        j4 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                        j3 = jM983getSurface0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                        f3 = fM1099getElevationD9Ej5fM;
                        function6 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                        public final void invoke(Composer composer2, int i14) {
                            NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                        }
                    });
                }
                i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i6;
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i14 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i16 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i16 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i16 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i14 & 896) | (i14 & 7168) | ((i7 << 6) & 458752), 18);
                    long j7 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i15 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                        public final void invoke(Composer composer2, int i16) {
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i17 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i17 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i17 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i15 & 896) | (i15 & 7168) | ((i7 << 6) & 458752), 18);
                    long j8 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                    public final void invoke(Composer composer2, int i16) {
                        NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            function4 = function3;
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i16 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                        public final void invoke(Composer composer2, int i17) {
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i18 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i18 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i18 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i16 & 896) | (i16 & 7168) | ((i7 << 6) & 458752), 18);
                    long j9 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i17 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                        public final void invoke(Composer composer2, int i18) {
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i19 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i19 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i19 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i17 & 896) | (i17 & 7168) | ((i7 << 6) & 458752), 18);
                    long j10 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                    public final void invoke(Composer composer2, int i18) {
                        NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                    }
                });
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i18 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i19) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i110 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i110 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i110 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i18 & 896) | (i18 & 7168) | ((i7 << 6) & 458752), 18);
                long j11 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i19 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i110) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i111 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i111 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i111 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i19 & 896) | (i19 & 7168) | ((i7 << 6) & 458752), 18);
                long j12 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                public final void invoke(Composer composer2, int i110) {
                    NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        fM1099getElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changed(function4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i2 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i110 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                        public final void invoke(Composer composer2, int i111) {
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i112 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i112 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i112 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i110 & 896) | (i110 & 7168) | ((i7 << 6) & 458752), 18);
                    long j13 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            function5 = null;
                            f2 = fM1099getElevationD9Ej5fM;
                        } else {
                            i7 = i3;
                            f2 = fM1099getElevationD9Ej5fM;
                            function5 = function4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111 = i7 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                        public final void invoke(Composer composer2, int i112) {
                            ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                            if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                                int i113 = i7;
                                Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density = (Density) objConsume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composer2.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-497173955);
                                ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                                composer2.startReplaceableGroup(65525382);
                                ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                                if (function7 != null) {
                                    function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i113 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i113 >> 12) & 112)));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i111 & 896) | (i111 & 7168) | ((i7 << 6) & 458752), 18);
                    long j14 = jM997contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    j3 = jM983getSurface0d7_KjU;
                    j4 = j14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                    public final void invoke(Composer composer2, int i112) {
                        NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                    }
                });
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i112 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i113) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i114 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i114 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i114 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i112 & 896) | (i112 & 7168) | ((i7 << 6) & 458752), 18);
                long j15 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i113 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i114) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i115 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i115 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i115 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i113 & 896) | (i113 & 7168) | ((i7 << 6) & 458752), 18);
                long j16 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j16;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                public final void invoke(Composer composer2, int i114) {
                    NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        function4 = function3;
        if ((i2 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i114 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i115) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i116 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i116 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i116 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i114 & 896) | (i114 & 7168) | ((i7 << 6) & 458752), 18);
                long j17 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        function5 = null;
                        f2 = fM1099getElevationD9Ej5fM;
                    } else {
                        i7 = i3;
                        f2 = fM1099getElevationD9Ej5fM;
                        function5 = function4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i115 = i7 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer2, int i116) {
                        ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                        if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                            int i117 = i7;
                            Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-497173955);
                            ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                            composer2.startReplaceableGroup(65525382);
                            ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                            if (function7 != null) {
                                function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i117 >> 9) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i117 >> 12) & 112)));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i115 & 896) | (i115 & 7168) | ((i7 << 6) & 458752), 18);
                long j18 = jM997contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                j3 = jM983getSurface0d7_KjU;
                j4 = j18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

                public final void invoke(Composer composer2, int i116) {
                    NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
                }
            });
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i6;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    i7 = i3;
                    function5 = null;
                    f2 = fM1099getElevationD9Ej5fM;
                } else {
                    i7 = i3;
                    f2 = fM1099getElevationD9Ej5fM;
                    function5 = function4;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    i7 = i3;
                    function5 = null;
                    f2 = fM1099getElevationD9Ej5fM;
                } else {
                    i7 = i3;
                    f2 = fM1099getElevationD9Ej5fM;
                    function5 = function4;
                }
            }
            composerStartRestartGroup.endDefaults();
            int i116 = i7 << 3;
            SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                public final void invoke(Composer composer2, int i117) {
                    ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                    if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                        int i118 = i7;
                        Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-497173955);
                        ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                        composer2.startReplaceableGroup(65525382);
                        ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                        if (function7 != null) {
                            function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i118 >> 9) & 112) | 6));
                            SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i118 >> 12) & 112)));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i116 & 896) | (i116 & 7168) | ((i7 << 6) & 458752), 18);
            long j19 = jM997contentColorForek8zF_U;
            f3 = f2;
            function6 = function5;
            j3 = jM983getSurface0d7_KjU;
            j4 = j19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    i7 = i3;
                    function5 = null;
                    f2 = fM1099getElevationD9Ej5fM;
                } else {
                    i7 = i3;
                    f2 = fM1099getElevationD9Ej5fM;
                    function5 = function4;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    fM1099getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m1099getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    i7 = i3;
                    function5 = null;
                    f2 = fM1099getElevationD9Ej5fM;
                } else {
                    i7 = i3;
                    f2 = fM1099getElevationD9Ej5fM;
                    function5 = function4;
                }
            }
            composerStartRestartGroup.endDefaults();
            int i117 = i7 << 3;
            SurfaceKt.m1175SurfaceFjzlyU(companion, null, jM983getSurface0d7_KjU, jM997contentColorForek8zF_U, null, f2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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

                public final void invoke(Composer composer2, int i118) {
                    ComposerKt.sourceInformation(composer2, "C106@4731L392:NavigationRail.kt#jmzs0o");
                    if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m425paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Function3<ColumnScope, Composer, Integer, Unit> function7 = function5;
                        int i119 = i7;
                        Function3<ColumnScope, Composer, Integer, Unit> function8 = content;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation(composer2, "C79@3994L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-497173955);
                        ComposerKt.sourceInformation(composer2, "C117@5104L9:NavigationRail.kt#jmzs0o");
                        composer2.startReplaceableGroup(65525382);
                        ComposerKt.sourceInformation(composer2, "114@5014L8,115@5039L38");
                        if (function7 != null) {
                            function7.invoke(columnScopeInstance, composer2, Integer.valueOf(((i119 >> 9) & 112) | 6));
                            SpacerKt.Spacer(SizeKt.m450height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.HeaderPadding), composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        function8.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i119 >> 12) & 112)));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i7 & 14) | 1572864 | (i117 & 896) | (i117 & 7168) | ((i7 << 6) & 458752), 18);
            long j110 = jM997contentColorForek8zF_U;
            f3 = f2;
            function6 = function5;
            j3 = jM983getSurface0d7_KjU;
            j4 = j110;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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

            public final void invoke(Composer composer2, int i118) {
                NavigationRailKt.m1100NavigationRailHsRjFd4(companion, j3, j4, f3, function6, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0126  */
    /* JADX WARN: Code duplicated, block: B:102:0x012a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0135 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0148  */
    /* JADX WARN: Code duplicated, block: B:115:0x015e  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:127:0x018b A[PHI: r1 r4 r5 r8 r10 r12 r18
  0x018b: PHI (r1v34 androidx.compose.ui.Modifier) = (r1v12 androidx.compose.ui.Modifier), (r1v38 androidx.compose.ui.Modifier) binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r4v30 int) = (r4v23 int), (r4v32 int) binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r5v32 androidx.compose.foundation.interaction.MutableInteractionSource) = 
  (r5v14 androidx.compose.foundation.interaction.MutableInteractionSource)
  (r5v33 androidx.compose.foundation.interaction.MutableInteractionSource)
 binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r8v8 boolean) = (r8v4 boolean), (r8v3 boolean) binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r10v7 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
  (r10v4 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
  (r10v3 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
 binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r12v7 boolean) = (r12v4 boolean), (r12v3 boolean) binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x018b: PHI (r18v4 long) = (r18v1 long), (r18v5 long) binds: [B:148:0x01e0, B:126:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:130:0x0196  */
    /* JADX WARN: Code duplicated, block: B:132:0x019a  */
    /* JADX WARN: Code duplicated, block: B:134:0x019d  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:146:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:152:0x0225  */
    /* JADX WARN: Code duplicated, block: B:155:0x0239  */
    /* JADX WARN: Code duplicated, block: B:156:0x023c  */
    /* JADX WARN: Code duplicated, block: B:159:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:162:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:163:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:168:0x03af  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:51:0x009d  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Instruction removed from duplicated block: B:115:0x015e, please report this as an issue */
    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    public static final void m1101NavigationRailItem0S3VyRs(final boolean z, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        final int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        int i7;
        int i8;
        final boolean z5;
        int i9;
        int i10;
        int i11;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource2;
        long jM979getPrimary0d7_KjU;
        long jM1630copywmQWz5c$default;
        Object objRememberedValue;
        float f;
        Function0<ComposeUiNode> constructor;
        final Modifier modifier3;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final boolean z7;
        final MutableInteractionSource mutableInteractionSource3;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1813548445);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@6931L39,155@7020L6,156@7090L7,156@7124L6,171@7922L83,175@8010L791:NavigationRail.kt#jmzs0o");
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
            i3 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(icon) ? 256 : 128;
        }
        int i12 = i2 & 8;
        if (i12 == 0) {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((458752 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changed(function3)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((3670016 & i) == 0) {
                            z5 = z3;
                            if (composerStartRestartGroup.changed(z5)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 234881024) != 0) {
                            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                        }
                        if ((i & 1879048192) != 0) {
                            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                        }
                        if ((i3 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                }
                                if ((i2 & 512) != 0) {
                                    i3 &= -1879048193;
                                }
                                companion = modifier;
                                mutableInteractionSource2 = mutableInteractionSource;
                                jM979getPrimary0d7_KjU = j;
                            } else {
                                if (i12 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function3 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
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
                                if ((i2 & 256) != 0) {
                                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                    i3 &= -234881025;
                                } else {
                                    jM979getPrimary0d7_KjU = j;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i3 &= -1879048193;
                                }
                                composerStartRestartGroup.endDefaults();
                                final ComposableLambda composableLambda = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                                    public final void invoke(Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                        if ((i13 & 11) != 2 || !composer2.getSkipping()) {
                                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                }) : null;
                                if (function3 == null) {
                                    f = NavigationRailItemCompactSize;
                                } else {
                                    f = NavigationRailItemSize;
                                }
                                Modifier modifierM464size3ABfNKs = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Density density = (Density) objConsume2;
                                Modifier modifier4 = companion;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM464size3ABfNKs);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composerStartRestartGroup.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceableGroup(2058660585);
                                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(-172871267);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                                int i13 = i3 >> 24;
                                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                        invoke(f2.floatValue(), composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f2, Composer composer2, int i14) {
                                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                        if ((i14 & 14) == 0) {
                                            i14 |= composer2.changed(f2) ? 4 : 2;
                                        }
                                        if ((i14 & 91) != 18 || !composer2.getSkipping()) {
                                            if (z5) {
                                                f2 = 1.0f;
                                            }
                                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda, f2, composer2, (i3 >> 6) & 14);
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), composerStartRestartGroup, (i13 & 112) | (i13 & 14) | 3072 | ((i3 << 6) & 896));
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                modifier3 = modifier4;
                                z6 = z4;
                                function4 = function3;
                                z7 = z5;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                j3 = jM979getPrimary0d7_KjU;
                                j4 = jM1630copywmQWz5c$default;
                            }
                            jM1630copywmQWz5c$default = j2;
                            composerStartRestartGroup.endDefaults();
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda2 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i14) {
                                    ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            }) : null;
                            if (function3 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            Modifier modifierM464size3ABfNKs2 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density2 = (Density) objConsume5;
                            Modifier modifier5 = companion;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume6;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume7 = composerStartRestartGroup.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume7;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM464size3ABfNKs2);
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
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-172871267);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                            int i14 = i3 >> 24;
                            m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                    invoke(f2.floatValue(), composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f2, Composer composer2, int i15) {
                                    ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                    if ((i15 & 14) == 0) {
                                        i15 |= composer2.changed(f2) ? 4 : 2;
                                    }
                                    if ((i15 & 91) != 18 || !composer2.getSkipping()) {
                                        if (z5) {
                                            f2 = 1.0f;
                                        }
                                        NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda2, f2, composer2, (i3 >> 6) & 14);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i3 << 6) & 896));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier5;
                            z6 = z4;
                            function4 = function3;
                            z7 = z5;
                            mutableInteractionSource3 = mutableInteractionSource5;
                            j3 = jM979getPrimary0d7_KjU;
                            j4 = jM1630copywmQWz5c$default;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z6 = z4;
                            function4 = function3;
                            z7 = z5;
                            mutableInteractionSource3 = mutableInteractionSource;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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
                                NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= 1572864;
                    z5 = z3;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 234881024) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 1879048192) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume8 = composerStartRestartGroup.consume(localContentColor2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume8).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume9 = composerStartRestartGroup.consume(localContentColor3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume9).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda3 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs3 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density3 = (Density) objConsume10;
                        Modifier modifier6 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume11;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localViewConfiguration3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume12;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM464size3ABfNKs3);
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
                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i15 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i16) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i16 & 14) == 0) {
                                    i16 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i16 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda3, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier6;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource6;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume13 = composerStartRestartGroup.consume(localContentColor4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume13).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume14 = composerStartRestartGroup.consume(localContentColor5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume14).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda4 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i16) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs4 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center4 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center4, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume15 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density4 = (Density) objConsume15;
                        Modifier modifier7 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume16 = composerStartRestartGroup.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection4 = (LayoutDirection) objConsume16;
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localViewConfiguration4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume17;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM464size3ABfNKs4);
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
                        Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i16 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i17) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i17 & 14) == 0) {
                                    i17 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda4, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier7;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource7;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                        public final void invoke(Composer composer2, int i17) {
                            NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function2;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((3670016 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 234881024) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 1879048192) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume18 = composerStartRestartGroup.consume(localContentColor6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume18).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume19 = composerStartRestartGroup.consume(localContentColor7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume19).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda5 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i17) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs5 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center5 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center5, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume110 = composerStartRestartGroup.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density5 = (Density) objConsume110;
                        Modifier modifier8 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111 = composerStartRestartGroup.consume(localLayoutDirection5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection5 = (LayoutDirection) objConsume111;
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume112 = composerStartRestartGroup.consume(localViewConfiguration5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume112;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM464size3ABfNKs5);
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
                        Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i17 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i18) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i18 & 14) == 0) {
                                    i18 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i18 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda5, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier8;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource8;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume113 = composerStartRestartGroup.consume(localContentColor8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume114 = composerStartRestartGroup.consume(localContentColor9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda6 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i18) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs6 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center6 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(center6, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume115 = composerStartRestartGroup.consume(localDensity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density6 = (Density) objConsume115;
                        Modifier modifier9 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume116 = composerStartRestartGroup.consume(localLayoutDirection6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection6 = (LayoutDirection) objConsume116;
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume117 = composerStartRestartGroup.consume(localViewConfiguration6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume117;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM464size3ABfNKs6);
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
                        Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl6, density6, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl6, viewConfiguration6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i18 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i19) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i19 & 14) == 0) {
                                    i19 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i19 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda6, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier9;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource9;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                        public final void invoke(Composer composer2, int i19) {
                            NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume118 = composerStartRestartGroup.consume(localContentColor10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume119 = composerStartRestartGroup.consume(localContentColor11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda7 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i19) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs7 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(center7, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1110 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density7 = (Density) objConsume1110;
                    Modifier modifier10 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111 = composerStartRestartGroup.consume(localLayoutDirection7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection7 = (LayoutDirection) objConsume1111;
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1112 = composerStartRestartGroup.consume(localViewConfiguration7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) objConsume1112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM464size3ABfNKs7);
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
                    Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl7, density7, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl7, viewConfiguration7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i19 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i110) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i110 & 14) == 0) {
                                i110 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i110 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda7, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i19 & 112) | (i19 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier10;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource10;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1113 = composerStartRestartGroup.consume(localContentColor12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1114 = composerStartRestartGroup.consume(localContentColor13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda8 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i110) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs8 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center8 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(center8, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1115 = composerStartRestartGroup.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density8 = (Density) objConsume1115;
                    Modifier modifier11 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1116 = composerStartRestartGroup.consume(localLayoutDirection8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection8 = (LayoutDirection) objConsume1116;
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1117 = composerStartRestartGroup.consume(localViewConfiguration8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration8 = (ViewConfiguration) objConsume1117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierM464size3ABfNKs8);
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
                    Composer composerM1286constructorimpl8 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl8, measurePolicyRememberBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl8, density8, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl8, layoutDirection8, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl8, viewConfiguration8, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf8.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i110 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i111) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i111 & 14) == 0) {
                                i111 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i111 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda8, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier11;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource11;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i111) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((3670016 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 234881024) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 1879048192) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1118 = composerStartRestartGroup.consume(localContentColor14);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1119 = composerStartRestartGroup.consume(localContentColor15);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda9 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i111) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs9 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center9 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(center9, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11110 = composerStartRestartGroup.consume(localDensity9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density9 = (Density) objConsume11110;
                        Modifier modifier12 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111 = composerStartRestartGroup.consume(localLayoutDirection9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection9 = (LayoutDirection) objConsume11111;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration9 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11112 = composerStartRestartGroup.consume(localViewConfiguration9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration9 = (ViewConfiguration) objConsume11112;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierM464size3ABfNKs9);
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
                        Composer composerM1286constructorimpl9 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl9, measurePolicyRememberBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl9, density9, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl9, layoutDirection9, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl9, viewConfiguration9, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf9.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i111 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i112) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i112 & 14) == 0) {
                                    i112 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i112 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda9, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i111 & 112) | (i111 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier12;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource12;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11113 = composerStartRestartGroup.consume(localContentColor16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11114 = composerStartRestartGroup.consume(localContentColor17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda10 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i112) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs10 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center10 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(center10, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11115 = composerStartRestartGroup.consume(localDensity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density10 = (Density) objConsume11115;
                        Modifier modifier13 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11116 = composerStartRestartGroup.consume(localLayoutDirection10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection10 = (LayoutDirection) objConsume11116;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration10 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11117 = composerStartRestartGroup.consume(localViewConfiguration10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration10 = (ViewConfiguration) objConsume11117;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf10 = LayoutKt.materializerOf(modifierM464size3ABfNKs10);
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
                        Composer composerM1286constructorimpl10 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl10, measurePolicyRememberBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl10, density10, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl10, layoutDirection10, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl10, viewConfiguration10, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf10.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i112 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i113) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i113 & 14) == 0) {
                                    i113 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i113 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda10, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i112 & 112) | (i112 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier13;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource13;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                        public final void invoke(Composer composer2, int i113) {
                            NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11118 = composerStartRestartGroup.consume(localContentColor18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11119 = composerStartRestartGroup.consume(localContentColor19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda11 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i113) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs11 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(center11, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111110 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11 = (Density) objConsume111110;
                    Modifier modifier14 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111 = composerStartRestartGroup.consume(localLayoutDirection11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11 = (LayoutDirection) objConsume111111;
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111112 = composerStartRestartGroup.consume(localViewConfiguration11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11 = (ViewConfiguration) objConsume111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11 = LayoutKt.materializerOf(modifierM464size3ABfNKs11);
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
                    Composer composerM1286constructorimpl11 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl11, measurePolicyRememberBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl11, density11, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl11, layoutDirection11, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl11, viewConfiguration11, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf11.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i113 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i114) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i114 & 14) == 0) {
                                i114 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i114 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda11, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier14;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource14;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111113 = composerStartRestartGroup.consume(localContentColor110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111114 = composerStartRestartGroup.consume(localContentColor111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda12 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i114) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs12 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center12 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(center12, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111115 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density12 = (Density) objConsume111115;
                    Modifier modifier15 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111116 = composerStartRestartGroup.consume(localLayoutDirection12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection12 = (LayoutDirection) objConsume111116;
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration12 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111117 = composerStartRestartGroup.consume(localViewConfiguration12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration12 = (ViewConfiguration) objConsume111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf12 = LayoutKt.materializerOf(modifierM464size3ABfNKs12);
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
                    Composer composerM1286constructorimpl12 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl12, measurePolicyRememberBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl12, density12, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl12, layoutDirection12, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl12, viewConfiguration12, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf12.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i114 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i115) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i115 & 14) == 0) {
                                i115 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i115 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda12, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i114 & 112) | (i114 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier15;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource15;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i115) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function2;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((3670016 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111118 = composerStartRestartGroup.consume(localContentColor112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111119 = composerStartRestartGroup.consume(localContentColor113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda13 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i115) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs13 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center13 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(center13, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111110 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density13 = (Density) objConsume1111110;
                    Modifier modifier16 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111 = composerStartRestartGroup.consume(localLayoutDirection13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection13 = (LayoutDirection) objConsume1111111;
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration13 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111112 = composerStartRestartGroup.consume(localViewConfiguration13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration13 = (ViewConfiguration) objConsume1111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf13 = LayoutKt.materializerOf(modifierM464size3ABfNKs13);
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
                    Composer composerM1286constructorimpl13 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl13, measurePolicyRememberBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl13, density13, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl13, layoutDirection13, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl13, viewConfiguration13, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf13.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i115 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i116) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i116 & 14) == 0) {
                                i116 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i116 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda13, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier16;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource16;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111113 = composerStartRestartGroup.consume(localContentColor114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111114 = composerStartRestartGroup.consume(localContentColor115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda14 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i116) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs14 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center14 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(center14, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111115 = composerStartRestartGroup.consume(localDensity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density14 = (Density) objConsume1111115;
                    Modifier modifier17 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111116 = composerStartRestartGroup.consume(localLayoutDirection14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection14 = (LayoutDirection) objConsume1111116;
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration14 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111117 = composerStartRestartGroup.consume(localViewConfiguration14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration14 = (ViewConfiguration) objConsume1111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf14 = LayoutKt.materializerOf(modifierM464size3ABfNKs14);
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
                    Composer composerM1286constructorimpl14 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl14, measurePolicyRememberBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl14, density14, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl14, layoutDirection14, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl14, viewConfiguration14, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf14.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i116 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i117) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i117 & 14) == 0) {
                                i117 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i117 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda14, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i116 & 112) | (i116 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier17;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource17;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i117) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 1879048192) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111118 = composerStartRestartGroup.consume(localContentColor116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111119 = composerStartRestartGroup.consume(localContentColor117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda15 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i117) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs15 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(center15, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111110 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density15 = (Density) objConsume11111110;
                Modifier modifier18 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111 = composerStartRestartGroup.consume(localLayoutDirection15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection15 = (LayoutDirection) objConsume11111111;
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration15 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111112 = composerStartRestartGroup.consume(localViewConfiguration15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration15 = (ViewConfiguration) objConsume11111112;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf15 = LayoutKt.materializerOf(modifierM464size3ABfNKs15);
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
                Composer composerM1286constructorimpl15 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl15, measurePolicyRememberBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl15, density15, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl15, layoutDirection15, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl15, viewConfiguration15, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf15.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i117 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i118) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i118 & 14) == 0) {
                            i118 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i118 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda15, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i117 & 112) | (i117 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier18;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource18;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111113 = composerStartRestartGroup.consume(localContentColor118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111114 = composerStartRestartGroup.consume(localContentColor119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda16 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i118) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs16 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center16 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(center16, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111115 = composerStartRestartGroup.consume(localDensity16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density16 = (Density) objConsume11111115;
                Modifier modifier19 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111116 = composerStartRestartGroup.consume(localLayoutDirection16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection16 = (LayoutDirection) objConsume11111116;
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration16 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111117 = composerStartRestartGroup.consume(localViewConfiguration16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration16 = (ViewConfiguration) objConsume11111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf16 = LayoutKt.materializerOf(modifierM464size3ABfNKs16);
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
                Composer composerM1286constructorimpl16 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl16, measurePolicyRememberBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl16, density16, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl16, layoutDirection16, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl16, viewConfiguration16, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf16.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i118 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i119) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i119 & 14) == 0) {
                            i119 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i119 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda16, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i118 & 112) | (i118 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier19;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource19;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                public final void invoke(Composer composer2, int i119) {
                    NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((3670016 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 234881024) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 1879048192) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11111118 = composerStartRestartGroup.consume(localContentColor1110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11111119 = composerStartRestartGroup.consume(localContentColor1111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda17 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i119) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i119 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs17 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center17 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy17 = BoxKt.rememberBoxMeasurePolicy(center17, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111110 = composerStartRestartGroup.consume(localDensity17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density17 = (Density) objConsume111111110;
                        Modifier modifier110 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111 = composerStartRestartGroup.consume(localLayoutDirection17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection17 = (LayoutDirection) objConsume111111111;
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration17 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111112 = composerStartRestartGroup.consume(localViewConfiguration17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration17 = (ViewConfiguration) objConsume111111112;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf17 = LayoutKt.materializerOf(modifierM464size3ABfNKs17);
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
                        Composer composerM1286constructorimpl17 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl17, measurePolicyRememberBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl17, density17, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl17, layoutDirection17, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl17, viewConfiguration17, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf17.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i119 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i1110) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i1110 & 14) == 0) {
                                    i1110 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i1110 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda17, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i119 & 112) | (i119 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier110;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource110;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1112 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume111111113 = composerStartRestartGroup.consume(localContentColor1112);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
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
                            if ((i2 & 256) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM979getPrimary0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1113 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume111111114 = composerStartRestartGroup.consume(localContentColor1113);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i3 &= -1879048193;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda18 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i1110) {
                                ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                                if ((i1110 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        }) : null;
                        if (function3 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        Modifier modifierM464size3ABfNKs18 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                        Alignment center18 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy18 = BoxKt.rememberBoxMeasurePolicy(center18, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111115 = composerStartRestartGroup.consume(localDensity18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density18 = (Density) objConsume111111115;
                        Modifier modifier111 = companion;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111116 = composerStartRestartGroup.consume(localLayoutDirection18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection18 = (LayoutDirection) objConsume111111116;
                        MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration18 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111117 = composerStartRestartGroup.consume(localViewConfiguration18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration18 = (ViewConfiguration) objConsume111111117;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf18 = LayoutKt.materializerOf(modifierM464size3ABfNKs18);
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
                        Composer composerM1286constructorimpl18 = Updater.m1286constructorimpl(composerStartRestartGroup);
                        Updater.m1293setimpl(composerM1286constructorimpl18, measurePolicyRememberBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl18, density18, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl18, layoutDirection18, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl18, viewConfiguration18, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf18.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-172871267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                        int i1110 = i3 >> 24;
                        m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                                invoke(f2.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f2, Composer composer2, int i1111) {
                                ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                                if ((i1111 & 14) == 0) {
                                    i1111 |= composer2.changed(f2) ? 4 : 2;
                                }
                                if ((i1111 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z5) {
                                        f2 = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda18, f2, composer2, (i3 >> 6) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i1110 & 112) | (i1110 & 14) | 3072 | ((i3 << 6) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier111;
                        z6 = z4;
                        function4 = function3;
                        z7 = z5;
                        mutableInteractionSource3 = mutableInteractionSource111;
                        j3 = jM979getPrimary0d7_KjU;
                        j4 = jM1630copywmQWz5c$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                        public final void invoke(Composer composer2, int i1111) {
                            NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111118 = composerStartRestartGroup.consume(localContentColor1114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111119 = composerStartRestartGroup.consume(localContentColor1115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda19 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1111) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1111 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs19 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center19 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy19 = BoxKt.rememberBoxMeasurePolicy(center19, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111110 = composerStartRestartGroup.consume(localDensity19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density19 = (Density) objConsume1111111110;
                    Modifier modifier112 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111 = composerStartRestartGroup.consume(localLayoutDirection19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection19 = (LayoutDirection) objConsume1111111111;
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration19 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111112 = composerStartRestartGroup.consume(localViewConfiguration19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration19 = (ViewConfiguration) objConsume1111111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf19 = LayoutKt.materializerOf(modifierM464size3ABfNKs19);
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
                    Composer composerM1286constructorimpl19 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl19, measurePolicyRememberBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl19, density19, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl19, layoutDirection19, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl19, viewConfiguration19, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf19.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1111 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1112) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1112 & 14) == 0) {
                                i1112 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1112 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda19, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1111 & 112) | (i1111 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier112;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource112;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111113 = composerStartRestartGroup.consume(localContentColor1116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111114 = composerStartRestartGroup.consume(localContentColor1117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda110 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1112) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1112 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs110 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center110 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy110 = BoxKt.rememberBoxMeasurePolicy(center110, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111115 = composerStartRestartGroup.consume(localDensity110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density110 = (Density) objConsume1111111115;
                    Modifier modifier113 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111116 = composerStartRestartGroup.consume(localLayoutDirection110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection110 = (LayoutDirection) objConsume1111111116;
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration110 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111117 = composerStartRestartGroup.consume(localViewConfiguration110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration110 = (ViewConfiguration) objConsume1111111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf110 = LayoutKt.materializerOf(modifierM464size3ABfNKs110);
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
                    Composer composerM1286constructorimpl110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl110, measurePolicyRememberBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl110, density110, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl110, layoutDirection110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl110, viewConfiguration110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1112 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1113) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1113 & 14) == 0) {
                                i1113 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1113 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda110, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1112 & 112) | (i1112 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier113;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource113;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i1113) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function2;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((3670016 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111118 = composerStartRestartGroup.consume(localContentColor1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111119 = composerStartRestartGroup.consume(localContentColor1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda111 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1113) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1113 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs111 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center111 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy111 = BoxKt.rememberBoxMeasurePolicy(center111, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111110 = composerStartRestartGroup.consume(localDensity111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111 = (Density) objConsume11111111110;
                    Modifier modifier114 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111111 = composerStartRestartGroup.consume(localLayoutDirection111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111 = (LayoutDirection) objConsume11111111111;
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111112 = composerStartRestartGroup.consume(localViewConfiguration111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111 = (ViewConfiguration) objConsume11111111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111 = LayoutKt.materializerOf(modifierM464size3ABfNKs111);
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
                    Composer composerM1286constructorimpl111 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl111, measurePolicyRememberBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl111, density111, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl111, layoutDirection111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl111, viewConfiguration111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1113 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1114) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1114 & 14) == 0) {
                                i1114 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1114 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda111, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1113 & 112) | (i1113 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier114;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource114;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111113 = composerStartRestartGroup.consume(localContentColor11110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111114 = composerStartRestartGroup.consume(localContentColor11111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda112 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1114) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1114 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs112 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center112 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy112 = BoxKt.rememberBoxMeasurePolicy(center112, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111115 = composerStartRestartGroup.consume(localDensity112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density112 = (Density) objConsume11111111115;
                    Modifier modifier115 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111116 = composerStartRestartGroup.consume(localLayoutDirection112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection112 = (LayoutDirection) objConsume11111111116;
                    MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration112 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111117 = composerStartRestartGroup.consume(localViewConfiguration112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration112 = (ViewConfiguration) objConsume11111111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf112 = LayoutKt.materializerOf(modifierM464size3ABfNKs112);
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
                    Composer composerM1286constructorimpl112 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl112, measurePolicyRememberBoxMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl112, density112, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl112, layoutDirection112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl112, viewConfiguration112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1114 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1115) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1115 & 14) == 0) {
                                i1115 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1115 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda112, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1114 & 112) | (i1114 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier115;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource115;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i1115) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 1879048192) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111118 = composerStartRestartGroup.consume(localContentColor11112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111119 = composerStartRestartGroup.consume(localContentColor11113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda113 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i1115) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i1115 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs113 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center113 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy113 = BoxKt.rememberBoxMeasurePolicy(center113, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111110 = composerStartRestartGroup.consume(localDensity113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density113 = (Density) objConsume111111111110;
                Modifier modifier116 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111 = composerStartRestartGroup.consume(localLayoutDirection113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection113 = (LayoutDirection) objConsume111111111111;
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration113 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111112 = composerStartRestartGroup.consume(localViewConfiguration113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration113 = (ViewConfiguration) objConsume111111111112;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf113 = LayoutKt.materializerOf(modifierM464size3ABfNKs113);
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
                Composer composerM1286constructorimpl113 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl113, measurePolicyRememberBoxMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl113, density113, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl113, layoutDirection113, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl113, viewConfiguration113, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf113.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i1115 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i1116) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i1116 & 14) == 0) {
                            i1116 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i1116 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda113, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i1115 & 112) | (i1115 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier116;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource116;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111113 = composerStartRestartGroup.consume(localContentColor11114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111114 = composerStartRestartGroup.consume(localContentColor11115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda114 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i1116) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i1116 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs114 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center114 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy114 = BoxKt.rememberBoxMeasurePolicy(center114, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111115 = composerStartRestartGroup.consume(localDensity114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density114 = (Density) objConsume111111111115;
                Modifier modifier117 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111116 = composerStartRestartGroup.consume(localLayoutDirection114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection114 = (LayoutDirection) objConsume111111111116;
                MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration114 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111117 = composerStartRestartGroup.consume(localViewConfiguration114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration114 = (ViewConfiguration) objConsume111111111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf114 = LayoutKt.materializerOf(modifierM464size3ABfNKs114);
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
                Composer composerM1286constructorimpl114 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl114, measurePolicyRememberBoxMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl114, density114, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl114, layoutDirection114, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl114, viewConfiguration114, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf114.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i1116 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i1117) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i1117 & 14) == 0) {
                            i1117 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i1117 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda114, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i1116 & 112) | (i1116 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier117;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource117;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                public final void invoke(Composer composer2, int i1117) {
                    NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        z4 = z2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changed(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((3670016 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 234881024) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 1879048192) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111118 = composerStartRestartGroup.consume(localContentColor11116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111119 = composerStartRestartGroup.consume(localContentColor11117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda115 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1117) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1117 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs115 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center115 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy115 = BoxKt.rememberBoxMeasurePolicy(center115, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111110 = composerStartRestartGroup.consume(localDensity115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density115 = (Density) objConsume1111111111110;
                    Modifier modifier118 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111 = composerStartRestartGroup.consume(localLayoutDirection115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection115 = (LayoutDirection) objConsume1111111111111;
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration115 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111112 = composerStartRestartGroup.consume(localViewConfiguration115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration115 = (ViewConfiguration) objConsume1111111111112;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf115 = LayoutKt.materializerOf(modifierM464size3ABfNKs115);
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
                    Composer composerM1286constructorimpl115 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl115, measurePolicyRememberBoxMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl115, density115, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl115, layoutDirection115, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl115, viewConfiguration115, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf115.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1117 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1118) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1118 & 14) == 0) {
                                i1118 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1118 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda115, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1117 & 112) | (i1117 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier118;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource118;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111111113 = composerStartRestartGroup.consume(localContentColor11118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
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
                        if ((i2 & 256) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM979getPrimary0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111111114 = composerStartRestartGroup.consume(localContentColor11119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -1879048193;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda116 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i1118) {
                            ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                            if ((i1118 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    }) : null;
                    if (function3 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    Modifier modifierM464size3ABfNKs116 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                    Alignment center116 = Alignment.INSTANCE.getCenter();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy116 = BoxKt.rememberBoxMeasurePolicy(center116, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111115 = composerStartRestartGroup.consume(localDensity116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density116 = (Density) objConsume1111111111115;
                    Modifier modifier119 = companion;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111116 = composerStartRestartGroup.consume(localLayoutDirection116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection116 = (LayoutDirection) objConsume1111111111116;
                    MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource2;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration116 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111117 = composerStartRestartGroup.consume(localViewConfiguration116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration116 = (ViewConfiguration) objConsume1111111111117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf116 = LayoutKt.materializerOf(modifierM464size3ABfNKs116);
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
                    Composer composerM1286constructorimpl116 = Updater.m1286constructorimpl(composerStartRestartGroup);
                    Updater.m1293setimpl(composerM1286constructorimpl116, measurePolicyRememberBoxMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl116, density116, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl116, layoutDirection116, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl116, viewConfiguration116, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf116.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-172871267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                    int i1118 = i3 >> 24;
                    m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                            invoke(f2.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2, Composer composer2, int i1119) {
                            ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                            if ((i1119 & 14) == 0) {
                                i1119 |= composer2.changed(f2) ? 4 : 2;
                            }
                            if ((i1119 & 91) != 18 || !composer2.getSkipping()) {
                                if (z5) {
                                    f2 = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda116, f2, composer2, (i3 >> 6) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i1118 & 112) | (i1118 & 14) | 3072 | ((i3 << 6) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier119;
                    z6 = z4;
                    function4 = function3;
                    z7 = z5;
                    mutableInteractionSource3 = mutableInteractionSource119;
                    j3 = jM979getPrimary0d7_KjU;
                    j4 = jM1630copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                    public final void invoke(Composer composer2, int i1119) {
                        NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 1879048192) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111118 = composerStartRestartGroup.consume(localContentColor111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111119 = composerStartRestartGroup.consume(localContentColor111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda117 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i1119) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i1119 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs117 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center117 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy117 = BoxKt.rememberBoxMeasurePolicy(center117, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111110 = composerStartRestartGroup.consume(localDensity117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density117 = (Density) objConsume11111111111110;
                Modifier modifier1110 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111111 = composerStartRestartGroup.consume(localLayoutDirection117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection117 = (LayoutDirection) objConsume11111111111111;
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration117 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111112 = composerStartRestartGroup.consume(localViewConfiguration117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration117 = (ViewConfiguration) objConsume11111111111112;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf117 = LayoutKt.materializerOf(modifierM464size3ABfNKs117);
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
                Composer composerM1286constructorimpl117 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl117, measurePolicyRememberBoxMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl117, density117, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl117, layoutDirection117, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl117, viewConfiguration117, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf117.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i1119 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i11110) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i11110 & 14) == 0) {
                            i11110 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i11110 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda117, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i1119 & 112) | (i1119 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1110;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource1110;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111113 = composerStartRestartGroup.consume(localContentColor111112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111114 = composerStartRestartGroup.consume(localContentColor111113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda118 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i11110) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i11110 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs118 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center118 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy118 = BoxKt.rememberBoxMeasurePolicy(center118, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111115 = composerStartRestartGroup.consume(localDensity118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density118 = (Density) objConsume11111111111115;
                Modifier modifier1111 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111116 = composerStartRestartGroup.consume(localLayoutDirection118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection118 = (LayoutDirection) objConsume11111111111116;
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration118 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111117 = composerStartRestartGroup.consume(localViewConfiguration118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration118 = (ViewConfiguration) objConsume11111111111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf118 = LayoutKt.materializerOf(modifierM464size3ABfNKs118);
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
                Composer composerM1286constructorimpl118 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl118, measurePolicyRememberBoxMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl118, density118, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl118, layoutDirection118, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl118, viewConfiguration118, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf118.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i11110 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i11111) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i11111 & 14) == 0) {
                            i11111 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i11111 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda118, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i11110 & 112) | (i11110 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1111;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource1111;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                public final void invoke(Composer composer2, int i11111) {
                    NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3 = function2;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((3670016 & i) == 0) {
                z5 = z3;
                if (composerStartRestartGroup.changed(z5)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 234881024) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 1879048192) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111118 = composerStartRestartGroup.consume(localContentColor111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111119 = composerStartRestartGroup.consume(localContentColor111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume11111111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda119 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i11111) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i11111 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs119 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center119 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy119 = BoxKt.rememberBoxMeasurePolicy(center119, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111110 = composerStartRestartGroup.consume(localDensity119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density119 = (Density) objConsume111111111111110;
                Modifier modifier1112 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111111 = composerStartRestartGroup.consume(localLayoutDirection119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection119 = (LayoutDirection) objConsume111111111111111;
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration119 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111112 = composerStartRestartGroup.consume(localViewConfiguration119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration119 = (ViewConfiguration) objConsume111111111111112;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf119 = LayoutKt.materializerOf(modifierM464size3ABfNKs119);
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
                Composer composerM1286constructorimpl119 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl119, measurePolicyRememberBoxMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl119, density119, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl119, layoutDirection119, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl119, viewConfiguration119, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf119.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i11111 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i11112) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i11112 & 14) == 0) {
                            i11112 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i11112 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda119, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i11111 & 112) | (i11111 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1112;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource1112;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111113 = composerStartRestartGroup.consume(localContentColor111116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
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
                    if ((i2 & 256) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM979getPrimary0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111114 = composerStartRestartGroup.consume(localContentColor111117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -1879048193;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> composableLambda1110 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i11112) {
                        ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                        if ((i11112 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                }) : null;
                if (function3 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                Modifier modifierM464size3ABfNKs1110 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
                Alignment center1110 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1110 = BoxKt.rememberBoxMeasurePolicy(center1110, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111115 = composerStartRestartGroup.consume(localDensity1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density1110 = (Density) objConsume111111111111115;
                Modifier modifier1113 = companion;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111116 = composerStartRestartGroup.consume(localLayoutDirection1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection1110 = (LayoutDirection) objConsume111111111111116;
                MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1110 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111117 = composerStartRestartGroup.consume(localViewConfiguration1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration1110 = (ViewConfiguration) objConsume111111111111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1110 = LayoutKt.materializerOf(modifierM464size3ABfNKs1110);
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
                Composer composerM1286constructorimpl1110 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl1110, measurePolicyRememberBoxMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl1110, density1110, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl1110, layoutDirection1110, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl1110, viewConfiguration1110, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf1110.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-172871267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
                int i11112 = i3 >> 24;
                m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                        invoke(f2.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, Composer composer2, int i11113) {
                        ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                        if ((i11113 & 14) == 0) {
                            i11113 |= composer2.changed(f2) ? 4 : 2;
                        }
                        if ((i11113 & 91) != 18 || !composer2.getSkipping()) {
                            if (z5) {
                                f2 = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda1110, f2, composer2, (i3 >> 6) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i11112 & 112) | (i11112 & 14) | 3072 | ((i3 << 6) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1113;
                z6 = z4;
                function4 = function3;
                z7 = z5;
                mutableInteractionSource3 = mutableInteractionSource1113;
                j3 = jM979getPrimary0d7_KjU;
                j4 = jM1630copywmQWz5c$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                public final void invoke(Composer composer2, int i11113) {
                    NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 1572864;
        z5 = z3;
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i & 234881024) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
        }
        if ((i & 1879048192) != 0) {
            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : 536870912;
        }
        if ((i3 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
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
                if ((i2 & 256) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor111118 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111118 = composerStartRestartGroup.consume(localContentColor111118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111111118).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
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
                if ((i2 & 256) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor111119 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111119 = composerStartRestartGroup.consume(localContentColor111119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume111111111111119).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            final Function2<? super Composer, ? super Integer, Unit> composableLambda1111 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                public final void invoke(Composer composer2, int i11113) {
                    ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                    if ((i11113 & 11) != 2 || !composer2.getSkipping()) {
                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                    } else {
                        composer2.skipToGroupEnd();
                    }
                }
            }) : null;
            if (function3 == null) {
                f = NavigationRailItemCompactSize;
            } else {
                f = NavigationRailItemSize;
            }
            Modifier modifierM464size3ABfNKs1111 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
            Alignment center1111 = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1111 = BoxKt.rememberBoxMeasurePolicy(center1111, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111110 = composerStartRestartGroup.consume(localDensity1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1111 = (Density) objConsume1111111111111110;
            Modifier modifier1114 = companion;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111111 = composerStartRestartGroup.consume(localLayoutDirection1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1111 = (LayoutDirection) objConsume1111111111111111;
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111112 = composerStartRestartGroup.consume(localViewConfiguration1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1111 = (ViewConfiguration) objConsume1111111111111112;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111 = LayoutKt.materializerOf(modifierM464size3ABfNKs1111);
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
            Composer composerM1286constructorimpl1111 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1111, measurePolicyRememberBoxMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl1111, density1111, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl1111, layoutDirection1111, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl1111, viewConfiguration1111, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf1111.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-172871267);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
            int i11113 = i3 >> 24;
            m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                    invoke(f2.floatValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f2, Composer composer2, int i11114) {
                    ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                    if ((i11114 & 14) == 0) {
                        i11114 |= composer2.changed(f2) ? 4 : 2;
                    }
                    if ((i11114 & 91) != 18 || !composer2.getSkipping()) {
                        if (z5) {
                            f2 = 1.0f;
                        }
                        NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda1111, f2, composer2, (i3 >> 6) & 14);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i11113 & 112) | (i11113 & 14) | 3072 | ((i3 << 6) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier3 = modifier1114;
            z6 = z4;
            function4 = function3;
            z7 = z5;
            mutableInteractionSource3 = mutableInteractionSource1114;
            j3 = jM979getPrimary0d7_KjU;
            j4 = jM1630copywmQWz5c$default;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
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
                if ((i2 & 256) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111110 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111113 = composerStartRestartGroup.consume(localContentColor1111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111111113).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
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
                if ((i2 & 256) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m979getPrimary0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111111 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111114 = composerStartRestartGroup.consume(localContentColor1111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(((Color) objConsume1111111111111114).m1641unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -1879048193;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            final Function2<? super Composer, ? super Integer, Unit> composableLambda1112 = function3 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                public final void invoke(Composer composer2, int i11114) {
                    ComposerKt.sourceInformation(composer2, "C160@7258L10,161@7324L40:NavigationRail.kt#jmzs0o");
                    if ((i11114 & 11) != 2 || !composer2.getSkipping()) {
                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i3 >> 12) & 112);
                    } else {
                        composer2.skipToGroupEnd();
                    }
                }
            }) : null;
            if (function3 == null) {
                f = NavigationRailItemCompactSize;
            } else {
                f = NavigationRailItemSize;
            }
            Modifier modifierM464size3ABfNKs1112 = SizeKt.m464size3ABfNKs(SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM979getPrimary0d7_KjU, composerStartRestartGroup, ((i3 >> 18) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), f);
            Alignment center1112 = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1112 = BoxKt.rememberBoxMeasurePolicy(center1112, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1112 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111115 = composerStartRestartGroup.consume(localDensity1112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1112 = (Density) objConsume1111111111111115;
            Modifier modifier1115 = companion;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1112 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111116 = composerStartRestartGroup.consume(localLayoutDirection1112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1112 = (LayoutDirection) objConsume1111111111111116;
            MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1112 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111117 = composerStartRestartGroup.consume(localViewConfiguration1112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1112 = (ViewConfiguration) objConsume1111111111111117;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1112 = LayoutKt.materializerOf(modifierM464size3ABfNKs1112);
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
            Composer composerM1286constructorimpl1112 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl1112, measurePolicyRememberBoxMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl1112, density1112, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl1112, layoutDirection1112, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl1112, viewConfiguration1112, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf1112.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-172871267);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C187@8378L417:NavigationRail.kt#jmzs0o");
            int i11114 = i3 >> 24;
            m1102NavigationRailTransitionKlgxPg(jM979getPrimary0d7_KjU, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f2, Composer composer2, Integer num) {
                    invoke(f2.floatValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f2, Composer composer2, int i11115) {
                    ComposerKt.sourceInformation(composer2, "C194@8606L179:NavigationRail.kt#jmzs0o");
                    if ((i11115 & 14) == 0) {
                        i11115 |= composer2.changed(f2) ? 4 : 2;
                    }
                    if ((i11115 & 91) != 18 || !composer2.getSkipping()) {
                        if (z5) {
                            f2 = 1.0f;
                        }
                        NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda1112, f2, composer2, (i3 >> 6) & 14);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i11114 & 112) | (i11114 & 14) | 3072 | ((i3 << 6) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier3 = modifier1115;
            z6 = z4;
            function4 = function3;
            z7 = z5;
            mutableInteractionSource3 = mutableInteractionSource1115;
            j3 = jM979getPrimary0d7_KjU;
            j4 = jM1630copywmQWz5c$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

            public final void invoke(Composer composer2, int i11115) {
                NavigationRailKt.m1101NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function4, z7, mutableInteractionSource3, j3, j4, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1102NavigationRailTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-207161906);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)232@9909L126,239@10110L181:NavigationRail.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        final int i3 = i2;
        if ((i3 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, composerStartRestartGroup, 48, 12);
            long jM1683lerpjxsXWHM = ColorKt.m1683lerpjxsXWHM(j2, j, m1103NavigationRailTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(Color.m1630copywmQWz5c$default(jM1683lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(jM1683lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1688205042, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$1
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
                    ComposerKt.sourceInformation(composer2, "C243@10259L26:NavigationRail.kt#jmzs0o");
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        function3.invoke(Float.valueOf(NavigationRailKt.m1103NavigationRailTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState)), composer2, Integer.valueOf((i3 >> 6) & 112));
                    }
                }
            }), composerStartRestartGroup, 56);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$2
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
                NavigationRailKt.m1102NavigationRailTransitionKlgxPg(j, j2, z, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1903861684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemBaselineLayout)P(!1,2)264@10960L1118:NavigationRail.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    Placeable placeableMo3124measureBRTryo0;
                    Measurable measurable;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable2 : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                            Placeable placeableMo3124measureBRTryo1 = measurable2.mo3124measureBRTryo0(j);
                            if (function3 != null) {
                                Iterator<T> it = list.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    measurable = (Measurable) it.next();
                                } while (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "label"));
                                placeableMo3124measureBRTryo0 = measurable.mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                            } else {
                                placeableMo3124measureBRTryo0 = null;
                            }
                            if (function3 == null) {
                                return NavigationRailKt.m1108placeIcon3p2s80s(Layout, placeableMo3124measureBRTryo1, j);
                            }
                            Intrinsics.checkNotNull(placeableMo3124measureBRTryo0);
                            return NavigationRailKt.m1109placeLabelAndIconDIyivk0(Layout, placeableMo3124measureBRTryo0, placeableMo3124measureBRTryo1, j, f);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
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
            composerStartRestartGroup.startReplaceableGroup(1943278197);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C266@10990L41,268@11081L168:NavigationRail.kt#jmzs0o");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density2 = (Density) objConsume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierLayoutId);
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
            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1405563567);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C266@11023L6:NavigationRail.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (function3 != null) {
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density3 = (Density) objConsume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierAlpha);
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
                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(2107148020);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C272@11240L7:NavigationRail.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout.3
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
                NavigationRailKt.NavigationRailItemBaselineLayout(function2, function3, f, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1108placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        final int iMax = Math.max(0, (Constraints.m3799getMaxWidthimpl(j) - placeable.getWidth()) / 2);
        final int iMax2 = Math.max(0, (Constraints.m3798getMaxHeightimpl(j) - placeable.getHeight()) / 2);
        return MeasureScope.layout$default(measureScope, Constraints.m3799getMaxWidthimpl(j), Constraints.m3798getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(layout, placeable, iMax, iMax2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1109placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        final int iM3798getMaxHeightimpl = (Constraints.m3798getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo312roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        final int iM3799getMaxWidthimpl = (Constraints.m3799getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        final int i = measureScope.mo312roundToPx0680j_4(ItemIconTopOffset);
        int iM3798getMaxHeightimpl2 = (Constraints.m3798getMaxHeightimpl(j) - placeable2.getHeight()) / 2;
        final int iM3799getMaxWidthimpl2 = (Constraints.m3799getMaxWidthimpl(j) - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((iM3798getMaxHeightimpl2 - i) * (1 - f));
        return MeasureScope.layout$default(measureScope, Constraints.m3799getMaxWidthimpl(j), Constraints.m3798getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeLabelAndIcon$1
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
                if (f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, iM3799getMaxWidthimpl, iM3798getMaxHeightimpl + iRoundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM3799getMaxWidthimpl2, i + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 8;
        NavigationRailPadding = Dp.m3843constructorimpl(f);
        HeaderPadding = Dp.m3843constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationRailTransition_Klgx_Pg$lambda-3, reason: not valid java name */
    public static final float m1103NavigationRailTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
