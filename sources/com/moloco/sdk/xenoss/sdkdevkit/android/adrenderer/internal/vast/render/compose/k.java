package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f7000a = Dp.m3843constructorimpl(4);

    public static final class a extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7001a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, long j, int i) {
            super(3);
            this.f7001a = str;
            this.b = str2;
            this.c = j;
            this.d = i;
        }

        public final void a(RowScope OutlinedButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1553541117, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTA.<anonymous> (VastCTA.kt:37)");
            }
            String str = this.f7001a;
            composer.startReplaceableGroup(640085894);
            if (str != null) {
                String str2 = this.f7001a;
                int i2 = this.d;
                Modifier.Companion companion = Modifier.INSTANCE;
                SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str2, null, SizeKt.m464size3ABfNKs(ClipKt.clip(companion, RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(k.f7000a)), Dp.m3843constructorimpl(36)), null, null, null, null, 0.0f, null, 0, composer, ((i2 >> 3) & 14) | 48, 1016);
                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion, k.f7000a), composer, 6);
                Unit unit = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            String str3 = this.b;
            long j = this.c;
            int i3 = this.d;
            TextKt.m1246TextfLXpl1I(str3, null, j, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, null, null, composer, ((i3 >> 6) & 14) | ((i3 >> 3) & 896), 3072, 57338);
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

    public static final class b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f7002a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Modifier modifier, String str, String str2, long j, Function0<Unit> function0, int i, int i2) {
            super(2);
            this.f7002a = modifier;
            this.b = str;
            this.c = str2;
            this.d = j;
            this.e = function0;
            this.f = i;
            this.g = i2;
        }

        public final void a(Composer composer, int i) {
            k.a(this.f7002a, this.b, this.c, this.d, this.e, composer, this.f | 1, this.g);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(2);
            this.f7003a = i;
        }

        public final void a(Composer composer, int i) {
            k.a(composer, this.f7003a | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:85:0x0161  */
    /* JADX WARN: Code duplicated, block: B:90:0x0170  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void a(Modifier modifier, String str, String text, long j, Function0<Unit> onClick, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        String str2;
        int i4;
        long jM979getPrimary0d7_KjU;
        int i5;
        Modifier modifier3;
        Modifier modifier4;
        int i6;
        Composer composer2;
        Modifier modifier5;
        String str3;
        long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1735772917);
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
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(text)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    jM979getPrimary0d7_KjU = j;
                    int i9 = composerStartRestartGroup.changed(jM979getPrimary0d7_KjU) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                i3 |= i9;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(onClick)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        str2 = null;
                    }
                    if ((i2 & 8) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i3 &= -7169;
                    }
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    modifier4 = modifier2;
                }
                String str4 = str2;
                long j3 = jM979getPrimary0d7_KjU;
                i6 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1735772917, i6, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTA (VastCTA.kt:23)");
                }
                Modifier modifier6 = modifier4;
                composer2 = composerStartRestartGroup;
                ButtonKt.OutlinedButton(onClick, AnimationModifierKt.animateContentSize$default(SizeKt.m471widthInVpY3zN4$default(SizeKt.m450height3ABfNKs(modifier4, Dp.m3843constructorimpl(48)), 0.0f, Dp.m3843constructorimpl(156), 1, null), null, null, 3, null), false, null, null, null, null, null, PaddingKt.m418PaddingValuesYgX7TsA$default(f7000a, 0.0f, 2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1553541117, true, new a(str4, text, j3, i6)), composer2, ((i6 >> 12) & 14) | 905969664, 252);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier6;
                str3 = str4;
                j2 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                str3 = str2;
                j2 = jM979getPrimary0d7_KjU;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new b(modifier5, str3, text, j2, onClick, i, i2));
        }
        i3 |= 48;
        str2 = str;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changed(text)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM979getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM979getPrimary0d7_KjU)) {
                }
                i3 |= i9;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            i3 |= i9;
        } else {
            jM979getPrimary0d7_KjU = j;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changed(onClick)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((46811 & i3) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    str2 = null;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
                modifier4 = modifier3;
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    str2 = null;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
                modifier4 = modifier3;
            }
            String str5 = str2;
            long j4 = jM979getPrimary0d7_KjU;
            i6 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1735772917, i6, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTA (VastCTA.kt:23)");
            }
            Modifier modifier7 = modifier4;
            composer2 = composerStartRestartGroup;
            ButtonKt.OutlinedButton(onClick, AnimationModifierKt.animateContentSize$default(SizeKt.m471widthInVpY3zN4$default(SizeKt.m450height3ABfNKs(modifier4, Dp.m3843constructorimpl(48)), 0.0f, Dp.m3843constructorimpl(156), 1, null), null, null, 3, null), false, null, null, null, null, null, PaddingKt.m418PaddingValuesYgX7TsA$default(f7000a, 0.0f, 2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1553541117, true, new a(str5, text, j4, i6)), composer2, ((i6 >> 12) & 14) | 905969664, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier7;
            str3 = str5;
            j2 = j4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    str2 = null;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
                modifier4 = modifier3;
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    str2 = null;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
                modifier4 = modifier3;
            }
            String str6 = str2;
            long j5 = jM979getPrimary0d7_KjU;
            i6 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1735772917, i6, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTA (VastCTA.kt:23)");
            }
            Modifier modifier8 = modifier4;
            composer2 = composerStartRestartGroup;
            ButtonKt.OutlinedButton(onClick, AnimationModifierKt.animateContentSize$default(SizeKt.m471widthInVpY3zN4$default(SizeKt.m450height3ABfNKs(modifier4, Dp.m3843constructorimpl(48)), 0.0f, Dp.m3843constructorimpl(156), 1, null), null, null, 3, null), false, null, null, null, null, null, PaddingKt.m418PaddingValuesYgX7TsA$default(f7000a, 0.0f, 2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1553541117, true, new a(str6, text, j5, i6)), composer2, ((i6 >> 12) & 14) | 905969664, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier8;
            str3 = str6;
            j2 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(modifier5, str3, text, j2, onClick, i, i2));
    }

    public static final void a(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-838285503);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-838285503, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastCTAPreview (VastCTA.kt:58)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, d.f6973a.a(), composerStartRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new c(i));
    }
}
