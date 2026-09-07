package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u00ad\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:105:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x0135  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:115:0x015f  */
    /* JADX WARN: Code duplicated, block: B:117:0x016c  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:138:0x01af  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:149:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:160:0x021f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0293  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:59:0x00af  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00df  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0105  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m882AlertDialog6oU6zVQ(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i9;
        Shape shape2;
        long jM997contentColorForek8zF_U;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        CornerBasedShape medium;
        long jM983getSurface0d7_KjU;
        DialogProperties dialogProperties2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        long j3;
        Shape shape3;
        long j4;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Shape shape4;
        final long j5;
        final long j6;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(onDismissRequest) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(confirmButton) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
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
                        if (composerStartRestartGroup.changed(function3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((i & 458752) == 0) {
                            function5 = function4;
                            if (composerStartRestartGroup.changed(function5)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((i & 3670016) == 0) {
                            shape2 = shape;
                            if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(shape2)) {
                                i11 = 524288;
                            } else {
                                i11 = 1048576;
                            }
                            i3 |= i11;
                        } else {
                            shape2 = shape;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                        }
                        if ((i & 234881024) == 0) {
                            jM997contentColorForek8zF_U = j2;
                            if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(jM997contentColorForek8zF_U)) {
                                i10 = 33554432;
                            } else {
                                i10 = 67108864;
                            }
                            i3 |= i10;
                        } else {
                            jM997contentColorForek8zF_U = j2;
                        }
                        if ((1879048192 & i) != 0) {
                            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                        }
                        if ((i3 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                } else {
                                    function6 = function2;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                } else {
                                    function7 = function3;
                                }
                                function8 = i8 == 0 ? function5 : null;
                                if ((i2 & 64) != 0) {
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                    i3 &= -3670017;
                                } else {
                                    medium = shape2;
                                }
                                if ((i2 & 128) != 0) {
                                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                    i3 &= -29360129;
                                } else {
                                    jM983getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                    i3 &= -234881025;
                                }
                                if ((i2 & 512) != 0) {
                                    i3 &= -1879048193;
                                    dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                                } else {
                                    dialogProperties2 = dialogProperties;
                                }
                                function9 = function7;
                                j3 = jM997contentColorForek8zF_U;
                                shape3 = medium;
                                j4 = jM983getSurface0d7_KjU;
                                function10 = function6;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                }
                                if ((i2 & 512) != 0) {
                                    i3 &= -1879048193;
                                }
                                companion = modifier;
                                function9 = function3;
                                j4 = j;
                                dialogProperties2 = dialogProperties;
                                j3 = jM997contentColorForek8zF_U;
                                shape3 = shape2;
                                function8 = function5;
                                function10 = function2;
                            }
                            composerStartRestartGroup.endDefaults();
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i13 & 11) != 2 || !composer2.getSkipping()) {
                                        float f = 8;
                                        Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                        final Function2<Composer, Integer, Unit> function14 = function10;
                                        final int i14 = i3;
                                        final Function2<Composer, Integer, Unit> function15 = confirmButton;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        composer2.enableReusing();
                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        composer2.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer2.startReplaceableGroup(-434861445);
                                        ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                        AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                                ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                                if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                                    Function2<Composer, Integer, Unit> function16 = function14;
                                                    composer3.startReplaceableGroup(-1046483318);
                                                    ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                    if (function16 != null) {
                                                        function16.invoke(composer3, Integer.valueOf((i14 >> 9) & 14));
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    function15.invoke(composer3, Integer.valueOf((i14 >> 3) & 14));
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, 438);
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
                            int i13 = (i3 & 14) | 48 | (i3 & 896);
                            int i14 = i3 >> 3;
                            m883AlertDialogwqdebIU(onDismissRequest, composableLambda, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i13 | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024), 0);
                            function11 = function10;
                            modifier2 = companion;
                            function12 = function9;
                            function13 = function8;
                            shape4 = shape3;
                            j5 = j4;
                            j6 = j3;
                            dialogProperties3 = dialogProperties2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function11 = function2;
                            function12 = function3;
                            dialogProperties3 = dialogProperties;
                            long j7 = jM997contentColorForek8zF_U;
                            shape4 = shape2;
                            j5 = j;
                            function13 = function5;
                            j6 = j7;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                            }
                        });
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function4;
                    if ((i & 3670016) == 0) {
                        shape2 = shape;
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                    }
                    if ((i & 234881024) == 0) {
                        jM997contentColorForek8zF_U = j2;
                        if ((i2 & 256) == 0) {
                            i10 = 33554432;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((1879048192 & i) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i16 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i17 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i16 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i16 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i15 = (i3 & 14) | 48 | (i3 & 896);
                        int i16 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda2, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i15 | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i18 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i18 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i18 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i17 = (i3 & 14) | 48 | (i3 & 896);
                        int i18 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda3, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i17 | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((i & 458752) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changed(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) == 0) {
                        shape2 = shape;
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                    }
                    if ((i & 234881024) == 0) {
                        jM997contentColorForek8zF_U = j2;
                        if ((i2 & 256) == 0) {
                            i10 = 33554432;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((1879048192 & i) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i110 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i111 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i110 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i110 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i19 = (i3 & 14) | 48 | (i3 & 896);
                        int i110 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda4, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i19 | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (i110 & 3670016) | (i110 & 29360128) | (i110 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i112 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i113 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i112 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i112 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i111 = (i3 & 14) | 48 | (i3 & 896);
                        int i112 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda5, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111 | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (i112 & 3670016) | (i112 & 29360128) | (i112 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function4;
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i114 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i115 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i114 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i114 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i113 = (i3 & 14) | 48 | (i3 & 896);
                    int i114 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda6, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i113 | (i114 & 7168) | (57344 & i114) | (458752 & i114) | (i114 & 3670016) | (i114 & 29360128) | (i114 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i116 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i117 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i116 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i116 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i115 = (i3 & 14) | 48 | (i3 & 896);
                    int i116 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda7, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i115 | (i116 & 7168) | (57344 & i116) | (458752 & i116) | (i116 & 3670016) | (i116 & 29360128) | (i116 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((i & 458752) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changed(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) == 0) {
                        shape2 = shape;
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                    }
                    if ((i & 234881024) == 0) {
                        jM997contentColorForek8zF_U = j2;
                        if ((i2 & 256) == 0) {
                            i10 = 33554432;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((1879048192 & i) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i118 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i119 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i118 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i118 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i117 = (i3 & 14) | 48 | (i3 & 896);
                        int i118 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda8, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i117 | (i118 & 7168) | (57344 & i118) | (458752 & i118) | (i118 & 3670016) | (i118 & 29360128) | (i118 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i119 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i1110 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i1111 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i1110 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i1110 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i119 = (i3 & 14) | 48 | (i3 & 896);
                        int i1110 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda9, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i119 | (i1110 & 7168) | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016) | (i1110 & 29360128) | (i1110 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function4;
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i1111 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1112 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1113 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1112 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1112 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i1111 = (i3 & 14) | 48 | (i3 & 896);
                    int i1112 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda10, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111 | (i1112 & 7168) | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016) | (i1112 & 29360128) | (i1112 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i1113 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1114 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1115 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1114 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1114 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i1113 = (i3 & 14) | 48 | (i3 & 896);
                    int i1114 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda11, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1113 | (i1114 & 7168) | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016) | (i1114 & 29360128) | (i1114 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((i & 458752) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changed(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i1115 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1116 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1117 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1116 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1116 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i1115 = (i3 & 14) | 48 | (i3 & 896);
                    int i1116 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda12, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1115 | (i1116 & 7168) | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016) | (i1116 & 29360128) | (i1116 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i1117 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1118 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1119 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1118 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1118 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i1117 = (i3 & 14) | 48 | (i3 & 896);
                    int i1118 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda13, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1117 | (i1118 & 7168) | (57344 & i1118) | (458752 & i1118) | (i1118 & 3670016) | (i1118 & 29360128) | (i1118 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function4;
            if ((i & 3670016) == 0) {
                shape2 = shape;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
            }
            if ((i & 234881024) == 0) {
                jM997contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            if ((1879048192 & i) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i1119 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i11110 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i11111 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i11110 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i11110 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i1119 = (i3 & 14) | 48 | (i3 & 896);
                int i11110 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda14, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1119 | (i11110 & 7168) | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016) | (i11110 & 29360128) | (i11110 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i11111 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i11112 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i11113 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i11112 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i11112 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i11111 = (i3 & 14) | 48 | (i3 & 896);
                int i11112 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda15, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11111 | (i11112 & 7168) | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016) | (i11112 & 29360128) | (i11112 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
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
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((i & 458752) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changed(function5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 3670016) == 0) {
                        shape2 = shape;
                        if ((i2 & 64) == 0) {
                            i11 = 524288;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                    }
                    if ((i & 234881024) == 0) {
                        jM997contentColorForek8zF_U = j2;
                        if ((i2 & 256) == 0) {
                            i10 = 33554432;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    } else {
                        jM997contentColorForek8zF_U = j2;
                    }
                    if ((1879048192 & i) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                    }
                    if ((i3 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i11113 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i11114 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                        public final void invoke(Composer composer3, int i11115) {
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i11115 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i11114 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i11114 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i11113 = (i3 & 14) | 48 | (i3 & 896);
                        int i11114 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda16, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11113 | (i11114 & 7168) | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016) | (i11114 & 29360128) | (i11114 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function2;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if (i8 == 0) {
                            }
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -29360129;
                            } else {
                                jM983getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                                i3 &= -234881025;
                            }
                            if ((i2 & 512) != 0) {
                                i3 &= -1879048193;
                                dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            function9 = function7;
                            j3 = jM997contentColorForek8zF_U;
                            shape3 = medium;
                            j4 = jM983getSurface0d7_KjU;
                            function10 = function6;
                        }
                        composerStartRestartGroup.endDefaults();
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i11115 & 11) != 2 || !composer2.getSkipping()) {
                                    float f = 8;
                                    Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                    final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                    final int i11116 = i3;
                                    final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    composer2.enableReusing();
                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-434861445);
                                    ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                    AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                        public final void invoke(Composer composer3, int i11117) {
                                            ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i11117 & 11) != 2 || !composer3.getSkipping()) {
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                composer3.startReplaceableGroup(-1046483318);
                                                ComposerKt.sourceInformation(composer3, "84@4101L8");
                                                if (function16 != null) {
                                                    function16.invoke(composer3, Integer.valueOf((i11116 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer3.endReplaceableGroup();
                                                function15.invoke(composer3, Integer.valueOf((i11116 >> 3) & 14));
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 438);
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
                        int i11115 = (i3 & 14) | 48 | (i3 & 896);
                        int i11116 = i3 >> 3;
                        m883AlertDialogwqdebIU(onDismissRequest, composableLambda17, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11115 | (i11116 & 7168) | (57344 & i11116) | (458752 & i11116) | (i11116 & 3670016) | (i11116 & 29360128) | (i11116 & 234881024), 0);
                        function11 = function10;
                        modifier2 = companion;
                        function12 = function9;
                        function13 = function8;
                        shape4 = shape3;
                        j5 = j4;
                        j6 = j3;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11117) {
                            AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function4;
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda18 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11117) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i11117 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i11118 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i11119) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i11119 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i11118 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i11118 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i11117 = (i3 & 14) | 48 | (i3 & 896);
                    int i11118 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda18, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11117 | (i11118 & 7168) | (57344 & i11118) | (458752 & i11118) | (i11118 & 3670016) | (i11118 & 29360128) | (i11118 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11119) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i11119 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i111110 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i111111) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i111111 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i111110 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i111110 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i11119 = (i3 & 14) | 48 | (i3 & 896);
                    int i111110 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda19, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11119 | (i111110 & 7168) | (57344 & i111110) | (458752 & i111110) | (i111110 & 3670016) | (i111110 & 29360128) | (i111110 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111111) {
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((i & 458752) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changed(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111111) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i111111 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i111112 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i111113) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i111113 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i111112 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i111112 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i111111 = (i3 & 14) | 48 | (i3 & 896);
                    int i111112 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda110, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111111 | (i111112 & 7168) | (57344 & i111112) | (458752 & i111112) | (i111112 & 3670016) | (i111112 & 29360128) | (i111112 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111113) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i111113 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i111114 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i111115) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i111115 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i111114 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i111114 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i111113 = (i3 & 14) | 48 | (i3 & 896);
                    int i111114 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda111, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111113 | (i111114 & 7168) | (57344 & i111114) | (458752 & i111114) | (i111114 & 3670016) | (i111114 & 29360128) | (i111114 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111115) {
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function4;
            if ((i & 3670016) == 0) {
                shape2 = shape;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
            }
            if ((i & 234881024) == 0) {
                jM997contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            if ((1879048192 & i) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111115) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i111115 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i111116 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i111117) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i111117 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i111116 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i111116 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i111115 = (i3 & 14) | 48 | (i3 & 896);
                int i111116 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda112, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111115 | (i111116 & 7168) | (57344 & i111116) | (458752 & i111116) | (i111116 & 3670016) | (i111116 & 29360128) | (i111116 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111117) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i111117 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i111118 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i111119) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i111119 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i111118 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i111118 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i111117 = (i3 & 14) | 48 | (i3 & 896);
                int i111118 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda113, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111117 | (i111118 & 7168) | (57344 & i111118) | (458752 & i111118) | (i111118 & 3670016) | (i111118 & 29360128) | (i111118 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i111119) {
                    AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((i & 458752) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changed(function5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 3670016) == 0) {
                    shape2 = shape;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
                }
                if ((i & 234881024) == 0) {
                    jM997contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i10 = 33554432;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                } else {
                    jM997contentColorForek8zF_U = j2;
                }
                if ((1879048192 & i) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i111119) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i111119 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1111110 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i1111111) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1111111 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1111110 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1111110 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i111119 = (i3 & 14) | 48 | (i3 & 896);
                    int i1111110 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda114, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i111119 | (i1111110 & 7168) | (57344 & i1111110) | (458752 & i1111110) | (i1111110 & 3670016) | (i1111110 & 29360128) | (i1111110 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -29360129;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -234881025;
                        }
                        if ((i2 & 512) != 0) {
                            i3 &= -1879048193;
                            dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        function9 = function7;
                        j3 = jM997contentColorForek8zF_U;
                        shape3 = medium;
                        j4 = jM983getSurface0d7_KjU;
                        function10 = function6;
                    }
                    composerStartRestartGroup.endDefaults();
                    ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111111) {
                            ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i1111111 & 11) != 2 || !composer2.getSkipping()) {
                                float f = 8;
                                Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                                final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                                final int i1111112 = i3;
                                final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                composer2.enableReusing();
                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(-434861445);
                                ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                    public final void invoke(Composer composer3, int i1111113) {
                                        ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                        if ((i1111113 & 11) != 2 || !composer3.getSkipping()) {
                                            Function2<Composer, Integer, Unit> function16 = function14;
                                            composer3.startReplaceableGroup(-1046483318);
                                            ComposerKt.sourceInformation(composer3, "84@4101L8");
                                            if (function16 != null) {
                                                function16.invoke(composer3, Integer.valueOf((i1111112 >> 9) & 14));
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            function15.invoke(composer3, Integer.valueOf((i1111112 >> 3) & 14));
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 438);
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
                    int i1111111 = (i3 & 14) | 48 | (i3 & 896);
                    int i1111112 = i3 >> 3;
                    m883AlertDialogwqdebIU(onDismissRequest, composableLambda115, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111111 | (i1111112 & 7168) | (57344 & i1111112) | (458752 & i1111112) | (i1111112 & 3670016) | (i1111112 & 29360128) | (i1111112 & 234881024), 0);
                    function11 = function10;
                    modifier2 = companion;
                    function12 = function9;
                    function13 = function8;
                    shape4 = shape3;
                    j5 = j4;
                    j6 = j3;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111113) {
                        AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function4;
            if ((i & 3670016) == 0) {
                shape2 = shape;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
            }
            if ((i & 234881024) == 0) {
                jM997contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            if ((1879048192 & i) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111113) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i1111113 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i1111114 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i1111115) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i1111115 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i1111114 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i1111114 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i1111113 = (i3 & 14) | 48 | (i3 & 896);
                int i1111114 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda116, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111113 | (i1111114 & 7168) | (57344 & i1111114) | (458752 & i1111114) | (i1111114 & 3670016) | (i1111114 & 29360128) | (i1111114 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111115) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i1111115 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i1111116 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i1111117) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i1111117 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i1111116 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i1111116 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i1111115 = (i3 & 14) | 48 | (i3 & 896);
                int i1111116 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda117, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111115 | (i1111116 & 7168) | (57344 & i1111116) | (458752 & i1111116) | (i1111116 & 3670016) | (i1111116 & 29360128) | (i1111116 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i1111117) {
                    AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((i & 458752) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changed(function5)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i & 3670016) == 0) {
                shape2 = shape;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
            }
            if ((i & 234881024) == 0) {
                jM997contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            } else {
                jM997contentColorForek8zF_U = j2;
            }
            if ((1879048192 & i) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111117) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i1111117 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i1111118 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i1111119) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i1111119 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i1111118 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i1111118 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i1111117 = (i3 & 14) | 48 | (i3 & 896);
                int i1111118 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda118, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111117 | (i1111118 & 7168) | (57344 & i1111118) | (458752 & i1111118) | (i1111118 & 3670016) | (i1111118 & 29360128) | (i1111118 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -29360129;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function7;
                    j3 = jM997contentColorForek8zF_U;
                    shape3 = medium;
                    j4 = jM983getSurface0d7_KjU;
                    function10 = function6;
                }
                composerStartRestartGroup.endDefaults();
                ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111119) {
                        ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i1111119 & 11) != 2 || !composer2.getSkipping()) {
                            float f = 8;
                            Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final int i11111110 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-434861445);
                            ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                            AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                public final void invoke(Composer composer3, int i11111111) {
                                    ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i11111111 & 11) != 2 || !composer3.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function16 = function14;
                                        composer3.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation(composer3, "84@4101L8");
                                        if (function16 != null) {
                                            function16.invoke(composer3, Integer.valueOf((i11111110 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceableGroup();
                                        function15.invoke(composer3, Integer.valueOf((i11111110 >> 3) & 14));
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 438);
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
                int i1111119 = (i3 & 14) | 48 | (i3 & 896);
                int i11111110 = i3 >> 3;
                m883AlertDialogwqdebIU(onDismissRequest, composableLambda119, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i1111119 | (i11111110 & 7168) | (57344 & i11111110) | (458752 & i11111110) | (i11111110 & 3670016) | (i11111110 & 29360128) | (i11111110 & 234881024), 0);
                function11 = function10;
                modifier2 = companion;
                function12 = function9;
                function13 = function8;
                shape4 = shape3;
                j5 = j4;
                j6 = j3;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111111) {
                    AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function4;
        if ((i & 3670016) == 0) {
            shape2 = shape;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        } else {
            shape2 = shape;
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) ? 4194304 : 8388608;
        }
        if ((i & 234881024) == 0) {
            jM997contentColorForek8zF_U = j2;
            if ((i2 & 256) == 0) {
                i10 = 33554432;
            } else {
                i10 = 33554432;
            }
            i3 |= i10;
        } else {
            jM997contentColorForek8zF_U = j2;
        }
        if ((1879048192 & i) != 0) {
            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(dialogProperties)) ? 268435456 : 536870912;
        }
        if ((i3 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i6 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape2;
                }
                if ((i2 & 128) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -29360129;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                function9 = function7;
                j3 = jM997contentColorForek8zF_U;
                shape3 = medium;
                j4 = jM983getSurface0d7_KjU;
                function10 = function6;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i6 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape2;
                }
                if ((i2 & 128) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -29360129;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                function9 = function7;
                j3 = jM997contentColorForek8zF_U;
                shape3 = medium;
                j4 = jM983getSurface0d7_KjU;
                function10 = function6;
            }
            composerStartRestartGroup.endDefaults();
            ComposableLambda composableLambda1110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111111) {
                    ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if ((i11111111 & 11) != 2 || !composer2.getSkipping()) {
                        float f = 8;
                        Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                        final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                        final int i11111112 = i3;
                        final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-434861445);
                        ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                        AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                            public final void invoke(Composer composer3, int i11111113) {
                                ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i11111113 & 11) != 2 || !composer3.getSkipping()) {
                                    Function2<Composer, Integer, Unit> function16 = function14;
                                    composer3.startReplaceableGroup(-1046483318);
                                    ComposerKt.sourceInformation(composer3, "84@4101L8");
                                    if (function16 != null) {
                                        function16.invoke(composer3, Integer.valueOf((i11111112 >> 9) & 14));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer3.endReplaceableGroup();
                                    function15.invoke(composer3, Integer.valueOf((i11111112 >> 3) & 14));
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 438);
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
            int i11111111 = (i3 & 14) | 48 | (i3 & 896);
            int i11111112 = i3 >> 3;
            m883AlertDialogwqdebIU(onDismissRequest, composableLambda1110, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11111111 | (i11111112 & 7168) | (57344 & i11111112) | (458752 & i11111112) | (i11111112 & 3670016) | (i11111112 & 29360128) | (i11111112 & 234881024), 0);
            function11 = function10;
            modifier2 = companion;
            function12 = function9;
            function13 = function8;
            shape4 = shape3;
            j5 = j4;
            j6 = j3;
            dialogProperties3 = dialogProperties2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i6 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape2;
                }
                if ((i2 & 128) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -29360129;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                function9 = function7;
                j3 = jM997contentColorForek8zF_U;
                shape3 = medium;
                j4 = jM983getSurface0d7_KjU;
                function10 = function6;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i6 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape2;
                }
                if ((i2 & 128) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -29360129;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    dialogProperties2 = new DialogProperties(false, false, null, 7, null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                function9 = function7;
                j3 = jM997contentColorForek8zF_U;
                shape3 = medium;
                j4 = jM983getSurface0d7_KjU;
                function10 = function6;
            }
            composerStartRestartGroup.endDefaults();
            ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111113) {
                    ComposerKt.sourceInformation(composer2, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if ((i11111113 & 11) != 2 || !composer2.getSkipping()) {
                        float f = 8;
                        Modifier modifierM424paddingVpY3zN4 = PaddingKt.m424paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(2));
                        final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                        final int i11111114 = i3;
                        final Function2<? super Composer, ? super Integer, Unit> function15 = confirmButton;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM424paddingVpY3zN4);
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
                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-434861445);
                        ComposerKt.sourceInformation(composer2, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                        AlertDialogKt.m881AlertDialogFlowRowixp7dh8(Dp.m3843constructorimpl(f), Dp.m3843constructorimpl(12), ComposableLambdaKt.composableLambda(composer2, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                            public final void invoke(Composer composer3, int i11111115) {
                                ComposerKt.sourceInformation(composer3, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i11111115 & 11) != 2 || !composer3.getSkipping()) {
                                    Function2<Composer, Integer, Unit> function16 = function14;
                                    composer3.startReplaceableGroup(-1046483318);
                                    ComposerKt.sourceInformation(composer3, "84@4101L8");
                                    if (function16 != null) {
                                        function16.invoke(composer3, Integer.valueOf((i11111114 >> 9) & 14));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer3.endReplaceableGroup();
                                    function15.invoke(composer3, Integer.valueOf((i11111114 >> 3) & 14));
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 438);
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
            int i11111113 = (i3 & 14) | 48 | (i3 & 896);
            int i11111114 = i3 >> 3;
            m883AlertDialogwqdebIU(onDismissRequest, composableLambda1111, companion, function9, function8, shape3, j4, j3, dialogProperties2, composerStartRestartGroup, i11111113 | (i11111114 & 7168) | (57344 & i11111114) | (458752 & i11111114) | (i11111114 & 3670016) | (i11111114 & 29360128) | (i11111114 & 234881024), 0);
            function11 = function10;
            modifier2 = companion;
            function12 = function9;
            function13 = function8;
            shape4 = shape3;
            j5 = j4;
            j6 = j3;
            dialogProperties3 = dialogProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i11111115) {
                AndroidAlertDialog_androidKt.m882AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier2, function11, function12, function13, shape4, j5, j6, dialogProperties3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0149  */
    /* JADX WARN: Code duplicated, block: B:124:0x017c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x017e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0183  */
    /* JADX WARN: Code duplicated, block: B:129:0x0188  */
    /* JADX WARN: Code duplicated, block: B:132:0x018c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0193  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:152:0x0251  */
    /* JADX WARN: Code duplicated, block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:94:0x0107  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0111  */
    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m883AlertDialogwqdebIU(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i5;
        int i6;
        int i7;
        long jM983getSurface0d7_KjU;
        long j3;
        DialogProperties dialogProperties2;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function5;
        CornerBasedShape medium;
        long jM997contentColorForek8zF_U;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Shape shape2;
        Function2<? super Composer, ? super Integer, Unit> function7;
        long j4;
        DialogProperties dialogProperties3;
        long j5;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final Shape shape3;
        final long j6;
        final long j7;
        final DialogProperties dialogProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(onDismissRequest) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(buttons) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changed(function4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changed(function3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) != 0) {
                        i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            jM983getSurface0d7_KjU = j;
                            int i11 = composerStartRestartGroup.changed(jM983getSurface0d7_KjU) ? 1048576 : 524288;
                            i3 |= i11;
                        } else {
                            jM983getSurface0d7_KjU = j;
                        }
                        i3 |= i11;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    if ((29360128 & i) == 0) {
                        j3 = j2;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i9 = 4194304;
                        } else {
                            i9 = 8388608;
                        }
                        i3 |= i9;
                    } else {
                        j3 = j2;
                    }
                    if ((234881024 & i) == 0) {
                        if ((i2 & 256) == 0) {
                            dialogProperties2 = dialogProperties;
                            int i12 = composerStartRestartGroup.changed(dialogProperties2) ? 67108864 : 33554432;
                            i3 |= i12;
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        i3 |= i12;
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    if ((i3 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
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
                            companion = modifier;
                            function6 = function3;
                            shape2 = shape;
                            i8 = i3;
                            function7 = function4;
                            j4 = j3;
                        } else {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            function5 = i6 == 0 ? function3 : null;
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape;
                            }
                            if ((i2 & 64) != 0) {
                                jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM997contentColorForek8zF_U = j3;
                            }
                            if ((i2 & 256) != 0) {
                                i8 = i3 & (-234881025);
                                function6 = function5;
                                shape2 = medium;
                                function7 = function4;
                                j4 = jM997contentColorForek8zF_U;
                                dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                                j5 = jM983getSurface0d7_KjU;
                            } else {
                                i8 = i3;
                                function6 = function5;
                                shape2 = medium;
                                function7 = function4;
                                j4 = jM997contentColorForek8zF_U;
                            }
                            composerStartRestartGroup.endDefaults();
                            final Modifier modifier3 = companion;
                            final Function2<? super Composer, ? super Integer, Unit> function10 = function7;
                            final Function2<? super Composer, ? super Integer, Unit> function11 = function6;
                            final Shape shape4 = shape2;
                            final long j8 = j5;
                            final long j9 = j4;
                            final int i13 = i8;
                            AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer2.getSkipping()) {
                                        Function2<Composer, Integer, Unit> function12 = buttons;
                                        Modifier modifier4 = modifier3;
                                        Function2<Composer, Integer, Unit> function13 = function10;
                                        Function2<Composer, Integer, Unit> function14 = function11;
                                        Shape shape5 = shape4;
                                        long j10 = j8;
                                        long j11 = j9;
                                        int i15 = i13;
                                        AlertDialogKt.m880AlertDialogContentWMdw5o4(function12, modifier4, function13, function14, shape5, j10, j11, composer2, ((i15 >> 3) & 14) | ((i15 >> 3) & 112) | ((i15 >> 3) & 896) | ((i15 >> 3) & 7168) | ((i15 >> 3) & 57344) | ((i15 >> 3) & 458752) | ((i15 >> 3) & 3670016), 0);
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                            modifier2 = companion;
                            function8 = function7;
                            function9 = function6;
                            shape3 = shape2;
                            j6 = j5;
                            j7 = j4;
                            dialogProperties4 = dialogProperties3;
                        }
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                        composerStartRestartGroup.endDefaults();
                        final Modifier modifier4 = companion;
                        final Function2<? super Composer, ? super Integer, Unit> function12 = function7;
                        final Function2<? super Composer, ? super Integer, Unit> function13 = function6;
                        final Shape shape5 = shape2;
                        final long j10 = j5;
                        final long j11 = j4;
                        final int i14 = i8;
                        AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    Function2<Composer, Integer, Unit> function14 = buttons;
                                    Modifier modifier5 = modifier4;
                                    Function2<Composer, Integer, Unit> function15 = function12;
                                    Function2<Composer, Integer, Unit> function16 = function13;
                                    Shape shape6 = shape5;
                                    long j12 = j10;
                                    long j13 = j11;
                                    int i16 = i14;
                                    AlertDialogKt.m880AlertDialogContentWMdw5o4(function14, modifier5, function15, function16, shape6, j12, j13, composer2, ((i16 >> 3) & 14) | ((i16 >> 3) & 112) | ((i16 >> 3) & 896) | ((i16 >> 3) & 7168) | ((i16 >> 3) & 57344) | ((i16 >> 3) & 458752) | ((i16 >> 3) & 3670016), 0);
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                        modifier2 = companion;
                        function8 = function7;
                        function9 = function6;
                        shape3 = shape2;
                        j6 = j5;
                        j7 = j4;
                        dialogProperties4 = dialogProperties3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function9 = function3;
                        function8 = function4;
                        shape3 = shape;
                        dialogProperties4 = dialogProperties2;
                        j7 = j3;
                        j6 = jM983getSurface0d7_KjU;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                if ((458752 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM983getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                        }
                        i3 |= i11;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((29360128 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                } else {
                    j3 = j2;
                }
                if ((234881024 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        dialogProperties2 = dialogProperties;
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                        }
                        i3 |= i12;
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier5 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function14 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function15 = function6;
                    final Shape shape6 = shape2;
                    final long j12 = j5;
                    final long j13 = j4;
                    final int i15 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function16 = buttons;
                                Modifier modifier6 = modifier5;
                                Function2<Composer, Integer, Unit> function17 = function14;
                                Function2<Composer, Integer, Unit> function18 = function15;
                                Shape shape7 = shape6;
                                long j14 = j12;
                                long j15 = j13;
                                int i17 = i15;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function16, modifier6, function17, function18, shape7, j14, j15, composer2, ((i17 >> 3) & 14) | ((i17 >> 3) & 112) | ((i17 >> 3) & 896) | ((i17 >> 3) & 7168) | ((i17 >> 3) & 57344) | ((i17 >> 3) & 458752) | ((i17 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier6 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function16 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function17 = function6;
                    final Shape shape7 = shape2;
                    final long j14 = j5;
                    final long j15 = j4;
                    final int i16 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function18 = buttons;
                                Modifier modifier7 = modifier6;
                                Function2<Composer, Integer, Unit> function19 = function16;
                                Function2<Composer, Integer, Unit> function110 = function17;
                                Shape shape8 = shape7;
                                long j16 = j14;
                                long j17 = j15;
                                int i18 = i16;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function18, modifier7, function19, function110, shape8, j16, j17, composer2, ((i18 >> 3) & 14) | ((i18 >> 3) & 112) | ((i18 >> 3) & 896) | ((i18 >> 3) & 7168) | ((i18 >> 3) & 57344) | ((i18 >> 3) & 458752) | ((i18 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function4 = function2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM983getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                        }
                        i3 |= i11;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((29360128 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                } else {
                    j3 = j2;
                }
                if ((234881024 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        dialogProperties2 = dialogProperties;
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                        }
                        i3 |= i12;
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier7 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function18 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function19 = function6;
                    final Shape shape8 = shape2;
                    final long j16 = j5;
                    final long j17 = j4;
                    final int i17 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i18 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function110 = buttons;
                                Modifier modifier8 = modifier7;
                                Function2<Composer, Integer, Unit> function111 = function18;
                                Function2<Composer, Integer, Unit> function112 = function19;
                                Shape shape9 = shape8;
                                long j18 = j16;
                                long j19 = j17;
                                int i19 = i17;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function110, modifier8, function111, function112, shape9, j18, j19, composer2, ((i19 >> 3) & 14) | ((i19 >> 3) & 112) | ((i19 >> 3) & 896) | ((i19 >> 3) & 7168) | ((i19 >> 3) & 57344) | ((i19 >> 3) & 458752) | ((i19 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier8 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function110 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function111 = function6;
                    final Shape shape9 = shape2;
                    final long j18 = j5;
                    final long j19 = j4;
                    final int i18 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i19 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function112 = buttons;
                                Modifier modifier9 = modifier8;
                                Function2<Composer, Integer, Unit> function113 = function110;
                                Function2<Composer, Integer, Unit> function114 = function111;
                                Shape shape10 = shape9;
                                long j110 = j18;
                                long j111 = j19;
                                int i110 = i18;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function112, modifier9, function113, function114, shape10, j110, j111, composer2, ((i110 >> 3) & 14) | ((i110 >> 3) & 112) | ((i110 >> 3) & 896) | ((i110 >> 3) & 7168) | ((i110 >> 3) & 57344) | ((i110 >> 3) & 458752) | ((i110 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            if ((458752 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM983getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j;
            }
            if ((29360128 & i) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            } else {
                j3 = j2;
            }
            if ((234881024 & i) == 0) {
                if ((i2 & 256) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                i3 |= i12;
            } else {
                dialogProperties2 = dialogProperties;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier9 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function112 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function113 = function6;
                final Shape shape10 = shape2;
                final long j110 = j5;
                final long j111 = j4;
                final int i19 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i110 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function114 = buttons;
                            Modifier modifier10 = modifier9;
                            Function2<Composer, Integer, Unit> function115 = function112;
                            Function2<Composer, Integer, Unit> function116 = function113;
                            Shape shape11 = shape10;
                            long j112 = j110;
                            long j113 = j111;
                            int i111 = i19;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function114, modifier10, function115, function116, shape11, j112, j113, composer2, ((i111 >> 3) & 14) | ((i111 >> 3) & 112) | ((i111 >> 3) & 896) | ((i111 >> 3) & 7168) | ((i111 >> 3) & 57344) | ((i111 >> 3) & 458752) | ((i111 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier10 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function114 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function115 = function6;
                final Shape shape11 = shape2;
                final long j112 = j5;
                final long j113 = j4;
                final int i110 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i111 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function116 = buttons;
                            Modifier modifier11 = modifier10;
                            Function2<Composer, Integer, Unit> function117 = function114;
                            Function2<Composer, Integer, Unit> function118 = function115;
                            Shape shape12 = shape11;
                            long j114 = j112;
                            long j115 = j113;
                            int i112 = i110;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function116, modifier11, function117, function118, shape12, j114, j115, composer2, ((i112 >> 3) & 14) | ((i112 >> 3) & 112) | ((i112 >> 3) & 896) | ((i112 >> 3) & 7168) | ((i112 >> 3) & 57344) | ((i112 >> 3) & 458752) | ((i112 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changed(function4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM983getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                        }
                        i3 |= i11;
                    } else {
                        jM983getSurface0d7_KjU = j;
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                if ((29360128 & i) == 0) {
                    j3 = j2;
                    if ((i2 & 128) == 0) {
                        i9 = 4194304;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                } else {
                    j3 = j2;
                }
                if ((234881024 & i) == 0) {
                    if ((i2 & 256) == 0) {
                        dialogProperties2 = dialogProperties;
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                        }
                        i3 |= i12;
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier11 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function116 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function117 = function6;
                    final Shape shape12 = shape2;
                    final long j114 = j5;
                    final long j115 = j4;
                    final int i111 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i112 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function118 = buttons;
                                Modifier modifier12 = modifier11;
                                Function2<Composer, Integer, Unit> function119 = function116;
                                Function2<Composer, Integer, Unit> function1110 = function117;
                                Shape shape13 = shape12;
                                long j116 = j114;
                                long j117 = j115;
                                int i113 = i111;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function118, modifier12, function119, function1110, shape13, j116, j117, composer2, ((i113 >> 3) & 14) | ((i113 >> 3) & 112) | ((i113 >> 3) & 896) | ((i113 >> 3) & 7168) | ((i113 >> 3) & 57344) | ((i113 >> 3) & 458752) | ((i113 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 64) != 0) {
                            jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM997contentColorForek8zF_U = j3;
                        }
                        if ((i2 & 256) != 0) {
                            i8 = i3 & (-234881025);
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                            j5 = jM983getSurface0d7_KjU;
                        } else {
                            i8 = i3;
                            function6 = function5;
                            shape2 = medium;
                            function7 = function4;
                            j4 = jM997contentColorForek8zF_U;
                            j5 = jM983getSurface0d7_KjU;
                            dialogProperties3 = dialogProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    final Modifier modifier12 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function118 = function7;
                    final Function2<? super Composer, ? super Integer, Unit> function119 = function6;
                    final Shape shape13 = shape2;
                    final long j116 = j5;
                    final long j117 = j4;
                    final int i112 = i8;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i113 & 11) != 2 || !composer2.getSkipping()) {
                                Function2<Composer, Integer, Unit> function1110 = buttons;
                                Modifier modifier13 = modifier12;
                                Function2<Composer, Integer, Unit> function1111 = function118;
                                Function2<Composer, Integer, Unit> function1112 = function119;
                                Shape shape14 = shape13;
                                long j118 = j116;
                                long j119 = j117;
                                int i114 = i112;
                                AlertDialogKt.m880AlertDialogContentWMdw5o4(function1110, modifier13, function1111, function1112, shape14, j118, j119, composer2, ((i114 >> 3) & 14) | ((i114 >> 3) & 112) | ((i114 >> 3) & 896) | ((i114 >> 3) & 7168) | ((i114 >> 3) & 57344) | ((i114 >> 3) & 458752) | ((i114 >> 3) & 3670016), 0);
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                    modifier2 = companion;
                    function8 = function7;
                    function9 = function6;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    dialogProperties4 = dialogProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            if ((458752 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM983getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j;
            }
            if ((29360128 & i) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            } else {
                j3 = j2;
            }
            if ((234881024 & i) == 0) {
                if ((i2 & 256) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                i3 |= i12;
            } else {
                dialogProperties2 = dialogProperties;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier13 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function1110 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function1111 = function6;
                final Shape shape14 = shape2;
                final long j118 = j5;
                final long j119 = j4;
                final int i113 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i114 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function1112 = buttons;
                            Modifier modifier14 = modifier13;
                            Function2<Composer, Integer, Unit> function1113 = function1110;
                            Function2<Composer, Integer, Unit> function1114 = function1111;
                            Shape shape15 = shape14;
                            long j1110 = j118;
                            long j1111 = j119;
                            int i115 = i113;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function1112, modifier14, function1113, function1114, shape15, j1110, j1111, composer2, ((i115 >> 3) & 14) | ((i115 >> 3) & 112) | ((i115 >> 3) & 896) | ((i115 >> 3) & 7168) | ((i115 >> 3) & 57344) | ((i115 >> 3) & 458752) | ((i115 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier14 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function1112 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function1113 = function6;
                final Shape shape15 = shape2;
                final long j1110 = j5;
                final long j1111 = j4;
                final int i114 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i115 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function1114 = buttons;
                            Modifier modifier15 = modifier14;
                            Function2<Composer, Integer, Unit> function1115 = function1112;
                            Function2<Composer, Integer, Unit> function1116 = function1113;
                            Shape shape16 = shape15;
                            long j1112 = j1110;
                            long j1113 = j1111;
                            int i116 = i114;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function1114, modifier15, function1115, function1116, shape16, j1112, j1113, composer2, ((i116 >> 3) & 14) | ((i116 >> 3) & 112) | ((i116 >> 3) & 896) | ((i116 >> 3) & 7168) | ((i116 >> 3) & 57344) | ((i116 >> 3) & 458752) | ((i116 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        function4 = function2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM983getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                    }
                    i3 |= i11;
                } else {
                    jM983getSurface0d7_KjU = j;
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j;
            }
            if ((29360128 & i) == 0) {
                j3 = j2;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            } else {
                j3 = j2;
            }
            if ((234881024 & i) == 0) {
                if ((i2 & 256) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                    }
                    i3 |= i12;
                } else {
                    dialogProperties2 = dialogProperties;
                }
                i3 |= i12;
            } else {
                dialogProperties2 = dialogProperties;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier15 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function1114 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function1115 = function6;
                final Shape shape16 = shape2;
                final long j1112 = j5;
                final long j1113 = j4;
                final int i115 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i116 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function1116 = buttons;
                            Modifier modifier16 = modifier15;
                            Function2<Composer, Integer, Unit> function1117 = function1114;
                            Function2<Composer, Integer, Unit> function1118 = function1115;
                            Shape shape17 = shape16;
                            long j1114 = j1112;
                            long j1115 = j1113;
                            int i117 = i115;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function1116, modifier16, function1117, function1118, shape17, j1114, j1115, composer2, ((i117 >> 3) & 14) | ((i117 >> 3) & 112) | ((i117 >> 3) & 896) | ((i117 >> 3) & 7168) | ((i117 >> 3) & 57344) | ((i117 >> 3) & 458752) | ((i117 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 64) != 0) {
                        jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM997contentColorForek8zF_U = j3;
                    }
                    if ((i2 & 256) != 0) {
                        i8 = i3 & (-234881025);
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                        j5 = jM983getSurface0d7_KjU;
                    } else {
                        i8 = i3;
                        function6 = function5;
                        shape2 = medium;
                        function7 = function4;
                        j4 = jM997contentColorForek8zF_U;
                        j5 = jM983getSurface0d7_KjU;
                        dialogProperties3 = dialogProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                final Modifier modifier16 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function1116 = function7;
                final Function2<? super Composer, ? super Integer, Unit> function1117 = function6;
                final Shape shape17 = shape2;
                final long j1114 = j5;
                final long j1115 = j4;
                final int i116 = i8;
                AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i117 & 11) != 2 || !composer2.getSkipping()) {
                            Function2<Composer, Integer, Unit> function1118 = buttons;
                            Modifier modifier17 = modifier16;
                            Function2<Composer, Integer, Unit> function1119 = function1116;
                            Function2<Composer, Integer, Unit> function11110 = function1117;
                            Shape shape18 = shape17;
                            long j1116 = j1114;
                            long j1117 = j1115;
                            int i118 = i116;
                            AlertDialogKt.m880AlertDialogContentWMdw5o4(function1118, modifier17, function1119, function11110, shape18, j1116, j1117, composer2, ((i118 >> 3) & 14) | ((i118 >> 3) & 112) | ((i118 >> 3) & 896) | ((i118 >> 3) & 7168) | ((i118 >> 3) & 57344) | ((i118 >> 3) & 458752) | ((i118 >> 3) & 3670016), 0);
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
                modifier2 = companion;
                function8 = function7;
                function9 = function6;
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        if ((458752 & i) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                jM983getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM983getSurface0d7_KjU)) {
                }
                i3 |= i11;
            } else {
                jM983getSurface0d7_KjU = j;
            }
            i3 |= i11;
        } else {
            jM983getSurface0d7_KjU = j;
        }
        if ((29360128 & i) == 0) {
            j3 = j2;
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        } else {
            j3 = j2;
        }
        if ((234881024 & i) == 0) {
            if ((i2 & 256) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                }
                i3 |= i12;
            } else {
                dialogProperties2 = dialogProperties;
            }
            i3 |= i12;
        } else {
            dialogProperties2 = dialogProperties;
        }
        if ((i3 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape;
                }
                if ((i2 & 64) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i8 = i3 & (-234881025);
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                    j5 = jM983getSurface0d7_KjU;
                } else {
                    i8 = i3;
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM983getSurface0d7_KjU;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape;
                }
                if ((i2 & 64) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i8 = i3 & (-234881025);
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                    j5 = jM983getSurface0d7_KjU;
                } else {
                    i8 = i3;
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM983getSurface0d7_KjU;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            final Modifier modifier17 = companion;
            final Function2<? super Composer, ? super Integer, Unit> function1118 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function1119 = function6;
            final Shape shape18 = shape2;
            final long j1116 = j5;
            final long j1117 = j4;
            final int i117 = i8;
            AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if ((i118 & 11) != 2 || !composer2.getSkipping()) {
                        Function2<Composer, Integer, Unit> function11110 = buttons;
                        Modifier modifier18 = modifier17;
                        Function2<Composer, Integer, Unit> function11111 = function1118;
                        Function2<Composer, Integer, Unit> function11112 = function1119;
                        Shape shape19 = shape18;
                        long j1118 = j1116;
                        long j1119 = j1117;
                        int i119 = i117;
                        AlertDialogKt.m880AlertDialogContentWMdw5o4(function11110, modifier18, function11111, function11112, shape19, j1118, j1119, composer2, ((i119 >> 3) & 14) | ((i119 >> 3) & 112) | ((i119 >> 3) & 896) | ((i119 >> 3) & 7168) | ((i119 >> 3) & 57344) | ((i119 >> 3) & 458752) | ((i119 >> 3) & 3670016), 0);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
            modifier2 = companion;
            function8 = function7;
            function9 = function6;
            shape3 = shape2;
            j6 = j5;
            j7 = j4;
            dialogProperties4 = dialogProperties3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape;
                }
                if ((i2 & 64) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i8 = i3 & (-234881025);
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                    j5 = jM983getSurface0d7_KjU;
                } else {
                    i8 = i3;
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM983getSurface0d7_KjU;
                    dialogProperties3 = dialogProperties2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape;
                }
                if ((i2 & 64) != 0) {
                    jM983getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM997contentColorForek8zF_U = ColorsKt.m997contentColorForek8zF_U(jM983getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM997contentColorForek8zF_U = j3;
                }
                if ((i2 & 256) != 0) {
                    i8 = i3 & (-234881025);
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    dialogProperties3 = new DialogProperties(false, false, null, 7, null);
                    j5 = jM983getSurface0d7_KjU;
                } else {
                    i8 = i3;
                    function6 = function5;
                    shape2 = medium;
                    function7 = function4;
                    j4 = jM997contentColorForek8zF_U;
                    j5 = jM983getSurface0d7_KjU;
                    dialogProperties3 = dialogProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            final Modifier modifier18 = companion;
            final Function2<? super Composer, ? super Integer, Unit> function11110 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function11111 = function6;
            final Shape shape19 = shape2;
            final long j1118 = j5;
            final long j1119 = j4;
            final int i118 = i8;
            AndroidDialog_androidKt.Dialog(onDismissRequest, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation(composer2, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if ((i119 & 11) != 2 || !composer2.getSkipping()) {
                        Function2<Composer, Integer, Unit> function11112 = buttons;
                        Modifier modifier19 = modifier18;
                        Function2<Composer, Integer, Unit> function11113 = function11110;
                        Function2<Composer, Integer, Unit> function11114 = function11111;
                        Shape shape110 = shape19;
                        long j11110 = j1118;
                        long j11111 = j1119;
                        int i1110 = i118;
                        AlertDialogKt.m880AlertDialogContentWMdw5o4(function11112, modifier19, function11113, function11114, shape110, j11110, j11111, composer2, ((i1110 >> 3) & 14) | ((i1110 >> 3) & 112) | ((i1110 >> 3) & 896) | ((i1110 >> 3) & 7168) | ((i1110 >> 3) & 57344) | ((i1110 >> 3) & 458752) | ((i1110 >> 3) & 3670016), 0);
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i8 & 14) | 384 | ((i8 >> 21) & 112), 0);
            modifier2 = companion;
            function8 = function7;
            function9 = function6;
            shape3 = shape2;
            j6 = j5;
            j7 = j4;
            dialogProperties4 = dialogProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                AndroidAlertDialog_androidKt.m883AlertDialogwqdebIU(onDismissRequest, buttons, modifier2, function8, function9, shape3, j6, j7, dialogProperties4, composer2, i | 1, i2);
            }
        });
    }
}
