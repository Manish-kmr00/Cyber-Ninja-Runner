package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1", f = "LifecycleAwareAdCountdownButton.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6771a;
        public final /* synthetic */ State<UInt> b;
        public final /* synthetic */ State<Function0<Unit>> c;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$a, reason: collision with other inner class name */
        public static final class C0633a extends Lambda implements Function0<UInt> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ State<UInt> f6772a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0633a(State<UInt> state) {
                super(0);
                this.f6772a = state;
            }

            public final int a() {
                return t.a(this.f6772a);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ UInt invoke() {
                return UInt.m7995boximpl(a());
            }
        }

        public static final class b implements FlowCollector<UInt> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ State<Function0<Unit>> f6773a;

            /* JADX WARN: Multi-variable type inference failed */
            public b(State<? extends Function0<Unit>> state) {
                this.f6773a = state;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                t.b(this.f6773a).invoke();
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(UInt uInt, Continuation continuation) {
                return a(uInt.getData(), continuation);
            }
        }

        public static final class c implements Flow<UInt> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Flow f6774a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$c$a, reason: collision with other inner class name */
            public static final class C0634a<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f6775a;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$c$a$a, reason: collision with other inner class name */
                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1$invokeSuspend$$inlined$filter$1$2", f = "LifecycleAwareAdCountdownButton.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                public static final class C0635a extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f6776a;
                    public int b;
                    public Object c;
                    public Object d;

                    public C0635a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6776a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return C0634a.this.emit(null, this);
                    }
                }

                public C0634a(FlowCollector flowCollector) {
                    this.f6775a = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) throws Throwable {
                    C0635a c0635a;
                    if (continuation instanceof C0635a) {
                        c0635a = (C0635a) continuation;
                        int i = c0635a.b;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0635a.b = i - Integer.MIN_VALUE;
                        } else {
                            c0635a = new C0635a(continuation);
                        }
                    } else {
                        c0635a = new C0635a(continuation);
                    }
                    Object obj2 = c0635a.f6776a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0635a.b;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.f6775a;
                        if (((UInt) obj).getData() == 0) {
                            c0635a.b = 1;
                            if (flowCollector.emit(obj, c0635a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public c(Flow flow) {
                this.f6774a = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super UInt> flowCollector, Continuation continuation) {
                Object objCollect = this.f6774a.collect(new C0634a(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(State<UInt> state, State<? extends Function0<Unit>> state2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = state;
            this.c = state2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6771a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar = new c(SnapshotStateKt.snapshotFlow(new C0633a(this.b)));
                b bVar = new b(this.c);
                this.f6771a = 1;
                if (cVar.collect(bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BoxScope f6777a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<UInt> b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> g;
        public final /* synthetic */ Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<UInt> mVar, boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function1, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function2, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, boolean z3, int i) {
            super(2);
            this.f6777a = boxScope;
            this.b = mVar;
            this.c = z;
            this.d = z2;
            this.e = function0;
            this.f = function1;
            this.g = function2;
            this.h = function10;
            this.i = z3;
            this.j = i;
        }

        public final void a(Composer composer, int i) {
            t.a(this.f6777a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, composer, this.j | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final void a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<UInt> initialSecondsLeft, boolean z, boolean z2, Function0<Unit> onCountdownFinished, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> basedOnAdCountdownButton, boolean z3, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(initialSecondsLeft, "initialSecondsLeft");
        Intrinsics.checkNotNullParameter(onCountdownFinished, "onCountdownFinished");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(basedOnAdCountdownButton, "basedOnAdCountdownButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1386467363);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(initialSecondsLeft) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(onCountdownFinished) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i2 |= composerStartRestartGroup.changed(onClick) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(onButtonRendered) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(basedOnAdCountdownButton) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
        }
        int i3 = i2;
        if ((191739611 & i3) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1386467363, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButton (LifecycleAwareAdCountdownButton.kt:24)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(initialSecondsLeft);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g.a(initialSecondsLeft.a().getData(), coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle((StateFlow) objRememberedValue2, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 8, 7);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onCountdownFinished, composerStartRestartGroup, (i3 >> 12) & 14);
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(stateCollectAsStateWithLifecycle, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 70);
            Boolean boolValueOf = Boolean.valueOf(z2);
            Boolean boolValueOf2 = Boolean.valueOf(z);
            Boolean boolValueOf3 = Boolean.valueOf(z3);
            UInt uIntA = initialSecondsLeft.a();
            UInt uIntM7995boximpl = UInt.m7995boximpl(a(stateCollectAsStateWithLifecycle));
            int i4 = i3 & 14;
            int i5 = i3 >> 6;
            composer2 = composerStartRestartGroup;
            basedOnAdCountdownButton.invoke(boxScope, boolValueOf, boolValueOf2, onClick, onButtonRendered, boolValueOf3, uIntA, uIntM7995boximpl, composer2, Integer.valueOf(i4 | (i5 & 112) | (i3 & 896) | (i5 & 7168) | (i5 & 57344) | ((i3 >> 9) & 458752) | ((i3 << 3) & 234881024)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(boxScope, initialSecondsLeft, z, z2, onCountdownFinished, onClick, onButtonRendered, basedOnAdCountdownButton, z3, i));
    }

    public static final Function0<Unit> b(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    public static final int a(State<UInt> state) {
        return state.getValue().getData();
    }
}
