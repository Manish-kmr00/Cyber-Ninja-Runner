package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
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

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m3843constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation(composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x014c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0152  */
    /* JADX WARN: Code duplicated, block: B:104:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x015d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0161  */
    /* JADX WARN: Code duplicated, block: B:113:0x016c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0180  */
    /* JADX WARN: Code duplicated, block: B:122:0x0186  */
    /* JADX WARN: Code duplicated, block: B:124:0x018c  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0197  */
    /* JADX WARN: Code duplicated, block: B:131:0x019b  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:156:0x01da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:159:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:162:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:169:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:172:0x0204  */
    /* JADX WARN: Code duplicated, block: B:174:0x020a  */
    /* JADX WARN: Code duplicated, block: B:177:0x0213  */
    /* JADX WARN: Code duplicated, block: B:179:0x0218  */
    /* JADX WARN: Code duplicated, block: B:182:0x021e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0223  */
    /* JADX WARN: Code duplicated, block: B:186:0x0227  */
    /* JADX WARN: Code duplicated, block: B:188:0x022d  */
    /* JADX WARN: Code duplicated, block: B:189:0x0230  */
    /* JADX WARN: Code duplicated, block: B:192:0x023d  */
    /* JADX WARN: Code duplicated, block: B:198:0x0273  */
    /* JADX WARN: Code duplicated, block: B:200:0x027a  */
    /* JADX WARN: Code duplicated, block: B:225:0x02dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x02df  */
    /* JADX WARN: Code duplicated, block: B:227:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:230:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:231:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:233:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:234:0x0304  */
    /* JADX WARN: Code duplicated, block: B:236:0x0308  */
    /* JADX WARN: Code duplicated, block: B:237:0x030f  */
    /* JADX WARN: Code duplicated, block: B:239:0x0313  */
    /* JADX WARN: Code duplicated, block: B:240:0x031a  */
    /* JADX WARN: Code duplicated, block: B:242:0x031e  */
    /* JADX WARN: Code duplicated, block: B:243:0x0325  */
    /* JADX WARN: Code duplicated, block: B:245:0x0329  */
    /* JADX WARN: Code duplicated, block: B:247:0x0331  */
    /* JADX WARN: Code duplicated, block: B:248:0x0333  */
    /* JADX WARN: Code duplicated, block: B:250:0x0337  */
    /* JADX WARN: Code duplicated, block: B:251:0x0339  */
    /* JADX WARN: Code duplicated, block: B:253:0x033d  */
    /* JADX WARN: Code duplicated, block: B:254:0x033f  */
    /* JADX WARN: Code duplicated, block: B:257:0x034a  */
    /* JADX WARN: Code duplicated, block: B:258:0x0359  */
    /* JADX WARN: Code duplicated, block: B:261:0x035f  */
    /* JADX WARN: Code duplicated, block: B:262:0x0366  */
    /* JADX WARN: Code duplicated, block: B:265:0x036c  */
    /* JADX WARN: Code duplicated, block: B:266:0x0387  */
    /* JADX WARN: Code duplicated, block: B:269:0x0396  */
    /* JADX WARN: Code duplicated, block: B:270:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:273:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:274:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:277:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:278:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:281:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:282:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:286:0x043c  */
    /* JADX WARN: Code duplicated, block: B:287:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:292:0x04da  */
    /* JADX WARN: Code duplicated, block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00df  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    /* JADX WARN: Code duplicated, block: B:81:0x010c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0112  */
    /* JADX WARN: Code duplicated, block: B:84:0x0115  */
    /* JADX WARN: Code duplicated, block: B:88:0x011d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0124  */
    /* JADX WARN: Code duplicated, block: B:91:0x012c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0132  */
    /* JADX WARN: Code duplicated, block: B:94:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0144  */
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m1146Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int i, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i11;
        int i12;
        int iM1067getEnd5ygKITE;
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
        final Modifier.Companion companion;
        ScaffoldState scaffoldStateRememberScaffoldState;
        Function2<? super Composer, ? super Integer, Unit> function2M1005getLambda1$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1006getLambda2$material_release;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1007getLambda3$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1008getLambda4$material_release;
        boolean z3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function8;
        boolean z4;
        ScaffoldState scaffoldState2;
        CornerBasedShape large;
        int i24;
        float fM1024getElevationD9Ej5fM;
        boolean z5;
        int i25;
        long jM983getSurface0d7_KjU;
        long jM997contentColorForek8zF_U;
        int i26;
        long scrimColor;
        long jM972getBackground0d7_KjU;
        long j6;
        long j7;
        float f2;
        int i27;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function9;
        final ComposableLambda composableLambda;
        final ScaffoldState scaffoldState3;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final int i28;
        final float f3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Shape shape2;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function14;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i29;
        int i30;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)160@7052L23,169@7562L6,171@7677L6,172@7725L38,173@7810L10,174@7865L6,175@7910L32:Scaffold.kt#jmzs0o");
        int i31 = i4 & 1;
        if (i31 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= ((i4 & 2) == 0 && composerStartRestartGroup.changed(scaffoldState)) ? 32 : 16;
        }
        int i32 = i4 & 4;
        if (i32 == 0) {
            if ((i2 & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
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
                    if (composerStartRestartGroup.changed(function4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function7 = function5;
                } else {
                    function7 = function5;
                    if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(function7)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i5 |= i11;
                    }
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                    iM1067getEnd5ygKITE = i;
                } else {
                    iM1067getEnd5ygKITE = i;
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(iM1067getEnd5ygKITE)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i5 |= i13;
                    }
                }
                i14 = i4 & 128;
                if (i14 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i5 |= i15;
                }
                i16 = i4 & 256;
                if (i16 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(function6)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i5 |= i17;
                }
                i18 = i4 & 512;
                if (i18 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i19 = 536870912;
                    } else {
                        i19 = 268435456;
                    }
                    i5 |= i19;
                }
                if ((i3 & 14) == 0) {
                    i20 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
                } else {
                    i20 = i3;
                }
                i21 = i4 & 2048;
                if (i21 != 0) {
                    i20 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i22 = 32;
                    } else {
                        i22 = 16;
                    }
                    i20 |= i22;
                }
                if ((i3 & 896) != 0) {
                    i20 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
                }
                if ((i3 & 7168) != 0) {
                    i20 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
                }
                if ((i3 & 57344) != 0) {
                    i20 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j3)) ? 8192 : 16384;
                }
                if ((i3 & 458752) != 0) {
                    if ((i4 & 32768) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i30 = 65536;
                    } else {
                        i30 = 131072;
                    }
                    i20 |= i30;
                }
                if ((i3 & 3670016) != 0) {
                    if ((i4 & 65536) == 0 || !composerStartRestartGroup.changed(j5)) {
                        i29 = 524288;
                    } else {
                        i29 = 1048576;
                    }
                    i20 |= i29;
                }
                if ((i4 & 131072) != 0) {
                    if ((i3 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i23 = 8388608;
                        } else {
                            i23 = 4194304;
                        }
                    }
                    if ((i5 & 1533916891) == 306783378 || (i20 & 23967451) != 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i31 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i4 & 2) != 0) {
                                scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i5 &= -113;
                            } else {
                                scaffoldStateRememberScaffoldState = scaffoldState;
                            }
                            if (i32 != 0) {
                                function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                            } else {
                                function2M1005getLambda1$material_release = function2;
                            }
                            if (i6 != 0) {
                                function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                            } else {
                                function2M1006getLambda2$material_release = function3;
                            }
                            if (i8 != 0) {
                                function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                            } else {
                                function3M1007getLambda3$material_release = function4;
                            }
                            if (i10 != 0) {
                                function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                            } else {
                                function2M1008getLambda4$material_release = function5;
                            }
                            if (i12 != 0) {
                                iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                            }
                            if (i14 != 0) {
                                z3 = false;
                            } else {
                                z3 = z;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            } else {
                                function8 = function6;
                            }
                            if (i18 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            scaffoldState2 = scaffoldStateRememberScaffoldState;
                            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function15 = function8;
                            if ((i4 & 1024) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i20 &= -15;
                            } else {
                                large = shape;
                            }
                            i24 = i20;
                            if (i21 != 0) {
                                fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                            } else {
                                fM1024getElevationD9Ej5fM = f;
                            }
                            if ((i4 & 4096) != 0) {
                                boolean z8 = z4;
                                i25 = i24 & (-897);
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                z5 = z8;
                            } else {
                                z5 = z4;
                                i25 = i24;
                                jM983getSurface0d7_KjU = j;
                            }
                            float f4 = fM1024getElevationD9Ej5fM;
                            if ((i4 & 8192) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                                i25 &= -7169;
                            } else {
                                jM997contentColorForek8zF_U = j2;
                            }
                            if ((i4 & 16384) != 0) {
                                i26 = 6;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i25 &= -57345;
                            } else {
                                i26 = 6;
                                scrimColor = j3;
                            }
                            if ((32768 & i4) != 0) {
                                jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                                i25 &= -458753;
                            } else {
                                jM972getBackground0d7_KjU = j4;
                            }
                            if ((i4 & 65536) != 0) {
                                long jM997contentColorForek8zF_U2 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                                i25 &= -3670017;
                                j6 = jM997contentColorForek8zF_U2;
                            } else {
                                j6 = j5;
                            }
                            j7 = jM997contentColorForek8zF_U;
                            f2 = f4;
                            i27 = i25;
                            function9 = function15;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 2) != 0) {
                                i5 &= -113;
                            }
                            if ((i4 & 1024) != 0) {
                                i20 &= -15;
                            }
                            int i33 = i20;
                            if ((i4 & 4096) != 0) {
                                i33 &= -897;
                            }
                            if ((i4 & 8192) != 0) {
                                i33 &= -7169;
                            }
                            if ((i4 & 16384) != 0) {
                                i33 &= -57345;
                            }
                            if ((32768 & i4) != 0) {
                                i33 &= -458753;
                            }
                            if ((i4 & 65536) != 0) {
                                i33 &= -3670017;
                            }
                            scaffoldState2 = scaffoldState;
                            function2M1005getLambda1$material_release = function2;
                            function2M1006getLambda2$material_release = function3;
                            z3 = z;
                            function9 = function6;
                            z5 = z2;
                            f2 = f;
                            jM983getSurface0d7_KjU = j;
                            j7 = j2;
                            scrimColor = j3;
                            jM972getBackground0d7_KjU = j4;
                            j6 = j5;
                            i27 = i33;
                            i5 = i5;
                            function2M1008getLambda4$material_release = function7;
                            companion = modifier;
                            function3M1007getLambda3$material_release = function4;
                            large = shape;
                        }
                        composerStartRestartGroup.endDefaults();
                        final long j8 = jM972getBackground0d7_KjU;
                        final long j9 = j6;
                        final int i34 = i27;
                        final boolean z9 = z3;
                        final int i35 = iM1067getEnd5ygKITE;
                        final Function2<? super Composer, ? super Integer, Unit> function16 = function2M1005getLambda1$material_release;
                        final Function2<? super Composer, ? super Integer, Unit> function17 = function2M1008getLambda4$material_release;
                        final Function2<? super Composer, ? super Integer, Unit> function18 = function2M1006getLambda2$material_release;
                        final int i36 = i5;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function19 = function3M1007getLambda3$material_release;
                        final ScaffoldState scaffoldState4 = scaffoldState2;
                        Function2<? super Composer, ? super Integer, Unit> function20 = function2M1005getLambda1$material_release;
                        Function2<? super Composer, ? super Integer, Unit> function21 = function2M1006getLambda2$material_release;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                                invoke(modifier2, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Modifier childModifier, Composer composer2, int i37) {
                                int i38;
                                Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                                ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                                if ((i37 & 14) == 0) {
                                    i38 = i37 | (composer2.changed(childModifier) ? 4 : 2);
                                } else {
                                    i38 = i37;
                                }
                                if ((i38 & 91) != 18 || !composer2.getSkipping()) {
                                    long j10 = j8;
                                    long j11 = j9;
                                    final boolean z10 = z9;
                                    final int i39 = i35;
                                    final Function2<Composer, Integer, Unit> function22 = function16;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function23 = content;
                                    final Function2<Composer, Integer, Unit> function24 = function17;
                                    final Function2<Composer, Integer, Unit> function25 = function18;
                                    final int i40 = i36;
                                    final int i41 = i34;
                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function26 = function19;
                                    final ScaffoldState scaffoldState5 = scaffoldState4;
                                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                        public final void invoke(Composer composer3, int i42) {
                                            ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                            if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                                boolean z11 = z10;
                                                int i43 = i39;
                                                Function2<Composer, Integer, Unit> function27 = function22;
                                                Function3<PaddingValues, Composer, Integer, Unit> function28 = function23;
                                                final Function3<SnackbarHostState, Composer, Integer, Unit> function29 = function26;
                                                final ScaffoldState scaffoldState6 = scaffoldState5;
                                                final int i44 = i40;
                                                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                    public final void invoke(Composer composer4, int i45) {
                                                        ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                        if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                        } else {
                                                            function29.invoke(scaffoldState6.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                        }
                                                    }
                                                });
                                                Function2<Composer, Integer, Unit> function30 = function24;
                                                Function2<Composer, Integer, Unit> function31 = function25;
                                                int i45 = i40;
                                                ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z11, i43, function27, function28, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                    int i42 = 1572864 | (i38 & 14);
                                    int i43 = i34;
                                    SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j10, j11, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                        if (function9 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-1013848234);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                            int i37 = i27 << 12;
                            DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i38) {
                                    ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                    if ((i38 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                    } else {
                                        composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                    }
                                }
                            }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i37 & 57344) | (i37 & 458752) | (i37 & 3670016) | (i37 & 29360128) | (i37 & 234881024), 0);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-1013847725);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                            composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        scaffoldState3 = scaffoldState2;
                        function10 = function2M1008getLambda4$material_release;
                        i28 = iM1067getEnd5ygKITE;
                        f3 = f2;
                        function11 = function9;
                        z6 = z5;
                        function12 = function20;
                        function13 = function21;
                        boolean z10 = z3;
                        shape2 = large;
                        function14 = function3M1007getLambda3$material_release;
                        z7 = z10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        scaffoldState3 = scaffoldState;
                        function12 = function2;
                        function13 = function3;
                        function14 = function4;
                        function11 = function6;
                        shape2 = shape;
                        f3 = f;
                        jM983getSurface0d7_KjU = j;
                        j7 = j2;
                        scrimColor = j3;
                        jM972getBackground0d7_KjU = j4;
                        j6 = j5;
                        function10 = function7;
                        i28 = iM1067getEnd5ygKITE;
                        z7 = z;
                        z6 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final long j10 = jM983getSurface0d7_KjU;
                    final long j11 = j7;
                    final long j12 = scrimColor;
                    final long j13 = jM972getBackground0d7_KjU;
                    final long j14 = j6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i38) {
                            ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j10, j11, j12, j13, j14, content, composer2, i2 | 1, i3, i4);
                        }
                    });
                }
                i23 = 12582912;
                i20 |= i23;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function110 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z11 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z11;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f5 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U3 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U3;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f5;
                        i27 = i25;
                        function9 = function110;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z12 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z12;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f6 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U4 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U4;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f6;
                        i27 = i25;
                        function9 = function111;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j15 = jM972getBackground0d7_KjU;
                    final long j16 = j6;
                    final int i38 = i27;
                    final boolean z13 = z3;
                    final int i39 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function112 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function113 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function114 = function2M1006getLambda2$material_release;
                    final int i310 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function115 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState5 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function23 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i311) {
                            int i312;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i311 & 14) == 0) {
                                i312 = i311 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i312 = i311;
                            }
                            if ((i312 & 91) != 18 || !composer2.getSkipping()) {
                                long j17 = j15;
                                long j18 = j16;
                                final boolean z14 = z13;
                                final int i313 = i39;
                                final Function2<? super Composer, ? super Integer, Unit> function24 = function112;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function25 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function113;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function114;
                                final int i40 = i310;
                                final int i41 = i38;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function28 = function115;
                                final ScaffoldState scaffoldState6 = scaffoldState5;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z15 = z14;
                                            int i43 = i313;
                                            Function2<Composer, Integer, Unit> function29 = function24;
                                            Function3<PaddingValues, Composer, Integer, Unit> function210 = function25;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function211 = function28;
                                            final ScaffoldState scaffoldState7 = scaffoldState6;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function211.invoke(scaffoldState7.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function26;
                                            Function2<Composer, Integer, Unit> function31 = function27;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z15, i43, function29, function210, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i312 & 14);
                                int i43 = i38;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j17, j18, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i311 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i312) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i312 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i311 & 57344) | (i311 & 458752) | (i311 & 3670016) | (i311 & 29360128) | (i311 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function22;
                    function13 = function23;
                    boolean z14 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z14;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function116 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z15 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z15;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f7 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U5 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U5;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f7;
                        i27 = i25;
                        function9 = function116;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function117 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z16 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z16;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f8 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U6 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U6;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f8;
                        i27 = i25;
                        function9 = function117;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j17 = jM972getBackground0d7_KjU;
                    final long j18 = j6;
                    final int i312 = i27;
                    final boolean z17 = z3;
                    final int i313 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function118 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function119 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1110 = function2M1006getLambda2$material_release;
                    final int i314 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1111 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState6 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function24 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function25 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i315) {
                            int i316;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i315 & 14) == 0) {
                                i316 = i315 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i316 = i315;
                            }
                            if ((i316 & 91) != 18 || !composer2.getSkipping()) {
                                long j19 = j17;
                                long j110 = j18;
                                final boolean z18 = z17;
                                final int i317 = i313;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function118;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function27 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function119;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function1110;
                                final int i40 = i314;
                                final int i41 = i312;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function210 = function1111;
                                final ScaffoldState scaffoldState7 = scaffoldState6;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z19 = z18;
                                            int i43 = i317;
                                            Function2<Composer, Integer, Unit> function211 = function26;
                                            Function3<PaddingValues, Composer, Integer, Unit> function212 = function27;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function213 = function210;
                                            final ScaffoldState scaffoldState8 = scaffoldState7;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function213.invoke(scaffoldState8.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function28;
                                            Function2<Composer, Integer, Unit> function31 = function29;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z19, i43, function211, function212, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i316 & 14);
                                int i43 = i312;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j19, j110, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i315 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i316) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i316 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i315 & 57344) | (i315 & 458752) | (i315 & 3670016) | (i315 & 29360128) | (i315 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function24;
                    function13 = function25;
                    boolean z18 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final long j19 = jM983getSurface0d7_KjU;
                final long j110 = j7;
                final long j111 = scrimColor;
                final long j112 = jM972getBackground0d7_KjU;
                final long j113 = j6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i316) {
                        ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j19, j110, j111, j112, j113, content, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i5 |= 3072;
            i8 = i4 & 16;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function7)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
                iM1067getEnd5ygKITE = i;
            } else {
                iM1067getEnd5ygKITE = i;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(iM1067getEnd5ygKITE)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i5 |= i13;
                }
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function6)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            if ((i3 & 14) == 0) {
                i20 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
            } else {
                i20 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i20 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i20 |= i22;
            }
            if ((i3 & 896) != 0) {
                i20 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i20 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
            }
            if ((i3 & 57344) != 0) {
                i20 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j3)) ? 8192 : 16384;
            }
            if ((i3 & 458752) != 0) {
                if ((i4 & 32768) == 0) {
                    i30 = 65536;
                } else {
                    i30 = 65536;
                }
                i20 |= i30;
            }
            if ((i3 & 3670016) != 0) {
                if ((i4 & 65536) == 0) {
                    i29 = 524288;
                } else {
                    i29 = 524288;
                }
                i20 |= i29;
            }
            if ((i4 & 131072) != 0) {
                if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                }
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1112 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z19 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z19;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f9 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U7 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U7;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f9;
                        i27 = i25;
                        function9 = function1112;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1113 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z110 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z110;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f10 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U8 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U8;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f10;
                        i27 = i25;
                        function9 = function1113;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j114 = jM972getBackground0d7_KjU;
                    final long j115 = j6;
                    final int i316 = i27;
                    final boolean z111 = z3;
                    final int i317 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function1114 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1115 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1116 = function2M1006getLambda2$material_release;
                    final int i318 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1117 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState7 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function26 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function27 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i319) {
                            int i3110;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i319 & 14) == 0) {
                                i3110 = i319 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i3110 = i319;
                            }
                            if ((i3110 & 91) != 18 || !composer2.getSkipping()) {
                                long j116 = j114;
                                long j117 = j115;
                                final boolean z112 = z111;
                                final int i3111 = i317;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function1114;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function29 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function1115;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function1116;
                                final int i40 = i318;
                                final int i41 = i316;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function212 = function1117;
                                final ScaffoldState scaffoldState8 = scaffoldState7;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z113 = z112;
                                            int i43 = i3111;
                                            Function2<Composer, Integer, Unit> function213 = function28;
                                            Function3<PaddingValues, Composer, Integer, Unit> function214 = function29;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function215 = function212;
                                            final ScaffoldState scaffoldState9 = scaffoldState8;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function215.invoke(scaffoldState9.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function210;
                                            Function2<Composer, Integer, Unit> function31 = function211;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z113, i43, function213, function214, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i3110 & 14);
                                int i43 = i316;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j116, j117, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i319 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i3110) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i3110 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i319 & 57344) | (i319 & 458752) | (i319 & 3670016) | (i319 & 29360128) | (i319 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function26;
                    function13 = function27;
                    boolean z112 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1118 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z113 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z113;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f11 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U9 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U9;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f11;
                        i27 = i25;
                        function9 = function1118;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1119 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z114 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z114;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f12 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U10 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U10;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f12;
                        i27 = i25;
                        function9 = function1119;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j116 = jM972getBackground0d7_KjU;
                    final long j117 = j6;
                    final int i3110 = i27;
                    final boolean z115 = z3;
                    final int i3111 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function11110 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function11111 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function11112 = function2M1006getLambda2$material_release;
                    final int i3112 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11113 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState8 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function28 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function29 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i3113) {
                            int i3114;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i3113 & 14) == 0) {
                                i3114 = i3113 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i3114 = i3113;
                            }
                            if ((i3114 & 91) != 18 || !composer2.getSkipping()) {
                                long j118 = j116;
                                long j119 = j117;
                                final boolean z116 = z115;
                                final int i3115 = i3111;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function11110;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function211 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function11111;
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function11112;
                                final int i40 = i3112;
                                final int i41 = i3110;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function214 = function11113;
                                final ScaffoldState scaffoldState9 = scaffoldState8;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z117 = z116;
                                            int i43 = i3115;
                                            Function2<Composer, Integer, Unit> function215 = function210;
                                            Function3<PaddingValues, Composer, Integer, Unit> function216 = function211;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function217 = function214;
                                            final ScaffoldState scaffoldState10 = scaffoldState9;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function217.invoke(scaffoldState10.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function212;
                                            Function2<Composer, Integer, Unit> function31 = function213;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z117, i43, function215, function216, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i3114 & 14);
                                int i43 = i3110;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j118, j119, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i3113 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i3114) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i3114 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3113 & 57344) | (i3113 & 458752) | (i3113 & 3670016) | (i3113 & 29360128) | (i3113 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function28;
                    function13 = function29;
                    boolean z116 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z116;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final long j118 = jM983getSurface0d7_KjU;
                final long j119 = j7;
                final long j1110 = scrimColor;
                final long j1111 = jM972getBackground0d7_KjU;
                final long j1112 = j6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3114) {
                        ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j118, j119, j1110, j1111, j1112, content, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i23 = 12582912;
            i20 |= i23;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11114 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z117 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z117;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f13 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U11 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U11;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f13;
                    i27 = i25;
                    function9 = function11114;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11115 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z118 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z118;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f14 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U12 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U12;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f14;
                    i27 = i25;
                    function9 = function11115;
                }
                composerStartRestartGroup.endDefaults();
                final long j1113 = jM972getBackground0d7_KjU;
                final long j1114 = j6;
                final int i3114 = i27;
                final boolean z119 = z3;
                final int i3115 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function11116 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11117 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11118 = function2M1006getLambda2$material_release;
                final int i3116 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11119 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState9 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function210 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function211 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i3117) {
                        int i3118;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i3117 & 14) == 0) {
                            i3118 = i3117 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i3118 = i3117;
                        }
                        if ((i3118 & 91) != 18 || !composer2.getSkipping()) {
                            long j1115 = j1113;
                            long j1116 = j1114;
                            final boolean z1110 = z119;
                            final int i3119 = i3115;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function11116;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function213 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function214 = function11117;
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function11118;
                            final int i40 = i3116;
                            final int i41 = i3114;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function216 = function11119;
                            final ScaffoldState scaffoldState10 = scaffoldState9;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z1111 = z1110;
                                        int i43 = i3119;
                                        Function2<Composer, Integer, Unit> function217 = function212;
                                        Function3<PaddingValues, Composer, Integer, Unit> function218 = function213;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function219 = function216;
                                        final ScaffoldState scaffoldState11 = scaffoldState10;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function219.invoke(scaffoldState11.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function214;
                                        Function2<Composer, Integer, Unit> function31 = function215;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z1111, i43, function217, function218, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i3118 & 14);
                            int i43 = i3114;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j1115, j1116, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i3117 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3118) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i3118 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3117 & 57344) | (i3117 & 458752) | (i3117 & 3670016) | (i3117 & 29360128) | (i3117 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function210;
                function13 = function211;
                boolean z1110 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z1110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111110 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1111 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z1111;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f15 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U13 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U13;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f15;
                    i27 = i25;
                    function9 = function111110;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111111 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z1112 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z1112;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f16 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U14 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U14;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f16;
                    i27 = i25;
                    function9 = function111111;
                }
                composerStartRestartGroup.endDefaults();
                final long j1115 = jM972getBackground0d7_KjU;
                final long j1116 = j6;
                final int i3118 = i27;
                final boolean z1113 = z3;
                final int i3119 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function111112 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function111113 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function111114 = function2M1006getLambda2$material_release;
                final int i31110 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function111115 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState10 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function212 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function213 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i31111) {
                        int i31112;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i31111 & 14) == 0) {
                            i31112 = i31111 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i31112 = i31111;
                        }
                        if ((i31112 & 91) != 18 || !composer2.getSkipping()) {
                            long j1117 = j1115;
                            long j1118 = j1116;
                            final boolean z1114 = z1113;
                            final int i31113 = i3119;
                            final Function2<? super Composer, ? super Integer, Unit> function214 = function111112;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function215 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function216 = function111113;
                            final Function2<? super Composer, ? super Integer, Unit> function217 = function111114;
                            final int i40 = i31110;
                            final int i41 = i3118;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function218 = function111115;
                            final ScaffoldState scaffoldState11 = scaffoldState10;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z1115 = z1114;
                                        int i43 = i31113;
                                        Function2<Composer, Integer, Unit> function219 = function214;
                                        Function3<PaddingValues, Composer, Integer, Unit> function2110 = function215;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2111 = function218;
                                        final ScaffoldState scaffoldState12 = scaffoldState11;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function2111.invoke(scaffoldState12.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function216;
                                        Function2<Composer, Integer, Unit> function31 = function217;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z1115, i43, function219, function2110, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i31112 & 14);
                            int i43 = i3118;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j1117, j1118, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i31111 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i31112) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i31112 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31111 & 57344) | (i31111 & 458752) | (i31111 & 3670016) | (i31111 & 29360128) | (i31111 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function212;
                function13 = function213;
                boolean z1114 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z1114;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final long j1117 = jM983getSurface0d7_KjU;
            final long j1118 = j7;
            final long j1119 = scrimColor;
            final long j11110 = jM972getBackground0d7_KjU;
            final long j11111 = j6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i31112) {
                    ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j1117, j1118, j1119, j11110, j11111, content, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 384;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
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
                if (composerStartRestartGroup.changed(function4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function7)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
                iM1067getEnd5ygKITE = i;
            } else {
                iM1067getEnd5ygKITE = i;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(iM1067getEnd5ygKITE)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i5 |= i13;
                }
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function6)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            if ((i3 & 14) == 0) {
                i20 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
            } else {
                i20 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i20 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i20 |= i22;
            }
            if ((i3 & 896) != 0) {
                i20 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i20 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
            }
            if ((i3 & 57344) != 0) {
                i20 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j3)) ? 8192 : 16384;
            }
            if ((i3 & 458752) != 0) {
                if ((i4 & 32768) == 0) {
                    i30 = 65536;
                } else {
                    i30 = 65536;
                }
                i20 |= i30;
            }
            if ((i3 & 3670016) != 0) {
                if ((i4 & 65536) == 0) {
                    i29 = 524288;
                } else {
                    i29 = 524288;
                }
                i20 |= i29;
            }
            if ((i4 & 131072) != 0) {
                if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i23 = 8388608;
                    } else {
                        i23 = 4194304;
                    }
                }
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111116 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z1115 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z1115;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f17 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U15 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U15;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f17;
                        i27 = i25;
                        function9 = function111116;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111117 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z1116 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z1116;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f18 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U16 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U16;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f18;
                        i27 = i25;
                        function9 = function111117;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j11112 = jM972getBackground0d7_KjU;
                    final long j11113 = j6;
                    final int i31112 = i27;
                    final boolean z1117 = z3;
                    final int i31113 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function111118 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function111119 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1111110 = function2M1006getLambda2$material_release;
                    final int i31114 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1111111 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState11 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function214 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function215 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i31115) {
                            int i31116;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i31115 & 14) == 0) {
                                i31116 = i31115 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i31116 = i31115;
                            }
                            if ((i31116 & 91) != 18 || !composer2.getSkipping()) {
                                long j11114 = j11112;
                                long j11115 = j11113;
                                final boolean z1118 = z1117;
                                final int i31117 = i31113;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function111118;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function217 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function218 = function111119;
                                final Function2<? super Composer, ? super Integer, Unit> function219 = function1111110;
                                final int i40 = i31114;
                                final int i41 = i31112;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2110 = function1111111;
                                final ScaffoldState scaffoldState12 = scaffoldState11;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z1119 = z1118;
                                            int i43 = i31117;
                                            Function2<Composer, Integer, Unit> function2111 = function216;
                                            Function3<PaddingValues, Composer, Integer, Unit> function2112 = function217;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2113 = function2110;
                                            final ScaffoldState scaffoldState13 = scaffoldState12;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function2113.invoke(scaffoldState13.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function218;
                                            Function2<Composer, Integer, Unit> function31 = function219;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z1119, i43, function2111, function2112, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i31116 & 14);
                                int i43 = i31112;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j11114, j11115, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i31115 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i31116) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i31116 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31115 & 57344) | (i31115 & 458752) | (i31115 & 3670016) | (i31115 & 29360128) | (i31115 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function214;
                    function13 = function215;
                    boolean z1118 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z1118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111112 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z1119 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z1119;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f19 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U17 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U17;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f19;
                        i27 = i25;
                        function9 = function1111112;
                    } else {
                        if (i31 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i4 & 2) != 0) {
                            scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i5 &= -113;
                        } else {
                            scaffoldStateRememberScaffoldState = scaffoldState;
                        }
                        if (i32 != 0) {
                            function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                        } else {
                            function2M1005getLambda1$material_release = function2;
                        }
                        if (i6 != 0) {
                            function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                        } else {
                            function2M1006getLambda2$material_release = function3;
                        }
                        if (i8 != 0) {
                            function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                        } else {
                            function3M1007getLambda3$material_release = function4;
                        }
                        if (i10 != 0) {
                            function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                        } else {
                            function2M1008getLambda4$material_release = function5;
                        }
                        if (i12 != 0) {
                            iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                        }
                        if (i14 != 0) {
                            z3 = false;
                        } else {
                            z3 = z;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i18 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        scaffoldState2 = scaffoldStateRememberScaffoldState;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111113 = function8;
                        if ((i4 & 1024) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i20 &= -15;
                        } else {
                            large = shape;
                        }
                        i24 = i20;
                        if (i21 != 0) {
                            fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                        } else {
                            fM1024getElevationD9Ej5fM = f;
                        }
                        if ((i4 & 4096) != 0) {
                            boolean z11110 = z4;
                            i25 = i24 & (-897);
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            z5 = z11110;
                        } else {
                            z5 = z4;
                            i25 = i24;
                            jM983getSurface0d7_KjU = j;
                        }
                        float f110 = fM1024getElevationD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                            i25 &= -7169;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((i4 & 16384) != 0) {
                            i26 = 6;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i25 &= -57345;
                        } else {
                            i26 = 6;
                            scrimColor = j3;
                        }
                        if ((32768 & i4) != 0) {
                            jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                            i25 &= -458753;
                        } else {
                            jM972getBackground0d7_KjU = j4;
                        }
                        if ((i4 & 65536) != 0) {
                            long jM997contentColorForek8zF_U18 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                            i25 &= -3670017;
                            j6 = jM997contentColorForek8zF_U18;
                        } else {
                            j6 = j5;
                        }
                        j7 = jM997contentColorForek8zF_U;
                        f2 = f110;
                        i27 = i25;
                        function9 = function1111113;
                    }
                    composerStartRestartGroup.endDefaults();
                    final long j11114 = jM972getBackground0d7_KjU;
                    final long j11115 = j6;
                    final int i31116 = i27;
                    final boolean z11111 = z3;
                    final int i31117 = iM1067getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function1111114 = function2M1005getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1111115 = function2M1008getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function1111116 = function2M1006getLambda2$material_release;
                    final int i31118 = i5;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1111117 = function3M1007getLambda3$material_release;
                    final ScaffoldState scaffoldState12 = scaffoldState2;
                    Function2<? super Composer, ? super Integer, Unit> function216 = function2M1005getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function217 = function2M1006getLambda2$material_release;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                            invoke(modifier2, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier childModifier, Composer composer2, int i31119) {
                            int i311110;
                            Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                            ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                            if ((i31119 & 14) == 0) {
                                i311110 = i31119 | (composer2.changed(childModifier) ? 4 : 2);
                            } else {
                                i311110 = i31119;
                            }
                            if ((i311110 & 91) != 18 || !composer2.getSkipping()) {
                                long j11116 = j11114;
                                long j11117 = j11115;
                                final boolean z11112 = z11111;
                                final int i311111 = i31117;
                                final Function2<? super Composer, ? super Integer, Unit> function218 = function1111114;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function219 = content;
                                final Function2<? super Composer, ? super Integer, Unit> function2110 = function1111115;
                                final Function2<? super Composer, ? super Integer, Unit> function2111 = function1111116;
                                final int i40 = i31118;
                                final int i41 = i31116;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2112 = function1111117;
                                final ScaffoldState scaffoldState13 = scaffoldState12;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                        if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                            boolean z11113 = z11112;
                                            int i43 = i311111;
                                            Function2<Composer, Integer, Unit> function2113 = function218;
                                            Function3<PaddingValues, Composer, Integer, Unit> function2114 = function219;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2115 = function2112;
                                            final ScaffoldState scaffoldState14 = scaffoldState13;
                                            final int i44 = i40;
                                            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                                public final void invoke(Composer composer4, int i45) {
                                                    ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                    if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        function2115.invoke(scaffoldState14.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function30 = function2110;
                                            Function2<Composer, Integer, Unit> function31 = function2111;
                                            int i45 = i40;
                                            ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z11113, i43, function2113, function2114, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i42 = 1572864 | (i311110 & 14);
                                int i43 = i31116;
                                SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j11116, j11117, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function9 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-1013848234);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                        int i31119 = i27 << 12;
                        DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i311110) {
                                ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                                if ((i311110 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31119 & 57344) | (i31119 & 458752) | (i31119 & 3670016) | (i31119 & 29360128) | (i31119 & 234881024), 0);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1013847725);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                        composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    scaffoldState3 = scaffoldState2;
                    function10 = function2M1008getLambda4$material_release;
                    i28 = iM1067getEnd5ygKITE;
                    f3 = f2;
                    function11 = function9;
                    z6 = z5;
                    function12 = function216;
                    function13 = function217;
                    boolean z11112 = z3;
                    shape2 = large;
                    function14 = function3M1007getLambda3$material_release;
                    z7 = z11112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final long j11116 = jM983getSurface0d7_KjU;
                final long j11117 = j7;
                final long j11118 = scrimColor;
                final long j11119 = jM972getBackground0d7_KjU;
                final long j111110 = j6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i311110) {
                        ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j11116, j11117, j11118, j11119, j111110, content, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i23 = 12582912;
            i20 |= i23;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111118 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11113 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z11113;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f111 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U19 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U19;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f111;
                    i27 = i25;
                    function9 = function1111118;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111119 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11114 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z11114;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f112 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U110 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U110;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f112;
                    i27 = i25;
                    function9 = function1111119;
                }
                composerStartRestartGroup.endDefaults();
                final long j111111 = jM972getBackground0d7_KjU;
                final long j111112 = j6;
                final int i311110 = i27;
                final boolean z11115 = z3;
                final int i311111 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function11111110 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11111111 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11111112 = function2M1006getLambda2$material_release;
                final int i311112 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11111113 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState13 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function218 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function219 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i311113) {
                        int i311114;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i311113 & 14) == 0) {
                            i311114 = i311113 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i311114 = i311113;
                        }
                        if ((i311114 & 91) != 18 || !composer2.getSkipping()) {
                            long j111113 = j111111;
                            long j111114 = j111112;
                            final boolean z11116 = z11115;
                            final int i311115 = i311111;
                            final Function2<? super Composer, ? super Integer, Unit> function2110 = function11111110;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function2111 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function2112 = function11111111;
                            final Function2<? super Composer, ? super Integer, Unit> function2113 = function11111112;
                            final int i40 = i311112;
                            final int i41 = i311110;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2114 = function11111113;
                            final ScaffoldState scaffoldState14 = scaffoldState13;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z11117 = z11116;
                                        int i43 = i311115;
                                        Function2<Composer, Integer, Unit> function2115 = function2110;
                                        Function3<PaddingValues, Composer, Integer, Unit> function2116 = function2111;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2117 = function2114;
                                        final ScaffoldState scaffoldState15 = scaffoldState14;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function2117.invoke(scaffoldState15.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function2112;
                                        Function2<Composer, Integer, Unit> function31 = function2113;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z11117, i43, function2115, function2116, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i311114 & 14);
                            int i43 = i311110;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j111113, j111114, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i311113 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i311114) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i311114 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i311113 & 57344) | (i311113 & 458752) | (i311113 & 3670016) | (i311113 & 29360128) | (i311113 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function218;
                function13 = function219;
                boolean z11116 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z11116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11111114 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11117 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z11117;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f113 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U111 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U111;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f113;
                    i27 = i25;
                    function9 = function11111114;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11111115 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z11118 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z11118;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f114 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U112 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U112;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f114;
                    i27 = i25;
                    function9 = function11111115;
                }
                composerStartRestartGroup.endDefaults();
                final long j111113 = jM972getBackground0d7_KjU;
                final long j111114 = j6;
                final int i311114 = i27;
                final boolean z11119 = z3;
                final int i311115 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function11111116 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11111117 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function11111118 = function2M1006getLambda2$material_release;
                final int i311116 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11111119 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState14 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function2110 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function2111 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i311117) {
                        int i311118;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i311117 & 14) == 0) {
                            i311118 = i311117 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i311118 = i311117;
                        }
                        if ((i311118 & 91) != 18 || !composer2.getSkipping()) {
                            long j111115 = j111113;
                            long j111116 = j111114;
                            final boolean z111110 = z11119;
                            final int i311119 = i311115;
                            final Function2<? super Composer, ? super Integer, Unit> function2112 = function11111116;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function2113 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function2114 = function11111117;
                            final Function2<? super Composer, ? super Integer, Unit> function2115 = function11111118;
                            final int i40 = i311116;
                            final int i41 = i311114;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2116 = function11111119;
                            final ScaffoldState scaffoldState15 = scaffoldState14;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z111111 = z111110;
                                        int i43 = i311119;
                                        Function2<Composer, Integer, Unit> function2117 = function2112;
                                        Function3<PaddingValues, Composer, Integer, Unit> function2118 = function2113;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2119 = function2116;
                                        final ScaffoldState scaffoldState16 = scaffoldState15;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function2119.invoke(scaffoldState16.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function2114;
                                        Function2<Composer, Integer, Unit> function31 = function2115;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z111111, i43, function2117, function2118, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i311118 & 14);
                            int i43 = i311114;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j111115, j111116, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i311117 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i311118) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i311118 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i311117 & 57344) | (i311117 & 458752) | (i311117 & 3670016) | (i311117 & 29360128) | (i311117 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function2110;
                function13 = function2111;
                boolean z111110 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z111110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final long j111115 = jM983getSurface0d7_KjU;
            final long j111116 = j7;
            final long j111117 = scrimColor;
            final long j111118 = jM972getBackground0d7_KjU;
            final long j111119 = j6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i311118) {
                    ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j111115, j111116, j111117, j111118, j111119, content, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 3072;
        i8 = i4 & 16;
        if (i8 != 0) {
            i5 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (composerStartRestartGroup.changed(function4)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i5 |= i9;
        }
        i10 = i4 & 32;
        if (i10 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function7 = function5;
        } else {
            function7 = function5;
            if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(function7)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
        }
        i12 = i4 & 64;
        if (i12 != 0) {
            i5 |= 1572864;
            iM1067getEnd5ygKITE = i;
        } else {
            iM1067getEnd5ygKITE = i;
            if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(iM1067getEnd5ygKITE)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i5 |= i13;
            }
        }
        i14 = i4 & 128;
        if (i14 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i5 |= i15;
        }
        i16 = i4 & 256;
        if (i16 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(function6)) {
                i17 = 67108864;
            } else {
                i17 = 33554432;
            }
            i5 |= i17;
        }
        i18 = i4 & 512;
        if (i18 != 0) {
            i5 |= C.ENCODING_PCM_32BIT;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i19 = 536870912;
            } else {
                i19 = 268435456;
            }
            i5 |= i19;
        }
        if ((i3 & 14) == 0) {
            i20 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(shape)) ? 2 : 4);
        } else {
            i20 = i3;
        }
        i21 = i4 & 2048;
        if (i21 != 0) {
            i20 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i22 = 32;
            } else {
                i22 = 16;
            }
            i20 |= i22;
        }
        if ((i3 & 896) != 0) {
            i20 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(j)) ? 128 : 256;
        }
        if ((i3 & 7168) != 0) {
            i20 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(j2)) ? 1024 : 2048;
        }
        if ((i3 & 57344) != 0) {
            i20 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j3)) ? 8192 : 16384;
        }
        if ((i3 & 458752) != 0) {
            if ((i4 & 32768) == 0) {
                i30 = 65536;
            } else {
                i30 = 65536;
            }
            i20 |= i30;
        }
        if ((i3 & 3670016) != 0) {
            if ((i4 & 65536) == 0) {
                i29 = 524288;
            } else {
                i29 = 524288;
            }
            i20 |= i29;
        }
        if ((i4 & 131072) != 0) {
            if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i23 = 8388608;
                } else {
                    i23 = 4194304;
                }
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111111110 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z111111 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z111111;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f115 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U113 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U113;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f115;
                    i27 = i25;
                    function9 = function111111110;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111111111 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z111112 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z111112;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f116 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U114 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U114;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f116;
                    i27 = i25;
                    function9 = function111111111;
                }
                composerStartRestartGroup.endDefaults();
                final long j1111110 = jM972getBackground0d7_KjU;
                final long j1111111 = j6;
                final int i311118 = i27;
                final boolean z111113 = z3;
                final int i311119 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function111111112 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function111111113 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function111111114 = function2M1006getLambda2$material_release;
                final int i3111110 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function111111115 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState15 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function2112 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function2113 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i3111111) {
                        int i3111112;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i3111111 & 14) == 0) {
                            i3111112 = i3111111 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i3111112 = i3111111;
                        }
                        if ((i3111112 & 91) != 18 || !composer2.getSkipping()) {
                            long j1111112 = j1111110;
                            long j1111113 = j1111111;
                            final boolean z111114 = z111113;
                            final int i3111113 = i311119;
                            final Function2<? super Composer, ? super Integer, Unit> function2114 = function111111112;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function2115 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function2116 = function111111113;
                            final Function2<? super Composer, ? super Integer, Unit> function2117 = function111111114;
                            final int i40 = i3111110;
                            final int i41 = i311118;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function2118 = function111111115;
                            final ScaffoldState scaffoldState16 = scaffoldState15;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z111115 = z111114;
                                        int i43 = i3111113;
                                        Function2<Composer, Integer, Unit> function2119 = function2114;
                                        Function3<PaddingValues, Composer, Integer, Unit> function21110 = function2115;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21111 = function2118;
                                        final ScaffoldState scaffoldState17 = scaffoldState16;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function21111.invoke(scaffoldState17.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function2116;
                                        Function2<Composer, Integer, Unit> function31 = function2117;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z111115, i43, function2119, function21110, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i3111112 & 14);
                            int i43 = i311118;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j1111112, j1111113, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i3111111 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3111112) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i3111112 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3111111 & 57344) | (i3111111 & 458752) | (i3111111 & 3670016) | (i3111111 & 29360128) | (i3111111 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function2112;
                function13 = function2113;
                boolean z111114 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z111114;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111111116 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z111115 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z111115;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f117 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U115 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U115;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f117;
                    i27 = i25;
                    function9 = function111111116;
                } else {
                    if (i31 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i4 & 2) != 0) {
                        scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i5 &= -113;
                    } else {
                        scaffoldStateRememberScaffoldState = scaffoldState;
                    }
                    if (i32 != 0) {
                        function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                    } else {
                        function2M1005getLambda1$material_release = function2;
                    }
                    if (i6 != 0) {
                        function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                    } else {
                        function2M1006getLambda2$material_release = function3;
                    }
                    if (i8 != 0) {
                        function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                    } else {
                        function3M1007getLambda3$material_release = function4;
                    }
                    if (i10 != 0) {
                        function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                    } else {
                        function2M1008getLambda4$material_release = function5;
                    }
                    if (i12 != 0) {
                        iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                    }
                    if (i14 != 0) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i18 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    scaffoldState2 = scaffoldStateRememberScaffoldState;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function111111117 = function8;
                    if ((i4 & 1024) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i20 &= -15;
                    } else {
                        large = shape;
                    }
                    i24 = i20;
                    if (i21 != 0) {
                        fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                    } else {
                        fM1024getElevationD9Ej5fM = f;
                    }
                    if ((i4 & 4096) != 0) {
                        boolean z111116 = z4;
                        i25 = i24 & (-897);
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        z5 = z111116;
                    } else {
                        z5 = z4;
                        i25 = i24;
                        jM983getSurface0d7_KjU = j;
                    }
                    float f118 = fM1024getElevationD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                        i25 &= -7169;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((i4 & 16384) != 0) {
                        i26 = 6;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i25 &= -57345;
                    } else {
                        i26 = 6;
                        scrimColor = j3;
                    }
                    if ((32768 & i4) != 0) {
                        jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                        i25 &= -458753;
                    } else {
                        jM972getBackground0d7_KjU = j4;
                    }
                    if ((i4 & 65536) != 0) {
                        long jM997contentColorForek8zF_U116 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                        i25 &= -3670017;
                        j6 = jM997contentColorForek8zF_U116;
                    } else {
                        j6 = j5;
                    }
                    j7 = jM997contentColorForek8zF_U;
                    f2 = f118;
                    i27 = i25;
                    function9 = function111111117;
                }
                composerStartRestartGroup.endDefaults();
                final long j1111112 = jM972getBackground0d7_KjU;
                final long j1111113 = j6;
                final int i3111112 = i27;
                final boolean z111117 = z3;
                final int i3111113 = iM1067getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function111111118 = function2M1005getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function111111119 = function2M1008getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function1111111110 = function2M1006getLambda2$material_release;
                final int i3111114 = i5;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1111111111 = function3M1007getLambda3$material_release;
                final ScaffoldState scaffoldState16 = scaffoldState2;
                Function2<? super Composer, ? super Integer, Unit> function2114 = function2M1005getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function2115 = function2M1006getLambda2$material_release;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                        invoke(modifier2, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer composer2, int i3111115) {
                        int i3111116;
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                        if ((i3111115 & 14) == 0) {
                            i3111116 = i3111115 | (composer2.changed(childModifier) ? 4 : 2);
                        } else {
                            i3111116 = i3111115;
                        }
                        if ((i3111116 & 91) != 18 || !composer2.getSkipping()) {
                            long j1111114 = j1111112;
                            long j1111115 = j1111113;
                            final boolean z111118 = z111117;
                            final int i3111117 = i3111113;
                            final Function2<? super Composer, ? super Integer, Unit> function2116 = function111111118;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function2117 = content;
                            final Function2<? super Composer, ? super Integer, Unit> function2118 = function111111119;
                            final Function2<? super Composer, ? super Integer, Unit> function2119 = function1111111110;
                            final int i40 = i3111114;
                            final int i41 = i3111112;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21110 = function1111111111;
                            final ScaffoldState scaffoldState17 = scaffoldState16;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer composer3, int i42) {
                                    ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                        boolean z111119 = z111118;
                                        int i43 = i3111117;
                                        Function2<Composer, Integer, Unit> function21111 = function2116;
                                        Function3<PaddingValues, Composer, Integer, Unit> function21112 = function2117;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21113 = function21110;
                                        final ScaffoldState scaffoldState18 = scaffoldState17;
                                        final int i44 = i40;
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                            public final void invoke(Composer composer4, int i45) {
                                                ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                } else {
                                                    function21113.invoke(scaffoldState18.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function30 = function2118;
                                        Function2<Composer, Integer, Unit> function31 = function2119;
                                        int i45 = i40;
                                        ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z111119, i43, function21111, function21112, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i42 = 1572864 | (i3111116 & 14);
                            int i43 = i3111112;
                            SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j1111114, j1111115, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function9 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                    int i3111115 = i27 << 12;
                    DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3111116) {
                            ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if ((i3111116 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                            }
                        }
                    }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3111115 & 57344) | (i3111115 & 458752) | (i3111115 & 3670016) | (i3111115 & 29360128) | (i3111115 & 234881024), 0);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                    composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                    composerStartRestartGroup.endReplaceableGroup();
                }
                scaffoldState3 = scaffoldState2;
                function10 = function2M1008getLambda4$material_release;
                i28 = iM1067getEnd5ygKITE;
                f3 = f2;
                function11 = function9;
                z6 = z5;
                function12 = function2114;
                function13 = function2115;
                boolean z111118 = z3;
                shape2 = large;
                function14 = function3M1007getLambda3$material_release;
                z7 = z111118;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final long j1111114 = jM983getSurface0d7_KjU;
            final long j1111115 = j7;
            final long j1111116 = scrimColor;
            final long j1111117 = jM972getBackground0d7_KjU;
            final long j1111118 = j6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3111116) {
                    ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j1111114, j1111115, j1111116, j1111117, j1111118, content, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i23 = 12582912;
        i20 |= i23;
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i31 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i32 != 0) {
                    function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                } else {
                    function2M1005getLambda1$material_release = function2;
                }
                if (i6 != 0) {
                    function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                } else {
                    function2M1006getLambda2$material_release = function3;
                }
                if (i8 != 0) {
                    function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                } else {
                    function3M1007getLambda3$material_release = function4;
                }
                if (i10 != 0) {
                    function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                } else {
                    function2M1008getLambda4$material_release = function5;
                }
                if (i12 != 0) {
                    iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                }
                if (i14 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i16 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i18 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111111112 = function8;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i20 &= -15;
                } else {
                    large = shape;
                }
                i24 = i20;
                if (i21 != 0) {
                    fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                } else {
                    fM1024getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z111119 = z4;
                    i25 = i24 & (-897);
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    z5 = z111119;
                } else {
                    z5 = z4;
                    i25 = i24;
                    jM983getSurface0d7_KjU = j;
                }
                float f119 = fM1024getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                    i25 &= -7169;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i26 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i25 &= -57345;
                } else {
                    i26 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                    i25 &= -458753;
                } else {
                    jM972getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    long jM997contentColorForek8zF_U117 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                    i25 &= -3670017;
                    j6 = jM997contentColorForek8zF_U117;
                } else {
                    j6 = j5;
                }
                j7 = jM997contentColorForek8zF_U;
                f2 = f119;
                i27 = i25;
                function9 = function1111111112;
            } else {
                if (i31 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i32 != 0) {
                    function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                } else {
                    function2M1005getLambda1$material_release = function2;
                }
                if (i6 != 0) {
                    function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                } else {
                    function2M1006getLambda2$material_release = function3;
                }
                if (i8 != 0) {
                    function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                } else {
                    function3M1007getLambda3$material_release = function4;
                }
                if (i10 != 0) {
                    function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                } else {
                    function2M1008getLambda4$material_release = function5;
                }
                if (i12 != 0) {
                    iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                }
                if (i14 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i16 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i18 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111111113 = function8;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i20 &= -15;
                } else {
                    large = shape;
                }
                i24 = i20;
                if (i21 != 0) {
                    fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                } else {
                    fM1024getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z1111110 = z4;
                    i25 = i24 & (-897);
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    z5 = z1111110;
                } else {
                    z5 = z4;
                    i25 = i24;
                    jM983getSurface0d7_KjU = j;
                }
                float f1110 = fM1024getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                    i25 &= -7169;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i26 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i25 &= -57345;
                } else {
                    i26 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                    i25 &= -458753;
                } else {
                    jM972getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    long jM997contentColorForek8zF_U118 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                    i25 &= -3670017;
                    j6 = jM997contentColorForek8zF_U118;
                } else {
                    j6 = j5;
                }
                j7 = jM997contentColorForek8zF_U;
                f2 = f1110;
                i27 = i25;
                function9 = function1111111113;
            }
            composerStartRestartGroup.endDefaults();
            final long j1111119 = jM972getBackground0d7_KjU;
            final long j11111110 = j6;
            final int i3111116 = i27;
            final boolean z1111111 = z3;
            final int i3111117 = iM1067getEnd5ygKITE;
            final Function2<? super Composer, ? super Integer, Unit> function1111111114 = function2M1005getLambda1$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function1111111115 = function2M1008getLambda4$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function1111111116 = function2M1006getLambda2$material_release;
            final int i3111118 = i5;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function1111111117 = function3M1007getLambda3$material_release;
            final ScaffoldState scaffoldState17 = scaffoldState2;
            Function2<? super Composer, ? super Integer, Unit> function2116 = function2M1005getLambda1$material_release;
            Function2<? super Composer, ? super Integer, Unit> function2117 = function2M1006getLambda2$material_release;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                    invoke(modifier2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier childModifier, Composer composer2, int i3111119) {
                    int i31111110;
                    Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                    ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                    if ((i3111119 & 14) == 0) {
                        i31111110 = i3111119 | (composer2.changed(childModifier) ? 4 : 2);
                    } else {
                        i31111110 = i3111119;
                    }
                    if ((i31111110 & 91) != 18 || !composer2.getSkipping()) {
                        long j11111111 = j1111119;
                        long j11111112 = j11111110;
                        final boolean z1111112 = z1111111;
                        final int i31111111 = i3111117;
                        final Function2<? super Composer, ? super Integer, Unit> function2118 = function1111111114;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function2119 = content;
                        final Function2<? super Composer, ? super Integer, Unit> function21110 = function1111111115;
                        final Function2<? super Composer, ? super Integer, Unit> function21111 = function1111111116;
                        final int i40 = i3111118;
                        final int i41 = i3111116;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21112 = function1111111117;
                        final ScaffoldState scaffoldState18 = scaffoldState17;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                            public final void invoke(Composer composer3, int i42) {
                                ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                    boolean z1111113 = z1111112;
                                    int i43 = i31111111;
                                    Function2<Composer, Integer, Unit> function21113 = function2118;
                                    Function3<PaddingValues, Composer, Integer, Unit> function21114 = function2119;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21115 = function21112;
                                    final ScaffoldState scaffoldState19 = scaffoldState18;
                                    final int i44 = i40;
                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                        public final void invoke(Composer composer4, int i45) {
                                            ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                            if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                function21115.invoke(scaffoldState19.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                            }
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function30 = function21110;
                                    Function2<Composer, Integer, Unit> function31 = function21111;
                                    int i45 = i40;
                                    ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z1111113, i43, function21113, function21114, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        int i42 = 1572864 | (i31111110 & 14);
                        int i43 = i3111116;
                        SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j11111111, j11111112, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (function9 != null) {
                composerStartRestartGroup.startReplaceableGroup(-1013848234);
                ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                int i3111119 = i27 << 12;
                DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i31111110) {
                        ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                        if ((i31111110 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                        }
                    }
                }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i3111119 & 57344) | (i3111119 & 458752) | (i3111119 & 3670016) | (i3111119 & 29360128) | (i3111119 & 234881024), 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1013847725);
                ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                composerStartRestartGroup.endReplaceableGroup();
            }
            scaffoldState3 = scaffoldState2;
            function10 = function2M1008getLambda4$material_release;
            i28 = iM1067getEnd5ygKITE;
            f3 = f2;
            function11 = function9;
            z6 = z5;
            function12 = function2116;
            function13 = function2117;
            boolean z1111112 = z3;
            shape2 = large;
            function14 = function3M1007getLambda3$material_release;
            z7 = z1111112;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i31 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i32 != 0) {
                    function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                } else {
                    function2M1005getLambda1$material_release = function2;
                }
                if (i6 != 0) {
                    function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                } else {
                    function2M1006getLambda2$material_release = function3;
                }
                if (i8 != 0) {
                    function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                } else {
                    function3M1007getLambda3$material_release = function4;
                }
                if (i10 != 0) {
                    function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                } else {
                    function2M1008getLambda4$material_release = function5;
                }
                if (i12 != 0) {
                    iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                }
                if (i14 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i16 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i18 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111111118 = function8;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i20 &= -15;
                } else {
                    large = shape;
                }
                i24 = i20;
                if (i21 != 0) {
                    fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                } else {
                    fM1024getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z1111113 = z4;
                    i25 = i24 & (-897);
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    z5 = z1111113;
                } else {
                    z5 = z4;
                    i25 = i24;
                    jM983getSurface0d7_KjU = j;
                }
                float f1111 = fM1024getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                    i25 &= -7169;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i26 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i25 &= -57345;
                } else {
                    i26 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                    i25 &= -458753;
                } else {
                    jM972getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    long jM997contentColorForek8zF_U119 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                    i25 &= -3670017;
                    j6 = jM997contentColorForek8zF_U119;
                } else {
                    j6 = j5;
                }
                j7 = jM997contentColorForek8zF_U;
                f2 = f1111;
                i27 = i25;
                function9 = function1111111118;
            } else {
                if (i31 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i4 & 2) != 0) {
                    scaffoldStateRememberScaffoldState = rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i5 &= -113;
                } else {
                    scaffoldStateRememberScaffoldState = scaffoldState;
                }
                if (i32 != 0) {
                    function2M1005getLambda1$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1005getLambda1$material_release();
                } else {
                    function2M1005getLambda1$material_release = function2;
                }
                if (i6 != 0) {
                    function2M1006getLambda2$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1006getLambda2$material_release();
                } else {
                    function2M1006getLambda2$material_release = function3;
                }
                if (i8 != 0) {
                    function3M1007getLambda3$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1007getLambda3$material_release();
                } else {
                    function3M1007getLambda3$material_release = function4;
                }
                if (i10 != 0) {
                    function2M1008getLambda4$material_release = ComposableSingletons$ScaffoldKt.INSTANCE.m1008getLambda4$material_release();
                } else {
                    function2M1008getLambda4$material_release = function5;
                }
                if (i12 != 0) {
                    iM1067getEnd5ygKITE = FabPosition.INSTANCE.m1067getEnd5ygKITE();
                }
                if (i14 != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if (i16 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i18 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                scaffoldState2 = scaffoldStateRememberScaffoldState;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function1111111119 = function8;
                if ((i4 & 1024) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i20 &= -15;
                } else {
                    large = shape;
                }
                i24 = i20;
                if (i21 != 0) {
                    fM1024getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1024getElevationD9Ej5fM();
                } else {
                    fM1024getElevationD9Ej5fM = f;
                }
                if ((i4 & 4096) != 0) {
                    boolean z1111114 = z4;
                    i25 = i24 & (-897);
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    z5 = z1111114;
                } else {
                    z5 = z4;
                    i25 = i24;
                    jM983getSurface0d7_KjU = j;
                }
                float f1112 = fM1024getElevationD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 6) & 14);
                    i25 &= -7169;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((i4 & 16384) != 0) {
                    i26 = 6;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i25 &= -57345;
                } else {
                    i26 = 6;
                    scrimColor = j3;
                }
                if ((32768 & i4) != 0) {
                    jM972getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, i26).m972getBackground0d7_KjU();
                    i25 &= -458753;
                } else {
                    jM972getBackground0d7_KjU = j4;
                }
                if ((i4 & 65536) != 0) {
                    long jM997contentColorForek8zF_U1110 = ColorsKt.m997contentColorForek8zF_U(jM972getBackground0d7_KjU, composerStartRestartGroup, (i25 >> 15) & 14);
                    i25 &= -3670017;
                    j6 = jM997contentColorForek8zF_U1110;
                } else {
                    j6 = j5;
                }
                j7 = jM997contentColorForek8zF_U;
                f2 = f1112;
                i27 = i25;
                function9 = function1111111119;
            }
            composerStartRestartGroup.endDefaults();
            final long j11111111 = jM972getBackground0d7_KjU;
            final long j11111112 = j6;
            final int i31111110 = i27;
            final boolean z1111115 = z3;
            final int i31111111 = iM1067getEnd5ygKITE;
            final Function2<? super Composer, ? super Integer, Unit> function11111111110 = function2M1005getLambda1$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function11111111111 = function2M1008getLambda4$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function11111111112 = function2M1006getLambda2$material_release;
            final int i31111112 = i5;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11111111113 = function3M1007getLambda3$material_release;
            final ScaffoldState scaffoldState18 = scaffoldState2;
            Function2<? super Composer, ? super Integer, Unit> function2118 = function2M1005getLambda1$material_release;
            Function2<? super Composer, ? super Integer, Unit> function2119 = function2M1006getLambda2$material_release;
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier2, Composer composer2, Integer num) {
                    invoke(modifier2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier childModifier, Composer composer2, int i31111113) {
                    int i31111114;
                    Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                    ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
                    if ((i31111113 & 14) == 0) {
                        i31111114 = i31111113 | (composer2.changed(childModifier) ? 4 : 2);
                    } else {
                        i31111114 = i31111113;
                    }
                    if ((i31111114 & 91) != 18 || !composer2.getSkipping()) {
                        long j11111113 = j11111111;
                        long j11111114 = j11111112;
                        final boolean z1111116 = z1111115;
                        final int i31111115 = i31111111;
                        final Function2<? super Composer, ? super Integer, Unit> function21110 = function11111111110;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function21111 = content;
                        final Function2<? super Composer, ? super Integer, Unit> function21112 = function11111111111;
                        final Function2<? super Composer, ? super Integer, Unit> function21113 = function11111111112;
                        final int i40 = i31111112;
                        final int i41 = i31111110;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21114 = function11111111113;
                        final ScaffoldState scaffoldState19 = scaffoldState18;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                            public final void invoke(Composer composer3, int i42) {
                                ComposerKt.sourceInformation(composer3, "C180@8164L413:Scaffold.kt#jmzs0o");
                                if ((i42 & 11) != 2 || !composer3.getSkipping()) {
                                    boolean z1111117 = z1111116;
                                    int i43 = i31111115;
                                    Function2<Composer, Integer, Unit> function21115 = function21110;
                                    Function3<PaddingValues, Composer, Integer, Unit> function21116 = function21111;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21117 = function21114;
                                    final ScaffoldState scaffoldState110 = scaffoldState19;
                                    final int i44 = i40;
                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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

                                        public final void invoke(Composer composer4, int i45) {
                                            ComposerKt.sourceInformation(composer4, "C186@8417L45:Scaffold.kt#jmzs0o");
                                            if ((i45 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                function21117.invoke(scaffoldState110.getSnackbarHostState(), composer4, Integer.valueOf((i44 >> 9) & 112));
                                            }
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function30 = function21112;
                                    Function2<Composer, Integer, Unit> function31 = function21113;
                                    int i45 = i40;
                                    ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z1111117, i43, function21115, function21116, composableLambda3, function30, function31, composer3, ((i45 >> 21) & 14) | 24576 | ((i45 >> 15) & 112) | (i45 & 896) | ((i41 >> 12) & 7168) | (458752 & i45) | ((i45 << 9) & 3670016));
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        int i42 = 1572864 | (i31111114 & 14);
                        int i43 = i31111110;
                        SurfaceKt.m1175SurfaceFjzlyU(childModifier, null, j11111113, j11111114, null, 0.0f, composableLambda2, composer2, i42 | ((i43 >> 9) & 896) | ((i43 >> 9) & 7168), 50);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (function9 != null) {
                composerStartRestartGroup.startReplaceableGroup(-1013848234);
                ComposerKt.sourceInformation(composerStartRestartGroup, "195@8636L487");
                int i31111113 = i27 << 12;
                DrawerKt.m1028ModalDrawerGs3lGvM(function9, companion, scaffoldState2.getDrawerState(), z5, large, f2, jM983getSurface0d7_KjU, j7, scrimColor, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i31111114) {
                        ComposerKt.sourceInformation(composer2, "C205@9096L15:Scaffold.kt#jmzs0o");
                        if ((i31111114 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            composableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                        }
                    }
                }), composerStartRestartGroup, ((i5 >> 24) & 14) | C.ENCODING_PCM_32BIT | ((i5 << 3) & 112) | ((i5 >> 18) & 7168) | (i31111113 & 57344) | (i31111113 & 458752) | (i31111113 & 3670016) | (i31111113 & 29360128) | (i31111113 & 234881024), 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1013847725);
                ComposerKt.sourceInformation(composerStartRestartGroup, "208@9145L15");
                composableLambda.invoke(companion, composerStartRestartGroup, Integer.valueOf((i5 & 14) | 48));
                composerStartRestartGroup.endReplaceableGroup();
            }
            scaffoldState3 = scaffoldState2;
            function10 = function2M1008getLambda4$material_release;
            i28 = iM1067getEnd5ygKITE;
            f3 = f2;
            function11 = function9;
            z6 = z5;
            function12 = function2118;
            function13 = function2119;
            boolean z1111116 = z3;
            shape2 = large;
            function14 = function3M1007getLambda3$material_release;
            z7 = z1111116;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final long j11111113 = jM983getSurface0d7_KjU;
        final long j11111114 = j7;
        final long j11111115 = scrimColor;
        final long j11111116 = jM972getBackground0d7_KjU;
        final long j11111117 = j6;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i31111114) {
                ScaffoldKt.m1146Scaffold27mzLpw(companion, scaffoldState3, function12, function13, function14, function10, i28, z7, function11, z6, shape2, f3, j11111113, j11111114, j11111115, j11111116, j11111117, content, composer2, i2 | 1, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1147ScaffoldLayoutMDYNRJg(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, Composer composer, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4498,236@10217L4515:Scaffold.kt#jmzs0o");
        int i3 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function4) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function5) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function6) ? 1048576 : 524288;
        }
        final int i4 = i3;
        if ((i4 & 2995931) != 599186 || !composerStartRestartGroup.getSkipping()) {
            Object[] objArr = {function2, function4, function5, FabPosition.m1059boximpl(i), Boolean.valueOf(z), function6, function3};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i5 = 0; i5 < 7; i5++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i5]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1149invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1149invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int iM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(j);
                        final int iM3798getMaxHeightimpl = Constraints.m3798getMaxHeightimpl(j);
                        final long jM3790copyZbe2FdA$default = Constraints.m3790copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function7 = function2;
                        final Function2<Composer, Integer, Unit> function8 = function4;
                        final Function2<Composer, Integer, Unit> function9 = function5;
                        final int i6 = i;
                        final boolean z2 = z;
                        final Function2<Composer, Integer, Unit> function10 = function6;
                        final int i7 = i4;
                        final Function3<PaddingValues, Composer, Integer, Unit> function11 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, iM3799getMaxWidthimpl, iM3798getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                Object obj;
                                Object obj2;
                                final FabPlacement fabPlacement;
                                int i8;
                                Object obj3;
                                Integer numValueOf;
                                int iIntValue;
                                int height;
                                int i9;
                                int height2;
                                Object obj4;
                                Object obj5;
                                int i10;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function7);
                                long j2 = jM3790copyZbe2FdA$default;
                                ArrayList arrayList = new ArrayList(listSubcompose.size());
                                int size = listSubcompose.size();
                                for (int i11 = 0; i11 < size; i11++) {
                                    arrayList.add(listSubcompose.get(i11).mo3124measureBRTryo0(j2));
                                }
                                ArrayList arrayList2 = arrayList;
                                if (!arrayList2.isEmpty()) {
                                    obj = arrayList2.get(0);
                                    int height3 = ((Placeable) obj).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                    if (1 <= lastIndex) {
                                        int i12 = 1;
                                        while (true) {
                                            Object obj6 = arrayList2.get(i12);
                                            int height4 = ((Placeable) obj6).getHeight();
                                            if (height3 < height4) {
                                                obj = obj6;
                                                height3 = height4;
                                            }
                                            if (i12 == lastIndex) {
                                                break;
                                            } else {
                                                i12++;
                                            }
                                        }
                                    }
                                } else {
                                    obj = null;
                                }
                                Placeable placeable = (Placeable) obj;
                                int height5 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function8);
                                long j3 = jM3790copyZbe2FdA$default;
                                ArrayList arrayList3 = new ArrayList(listSubcompose2.size());
                                int size2 = listSubcompose2.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    arrayList3.add(listSubcompose2.get(i13).mo3124measureBRTryo0(j3));
                                }
                                ArrayList arrayList4 = arrayList3;
                                if (!arrayList4.isEmpty()) {
                                    obj2 = arrayList4.get(0);
                                    int height6 = ((Placeable) obj2).getHeight();
                                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
                                    if (1 <= lastIndex2) {
                                        int i14 = 1;
                                        while (true) {
                                            Object obj7 = arrayList4.get(i14);
                                            int height7 = ((Placeable) obj7).getHeight();
                                            if (height6 < height7) {
                                                obj2 = obj7;
                                                height6 = height7;
                                            }
                                            if (i14 == lastIndex2) {
                                                break;
                                            } else {
                                                i14++;
                                            }
                                        }
                                    }
                                } else {
                                    obj2 = null;
                                }
                                Placeable placeable2 = (Placeable) obj2;
                                int height8 = placeable2 != null ? placeable2.getHeight() : 0;
                                List<Measurable> listSubcompose3 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function9);
                                long j4 = jM3790copyZbe2FdA$default;
                                ArrayList arrayList5 = new ArrayList();
                                Iterator<T> it = listSubcompose3.iterator();
                                while (it.hasNext()) {
                                    Placeable placeableMo3124measureBRTryo0 = ((Measurable) it.next()).mo3124measureBRTryo0(j4);
                                    if (placeableMo3124measureBRTryo0.getHeight() == 0 || placeableMo3124measureBRTryo0.getWidth() == 0) {
                                        placeableMo3124measureBRTryo0 = null;
                                    }
                                    if (placeableMo3124measureBRTryo0 != null) {
                                        arrayList5.add(placeableMo3124measureBRTryo0);
                                    }
                                }
                                ArrayList arrayList6 = arrayList5;
                                if (arrayList6.isEmpty()) {
                                    fabPlacement = null;
                                } else {
                                    if (!arrayList6.isEmpty()) {
                                        obj4 = arrayList6.get(0);
                                        int width = ((Placeable) obj4).getWidth();
                                        int lastIndex3 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex3) {
                                            int i15 = 1;
                                            while (true) {
                                                Object obj8 = arrayList6.get(i15);
                                                int width2 = ((Placeable) obj8).getWidth();
                                                if (width < width2) {
                                                    obj4 = obj8;
                                                    width = width2;
                                                }
                                                if (i15 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i15++;
                                                }
                                            }
                                        }
                                    } else {
                                        obj4 = null;
                                    }
                                    Intrinsics.checkNotNull(obj4);
                                    int width3 = ((Placeable) obj4).getWidth();
                                    if (!arrayList6.isEmpty()) {
                                        obj5 = arrayList6.get(0);
                                        int height9 = ((Placeable) obj5).getHeight();
                                        int lastIndex4 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex4) {
                                            int i16 = 1;
                                            while (true) {
                                                Object obj9 = arrayList6.get(i16);
                                                int height10 = ((Placeable) obj9).getHeight();
                                                if (height9 < height10) {
                                                    height9 = height10;
                                                    obj5 = obj9;
                                                }
                                                if (i16 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i16++;
                                                }
                                            }
                                        }
                                    } else {
                                        obj5 = null;
                                    }
                                    Intrinsics.checkNotNull(obj5);
                                    int height11 = ((Placeable) obj5).getHeight();
                                    if (FabPosition.m1062equalsimpl0(i6, FabPosition.INSTANCE.m1067getEnd5ygKITE())) {
                                        i10 = SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (iM3799getMaxWidthimpl - SubcomposeLayout.mo312roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3 : SubcomposeLayout.mo312roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    } else {
                                        i10 = (iM3799getMaxWidthimpl - width3) / 2;
                                    }
                                    fabPlacement = new FabPlacement(z2, i10, width3, height11);
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function12 = function10;
                                final int i17 = i7;
                                List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.sourceInformation(composer2, "C285@12279L144:Scaffold.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(fabPlacement)}, function12, composer2, ((i17 >> 15) & 112) | 8);
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                }));
                                long j5 = jM3790copyZbe2FdA$default;
                                ArrayList arrayList7 = new ArrayList(listSubcompose4.size());
                                int size3 = listSubcompose4.size();
                                for (int i18 = 0; i18 < size3; i18++) {
                                    arrayList7.add(listSubcompose4.get(i18).mo3124measureBRTryo0(j5));
                                }
                                ArrayList arrayList8 = arrayList7;
                                if (!arrayList8.isEmpty()) {
                                    i8 = 0;
                                    obj3 = arrayList8.get(0);
                                    int height12 = ((Placeable) obj3).getHeight();
                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList8);
                                    if (1 <= lastIndex5) {
                                        int i19 = 1;
                                        while (true) {
                                            Object obj10 = arrayList8.get(i19);
                                            int height13 = ((Placeable) obj10).getHeight();
                                            if (height12 < height13) {
                                                obj3 = obj10;
                                                height12 = height13;
                                            }
                                            if (i19 == lastIndex5) {
                                                break;
                                            } else {
                                                i19++;
                                            }
                                        }
                                    }
                                } else {
                                    obj3 = null;
                                    i8 = 0;
                                }
                                Placeable placeable3 = (Placeable) obj3;
                                final int height14 = placeable3 != null ? placeable3.getHeight() : i8;
                                if (fabPlacement != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                    boolean z3 = z2;
                                    if (height14 != 0) {
                                        if (z3) {
                                            height2 = height14 + (fabPlacement.getHeight() / 2);
                                        } else {
                                            height = fabPlacement.getHeight() + height14;
                                            i9 = subcomposeMeasureScope2.mo312roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                        }
                                        numValueOf = Integer.valueOf(height2);
                                    } else {
                                        height = fabPlacement.getHeight();
                                        i9 = subcomposeMeasureScope2.mo312roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    }
                                    height2 = height + i9;
                                    numValueOf = Integer.valueOf(height2);
                                } else {
                                    numValueOf = null;
                                }
                                if (height8 != 0) {
                                    iIntValue = height8 + (numValueOf != null ? numValueOf.intValue() : height14);
                                } else {
                                    iIntValue = i8;
                                }
                                int i20 = iM3798getMaxHeightimpl - height5;
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeLayout;
                                final Function3<PaddingValues, Composer, Integer, Unit> function13 = function11;
                                final int i21 = i7;
                                List<Measurable> listSubcompose5 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i22) {
                                        ComposerKt.sourceInformation(composer2, "C317@13701L21:Scaffold.kt#jmzs0o");
                                        if ((i22 & 11) != 2 || !composer2.getSkipping()) {
                                            function13.invoke(PaddingKt.m420PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, subcomposeMeasureScope4.mo315toDpu2uoSUM(height14), 7, null), composer2, Integer.valueOf((i21 >> 6) & 112));
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                }));
                                long j6 = jM3790copyZbe2FdA$default;
                                ArrayList arrayList9 = new ArrayList(listSubcompose5.size());
                                int size4 = listSubcompose5.size();
                                int i22 = 0;
                                while (i22 < size4) {
                                    arrayList9.add(listSubcompose5.get(i22).mo3124measureBRTryo0(Constraints.m3790copyZbe2FdA$default(j6, 0, 0, 0, i20, 7, null)));
                                    i22++;
                                    listSubcompose5 = listSubcompose5;
                                    size4 = size4;
                                    j6 = j6;
                                }
                                ArrayList arrayList10 = arrayList9;
                                int i23 = 0;
                                for (int size5 = arrayList10.size(); i23 < size5; size5 = size5) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList10.get(i23), 0, height5, 0.0f, 4, null);
                                    i23++;
                                    height14 = height14;
                                }
                                int i24 = height14;
                                int size6 = arrayList2.size();
                                for (int i25 = 0; i25 < size6; i25++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList2.get(i25), 0, 0, 0.0f, 4, null);
                                }
                                int i26 = iM3798getMaxHeightimpl;
                                int size7 = arrayList4.size();
                                for (int i27 = 0; i27 < size7; i27++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList4.get(i27), 0, i26 - iIntValue, 0.0f, 4, null);
                                }
                                int i28 = iM3798getMaxHeightimpl;
                                int size8 = arrayList8.size();
                                for (int i29 = 0; i29 < size8; i29++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList8.get(i29), 0, i28 - i24, 0.0f, 4, null);
                                }
                                if (fabPlacement != null) {
                                    int i30 = iM3798getMaxHeightimpl;
                                    int size9 = arrayList6.size();
                                    for (int i31 = 0; i31 < size9; i31++) {
                                        Placeable placeable4 = (Placeable) arrayList6.get(i31);
                                        int left = fabPlacement.getLeft();
                                        Intrinsics.checkNotNull(numValueOf);
                                        Placeable.PlacementScope.place$default(layout, placeable4, left, i30 - numValueOf.intValue(), 0.0f, 4, null);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composerStartRestartGroup, 0, 1);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ScaffoldKt.m1147ScaffoldLayoutMDYNRJg(z, i, function2, function3, function4, function5, function6, composer2, i2 | 1);
            }
        });
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
