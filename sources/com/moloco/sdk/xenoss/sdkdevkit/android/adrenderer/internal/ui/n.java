package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    public static final class a extends Lambda implements Function3<o, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f6729a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.n$a$a, reason: collision with other inner class name */
        public static final class C0631a extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f6730a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TextStyle c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0631a(o oVar, long j, TextStyle textStyle, int i) {
                super(3);
                this.f6730a = oVar;
                this.b = j;
                this.c = textStyle;
                this.d = i;
            }

            public final void a(RowScope TextButton, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                if ((i & 81) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-291791758, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous>.<anonymous> (CountdownButton.kt:83)");
                }
                TextKt.m1246TextfLXpl1I(((o.c) this.f6730a).a(), null, 0L, this.b, null, null, null, 0L, null, TextAlign.m3744boximpl(TextAlign.INSTANCE.m3751getCentere0LSkKk()), 0L, 0, false, 1, null, this.c, composer, (this.d >> 9) & 7168, 3072, 24054);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                a(rowScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0<Unit> function0, boolean z, long j, long j2, int i, long j3) {
            super(3);
            this.f6729a = function0;
            this.b = z;
            this.c = j;
            this.d = j2;
            this.e = i;
            this.f = j3;
        }

        public final void a(o buttonPart, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(buttonPart, "buttonPart");
            if ((i & 14) == 0) {
                i2 = (composer.changed(buttonPart) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1264027403, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous> (CountdownButton.kt:55)");
            }
            TextStyle h6 = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH6();
            if (buttonPart instanceof o.a) {
                composer.startReplaceableGroup(1614446682);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof o.b) {
                composer.startReplaceableGroup(1614447018);
                o.b bVar = (o.b) buttonPart;
                Painter painterE = bVar.e();
                long jD = bVar.d();
                Shape shapeB = bVar.b();
                long jA = bVar.a();
                String strC = bVar.c();
                Function0<Unit> function0 = this.f6729a;
                boolean z = this.b;
                long j = this.c;
                long j2 = this.d;
                int i3 = this.e;
                int i4 = ((i3 >> 3) & 112) | 8 | (i3 & 7168);
                int i5 = i3 << 3;
                r.a(painterE, function0, null, z, strC, j, j2, jD, shapeB, jA, composer, i4 | (i5 & 458752) | (i5 & 3670016), 4);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof o.c) {
                composer.startReplaceableGroup(1614447638);
                Function0<Unit> function1 = this.f6729a;
                boolean z2 = this.b;
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                long j3 = this.c;
                int i6 = this.e;
                ButtonColors buttonColorsM938textButtonColorsRGew2ao = buttonDefaults.m938textButtonColorsRGew2ao(0L, j3, j3, composer, ((i6 >> 6) & 896) | ((i6 >> 9) & 112) | (ButtonDefaults.$stable << 9), 1);
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -291791758, true, new C0631a(buttonPart, this.f, h6, this.e));
                int i7 = this.e;
                ButtonKt.TextButton(function1, null, z2, null, null, null, null, buttonColorsM938textButtonColorsRGew2ao, null, composableLambda, composer, ((i7 >> 6) & 14) | C.ENCODING_PCM_32BIT | ((i7 >> 3) & 896), 378);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1614448237);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(o oVar, Composer composer, Integer num) {
            a(oVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f6731a;
        public final /* synthetic */ Modifier b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;
        public final /* synthetic */ long f;
        public final /* synthetic */ long g;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o oVar, Modifier modifier, Function0<Unit> function0, boolean z, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar, int i, int i2) {
            super(2);
            this.f6731a = oVar;
            this.b = modifier;
            this.c = function0;
            this.d = z;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = iVar;
            this.i = i;
            this.j = i2;
        }

        public final void a(Composer composer, int i) {
            n.a(this.f6731a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, composer, this.i | 1, this.j);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0134 A[PHI: r9 r10 r13 r18
  0x0134: PHI (r9v20 androidx.compose.ui.Modifier) = (r9v3 androidx.compose.ui.Modifier), (r9v2 androidx.compose.ui.Modifier), (r9v2 androidx.compose.ui.Modifier) binds: [B:110:0x015c, B:99:0x0130, B:100:0x0132] A[DONT_GENERATE, DONT_INLINE]
  0x0134: PHI (r10v31 long) = (r10v20 long), (r10v19 long), (r10v19 long) binds: [B:110:0x015c, B:99:0x0130, B:100:0x0132] A[DONT_GENERATE, DONT_INLINE]
  0x0134: PHI (r13v9 long) = (r13v4 long), (r13v3 long), (r13v3 long) binds: [B:110:0x015c, B:99:0x0130, B:100:0x0132] A[DONT_GENERATE, DONT_INLINE]
  0x0134: PHI (r18v12 int) = (r18v8 int), (r18v7 int), (r18v13 int) binds: [B:110:0x015c, B:99:0x0130, B:100:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0140  */
    /* JADX WARN: Code duplicated, block: B:107:0x0147  */
    /* JADX WARN: Code duplicated, block: B:109:0x0157  */
    /* JADX WARN: Code duplicated, block: B:111:0x015e  */
    /* JADX WARN: Code duplicated, block: B:114:0x016e  */
    /* JADX WARN: Code duplicated, block: B:117:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:121:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:124:0x022d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x0238  */
    /* JADX WARN: Code duplicated, block: B:130:0x028f  */
    /* JADX WARN: Code duplicated, block: B:135:0x029d  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x0109  */
    /* JADX WARN: Code duplicated, block: B:93:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0124  */
    public static final void a(o countdownButtonPart, Modifier modifier, Function0<Unit> onClick, boolean z, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        long jM979getPrimary0d7_KjU;
        int i6;
        long jB;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long jD;
        int i13;
        Function0<ComposeUiNode> constructor;
        Composer composer2;
        Modifier modifier3;
        long j4;
        o.a aVar;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(countdownButtonPart, "countdownButtonPart");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-913983839);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(countdownButtonPart) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(onClick)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    jM979getPrimary0d7_KjU = j;
                    int i15 = composerStartRestartGroup.changed(jM979getPrimary0d7_KjU) ? 16384 : 8192;
                    i3 |= i15;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                i3 |= i15;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    jB = j2;
                    if (composerStartRestartGroup.changed(jB)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i10 = i3 | 1572864;
                } else {
                    i9 = i3;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i10 = i9 | i11;
                    } else {
                        i10 = i9;
                    }
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(iVar)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                    }
                    if ((i10 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 16) != 0) {
                                jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                                i10 &= -57345;
                            }
                            if (i6 != 0) {
                                jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                            }
                            if (i8 != 0) {
                                jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                            }
                            long j5 = jM979getPrimary0d7_KjU;
                            long j6 = jB;
                            i13 = i10;
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                            }
                            Modifier modifierM465size6HolHcs = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j6);
                            Alignment topEnd = Alignment.INSTANCE.getTopEnd();
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topEnd, false, composerStartRestartGroup, 6);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM465size6HolHcs);
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
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, companion.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(848184628);
                            if ((countdownButtonPart instanceof o.a) && iVar != null) {
                                aVar = (o.a) countdownButtonPart;
                                if (aVar.b()) {
                                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                                }
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            jB = j6;
                            composer2 = composerStartRestartGroup;
                            CrossfadeKt.Crossfade(countdownButtonPart, modifier4, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j5, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j4 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i10 &= -57345;
                            }
                        }
                        jD = j3;
                        long j7 = jM979getPrimary0d7_KjU;
                        long j8 = jB;
                        i13 = i10;
                        Modifier modifier5 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                        }
                        Modifier modifierM465size6HolHcs2 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j8);
                        Alignment topEnd2 = Alignment.INSTANCE.getTopEnd();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(topEnd2, false, composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM465size6HolHcs2);
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
                        Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl2, density2, companion2.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(848184628);
                        if (countdownButtonPart instanceof o.a) {
                            aVar = (o.a) countdownButtonPart;
                            if (aVar.b()) {
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                            }
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        jB = j8;
                        composer2 = composerStartRestartGroup;
                        CrossfadeKt.Crossfade(countdownButtonPart, modifier5, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j7, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        j4 = j7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        jD = j3;
                        j4 = jM979getPrimary0d7_KjU;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
                }
                i12 = 12582912;
                i10 |= i12;
                if ((i10 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j9 = jM979getPrimary0d7_KjU;
                    long j10 = jB;
                    i13 = i10;
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs3 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j10);
                    Alignment topEnd3 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(topEnd3, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    constructor = companion3.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM465size6HolHcs3);
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
                    Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl3, density3, companion3.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j10;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier6, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j9, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    j4 = j9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j11 = jM979getPrimary0d7_KjU;
                    long j12 = jB;
                    i13 = i10;
                    Modifier modifier7 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs4 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j12);
                    Alignment topEnd4 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(topEnd4, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    constructor = companion4.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM465size6HolHcs4);
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
                    Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl4, density4, companion4.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, companion4.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, companion4.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j12;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier7, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j11, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    j4 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            jB = j2;
            i8 = i2 & 64;
            if (i8 != 0) {
                i10 = i3 | 1572864;
            } else {
                i9 = i3;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i10 = i9 | i11;
                } else {
                    i10 = i9;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(iVar)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                }
                if ((i10 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j13 = jM979getPrimary0d7_KjU;
                    long j14 = jB;
                    i13 = i10;
                    Modifier modifier8 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs5 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j14);
                    Alignment topEnd5 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(topEnd5, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    constructor = companion5.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM465size6HolHcs5);
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
                    Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl5, density5, companion5.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, companion5.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, companion5.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j14;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier8, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j13, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    j4 = j13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j15 = jM979getPrimary0d7_KjU;
                    long j16 = jB;
                    i13 = i10;
                    Modifier modifier9 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs6 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j16);
                    Alignment topEnd6 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(topEnd6, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    constructor = companion6.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM465size6HolHcs6);
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
                    Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl6, density6, companion6.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, companion6.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl6, viewConfiguration6, companion6.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j16;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier9, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j15, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    j4 = j15;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
            }
            i12 = 12582912;
            i10 |= i12;
            if ((i10 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j17 = jM979getPrimary0d7_KjU;
                long j18 = jB;
                i13 = i10;
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs7 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j18);
                Alignment topEnd7 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(topEnd7, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                constructor = companion7.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM465size6HolHcs7);
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
                Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, companion7.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl7, density7, companion7.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, companion7.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl7, viewConfiguration7, companion7.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j18;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier10, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j17, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                j4 = j17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j19 = jM979getPrimary0d7_KjU;
                long j110 = jB;
                i13 = i10;
                Modifier modifier11 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs8 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j110);
                Alignment topEnd8 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(topEnd8, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection8 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                constructor = companion8.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierM465size6HolHcs8);
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
                Updater.m1293setimpl(composerM1286constructorimpl8, measurePolicyRememberBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl8, density8, companion8.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl8, layoutDirection8, companion8.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl8, viewConfiguration8, companion8.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf8.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j110;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier11, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j19, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                j4 = j19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changed(onClick)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                jM979getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM979getPrimary0d7_KjU)) {
                }
                i3 |= i15;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            i3 |= i15;
        } else {
            jM979getPrimary0d7_KjU = j;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                jB = j2;
                if (composerStartRestartGroup.changed(jB)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i10 = i3 | 1572864;
            } else {
                i9 = i3;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i10 = i9 | i11;
                } else {
                    i10 = i9;
                }
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(iVar)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                }
                if ((i10 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j111 = jM979getPrimary0d7_KjU;
                    long j112 = jB;
                    i13 = i10;
                    Modifier modifier12 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs9 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j112);
                    Alignment topEnd9 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(topEnd9, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection9 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration9 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                    constructor = companion9.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierM465size6HolHcs9);
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
                    Updater.m1293setimpl(composerM1286constructorimpl9, measurePolicyRememberBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl9, density9, companion9.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl9, layoutDirection9, companion9.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl9, viewConfiguration9, companion9.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf9.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j112;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier12, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j111, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier12;
                    j4 = j111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 16) != 0) {
                            jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                            i10 &= -57345;
                        }
                        if (i6 != 0) {
                            jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                        }
                        if (i8 != 0) {
                            jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                        } else {
                            jD = j3;
                        }
                    }
                    long j113 = jM979getPrimary0d7_KjU;
                    long j114 = jB;
                    i13 = i10;
                    Modifier modifier13 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                    }
                    Modifier modifierM465size6HolHcs10 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j114);
                    Alignment topEnd10 = Alignment.INSTANCE.getTopEnd();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(topEnd10, false, composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density10 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection10 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                    constructor = companion10.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf10 = LayoutKt.materializerOf(modifierM465size6HolHcs10);
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
                    Updater.m1293setimpl(composerM1286constructorimpl10, measurePolicyRememberBoxMeasurePolicy10, companion10.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl10, density10, companion10.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl10, layoutDirection10, companion10.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl10, viewConfiguration10, companion10.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf10.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(848184628);
                    if (countdownButtonPart instanceof o.a) {
                        aVar = (o.a) countdownButtonPart;
                        if (aVar.b()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    jB = j114;
                    composer2 = composerStartRestartGroup;
                    CrossfadeKt.Crossfade(countdownButtonPart, modifier13, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j113, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier13;
                    j4 = j113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
            }
            i12 = 12582912;
            i10 |= i12;
            if ((i10 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j115 = jM979getPrimary0d7_KjU;
                long j116 = jB;
                i13 = i10;
                Modifier modifier14 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs11 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j116);
                Alignment topEnd11 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(topEnd11, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                constructor = companion11.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11 = LayoutKt.materializerOf(modifierM465size6HolHcs11);
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
                Updater.m1293setimpl(composerM1286constructorimpl11, measurePolicyRememberBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl11, density11, companion11.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl11, layoutDirection11, companion11.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl11, viewConfiguration11, companion11.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf11.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j116;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier14, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j115, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier14;
                j4 = j115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j117 = jM979getPrimary0d7_KjU;
                long j118 = jB;
                i13 = i10;
                Modifier modifier15 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs12 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j118);
                Alignment topEnd12 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(topEnd12, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density12 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection12 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration12 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                constructor = companion12.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf12 = LayoutKt.materializerOf(modifierM465size6HolHcs12);
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
                Updater.m1293setimpl(composerM1286constructorimpl12, measurePolicyRememberBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl12, density12, companion12.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl12, layoutDirection12, companion12.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl12, viewConfiguration12, companion12.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf12.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j118;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier15, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j117, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
                j4 = j117;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        jB = j2;
        i8 = i2 & 64;
        if (i8 != 0) {
            i10 = i3 | 1572864;
        } else {
            i9 = i3;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i10 = i9 | i11;
            } else {
                i10 = i9;
            }
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(iVar)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
            }
            if ((i10 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j119 = jM979getPrimary0d7_KjU;
                long j1110 = jB;
                i13 = i10;
                Modifier modifier16 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs13 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j1110);
                Alignment topEnd13 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(topEnd13, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection13 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration13 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
                constructor = companion13.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf13 = LayoutKt.materializerOf(modifierM465size6HolHcs13);
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
                Updater.m1293setimpl(composerM1286constructorimpl13, measurePolicyRememberBoxMeasurePolicy13, companion13.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl13, density13, companion13.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl13, layoutDirection13, companion13.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl13, viewConfiguration13, companion13.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf13.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j1110;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier16, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j119, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier16;
                j4 = j119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i10 &= -57345;
                    }
                    if (i6 != 0) {
                        jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                    }
                    if (i8 != 0) {
                        jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                    } else {
                        jD = j3;
                    }
                }
                long j1111 = jM979getPrimary0d7_KjU;
                long j1112 = jB;
                i13 = i10;
                Modifier modifier17 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
                }
                Modifier modifierM465size6HolHcs14 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j1112);
                Alignment topEnd14 = Alignment.INSTANCE.getTopEnd();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(topEnd14, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density14 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection14 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                constructor = companion14.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf14 = LayoutKt.materializerOf(modifierM465size6HolHcs14);
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
                Updater.m1293setimpl(composerM1286constructorimpl14, measurePolicyRememberBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl14, density14, companion14.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl14, layoutDirection14, companion14.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl14, viewConfiguration14, companion14.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf14.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(848184628);
                if (countdownButtonPart instanceof o.a) {
                    aVar = (o.a) countdownButtonPart;
                    if (aVar.b()) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                jB = j1112;
                composer2 = composerStartRestartGroup;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier17, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j1111, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier17;
                j4 = j1111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
        }
        i12 = 12582912;
        i10 |= i12;
        if ((i10 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i10 &= -57345;
                }
                if (i6 != 0) {
                    jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                }
                if (i8 != 0) {
                    jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                } else {
                    jD = j3;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i10 &= -57345;
                }
                if (i6 != 0) {
                    jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                }
                if (i8 != 0) {
                    jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                } else {
                    jD = j3;
                }
            }
            long j1113 = jM979getPrimary0d7_KjU;
            long j1114 = jB;
            i13 = i10;
            Modifier modifier18 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
            }
            Modifier modifierM465size6HolHcs15 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j1114);
            Alignment topEnd15 = Alignment.INSTANCE.getTopEnd();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(topEnd15, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density15 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection15 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration15 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
            constructor = companion15.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf15 = LayoutKt.materializerOf(modifierM465size6HolHcs15);
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
            Updater.m1293setimpl(composerM1286constructorimpl15, measurePolicyRememberBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl15, density15, companion15.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl15, layoutDirection15, companion15.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl15, viewConfiguration15, companion15.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf15.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(848184628);
            if (countdownButtonPart instanceof o.a) {
                aVar = (o.a) countdownButtonPart;
                if (aVar.b()) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            jB = j1114;
            composer2 = composerStartRestartGroup;
            CrossfadeKt.Crossfade(countdownButtonPart, modifier18, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j1113, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier18;
            j4 = j1113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i10 &= -57345;
                }
                if (i6 != 0) {
                    jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                }
                if (i8 != 0) {
                    jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                } else {
                    jD = j3;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 16) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i10 &= -57345;
                }
                if (i6 != 0) {
                    jB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                }
                if (i8 != 0) {
                    jD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                } else {
                    jD = j3;
                }
            }
            long j1115 = jM979getPrimary0d7_KjU;
            long j1116 = jB;
            i13 = i10;
            Modifier modifier19 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913983839, i13, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:27)");
            }
            Modifier modifierM465size6HolHcs16 = SizeKt.m465size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j1116);
            Alignment topEnd16 = Alignment.INSTANCE.getTopEnd();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(topEnd16, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density16 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection16 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration16 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
            constructor = companion16.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf16 = LayoutKt.materializerOf(modifierM465size6HolHcs16);
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
            Updater.m1293setimpl(composerM1286constructorimpl16, measurePolicyRememberBoxMeasurePolicy16, companion16.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl16, density16, companion16.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl16, layoutDirection16, companion16.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl16, viewConfiguration16, companion16.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf16.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(848184628);
            if (countdownButtonPart instanceof o.a) {
                aVar = (o.a) countdownButtonPart;
                if (aVar.b()) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), composerStartRestartGroup, (i13 >> 21) & 14);
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            jB = j1116;
            composer2 = composerStartRestartGroup;
            CrossfadeKt.Crossfade(countdownButtonPart, modifier19, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1264027403, true, new a(onClick, z, j1115, jB, i13, jD)), composer2, (i13 & 112) | (i13 & 14) | 3072, 4);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier19;
            j4 = j1115;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(countdownButtonPart, modifier3, onClick, z, j4, jB, jD, iVar, i, i2));
    }
}
