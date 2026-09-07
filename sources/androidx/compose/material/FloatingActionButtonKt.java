package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
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
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0089\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001ar\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m3843constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m3843constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m3843constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m3843constructorimpl(20);

    /* JADX WARN: Code duplicated, block: B:113:0x0159 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x015b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0160  */
    /* JADX WARN: Code duplicated, block: B:117:0x0164  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0188  */
    /* JADX WARN: Code duplicated, block: B:124:0x018f  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:132:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:136:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:142:0x0282  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x011d  */
    /* JADX WARN: Code duplicated, block: B:96:0x012d  */
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m1074FloatingActionButtonbogVsAg(final Function0<Unit> onClick, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        Shape shape2;
        long j3;
        final long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM1072elevationxZ9QkE;
        int i6;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource2;
        CornerBasedShape cornerBasedShapeCopy;
        long jM981getSecondary0d7_KjU;
        long jM997contentColorForek8zF_U;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        long j5;
        Object objRememberedValue;
        Composer composer2;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final long j6;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1028985328);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)81@3832L39,82@3906L6,83@3994L6,84@4038L32,85@4148L11,94@4393L28,88@4205L685:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
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
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i9 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        int i10 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    i3 |= i10;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        j4 = j2;
                        int i11 = composerStartRestartGroup.changed(j4) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                if ((i & 3670016) == 0) {
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevationM1072elevationxZ9QkE)) {
                        i7 = 524288;
                    } else {
                        i7 = 1048576;
                    }
                    i3 |= i7;
                } else {
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i6 = 8388608;
                        } else {
                            i6 = 4194304;
                        }
                    }
                    if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
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
                            if ((i2 & 8) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -7169;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                                i3 &= -57345;
                            } else {
                                jM981getSecondary0d7_KjU = j3;
                            }
                            if ((i2 & 32) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                                i3 &= -458753;
                            } else {
                                jM997contentColorForek8zF_U = j4;
                            }
                            if ((i2 & 64) != 0) {
                                floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i3 &= -3670017;
                            }
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape3 = cornerBasedShapeCopy;
                            j5 = jM981getSecondary0d7_KjU;
                            j4 = jM997contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            modifier2 = modifier;
                            mutableInteractionSource3 = mutableInteractionSource;
                            shape3 = shape2;
                            j5 = j3;
                        }
                        FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                        composerStartRestartGroup.endDefaults();
                        long j8 = j4;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation3.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                            public final void invoke(Composer composer3, int i12) {
                                ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                                if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                    final Function2<Composer, Integer, Unit> function2 = content;
                                    final int i13 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                        public final void invoke(Composer composer4, int i14) {
                                            ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final Function2<Composer, Integer, Unit> function3 = function2;
                                                final int i15 = i13;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                    public final void invoke(Composer composer5, int i16) {
                                                        ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                        if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                            Alignment center = Alignment.INSTANCE.getCenter();
                                                            Function2<Composer, Integer, Unit> function4 = function3;
                                                            int i17 = i15;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-2137368960);
                                                            ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            composer5.startReplaceableGroup(-1049034642);
                                                            ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                            function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                            composer5.endReplaceableGroup();
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
                        }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                        modifier3 = modifier2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                        j6 = j5;
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                        j7 = j8;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        mutableInteractionSource4 = mutableInteractionSource;
                        shape4 = shape2;
                        composer2 = composerStartRestartGroup;
                        long j9 = j4;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM1072elevationxZ9QkE;
                        j6 = j3;
                        j7 = j9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                        public final void invoke(Composer composer3, int i12) {
                            FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                        }
                    });
                }
                i6 = 12582912;
                i3 |= i6;
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j10 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation4.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation4;
                    j7 = j10;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j11 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation5.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation5;
                    j7 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                    public final void invoke(Composer composer3, int i12) {
                        FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
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
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
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
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
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
            if ((i & 3670016) == 0) {
                floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
                if ((i2 & 64) == 0) {
                    i7 = 524288;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            } else {
                floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i6 = 8388608;
                    } else {
                        i6 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j12 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation6.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation6;
                    j7 = j12;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j13 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation7.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation7;
                    j7 = j13;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                    public final void invoke(Composer composer3, int i12) {
                        FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                    }
                });
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j14 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation8.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation8;
                j7 = j14;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j15 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation9.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation9;
                j7 = j15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                public final void invoke(Composer composer3, int i12) {
                    FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
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
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
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
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
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
            if ((i & 3670016) == 0) {
                floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
                if ((i2 & 64) == 0) {
                    i7 = 524288;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            } else {
                floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i6 = 8388608;
                    } else {
                        i6 = 4194304;
                    }
                }
                if ((23967451 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation10 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j16 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation10.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation10;
                    j7 = j16;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
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
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM981getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 &= -3670017;
                        }
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = cornerBasedShapeCopy;
                        j5 = jM981getSecondary0d7_KjU;
                        j4 = jM997contentColorForek8zF_U;
                    }
                    FloatingActionButtonElevation floatingActionButtonElevation11 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    composerStartRestartGroup.endDefaults();
                    long j17 = j4;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation11.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                        public final void invoke(Composer composer3, int i12) {
                            ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                            if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                                final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                                final int i13 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                            final int i15 = i13;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                                public final void invoke(Composer composer5, int i16) {
                                                    ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        Function2<Composer, Integer, Unit> function4 = function3;
                                                        int i17 = i15;
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-2137368960);
                                                        ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        composer5.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                        composer5.endReplaceableGroup();
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
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    j6 = j5;
                    floatingActionButtonElevation2 = floatingActionButtonElevation11;
                    j7 = j17;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                    public final void invoke(Composer composer3, int i12) {
                        FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                    }
                });
            }
            i6 = 12582912;
            i3 |= i6;
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation12 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j18 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation12.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation12;
                j7 = j18;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation13 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j19 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation13.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation13;
                j7 = j19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                public final void invoke(Composer composer3, int i12) {
                    FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
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
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
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
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
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
        if ((i & 3670016) == 0) {
            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
            if ((i2 & 64) == 0) {
                i7 = 524288;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        } else {
            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation14 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j110 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation14.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation14;
                j7 = j110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
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
                    if ((i2 & 8) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -7169;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -57345;
                    } else {
                        jM981getSecondary0d7_KjU = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if ((i2 & 64) != 0) {
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 &= -3670017;
                    }
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = cornerBasedShapeCopy;
                    j5 = jM981getSecondary0d7_KjU;
                    j4 = jM997contentColorForek8zF_U;
                }
                FloatingActionButtonElevation floatingActionButtonElevation15 = floatingActionButtonElevationM1072elevationxZ9QkE;
                composerStartRestartGroup.endDefaults();
                long j111 = j4;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation15.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                    public final void invoke(Composer composer3, int i12) {
                        ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i13 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                        final int i15 = i13;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function4 = function3;
                                                    int i17 = i15;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer5.startReplaceableGroup(-1049034642);
                                                    ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                    function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                    composer5.endReplaceableGroup();
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
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j6 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation15;
                j7 = j111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

                public final void invoke(Composer composer3, int i12) {
                    FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
                }
            });
        }
        i6 = 12582912;
        i3 |= i6;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
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
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM981getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -3670017;
                }
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = cornerBasedShapeCopy;
                j5 = jM981getSecondary0d7_KjU;
                j4 = jM997contentColorForek8zF_U;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
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
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM981getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -3670017;
                }
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = cornerBasedShapeCopy;
                j5 = jM981getSecondary0d7_KjU;
                j4 = jM997contentColorForek8zF_U;
            }
            FloatingActionButtonElevation floatingActionButtonElevation16 = floatingActionButtonElevationM1072elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            long j112 = j4;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation16.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                public final void invoke(Composer composer3, int i12) {
                    ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                    if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        final int i13 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                            public final void invoke(Composer composer4, int i14) {
                                ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                    final int i15 = i13;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                        public final void invoke(Composer composer5, int i16) {
                                            ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function4 = function3;
                                                int i17 = i15;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer5.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                composer5.startReplaceableGroup(-2137368960);
                                                ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer5.startReplaceableGroup(-1049034642);
                                                ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                composer5.endReplaceableGroup();
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
            }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
            modifier3 = modifier2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            j6 = j5;
            floatingActionButtonElevation2 = floatingActionButtonElevation16;
            j7 = j112;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
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
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM981getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -3670017;
                }
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = cornerBasedShapeCopy;
                j5 = jM981getSecondary0d7_KjU;
                j4 = jM997contentColorForek8zF_U;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
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
                if ((i2 & 8) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -7169;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if ((i2 & 16) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -57345;
                } else {
                    jM981getSecondary0d7_KjU = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if ((i2 & 64) != 0) {
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 &= -3670017;
                }
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = cornerBasedShapeCopy;
                j5 = jM981getSecondary0d7_KjU;
                j4 = jM997contentColorForek8zF_U;
            }
            FloatingActionButtonElevation floatingActionButtonElevation17 = floatingActionButtonElevationM1072elevationxZ9QkE;
            composerStartRestartGroup.endDefaults();
            long j113 = j4;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, false, shape3, j5, j4, null, floatingActionButtonElevation17.elevation(mutableInteractionSource3, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m3857unboximpl(), mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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

                public final void invoke(Composer composer3, int i12) {
                    ComposerKt.sourceInformation(composer3, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                    if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(j4)))};
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        final int i13 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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

                            public final void invoke(Composer composer4, int i14) {
                                ComposerKt.sourceInformation(composer4, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer4.getSkipping()) {
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final Function2<? super Composer, ? super Integer, Unit> function3 = function2;
                                    final int i15 = i13;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                        public final void invoke(Composer composer5, int i16) {
                                            ComposerKt.sourceInformation(composer5, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer5.getSkipping()) {
                                                Modifier modifierM448defaultMinSizeVpY3zN4 = SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function4 = function3;
                                                int i17 = i15;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
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
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM448defaultMinSizeVpY3zN4);
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
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer5.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                composer5.startReplaceableGroup(-2137368960);
                                                ComposerKt.sourceInformation(composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer5.startReplaceableGroup(-1049034642);
                                                ComposerKt.sourceInformation(composer5, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                function4.invoke(composer5, Integer.valueOf((i17 >> 21) & 14));
                                                composer5.endReplaceableGroup();
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
            }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 18) & 234881024), 68);
            modifier3 = modifier2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            j6 = j5;
            floatingActionButtonElevation2 = floatingActionButtonElevation17;
            j7 = j113;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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

            public final void invoke(Composer composer3, int i12) {
                FloatingActionButtonKt.m1074FloatingActionButtonbogVsAg(onClick, modifier3, mutableInteractionSource4, shape4, j6, j7, floatingActionButtonElevation2, content, composer3, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0122  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:106:0x014f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x018a  */
    /* JADX WARN: Code duplicated, block: B:126:0x018e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0190  */
    /* JADX WARN: Code duplicated, block: B:129:0x0194  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01be  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:140:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:147:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:148:0x0232  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:91:0x0104  */
    /* JADX WARN: Code duplicated, block: B:93:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1073ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> text, final Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long jM981getSecondary0d7_KjU;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function3;
        MutableInteractionSource mutableInteractionSource2;
        CornerBasedShape cornerBasedShapeCopy;
        long jM997contentColorForek8zF_U;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape2;
        long j4;
        long j5;
        FloatingActionButtonElevation floatingActionButtonElevationM1072elevationxZ9QkE;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        Object objRememberedValue;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape3;
        final long j6;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final long j7;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)148@7090L39,149@7164L6,150@7252L6,151@7296L32,152@7406L11,154@7426L849:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & 458752) != 0) {
                        i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                    }
                    if ((i & 3670016) == 0) {
                        jM981getSecondary0d7_KjU = j;
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(jM981getSecondary0d7_KjU)) {
                            i9 = 524288;
                        } else {
                            i9 = 1048576;
                        }
                        i3 |= i9;
                    } else {
                        jM981getSecondary0d7_KjU = j;
                    }
                    if ((i & 29360128) == 0) {
                        j3 = j2;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i8 = 4194304;
                        } else {
                            i8 = 8388608;
                        }
                        i3 |= i8;
                    } else {
                        j3 = j2;
                    }
                    if ((i & 234881024) == 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                            int i11 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 67108864 : 33554432;
                            i3 |= i11;
                        } else {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                        }
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    if ((i3 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function3 = null;
                            } else {
                                function3 = function2;
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
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i2 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -458753;
                            } else {
                                cornerBasedShapeCopy = shape;
                            }
                            if ((i2 & 64) != 0) {
                                jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM997contentColorForek8zF_U = j3;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                modifier2 = companion;
                                function4 = function3;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                shape2 = cornerBasedShapeCopy;
                                j4 = jM997contentColorForek8zF_U;
                                floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                j5 = jM981getSecondary0d7_KjU;
                            } else {
                                modifier2 = companion;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                shape2 = cornerBasedShapeCopy;
                                j4 = jM997contentColorForek8zF_U;
                                j5 = jM981getSecondary0d7_KjU;
                                floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                                function4 = function3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            modifier2 = modifier;
                            mutableInteractionSource3 = mutableInteractionSource;
                            shape2 = shape;
                            j4 = j3;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function2;
                        }
                        composerStartRestartGroup.endDefaults();
                        float f = ExtendedFabSize;
                        Modifier modifierM468sizeInqDBjuR0$default = SizeKt.m468sizeInqDBjuR0$default(modifier2, f, f, 0.0f, 0.0f, 12, null);
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                                ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                                if ((i12 & 11) != 2 || !composer2.getSkipping()) {
                                    Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function6 = function4;
                                    int i13 = i3;
                                    Function2<Composer, Integer, Unit> function7 = text;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-388203689);
                                    ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                    composer2.startReplaceableGroup(-1435223762);
                                    ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                    if (function6 != null) {
                                        function6.invoke(composer2, Integer.valueOf((i13 >> 9) & 14));
                                        SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    function7.invoke(composer2, Integer.valueOf(i13 & 14));
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
                        int i12 = ((i3 >> 3) & 14) | 12582912;
                        int i13 = i3 >> 6;
                        m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda, composerStartRestartGroup, i12 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
                        modifier3 = modifier2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape3 = shape2;
                        j6 = j5;
                        function5 = function4;
                        j7 = j4;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        function5 = function2;
                        mutableInteractionSource4 = mutableInteractionSource;
                        shape3 = shape;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        j7 = j3;
                        j6 = jM981getSecondary0d7_KjU;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                            FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    jM981getSecondary0d7_KjU = j;
                    if ((i2 & 64) == 0) {
                        i9 = 524288;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    jM981getSecondary0d7_KjU = j;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i8 = 4194304;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                } else {
                    j3 = j2;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f2 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default2 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f2, f2, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i15 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i15 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i15 & 14));
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
                    int i14 = ((i3 >> 3) & 14) | 12582912;
                    int i15 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default2, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda2, composerStartRestartGroup, i14 | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f3 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default3 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f3, f3, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i17 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i17 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i17 & 14));
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
                    int i16 = ((i3 >> 3) & 14) | 12582912;
                    int i17 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default3, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda3, composerStartRestartGroup, i16 | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (i17 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                        FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    jM981getSecondary0d7_KjU = j;
                    if ((i2 & 64) == 0) {
                        i9 = 524288;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    jM981getSecondary0d7_KjU = j;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i8 = 4194304;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                } else {
                    j3 = j2;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f4 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default4 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f4, f4, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i19 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i19 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i19 & 14));
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
                    int i18 = ((i3 >> 3) & 14) | 12582912;
                    int i19 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default4, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda4, composerStartRestartGroup, i18 | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (i19 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f5 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default5 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f5, f5, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i111 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i111 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i111 & 14));
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
                    int i110 = ((i3 >> 3) & 14) | 12582912;
                    int i111 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default5, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda5, composerStartRestartGroup, i110 | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                        FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                jM981getSecondary0d7_KjU = j;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                jM981getSecondary0d7_KjU = j;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i8 = 4194304;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f6 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default6 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f6, f6, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i113 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i113 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i113 & 14));
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
                int i112 = ((i3 >> 3) & 14) | 12582912;
                int i113 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default6, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda6, composerStartRestartGroup, i112 | (i113 & 896) | (i113 & 7168) | (57344 & i113) | (458752 & i113) | (i113 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f7 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default7 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f7, f7, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i115 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i115 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i115 & 14));
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
                int i114 = ((i3 >> 3) & 14) | 12582912;
                int i115 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default7, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda7, composerStartRestartGroup, i114 | (i115 & 896) | (i115 & 7168) | (57344 & i115) | (458752 & i115) | (i115 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                    FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((i & 3670016) == 0) {
                    jM981getSecondary0d7_KjU = j;
                    if ((i2 & 64) == 0) {
                        i9 = 524288;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    jM981getSecondary0d7_KjU = j;
                }
                if ((i & 29360128) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i8 = 4194304;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                } else {
                    j3 = j2;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                        }
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f8 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default8 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f8, f8, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i117 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i117 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i117 & 14));
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
                    int i116 = ((i3 >> 3) & 14) | 12582912;
                    int i117 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default8, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda8, composerStartRestartGroup, i116 | (i117 & 896) | (i117 & 7168) | (57344 & i117) | (458752 & i117) | (i117 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
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
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i2 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -458753;
                        } else {
                            cornerBasedShapeCopy = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            modifier2 = companion;
                            function4 = function3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            j5 = jM981getSecondary0d7_KjU;
                        } else {
                            modifier2 = companion;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape2 = cornerBasedShapeCopy;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM981getSecondary0d7_KjU;
                            floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    float f9 = ExtendedFabSize;
                    Modifier modifierM468sizeInqDBjuR0$default9 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f9, f9, 0.0f, 0.0f, 12, null);
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                            if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                                Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function6 = function4;
                                int i119 = i3;
                                Function2<Composer, Integer, Unit> function7 = text;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-388203689);
                                ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                                composer2.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                                if (function6 != null) {
                                    function6.invoke(composer2, Integer.valueOf((i119 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                                }
                                composer2.endReplaceableGroup();
                                function7.invoke(composer2, Integer.valueOf(i119 & 14));
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
                    int i118 = ((i3 >> 3) & 14) | 12582912;
                    int i119 = i3 >> 6;
                    m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default9, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda9, composerStartRestartGroup, i118 | (i119 & 896) | (i119 & 7168) | (57344 & i119) | (458752 & i119) | (i119 & 3670016), 0);
                    modifier3 = modifier2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape3 = shape2;
                    j6 = j5;
                    function5 = function4;
                    j7 = j4;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                        FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                jM981getSecondary0d7_KjU = j;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                jM981getSecondary0d7_KjU = j;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i8 = 4194304;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f10 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default10 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f10, f10, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i1110 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i1111 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i1111 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i1111 & 14));
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
                int i1110 = ((i3 >> 3) & 14) | 12582912;
                int i1111 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default10, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda10, composerStartRestartGroup, i1110 | (i1111 & 896) | (i1111 & 7168) | (57344 & i1111) | (458752 & i1111) | (i1111 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f11 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default11 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f11, f11, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i1112 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i1113 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i1113 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i1113 & 14));
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
                int i1112 = ((i3 >> 3) & 14) | 12582912;
                int i1113 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default11, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda11, composerStartRestartGroup, i1112 | (i1113 & 896) | (i1113 & 7168) | (57344 & i1113) | (458752 & i1113) | (i1113 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                    FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & 458752) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((i & 3670016) == 0) {
                jM981getSecondary0d7_KjU = j;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                jM981getSecondary0d7_KjU = j;
            }
            if ((i & 29360128) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i8 = 4194304;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                    }
                    i3 |= i11;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f12 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default12 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f12, f12, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i1114 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i1115 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i1115 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i1115 & 14));
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
                int i1114 = ((i3 >> 3) & 14) | 12582912;
                int i1115 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default12, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda12, composerStartRestartGroup, i1114 | (i1115 & 896) | (i1115 & 7168) | (57344 & i1115) | (458752 & i1115) | (i1115 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
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
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i2 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -458753;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        modifier2 = companion;
                        function4 = function3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        j5 = jM981getSecondary0d7_KjU;
                    } else {
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = cornerBasedShapeCopy;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM981getSecondary0d7_KjU;
                        floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                float f13 = ExtendedFabSize;
                Modifier modifierM468sizeInqDBjuR0$default13 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f13, f13, 0.0f, 0.0f, 12, null);
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                        if ((i1116 & 11) != 2 || !composer2.getSkipping()) {
                            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function6 = function4;
                            int i1117 = i3;
                            Function2<Composer, Integer, Unit> function7 = text;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            composer2.startReplaceableGroup(-1435223762);
                            ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                            if (function6 != null) {
                                function6.invoke(composer2, Integer.valueOf((i1117 >> 9) & 14));
                                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                            }
                            composer2.endReplaceableGroup();
                            function7.invoke(composer2, Integer.valueOf(i1117 & 14));
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
                int i1116 = ((i3 >> 3) & 14) | 12582912;
                int i1117 = i3 >> 6;
                m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default13, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda13, composerStartRestartGroup, i1116 | (i1117 & 896) | (i1117 & 7168) | (57344 & i1117) | (458752 & i1117) | (i1117 & 3670016), 0);
                modifier3 = modifier2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape3 = shape2;
                j6 = j5;
                function5 = function4;
                j7 = j4;
                floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                    FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        if ((i & 458752) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
        }
        if ((i & 3670016) == 0) {
            jM981getSecondary0d7_KjU = j;
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            jM981getSecondary0d7_KjU = j;
        }
        if ((i & 29360128) == 0) {
            j3 = j2;
            if ((i2 & 128) == 0) {
                i8 = 4194304;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        } else {
            j3 = j2;
        }
        if ((i & 234881024) == 0) {
            if ((i2 & 256) == 0) {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevation2)) {
                }
                i3 |= i11;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i3 |= i11;
        } else {
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        if ((i3 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
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
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i2 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -458753;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    modifier2 = companion;
                    function4 = function3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    j5 = jM981getSecondary0d7_KjU;
                } else {
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM981getSecondary0d7_KjU;
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                    function4 = function3;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
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
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i2 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -458753;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    modifier2 = companion;
                    function4 = function3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    j5 = jM981getSecondary0d7_KjU;
                } else {
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM981getSecondary0d7_KjU;
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                    function4 = function3;
                }
            }
            composerStartRestartGroup.endDefaults();
            float f14 = ExtendedFabSize;
            Modifier modifierM468sizeInqDBjuR0$default14 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f14, f14, 0.0f, 0.0f, 12, null);
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                    ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                    if ((i1118 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function6 = function4;
                        int i1119 = i3;
                        Function2<Composer, Integer, Unit> function7 = text;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-388203689);
                        ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                        composer2.startReplaceableGroup(-1435223762);
                        ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                        if (function6 != null) {
                            function6.invoke(composer2, Integer.valueOf((i1119 >> 9) & 14));
                            SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        function7.invoke(composer2, Integer.valueOf(i1119 & 14));
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
            int i1118 = ((i3 >> 3) & 14) | 12582912;
            int i1119 = i3 >> 6;
            m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default14, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda14, composerStartRestartGroup, i1118 | (i1119 & 896) | (i1119 & 7168) | (57344 & i1119) | (458752 & i1119) | (i1119 & 3670016), 0);
            modifier3 = modifier2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shape2;
            j6 = j5;
            function5 = function4;
            j7 = j4;
            floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
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
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i2 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -458753;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    modifier2 = companion;
                    function4 = function3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    j5 = jM981getSecondary0d7_KjU;
                } else {
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM981getSecondary0d7_KjU;
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                    function4 = function3;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
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
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i2 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -458753;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                if ((i2 & 64) != 0) {
                    jM981getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m981getSecondary0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM981getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    modifier2 = companion;
                    function4 = function3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    floatingActionButtonElevationM1072elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1072elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    j5 = jM981getSecondary0d7_KjU;
                } else {
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape2 = cornerBasedShapeCopy;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM981getSecondary0d7_KjU;
                    floatingActionButtonElevationM1072elevationxZ9QkE = floatingActionButtonElevation2;
                    function4 = function3;
                }
            }
            composerStartRestartGroup.endDefaults();
            float f15 = ExtendedFabSize;
            Modifier modifierM468sizeInqDBjuR0$default15 = SizeKt.m468sizeInqDBjuR0$default(modifier2, f15, f15, 0.0f, 0.0f, 12, null);
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                    ComposerKt.sourceInformation(composer2, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                    if ((i11110 & 11) != 2 || !composer2.getSkipping()) {
                        Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, function4 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function6 = function4;
                        int i11111 = i3;
                        Function2<Composer, Integer, Unit> function7 = text;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-388203689);
                        ComposerKt.sourceInformation(composer2, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                        composer2.startReplaceableGroup(-1435223762);
                        ComposerKt.sourceInformation(composer2, "175@8157L6,176@8180L46");
                        if (function6 != null) {
                            function6.invoke(composer2, Integer.valueOf((i11111 >> 9) & 14));
                            SpacerKt.Spacer(SizeKt.m469width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), composer2, 6);
                        }
                        composer2.endReplaceableGroup();
                        function7.invoke(composer2, Integer.valueOf(i11111 & 14));
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
            int i11110 = ((i3 >> 3) & 14) | 12582912;
            int i11111 = i3 >> 6;
            m1074FloatingActionButtonbogVsAg(onClick, modifierM468sizeInqDBjuR0$default15, mutableInteractionSource3, shape2, j5, j4, floatingActionButtonElevationM1072elevationxZ9QkE, composableLambda15, composerStartRestartGroup, i11110 | (i11111 & 896) | (i11111 & 7168) | (57344 & i11111) | (458752 & i11111) | (i11111 & 3670016), 0);
            modifier3 = modifier2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape3 = shape2;
            j6 = j5;
            function5 = function4;
            j7 = j4;
            floatingActionButtonElevation3 = floatingActionButtonElevationM1072elevationxZ9QkE;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                FloatingActionButtonKt.m1073ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier3, function5, mutableInteractionSource4, shape3, j6, j7, floatingActionButtonElevation3, composer2, i | 1, i2);
            }
        });
    }
}
