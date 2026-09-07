package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m3843constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m3843constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m3843constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m3843constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m3843constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m3843constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m3843constructorimpl(68);

    /* JADX WARN: Code duplicated, block: B:107:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x014f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0154  */
    /* JADX WARN: Code duplicated, block: B:111:0x0158  */
    /* JADX WARN: Code duplicated, block: B:113:0x015c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0163  */
    /* JADX WARN: Code duplicated, block: B:119:0x0176  */
    /* JADX WARN: Code duplicated, block: B:122:0x0182  */
    /* JADX WARN: Code duplicated, block: B:123:0x0190  */
    /* JADX WARN: Code duplicated, block: B:125:0x0194  */
    /* JADX WARN: Code duplicated, block: B:126:0x019b  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0129  */
    /* JADX INFO: renamed from: Snackbar-7zSek6w, reason: not valid java name */
    public static final void m1157Snackbar7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Shape shape, long j, long j2, float f, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        int i4;
        final boolean z2;
        int i5;
        Shape small;
        long backgroundColor;
        int i6;
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        int i8;
        final Modifier.Companion companion;
        long jM983getSurface0d7_KjU;
        float fM3843constructorimpl;
        final int i9;
        long j3;
        long j4;
        final float f2;
        final Shape shape2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final long j5;
        final boolean z3;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-558258760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)84@3955L6,85@4015L15,86@4072L6,90@4158L631:Snackbar.kt#jmzs0o");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                function3 = function2;
                i3 |= composerStartRestartGroup.changed(function3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        small = shape;
                        int i14 = composerStartRestartGroup.changed(small) ? 2048 : 1024;
                        i3 |= i14;
                    } else {
                        small = shape;
                    }
                    i3 |= i14;
                } else {
                    small = shape;
                }
                if ((57344 & i) == 0) {
                    backgroundColor = j;
                    if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(backgroundColor)) {
                        i11 = 8192;
                    } else {
                        i11 = 16384;
                    }
                    i3 |= i11;
                } else {
                    backgroundColor = j;
                }
                if ((i & 458752) != 0) {
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i10 = 65536;
                    } else {
                        i10 = 131072;
                    }
                    i3 |= i10;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                    function4 = content;
                } else {
                    function4 = content;
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(function4)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i3 |= i8;
                    }
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function3 = null;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        } else {
                            jM983getSurface0d7_KjU = j2;
                        }
                        if (i6 != 0) {
                            fM3843constructorimpl = Dp.m3843constructorimpl(6);
                        } else {
                            fM3843constructorimpl = f;
                        }
                        i9 = i3;
                        j3 = backgroundColor;
                        j4 = jM983getSurface0d7_KjU;
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
                        companion = modifier;
                        j4 = j2;
                        fM3843constructorimpl = f;
                        i9 = i3;
                        j3 = backgroundColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i15 = i9 >> 6;
                    SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                                final Function2<Composer, Integer, Unit> function6 = function3;
                                final Function2<Composer, Integer, Unit> function7 = function4;
                                final int i17 = i9;
                                final boolean z4 = z2;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                        ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer3.getSkipping()) {
                                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                            final Function2<Composer, Integer, Unit> function8 = function6;
                                            final Function2<Composer, Integer, Unit> function9 = function7;
                                            final int i19 = i17;
                                            final boolean z5 = z4;
                                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                                    ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                                    if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (function8 == null) {
                                                            composer4.startReplaceableGroup(59708346);
                                                            ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                            SnackbarKt.TextOnlySnackbar(function9, composer4, (i19 >> 21) & 14);
                                                            composer4.endReplaceableGroup();
                                                            return;
                                                        }
                                                        if (z5) {
                                                            composer4.startReplaceableGroup(59708411);
                                                            ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                            Function2<Composer, Integer, Unit> function10 = function9;
                                                            Function2<Composer, Integer, Unit> function11 = function8;
                                                            int i21 = i19;
                                                            SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                            composer4.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer4.startReplaceableGroup(59708478);
                                                        ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                        Function2<Composer, Integer, Unit> function12 = function9;
                                                        Function2<Composer, Integer, Unit> function13 = function8;
                                                        int i22 = i19;
                                                        SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, 48);
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 56);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | ((i9 >> 3) & 458752), 16);
                    f2 = fM3843constructorimpl;
                    shape2 = small;
                    long j7 = j3;
                    function5 = function3;
                    j5 = j7;
                    z3 = z2;
                    j6 = j4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier;
                    f2 = f;
                    function5 = function3;
                    z3 = z2;
                    shape2 = small;
                    j5 = backgroundColor;
                    j6 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        SnackbarKt.m1157Snackbar7zSek6w(companion, function5, z3, shape2, j5, j6, f2, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            z2 = z;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    small = shape;
                    if (composerStartRestartGroup.changed(small)) {
                    }
                    i3 |= i14;
                } else {
                    small = shape;
                }
                i3 |= i14;
            } else {
                small = shape;
            }
            if ((57344 & i) == 0) {
                backgroundColor = j;
                if ((i2 & 16) == 0) {
                    i11 = 8192;
                } else {
                    i11 = 8192;
                }
                i3 |= i11;
            } else {
                backgroundColor = j;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    i10 = 65536;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
                function4 = content;
            } else {
                function4 = content;
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                int i16 = i9 >> 6;
                SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                        if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                            final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                            final int i18 = i9;
                            final boolean z4 = z2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                    if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                        final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                        final int i110 = i18;
                                        final boolean z5 = z4;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (function8 == null) {
                                                        composer4.startReplaceableGroup(59708346);
                                                        ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                        SnackbarKt.TextOnlySnackbar(function9, composer4, (i110 >> 21) & 14);
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    if (z5) {
                                                        composer4.startReplaceableGroup(59708411);
                                                        ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                        Function2<Composer, Integer, Unit> function10 = function9;
                                                        Function2<Composer, Integer, Unit> function11 = function8;
                                                        int i21 = i110;
                                                        SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer4.startReplaceableGroup(59708478);
                                                    ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                    Function2<Composer, Integer, Unit> function12 = function9;
                                                    Function2<Composer, Integer, Unit> function13 = function8;
                                                    int i22 = i110;
                                                    SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 48);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i16 & 112) | (i16 & 896) | (i16 & 7168) | ((i9 >> 3) & 458752), 16);
                f2 = fM3843constructorimpl;
                shape2 = small;
                long j8 = j3;
                function5 = function3;
                j5 = j8;
                z3 = z2;
                j6 = j4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                int i17 = i9 >> 6;
                SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                        if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                            final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                            final int i19 = i9;
                            final boolean z4 = z2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                    if ((i110 & 11) != 2 || !composer3.getSkipping()) {
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                        final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                        final int i111 = i19;
                                        final boolean z5 = z4;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (function8 == null) {
                                                        composer4.startReplaceableGroup(59708346);
                                                        ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                        SnackbarKt.TextOnlySnackbar(function9, composer4, (i111 >> 21) & 14);
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    if (z5) {
                                                        composer4.startReplaceableGroup(59708411);
                                                        ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                        Function2<Composer, Integer, Unit> function10 = function9;
                                                        Function2<Composer, Integer, Unit> function11 = function8;
                                                        int i21 = i111;
                                                        SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer4.startReplaceableGroup(59708478);
                                                    ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                    Function2<Composer, Integer, Unit> function12 = function9;
                                                    Function2<Composer, Integer, Unit> function13 = function8;
                                                    int i22 = i111;
                                                    SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 48);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i17 & 112) | (i17 & 896) | (i17 & 7168) | ((i9 >> 3) & 458752), 16);
                f2 = fM3843constructorimpl;
                shape2 = small;
                long j9 = j3;
                function5 = function3;
                j5 = j9;
                z3 = z2;
                j6 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SnackbarKt.m1157Snackbar7zSek6w(companion, function5, z3, shape2, j5, j6, f2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        function3 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    small = shape;
                    if (composerStartRestartGroup.changed(small)) {
                    }
                    i3 |= i14;
                } else {
                    small = shape;
                }
                i3 |= i14;
            } else {
                small = shape;
            }
            if ((57344 & i) == 0) {
                backgroundColor = j;
                if ((i2 & 16) == 0) {
                    i11 = 8192;
                } else {
                    i11 = 8192;
                }
                i3 |= i11;
            } else {
                backgroundColor = j;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    i10 = 65536;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
                function4 = content;
            } else {
                function4 = content;
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                int i18 = i9 >> 6;
                SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                        if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                            final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                            final int i110 = i9;
                            final boolean z4 = z2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                    if ((i111 & 11) != 2 || !composer3.getSkipping()) {
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                        final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                        final int i112 = i110;
                                        final boolean z5 = z4;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (function8 == null) {
                                                        composer4.startReplaceableGroup(59708346);
                                                        ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                        SnackbarKt.TextOnlySnackbar(function9, composer4, (i112 >> 21) & 14);
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    if (z5) {
                                                        composer4.startReplaceableGroup(59708411);
                                                        ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                        Function2<Composer, Integer, Unit> function10 = function9;
                                                        Function2<Composer, Integer, Unit> function11 = function8;
                                                        int i21 = i112;
                                                        SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer4.startReplaceableGroup(59708478);
                                                    ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                    Function2<Composer, Integer, Unit> function12 = function9;
                                                    Function2<Composer, Integer, Unit> function13 = function8;
                                                    int i22 = i112;
                                                    SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 48);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i18 & 112) | (i18 & 896) | (i18 & 7168) | ((i9 >> 3) & 458752), 16);
                f2 = fM3843constructorimpl;
                shape2 = small;
                long j10 = j3;
                function5 = function3;
                j5 = j10;
                z3 = z2;
                j6 = j4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    if (i6 != 0) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f;
                    }
                    i9 = i3;
                    j3 = backgroundColor;
                    j4 = jM983getSurface0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                int i19 = i9 >> 6;
                SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                        if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                            final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                            final int i111 = i9;
                            final boolean z4 = z2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                    ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                    if ((i112 & 11) != 2 || !composer3.getSkipping()) {
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                        final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                        final int i113 = i111;
                                        final boolean z5 = z4;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (function8 == null) {
                                                        composer4.startReplaceableGroup(59708346);
                                                        ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                        SnackbarKt.TextOnlySnackbar(function9, composer4, (i113 >> 21) & 14);
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    if (z5) {
                                                        composer4.startReplaceableGroup(59708411);
                                                        ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                        Function2<Composer, Integer, Unit> function10 = function9;
                                                        Function2<Composer, Integer, Unit> function11 = function8;
                                                        int i21 = i113;
                                                        SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                        composer4.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer4.startReplaceableGroup(59708478);
                                                    ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                    Function2<Composer, Integer, Unit> function12 = function9;
                                                    Function2<Composer, Integer, Unit> function13 = function8;
                                                    int i22 = i113;
                                                    SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 48);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 56);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | ((i9 >> 3) & 458752), 16);
                f2 = fM3843constructorimpl;
                shape2 = small;
                long j11 = j3;
                function5 = function3;
                j5 = j11;
                z3 = z2;
                j6 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SnackbarKt.m1157Snackbar7zSek6w(companion, function5, z3, shape2, j5, j6, f2, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        z2 = z;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                small = shape;
                if (composerStartRestartGroup.changed(small)) {
                }
                i3 |= i14;
            } else {
                small = shape;
            }
            i3 |= i14;
        } else {
            small = shape;
        }
        if ((57344 & i) == 0) {
            backgroundColor = j;
            if ((i2 & 16) == 0) {
                i11 = 8192;
            } else {
                i11 = 8192;
            }
            i3 |= i11;
        } else {
            backgroundColor = j;
        }
        if ((i & 458752) != 0) {
            if ((i2 & 32) == 0) {
                i10 = 65536;
            } else {
                i10 = 65536;
            }
            i3 |= i10;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
            function4 = content;
        } else {
            function4 = content;
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
        }
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f;
                }
                i9 = i3;
                j3 = backgroundColor;
                j4 = jM983getSurface0d7_KjU;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f;
                }
                i9 = i3;
                j3 = backgroundColor;
                j4 = jM983getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            int i110 = i9 >> 6;
            SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                    if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                        final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                        final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                        final int i112 = i9;
                        final boolean z4 = z2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                if ((i113 & 11) != 2 || !composer3.getSkipping()) {
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                    final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                    final int i114 = i112;
                                    final boolean z5 = z4;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                            ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                            if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                if (function8 == null) {
                                                    composer4.startReplaceableGroup(59708346);
                                                    ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                    SnackbarKt.TextOnlySnackbar(function9, composer4, (i114 >> 21) & 14);
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                if (z5) {
                                                    composer4.startReplaceableGroup(59708411);
                                                    ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                    Function2<Composer, Integer, Unit> function10 = function9;
                                                    Function2<Composer, Integer, Unit> function11 = function8;
                                                    int i21 = i114;
                                                    SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.startReplaceableGroup(59708478);
                                                ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                Function2<Composer, Integer, Unit> function12 = function9;
                                                Function2<Composer, Integer, Unit> function13 = function8;
                                                int i22 = i114;
                                                SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                composer4.endReplaceableGroup();
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 48);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i110 & 112) | (i110 & 896) | (i110 & 7168) | ((i9 >> 3) & 458752), 16);
            f2 = fM3843constructorimpl;
            shape2 = small;
            long j12 = j3;
            function5 = function3;
            j5 = j12;
            z3 = z2;
            j6 = j4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f;
                }
                i9 = i3;
                j3 = backgroundColor;
                j4 = jM983getSurface0d7_KjU;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                if (i6 != 0) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f;
                }
                i9 = i3;
                j3 = backgroundColor;
                j4 = jM983getSurface0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            int i111 = i9 >> 6;
            SurfaceKt.m1175SurfaceFjzlyU(companion, small, j3, j4, null, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                    if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))};
                        final Function2<? super Composer, ? super Integer, Unit> function6 = function3;
                        final Function2<? super Composer, ? super Integer, Unit> function7 = function4;
                        final int i113 = i9;
                        final boolean z4 = z2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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
                                ComposerKt.sourceInformation(composer3, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                if ((i114 & 11) != 2 || !composer3.getSkipping()) {
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                    final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
                                    final int i115 = i113;
                                    final boolean z5 = z4;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer3, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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
                                            ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#jmzs0o");
                                            if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                if (function8 == null) {
                                                    composer4.startReplaceableGroup(59708346);
                                                    ComposerKt.sourceInformation(composer4, "101@4578L25");
                                                    SnackbarKt.TextOnlySnackbar(function9, composer4, (i115 >> 21) & 14);
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                if (z5) {
                                                    composer4.startReplaceableGroup(59708411);
                                                    ComposerKt.sourceInformation(composer4, "102@4643L38");
                                                    Function2<Composer, Integer, Unit> function10 = function9;
                                                    Function2<Composer, Integer, Unit> function11 = function8;
                                                    int i21 = i115;
                                                    SnackbarKt.NewLineButtonSnackbar(function10, function11, composer4, (i21 & 112) | ((i21 >> 21) & 14));
                                                    composer4.endReplaceableGroup();
                                                    return;
                                                }
                                                composer4.startReplaceableGroup(59708478);
                                                ComposerKt.sourceInformation(composer4, "103@4710L31");
                                                Function2<Composer, Integer, Unit> function12 = function9;
                                                Function2<Composer, Integer, Unit> function13 = function8;
                                                int i22 = i115;
                                                SnackbarKt.OneRowSnackbar(function12, function13, composer4, (i22 & 112) | ((i22 >> 21) & 14));
                                                composer4.endReplaceableGroup();
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 48);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 56);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i9 & 14) | 1572864 | (i111 & 112) | (i111 & 896) | (i111 & 7168) | ((i9 >> 3) & 458752), 16);
            f2 = fM3843constructorimpl;
            shape2 = small;
            long j13 = j3;
            function5 = function3;
            j5 = j13;
            z3 = z2;
            j6 = j4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SnackbarKt.m1157Snackbar7zSek6w(companion, function5, z3, shape2, j5, j6, f2, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:112:0x015a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x015c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0161  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:117:0x0167  */
    /* JADX WARN: Code duplicated, block: B:120:0x016e  */
    /* JADX WARN: Code duplicated, block: B:121:0x017d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0182  */
    /* JADX WARN: Code duplicated, block: B:125:0x018b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:134:0x01af  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:140:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:145:0x0242  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX INFO: renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m1158SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Shape shape2;
        long jM983getSurface0d7_KjU;
        long j4;
        int i6;
        final float f2;
        int i7;
        Modifier.Companion companion;
        boolean z2;
        CornerBasedShape small;
        long backgroundColor;
        long primaryActionColor;
        float fM3843constructorimpl;
        long j5;
        long j6;
        final String actionLabel;
        ComposableLambda composableLambda;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape3;
        final long j7;
        final long j8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        Composer composerStartRestartGroup = composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) != 0) {
                    i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        jM983getSurface0d7_KjU = j2;
                        int i11 = composerStartRestartGroup.changed(jM983getSurface0d7_KjU) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        jM983getSurface0d7_KjU = j2;
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                if ((i & 3670016) == 0) {
                    j4 = j3;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i8 = 524288;
                    } else {
                        i8 = 1048576;
                    }
                    i3 |= i8;
                } else {
                    j4 = j3;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i7 = 8388608;
                        } else {
                            i7 = 4194304;
                        }
                        i3 |= i7;
                    }
                }
                if ((i3 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            backgroundColor = j;
                        }
                        if ((i2 & 32) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            primaryActionColor = j4;
                        }
                        if (i6 != 0) {
                            j5 = jM983getSurface0d7_KjU;
                            fM3843constructorimpl = Dp.m3843constructorimpl(6);
                        } else {
                            fM3843constructorimpl = f2;
                            j5 = jM983getSurface0d7_KjU;
                        }
                        j6 = backgroundColor;
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
                        companion = modifier;
                        z2 = z;
                        small = shape2;
                        j6 = j;
                        long j10 = jM983getSurface0d7_KjU;
                        i3 = i3;
                        fM3843constructorimpl = f2;
                        primaryActionColor = j4;
                        j5 = j10;
                    }
                    composerStartRestartGroup.endDefaults();
                    actionLabel = snackbarData.getActionLabel();
                    if (actionLabel != null) {
                        final long j11 = primaryActionColor;
                        final int i12 = i3;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                                if ((i13 & 11) != 2 || !composer2.getSkipping()) {
                                    ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j11, 0L, composer2, ((i12 >> 15) & 112) | 3072, 5);
                                    final SnackbarData snackbarData2 = snackbarData;
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            snackbarData2.performAction();
                                        }
                                    };
                                    final String str = actionLabel;
                                    ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                            invoke(rowScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(RowScope TextButton, Composer composer3, int i14) {
                                            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                            ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                            if ((i14 & 81) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                            } else {
                                                TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                            }
                                        }
                                    }), composer2, C.ENCODING_PCM_32BIT, 382);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                    } else {
                        composableLambda = null;
                    }
                    m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                            if ((i13 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                            }
                        }
                    }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                    f2 = fM3843constructorimpl;
                    modifier2 = companion;
                    z3 = z2;
                    shape3 = small;
                    j7 = j6;
                    j8 = j5;
                    j9 = primaryActionColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    z3 = z;
                    j7 = j;
                    shape3 = shape2;
                    j9 = j4;
                    j8 = jM983getSurface0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        SnackbarKt.m1158SnackbarsPrSdHI(snackbarData, modifier2, z3, shape3, j7, j8, j9, f2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    jM983getSurface0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j2;
            }
            if ((i & 3670016) == 0) {
                j4 = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                j4 = j3;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    final long j12 = primaryActionColor;
                    final int i13 = i3;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                            if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j12, 0L, composer2, ((i13 >> 15) & 112) | 3072, 5);
                                final SnackbarData snackbarData2 = snackbarData;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        snackbarData2.performAction();
                                    }
                                };
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope TextButton, Composer composer3, int i15) {
                                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                        ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                        if ((i15 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                        }
                                    }
                                }), composer2, C.ENCODING_PCM_32BIT, 382);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                } else {
                    composableLambda = null;
                }
                m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                        if ((i14 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                        }
                    }
                }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                f2 = fM3843constructorimpl;
                modifier2 = companion;
                z3 = z2;
                shape3 = small;
                j7 = j6;
                j8 = j5;
                j9 = primaryActionColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    final long j13 = primaryActionColor;
                    final int i14 = i3;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j13, 0L, composer2, ((i14 >> 15) & 112) | 3072, 5);
                                final SnackbarData snackbarData2 = snackbarData;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        snackbarData2.performAction();
                                    }
                                };
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope TextButton, Composer composer3, int i16) {
                                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                        ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                        if ((i16 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                        }
                                    }
                                }), composer2, C.ENCODING_PCM_32BIT, 382);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                } else {
                    composableLambda = null;
                }
                m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                        if ((i15 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                        }
                    }
                }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                f2 = fM3843constructorimpl;
                modifier2 = companion;
                z3 = z2;
                shape3 = small;
                j7 = j6;
                j8 = j5;
                j9 = primaryActionColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    SnackbarKt.m1158SnackbarsPrSdHI(snackbarData, modifier2, z3, shape3, j7, j8, j9, f2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
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
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i & 57344) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    jM983getSurface0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j2;
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j2;
            }
            if ((i & 3670016) == 0) {
                j4 = j3;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                j4 = j3;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    final long j14 = primaryActionColor;
                    final int i15 = i3;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i16) {
                            ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j14, 0L, composer2, ((i15 >> 15) & 112) | 3072, 5);
                                final SnackbarData snackbarData2 = snackbarData;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        snackbarData2.performAction();
                                    }
                                };
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope TextButton, Composer composer3, int i17) {
                                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                        ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                        if ((i17 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                        }
                                    }
                                }), composer2, C.ENCODING_PCM_32BIT, 382);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                } else {
                    composableLambda = null;
                }
                m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i16) {
                        ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                        if ((i16 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                        }
                    }
                }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                f2 = fM3843constructorimpl;
                modifier2 = companion;
                z3 = z2;
                shape3 = small;
                j7 = j6;
                j8 = j5;
                j9 = primaryActionColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 32) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j4;
                    }
                    if (i6 != 0) {
                        j5 = jM983getSurface0d7_KjU;
                        fM3843constructorimpl = Dp.m3843constructorimpl(6);
                    } else {
                        fM3843constructorimpl = f2;
                        j5 = jM983getSurface0d7_KjU;
                    }
                    j6 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    final long j15 = primaryActionColor;
                    final int i16 = i3;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i17) {
                            ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                            if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j15, 0L, composer2, ((i16 >> 15) & 112) | 3072, 5);
                                final SnackbarData snackbarData2 = snackbarData;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        snackbarData2.performAction();
                                    }
                                };
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope TextButton, Composer composer3, int i18) {
                                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                        ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                        if ((i18 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                        }
                                    }
                                }), composer2, C.ENCODING_PCM_32BIT, 382);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                } else {
                    composableLambda = null;
                }
                m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i17) {
                        ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                        if ((i17 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                        }
                    }
                }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                f2 = fM3843constructorimpl;
                modifier2 = companion;
                z3 = z2;
                shape3 = small;
                j7 = j6;
                j8 = j5;
                j9 = primaryActionColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i17) {
                    SnackbarKt.m1158SnackbarsPrSdHI(snackbarData, modifier2, z3, shape3, j7, j8, j9, f2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i10;
            } else {
                shape2 = shape;
            }
            i3 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i & 57344) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) ? 8192 : 16384;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                jM983getSurface0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j2;
            }
            i3 |= i11;
        } else {
            jM983getSurface0d7_KjU = j2;
        }
        if ((i & 3670016) == 0) {
            j4 = j3;
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        } else {
            j4 = j3;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
        }
        if ((i3 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    j5 = jM983getSurface0d7_KjU;
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f2;
                    j5 = jM983getSurface0d7_KjU;
                }
                j6 = backgroundColor;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    j5 = jM983getSurface0d7_KjU;
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f2;
                    j5 = jM983getSurface0d7_KjU;
                }
                j6 = backgroundColor;
            }
            composerStartRestartGroup.endDefaults();
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                final long j16 = primaryActionColor;
                final int i17 = i3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i18) {
                        ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                        if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                            ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j16, 0L, composer2, ((i17 >> 15) & 112) | 3072, 5);
                            final SnackbarData snackbarData2 = snackbarData;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    snackbarData2.performAction();
                                }
                            };
                            final String str = actionLabel;
                            ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope TextButton, Composer composer3, int i19) {
                                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                    ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                    if ((i19 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                    }
                                }
                            }), composer2, C.ENCODING_PCM_32BIT, 382);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
            } else {
                composableLambda = null;
            }
            m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i18) {
                    ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                    if ((i18 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                    }
                }
            }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
            f2 = fM3843constructorimpl;
            modifier2 = companion;
            z3 = z2;
            shape3 = small;
            j7 = j6;
            j8 = j5;
            j9 = primaryActionColor;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    j5 = jM983getSurface0d7_KjU;
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f2;
                    j5 = jM983getSurface0d7_KjU;
                }
                j6 = backgroundColor;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j;
                }
                if ((i2 & 32) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j4;
                }
                if (i6 != 0) {
                    j5 = jM983getSurface0d7_KjU;
                    fM3843constructorimpl = Dp.m3843constructorimpl(6);
                } else {
                    fM3843constructorimpl = f2;
                    j5 = jM983getSurface0d7_KjU;
                }
                j6 = backgroundColor;
            }
            composerStartRestartGroup.endDefaults();
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                final long j17 = primaryActionColor;
                final int i18 = i3;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i19) {
                        ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                        if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                            ButtonColors buttonColorsM938textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, j17, 0L, composer2, ((i18 >> 15) & 112) | 3072, 5);
                            final SnackbarData snackbarData2 = snackbarData;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    snackbarData2.performAction();
                                }
                            };
                            final String str = actionLabel;
                            ButtonKt.TextButton(function0, null, false, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope TextButton, Composer composer3, int i110) {
                                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                    ComposerKt.sourceInformation(composer3, "C167@7704L17:Snackbar.kt#jmzs0o");
                                    if ((i110 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        TextKt.m1246TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer3, 0, 0, 65534);
                                    }
                                }
                            }), composer2, C.ENCODING_PCM_32BIT, 382);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
            } else {
                composableLambda = null;
            }
            m1157Snackbar7zSek6w(PaddingKt.m423padding3ABfNKs(companion, Dp.m3843constructorimpl(12)), composableLambda, z2, small, j6, j5, fM3843constructorimpl, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i19) {
                    ComposerKt.sourceInformation(composer2, "C175@7858L26:Snackbar.kt#jmzs0o");
                    if ((i19 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        TextKt.m1246TextfLXpl1I(snackbarData.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer2, 0, 0, 65534);
                    }
                }
            }), composerStartRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
            f2 = fM3843constructorimpl;
            modifier2 = companion;
            z3 = z2;
            shape3 = small;
            j7 = j6;
            j8 = j5;
            j9 = primaryActionColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i19) {
                SnackbarKt.m1158SnackbarsPrSdHI(snackbarData, modifier2, z3, shape3, j7, j8, j9, f2, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(917397959);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextOnlySnackbar)236@9927L1207:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            C10772 c10772 = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.TextOnlySnackbar.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    if (measurables.size() != 1) {
                        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
                    }
                    final Placeable placeableMo3124measureBRTryo0 = ((Measurable) CollectionsKt.first((List) measurables)).mo3124measureBRTryo0(j);
                    int i3 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                    int i4 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                    if (i3 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    if (i4 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    final int iMax = Math.max(Layout.mo312roundToPx0680j_4(i3 == i4 ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), placeableMo3124measureBRTryo0.getHeight());
                    return MeasureScope.layout$default(Layout, Constraints.m3799getMaxWidthimpl(j), iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2$measure$4
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
                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo3124measureBRTryo0, 0, (iMax - placeableMo3124measureBRTryo0.getHeight()) / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
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
            Updater.m1293setimpl(composerM1286constructorimpl, c10772, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-266728784);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C237@9944L202:Snackbar.kt#jmzs0o");
            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, HorizontalSpacing, SnackbarVerticalPadding);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
            composerStartRestartGroup.startReplaceableGroup(1392363114);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C243@10127L9:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.TextOnlySnackbar.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SnackbarKt.TextOnlySnackbar(function2, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1229075900);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NewLineButtonSnackbar)P(1)274@11262L476:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(modifierFillMaxWidth$default, f, 0.0f, f2, SeparateButtonExtraY, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C79@3994L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1214415430);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C282@11505L171,286@11685L47:Snackbar.kt#jmzs0o");
            Modifier modifierM427paddingqDBjuR0$default2 = PaddingKt.m427paddingqDBjuR0$default(androidx.compose.foundation.layout.AlignmentLineKt.m350paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f2, 0.0f, 11, null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default2);
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
            composerStartRestartGroup.startReplaceableGroup(1193033152);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C285@11668L6:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierAlign);
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
            composerStartRestartGroup.startReplaceableGroup(-2100387721);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C286@11722L8:Snackbar.kt#jmzs0o");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.NewLineButtonSnackbar.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SnackbarKt.NewLineButtonSnackbar(function2, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-534813202);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OneRowSnackbar)P(1)297@11913L2543:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            final String str = "action";
            final String str2 = "text";
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.OneRowSnackbar.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo18measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    int iMax;
                    final int i3;
                    final int height;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    String str3 = str;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str3)) {
                            final Placeable placeableMo3124measureBRTryo0 = measurable.mo3124measureBRTryo0(j);
                            int iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m3799getMaxWidthimpl(j) - placeableMo3124measureBRTryo0.getWidth()) - Layout.mo312roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m3801getMinWidthimpl(j));
                            String str4 = str2;
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str4)) {
                                    final Placeable placeableMo3124measureBRTryo1 = measurable2.mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j, 0, iCoerceAtLeast, 0, 0, 9, null));
                                    int i4 = placeableMo3124measureBRTryo1.get(AlignmentLineKt.getFirstBaseline());
                                    if (i4 == Integer.MIN_VALUE) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    int i5 = placeableMo3124measureBRTryo1.get(AlignmentLineKt.getLastBaseline());
                                    if (i5 == Integer.MIN_VALUE) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    boolean z = i4 == i5;
                                    final int iM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(j) - placeableMo3124measureBRTryo0.getWidth();
                                    if (!z) {
                                        int i6 = Layout.mo312roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i4;
                                        int iMax2 = Math.max(Layout.mo312roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), placeableMo3124measureBRTryo1.getHeight() + i6);
                                        iMax = iMax2;
                                        i3 = i6;
                                        height = (iMax2 - placeableMo3124measureBRTryo0.getHeight()) / 2;
                                    } else {
                                        iMax = Math.max(Layout.mo312roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), placeableMo3124measureBRTryo0.getHeight());
                                        int height2 = (iMax - placeableMo3124measureBRTryo1.getHeight()) / 2;
                                        int i7 = placeableMo3124measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                                        height = i7 != Integer.MIN_VALUE ? (i4 + height2) - i7 : 0;
                                        i3 = height2;
                                    }
                                    return MeasureScope.layout$default(Layout, Constraints.m3799getMaxWidthimpl(j), iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$measure$4
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
                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo3124measureBRTryo1, 0, i3, 0.0f, 4, null);
                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo3124measureBRTryo0, iM3799getMaxWidthimpl, height, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM427paddingqDBjuR0$default);
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
            composerStartRestartGroup.startReplaceableGroup(-643033641);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C299@11943L86,300@12042L46:Snackbar.kt#jmzs0o");
            Modifier modifierM425paddingVpY3zN4$default = PaddingKt.m425paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM425paddingVpY3zN4$default);
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
            composerStartRestartGroup.startReplaceableGroup(1616738193);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C299@12021L6:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId);
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
            composerStartRestartGroup.startReplaceableGroup(-1690150342);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C300@12078L8:Snackbar.kt#jmzs0o");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.OneRowSnackbar.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SnackbarKt.OneRowSnackbar(function2, function3, composer2, i | 1);
            }
        });
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m3843constructorimpl(f);
        TextEndExtraSpacing = Dp.m3843constructorimpl(f);
    }
}
