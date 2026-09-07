package com.moloco.sdk.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.moloco.sdk.R;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6437a = ColorKt.Color(4278354171L);

    public static final class a extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6438a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Modifier modifier, String str, String str2, long j, long j2, Function0<Unit> function0, int i, int i2) {
            super(2);
            this.f6438a = modifier;
            this.b = str;
            this.c = str2;
            this.d = j;
            this.e = j2;
            this.f = function0;
            this.g = i;
            this.h = i2;
        }

        public final void a(Composer composer, int i) {
            u.a(this.f6438a, this.b, this.c, this.d, this.e, this.f, composer, this.g | 1, this.h);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function7<BoxScope, Boolean, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6439a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ long f;
        public final /* synthetic */ int g;

        public static final class a extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> f6440a;
            public final /* synthetic */ int b;
            public final /* synthetic */ State<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ long f;
            public final /* synthetic */ long g;
            public final /* synthetic */ Function0<Unit> h;
            public final /* synthetic */ int i;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.u$b$a$a, reason: collision with other inner class name */
            public static final class C0563a extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f6441a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;
                public final /* synthetic */ int f;
                public final /* synthetic */ int g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0563a(String str, String str2, long j, long j2, Function0<Unit> function0, int i, int i2) {
                    super(3);
                    this.f6441a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                    this.f = i;
                    this.g = i2;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 14) == 0) {
                        i2 = i | (composer.changed(it) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1676203776, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:71)");
                    }
                    String str = this.f6441a;
                    String str2 = this.b;
                    long j = this.c;
                    long j2 = this.d;
                    Function0<Unit> function0 = this.e;
                    int i3 = this.f;
                    u.a(it, str, str2, j, j2, function0, composer, ((this.g << 3) & 458752) | (i2 & 14) | ((i3 >> 12) & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.u$b$a$b, reason: collision with other inner class name */
            public static final class C0564b extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f6442a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;
                public final /* synthetic */ int f;
                public final /* synthetic */ int g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0564b(String str, String str2, long j, long j2, Function0<Unit> function0, int i, int i2) {
                    super(3);
                    this.f6442a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                    this.f = i;
                    this.g = i2;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 14) == 0) {
                        i2 = i | (composer.changed(it) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(357526633, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:86)");
                    }
                    String str = this.f6442a;
                    String str2 = this.b;
                    long j = this.c;
                    long j2 = this.d;
                    Function0<Unit> function0 = this.e;
                    int i3 = this.f;
                    u.a(it, str, str2, j, j2, function0, composer, ((this.g << 3) & 458752) | (i2 & 14) | ((i3 >> 12) & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, int i, State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> state, String str, String str2, long j, long j2, Function0<Unit> function0, int i2) {
                super(3);
                this.f6440a = function1;
                this.b = i;
                this.c = state;
                this.d = str;
                this.e = str2;
                this.f = j;
                this.g = j2;
                this.h = function0;
                this.i = i2;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1562460200, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous> (MolocoVastCTA.kt:55)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a aVarB = b.b(this.c);
                if (aVarB instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.C0652a) {
                    composer.startReplaceableGroup(-1828335674);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v.a(null, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.CTA, this.f6440a, ComposableLambdaKt.composableLambda(composer, -1676203776, true, new C0563a(this.d, this.e, this.f, this.g, this.h, this.i, this.b)), composer, ((this.b >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.c) {
                    composer.startReplaceableGroup(-1828335108);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v.a(null, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.CTA, this.f6440a, ComposableLambdaKt.composableLambda(composer, 357526633, true, new C0564b(this.d, this.e, this.f, this.g, this.h, this.i, this.b)), composer, ((this.b >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.b) {
                    composer.startReplaceableGroup(-1828334545);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.d) {
                    composer.startReplaceableGroup(-1828334487);
                    composer.endReplaceableGroup();
                } else if (aVarB == null) {
                    composer.startReplaceableGroup(-1828334452);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1828334429);
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j, long j2, int i) {
            super(7);
            this.f6439a = alignment;
            this.b = paddingValues;
            this.c = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
            this.g = i;
        }

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a b(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> state) {
            return state.getValue();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> stateFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), stateFlow, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(BoxScope boxScope, boolean z, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> currentAdPartFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function0<Unit> onCTA, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            Intrinsics.checkNotNullParameter(currentAdPartFlow, "currentAdPartFlow");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            Intrinsics.checkNotNullParameter(onCTA, "onCTA");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1780811600, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous> (MolocoVastCTA.kt:47)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f6439a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1562460200, true, new a(onButtonRendered, i, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, 8, 1), this.c, this.d, this.e, this.f, onCTA, this.g)), composer, ((i >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final Function7<BoxScope, Boolean, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, String str, long j, long j2, String str2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1689381278);
        Alignment bottomEnd = (i2 & 1) != 0 ? Alignment.INSTANCE.getBottomEnd() : alignment;
        PaddingValues paddingValuesM416PaddingValues0680j_4 = (i2 & 2) != 0 ? PaddingKt.m416PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        String strStringResource = (i2 & 4) != 0 ? StringResources_androidKt.stringResource(R.string.com_moloco_sdk_xenoss_player_learn_more, composer, 0) : str;
        long jM1668getWhite0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m1668getWhite0d7_KjU() : j;
        long j3 = (i2 & 16) != 0 ? f6437a : j2;
        String str3 = (i2 & 32) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1689381278, i, -1, "com.moloco.sdk.internal.molocoCTAButton (MolocoVastCTA.kt:40)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1780811600, true, new b(bottomEnd, paddingValuesM416PaddingValues0680j_4, str3, strStringResource, jM1668getWhite0d7_KjU, j3, i));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x0176  */
    /* JADX WARN: Code duplicated, block: B:86:0x0182  */
    /* JADX WARN: Code duplicated, block: B:87:0x0186  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:94:0x027c  */
    /* JADX WARN: Code duplicated, block: B:99:0x028a  */
    public static final void a(Modifier modifier, String str, String str2, long j, long j2, Function0<Unit> function0, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        String str3;
        int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier3;
        float f;
        RoundedCornerShape roundedCornerShapeM673RoundedCornerShape0680j_4;
        Function0<ComposeUiNode> constructor;
        String str4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2035340272);
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
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                str3 = str;
                i3 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i4 = 256;
                    } else {
                        i4 = 128;
                    }
                    i3 |= i4;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changed(function0)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((374491 & i3) != 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        str3 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
                    }
                    f = 4;
                    roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
                    Modifier modifierM195clickableXHw0xAI$default = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    Modifier modifier4 = modifier3;
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    constructor = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default);
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
                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl, density, companion.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-678309503);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-419477280);
                    if (str3 != null) {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion2, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                        SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion2, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                }
                str4 = str3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new a(modifier2, str4, str2, j, j2, function0, i, i2));
            }
            i3 |= 384;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(function0)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((374491 & i3) != 74898) {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    str3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
                }
                f = 4;
                roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
                Modifier modifierM195clickableXHw0xAI$default2 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifier5 = modifier3;
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default2);
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
                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl2, density2, companion3.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-419477280);
                if (str3 != null) {
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion4, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                    SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion4, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier5;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    str3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
                }
                f = 4;
                roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
                Modifier modifierM195clickableXHw0xAI$default3 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(center3, centerVertically3, composerStartRestartGroup, 54);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifier6 = modifier3;
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                constructor = companion5.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default3);
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
                Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRowMeasurePolicy3, companion5.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl3, density3, companion5.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, companion5.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, companion5.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-419477280);
                if (str3 != null) {
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion6, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                    SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion6, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier6;
            }
            str4 = str3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new a(modifier2, str4, str2, j, j2, function0, i, i2));
        }
        i3 |= 48;
        str3 = str;
        if ((i2 & 4) != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(function0)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((374491 & i3) != 74898) {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    str3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
                }
                f = 4;
                roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
                Modifier modifierM195clickableXHw0xAI$default4 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
                Arrangement.HorizontalOrVertical center4 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(center4, centerVertically4, composerStartRestartGroup, 54);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifier7 = modifier3;
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                constructor = companion7.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default4);
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
                Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRowMeasurePolicy4, companion7.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl4, density4, companion7.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, companion7.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, companion7.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-419477280);
                if (str3 != null) {
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion8, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                    SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion8, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier7;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    str3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
                }
                f = 4;
                roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
                Modifier modifierM195clickableXHw0xAI$default5 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
                Arrangement.HorizontalOrVertical center5 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(center5, centerVertically5, composerStartRestartGroup, 54);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifier8 = modifier3;
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                constructor = companion9.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default5);
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
                Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRowMeasurePolicy5, companion9.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl5, density5, companion9.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, companion9.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, companion9.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-419477280);
                if (str3 != null) {
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion10, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                    SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion10, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier8;
            }
            str4 = str3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new a(modifier2, str4, str2, j, j2, function0, i, i2));
        }
        i3 |= 384;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i) == 0) {
            if (composerStartRestartGroup.changed(function0)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((374491 & i3) != 74898) {
            if (i8 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i9 != 0) {
                str3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
            }
            f = 4;
            roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
            Modifier modifierM195clickableXHw0xAI$default6 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
            Arrangement.HorizontalOrVertical center6 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(center6, centerVertically6, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Modifier modifier9 = modifier3;
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
            constructor = companion11.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default6);
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
            Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRowMeasurePolicy6, companion11.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl6, density6, companion11.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, companion11.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl6, viewConfiguration6, companion11.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-419477280);
            if (str3 != null) {
                Modifier.Companion companion12 = Modifier.INSTANCE;
                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion12, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion12, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier9;
        } else {
            if (i8 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i9 != 0) {
                str3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:106)");
            }
            f = 4;
            roundedCornerShapeM673RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m673RoundedCornerShape0680j_4(Dp.m3843constructorimpl(f));
            Modifier modifierM195clickableXHw0xAI$default7 = ClickableKt.m195clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m176backgroundbw27NRU$default(ClipKt.clip(SizeKt.m471widthInVpY3zN4$default(modifier3, 0.0f, Dp.m3843constructorimpl(164), 1, null), roundedCornerShapeM673RoundedCornerShape0680j_4), j2, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m3380boximpl(Role.INSTANCE.m3387getButtono7Vup1c()), function0, 1, null);
            Arrangement.HorizontalOrVertical center7 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(center7, centerVertically7, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Modifier modifier10 = modifier3;
            ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
            constructor = companion13.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM195clickableXHw0xAI$default7);
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
            Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRowMeasurePolicy7, companion13.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl7, density7, companion13.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, companion13.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl7, viewConfiguration7, companion13.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-419477280);
            if (str3 != null) {
                Modifier.Companion companion14 = Modifier.INSTANCE;
                SpacerKt.Spacer(SizeKt.m469width3ABfNKs(companion14, Dp.m3843constructorimpl(f)), composerStartRestartGroup, 6);
                SingletonAsyncImageKt.m4344AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m464size3ABfNKs(companion14, Dp.m3843constructorimpl(36)), roundedCornerShapeM673RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextKt.m1246TextfLXpl1I(str2, PaddingKt.m424paddingVpY3zN4(Modifier.INSTANCE, Dp.m3843constructorimpl(15), Dp.m3843constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composerStartRestartGroup, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier10;
        }
        str4 = str3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new a(modifier2, str4, str2, j, j2, function0, i, i2));
    }

    public static final long a() {
        return f6437a;
    }
}
