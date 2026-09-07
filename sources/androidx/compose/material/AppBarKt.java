package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0087\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0080\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\u0082\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", VastAttributes.HORIZONTAL_POSITION, "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m3843constructorimpl(56);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;

    private static final float square(float f) {
        return f * f;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0133  */
    /* JADX WARN: Code duplicated, block: B:103:0x013a  */
    /* JADX WARN: Code duplicated, block: B:106:0x013f  */
    /* JADX WARN: Code duplicated, block: B:107:0x014d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x015c  */
    /* JADX WARN: Code duplicated, block: B:113:0x015f  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x0104  */
    /* JADX WARN: Code duplicated, block: B:95:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    /* JADX WARN: Code duplicated, block: B:97:0x0129  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m890TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4;
        int i7;
        long j3;
        long j4;
        int i8;
        final float fM886getTopAppBarElevationD9Ej5fM;
        int i9;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1002getLambda1$material_release;
        long primarySurface;
        long jM997contentColorForek8zF_U;
        long j5;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)81@3902L6,82@3951L32,85@4047L1254:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        function4 = function3;
                        if (composerStartRestartGroup.changed(function4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        j3 = j;
                        if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i10 = 8192;
                        } else {
                            i10 = 16384;
                        }
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    if ((i & 458752) == 0) {
                        if ((i2 & 32) == 0) {
                            j4 = j2;
                            int i12 = composerStartRestartGroup.changed(j4) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            j4 = j2;
                        }
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        fM886getTopAppBarElevationD9Ej5fM = f;
                    } else {
                        fM886getTopAppBarElevationD9Ej5fM = f;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            if (i6 != 0) {
                                function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                            } else {
                                function3M1002getLambda1$material_release = function4;
                            }
                            if ((i2 & 16) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -57345;
                            } else {
                                primarySurface = j3;
                            }
                            if ((i2 & 32) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                                i3 &= -458753;
                            } else {
                                jM997contentColorForek8zF_U = j4;
                            }
                            if (i8 != 0) {
                                fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                            }
                            j5 = jM997contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                            function5 = function2;
                            function3M1002getLambda1$material_release = function4;
                            primarySurface = j3;
                            j5 = j4;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i13 = i3 >> 12;
                        m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                invoke(rowScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope AppBar, Composer composer2, int i14) {
                                int i15;
                                int i16;
                                Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                                ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                                if ((i14 & 14) == 0) {
                                    i15 = i14 | (composer2.changed(AppBar) ? 4 : 2);
                                } else {
                                    i15 = i14;
                                }
                                if ((i15 & 91) != 18 || !composer2.getSkipping()) {
                                    if (function5 == null) {
                                        composer2.startReplaceableGroup(-512812651);
                                        ComposerKt.sourceInformation(composer2, "94@4259L29");
                                        SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                        composer2.endReplaceableGroup();
                                        i16 = 6;
                                    } else {
                                        composer2.startReplaceableGroup(-512812592);
                                        ComposerKt.sourceInformation(composer2, "96@4318L257");
                                        Modifier modifier3 = AppBarKt.TitleIconModifier;
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function2<Composer, Integer, Unit> function8 = function5;
                                        int i17 = i3;
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
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                        composer2.startReplaceableGroup(1485618042);
                                        ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                        i16 = 6;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i17 >> 3) & 112) | 8);
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                    }
                                    Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                    final Function2<Composer, Integer, Unit> function9 = title;
                                    final int i18 = i3;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = composer2.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Density density2 = (Density) objConsume4;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume5 = composer2.consume(localLayoutDirection2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume6 = composer2.consume(localViewConfiguration2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor2);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                    Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(159489950);
                                    ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i16).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                        public final void invoke(Composer composer3, int i19) {
                                            ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                            if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i18 << 3) & 112) | 8);
                                            } else {
                                                composer3.skipToGroupEnd();
                                            }
                                        }
                                    }), composer2, 48);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i16)))};
                                    final Function3<RowScope, Composer, Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                    final int i19 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                        public final void invoke(Composer composer3, int i20) {
                                            ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                            if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                                int i21 = (i19 & 7168) | 438;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume7 = composer3.consume(localDensity3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density3 = (Density) objConsume7;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume8 = composer3.consume(localLayoutDirection3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume9 = composer3.consume(localViewConfiguration3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor3);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, (i13 & 896) | (i13 & 14) | 1600512 | (i13 & 112) | ((i3 << 12) & 458752), 0);
                        modifier2 = companion;
                        function6 = function5;
                        function7 = function3M1002getLambda1$material_release;
                        j6 = primarySurface;
                        j7 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function6 = function2;
                        function7 = function4;
                        j6 = j3;
                        j7 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                function4 = function3;
                if ((57344 & i) == 0) {
                    j3 = j;
                    if ((i2 & 16) == 0) {
                        i10 = 8192;
                    } else {
                        i10 = 8192;
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
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM886getTopAppBarElevationD9Ej5fM = f;
                } else {
                    fM886getTopAppBarElevationD9Ej5fM = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i14 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i15) {
                            int i16;
                            int i17;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i15 & 14) == 0) {
                                i16 = i15 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i16 = i15;
                            }
                            if ((i16 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i17 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i18 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i17 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i18 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i19 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i17).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i110 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i19 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i17)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i110 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i110 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i14 & 896) | (i14 & 14) | 1600512 | (i14 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i15 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i16) {
                            int i17;
                            int i18;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i16 & 14) == 0) {
                                i17 = i16 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i17 = i16;
                            }
                            if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i18 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i19 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i18 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i19 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i110 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i18).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                    public final void invoke(Composer composer3, int i111) {
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i111 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i110 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i18)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i111 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i111 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i15 & 896) | (i15 & 14) | 1600512 | (i15 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changed(function4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    j3 = j;
                    if ((i2 & 16) == 0) {
                        i10 = 8192;
                    } else {
                        i10 = 8192;
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
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM886getTopAppBarElevationD9Ej5fM = f;
                } else {
                    fM886getTopAppBarElevationD9Ej5fM = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i16 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i17) {
                            int i18;
                            int i19;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i17 & 14) == 0) {
                                i18 = i17 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i18 = i17;
                            }
                            if ((i18 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i19 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i110 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i19 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i110 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i111 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i19).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i112 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i111 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i19)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i112 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i112 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i16 & 896) | (i16 & 14) | 1600512 | (i16 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i17 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i18) {
                            int i19;
                            int i110;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i18 & 14) == 0) {
                                i19 = i18 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i19 = i18;
                            }
                            if ((i19 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i110 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i111 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i110 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i111 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i112 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i110).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                    public final void invoke(Composer composer3, int i113) {
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i113 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i112 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i110)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i113 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i113 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i17 & 896) | (i17 & 14) | 1600512 | (i17 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function4 = function3;
            if ((57344 & i) == 0) {
                j3 = j;
                if ((i2 & 16) == 0) {
                    i10 = 8192;
                } else {
                    i10 = 8192;
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
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM886getTopAppBarElevationD9Ej5fM = f;
            } else {
                fM886getTopAppBarElevationD9Ej5fM = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i18 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i19) {
                        int i110;
                        int i111;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i19 & 14) == 0) {
                            i110 = i19 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i110 = i19;
                        }
                        if ((i110 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i111 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i112 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i111 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i112 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i113 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i111).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i114 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i113 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i111)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i114 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i114 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i18 & 896) | (i18 & 14) | 1600512 | (i18 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i19 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i110) {
                        int i111;
                        int i112;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i110 & 14) == 0) {
                            i111 = i110 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i111 = i110;
                        }
                        if ((i111 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i112 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i113 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i112 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i113 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i114 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i112).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                public final void invoke(Composer composer3, int i115) {
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i115 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i114 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i112)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i115 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i115 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i19 & 896) | (i19 & 14) | 1600512 | (i19 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changed(function4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    j3 = j;
                    if ((i2 & 16) == 0) {
                        i10 = 8192;
                    } else {
                        i10 = 8192;
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
                        i3 |= i12;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM886getTopAppBarElevationD9Ej5fM = f;
                } else {
                    fM886getTopAppBarElevationD9Ej5fM = f;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i110 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i111) {
                            int i112;
                            int i113;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i111 & 14) == 0) {
                                i112 = i111 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i112 = i111;
                            }
                            if ((i112 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i113 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i114 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i113 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i114 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i115 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i113).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i116 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i115 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i113)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i116 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i116 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i110 & 896) | (i110 & 14) | 1600512 | (i110 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        if (i6 != 0) {
                            function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                        } else {
                            function3M1002getLambda1$material_release = function4;
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -57345;
                        } else {
                            primarySurface = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        } else {
                            jM997contentColorForek8zF_U = j4;
                        }
                        if (i8 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        j5 = jM997contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111 = i3 >> 12;
                    m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope AppBar, Composer composer2, int i112) {
                            int i113;
                            int i114;
                            Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                            ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                            if ((i112 & 14) == 0) {
                                i113 = i112 | (composer2.changed(AppBar) ? 4 : 2);
                            } else {
                                i113 = i112;
                            }
                            if ((i113 & 91) != 18 || !composer2.getSkipping()) {
                                if (function5 == null) {
                                    composer2.startReplaceableGroup(-512812651);
                                    ComposerKt.sourceInformation(composer2, "94@4259L29");
                                    SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                    composer2.endReplaceableGroup();
                                    i114 = 6;
                                } else {
                                    composer2.startReplaceableGroup(-512812592);
                                    ComposerKt.sourceInformation(composer2, "96@4318L257");
                                    Modifier modifier3 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function8 = function5;
                                    int i115 = i3;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                    composer2.startReplaceableGroup(1485618042);
                                    ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                    i114 = 6;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i115 >> 3) & 112) | 8);
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                                final int i116 = i3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) objConsume4;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composer2.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composer2.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-678309503);
                                ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(159489950);
                                ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i114).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                    public final void invoke(Composer composer3, int i117) {
                                        ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if ((i117 & 11) != 2 || !composer3.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i116 << 3) & 112) | 8);
                                        } else {
                                            composer3.skipToGroupEnd();
                                        }
                                    }
                                }), composer2, 48);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i114)))};
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                                final int i117 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer3, int i20) {
                                        ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                            int i21 = (i117 & 7168) | 438;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume7 = composer3.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density3 = (Density) objConsume7;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume8 = composer3.consume(localLayoutDirection3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume9 = composer3.consume(localViewConfiguration3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, (i111 & 896) | (i111 & 14) | 1600512 | (i111 & 112) | ((i3 << 12) & 458752), 0);
                    modifier2 = companion;
                    function6 = function5;
                    function7 = function3M1002getLambda1$material_release;
                    j6 = primarySurface;
                    j7 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function4 = function3;
            if ((57344 & i) == 0) {
                j3 = j;
                if ((i2 & 16) == 0) {
                    i10 = 8192;
                } else {
                    i10 = 8192;
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
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM886getTopAppBarElevationD9Ej5fM = f;
            } else {
                fM886getTopAppBarElevationD9Ej5fM = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i112 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i113) {
                        int i114;
                        int i115;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i113 & 14) == 0) {
                            i114 = i113 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i114 = i113;
                        }
                        if ((i114 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i115 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i116 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i115 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i116 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i117 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i115).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i118 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i117 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i115)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i118 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i118 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i112 & 896) | (i112 & 14) | 1600512 | (i112 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i113 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i114) {
                        int i115;
                        int i116;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i114 & 14) == 0) {
                            i115 = i114 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i115 = i114;
                        }
                        if ((i115 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i116 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i117 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i116 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i117 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i118 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i116).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                public final void invoke(Composer composer3, int i119) {
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i119 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i118 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i116)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i119 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i119 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i113 & 896) | (i113 & 14) | 1600512 | (i113 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changed(function4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                j3 = j;
                if ((i2 & 16) == 0) {
                    i10 = 8192;
                } else {
                    i10 = 8192;
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
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM886getTopAppBarElevationD9Ej5fM = f;
            } else {
                fM886getTopAppBarElevationD9Ej5fM = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i114 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i115) {
                        int i116;
                        int i117;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i115 & 14) == 0) {
                            i116 = i115 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i116 = i115;
                        }
                        if ((i116 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i117 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i118 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i117 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i118 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i119 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i117).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i1110 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i119 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i117)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i1110 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i1110 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i114 & 896) | (i114 & 14) | 1600512 | (i114 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    if (i6 != 0) {
                        function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                    } else {
                        function3M1002getLambda1$material_release = function4;
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -57345;
                    } else {
                        primarySurface = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -458753;
                    } else {
                        jM997contentColorForek8zF_U = j4;
                    }
                    if (i8 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    j5 = jM997contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                int i115 = i3 >> 12;
                m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope AppBar, Composer composer2, int i116) {
                        int i117;
                        int i118;
                        Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                        ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                        if ((i116 & 14) == 0) {
                            i117 = i116 | (composer2.changed(AppBar) ? 4 : 2);
                        } else {
                            i117 = i116;
                        }
                        if ((i117 & 91) != 18 || !composer2.getSkipping()) {
                            if (function5 == null) {
                                composer2.startReplaceableGroup(-512812651);
                                ComposerKt.sourceInformation(composer2, "94@4259L29");
                                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                                composer2.endReplaceableGroup();
                                i118 = 6;
                            } else {
                                composer2.startReplaceableGroup(-512812592);
                                ComposerKt.sourceInformation(composer2, "96@4318L257");
                                Modifier modifier3 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function8 = function5;
                                int i119 = i3;
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                                composer2.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                i118 = 6;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i119 >> 3) & 112) | 8);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                            final int i1110 = i3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) objConsume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i118).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                public final void invoke(Composer composer3, int i1111) {
                                    ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                    if ((i1111 & 11) != 2 || !composer3.getSkipping()) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i1110 << 3) & 112) | 8);
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 48);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i118)))};
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                            final int i1111 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer3, int i20) {
                                    ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                        int i21 = (i1111 & 7168) | 438;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume7 = composer3.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density3 = (Density) objConsume7;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume8 = composer3.consume(localLayoutDirection3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume9 = composer3.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, (i115 & 896) | (i115 & 14) | 1600512 | (i115 & 112) | ((i3 << 12) & 458752), 0);
                modifier2 = companion;
                function6 = function5;
                function7 = function3M1002getLambda1$material_release;
                j6 = primarySurface;
                j7 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        function4 = function3;
        if ((57344 & i) == 0) {
            j3 = j;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
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
                i3 |= i12;
            } else {
                j4 = j2;
            }
            i3 |= i12;
        } else {
            j4 = j2;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            fM886getTopAppBarElevationD9Ej5fM = f;
        } else {
            fM886getTopAppBarElevationD9Ej5fM = f;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                if (i6 != 0) {
                    function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                } else {
                    function3M1002getLambda1$material_release = function4;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                j5 = jM997contentColorForek8zF_U;
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                if (i6 != 0) {
                    function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                } else {
                    function3M1002getLambda1$material_release = function4;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                j5 = jM997contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            int i116 = i3 >> 12;
            m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope AppBar, Composer composer2, int i117) {
                    int i118;
                    int i119;
                    Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                    ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                    if ((i117 & 14) == 0) {
                        i118 = i117 | (composer2.changed(AppBar) ? 4 : 2);
                    } else {
                        i118 = i117;
                    }
                    if ((i118 & 91) != 18 || !composer2.getSkipping()) {
                        if (function5 == null) {
                            composer2.startReplaceableGroup(-512812651);
                            ComposerKt.sourceInformation(composer2, "94@4259L29");
                            SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                            composer2.endReplaceableGroup();
                            i119 = 6;
                        } else {
                            composer2.startReplaceableGroup(-512812592);
                            ComposerKt.sourceInformation(composer2, "96@4318L257");
                            Modifier modifier3 = AppBarKt.TitleIconModifier;
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function8 = function5;
                            int i1110 = i3;
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                            composer2.startReplaceableGroup(1485618042);
                            ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                            i119 = 6;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i1110 >> 3) & 112) | 8);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                        final int i1111 = i3;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composer2.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density2 = (Density) objConsume4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composer2.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composer2.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                        Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(159489950);
                        ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i119).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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
                                ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                if ((i1112 & 11) != 2 || !composer3.getSkipping()) {
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i1111 << 3) & 112) | 8);
                                } else {
                                    composer3.skipToGroupEnd();
                                }
                            }
                        }), composer2, 48);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i119)))};
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                        final int i1112 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer composer3, int i20) {
                                ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                    Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                    int i21 = (i1112 & 7168) | 438;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume7 = composer3.consume(localDensity3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density3 = (Density) objConsume7;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume8 = composer3.consume(localLayoutDirection3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume9 = composer3.consume(localViewConfiguration3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                    Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer3.enableReusing();
                                    function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                    function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
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
            }), composerStartRestartGroup, (i116 & 896) | (i116 & 14) | 1600512 | (i116 & 112) | ((i3 << 12) & 458752), 0);
            modifier2 = companion;
            function6 = function5;
            function7 = function3M1002getLambda1$material_release;
            j6 = primarySurface;
            j7 = j5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                if (i6 != 0) {
                    function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                } else {
                    function3M1002getLambda1$material_release = function4;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                j5 = jM997contentColorForek8zF_U;
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                if (i6 != 0) {
                    function3M1002getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1002getLambda1$material_release();
                } else {
                    function3M1002getLambda1$material_release = function4;
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -57345;
                } else {
                    primarySurface = j3;
                }
                if ((i2 & 32) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -458753;
                } else {
                    jM997contentColorForek8zF_U = j4;
                }
                if (i8 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                j5 = jM997contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            int i117 = i3 >> 12;
            m887AppBarcelAv9A(primarySurface, j5, fM886getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), companion, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope AppBar, Composer composer2, int i118) {
                    int i119;
                    int i1110;
                    Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                    ComposerKt.sourceInformation(composer2, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                    if ((i118 & 14) == 0) {
                        i119 = i118 | (composer2.changed(AppBar) ? 4 : 2);
                    } else {
                        i119 = i118;
                    }
                    if ((i119 & 91) != 18 || !composer2.getSkipping()) {
                        if (function5 == null) {
                            composer2.startReplaceableGroup(-512812651);
                            ComposerKt.sourceInformation(composer2, "94@4259L29");
                            SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                            composer2.endReplaceableGroup();
                            i1110 = 6;
                        } else {
                            composer2.startReplaceableGroup(-512812592);
                            ComposerKt.sourceInformation(composer2, "96@4318L257");
                            Modifier modifier3 = AppBarKt.TitleIconModifier;
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function8 = function5;
                            int i1111 = i3;
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
                            composer2.startReplaceableGroup(1485618042);
                            ComposerKt.sourceInformation(composer2, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                            i1110 = 6;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, function8, composer2, ((i1111 >> 3) & 112) | 8);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        Modifier modifierWeight$default = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<? super Composer, ? super Integer, Unit> function9 = title;
                        final int i1112 = i3;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composer2.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density2 = (Density) objConsume4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composer2.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composer2.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                        Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(159489950);
                        ComposerKt.sourceInformation(composer2, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, i1110).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                            public final void invoke(Composer composer3, int i1113) {
                                ComposerKt.sourceInformation(composer3, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                if ((i1113 & 11) != 2 || !composer3.getSkipping()) {
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)))}, function9, composer3, ((i1112 << 3) & 112) | 8);
                                } else {
                                    composer3.skipToGroupEnd();
                                }
                            }
                        }), composer2, 48);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, i1110)))};
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function3M1002getLambda1$material_release;
                        final int i1113 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer composer3, int i20) {
                                ComposerKt.sourceInformation(composer3, "C117@5070L215:AppBar.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                    Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function11 = function10;
                                    int i21 = (i1113 & 7168) | 438;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume7 = composer3.consume(localDensity3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density3 = (Density) objConsume7;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume8 = composer3.consume(localLayoutDirection3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume9 = composer3.consume(localViewConfiguration3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer3);
                                    Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer3.enableReusing();
                                    function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                    function11.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i21 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
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
            }), composerStartRestartGroup, (i117 & 896) | (i117 & 14) | 1600512 | (i117 & 112) | ((i3 << 12) & 458752), 0);
            modifier2 = companion;
            function6 = function5;
            function7 = function3M1002getLambda1$material_release;
            j6 = primarySurface;
            j7 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AppBarKt.m890TopAppBarxWeB9s(title, modifier2, function6, function7, j6, j7, fM886getTopAppBarElevationD9Ej5fM, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0187  */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00df  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:91:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x011c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:98:0x0132  */
    /* JADX WARN: Code duplicated, block: B:99:0x0142  */
    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m889TopAppBarHsRjFd4(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        long primarySurface;
        long jM997contentColorForek8zF_U;
        float fM886getTopAppBarElevationD9Ej5fM;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        Modifier.Companion companion;
        Modifier modifier3;
        PaddingValues contentPadding;
        long j3;
        long j4;
        float f2;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1897058582);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)156@6973L6,157@7022L32,162@7231L182:AppBar.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
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
                int i8 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i8;
            } else {
                primarySurface = j;
            }
            i3 |= i8;
        } else {
            primarySurface = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM997contentColorForek8zF_U = j2;
                int i9 = composerStartRestartGroup.changed(jM997contentColorForek8zF_U) ? 256 : 128;
                i3 |= i9;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            i3 |= i9;
        } else {
            jM997contentColorForek8zF_U = j2;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 7168) == 0) {
                fM886getTopAppBarElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM886getTopAppBarElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
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
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            modifier3 = modifier2;
                        } else {
                            if (i7 != 0) {
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
                            if (i10 != 0) {
                                fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                modifier3 = companion;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                j3 = primarySurface;
                                j4 = jM997contentColorForek8zF_U;
                                f2 = fM886getTopAppBarElevationD9Ej5fM;
                            } else {
                                modifier3 = companion;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i11 = i3 >> 3;
                            m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i11 & 7168) | (i11 & 14) | 24576 | (i11 & 112) | (i11 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                            modifier2 = modifier3;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            paddingValues3 = contentPadding;
                        }
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        composerStartRestartGroup.endDefaults();
                        int i12 = i3 >> 3;
                        m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i12 & 7168) | (i12 & 14) | 24576 | (i12 & 112) | (i12 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                        modifier2 = modifier3;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        paddingValues3 = contentPadding;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j5 = primarySurface;
                        j6 = jM997contentColorForek8zF_U;
                        f3 = fM886getTopAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                        }
                    });
                }
                i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i6;
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i13 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i13 & 7168) | (i13 & 14) | 24576 | (i13 & 112) | (i13 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i14 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i14 & 7168) | (i14 & 14) | 24576 | (i14 & 112) | (i14 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            paddingValues2 = paddingValues;
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
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i15 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i15 & 7168) | (i15 & 14) | 24576 | (i15 & 112) | (i15 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i16 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i16 & 7168) | (i16 & 14) | 24576 | (i16 & 112) | (i16 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i17 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i17 & 7168) | (i17 & 14) | 24576 | (i17 & 112) | (i17 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i18 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i18 & 7168) | (i18 & 14) | 24576 | (i18 & 112) | (i18 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        fM886getTopAppBarElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
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
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i19 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i19 & 7168) | (i19 & 14) | 24576 | (i19 & 112) | (i19 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    } else {
                        if (i7 != 0) {
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
                        if (i10 != 0) {
                            fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            f2 = fM886getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    int i110 = i3 >> 3;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i110 & 7168) | (i110 & 14) | 24576 | (i110 & 112) | (i110 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                    modifier2 = modifier3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    paddingValues3 = contentPadding;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i6;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i111 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i111 & 7168) | (i111 & 14) | 24576 | (i111 & 112) | (i111 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i112 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i112 & 7168) | (i112 & 14) | 24576 | (i112 & 112) | (i112 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        paddingValues2 = paddingValues;
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
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i113 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i113 & 7168) | (i113 & 14) | 24576 | (i113 & 112) | (i113 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i7 != 0) {
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
                    if (i10 != 0) {
                        fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        f2 = fM886getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                int i114 = i3 >> 3;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i114 & 7168) | (i114 & 14) | 24576 | (i114 & 112) | (i114 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
                modifier2 = modifier3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                paddingValues3 = contentPadding;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i6;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i7 != 0) {
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
                if (i10 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            } else {
                if (i7 != 0) {
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
                if (i10 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            }
            composerStartRestartGroup.endDefaults();
            int i115 = i3 >> 3;
            m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i115 & 7168) | (i115 & 14) | 24576 | (i115 & 112) | (i115 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
            modifier2 = modifier3;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            paddingValues3 = contentPadding;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i7 != 0) {
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
                if (i10 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            } else {
                if (i7 != 0) {
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
                if (i10 != 0) {
                    fM886getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m886getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    f2 = fM886getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                }
            }
            composerStartRestartGroup.endDefaults();
            int i116 = i3 >> 3;
            m887AppBarcelAv9A(j3, j4, f2, contentPadding, RectangleShapeKt.getRectangleShape(), modifier3, content, composerStartRestartGroup, (i116 & 7168) | (i116 & 14) | 24576 | (i116 & 112) | (i116 & 896) | ((i3 << 15) & 458752) | (3670016 & (i3 << 3)), 0);
            modifier2 = modifier3;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            paddingValues3 = contentPadding;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AppBarKt.m889TopAppBarHsRjFd4(modifier2, j5, j6, f3, paddingValues3, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0134  */
    /* JADX WARN: Code duplicated, block: B:101:0x0142  */
    /* JADX WARN: Code duplicated, block: B:104:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x0159  */
    /* JADX WARN: Code duplicated, block: B:110:0x0162  */
    /* JADX WARN: Code duplicated, block: B:111:0x0173  */
    /* JADX WARN: Code duplicated, block: B:114:0x0199 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:118:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x0105  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:97:0x012e  */
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    public static final void m888BottomAppBarY1yfwus(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        long jM997contentColorForek8zF_U;
        Shape shape2;
        int i4;
        float fM885getBottomAppBarElevationD9Ej5fM;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        int i8;
        Modifier.Companion companion;
        long primarySurface;
        long j3;
        long j4;
        Shape shape3;
        float f2;
        PaddingValues contentPadding;
        Modifier modifier2;
        Shape rectangleShape;
        final Modifier modifier3;
        final float f3;
        final long j5;
        final long j6;
        final PaddingValues paddingValues3;
        final Shape shape4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)216@9902L6,217@9951L32,223@10232L7,229@10422L152:AppBar.kt#jmzs0o");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(j)) ? 32 : 16;
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
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((57344 & i) == 0) {
                    fM885getBottomAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM885getBottomAppBarElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    paddingValues2 = paddingValues;
                } else {
                    paddingValues2 = paddingValues;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -113;
                            } else {
                                primarySurface = j;
                            }
                            if ((i2 & 4) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i11 != 0) {
                                shape2 = null;
                            }
                            if (i4 != 0) {
                                fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                modifier2 = companion;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                j3 = primarySurface;
                                j4 = jM997contentColorForek8zF_U;
                                shape3 = shape2;
                                f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            } else {
                                j3 = primarySurface;
                                j4 = jM997contentColorForek8zF_U;
                                shape3 = shape2;
                                f2 = fM885getBottomAppBarElevationD9Ej5fM;
                                contentPadding = paddingValues2;
                                modifier2 = companion;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            j3 = j;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localFabPlacement);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FabPlacement fabPlacement = (FabPlacement) objConsume;
                        if (shape3 == null && fabPlacement != null && fabPlacement.getIsDocked()) {
                            rectangleShape = new BottomAppBarCutoutShape(shape3, fabPlacement);
                        } else {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        int i12 = i3 >> 6;
                        m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i12 & 896) | (i12 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                        modifier3 = modifier2;
                        f3 = f2;
                        j5 = j3;
                        j6 = j4;
                        paddingValues3 = contentPadding;
                        shape4 = shape3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        j5 = j;
                        j6 = jM997contentColorForek8zF_U;
                        shape4 = shape2;
                        f3 = fM885getBottomAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                        }
                    });
                }
                i8 = 1572864;
                i3 |= i8;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localFabPlacement2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement2 = (FabPlacement) objConsume2;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i13 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i13 & 896) | (i13 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement3 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localFabPlacement3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement3 = (FabPlacement) objConsume3;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i14 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i14 & 896) | (i14 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            fM885getBottomAppBarElevationD9Ej5fM = f;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                paddingValues2 = paddingValues;
            } else {
                paddingValues2 = paddingValues;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement4 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localFabPlacement4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement4 = (FabPlacement) objConsume4;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i15 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i15 & 896) | (i15 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement5 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localFabPlacement5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement5 = (FabPlacement) objConsume5;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i16 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i16 & 896) | (i16 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement6 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localFabPlacement6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement6 = (FabPlacement) objConsume6;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i17 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i17 & 896) | (i17 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement7 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localFabPlacement7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement7 = (FabPlacement) objConsume7;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i18 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i18 & 896) | (i18 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        shape2 = shape;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((57344 & i) == 0) {
                fM885getBottomAppBarElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM885getBottomAppBarElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                paddingValues2 = paddingValues;
            } else {
                paddingValues2 = paddingValues;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement8 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localFabPlacement8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement8 = (FabPlacement) objConsume8;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i19 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i19 & 896) | (i19 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        } else {
                            primarySurface = j;
                        }
                        if ((i2 & 4) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier2 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        } else {
                            j3 = primarySurface;
                            j4 = jM997contentColorForek8zF_U;
                            shape3 = shape2;
                            f2 = fM885getBottomAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            modifier2 = companion;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement9 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localFabPlacement9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement9 = (FabPlacement) objConsume9;
                    if (shape3 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i110 = i3 >> 6;
                    m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i110 & 896) | (i110 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                    modifier3 = modifier2;
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    paddingValues3 = contentPadding;
                    shape4 = shape3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                    }
                });
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement10 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localFabPlacement10);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement10 = (FabPlacement) objConsume10;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i111 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i111 & 896) | (i111 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement11 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localFabPlacement11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement11 = (FabPlacement) objConsume11;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i112 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i112 & 896) | (i112 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        fM885getBottomAppBarElevationD9Ej5fM = f;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            paddingValues2 = paddingValues;
        } else {
            paddingValues2 = paddingValues;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement12 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localFabPlacement12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement12 = (FabPlacement) objConsume12;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i113 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i113 & 896) | (i113 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    } else {
                        primarySurface = j;
                    }
                    if ((i2 & 4) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i11 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier2 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    } else {
                        j3 = primarySurface;
                        j4 = jM997contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM885getBottomAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        modifier2 = companion;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<FabPlacement> localFabPlacement13 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localFabPlacement13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement13 = (FabPlacement) objConsume13;
                if (shape3 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i114 = i3 >> 6;
                m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i114 & 896) | (i114 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
                modifier3 = modifier2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                paddingValues3 = contentPadding;
                shape4 = shape3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
                }
            });
        }
        i8 = 1572864;
        i3 |= i8;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier2 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                } else {
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    modifier2 = companion;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier2 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                } else {
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    modifier2 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<FabPlacement> localFabPlacement14 = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localFabPlacement14);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FabPlacement fabPlacement14 = (FabPlacement) objConsume14;
            if (shape3 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            int i115 = i3 >> 6;
            m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i115 & 896) | (i115 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
            modifier3 = modifier2;
            f3 = f2;
            j5 = j3;
            j6 = j4;
            paddingValues3 = contentPadding;
            shape4 = shape3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier2 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                } else {
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    modifier2 = companion;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                } else {
                    primarySurface = j;
                }
                if ((i2 & 4) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i11 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM885getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m885getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier2 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                } else {
                    j3 = primarySurface;
                    j4 = jM997contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM885getBottomAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    modifier2 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<FabPlacement> localFabPlacement15 = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume15 = composerStartRestartGroup.consume(localFabPlacement15);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FabPlacement fabPlacement15 = (FabPlacement) objConsume15;
            if (shape3 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            int i116 = i3 >> 6;
            m887AppBarcelAv9A(j3, j4, f2, contentPadding, rectangleShape, modifier2, content, composerStartRestartGroup, ((i3 >> 3) & 126) | (i116 & 896) | (i116 & 7168) | ((i3 << 15) & 458752) | (i3 & 3670016), 0);
            modifier3 = modifier2;
            f3 = f2;
            j5 = j3;
            j6 = j4;
            paddingValues3 = contentPadding;
            shape4 = shape3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AppBarKt.m888BottomAppBarY1yfwus(modifier3, j5, j6, shape4, f3, paddingValues3, content, composer2, i | 1, i2);
            }
        });
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((f * f) - (f2 * f2)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Float fValueOf;
        Float fValueOf2;
        Pair pair;
        Float fValueOf3;
        Float fValueOf4;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = (f * f) + f4;
        float f7 = f4 * f5 * (f6 - f5);
        float f8 = f * f5;
        double d = f7;
        float fSqrt = (f8 - ((float) Math.sqrt(d))) / f6;
        float fSqrt2 = (f8 + ((float) Math.sqrt(d))) / f6;
        float fSqrt3 = (float) Math.sqrt(f5 - (fSqrt * fSqrt));
        float fSqrt4 = (float) Math.sqrt(f5 - (fSqrt2 * fSqrt2));
        if (f2 > 0.0f) {
            if (fSqrt3 > fSqrt4) {
                fValueOf3 = Float.valueOf(fSqrt);
                fValueOf4 = Float.valueOf(fSqrt3);
            } else {
                fValueOf3 = Float.valueOf(fSqrt2);
                fValueOf4 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf3, fValueOf4);
        } else {
            if (fSqrt3 < fSqrt4) {
                fValueOf = Float.valueOf(fSqrt);
                fValueOf2 = Float.valueOf(fSqrt3);
            } else {
                fValueOf = Float.valueOf(fSqrt2);
                fValueOf2 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf, fValueOf2);
        }
        float fFloatValue = ((Number) pair.component1()).floatValue();
        float fFloatValue2 = ((Number) pair.component2()).floatValue();
        if (fFloatValue < f) {
            fFloatValue2 = -fFloatValue2;
        }
        return TuplesKt.to(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x013c  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AppBar-celAv9A, reason: not valid java name */
    public static final void m887AppBarcelAv9A(final long j, final long j2, final float f, final PaddingValues paddingValues, final Shape shape, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249680788);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,5)513@22344L583:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i4 = 256;
                    } else {
                        i4 = 128;
                    }
                    i3 |= i4;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i2 & 16) != 0) {
                    if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changed(shape)) {
                            i6 = 16384;
                        } else {
                            i6 = 8192;
                        }
                        i3 |= i6;
                    }
                    i7 = i2 & 32;
                    if (i7 != 0) {
                        if ((i & 458752) == 0) {
                            modifier2 = modifier;
                            if (composerStartRestartGroup.changed(modifier2)) {
                                i8 = 131072;
                            } else {
                                i8 = 65536;
                            }
                            i3 |= i8;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            if (composerStartRestartGroup.changed(function3)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((2995931 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                            if (i7 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            int i10 = i3 << 6;
                            SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i11) {
                                    ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                    if ((i11 & 11) != 2 || !composer2.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                        final PaddingValues paddingValues2 = paddingValues;
                                        final Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                                        final int i12 = i3;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                            public final void invoke(Composer composer3, int i13) {
                                                ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                                if ((i13 & 11) != 2 || !composer3.getSkipping()) {
                                                    Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i14 = ((i12 >> 9) & 7168) | 432;
                                                    composer3.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer3.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer3.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer3.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    composer3.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer3.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    composer3.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i14 >> 6) & 112) | 6));
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
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
                            }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i10 & 896) | (i10 & 7168) | ((i3 << 9) & 458752), 16);
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        final Modifier modifier4 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11) {
                                AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier4, function3, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    modifier2 = modifier;
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(function3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i11 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i12 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i13 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i15 = ((i13 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i11 & 896) | (i11 & 7168) | ((i3 << 9) & 458752), 16);
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i12 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i13 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i14 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                        public final void invoke(Composer composer3, int i15) {
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i16 = ((i14 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i16 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i12 & 896) | (i12 & 7168) | ((i3 << 9) & 458752), 16);
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final Modifier modifier5 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier5, function3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                i7 = i2 & 32;
                if (i7 != 0) {
                    if ((i & 458752) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(function3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i13 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i15 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i17 = ((i15 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i17 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i13 & 896) | (i13 & 7168) | ((i3 << 9) & 458752), 16);
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i14 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i16 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i17 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i18 = ((i16 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i18 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i14 & 896) | (i14 & 7168) | ((i3 << 9) & 458752), 16);
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final Modifier modifier6 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier6, function3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                modifier2 = modifier;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i15 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i17 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i19 = ((i17 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i19 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i15 & 896) | (i15 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i16 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i18 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i19) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i110 = ((i18 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i110 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i16 & 896) | (i16 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier7 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier7, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 32;
                if (i7 != 0) {
                    if ((i & 458752) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(function3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i17 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i19 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i110 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i111 = ((i19 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i111 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i17 & 896) | (i17 & 7168) | ((i3 << 9) & 458752), 16);
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i18 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i110 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                        public final void invoke(Composer composer3, int i111) {
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i111 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i112 = ((i110 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i112 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i18 & 896) | (i18 & 7168) | ((i3 << 9) & 458752), 16);
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final Modifier modifier8 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier8, function3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                modifier2 = modifier;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i19 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i111 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i112 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i113 = ((i111 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i113 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i19 & 896) | (i19 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i110 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i112 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i113) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i113 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i114 = ((i112 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i114 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i110 & 896) | (i110 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier9 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier9, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            i7 = i2 & 32;
            if (i7 != 0) {
                if ((i & 458752) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i111 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i113 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i114 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i115 = ((i113 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i115 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i111 & 896) | (i111 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i112 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i114 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i115) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i115 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i116 = ((i114 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i116 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i112 & 896) | (i112 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier10 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier10, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((2995931 & i3) == 599186) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i113 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i115 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i116 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i117 = ((i115 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i117 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i113 & 896) | (i113 & 7168) | ((i3 << 9) & 458752), 16);
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i114 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i116 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                public final void invoke(Composer composer3, int i117) {
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i117 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i118 = ((i116 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i118 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i114 & 896) | (i114 & 7168) | ((i3 << 9) & 458752), 16);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier11 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier11, function3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        if ((i2 & 4) != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 32;
                if (i7 != 0) {
                    if ((i & 458752) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((3670016 & i) == 0) {
                        if (composerStartRestartGroup.changed(function3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((2995931 & i3) == 599186) {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i115 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i117 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i118 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i119 = ((i117 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i119 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i115 & 896) | (i115 & 7168) | ((i3 << 9) & 458752), 16);
                    } else {
                        if (i7 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        int i116 = i3 << 6;
                        SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                                if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i118 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                        public final void invoke(Composer composer3, int i119) {
                                            ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                            if ((i119 & 11) != 2 || !composer3.getSkipping()) {
                                                Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i1110 = ((i118 >> 9) & 7168) | 432;
                                                composer3.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer3.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer3.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer3.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                composer3.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer3.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                composer3.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1110 >> 6) & 112) | 6));
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
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
                        }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i116 & 896) | (i116 & 7168) | ((i3 << 9) & 458752), 16);
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final Modifier modifier12 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier12, function3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                modifier2 = modifier;
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i117 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i119 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1110 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1111 = ((i119 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1111 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i117 & 896) | (i117 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i118 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i119 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i1110 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i1111) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1111 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1112 = ((i1110 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1112 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i118 & 896) | (i118 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier13 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier13, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            i7 = i2 & 32;
            if (i7 != 0) {
                if ((i & 458752) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i119 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i1110 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i1111 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1112 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1113 = ((i1111 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1113 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i119 & 896) | (i119 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i1110 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i1111 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i1112 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i1113) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1113 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1114 = ((i1112 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1114 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1110 & 896) | (i1110 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier14 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier14, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((2995931 & i3) == 599186) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1111 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1112 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i1113 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i1114 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i1115 = ((i1113 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1115 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1111 & 896) | (i1111 & 7168) | ((i3 << 9) & 458752), 16);
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1112 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1113 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i1114 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                public final void invoke(Composer composer3, int i1115) {
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i1115 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i1116 = ((i1114 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1116 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1112 & 896) | (i1112 & 7168) | ((i3 << 9) & 458752), 16);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier15 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier15, function3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if ((i2 & 16) != 0) {
            if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            i7 = i2 & 32;
            if (i7 != 0) {
                if ((i & 458752) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((3670016 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((2995931 & i3) == 599186) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i1113 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i1114 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i1115 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1116 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1117 = ((i1115 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1117 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1113 & 896) | (i1113 & 7168) | ((i3 << 9) & 458752), 16);
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    int i1114 = i3 << 6;
                    SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                            if ((i1115 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                final int i1116 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer3, int i1117) {
                                        ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                        if ((i1117 & 11) != 2 || !composer3.getSkipping()) {
                                            Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                            int i1118 = ((i1116 >> 9) & 7168) | 432;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            composer3.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                            function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1118 >> 6) & 112) | 6));
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                    }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1114 & 896) | (i1114 & 7168) | ((i3 << 9) & 458752), 16);
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Modifier modifier16 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier16, function3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((2995931 & i3) == 599186) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1115 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1116 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i1117 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i1118 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i1119 = ((i1117 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i1119 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1115 & 896) | (i1115 & 7168) | ((i3 << 9) & 458752), 16);
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1116 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1117 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i1118 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                public final void invoke(Composer composer3, int i1119) {
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i1119 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i11110 = ((i1118 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11110 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1116 & 896) | (i1116 & 7168) | ((i3 << 9) & 458752), 16);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier17 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier17, function3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        i7 = i2 & 32;
        if (i7 != 0) {
            if ((i & 458752) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((2995931 & i3) == 599186) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1117 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1118 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i1119 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i11110 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i11111 = ((i1119 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11111 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1117 & 896) | (i1117 & 7168) | ((i3 << 9) & 458752), 16);
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                int i1118 = i3 << 6;
                SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                        if ((i1119 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                            final int i11110 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                public final void invoke(Composer composer3, int i11111) {
                                    ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                    if ((i11111 & 11) != 2 || !composer3.getSkipping()) {
                                        Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                        int i11112 = ((i11110 >> 9) & 7168) | 432;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composer3.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density = (Density) objConsume;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composer3.consume(localViewConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer3.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        composer3.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                        function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11112 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
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
                }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1118 & 896) | (i1118 & 7168) | ((i3 << 9) & 458752), 16);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier18 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier18, function3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((3670016 & i) == 0) {
            if (composerStartRestartGroup.changed(function3)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((2995931 & i3) == 599186) {
            if (i7 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            int i1119 = i3 << 6;
            SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                    if ((i11110 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                        final int i11111 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                if ((i11112 & 11) != 2 || !composer3.getSkipping()) {
                                    Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                    int i11113 = ((i11111 >> 9) & 7168) | 432;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer3.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density = (Density) objConsume;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer3.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composer3.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer3.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                    function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11113 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
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
            }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i1119 & 896) | (i1119 & 7168) | ((i3 << 9) & 458752), 16);
        } else {
            if (i7 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            int i11110 = i3 << 6;
            SurfaceKt.m1175SurfaceFjzlyU(modifier3, shape, j, j2, null, f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                    if ((i11111 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                        final int i11112 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                            public final void invoke(Composer composer3, int i11113) {
                                ComposerKt.sourceInformation(composer3, "C521@22608L303:AppBar.kt#jmzs0o");
                                if ((i11113 & 11) != 2 || !composer3.getSkipping()) {
                                    Modifier modifierM450height3ABfNKs = SizeKt.m450height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues2), AppBarKt.AppBarHeight);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                    int i11114 = ((i11112 >> 9) & 7168) | 432;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composer3.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density = (Density) objConsume;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer3.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composer3.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM450height3ABfNKs);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer3);
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer3.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer3, "C80@3988L9:Row.kt#2w3rfo");
                                    function5.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11114 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
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
            }), composerStartRestartGroup, ((i3 >> 15) & 14) | 1572864 | ((i3 >> 9) & 112) | (i11110 & 896) | (i11110 & 7168) | ((i3 << 9) & 458752), 16);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier19 = modifier3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AppBarKt.m887AppBarcelAv9A(j, j2, f, paddingValues, shape, modifier19, function3, composer2, i | 1, i2);
            }
        });
    }

    static {
        float f = 4;
        float fM3843constructorimpl = Dp.m3843constructorimpl(f);
        AppBarHorizontalPadding = fM3843constructorimpl;
        TitleInsetWithoutIcon = SizeKt.m469width3ABfNKs(Modifier.INSTANCE, Dp.m3843constructorimpl(Dp.m3843constructorimpl(16) - fM3843constructorimpl));
        TitleIconModifier = SizeKt.m469width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(Dp.m3843constructorimpl(72) - fM3843constructorimpl));
        BottomAppBarCutoutOffset = Dp.m3843constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = Dp.m3843constructorimpl(f);
    }
}
