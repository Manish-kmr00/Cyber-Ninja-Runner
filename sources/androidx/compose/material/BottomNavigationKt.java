package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = Dp.m3843constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;

    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d5 A[PHI: r1 r3 r4 r9
  0x00d5: PHI (r1v8 androidx.compose.ui.Modifier) = (r1v4 androidx.compose.ui.Modifier), (r1v11 androidx.compose.ui.Modifier) binds: [B:84:0x0103, B:72:0x00d4] A[DONT_GENERATE, DONT_INLINE]
  0x00d5: PHI (r3v18 int) = (r3v14 int), (r3v20 int) binds: [B:84:0x0103, B:72:0x00d4] A[DONT_GENERATE, DONT_INLINE]
  0x00d5: PHI (r4v7 long) = (r4v3 long), (r4v2 long) binds: [B:84:0x0103, B:72:0x00d4] A[DONT_GENERATE, DONT_INLINE]
  0x00d5: PHI (r9v9 long) = (r9v2 long), (r9v1 long) binds: [B:84:0x0103, B:72:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x0105  */
    /* JADX WARN: Code duplicated, block: B:90:0x014e  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m908BottomNavigationPEIptTM(Modifier modifier, long j, long j2, float f, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long primarySurface;
        long jM997contentColorForek8zF_U;
        float f2;
        int i4;
        final Modifier.Companion companion;
        final float fM907getElevationD9Ej5fM;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)91@4097L6,92@4146L32,96@4289L403:BottomNavigation.kt#jmzs0o");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                primarySurface = j;
                int i6 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i6;
            } else {
                primarySurface = j;
            }
            i3 |= i6;
        } else {
            primarySurface = j;
        }
        if ((i & 896) == 0) {
            jM997contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM997contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM997contentColorForek8zF_U = j2;
        }
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 7168) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                } else {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        fM907getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m907getElevationD9Ej5fM();
                    }
                    long j5 = jM997contentColorForek8zF_U;
                    final int i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    int i9 = i8 << 3;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, null, primarySurface, j5, null, fM907getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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

                        public final void invoke(Composer composer2, int i10) {
                            ComposerKt.sourceInformation(composer2, "C102@4443L243:BottomNavigation.kt#jmzs0o");
                            if ((i10 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                int i11 = ((i8 >> 3) & 7168) | 48;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, 6);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                function3.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i11 >> 6) & 112) | 6));
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 1572864 | (i9 & 896) | (i9 & 7168) | ((i8 << 6) & 458752), 18);
                    j3 = primarySurface;
                    j4 = j5;
                }
                fM907getElevationD9Ej5fM = f2;
                long j6 = jM997contentColorForek8zF_U;
                final int i10 = i3;
                composerStartRestartGroup.endDefaults();
                int i11 = i10 << 3;
                SurfaceKt.m1175SurfaceFjzlyU(companion, null, primarySurface, j6, null, fM907getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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

                    public final void invoke(Composer composer2, int i12) {
                        ComposerKt.sourceInformation(composer2, "C102@4443L243:BottomNavigation.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            Function3<RowScope, Composer, Integer, Unit> function3 = content;
                            int i13 = ((i10 >> 3) & 7168) | 48;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, 6);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            function3.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i13 >> 6) & 112) | 6));
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i10 & 14) | 1572864 | (i11 & 896) | (i11 & 7168) | ((i10 << 6) & 458752), 18);
                j3 = primarySurface;
                j4 = j6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                j3 = primarySurface;
                j4 = jM997contentColorForek8zF_U;
                fM907getElevationD9Ej5fM = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$2
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

                public final void invoke(Composer composer2, int i12) {
                    BottomNavigationKt.m908BottomNavigationPEIptTM(companion, j3, j4, fM907getElevationD9Ej5fM, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        f2 = f;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((46811 & i3) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    fM907getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m907getElevationD9Ej5fM();
                } else {
                    fM907getElevationD9Ej5fM = f2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    fM907getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m907getElevationD9Ej5fM();
                } else {
                    fM907getElevationD9Ej5fM = f2;
                }
            }
            long j7 = jM997contentColorForek8zF_U;
            final int i12 = i3;
            composerStartRestartGroup.endDefaults();
            int i13 = i12 << 3;
            SurfaceKt.m1175SurfaceFjzlyU(companion, null, primarySurface, j7, null, fM907getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                    ComposerKt.sourceInformation(composer2, "C102@4443L243:BottomNavigation.kt#jmzs0o");
                    if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        int i15 = ((i12 >> 3) & 7168) | 48;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, 6);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                        function3.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i15 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i12 & 14) | 1572864 | (i13 & 896) | (i13 & 7168) | ((i12 << 6) & 458752), 18);
            j3 = primarySurface;
            j4 = j7;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    fM907getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m907getElevationD9Ej5fM();
                } else {
                    fM907getElevationD9Ej5fM = f2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    fM907getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m907getElevationD9Ej5fM();
                } else {
                    fM907getElevationD9Ej5fM = f2;
                }
            }
            long j8 = jM997contentColorForek8zF_U;
            final int i14 = i3;
            composerStartRestartGroup.endDefaults();
            int i15 = i14 << 3;
            SurfaceKt.m1175SurfaceFjzlyU(companion, null, primarySurface, j8, null, fM907getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                    ComposerKt.sourceInformation(composer2, "C102@4443L243:BottomNavigation.kt#jmzs0o");
                    if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m450height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        int i17 = ((i14 >> 3) & 7168) | 48;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, 6);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                        function3.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i17 >> 6) & 112) | 6));
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i14 & 14) | 1572864 | (i15 & 896) | (i15 & 7168) | ((i14 << 6) & 458752), 18);
            j3 = primarySurface;
            j4 = j8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$2
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
                BottomNavigationKt.m908BottomNavigationPEIptTM(companion, j3, j4, fM907getElevationD9Ej5fM, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0130  */
    /* JADX WARN: Code duplicated, block: B:104:0x0139  */
    /* JADX WARN: Code duplicated, block: B:106:0x013d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x0149  */
    /* JADX WARN: Code duplicated, block: B:114:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x0155  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:125:0x0180  */
    /* JADX WARN: Code duplicated, block: B:127:0x018c  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x01af  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:146:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01da  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:156:0x0209  */
    /* JADX WARN: Code duplicated, block: B:159:0x020f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0235  */
    /* JADX WARN: Code duplicated, block: B:163:0x023c  */
    /* JADX WARN: Code duplicated, block: B:164:0x024c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0314  */
    /* JADX WARN: Code duplicated, block: B:170:0x0320  */
    /* JADX WARN: Code duplicated, block: B:171:0x0324  */
    /* JADX WARN: Code duplicated, block: B:176:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:58:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00da  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:85:0x0100  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:90:0x010f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0117  */
    /* JADX WARN: Code duplicated, block: B:94:0x011d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0120  */
    /* JADX WARN: Code duplicated, block: B:99:0x012a  */
    /* JADX INFO: renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m909BottomNavigationItemjY6E1Zs(final RowScope BottomNavigationItem, final boolean z, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2, final int i3) {
        final int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        boolean z4;
        int i10;
        int i11;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        int i12;
        int i13;
        boolean z5;
        int i14;
        int i15;
        int i16;
        int i17;
        Modifier.Companion companion;
        final boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        long jM1641unboximpl;
        long jM1630copywmQWz5c$default;
        Object objRememberedValue;
        final ComposableLambda composableLambda;
        Function0<ComposeUiNode> constructor;
        final Modifier modifier3;
        final long j3;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final long j4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i18;
        int i19;
        Intrinsics.checkNotNullParameter(BottomNavigationItem, "$this$BottomNavigationItem");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@7016L39,155@7109L7,156@7201L6,167@7704L61,169@7771L804:BottomNavigation.kt#jmzs0o");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(BottomNavigationItem) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) == 0) {
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
            }
            if ((i3 & 2) != 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(onClick)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i4 |= i5;
            }
            if ((i3 & 4) != 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(icon)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((57344 & i) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((458752 & i) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        if ((3670016 & i) == 0) {
                            function3 = function2;
                            if (composerStartRestartGroup.changed(function3)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i4 |= i12;
                        }
                        i13 = i3 & 64;
                        if (i13 != 0) {
                            i4 |= 12582912;
                            z5 = z3;
                        } else {
                            z5 = z3;
                            if ((i & 29360128) == 0) {
                                if (composerStartRestartGroup.changed(z5)) {
                                    i14 = 8388608;
                                } else {
                                    i14 = 4194304;
                                }
                                i4 |= i14;
                            }
                        }
                        i15 = i3 & 128;
                        if (i15 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i16 = 67108864;
                            } else {
                                i16 = 33554432;
                            }
                            i4 |= i16;
                        }
                        if ((i & 1879048192) != 0) {
                            if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j)) {
                                i19 = 268435456;
                            } else {
                                i19 = 536870912;
                            }
                            i4 |= i19;
                        }
                        if ((i2 & 14) == 0) {
                            if ((i3 & 1024) == 0 || !composerStartRestartGroup.changed(j2)) {
                                i18 = 2;
                            } else {
                                i18 = 4;
                            }
                            i17 = i2 | i18;
                        } else {
                            i17 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378 || (i17 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i7 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i9 != 0) {
                                    z4 = true;
                                }
                                if (i11 != 0) {
                                    function3 = null;
                                }
                                if (i13 != 0) {
                                    z6 = true;
                                } else {
                                    z6 = z3;
                                }
                                if (i15 != 0) {
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
                                if ((i3 & 256) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM1641unboximpl = ((Color) objConsume).m1641unboximpl();
                                    i4 &= -1879048193;
                                } else {
                                    jM1641unboximpl = j;
                                }
                                if ((i3 & 512) != 0) {
                                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i17 &= -15;
                                } else {
                                    jM1630copywmQWz5c$default = j2;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 256) != 0) {
                                    i4 &= -1879048193;
                                }
                                if ((i3 & 512) != 0) {
                                    i17 &= -15;
                                }
                                z6 = z3;
                                mutableInteractionSource2 = mutableInteractionSource;
                                jM1630copywmQWz5c$default = j2;
                                companion = modifier2;
                                jM1641unboximpl = j;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (function3 != null) {
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                    public final void invoke(Composer composer2, int i20) {
                                        ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                });
                            } else {
                                composableLambda = null;
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Modifier modifier4 = companion;
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Density density = (Density) objConsume2;
                            boolean z8 = z4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                            Function2<? super Composer, ? super Integer, Unit> function5 = function3;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWeight$default);
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
                            composerStartRestartGroup.startReplaceableGroup(-1538530399);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                            m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                    invoke(f.floatValue(), composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f, Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 14) == 0) {
                                        i20 |= composer2.changed(f) ? 4 : 2;
                                    }
                                    if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                        if (z6) {
                                            f = 1.0f;
                                        }
                                        BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier3 = modifier4;
                            j3 = jM1641unboximpl;
                            z7 = z8;
                            function4 = function5;
                            j4 = jM1630copywmQWz5c$default;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z6 = z5;
                            modifier3 = modifier2;
                            z7 = z4;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                            public final void invoke(Composer composer2, int i20) {
                                BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                            }
                        });
                    }
                    i4 |= 1572864;
                    function3 = function2;
                    i13 = i3 & 64;
                    if (i13 != 0) {
                        i4 |= 12582912;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(z5)) {
                                i14 = 8388608;
                            } else {
                                i14 = 4194304;
                            }
                            i4 |= i14;
                        }
                    }
                    i15 = i3 & 128;
                    if (i15 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                        i4 |= i16;
                    }
                    if ((i & 1879048192) != 0) {
                        if ((i3 & 512) == 0) {
                            i19 = 268435456;
                        } else {
                            i19 = 268435456;
                        }
                        i4 |= i19;
                    }
                    if ((i2 & 14) == 0) {
                        if ((i3 & 1024) == 0) {
                            i18 = 2;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composerStartRestartGroup.consume(localContentColor2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume5).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localContentColor3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume6).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default2 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        Modifier modifier5 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density2 = (Density) objConsume7;
                        boolean z9 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection2 = (LayoutDirection) objConsume8;
                        Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume9;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default2);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier5;
                        j3 = jM1641unboximpl;
                        z7 = z9;
                        function4 = function6;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume10 = composerStartRestartGroup.consume(localContentColor4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume10).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11 = composerStartRestartGroup.consume(localContentColor5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume11).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default3 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        Modifier modifier6 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density3 = (Density) objConsume12;
                        boolean z10 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume13;
                        Function2<? super Composer, ? super Integer, Unit> function7 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume14 = composerStartRestartGroup.consume(localViewConfiguration3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume14;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWeight$default3);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier6;
                        j3 = jM1641unboximpl;
                        z7 = z10;
                        function4 = function7;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                        public final void invoke(Composer composer2, int i20) {
                            BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                        }
                    });
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z4 = z2;
                i11 = i3 & 32;
                if (i11 != 0) {
                    if ((3670016 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changed(function3)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 64;
                    if (i13 != 0) {
                        i4 |= 12582912;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(z5)) {
                                i14 = 8388608;
                            } else {
                                i14 = 4194304;
                            }
                            i4 |= i14;
                        }
                    }
                    i15 = i3 & 128;
                    if (i15 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                        i4 |= i16;
                    }
                    if ((i & 1879048192) != 0) {
                        if ((i3 & 512) == 0) {
                            i19 = 268435456;
                        } else {
                            i19 = 268435456;
                        }
                        i4 |= i19;
                    }
                    if ((i2 & 14) == 0) {
                        if ((i3 & 1024) == 0) {
                            i18 = 2;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume15 = composerStartRestartGroup.consume(localContentColor6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume15).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume16 = composerStartRestartGroup.consume(localContentColor7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume16).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default4 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center4 = Alignment.INSTANCE.getCenter();
                        Modifier modifier7 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center4, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density4 = (Density) objConsume17;
                        boolean z11 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection4 = (LayoutDirection) objConsume18;
                        Function2<? super Composer, ? super Integer, Unit> function8 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localViewConfiguration4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume19;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWeight$default4);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier7;
                        j3 = jM1641unboximpl;
                        z7 = z11;
                        function4 = function8;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource7;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume110 = composerStartRestartGroup.consume(localContentColor8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume110).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume111 = composerStartRestartGroup.consume(localContentColor9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume111).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default5 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center5 = Alignment.INSTANCE.getCenter();
                        Modifier modifier8 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center5, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume112 = composerStartRestartGroup.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density5 = (Density) objConsume112;
                        boolean z12 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume113 = composerStartRestartGroup.consume(localLayoutDirection5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection5 = (LayoutDirection) objConsume113;
                        Function2<? super Composer, ? super Integer, Unit> function9 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume114 = composerStartRestartGroup.consume(localViewConfiguration5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume114;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierWeight$default5);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier8;
                        j3 = jM1641unboximpl;
                        z7 = z12;
                        function4 = function9;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                        public final void invoke(Composer composer2, int i20) {
                            BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function3 = function2;
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume115 = composerStartRestartGroup.consume(localContentColor10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localContentColor11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default6 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center6 = Alignment.INSTANCE.getCenter();
                    Modifier modifier9 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(center6, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume117 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density6 = (Density) objConsume117;
                    boolean z13 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume118 = composerStartRestartGroup.consume(localLayoutDirection6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection6 = (LayoutDirection) objConsume118;
                    Function2<? super Composer, ? super Integer, Unit> function10 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume119 = composerStartRestartGroup.consume(localViewConfiguration6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierWeight$default6);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier9;
                    j3 = jM1641unboximpl;
                    z7 = z13;
                    function4 = function10;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1110 = composerStartRestartGroup.consume(localContentColor12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111 = composerStartRestartGroup.consume(localContentColor13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default7 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    Modifier modifier10 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(center7, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1112 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density7 = (Density) objConsume1112;
                    boolean z14 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1113 = composerStartRestartGroup.consume(localLayoutDirection7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection7 = (LayoutDirection) objConsume1113;
                    Function2<? super Composer, ? super Integer, Unit> function11 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1114 = composerStartRestartGroup.consume(localViewConfiguration7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) objConsume1114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierWeight$default7);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier10;
                    j3 = jM1641unboximpl;
                    z7 = z14;
                    function4 = function11;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 24576;
            modifier2 = modifier;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((458752 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    if ((3670016 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changed(function3)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 64;
                    if (i13 != 0) {
                        i4 |= 12582912;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(z5)) {
                                i14 = 8388608;
                            } else {
                                i14 = 4194304;
                            }
                            i4 |= i14;
                        }
                    }
                    i15 = i3 & 128;
                    if (i15 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                        i4 |= i16;
                    }
                    if ((i & 1879048192) != 0) {
                        if ((i3 & 512) == 0) {
                            i19 = 268435456;
                        } else {
                            i19 = 268435456;
                        }
                        i4 |= i19;
                    }
                    if ((i2 & 14) == 0) {
                        if ((i3 & 1024) == 0) {
                            i18 = 2;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1115 = composerStartRestartGroup.consume(localContentColor14);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume1115).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1116 = composerStartRestartGroup.consume(localContentColor15);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume1116).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default8 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center8 = Alignment.INSTANCE.getCenter();
                        Modifier modifier11 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(center8, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1117 = composerStartRestartGroup.consume(localDensity8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density8 = (Density) objConsume1117;
                        boolean z15 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1118 = composerStartRestartGroup.consume(localLayoutDirection8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection8 = (LayoutDirection) objConsume1118;
                        Function2<? super Composer, ? super Integer, Unit> function12 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1119 = composerStartRestartGroup.consume(localViewConfiguration8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration8 = (ViewConfiguration) objConsume1119;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierWeight$default8);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier11;
                        j3 = jM1641unboximpl;
                        z7 = z15;
                        function4 = function12;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11110 = composerStartRestartGroup.consume(localContentColor16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume11110).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11111 = composerStartRestartGroup.consume(localContentColor17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume11111).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default9 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center9 = Alignment.INSTANCE.getCenter();
                        Modifier modifier12 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(center9, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11112 = composerStartRestartGroup.consume(localDensity9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density9 = (Density) objConsume11112;
                        boolean z16 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11113 = composerStartRestartGroup.consume(localLayoutDirection9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection9 = (LayoutDirection) objConsume11113;
                        Function2<? super Composer, ? super Integer, Unit> function13 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration9 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11114 = composerStartRestartGroup.consume(localViewConfiguration9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration9 = (ViewConfiguration) objConsume11114;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierWeight$default9);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier12;
                        j3 = jM1641unboximpl;
                        z7 = z16;
                        function4 = function13;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                        public final void invoke(Composer composer2, int i20) {
                            BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function3 = function2;
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11115 = composerStartRestartGroup.consume(localContentColor18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume11115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11116 = composerStartRestartGroup.consume(localContentColor19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume11116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default10 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center10 = Alignment.INSTANCE.getCenter();
                    Modifier modifier13 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(center10, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11117 = composerStartRestartGroup.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density10 = (Density) objConsume11117;
                    boolean z17 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11118 = composerStartRestartGroup.consume(localLayoutDirection10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection10 = (LayoutDirection) objConsume11118;
                    Function2<? super Composer, ? super Integer, Unit> function14 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration10 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11119 = composerStartRestartGroup.consume(localViewConfiguration10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) objConsume11119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf10 = LayoutKt.materializerOf(modifierWeight$default10);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier13;
                    j3 = jM1641unboximpl;
                    z7 = z17;
                    function4 = function14;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localContentColor110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localContentColor111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default11 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    Modifier modifier14 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(center11, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111112 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11 = (Density) objConsume111112;
                    boolean z18 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111113 = composerStartRestartGroup.consume(localLayoutDirection11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection11 = (LayoutDirection) objConsume111113;
                    Function2<? super Composer, ? super Integer, Unit> function15 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111114 = composerStartRestartGroup.consume(localViewConfiguration11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration11 = (ViewConfiguration) objConsume111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11 = LayoutKt.materializerOf(modifierWeight$default11);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier14;
                    j3 = jM1641unboximpl;
                    z7 = z18;
                    function4 = function15;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            i11 = i3 & 32;
            if (i11 != 0) {
                if ((3670016 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changed(function3)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111115 = composerStartRestartGroup.consume(localContentColor112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111116 = composerStartRestartGroup.consume(localContentColor113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default12 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center12 = Alignment.INSTANCE.getCenter();
                    Modifier modifier15 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(center12, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111117 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density12 = (Density) objConsume111117;
                    boolean z19 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111118 = composerStartRestartGroup.consume(localLayoutDirection12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection12 = (LayoutDirection) objConsume111118;
                    Function2<? super Composer, ? super Integer, Unit> function16 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration12 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111119 = composerStartRestartGroup.consume(localViewConfiguration12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration12 = (ViewConfiguration) objConsume111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf12 = LayoutKt.materializerOf(modifierWeight$default12);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier15;
                    j3 = jM1641unboximpl;
                    z7 = z19;
                    function4 = function16;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource15;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111110 = composerStartRestartGroup.consume(localContentColor114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111 = composerStartRestartGroup.consume(localContentColor115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default13 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center13 = Alignment.INSTANCE.getCenter();
                    Modifier modifier16 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(center13, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111112 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density13 = (Density) objConsume1111112;
                    boolean z110 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111113 = composerStartRestartGroup.consume(localLayoutDirection13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection13 = (LayoutDirection) objConsume1111113;
                    Function2<? super Composer, ? super Integer, Unit> function17 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration13 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111114 = composerStartRestartGroup.consume(localViewConfiguration13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration13 = (ViewConfiguration) objConsume1111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf13 = LayoutKt.materializerOf(modifierWeight$default13);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier16;
                    j3 = jM1641unboximpl;
                    z7 = z110;
                    function4 = function17;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 1572864;
            function3 = function2;
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 12582912;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i14 = 8388608;
                    } else {
                        i14 = 4194304;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
                i4 |= i16;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i19 = 268435456;
                } else {
                    i19 = 268435456;
                }
                i4 |= i19;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i18 = 2;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111115 = composerStartRestartGroup.consume(localContentColor116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume1111115).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111116 = composerStartRestartGroup.consume(localContentColor117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume1111116).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default14 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center14 = Alignment.INSTANCE.getCenter();
                Modifier modifier17 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(center14, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111117 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density14 = (Density) objConsume1111117;
                boolean z111 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111118 = composerStartRestartGroup.consume(localLayoutDirection14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection14 = (LayoutDirection) objConsume1111118;
                Function2<? super Composer, ? super Integer, Unit> function18 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration14 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111119 = composerStartRestartGroup.consume(localViewConfiguration14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) objConsume1111119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf14 = LayoutKt.materializerOf(modifierWeight$default14);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier17;
                j3 = jM1641unboximpl;
                z7 = z111;
                function4 = function18;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111110 = composerStartRestartGroup.consume(localContentColor118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111110).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111 = composerStartRestartGroup.consume(localContentColor119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default15 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                Modifier modifier18 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(center15, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111112 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density15 = (Density) objConsume11111112;
                boolean z112 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111113 = composerStartRestartGroup.consume(localLayoutDirection15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection15 = (LayoutDirection) objConsume11111113;
                Function2<? super Composer, ? super Integer, Unit> function19 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration15 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111114 = composerStartRestartGroup.consume(localViewConfiguration15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration15 = (ViewConfiguration) objConsume11111114;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf15 = LayoutKt.materializerOf(modifierWeight$default15);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier18;
                j3 = jM1641unboximpl;
                z7 = z112;
                function4 = function19;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                public final void invoke(Composer composer2, int i20) {
                    BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                }
            });
        }
        i4 |= 48;
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changed(onClick)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i4 |= i5;
        }
        if ((i3 & 4) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(icon)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i4 |= i6;
        }
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((57344 & i) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((458752 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    if ((3670016 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changed(function3)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 64;
                    if (i13 != 0) {
                        i4 |= 12582912;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(z5)) {
                                i14 = 8388608;
                            } else {
                                i14 = 4194304;
                            }
                            i4 |= i14;
                        }
                    }
                    i15 = i3 & 128;
                    if (i15 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                        i4 |= i16;
                    }
                    if ((i & 1879048192) != 0) {
                        if ((i3 & 512) == 0) {
                            i19 = 268435456;
                        } else {
                            i19 = 268435456;
                        }
                        i4 |= i19;
                    }
                    if ((i2 & 14) == 0) {
                        if ((i3 & 1024) == 0) {
                            i18 = 2;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11111115 = composerStartRestartGroup.consume(localContentColor1110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume11111115).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11111116 = composerStartRestartGroup.consume(localContentColor1111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume11111116).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default16 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center16 = Alignment.INSTANCE.getCenter();
                        Modifier modifier19 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(center16, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111117 = composerStartRestartGroup.consume(localDensity16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density16 = (Density) objConsume11111117;
                        boolean z113 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111118 = composerStartRestartGroup.consume(localLayoutDirection16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection16 = (LayoutDirection) objConsume11111118;
                        Function2<? super Composer, ? super Integer, Unit> function110 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration16 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111119 = composerStartRestartGroup.consume(localViewConfiguration16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration16 = (ViewConfiguration) objConsume11111119;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf16 = LayoutKt.materializerOf(modifierWeight$default16);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier19;
                        j3 = jM1641unboximpl;
                        z7 = z113;
                        function4 = function110;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource19;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1112 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume111111110 = composerStartRestartGroup.consume(localContentColor1112);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume111111110).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i7 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                z4 = true;
                            }
                            if (i11 != 0) {
                                function3 = null;
                            }
                            if (i13 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i15 != 0) {
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
                            if ((i3 & 256) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1113 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume111111111 = composerStartRestartGroup.consume(localContentColor1113);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM1641unboximpl = ((Color) objConsume111111111).m1641unboximpl();
                                i4 &= -1879048193;
                            } else {
                                jM1641unboximpl = j;
                            }
                            if ((i3 & 512) != 0) {
                                jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i17 &= -15;
                            } else {
                                jM1630copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (function3 != null) {
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                public final void invoke(Composer composer2, int i20) {
                                    ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                        TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                    } else {
                                        composer2.skipToGroupEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda = null;
                        }
                        Modifier modifierWeight$default17 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center17 = Alignment.INSTANCE.getCenter();
                        Modifier modifier110 = companion;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource2;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy17 = BoxKt.rememberBoxMeasurePolicy(center17, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111112 = composerStartRestartGroup.consume(localDensity17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density17 = (Density) objConsume111111112;
                        boolean z114 = z4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111113 = composerStartRestartGroup.consume(localLayoutDirection17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LayoutDirection layoutDirection17 = (LayoutDirection) objConsume111111113;
                        Function2<? super Composer, ? super Integer, Unit> function111 = function3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration17 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111114 = composerStartRestartGroup.consume(localViewConfiguration17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ViewConfiguration viewConfiguration17 = (ViewConfiguration) objConsume111111114;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf17 = LayoutKt.materializerOf(modifierWeight$default17);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                        m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 14) == 0) {
                                    i20 |= composer2.changed(f) ? 4 : 2;
                                }
                                if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                    if (z6) {
                                        f = 1.0f;
                                    }
                                    BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier3 = modifier110;
                        j3 = jM1641unboximpl;
                        z7 = z114;
                        function4 = function111;
                        j4 = jM1630copywmQWz5c$default;
                        mutableInteractionSource3 = mutableInteractionSource110;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                        public final void invoke(Composer composer2, int i20) {
                            BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function3 = function2;
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111115 = composerStartRestartGroup.consume(localContentColor1114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111111115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111116 = composerStartRestartGroup.consume(localContentColor1115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111111116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default18 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center18 = Alignment.INSTANCE.getCenter();
                    Modifier modifier111 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy18 = BoxKt.rememberBoxMeasurePolicy(center18, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111117 = composerStartRestartGroup.consume(localDensity18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density18 = (Density) objConsume111111117;
                    boolean z115 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111118 = composerStartRestartGroup.consume(localLayoutDirection18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection18 = (LayoutDirection) objConsume111111118;
                    Function2<? super Composer, ? super Integer, Unit> function112 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration18 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111119 = composerStartRestartGroup.consume(localViewConfiguration18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration18 = (ViewConfiguration) objConsume111111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf18 = LayoutKt.materializerOf(modifierWeight$default18);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier111;
                    j3 = jM1641unboximpl;
                    z7 = z115;
                    function4 = function112;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111110 = composerStartRestartGroup.consume(localContentColor1116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111111 = composerStartRestartGroup.consume(localContentColor1117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default19 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center19 = Alignment.INSTANCE.getCenter();
                    Modifier modifier112 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy19 = BoxKt.rememberBoxMeasurePolicy(center19, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111112 = composerStartRestartGroup.consume(localDensity19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density19 = (Density) objConsume1111111112;
                    boolean z116 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111113 = composerStartRestartGroup.consume(localLayoutDirection19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection19 = (LayoutDirection) objConsume1111111113;
                    Function2<? super Composer, ? super Integer, Unit> function113 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration19 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111114 = composerStartRestartGroup.consume(localViewConfiguration19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration19 = (ViewConfiguration) objConsume1111111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf19 = LayoutKt.materializerOf(modifierWeight$default19);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier112;
                    j3 = jM1641unboximpl;
                    z7 = z116;
                    function4 = function113;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            i11 = i3 & 32;
            if (i11 != 0) {
                if ((3670016 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changed(function3)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111115 = composerStartRestartGroup.consume(localContentColor1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111116 = composerStartRestartGroup.consume(localContentColor1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default110 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center110 = Alignment.INSTANCE.getCenter();
                    Modifier modifier113 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy110 = BoxKt.rememberBoxMeasurePolicy(center110, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111117 = composerStartRestartGroup.consume(localDensity110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density110 = (Density) objConsume1111111117;
                    boolean z117 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111118 = composerStartRestartGroup.consume(localLayoutDirection110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection110 = (LayoutDirection) objConsume1111111118;
                    Function2<? super Composer, ? super Integer, Unit> function114 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration110 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111119 = composerStartRestartGroup.consume(localViewConfiguration110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration110 = (ViewConfiguration) objConsume1111111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf110 = LayoutKt.materializerOf(modifierWeight$default110);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier113;
                    j3 = jM1641unboximpl;
                    z7 = z117;
                    function4 = function114;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111110 = composerStartRestartGroup.consume(localContentColor11110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume11111111110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111111 = composerStartRestartGroup.consume(localContentColor11111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume11111111111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default111 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center111 = Alignment.INSTANCE.getCenter();
                    Modifier modifier114 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy111 = BoxKt.rememberBoxMeasurePolicy(center111, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111112 = composerStartRestartGroup.consume(localDensity111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density111 = (Density) objConsume11111111112;
                    boolean z118 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111113 = composerStartRestartGroup.consume(localLayoutDirection111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection111 = (LayoutDirection) objConsume11111111113;
                    Function2<? super Composer, ? super Integer, Unit> function115 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration111 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111114 = composerStartRestartGroup.consume(localViewConfiguration111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration111 = (ViewConfiguration) objConsume11111111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf111 = LayoutKt.materializerOf(modifierWeight$default111);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier114;
                    j3 = jM1641unboximpl;
                    z7 = z118;
                    function4 = function115;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 1572864;
            function3 = function2;
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 12582912;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i14 = 8388608;
                    } else {
                        i14 = 4194304;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
                i4 |= i16;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i19 = 268435456;
                } else {
                    i19 = 268435456;
                }
                i4 |= i19;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i18 = 2;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111115 = composerStartRestartGroup.consume(localContentColor11112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111115).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111116 = composerStartRestartGroup.consume(localContentColor11113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111116).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default112 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center112 = Alignment.INSTANCE.getCenter();
                Modifier modifier115 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy112 = BoxKt.rememberBoxMeasurePolicy(center112, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111117 = composerStartRestartGroup.consume(localDensity112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density112 = (Density) objConsume11111111117;
                boolean z119 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111118 = composerStartRestartGroup.consume(localLayoutDirection112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection112 = (LayoutDirection) objConsume11111111118;
                Function2<? super Composer, ? super Integer, Unit> function116 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration112 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111119 = composerStartRestartGroup.consume(localViewConfiguration112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration112 = (ViewConfiguration) objConsume11111111119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf112 = LayoutKt.materializerOf(modifierWeight$default112);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier115;
                j3 = jM1641unboximpl;
                z7 = z119;
                function4 = function116;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111110 = composerStartRestartGroup.consume(localContentColor11114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume111111111110).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111 = composerStartRestartGroup.consume(localContentColor11115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume111111111111).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default113 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center113 = Alignment.INSTANCE.getCenter();
                Modifier modifier116 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy113 = BoxKt.rememberBoxMeasurePolicy(center113, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111112 = composerStartRestartGroup.consume(localDensity113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density113 = (Density) objConsume111111111112;
                boolean z1110 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111113 = composerStartRestartGroup.consume(localLayoutDirection113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection113 = (LayoutDirection) objConsume111111111113;
                Function2<? super Composer, ? super Integer, Unit> function117 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration113 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111114 = composerStartRestartGroup.consume(localViewConfiguration113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration113 = (ViewConfiguration) objConsume111111111114;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf113 = LayoutKt.materializerOf(modifierWeight$default113);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier116;
                j3 = jM1641unboximpl;
                z7 = z1110;
                function4 = function117;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                public final void invoke(Composer composer2, int i20) {
                    BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                }
            });
        }
        i4 |= 24576;
        modifier2 = modifier;
        i9 = i3 & 16;
        if (i9 != 0) {
            if ((458752 & i) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i4 |= i10;
            }
            i11 = i3 & 32;
            if (i11 != 0) {
                if ((3670016 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changed(function3)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i14 = 8388608;
                        } else {
                            i14 = 4194304;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                    i4 |= i16;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0) {
                        i19 = 268435456;
                    } else {
                        i19 = 268435456;
                    }
                    i4 |= i19;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0) {
                        i18 = 2;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111115 = composerStartRestartGroup.consume(localContentColor11116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111111111115).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111116 = composerStartRestartGroup.consume(localContentColor11117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume111111111116).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default114 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center114 = Alignment.INSTANCE.getCenter();
                    Modifier modifier117 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy114 = BoxKt.rememberBoxMeasurePolicy(center114, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111117 = composerStartRestartGroup.consume(localDensity114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density114 = (Density) objConsume111111111117;
                    boolean z1111 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111118 = composerStartRestartGroup.consume(localLayoutDirection114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection114 = (LayoutDirection) objConsume111111111118;
                    Function2<? super Composer, ? super Integer, Unit> function118 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration114 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111119 = composerStartRestartGroup.consume(localViewConfiguration114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration114 = (ViewConfiguration) objConsume111111111119;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf114 = LayoutKt.materializerOf(modifierWeight$default114);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier117;
                    j3 = jM1641unboximpl;
                    z7 = z1111;
                    function4 = function118;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111111110 = composerStartRestartGroup.consume(localContentColor11118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111111110).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z4 = true;
                        }
                        if (i11 != 0) {
                            function3 = null;
                        }
                        if (i13 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i15 != 0) {
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
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111111111 = composerStartRestartGroup.consume(localContentColor11119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM1641unboximpl = ((Color) objConsume1111111111111).m1641unboximpl();
                            i4 &= -1879048193;
                        } else {
                            jM1641unboximpl = j;
                        }
                        if ((i3 & 512) != 0) {
                            jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i17 &= -15;
                        } else {
                            jM1630copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (function3 != null) {
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i20) {
                                ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                    TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                    TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                                } else {
                                    composer2.skipToGroupEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    Modifier modifierWeight$default115 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                    Alignment center115 = Alignment.INSTANCE.getCenter();
                    Modifier modifier118 = companion;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource2;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy115 = BoxKt.rememberBoxMeasurePolicy(center115, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111112 = composerStartRestartGroup.consume(localDensity115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density115 = (Density) objConsume1111111111112;
                    boolean z1112 = z4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111113 = composerStartRestartGroup.consume(localLayoutDirection115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection115 = (LayoutDirection) objConsume1111111111113;
                    Function2<? super Composer, ? super Integer, Unit> function119 = function3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration115 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111114 = composerStartRestartGroup.consume(localViewConfiguration115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ViewConfiguration viewConfiguration115 = (ViewConfiguration) objConsume1111111111114;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf115 = LayoutKt.materializerOf(modifierWeight$default115);
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
                    composerStartRestartGroup.startReplaceableGroup(-1538530399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                    m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 14) == 0) {
                                i20 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier3 = modifier118;
                    j3 = jM1641unboximpl;
                    z7 = z1112;
                    function4 = function119;
                    j4 = jM1630copywmQWz5c$default;
                    mutableInteractionSource3 = mutableInteractionSource118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                    public final void invoke(Composer composer2, int i20) {
                        BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 1572864;
            function3 = function2;
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 12582912;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i14 = 8388608;
                    } else {
                        i14 = 4194304;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
                i4 |= i16;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i19 = 268435456;
                } else {
                    i19 = 268435456;
                }
                i4 |= i19;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i18 = 2;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111115 = composerStartRestartGroup.consume(localContentColor111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume1111111111115).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111116 = composerStartRestartGroup.consume(localContentColor111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume1111111111116).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default116 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center116 = Alignment.INSTANCE.getCenter();
                Modifier modifier119 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy116 = BoxKt.rememberBoxMeasurePolicy(center116, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111117 = composerStartRestartGroup.consume(localDensity116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density116 = (Density) objConsume1111111111117;
                boolean z1113 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111118 = composerStartRestartGroup.consume(localLayoutDirection116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection116 = (LayoutDirection) objConsume1111111111118;
                Function2<? super Composer, ? super Integer, Unit> function1110 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration116 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111119 = composerStartRestartGroup.consume(localViewConfiguration116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration116 = (ViewConfiguration) objConsume1111111111119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf116 = LayoutKt.materializerOf(modifierWeight$default116);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier119;
                j3 = jM1641unboximpl;
                z7 = z1113;
                function4 = function1110;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111110 = composerStartRestartGroup.consume(localContentColor111112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111111110).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111111 = composerStartRestartGroup.consume(localContentColor111113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111111111).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default117 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center117 = Alignment.INSTANCE.getCenter();
                Modifier modifier1110 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy117 = BoxKt.rememberBoxMeasurePolicy(center117, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111112 = composerStartRestartGroup.consume(localDensity117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density117 = (Density) objConsume11111111111112;
                boolean z1114 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111113 = composerStartRestartGroup.consume(localLayoutDirection117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection117 = (LayoutDirection) objConsume11111111111113;
                Function2<? super Composer, ? super Integer, Unit> function1111 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration117 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111114 = composerStartRestartGroup.consume(localViewConfiguration117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration117 = (ViewConfiguration) objConsume11111111111114;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf117 = LayoutKt.materializerOf(modifierWeight$default117);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1110;
                j3 = jM1641unboximpl;
                z7 = z1114;
                function4 = function1111;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                public final void invoke(Composer composer2, int i20) {
                    BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                }
            });
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z4 = z2;
        i11 = i3 & 32;
        if (i11 != 0) {
            if ((3670016 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changed(function3)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 12582912;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i14 = 8388608;
                    } else {
                        i14 = 4194304;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
                i4 |= i16;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i19 = 268435456;
                } else {
                    i19 = 268435456;
                }
                i4 |= i19;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i18 = 2;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111115 = composerStartRestartGroup.consume(localContentColor111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111111115).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111116 = composerStartRestartGroup.consume(localContentColor111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume11111111111116).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default118 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center118 = Alignment.INSTANCE.getCenter();
                Modifier modifier1111 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy118 = BoxKt.rememberBoxMeasurePolicy(center118, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111117 = composerStartRestartGroup.consume(localDensity118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density118 = (Density) objConsume11111111111117;
                boolean z1115 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111118 = composerStartRestartGroup.consume(localLayoutDirection118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection118 = (LayoutDirection) objConsume11111111111118;
                Function2<? super Composer, ? super Integer, Unit> function1112 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration118 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111119 = composerStartRestartGroup.consume(localViewConfiguration118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration118 = (ViewConfiguration) objConsume11111111111119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf118 = LayoutKt.materializerOf(modifierWeight$default118);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1111;
                j3 = jM1641unboximpl;
                z7 = z1115;
                function4 = function1112;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource1111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111110 = composerStartRestartGroup.consume(localContentColor111116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume111111111111110).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z4 = true;
                    }
                    if (i11 != 0) {
                        function3 = null;
                    }
                    if (i13 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i15 != 0) {
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
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111111 = composerStartRestartGroup.consume(localContentColor111117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM1641unboximpl = ((Color) objConsume111111111111111).m1641unboximpl();
                        i4 &= -1879048193;
                    } else {
                        jM1641unboximpl = j;
                    }
                    if ((i3 & 512) != 0) {
                        jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i17 &= -15;
                    } else {
                        jM1630copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (function3 != null) {
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                        public final void invoke(Composer composer2, int i20) {
                            ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                                TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                            } else {
                                composer2.skipToGroupEnd();
                            }
                        }
                    });
                } else {
                    composableLambda = null;
                }
                Modifier modifierWeight$default119 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                Alignment center119 = Alignment.INSTANCE.getCenter();
                Modifier modifier1112 = companion;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource2;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy119 = BoxKt.rememberBoxMeasurePolicy(center119, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111112 = composerStartRestartGroup.consume(localDensity119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density119 = (Density) objConsume111111111111112;
                boolean z1116 = z4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111113 = composerStartRestartGroup.consume(localLayoutDirection119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection119 = (LayoutDirection) objConsume111111111111113;
                Function2<? super Composer, ? super Integer, Unit> function1113 = function3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration119 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111114 = composerStartRestartGroup.consume(localViewConfiguration119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration119 = (ViewConfiguration) objConsume111111111111114;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf119 = LayoutKt.materializerOf(modifierWeight$default119);
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
                composerStartRestartGroup.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 14) == 0) {
                            i20 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier3 = modifier1112;
                j3 = jM1641unboximpl;
                z7 = z1116;
                function4 = function1113;
                j4 = jM1630copywmQWz5c$default;
                mutableInteractionSource3 = mutableInteractionSource1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                public final void invoke(Composer composer2, int i20) {
                    BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
                }
            });
        }
        i4 |= 1572864;
        function3 = function2;
        i13 = i3 & 64;
        if (i13 != 0) {
            i4 |= 12582912;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z5)) {
                    i14 = 8388608;
                } else {
                    i14 = 4194304;
                }
                i4 |= i14;
            }
        }
        i15 = i3 & 128;
        if (i15 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i16 = 67108864;
            } else {
                i16 = 33554432;
            }
            i4 |= i16;
        }
        if ((i & 1879048192) != 0) {
            if ((i3 & 512) == 0) {
                i19 = 268435456;
            } else {
                i19 = 268435456;
            }
            i4 |= i19;
        }
        if ((i2 & 14) == 0) {
            if ((i3 & 1024) == 0) {
                i18 = 2;
            } else {
                i18 = 2;
            }
            i17 = i2 | i18;
        } else {
            i17 = i2;
        }
        if ((i4 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z4 = true;
                }
                if (i11 != 0) {
                    function3 = null;
                }
                if (i13 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i15 != 0) {
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
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor111118 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111115 = composerStartRestartGroup.consume(localContentColor111118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1641unboximpl = ((Color) objConsume111111111111115).m1641unboximpl();
                    i4 &= -1879048193;
                } else {
                    jM1641unboximpl = j;
                }
                if ((i3 & 512) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i17 &= -15;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z4 = true;
                }
                if (i11 != 0) {
                    function3 = null;
                }
                if (i13 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i15 != 0) {
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
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor111119 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111111116 = composerStartRestartGroup.consume(localContentColor111119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1641unboximpl = ((Color) objConsume111111111111116).m1641unboximpl();
                    i4 &= -1879048193;
                } else {
                    jM1641unboximpl = j;
                }
                if ((i3 & 512) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i17 &= -15;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (function3 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                });
            } else {
                composableLambda = null;
            }
            Modifier modifierWeight$default1110 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
            Alignment center1110 = Alignment.INSTANCE.getCenter();
            Modifier modifier1113 = companion;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource2;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1110 = BoxKt.rememberBoxMeasurePolicy(center1110, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume111111111111117 = composerStartRestartGroup.consume(localDensity1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1110 = (Density) objConsume111111111111117;
            boolean z1117 = z4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume111111111111118 = composerStartRestartGroup.consume(localLayoutDirection1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1110 = (LayoutDirection) objConsume111111111111118;
            Function2<? super Composer, ? super Integer, Unit> function1114 = function3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1110 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume111111111111119 = composerStartRestartGroup.consume(localViewConfiguration1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1110 = (ViewConfiguration) objConsume111111111111119;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1110 = LayoutKt.materializerOf(modifierWeight$default1110);
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
            composerStartRestartGroup.startReplaceableGroup(-1538530399);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
            m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                    invoke(f.floatValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, Composer composer2, int i20) {
                    ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                    if ((i20 & 14) == 0) {
                        i20 |= composer2.changed(f) ? 4 : 2;
                    }
                    if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                        if (z6) {
                            f = 1.0f;
                        }
                        BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier3 = modifier1113;
            j3 = jM1641unboximpl;
            z7 = z1117;
            function4 = function1114;
            j4 = jM1630copywmQWz5c$default;
            mutableInteractionSource3 = mutableInteractionSource1113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z4 = true;
                }
                if (i11 != 0) {
                    function3 = null;
                }
                if (i13 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i15 != 0) {
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
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111110 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111110 = composerStartRestartGroup.consume(localContentColor1111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1641unboximpl = ((Color) objConsume1111111111111110).m1641unboximpl();
                    i4 &= -1879048193;
                } else {
                    jM1641unboximpl = j;
                }
                if ((i3 & 512) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i17 &= -15;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z4 = true;
                }
                if (i11 != 0) {
                    function3 = null;
                }
                if (i13 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i15 != 0) {
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
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111111 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111111 = composerStartRestartGroup.consume(localContentColor1111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM1641unboximpl = ((Color) objConsume1111111111111111).m1641unboximpl();
                    i4 &= -1879048193;
                } else {
                    jM1641unboximpl = j;
                }
                if ((i3 & 512) != 0) {
                    jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(jM1641unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i17 &= -15;
                } else {
                    jM1630copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (function3 != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                    public final void invoke(Composer composer2, int i20) {
                        ComposerKt.sourceInformation(composer2, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                        if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption();
                            TextKt.ProvideTextStyle(caption.m3500copyHL5avdY((262111 & 1) != 0 ? caption.spanStyle.m3462getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? caption.spanStyle.getFontSize() : 0L, (262111 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? caption.spanStyle.getFontStyle() : null, (262111 & 16) != 0 ? caption.spanStyle.getFontSynthesis() : null, (262111 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? caption.spanStyle.getLetterSpacing() : 0L, (262111 & 256) != 0 ? caption.spanStyle.getBaselineShift() : null, (262111 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? caption.spanStyle.getBackground() : 0L, (262111 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? caption.paragraphStyle.getTextAlign() : TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), (262111 & 32768) != 0 ? caption.paragraphStyle.getTextDirection() : null, (262111 & 65536) != 0 ? caption.paragraphStyle.getLineHeight() : 0L, (262111 & 131072) != 0 ? caption.paragraphStyle.getTextIndent() : null), function3, composer2, (i4 >> 15) & 112);
                        } else {
                            composer2.skipToGroupEnd();
                        }
                    }
                });
            } else {
                composableLambda = null;
            }
            Modifier modifierWeight$default1111 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m639selectableO2vRcR0(companion, z, mutableInteractionSource2, RippleKt.m1265rememberRipple9IZ8Weo(false, 0.0f, jM1641unboximpl, composerStartRestartGroup, ((i4 >> 21) & 896) | 6, 2), z4, Role.m3380boximpl(Role.INSTANCE.m3392getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
            Alignment center1111 = Alignment.INSTANCE.getCenter();
            Modifier modifier1114 = companion;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource2;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy1111 = BoxKt.rememberBoxMeasurePolicy(center1111, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111112 = composerStartRestartGroup.consume(localDensity1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density1111 = (Density) objConsume1111111111111112;
            boolean z1118 = z4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111113 = composerStartRestartGroup.consume(localLayoutDirection1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection1111 = (LayoutDirection) objConsume1111111111111113;
            Function2<? super Composer, ? super Integer, Unit> function1115 = function3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration1111 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111114 = composerStartRestartGroup.consume(localViewConfiguration1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration1111 = (ViewConfiguration) objConsume1111111111111114;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf1111 = LayoutKt.materializerOf(modifierWeight$default1111);
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
            composerStartRestartGroup.startReplaceableGroup(-1538530399);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C182@8148L421:BottomNavigation.kt#jmzs0o");
            m910BottomNavigationTransitionKlgxPg(jM1641unboximpl, jM1630copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                    invoke(f.floatValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, Composer composer2, int i20) {
                    ComposerKt.sourceInformation(composer2, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                    if ((i20 & 14) == 0) {
                        i20 |= composer2.changed(f) ? 4 : 2;
                    }
                    if ((i20 & 91) != 18 || !composer2.getSkipping()) {
                        if (z6) {
                            f = 1.0f;
                        }
                        BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i4 >> 9) & 14);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, ((i17 << 3) & 112) | ((i4 >> 27) & 14) | 3072 | ((i4 << 3) & 896));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier3 = modifier1114;
            j3 = jM1641unboximpl;
            z7 = z1118;
            function4 = function1115;
            j4 = jM1630copywmQWz5c$default;
            mutableInteractionSource3 = mutableInteractionSource1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

            public final void invoke(Composer composer2, int i20) {
                BottomNavigationKt.m909BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier3, z7, function4, z6, mutableInteractionSource3, j3, j4, composer2, i | 1, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m910BottomNavigationTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)227@9693L128,234@9896L181:BottomNavigation.kt#jmzs0o");
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
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, composerStartRestartGroup, 48, 12);
            long jM1683lerpjxsXWHM = ColorKt.m1683lerpjxsXWHM(j2, j, m911BottomNavigationTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1621boximpl(Color.m1630copywmQWz5c$default(jM1683lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(jM1683lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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
                    ComposerKt.sourceInformation(composer2, "C238@10045L26:BottomNavigation.kt#jmzs0o");
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        function3.invoke(Float.valueOf(BottomNavigationKt.m911BottomNavigationTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState)), composer2, Integer.valueOf((i3 >> 6) & 112));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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
                BottomNavigationKt.m910BottomNavigationTransitionKlgxPg(j, j2, z, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162995092);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationItemBaselineLayout)P(!1,2)259@10750L1203:BottomNavigation.kt#jmzs0o");
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
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.2
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
                                return BottomNavigationKt.m916placeIcon3p2s80s(Layout, placeableMo3124measureBRTryo1, j);
                            }
                            Intrinsics.checkNotNull(placeableMo3124measureBRTryo0);
                            return BottomNavigationKt.m917placeLabelAndIconDIyivk0(Layout, placeableMo3124measureBRTryo0, placeableMo3124measureBRTryo1, j, f);
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
            composerStartRestartGroup.startReplaceableGroup(395677717);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C261@10780L41,263@10871L253:BottomNavigation.kt#jmzs0o");
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
            composerStartRestartGroup.startReplaceableGroup(-1943403697);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C261@10813L6:BottomNavigation.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (function3 != null) {
                Modifier modifierM425paddingVpY3zN4$default = PaddingKt.m425paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
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
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM425paddingVpY3zN4$default);
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
                composerStartRestartGroup.startReplaceableGroup(150842644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C268@11115L7:BottomNavigation.kt#jmzs0o");
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.3
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
                BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, function3, f, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m916placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        int iM3798getMaxHeightimpl = Constraints.m3798getMaxHeightimpl(j);
        final int height = (iM3798getMaxHeightimpl - placeable.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), iM3798getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, height, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m917placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        int iM3798getMaxHeightimpl = Constraints.m3798getMaxHeightimpl(j);
        int i = placeable.get(AlignmentLineKt.getLastBaseline());
        int i2 = measureScope.mo312roundToPx0680j_4(CombinedItemTextBaseline);
        final int i3 = (iM3798getMaxHeightimpl - i) - i2;
        int height = (iM3798getMaxHeightimpl - placeable2.getHeight()) / 2;
        final int height2 = (iM3798getMaxHeightimpl - (i2 * 2)) - placeable2.getHeight();
        int iMax = Math.max(placeable.getWidth(), placeable2.getWidth());
        final int width = (iMax - placeable.getWidth()) / 2;
        final int width2 = (iMax - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((height - height2) * (1 - f));
        return MeasureScope.layout$default(measureScope, iMax, iM3798getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, width, i3 + iRoundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, width2, height2 + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 12;
        BottomNavigationItemHorizontalPadding = Dp.m3843constructorimpl(f);
        CombinedItemTextBaseline = Dp.m3843constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomNavigationTransition_Klgx_Pg$lambda-3, reason: not valid java name */
    public static final float m911BottomNavigationTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
