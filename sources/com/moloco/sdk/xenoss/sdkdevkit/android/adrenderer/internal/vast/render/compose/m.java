package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes10.dex */
public final class m {

    public static final class a extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7008a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.f7008a = i;
        }

        public final void a(Composer composer, int i) {
            m.a(composer, this.f7008a | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBarKt$VastProgressBar$1", f = "VastProgressBar.kt", i = {}, l = {43, 45, 53}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7009a;
        public final /* synthetic */ Animatable<Float, AnimationVector1D> b;
        public final /* synthetic */ float c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Animatable<Float, AnimationVector1D> animatable, float f, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = animatable;
            this.c = f;
            this.d = z;
            this.e = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7009a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.b;
            Float fBoxFloat = Boxing.boxFloat(this.c);
            this.f7009a = 1;
            if (animatable.snapTo(fBoxFloat, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (this.d && (this.e instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c)) {
                Animatable<Float, AnimationVector1D> animatable2 = this.b;
                Float fBoxFloat2 = Boxing.boxFloat(1.0f);
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(m.c(this.e), 0, EasingKt.getLinearEasing(), 2, null);
                this.f7009a = 2;
                if (Animatable.animateTo$default(animatable2, fBoxFloat2, tweenSpecTween$default, null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Animatable<Float, AnimationVector1D> animatable3 = this.b;
                this.f7009a = 3;
                if (animatable3.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<DrawScope, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f7010a;
        public final /* synthetic */ float b;
        public final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Animatable<Float, AnimationVector1D> animatable, float f, long j) {
            super(1);
            this.f7010a = animatable;
            this.b = f;
            this.c = j;
        }

        public final void a(DrawScope drawBehind) {
            Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
            long jSize = SizeKt.Size(this.f7010a.getValue().floatValue() * Size.m1464getWidthimpl(drawBehind.mo2125getSizeNHjbRc()), Size.m1461getHeightimpl(drawBehind.mo2125getSizeNHjbRc()));
            float f = this.b;
            DrawScope.m2122drawRoundRectuAw5IA$default(drawBehind, this.c, 0L, jSize, CornerRadiusKt.CornerRadius(f, f), null, 0.0f, null, 0, 242, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            a(drawScope);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7011a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i b;
        public final /* synthetic */ Modifier c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Modifier modifier, long j, int i, int i2) {
            super(2);
            this.f7011a = z;
            this.b = iVar;
            this.c = modifier;
            this.d = j;
            this.e = i;
            this.f = i2;
        }

        public final void a(Composer composer, int i) {
            m.a(this.f7011a, this.b, this.c, this.d, composer, this.e | 1, this.f);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<MutableState<Float>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7012a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableState<Float> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        }
    }

    public static final int c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a) {
            return 0;
        }
        if (iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) iVar;
            if (cVar.d() == 0) {
                return 0;
            }
            return RangesKt.coerceAtLeast((int) (cVar.d() - cVar.c()), 0);
        }
        if ((iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d) || Intrinsics.areEqual(iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b)) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:70:0x010a  */
    /* JADX WARN: Code duplicated, block: B:73:0x0167  */
    /* JADX WARN: Code duplicated, block: B:78:0x0173  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, Modifier modifier, long j, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long jM979getPrimary0d7_KjU;
        float fMax;
        Object objRememberedValue;
        long j2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer composerStartRestartGroup = composer.startRestartGroup(632891183);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(progress) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    jM979getPrimary0d7_KjU = j;
                    int i5 = composerStartRestartGroup.changed(jM979getPrimary0d7_KjU) ? 2048 : 1024;
                    i3 |= i5;
                } else {
                    jM979getPrimary0d7_KjU = j;
                }
                i3 |= i5;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                        i3 &= -7169;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                }
                Modifier modifier4 = modifier2;
                long j3 = jM979getPrimary0d7_KjU;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(632891183, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBar (VastProgressBar.kt:25)");
                }
                float f = 4;
                float fM3843constructorimpl = Dp.m3843constructorimpl(f);
                MutableState mutableState = (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) e.f7012a, composerStartRestartGroup, 3080, 6);
                fMax = Math.max(b(progress), a((MutableState<Float>) mutableState));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimatableKt.Animatable$default(fMax, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Animatable animatable = (Animatable) objRememberedValue;
                a((MutableState<Float>) mutableState, ((Number) animatable.getValue()).floatValue());
                int i6 = i3;
                EffectsKt.LaunchedEffect(progress, Boolean.valueOf(z), new b(animatable, fMax, z, progress, null), composerStartRestartGroup, ((i6 >> 3) & 14) | 512 | ((i6 << 3) & 112));
                BoxKt.Box(DrawModifierKt.drawBehind(androidx.compose.foundation.layout.SizeKt.m450height3ABfNKs(modifier4, Dp.m3843constructorimpl(f)), new c(animatable, fM3843constructorimpl, j3)), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM979getPrimary0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new d(z, progress, modifier3, j2, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM979getPrimary0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM979getPrimary0d7_KjU)) {
                }
                i3 |= i5;
            } else {
                jM979getPrimary0d7_KjU = j;
            }
            i3 |= i5;
        } else {
            jM979getPrimary0d7_KjU = j;
        }
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
            }
            Modifier modifier5 = modifier2;
            long j4 = jM979getPrimary0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632891183, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBar (VastProgressBar.kt:25)");
            }
            float f2 = 4;
            float fM3843constructorimpl2 = Dp.m3843constructorimpl(f2);
            MutableState mutableState2 = (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) e.f7012a, composerStartRestartGroup, 3080, 6);
            fMax = Math.max(b(progress), a((MutableState<Float>) mutableState2));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(fMax, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Animatable animatable2 = (Animatable) objRememberedValue;
            a((MutableState<Float>) mutableState2, ((Number) animatable2.getValue()).floatValue());
            int i7 = i3;
            EffectsKt.LaunchedEffect(progress, Boolean.valueOf(z), new b(animatable2, fMax, z, progress, null), composerStartRestartGroup, ((i7 >> 3) & 14) | 512 | ((i7 << 3) & 112));
            BoxKt.Box(DrawModifierKt.drawBehind(androidx.compose.foundation.layout.SizeKt.m450height3ABfNKs(modifier5, Dp.m3843constructorimpl(f2)), new c(animatable2, fM3843constructorimpl2, j4)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    jM979getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m979getPrimary0d7_KjU();
                    i3 &= -7169;
                }
            }
            Modifier modifier6 = modifier2;
            long j5 = jM979getPrimary0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632891183, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBar (VastProgressBar.kt:25)");
            }
            float f3 = 4;
            float fM3843constructorimpl3 = Dp.m3843constructorimpl(f3);
            MutableState mutableState3 = (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) e.f7012a, composerStartRestartGroup, 3080, 6);
            fMax = Math.max(b(progress), a((MutableState<Float>) mutableState3));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(fMax, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Animatable animatable3 = (Animatable) objRememberedValue;
            a((MutableState<Float>) mutableState3, ((Number) animatable3.getValue()).floatValue());
            int i8 = i3;
            EffectsKt.LaunchedEffect(progress, Boolean.valueOf(z), new b(animatable3, fMax, z, progress, null), composerStartRestartGroup, ((i8 >> 3) & 14) | 512 | ((i8 << 3) & 112));
            BoxKt.Box(DrawModifierKt.drawBehind(androidx.compose.foundation.layout.SizeKt.m450height3ABfNKs(modifier6, Dp.m3843constructorimpl(f3)), new c(animatable3, fM3843constructorimpl3, j5)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j5;
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(z, progress, modifier3, j2, i, i2));
    }

    public static final float b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a) {
            return 100.0f;
        }
        if (iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) iVar;
            if (cVar.d() != 0) {
                return (float) (cVar.c() / cVar.d());
            }
        } else if (!(iVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d) && !Intrinsics.areEqual(iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b)) {
            throw new NoWhenBranchMatchedException();
        }
        return 0.0f;
    }

    public static final void a(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    public static final void a(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1397199635);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397199635, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.Preview (VastProgressBar.kt:98)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.f6976a.a(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new a(i));
    }

    public static final float a(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }
}
