package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
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
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt {
    private static final Modifier TextPadding;
    private static final Modifier TitlePadding;
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* JADX WARN: Code duplicated, block: B:100:0x0123 A[PHI: r2 r3 r4 r5 r6 r7
  0x0123: PHI (r2v29 int) = (r2v21 int), (r2v32 int) binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]
  0x0123: PHI (r3v7 androidx.compose.ui.Modifier) = (r3v2 androidx.compose.ui.Modifier), (r3v11 androidx.compose.ui.Modifier) binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]
  0x0123: PHI (r4v8 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
  (r4v5 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
  (r4v10 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
 binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]
  0x0123: PHI (r5v13 androidx.compose.ui.graphics.Shape) = (r5v7 androidx.compose.ui.graphics.Shape), (r5v14 androidx.compose.ui.graphics.Shape) binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]
  0x0123: PHI (r6v7 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
  (r6v3 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
  (r6v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
 binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]
  0x0123: PHI (r7v11 long) = (r7v7 long), (r7v12 long) binds: [B:119:0x0160, B:99:0x011e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:101:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0128  */
    /* JADX WARN: Code duplicated, block: B:103:0x012d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:109:0x0136  */
    /* JADX WARN: Code duplicated, block: B:112:0x013c  */
    /* JADX WARN: Code duplicated, block: B:113:0x014b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0150  */
    /* JADX WARN: Code duplicated, block: B:117:0x015d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0162  */
    /* JADX WARN: Code duplicated, block: B:125:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:87:0x0103  */
    /* JADX INFO: renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m880AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Shape shape, long j, long j2, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i7;
        Shape shape2;
        long j3;
        long j4;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final CornerBasedShape medium;
        long jM983getSurface0d7_KjU;
        long j5;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)48@1896L6,49@1954L6,50@1996L32,52@2038L1047:AlertDialog.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(buttons) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changed(function4)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changed(function5)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            int i9 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i9;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            j3 = j;
                            int i10 = composerStartRestartGroup.changed(j3) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            j3 = j;
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            j4 = j2;
                            int i11 = composerStartRestartGroup.changed(j4) ? 1048576 : 524288;
                            i3 |= i11;
                        } else {
                            j4 = j2;
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    if ((2995931 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            companion = modifier;
                            function6 = function5;
                            medium = shape2;
                            jM983getSurface0d7_KjU = j3;
                        } else {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            function6 = i6 == 0 ? function5 : null;
                            if ((i2 & 16) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -57345;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 32) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -458753;
                            } else {
                                jM983getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 64) != 0) {
                                long jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                                i3 &= -3670017;
                                j5 = jM997contentColorForek8zF_U;
                            }
                            composerStartRestartGroup.endDefaults();
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                                    ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                                    if ((i12 & 11) != 2 || !composer2.getSkipping()) {
                                        final Function2<Composer, Integer, Unit> function8 = function4;
                                        final Function2<Composer, Integer, Unit> function9 = function6;
                                        Function2<Composer, Integer, Unit> function10 = buttons;
                                        final int i13 = i3;
                                        composer2.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                        composer2.startReplaceableGroup(523699273);
                                        ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                        AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                            public final void invoke(Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                                if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                                    final Function2<Composer, Integer, Unit> function11 = function8;
                                                    final int i15 = i13;
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                        public final void invoke(Composer composer4, int i16) {
                                                            ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                            if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i15 >> 3) & 112);
                                                            } else {
                                                                composer4.skipToGroupEnd();
                                                            }
                                                        }
                                                    }), composer3, 56);
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                            public final void invoke(Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                                if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                                    final Function2<Composer, Integer, Unit> function11 = function9;
                                                    final int i15 = i13;
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                        public final void invoke(Composer composer4, int i16) {
                                                            ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                            if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i15 >> 6) & 112);
                                                            } else {
                                                                composer4.skipToGroupEnd();
                                                            }
                                                        }
                                                    }), composer3, 56);
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }) : null, composer2, 6);
                                        function10.invoke(composer2, Integer.valueOf(i13 & 14));
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
                            });
                            int i12 = ((i3 >> 3) & 14) | 1572864;
                            int i13 = i3 >> 9;
                            SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda, composerStartRestartGroup, i12 | (i13 & 112) | (i13 & 896) | (i13 & 7168), 48);
                            modifier2 = companion;
                            function7 = function4;
                            j6 = jM983getSurface0d7_KjU;
                            j7 = j5;
                        }
                        j5 = j4;
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                                ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                    final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                    final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                    Function2<Composer, Integer, Unit> function10 = buttons;
                                    final int i15 = i3;
                                    composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                    composer2.startReplaceableGroup(523699273);
                                    ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                    AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                        public final void invoke(Composer composer3, int i16) {
                                            ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                                final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                                final int i17 = i15;
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                    public final void invoke(Composer composer4, int i18) {
                                                        ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                        if ((i18 & 11) != 2 || !composer4.getSkipping()) {
                                                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i17 >> 3) & 112);
                                                        } else {
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                        public final void invoke(Composer composer3, int i16) {
                                            ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                                final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                                final int i17 = i15;
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                    public final void invoke(Composer composer4, int i18) {
                                                        ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                        if ((i18 & 11) != 2 || !composer4.getSkipping()) {
                                                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i17 >> 6) & 112);
                                                        } else {
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }
                                                }), composer3, 56);
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : null, composer2, 6);
                                    function10.invoke(composer2, Integer.valueOf(i15 & 14));
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
                        });
                        int i14 = ((i3 >> 3) & 14) | 1572864;
                        int i15 = i3 >> 9;
                        SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda2, composerStartRestartGroup, i14 | (i15 & 112) | (i15 & 896) | (i15 & 7168), 48);
                        modifier2 = companion;
                        function7 = function4;
                        j6 = jM983getSurface0d7_KjU;
                        j7 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function7 = function4;
                        function6 = function5;
                        medium = shape2;
                        j6 = j3;
                        j7 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                function5 = function3;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U2 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U2;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U3 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U3;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i17 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i18) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i19 = i17;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i110) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i110 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i19 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i18) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i19 = i17;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i110) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i110 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i19 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i17 & 14));
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
                    });
                    int i16 = ((i3 >> 3) & 14) | 1572864;
                    int i17 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda3, composerStartRestartGroup, i16 | (i17 & 112) | (i17 & 896) | (i17 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U4 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U4;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U5 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U5;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i19 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i110) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i110 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i111 = i19;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i112) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i112 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i111 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i110) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i110 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i111 = i19;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i112) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i112 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i111 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i19 & 14));
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
                    });
                    int i18 = ((i3 >> 3) & 14) | 1572864;
                    int i19 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda4, composerStartRestartGroup, i18 | (i19 & 112) | (i19 & 896) | (i19 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                        AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            function4 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changed(function5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U6 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U6;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U7 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U7;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i111 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i112) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i112 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i113 = i111;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i114) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i114 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i113 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i112) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i112 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i113 = i111;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i114) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i114 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i113 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i111 & 14));
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
                    });
                    int i110 = ((i3 >> 3) & 14) | 1572864;
                    int i111 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda5, composerStartRestartGroup, i110 | (i111 & 112) | (i111 & 896) | (i111 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U8 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U8;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U9 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U9;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i113 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i114) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i114 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i115 = i113;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i116) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i116 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i115 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i114) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i114 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i115 = i113;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i116) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i116 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i115 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i113 & 14));
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
                    });
                    int i112 = ((i3 >> 3) & 14) | 1572864;
                    int i113 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda6, composerStartRestartGroup, i112 | (i113 & 112) | (i113 & 896) | (i113 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                        AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function5 = function3;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U10 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U10;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U11 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U11;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i115 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i116) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i116 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i117 = i115;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i118) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i118 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i117 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i116) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i116 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i117 = i115;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i118) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i118 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i117 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i115 & 14));
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
                });
                int i114 = ((i3 >> 3) & 14) | 1572864;
                int i115 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda7, composerStartRestartGroup, i114 | (i115 & 112) | (i115 & 896) | (i115 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U12 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U12;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U13 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U13;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i117 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i118) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i118 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i119 = i117;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i1110) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i1110 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i119 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i118) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i118 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i119 = i117;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i1110) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i1110 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i119 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i117 & 14));
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
                });
                int i116 = ((i3 >> 3) & 14) | 1572864;
                int i117 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda8, composerStartRestartGroup, i116 | (i117 & 112) | (i117 & 896) | (i117 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                    AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changed(function4)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changed(function5)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j4 = j2;
                        if (composerStartRestartGroup.changed(j4)) {
                        }
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((2995931 & i3) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U14 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U14;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U15 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U15;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i119 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i1110) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i1110 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i1111 = i119;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i1112) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i1112 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i1111 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i1110) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i1110 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i1111 = i119;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i1112) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i1112 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i1111 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i119 & 14));
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
                    });
                    int i118 = ((i3 >> 3) & 14) | 1572864;
                    int i119 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda9, composerStartRestartGroup, i118 | (i119 & 112) | (i119 & 896) | (i119 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U16 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U16;
                        } else {
                            j5 = j4;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -57345;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 64) != 0) {
                            long jM997contentColorForek8zF_U17 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                            i3 &= -3670017;
                            j5 = jM997contentColorForek8zF_U17;
                        } else {
                            j5 = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                            ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                            if ((i1110 & 11) != 2 || !composer2.getSkipping()) {
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                                final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                Function2<Composer, Integer, Unit> function10 = buttons;
                                final int i1111 = i3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                                composer2.startReplaceableGroup(523699273);
                                ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                                AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer composer3, int i1112) {
                                        ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if ((i1112 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                            final int i1113 = i1111;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer composer4, int i1114) {
                                                    ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if ((i1114 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i1113 >> 3) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer composer3, int i1112) {
                                        ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if ((i1112 & 11) != 2 || !composer3.getSkipping()) {
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                            final int i1113 = i1111;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer composer4, int i1114) {
                                                    ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if ((i1114 & 11) != 2 || !composer4.getSkipping()) {
                                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i1113 >> 6) & 112);
                                                    } else {
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }
                                            }), composer3, 56);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }) : null, composer2, 6);
                                function10.invoke(composer2, Integer.valueOf(i1111 & 14));
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
                    });
                    int i1110 = ((i3 >> 3) & 14) | 1572864;
                    int i1111 = i3 >> 9;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda10, composerStartRestartGroup, i1110 | (i1111 & 112) | (i1111 & 896) | (i1111 & 7168), 48);
                    modifier2 = companion;
                    function7 = function4;
                    j6 = jM983getSurface0d7_KjU;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                        AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function5 = function3;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U18 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U18;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U19 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U19;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i1112 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i1113 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i1114) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i1114 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i1115 = i1113;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i1116) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i1116 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i1115 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i1114) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i1114 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i1115 = i1113;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i1116) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i1116 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i1115 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i1113 & 14));
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
                });
                int i1112 = ((i3 >> 3) & 14) | 1572864;
                int i1113 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda11, composerStartRestartGroup, i1112 | (i1113 & 112) | (i1113 & 896) | (i1113 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U110 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U110;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U111 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U111;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i1114 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i1115 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i1116) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i1116 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i1117 = i1115;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i1118) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i1118 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i1117 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i1116) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i1116 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i1117 = i1115;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i1118) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i1118 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i1117 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i1115 & 14));
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
                });
                int i1114 = ((i3 >> 3) & 14) | 1572864;
                int i1115 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda12, composerStartRestartGroup, i1114 | (i1115 & 112) | (i1115 & 896) | (i1115 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                    AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        function4 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changed(function5)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            if ((2995931 & i3) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U112 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U112;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U113 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U113;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i1116 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i1117 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i1118) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i1118 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i1119 = i1117;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i11110) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i11110 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i1119 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i1118) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i1118 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i1119 = i1117;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i11110) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i11110 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i1119 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i1117 & 14));
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
                });
                int i1116 = ((i3 >> 3) & 14) | 1572864;
                int i1117 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda13, composerStartRestartGroup, i1116 | (i1117 & 112) | (i1117 & 896) | (i1117 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U114 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U114;
                    } else {
                        j5 = j4;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -57345;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 64) != 0) {
                        long jM997contentColorForek8zF_U115 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                        j5 = jM997contentColorForek8zF_U115;
                    } else {
                        j5 = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                        if ((i1118 & 11) != 2 || !composer2.getSkipping()) {
                            final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                            Function2<Composer, Integer, Unit> function10 = buttons;
                            final int i1119 = i3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                            composer2.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer3, int i11110) {
                                    ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                    if ((i11110 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                        final int i11111 = i1119;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer4, int i11112) {
                                                ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                if ((i11112 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i11111 >> 3) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer3, int i11110) {
                                    ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                    if ((i11110 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                        final int i11111 = i1119;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer4, int i11112) {
                                                ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                if ((i11112 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i11111 >> 6) & 112);
                                                } else {
                                                    composer4.skipToGroupEnd();
                                                }
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, composer2, 6);
                            function10.invoke(composer2, Integer.valueOf(i1119 & 14));
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
                });
                int i1118 = ((i3 >> 3) & 14) | 1572864;
                int i1119 = i3 >> 9;
                SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda14, composerStartRestartGroup, i1118 | (i1119 & 112) | (i1119 & 896) | (i1119 & 7168), 48);
                modifier2 = companion;
                function7 = function4;
                j6 = jM983getSurface0d7_KjU;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                    AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        function5 = function3;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i10;
            } else {
                j3 = j;
            }
            i3 |= i10;
        } else {
            j3 = j;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            i3 |= i11;
        } else {
            j4 = j2;
        }
        if ((2995931 & i3) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM997contentColorForek8zF_U116 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM997contentColorForek8zF_U116;
                } else {
                    j5 = j4;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM997contentColorForek8zF_U117 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM997contentColorForek8zF_U117;
                } else {
                    j5 = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                    ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                    if ((i11110 & 11) != 2 || !composer2.getSkipping()) {
                        final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                        final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                        Function2<Composer, Integer, Unit> function10 = buttons;
                        final int i11111 = i3;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                        composer2.startReplaceableGroup(523699273);
                        ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                        AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                            public final void invoke(Composer composer3, int i11112) {
                                ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                if ((i11112 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                    final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                    final int i11113 = i11111;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                        public final void invoke(Composer composer4, int i11114) {
                                            ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                            if ((i11114 & 11) != 2 || !composer4.getSkipping()) {
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i11113 >> 3) & 112);
                                            } else {
                                                composer4.skipToGroupEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                            public final void invoke(Composer composer3, int i11112) {
                                ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                if ((i11112 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                    final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                    final int i11113 = i11111;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                        public final void invoke(Composer composer4, int i11114) {
                                            ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                            if ((i11114 & 11) != 2 || !composer4.getSkipping()) {
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i11113 >> 6) & 112);
                                            } else {
                                                composer4.skipToGroupEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }) : null, composer2, 6);
                        function10.invoke(composer2, Integer.valueOf(i11111 & 14));
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
            });
            int i11110 = ((i3 >> 3) & 14) | 1572864;
            int i11111 = i3 >> 9;
            SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda15, composerStartRestartGroup, i11110 | (i11111 & 112) | (i11111 & 896) | (i11111 & 7168), 48);
            modifier2 = companion;
            function7 = function4;
            j6 = jM983getSurface0d7_KjU;
            j7 = j5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM997contentColorForek8zF_U118 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM997contentColorForek8zF_U118;
                } else {
                    j5 = j4;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 16) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -57345;
                } else {
                    medium = shape2;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j3;
                }
                if ((i2 & 64) != 0) {
                    long jM997contentColorForek8zF_U119 = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                    j5 = jM997contentColorForek8zF_U119;
                } else {
                    j5 = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                    ComposerKt.sourceInformation(composer2, "C58@2184L895:AlertDialog.kt#jmzs0o");
                    if ((i11112 & 11) != 2 || !composer2.getSkipping()) {
                        final Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                        final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                        Function2<Composer, Integer, Unit> function10 = buttons;
                        final int i11113 = i3;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion2);
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
                        composer2.startReplaceableGroup(523699273);
                        ComposerKt.sourceInformation(composer2, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                        AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function8 != null ? ComposableLambdaKt.composableLambda(composer2, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                            public final void invoke(Composer composer3, int i11114) {
                                ComposerKt.sourceInformation(composer3, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                if ((i11114 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))};
                                    final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
                                    final int i11115 = i11113;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                        public final void invoke(Composer composer4, int i11116) {
                                            ComposerKt.sourceInformation(composer4, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                            if ((i11116 & 11) != 2 || !composer4.getSkipping()) {
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), function11, composer4, (i11115 >> 3) & 112);
                                            } else {
                                                composer4.skipToGroupEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }) : null, function9 != null ? ComposableLambdaKt.composableLambda(composer2, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                            public final void invoke(Composer composer3, int i11114) {
                                ComposerKt.sourceInformation(composer3, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                if ((i11114 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)))};
                                    final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                                    final int i11115 = i11113;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                        public final void invoke(Composer composer4, int i11116) {
                                            ComposerKt.sourceInformation(composer4, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                            if ((i11116 & 11) != 2 || !composer4.getSkipping()) {
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2(), function11, composer4, (i11115 >> 6) & 112);
                                            } else {
                                                composer4.skipToGroupEnd();
                                            }
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }) : null, composer2, 6);
                        function10.invoke(composer2, Integer.valueOf(i11113 & 14));
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
            });
            int i11112 = ((i3 >> 3) & 14) | 1572864;
            int i11113 = i3 >> 9;
            SurfaceKt.m1175SurfaceFjzlyU(companion, medium, jM983getSurface0d7_KjU, j5, null, 0.0f, composableLambda16, composerStartRestartGroup, i11112 | (i11113 & 112) | (i11113 & 896) | (i11113 & 7168), 48);
            modifier2 = companion;
            function7 = function4;
            j6 = jM983getSurface0d7_KjU;
            j7 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                AlertDialogKt.m880AlertDialogContentWMdw5o4(buttons, modifier2, function7, function6, medium, j6, j7, composer2, i | 1, i2);
            }
        });
    }

    public static final void AlertDialogBaselineLayout(final ColumnScope columnScope, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-555573207);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogBaselineLayout)P(1)96@3561L3479:AlertDialog.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            Modifier modifierWeight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
            AnonymousClass2 anonymousClass2 = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.2
                /* JADX WARN: Code duplicated, block: B:39:0x00a9  */
                /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
                /* JADX WARN: Code duplicated, block: B:56:0x00e9  */
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    Object next;
                    Object next2;
                    int iIntValue;
                    int iIntValue2;
                    int iIntValue3;
                    final int i3;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), "title"));
                    Measurable measurable = (Measurable) next;
                    final Placeable placeableMo3124measureBRTryo0 = measurable != null ? measurable.mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    Iterator<T> it2 = list.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next2), "text"));
                    Measurable measurable2 = (Measurable) next2;
                    final Placeable placeableMo3124measureBRTryo1 = measurable2 != null ? measurable2.mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    int height = 0;
                    int iMax = Math.max(placeableMo3124measureBRTryo0 != null ? placeableMo3124measureBRTryo0.getWidth() : 0, placeableMo3124measureBRTryo1 != null ? placeableMo3124measureBRTryo1.getWidth() : 0);
                    if (placeableMo3124measureBRTryo0 == null) {
                        iIntValue = 0;
                    } else {
                        int i4 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                        Integer numValueOf = i4 == Integer.MIN_VALUE ? null : Integer.valueOf(i4);
                        if (numValueOf != null) {
                            iIntValue = numValueOf.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    if (placeableMo3124measureBRTryo0 == null) {
                        iIntValue2 = 0;
                    } else {
                        int i5 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                        Integer numValueOf2 = i5 == Integer.MIN_VALUE ? null : Integer.valueOf(i5);
                        if (numValueOf2 != null) {
                            iIntValue2 = numValueOf2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                    }
                    final int i6 = Layout.mo311roundToPxR2X_6o(AlertDialogKt.TitleBaselineDistanceFromTop) - iIntValue;
                    if (placeableMo3124measureBRTryo1 == null) {
                        iIntValue3 = 0;
                    } else {
                        int i7 = placeableMo3124measureBRTryo1.get(AlignmentLineKt.getFirstBaseline());
                        Integer numValueOf3 = i7 != Integer.MIN_VALUE ? Integer.valueOf(i7) : null;
                        if (numValueOf3 != null) {
                            iIntValue3 = numValueOf3.intValue();
                        } else {
                            iIntValue3 = 0;
                        }
                    }
                    int i8 = placeableMo3124measureBRTryo0 == null ? Layout.mo311roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTop) : Layout.mo311roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTitle);
                    int height2 = placeableMo3124measureBRTryo0 != null ? placeableMo3124measureBRTryo0.getHeight() + i6 : 0;
                    if (placeableMo3124measureBRTryo0 == null) {
                        i3 = i8 - iIntValue3;
                    } else {
                        i3 = (iIntValue2 == 0 ? height2 - iIntValue3 : (i6 + iIntValue2) - iIntValue3) + i8;
                    }
                    if (placeableMo3124measureBRTryo1 != null) {
                        if (iIntValue2 == 0) {
                            height = (placeableMo3124measureBRTryo1.getHeight() + i8) - iIntValue3;
                        } else {
                            height = ((placeableMo3124measureBRTryo1.getHeight() + i8) - iIntValue3) - ((placeableMo3124measureBRTryo0 != null ? placeableMo3124measureBRTryo0.getHeight() : 0) - iIntValue2);
                        }
                    }
                    return MeasureScope.layout$default(Layout, iMax, height + height2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                            Placeable placeable = placeableMo3124measureBRTryo0;
                            if (placeable != null) {
                                Placeable.PlacementScope.place$default(layout, placeable, 0, i6, 0.0f, 4, null);
                            }
                            Placeable placeable2 = placeableMo3124measureBRTryo1;
                            if (placeable2 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable2, 0, i3, 0.0f, 4, null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWeight);
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
            Updater.m1293setimpl(composerM1286constructorimpl, anonymousClass2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(1454034642);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C*104@3798L103:AlertDialog.kt#jmzs0o");
            composerStartRestartGroup.startReplaceableGroup(-1160646206);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*99@3629L106");
            if (function2 != null) {
                Modifier modifierAlign = columnScope.align(LayoutIdKt.layoutId(TitlePadding, "title"), Alignment.INSTANCE.getStart());
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
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlign);
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
                composerStartRestartGroup.startReplaceableGroup(472489145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C*100@3710L7:AlertDialog.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function3 != null) {
                Modifier modifierAlign2 = columnScope.align(LayoutIdKt.layoutId(TextPadding, "text"), Alignment.INSTANCE.getStart());
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
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierAlign2);
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
                composerStartRestartGroup.startReplaceableGroup(-272722206);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C*105@3877L6:AlertDialog.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.3
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
                AlertDialogKt.AlertDialogBaselineLayout(columnScope, function2, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m881AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(73434452);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)192@7298L3452:AlertDialog.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    int iMax;
                    Ref.IntRef intRef;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    ArrayList arrayList4 = new ArrayList();
                    Ref.IntRef intRef4 = new Ref.IntRef();
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    long jConstraints$default = ConstraintsKt.Constraints$default(0, Constraints.m3799getMaxWidthimpl(j), 0, 0, 13, null);
                    Iterator<? extends Measurable> it = measurables.iterator();
                    while (it.hasNext()) {
                        Placeable placeableMo3124measureBRTryo0 = it.next().mo3124measureBRTryo0(jConstraints$default);
                        long j2 = jConstraints$default;
                        Ref.IntRef intRef6 = intRef5;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef4, Layout, f, j, placeableMo3124measureBRTryo0)) {
                            intRef = intRef4;
                        } else {
                            intRef = intRef4;
                            measure_3p2s80s$startNewSequence(arrayList, intRef3, Layout, f2, arrayList4, arrayList2, intRef6, arrayList3, intRef2, intRef);
                        }
                        Ref.IntRef intRef7 = intRef;
                        if (!arrayList4.isEmpty()) {
                            intRef7.element += Layout.mo312roundToPx0680j_4(f);
                        }
                        arrayList4.add(placeableMo3124measureBRTryo0);
                        intRef7.element += placeableMo3124measureBRTryo0.getWidth();
                        intRef5 = intRef6;
                        intRef5.element = Math.max(intRef5.element, placeableMo3124measureBRTryo0.getHeight());
                        intRef4 = intRef7;
                        arrayList4 = arrayList4;
                        jConstraints$default = j2;
                        arrayList3 = arrayList3;
                        intRef3 = intRef3;
                    }
                    Ref.IntRef intRef8 = intRef3;
                    final ArrayList arrayList5 = arrayList3;
                    Ref.IntRef intRef9 = intRef4;
                    ArrayList arrayList6 = arrayList4;
                    if (!arrayList6.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList, intRef8, Layout, f2, arrayList6, arrayList2, intRef5, arrayList5, intRef2, intRef9);
                    }
                    if (Constraints.m3799getMaxWidthimpl(j) != Integer.MAX_VALUE) {
                        iMax = Constraints.m3799getMaxWidthimpl(j);
                    } else {
                        iMax = Math.max(intRef2.element, Constraints.m3801getMinWidthimpl(j));
                    }
                    final int i3 = iMax;
                    int iMax2 = Math.max(intRef8.element, Constraints.m3800getMinHeightimpl(j));
                    final float f3 = f;
                    return MeasureScope.layout$default(Layout, i3, iMax2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$measure$1
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
                            List<List<Placeable>> list = arrayList;
                            MeasureScope measureScope = Layout;
                            float f4 = f3;
                            int i4 = i3;
                            List<Integer> list2 = arrayList5;
                            int size = list.size();
                            int i5 = 0;
                            while (i5 < size) {
                                List<Placeable> list3 = list.get(i5);
                                int size2 = list3.size();
                                int[] iArr = new int[size2];
                                int i6 = 0;
                                while (i6 < size2) {
                                    iArr[i6] = list3.get(i6).getWidth() + (i6 < CollectionsKt.getLastIndex(list3) ? measureScope.mo312roundToPx0680j_4(f4) : 0);
                                    i6++;
                                }
                                Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
                                int[] iArr2 = new int[size2];
                                for (int i7 = 0; i7 < size2; i7++) {
                                    iArr2[i7] = 0;
                                }
                                bottom.arrange(measureScope, i4, iArr, iArr2);
                                int size3 = list3.size();
                                int i8 = 0;
                                while (i8 < size3) {
                                    Placeable.PlacementScope.place$default(layout, list3.get(i8), iArr2[i8], list2.get(i5).intValue(), 0.0f, 4, null);
                                    i8++;
                                    size3 = size3;
                                    iArr2 = iArr2;
                                    i5 = i5;
                                    list3 = list3;
                                }
                                i5++;
                            }
                        }
                    }, 4, null);
                }

                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                    return list.isEmpty() || (intRef.element + measureScope.mo312roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m3799getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                    List<List<Placeable>> list5 = list;
                    if (!list5.isEmpty()) {
                        intRef.element += measureScope.mo312roundToPx0680j_4(f3);
                    }
                    list5.add(CollectionsKt.toList(list2));
                    list3.add(Integer.valueOf(intRef2.element));
                    list4.add(Integer.valueOf(intRef.element));
                    intRef.element += intRef2.element;
                    intRef3.element = Math.max(intRef3.element, intRef4.element);
                    list2.clear();
                    intRef4.element = 0;
                    intRef2.element = 0;
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
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
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
            content.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
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
                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(f, f2, content, composer2, i | 1);
            }
        });
    }

    static {
        float f = 24;
        TitlePadding = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m3843constructorimpl(f), 0.0f, Dp.m3843constructorimpl(f), 0.0f, 10, null);
        TextPadding = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m3843constructorimpl(f), 0.0f, Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(28), 2, null);
    }
}
