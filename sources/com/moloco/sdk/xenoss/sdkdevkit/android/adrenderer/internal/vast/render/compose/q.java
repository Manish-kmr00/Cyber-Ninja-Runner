package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.json.mediationsdk.logger.IronSourceError;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import com.ogury.ad.OguryBidTokenErrorCode;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineContext f7041a = com.moloco.sdk.internal.scheduling.b.a().getMain();

    public static final class a extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d f7042a;
        public final /* synthetic */ CoroutineScope b;
        public final /* synthetic */ MutableState<Boolean> c;
        public final /* synthetic */ MutableState<Boolean> d;
        public final /* synthetic */ State<Function1<Boolean, Unit>> e;
        public final /* synthetic */ State<Function1<Boolean, Unit>> f;
        public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> g;
        public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> h;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$a$a, reason: collision with other inner class name */
        public static final class C0677a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f7043a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
            public final /* synthetic */ State c;

            public C0677a(List list, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, State state) {
                this.f7043a = list;
                this.b = dVar;
                this.c = state;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Iterator it = this.f7043a.iterator();
                while (it.hasNext()) {
                    Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
                }
                this.b.destroy();
                q.a(this.c).invoke(Boolean.FALSE);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7044a;
            public /* synthetic */ Object b;
            public final /* synthetic */ MutableState<Boolean> c;
            public final /* synthetic */ MutableState<Boolean> d;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d e;
            public final /* synthetic */ State<Function1<Boolean, Unit>> f;
            public final /* synthetic */ State<Function1<Boolean, Unit>> g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, State<? extends Function1<? super Boolean, Unit>> state, State<? extends Function1<? super Boolean, Unit>> state2, Continuation<? super b> continuation) {
                super(2, continuation);
                this.c = mutableState;
                this.d = mutableState2;
                this.e = dVar;
                this.f = state;
                this.g = state2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a aVar, Continuation<? super Unit> continuation) {
                return ((b) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(this.c, this.d, this.e, this.f, this.g, continuation);
                bVar.b = obj;
                return bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7044a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a) this.b;
                q.a(this.f).invoke(Boxing.boxBoolean(aVar.e()));
                this.c.setValue(Boxing.boxBoolean(aVar.e()));
                this.d.setValue(Boxing.boxBoolean(aVar.d()));
                q.b(this.g).invoke(Boxing.boxBoolean(aVar.f()));
                View viewM = this.e.M();
                if (viewM != null) {
                    viewM.setKeepScreenOn(aVar.d());
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$2", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7045a;
            public /* synthetic */ Object b;
            public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> state, Continuation<? super c> continuation) {
                super(2, continuation);
                this.c = state;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Continuation<? super Unit> continuation) {
                return ((c) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                c cVar = new c(this.c, continuation);
                cVar.b = obj;
                return cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7045a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                q.c(this.c).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) this.b);
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$3", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class d extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7046a;
            public /* synthetic */ Object b;
            public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> state, Continuation<? super d> continuation) {
                super(2, continuation);
                this.c = state;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar, Continuation<? super Unit> continuation) {
                return ((d) create(lVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                d dVar = new d(this.c, continuation);
                dVar.b = obj;
                return dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7046a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                q.d(this.c).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l) this.b);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, State<? extends Function1<? super Boolean, Unit>> state, State<? extends Function1<? super Boolean, Unit>> state2, State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> state3, State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> state4) {
            super(1);
            this.f7042a = dVar;
            this.b = coroutineScope;
            this.c = mutableState;
            this.d = mutableState2;
            this.e = state;
            this.f = state2;
            this.g = state3;
            this.h = state4;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            return new C0677a(CollectionsKt.listOf((Object[]) new Job[]{FlowKt.launchIn(FlowKt.onEach(this.f7042a.isPlaying(), new b(this.c, this.d, this.f7042a, this.e, this.f, null)), this.b), FlowKt.launchIn(FlowKt.onEach(this.f7042a.o(), new c(this.g, null)), this.b), FlowKt.launchIn(FlowKt.onEach(FlowKt.filterNotNull(this.f7042a.e()), new d(this.h, null)), this.b)}), this.f7042a, this.e);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$2", f = "VastVideoPlayer.kt", i = {0, 1}, l = {112, 114}, m = "invokeSuspend", n = {"view", "view"}, s = {"L$0", "L$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7047a;
        public int b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0062  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            View viewM;
            View view;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    View view2 = (View) this.f7047a;
                    ResultKt.throwOnFailure(obj);
                    viewM = view2;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    view = (View) this.f7047a;
                    ResultKt.throwOnFailure(obj);
                }
                if (view != null) {
                    view.setVisibility(4);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            viewM = this.c.M();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar = this.c;
            if (viewM != null) {
                viewM.setVisibility(4);
            }
            this.f7047a = viewM;
            this.b = 1;
            if (dVar.a(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (viewM != null) {
                viewM.setVisibility(0);
            }
            this.f7047a = viewM;
            this.b = 2;
            if (DelayKt.delay(50L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            view = viewM;
            if (view != null) {
                view.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3", f = "VastVideoPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7048a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> e;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7049a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
            public final /* synthetic */ String c;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> d;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = dVar;
                this.c = str;
                this.d = mVar;
                this.e = mVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7049a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar = this.b;
                String str = this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar = this.d;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2 = this.e;
                dVar.a(str);
                dVar.seekTo(mVar.a().longValue());
                q.b(dVar, mVar2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = dVar;
            this.c = str;
            this.d = mVar;
            this.e = mVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7048a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f7041a;
                a aVar = new a(this.b, this.c, this.d, this.e, null);
                this.f7048a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4", f = "VastVideoPlayer.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7050a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7051a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = dVar;
                this.c = mVar;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7051a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                q.b(this.b, this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = dVar;
            this.c = mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7050a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f7041a;
                a aVar = new a(this.b, this.c, null);
                this.f7050a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5", f = "VastVideoPlayer.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7052a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
        public final /* synthetic */ boolean c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7053a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d b;
            public final /* synthetic */ boolean c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, boolean z, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = dVar;
                this.c = z;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7053a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.a(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, boolean z, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = dVar;
            this.c = z;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7052a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f7041a;
                a aVar = new a(this.b, this.c, null);
                this.f7052a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
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

    public static final class f extends Lambda implements Function1<Context, FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(1);
            this.f7054a = view;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FrameLayout invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            FrameLayout frameLayout = new FrameLayout(it);
            frameLayout.addView(this.f7054a, new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
    }

    public static final class g extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7055a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Function1<Boolean, Unit> f;
        public final /* synthetic */ Function1<Boolean, Unit> g;
        public final /* synthetic */ j0 h;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> i;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> j;
        public final /* synthetic */ Modifier k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(String str, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar2, boolean z2, Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function2, j0 j0Var, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> function3, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> function4, Modifier modifier, int i, int i2, int i3) {
            super(2);
            this.f7055a = str;
            this.b = z;
            this.c = mVar;
            this.d = mVar2;
            this.e = z2;
            this.f = function1;
            this.g = function2;
            this.h = j0Var;
            this.i = function3;
            this.j = function4;
            this.k = modifier;
            this.l = i;
            this.m = i2;
            this.n = i3;
        }

        public final void a(Composer composer, int i) {
            q.a(this.f7055a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, composer, this.l | 1, this.m, this.n);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<MutableState<Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f7056a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableState<Boolean> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }
    }

    public static final class i extends Lambda implements Function0<MutableState<Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f7057a = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableState<Boolean> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }
    }

    public static final void b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar) {
        if (mVar.a().booleanValue()) {
            dVar.play();
        } else {
            dVar.pause();
        }
    }

    public static final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> c(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> state) {
        return (Function1) state.getValue();
    }

    public static final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> d(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> state) {
        return (Function1) state.getValue();
    }

    public static final Function1<Boolean, Unit> b(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0136  */
    /* JADX WARN: Code duplicated, block: B:102:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x0140  */
    /* JADX WARN: Code duplicated, block: B:106:0x0147  */
    /* JADX WARN: Code duplicated, block: B:108:0x014d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x0156  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0169  */
    /* JADX WARN: Code duplicated, block: B:122:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0184  */
    /* JADX WARN: Code duplicated, block: B:127:0x018c  */
    /* JADX WARN: Code duplicated, block: B:130:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:132:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:135:0x0204  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:142:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:146:0x0307  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x0107  */
    /* JADX WARN: Code duplicated, block: B:85:0x010e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0112  */
    /* JADX WARN: Code duplicated, block: B:89:0x0117  */
    /* JADX WARN: Code duplicated, block: B:91:0x011d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0120  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127  */
    /* JADX WARN: Code duplicated, block: B:97:0x012b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0130  */
    public static final void a(String uri, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> play, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> seekToMillis, boolean z2, Function1<? super Boolean, Unit> isPlaying, Function1<? super Boolean, Unit> isVisible, j0 viewVisibilityTracker, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> onProgressChanged, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> onError, Modifier modifier, Composer composer, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        Context context;
        Lifecycle lifecycle;
        int i14;
        boolean zChanged;
        Object objRememberedValue;
        Object objRememberedValue2;
        Composer composer2;
        View viewM;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(seekToMillis, "seekToMillis");
        Intrinsics.checkNotNullParameter(isPlaying, "isPlaying");
        Intrinsics.checkNotNullParameter(isVisible, "isVisible");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Composer composerStartRestartGroup = composer.startRestartGroup(32444032);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(uri) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(play) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(seekToMillis) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((57344 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i4 & 32) == 0) {
            if ((458752 & i2) == 0) {
                i6 = composerStartRestartGroup.changed(isPlaying) ? 131072 : 65536;
            }
            if ((i4 & 64) != 0) {
                if ((3670016 & i2) == 0) {
                    if (composerStartRestartGroup.changed(isVisible)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                }
                if ((i4 & 128) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changed(viewVisibilityTracker)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                    }
                    if ((i4 & 256) != 0) {
                        if ((234881024 & i2) == 0) {
                            if (composerStartRestartGroup.changed(onProgressChanged)) {
                                i9 = 67108864;
                            } else {
                                i9 = 33554432;
                            }
                        }
                        if ((i4 & 512) != 0) {
                            if ((1879048192 & i2) == 0) {
                                if (composerStartRestartGroup.changed(onError)) {
                                    i10 = 536870912;
                                } else {
                                    i10 = 268435456;
                                }
                            }
                            i11 = i4 & 1024;
                            if (i11 != 0) {
                                i12 = i3 | 6;
                            } else if ((i3 & 14) == 0) {
                                if (composerStartRestartGroup.changed(modifier)) {
                                    i13 = 4;
                                } else {
                                    i13 = 2;
                                }
                                i12 = i3 | i13;
                            } else {
                                i12 = i3;
                            }
                            if ((i5 & 1533916891) != 306783378 && (i12 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                composer2 = composerStartRestartGroup;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                                }
                                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                                Boolean boolValueOf = Boolean.valueOf(z);
                                i14 = i12;
                                composerStartRestartGroup.startReplaceableGroup(1618982084);
                                zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                                composerStartRestartGroup.startReplaceableGroup(773894976);
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                                composerStartRestartGroup.endReplaceableGroup();
                                EffectsKt.DisposableEffect(dVar, new a(dVar, coroutineScope, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar, null), composerStartRestartGroup, 70);
                                int i15 = i5;
                                c cVar = new c(dVar, uri, seekToMillis, play, null);
                                int i16 = i15 >> 3;
                                EffectsKt.LaunchedEffect(dVar, uri, seekToMillis, cVar, composerStartRestartGroup, ((i15 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i16 & 896));
                                composer2 = composerStartRestartGroup;
                                EffectsKt.LaunchedEffect(dVar, play, new d(dVar, play, null), composer2, (i16 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                                EffectsKt.LaunchedEffect(dVar, Boolean.valueOf(z2), new e(dVar, z2, null), composer2, ((i15 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                                viewM = dVar.M();
                                if (viewM != null) {
                                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                        }
                        i10 = C.ENCODING_PCM_32BIT;
                        i5 |= i10;
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            if (composerStartRestartGroup.changed(modifier)) {
                                i13 = 4;
                            } else {
                                i13 = 2;
                            }
                            i12 = i3 | i13;
                        } else {
                            i12 = i3;
                        }
                        if ((i5 & 1533916891) != 306783378) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf2 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller2;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar2, new a(dVar2, coroutineScope2, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar2, null), composerStartRestartGroup, 70);
                            int i17 = i5;
                            c cVar2 = new c(dVar2, uri, seekToMillis, play, null);
                            int i18 = i17 >> 3;
                            EffectsKt.LaunchedEffect(dVar2, uri, seekToMillis, cVar2, composerStartRestartGroup, ((i17 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i18 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar2, play, new d(dVar2, play, null), composer2, (i18 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar2, Boolean.valueOf(z2), new e(dVar2, z2, null), composer2, ((i17 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar2.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf3 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller3;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar3, new a(dVar3, coroutineScope3, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar3, null), composerStartRestartGroup, 70);
                            int i19 = i5;
                            c cVar3 = new c(dVar3, uri, seekToMillis, play, null);
                            int i110 = i19 >> 3;
                            EffectsKt.LaunchedEffect(dVar3, uri, seekToMillis, cVar3, composerStartRestartGroup, ((i19 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i110 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar3, play, new d(dVar3, play, null), composer2, (i110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar3, Boolean.valueOf(z2), new e(dVar3, z2, null), composer2, ((i19 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar3.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                    }
                    i9 = 100663296;
                    i5 |= i9;
                    if ((i4 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changed(onError)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            if (composerStartRestartGroup.changed(modifier)) {
                                i13 = 4;
                            } else {
                                i13 = 2;
                            }
                            i12 = i3 | i13;
                        } else {
                            i12 = i3;
                        }
                        if ((i5 & 1533916891) != 306783378) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf4 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar4 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller4;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar4, new a(dVar4, coroutineScope4, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar4, null), composerStartRestartGroup, 70);
                            int i111 = i5;
                            c cVar4 = new c(dVar4, uri, seekToMillis, play, null);
                            int i112 = i111 >> 3;
                            EffectsKt.LaunchedEffect(dVar4, uri, seekToMillis, cVar4, composerStartRestartGroup, ((i111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i112 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar4, play, new d(dVar4, play, null), composer2, (i112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar4, Boolean.valueOf(z2), new e(dVar4, z2, null), composer2, ((i111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar4.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf5 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller5;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar5, new a(dVar5, coroutineScope5, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar5, null), composerStartRestartGroup, 70);
                            int i113 = i5;
                            c cVar5 = new c(dVar5, uri, seekToMillis, play, null);
                            int i114 = i113 >> 3;
                            EffectsKt.LaunchedEffect(dVar5, uri, seekToMillis, cVar5, composerStartRestartGroup, ((i113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i114 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar5, play, new d(dVar5, play, null), composer2, (i114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar5, Boolean.valueOf(z2), new e(dVar5, z2, null), composer2, ((i113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar5.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i5 |= i10;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf6 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller6;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar6, new a(dVar6, coroutineScope6, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar6, null), composerStartRestartGroup, 70);
                        int i115 = i5;
                        c cVar6 = new c(dVar6, uri, seekToMillis, play, null);
                        int i116 = i115 >> 3;
                        EffectsKt.LaunchedEffect(dVar6, uri, seekToMillis, cVar6, composerStartRestartGroup, ((i115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i116 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar6, play, new d(dVar6, play, null), composer2, (i116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar6, Boolean.valueOf(z2), new e(dVar6, z2, null), composer2, ((i115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar6.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf7 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller7;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar7, new a(dVar7, coroutineScope7, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar7, null), composerStartRestartGroup, 70);
                        int i117 = i5;
                        c cVar7 = new c(dVar7, uri, seekToMillis, play, null);
                        int i118 = i117 >> 3;
                        EffectsKt.LaunchedEffect(dVar7, uri, seekToMillis, cVar7, composerStartRestartGroup, ((i117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i118 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar7, play, new d(dVar7, play, null), composer2, (i118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar7, Boolean.valueOf(z2), new e(dVar7, z2, null), composer2, ((i117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar7.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i8 = 12582912;
                i5 |= i8;
                if ((i4 & 256) != 0) {
                    if ((234881024 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onProgressChanged)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i4 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changed(onError)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            if (composerStartRestartGroup.changed(modifier)) {
                                i13 = 4;
                            } else {
                                i13 = 2;
                            }
                            i12 = i3 | i13;
                        } else {
                            i12 = i3;
                        }
                        if ((i5 & 1533916891) != 306783378) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf8 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf8) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar8 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller8;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar8, new a(dVar8, coroutineScope8, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar8, null), composerStartRestartGroup, 70);
                            int i119 = i5;
                            c cVar8 = new c(dVar8, uri, seekToMillis, play, null);
                            int i1110 = i119 >> 3;
                            EffectsKt.LaunchedEffect(dVar8, uri, seekToMillis, cVar8, composerStartRestartGroup, ((i119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1110 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar8, play, new d(dVar8, play, null), composer2, (i1110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar8, Boolean.valueOf(z2), new e(dVar8, z2, null), composer2, ((i119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar8.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf9 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf9) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar9 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller9;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar9, new a(dVar9, coroutineScope9, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar9, null), composerStartRestartGroup, 70);
                            int i1111 = i5;
                            c cVar9 = new c(dVar9, uri, seekToMillis, play, null);
                            int i1112 = i1111 >> 3;
                            EffectsKt.LaunchedEffect(dVar9, uri, seekToMillis, cVar9, composerStartRestartGroup, ((i1111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1112 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar9, play, new d(dVar9, play, null), composer2, (i1112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar9, Boolean.valueOf(z2), new e(dVar9, z2, null), composer2, ((i1111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar9.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i5 |= i10;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf10 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf10) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar10 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller10;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar10, new a(dVar10, coroutineScope10, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar10, null), composerStartRestartGroup, 70);
                        int i1113 = i5;
                        c cVar10 = new c(dVar10, uri, seekToMillis, play, null);
                        int i1114 = i1113 >> 3;
                        EffectsKt.LaunchedEffect(dVar10, uri, seekToMillis, cVar10, composerStartRestartGroup, ((i1113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1114 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar10, play, new d(dVar10, play, null), composer2, (i1114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar10, Boolean.valueOf(z2), new e(dVar10, z2, null), composer2, ((i1113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar10.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf11 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf11) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller11;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar11, new a(dVar11, coroutineScope11, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11, null), composerStartRestartGroup, 70);
                        int i1115 = i5;
                        c cVar11 = new c(dVar11, uri, seekToMillis, play, null);
                        int i1116 = i1115 >> 3;
                        EffectsKt.LaunchedEffect(dVar11, uri, seekToMillis, cVar11, composerStartRestartGroup, ((i1115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1116 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar11, play, new d(dVar11, play, null), composer2, (i1116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar11, Boolean.valueOf(z2), new e(dVar11, z2, null), composer2, ((i1115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar11.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i9 = 100663296;
                i5 |= i9;
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf12 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf12) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar12 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller12;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar12, new a(dVar12, coroutineScope12, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar12, null), composerStartRestartGroup, 70);
                        int i1117 = i5;
                        c cVar12 = new c(dVar12, uri, seekToMillis, play, null);
                        int i1118 = i1117 >> 3;
                        EffectsKt.LaunchedEffect(dVar12, uri, seekToMillis, cVar12, composerStartRestartGroup, ((i1117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1118 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar12, play, new d(dVar12, play, null), composer2, (i1118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar12, Boolean.valueOf(z2), new e(dVar12, z2, null), composer2, ((i1117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar12.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf13 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf13) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar13 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller13;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar13, new a(dVar13, coroutineScope13, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar13, null), composerStartRestartGroup, 70);
                        int i1119 = i5;
                        c cVar13 = new c(dVar13, uri, seekToMillis, play, null);
                        int i11110 = i1119 >> 3;
                        EffectsKt.LaunchedEffect(dVar13, uri, seekToMillis, cVar13, composerStartRestartGroup, ((i1119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11110 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar13, play, new d(dVar13, play, null), composer2, (i11110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar13, Boolean.valueOf(z2), new e(dVar13, z2, null), composer2, ((i1119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar13.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf14 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf14) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar14 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller14;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar14, new a(dVar14, coroutineScope14, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar14, null), composerStartRestartGroup, 70);
                    int i11111 = i5;
                    c cVar14 = new c(dVar14, uri, seekToMillis, play, null);
                    int i11112 = i11111 >> 3;
                    EffectsKt.LaunchedEffect(dVar14, uri, seekToMillis, cVar14, composerStartRestartGroup, ((i11111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11112 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar14, play, new d(dVar14, play, null), composer2, (i11112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar14, Boolean.valueOf(z2), new e(dVar14, z2, null), composer2, ((i11111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar14.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf15 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf15) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar15 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller15;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar15, new a(dVar15, coroutineScope15, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar15, null), composerStartRestartGroup, 70);
                    int i11113 = i5;
                    c cVar15 = new c(dVar15, uri, seekToMillis, play, null);
                    int i11114 = i11113 >> 3;
                    EffectsKt.LaunchedEffect(dVar15, uri, seekToMillis, cVar15, composerStartRestartGroup, ((i11113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11114 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar15, play, new d(dVar15, play, null), composer2, (i11114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar15, Boolean.valueOf(z2), new e(dVar15, z2, null), composer2, ((i11113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar15.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i7 = 1572864;
            i5 |= i7;
            if ((i4 & 128) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changed(viewVisibilityTracker)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((i4 & 256) != 0) {
                    if ((234881024 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onProgressChanged)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i4 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changed(onError)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            if (composerStartRestartGroup.changed(modifier)) {
                                i13 = 4;
                            } else {
                                i13 = 2;
                            }
                            i12 = i3 | i13;
                        } else {
                            i12 = i3;
                        }
                        if ((i5 & 1533916891) != 306783378) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf16 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf16) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar16 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller16;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope16 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar16, new a(dVar16, coroutineScope16, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar16, null), composerStartRestartGroup, 70);
                            int i11115 = i5;
                            c cVar16 = new c(dVar16, uri, seekToMillis, play, null);
                            int i11116 = i11115 >> 3;
                            EffectsKt.LaunchedEffect(dVar16, uri, seekToMillis, cVar16, composerStartRestartGroup, ((i11115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11116 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar16, play, new d(dVar16, play, null), composer2, (i11116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar16, Boolean.valueOf(z2), new e(dVar16, z2, null), composer2, ((i11115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar16.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf17 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf17) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar17 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller17 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller17);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller17;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope17 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar17, new a(dVar17, coroutineScope17, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar17, null), composerStartRestartGroup, 70);
                            int i11117 = i5;
                            c cVar17 = new c(dVar17, uri, seekToMillis, play, null);
                            int i11118 = i11117 >> 3;
                            EffectsKt.LaunchedEffect(dVar17, uri, seekToMillis, cVar17, composerStartRestartGroup, ((i11117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11118 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar17, play, new d(dVar17, play, null), composer2, (i11118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar17, Boolean.valueOf(z2), new e(dVar17, z2, null), composer2, ((i11117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar17.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i5 |= i10;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf18 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf18) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar18 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller18 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller18);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller18;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope18 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar18, new a(dVar18, coroutineScope18, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar18, null), composerStartRestartGroup, 70);
                        int i11119 = i5;
                        c cVar18 = new c(dVar18, uri, seekToMillis, play, null);
                        int i111110 = i11119 >> 3;
                        EffectsKt.LaunchedEffect(dVar18, uri, seekToMillis, cVar18, composerStartRestartGroup, ((i11119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111110 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar18, play, new d(dVar18, play, null), composer2, (i111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar18, Boolean.valueOf(z2), new e(dVar18, z2, null), composer2, ((i11119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar18.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf19 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf19) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar19 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller19 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller19);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller19;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope19 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar19, new a(dVar19, coroutineScope19, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar19, null), composerStartRestartGroup, 70);
                        int i111111 = i5;
                        c cVar19 = new c(dVar19, uri, seekToMillis, play, null);
                        int i111112 = i111111 >> 3;
                        EffectsKt.LaunchedEffect(dVar19, uri, seekToMillis, cVar19, composerStartRestartGroup, ((i111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111112 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar19, play, new d(dVar19, play, null), composer2, (i111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar19, Boolean.valueOf(z2), new e(dVar19, z2, null), composer2, ((i111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar19.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i9 = 100663296;
                i5 |= i9;
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf110 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf110) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar110 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller110);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller110;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar110, new a(dVar110, coroutineScope110, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar110, null), composerStartRestartGroup, 70);
                        int i111113 = i5;
                        c cVar110 = new c(dVar110, uri, seekToMillis, play, null);
                        int i111114 = i111113 >> 3;
                        EffectsKt.LaunchedEffect(dVar110, uri, seekToMillis, cVar110, composerStartRestartGroup, ((i111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111114 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar110, play, new d(dVar110, play, null), composer2, (i111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar110, Boolean.valueOf(z2), new e(dVar110, z2, null), composer2, ((i111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar110.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf111 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf111) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller111;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar111, new a(dVar111, coroutineScope111, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111, null), composerStartRestartGroup, 70);
                        int i111115 = i5;
                        c cVar111 = new c(dVar111, uri, seekToMillis, play, null);
                        int i111116 = i111115 >> 3;
                        EffectsKt.LaunchedEffect(dVar111, uri, seekToMillis, cVar111, composerStartRestartGroup, ((i111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111116 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar111, play, new d(dVar111, play, null), composer2, (i111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar111, Boolean.valueOf(z2), new e(dVar111, z2, null), composer2, ((i111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar111.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf112 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf112) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar112 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller112);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar112, new a(dVar112, coroutineScope112, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar112, null), composerStartRestartGroup, 70);
                    int i111117 = i5;
                    c cVar112 = new c(dVar112, uri, seekToMillis, play, null);
                    int i111118 = i111117 >> 3;
                    EffectsKt.LaunchedEffect(dVar112, uri, seekToMillis, cVar112, composerStartRestartGroup, ((i111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111118 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar112, play, new d(dVar112, play, null), composer2, (i111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar112, Boolean.valueOf(z2), new e(dVar112, z2, null), composer2, ((i111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar112.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf113 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf113) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar113 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller113);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar113, new a(dVar113, coroutineScope113, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar113, null), composerStartRestartGroup, 70);
                    int i111119 = i5;
                    c cVar113 = new c(dVar113, uri, seekToMillis, play, null);
                    int i1111110 = i111119 >> 3;
                    EffectsKt.LaunchedEffect(dVar113, uri, seekToMillis, cVar113, composerStartRestartGroup, ((i111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111110 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar113, play, new d(dVar113, play, null), composer2, (i1111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar113, Boolean.valueOf(z2), new e(dVar113, z2, null), composer2, ((i111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar113.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i8 = 12582912;
            i5 |= i8;
            if ((i4 & 256) != 0) {
                if ((234881024 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onProgressChanged)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf114 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf114) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar114 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller114);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller114;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar114, new a(dVar114, coroutineScope114, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar114, null), composerStartRestartGroup, 70);
                        int i1111111 = i5;
                        c cVar114 = new c(dVar114, uri, seekToMillis, play, null);
                        int i1111112 = i1111111 >> 3;
                        EffectsKt.LaunchedEffect(dVar114, uri, seekToMillis, cVar114, composerStartRestartGroup, ((i1111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111112 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar114, play, new d(dVar114, play, null), composer2, (i1111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar114, Boolean.valueOf(z2), new e(dVar114, z2, null), composer2, ((i1111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar114.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf115 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf115) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar115 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller115);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller115;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar115, new a(dVar115, coroutineScope115, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar115, null), composerStartRestartGroup, 70);
                        int i1111113 = i5;
                        c cVar115 = new c(dVar115, uri, seekToMillis, play, null);
                        int i1111114 = i1111113 >> 3;
                        EffectsKt.LaunchedEffect(dVar115, uri, seekToMillis, cVar115, composerStartRestartGroup, ((i1111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111114 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar115, play, new d(dVar115, play, null), composer2, (i1111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar115, Boolean.valueOf(z2), new e(dVar115, z2, null), composer2, ((i1111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar115.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf116 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf116) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar116 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller116);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller116;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar116, new a(dVar116, coroutineScope116, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar116, null), composerStartRestartGroup, 70);
                    int i1111115 = i5;
                    c cVar116 = new c(dVar116, uri, seekToMillis, play, null);
                    int i1111116 = i1111115 >> 3;
                    EffectsKt.LaunchedEffect(dVar116, uri, seekToMillis, cVar116, composerStartRestartGroup, ((i1111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111116 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar116, play, new d(dVar116, play, null), composer2, (i1111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar116, Boolean.valueOf(z2), new e(dVar116, z2, null), composer2, ((i1111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar116.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf117 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf117) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar117 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller117);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller117;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar117, new a(dVar117, coroutineScope117, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar117, null), composerStartRestartGroup, 70);
                    int i1111117 = i5;
                    c cVar117 = new c(dVar117, uri, seekToMillis, play, null);
                    int i1111118 = i1111117 >> 3;
                    EffectsKt.LaunchedEffect(dVar117, uri, seekToMillis, cVar117, composerStartRestartGroup, ((i1111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111118 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar117, play, new d(dVar117, play, null), composer2, (i1111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar117, Boolean.valueOf(z2), new e(dVar117, z2, null), composer2, ((i1111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar117.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i9 = 100663296;
            i5 |= i9;
            if ((i4 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onError)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf118 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf118) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar118 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller118);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller118;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar118, new a(dVar118, coroutineScope118, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar118, null), composerStartRestartGroup, 70);
                    int i1111119 = i5;
                    c cVar118 = new c(dVar118, uri, seekToMillis, play, null);
                    int i11111110 = i1111119 >> 3;
                    EffectsKt.LaunchedEffect(dVar118, uri, seekToMillis, cVar118, composerStartRestartGroup, ((i1111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111110 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar118, play, new d(dVar118, play, null), composer2, (i11111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar118, Boolean.valueOf(z2), new e(dVar118, z2, null), composer2, ((i1111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar118.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf119 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf119) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar119 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller119);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller119;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar119, new a(dVar119, coroutineScope119, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar119, null), composerStartRestartGroup, 70);
                    int i11111111 = i5;
                    c cVar119 = new c(dVar119, uri, seekToMillis, play, null);
                    int i11111112 = i11111111 >> 3;
                    EffectsKt.LaunchedEffect(dVar119, uri, seekToMillis, cVar119, composerStartRestartGroup, ((i11111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111112 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar119, play, new d(dVar119, play, null), composer2, (i11111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar119, Boolean.valueOf(z2), new e(dVar119, z2, null), composer2, ((i11111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar119.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i10 = C.ENCODING_PCM_32BIT;
            i5 |= i10;
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            if ((i5 & 1533916891) != 306783378) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf1110 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf1110) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1110 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1110);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller1110;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope1110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar1110, new a(dVar1110, coroutineScope1110, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1110, null), composerStartRestartGroup, 70);
                int i11111113 = i5;
                c cVar1110 = new c(dVar1110, uri, seekToMillis, play, null);
                int i11111114 = i11111113 >> 3;
                EffectsKt.LaunchedEffect(dVar1110, uri, seekToMillis, cVar1110, composerStartRestartGroup, ((i11111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111114 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar1110, play, new d(dVar1110, play, null), composer2, (i11111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar1110, Boolean.valueOf(z2), new e(dVar1110, z2, null), composer2, ((i11111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar1110.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf1111 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf1111) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1111 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope1111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar1111, new a(dVar1111, coroutineScope1111, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1111, null), composerStartRestartGroup, 70);
                int i11111115 = i5;
                c cVar1111 = new c(dVar1111, uri, seekToMillis, play, null);
                int i11111116 = i11111115 >> 3;
                EffectsKt.LaunchedEffect(dVar1111, uri, seekToMillis, cVar1111, composerStartRestartGroup, ((i11111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111116 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar1111, play, new d(dVar1111, play, null), composer2, (i11111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar1111, Boolean.valueOf(z2), new e(dVar1111, z2, null), composer2, ((i11111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar1111.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
        }
        i6 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i5 |= i6;
        if ((i4 & 64) != 0) {
            if ((3670016 & i2) == 0) {
                if (composerStartRestartGroup.changed(isVisible)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
            }
            if ((i4 & 128) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changed(viewVisibilityTracker)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                }
                if ((i4 & 256) != 0) {
                    if ((234881024 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onProgressChanged)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i4 & 512) != 0) {
                        if ((1879048192 & i2) == 0) {
                            if (composerStartRestartGroup.changed(onError)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        i11 = i4 & 1024;
                        if (i11 != 0) {
                            i12 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            if (composerStartRestartGroup.changed(modifier)) {
                                i13 = 4;
                            } else {
                                i13 = 2;
                            }
                            i12 = i3 | i13;
                        } else {
                            i12 = i3;
                        }
                        if ((i5 & 1533916891) != 306783378) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf1112 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf1112) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1112 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1112);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1112;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope1112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar1112, new a(dVar1112, coroutineScope1112, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1112, null), composerStartRestartGroup, 70);
                            int i11111117 = i5;
                            c cVar1112 = new c(dVar1112, uri, seekToMillis, play, null);
                            int i11111118 = i11111117 >> 3;
                            EffectsKt.LaunchedEffect(dVar1112, uri, seekToMillis, cVar1112, composerStartRestartGroup, ((i11111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111118 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar1112, play, new d(dVar1112, play, null), composer2, (i11111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar1112, Boolean.valueOf(z2), new e(dVar1112, z2, null), composer2, ((i11111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar1112.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                            }
                            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                            Boolean boolValueOf1113 = Boolean.valueOf(z);
                            i14 = i12;
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(boolValueOf1113) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1113 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1113);
                                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1113;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope1113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(dVar1113, new a(dVar1113, coroutineScope1113, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1113, null), composerStartRestartGroup, 70);
                            int i11111119 = i5;
                            c cVar1113 = new c(dVar1113, uri, seekToMillis, play, null);
                            int i111111110 = i11111119 >> 3;
                            EffectsKt.LaunchedEffect(dVar1113, uri, seekToMillis, cVar1113, composerStartRestartGroup, ((i11111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111110 & 896));
                            composer2 = composerStartRestartGroup;
                            EffectsKt.LaunchedEffect(dVar1113, play, new d(dVar1113, play, null), composer2, (i111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            EffectsKt.LaunchedEffect(dVar1113, Boolean.valueOf(z2), new e(dVar1113, z2, null), composer2, ((i11111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                            viewM = dVar1113.M();
                            if (viewM != null) {
                                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i5 |= i10;
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf1114 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf1114) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1114 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1114);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller1114;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope1114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar1114, new a(dVar1114, coroutineScope1114, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1114, null), composerStartRestartGroup, 70);
                        int i111111111 = i5;
                        c cVar1114 = new c(dVar1114, uri, seekToMillis, play, null);
                        int i111111112 = i111111111 >> 3;
                        EffectsKt.LaunchedEffect(dVar1114, uri, seekToMillis, cVar1114, composerStartRestartGroup, ((i111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111112 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar1114, play, new d(dVar1114, play, null), composer2, (i111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar1114, Boolean.valueOf(z2), new e(dVar1114, z2, null), composer2, ((i111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar1114.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf1115 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf1115) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1115 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1115);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller1115;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope1115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar1115, new a(dVar1115, coroutineScope1115, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1115, null), composerStartRestartGroup, 70);
                        int i111111113 = i5;
                        c cVar1115 = new c(dVar1115, uri, seekToMillis, play, null);
                        int i111111114 = i111111113 >> 3;
                        EffectsKt.LaunchedEffect(dVar1115, uri, seekToMillis, cVar1115, composerStartRestartGroup, ((i111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111114 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar1115, play, new d(dVar1115, play, null), composer2, (i111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar1115, Boolean.valueOf(z2), new e(dVar1115, z2, null), composer2, ((i111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar1115.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i9 = 100663296;
                i5 |= i9;
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf1116 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf1116) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1116 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1116);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller1116;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope1116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar1116, new a(dVar1116, coroutineScope1116, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1116, null), composerStartRestartGroup, 70);
                        int i111111115 = i5;
                        c cVar1116 = new c(dVar1116, uri, seekToMillis, play, null);
                        int i111111116 = i111111115 >> 3;
                        EffectsKt.LaunchedEffect(dVar1116, uri, seekToMillis, cVar1116, composerStartRestartGroup, ((i111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111116 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar1116, play, new d(dVar1116, play, null), composer2, (i111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar1116, Boolean.valueOf(z2), new e(dVar1116, z2, null), composer2, ((i111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar1116.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf1117 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf1117) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1117 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1117);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller1117;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope1117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar1117, new a(dVar1117, coroutineScope1117, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1117, null), composerStartRestartGroup, 70);
                        int i111111117 = i5;
                        c cVar1117 = new c(dVar1117, uri, seekToMillis, play, null);
                        int i111111118 = i111111117 >> 3;
                        EffectsKt.LaunchedEffect(dVar1117, uri, seekToMillis, cVar1117, composerStartRestartGroup, ((i111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111118 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar1117, play, new d(dVar1117, play, null), composer2, (i111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar1117, Boolean.valueOf(z2), new e(dVar1117, z2, null), composer2, ((i111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar1117.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf1118 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf1118) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1118 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1118);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller1118;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope1118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar1118, new a(dVar1118, coroutineScope1118, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1118, null), composerStartRestartGroup, 70);
                    int i111111119 = i5;
                    c cVar1118 = new c(dVar1118, uri, seekToMillis, play, null);
                    int i1111111110 = i111111119 >> 3;
                    EffectsKt.LaunchedEffect(dVar1118, uri, seekToMillis, cVar1118, composerStartRestartGroup, ((i111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111110 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar1118, play, new d(dVar1118, play, null), composer2, (i1111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar1118, Boolean.valueOf(z2), new e(dVar1118, z2, null), composer2, ((i111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar1118.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf1119 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf1119) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1119 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1119);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller1119;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope1119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar1119, new a(dVar1119, coroutineScope1119, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1119, null), composerStartRestartGroup, 70);
                    int i1111111111 = i5;
                    c cVar1119 = new c(dVar1119, uri, seekToMillis, play, null);
                    int i1111111112 = i1111111111 >> 3;
                    EffectsKt.LaunchedEffect(dVar1119, uri, seekToMillis, cVar1119, composerStartRestartGroup, ((i1111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111112 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar1119, play, new d(dVar1119, play, null), composer2, (i1111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar1119, Boolean.valueOf(z2), new e(dVar1119, z2, null), composer2, ((i1111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar1119.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i8 = 12582912;
            i5 |= i8;
            if ((i4 & 256) != 0) {
                if ((234881024 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onProgressChanged)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf11110 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf11110) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11110 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11110);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller11110;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope11110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar11110, new a(dVar11110, coroutineScope11110, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11110, null), composerStartRestartGroup, 70);
                        int i1111111113 = i5;
                        c cVar11110 = new c(dVar11110, uri, seekToMillis, play, null);
                        int i1111111114 = i1111111113 >> 3;
                        EffectsKt.LaunchedEffect(dVar11110, uri, seekToMillis, cVar11110, composerStartRestartGroup, ((i1111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111114 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar11110, play, new d(dVar11110, play, null), composer2, (i1111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar11110, Boolean.valueOf(z2), new e(dVar11110, z2, null), composer2, ((i1111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar11110.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf11111 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf11111) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11111 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11111);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller11111;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope11111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar11111, new a(dVar11111, coroutineScope11111, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11111, null), composerStartRestartGroup, 70);
                        int i1111111115 = i5;
                        c cVar11111 = new c(dVar11111, uri, seekToMillis, play, null);
                        int i1111111116 = i1111111115 >> 3;
                        EffectsKt.LaunchedEffect(dVar11111, uri, seekToMillis, cVar11111, composerStartRestartGroup, ((i1111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111116 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar11111, play, new d(dVar11111, play, null), composer2, (i1111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar11111, Boolean.valueOf(z2), new e(dVar11111, z2, null), composer2, ((i1111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar11111.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf11112 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf11112) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11112 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11112);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller11112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope11112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar11112, new a(dVar11112, coroutineScope11112, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11112, null), composerStartRestartGroup, 70);
                    int i1111111117 = i5;
                    c cVar11112 = new c(dVar11112, uri, seekToMillis, play, null);
                    int i1111111118 = i1111111117 >> 3;
                    EffectsKt.LaunchedEffect(dVar11112, uri, seekToMillis, cVar11112, composerStartRestartGroup, ((i1111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111118 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar11112, play, new d(dVar11112, play, null), composer2, (i1111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar11112, Boolean.valueOf(z2), new e(dVar11112, z2, null), composer2, ((i1111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar11112.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf11113 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf11113) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11113 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11113);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller11113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope11113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar11113, new a(dVar11113, coroutineScope11113, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11113, null), composerStartRestartGroup, 70);
                    int i1111111119 = i5;
                    c cVar11113 = new c(dVar11113, uri, seekToMillis, play, null);
                    int i11111111110 = i1111111119 >> 3;
                    EffectsKt.LaunchedEffect(dVar11113, uri, seekToMillis, cVar11113, composerStartRestartGroup, ((i1111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111110 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar11113, play, new d(dVar11113, play, null), composer2, (i11111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar11113, Boolean.valueOf(z2), new e(dVar11113, z2, null), composer2, ((i1111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar11113.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i9 = 100663296;
            i5 |= i9;
            if ((i4 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onError)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf11114 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf11114) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11114 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11114);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller11114;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope11114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar11114, new a(dVar11114, coroutineScope11114, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11114, null), composerStartRestartGroup, 70);
                    int i11111111111 = i5;
                    c cVar11114 = new c(dVar11114, uri, seekToMillis, play, null);
                    int i11111111112 = i11111111111 >> 3;
                    EffectsKt.LaunchedEffect(dVar11114, uri, seekToMillis, cVar11114, composerStartRestartGroup, ((i11111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111112 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar11114, play, new d(dVar11114, play, null), composer2, (i11111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar11114, Boolean.valueOf(z2), new e(dVar11114, z2, null), composer2, ((i11111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar11114.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf11115 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf11115) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11115 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11115);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller11115;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope11115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar11115, new a(dVar11115, coroutineScope11115, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11115, null), composerStartRestartGroup, 70);
                    int i11111111113 = i5;
                    c cVar11115 = new c(dVar11115, uri, seekToMillis, play, null);
                    int i11111111114 = i11111111113 >> 3;
                    EffectsKt.LaunchedEffect(dVar11115, uri, seekToMillis, cVar11115, composerStartRestartGroup, ((i11111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111114 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar11115, play, new d(dVar11115, play, null), composer2, (i11111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar11115, Boolean.valueOf(z2), new e(dVar11115, z2, null), composer2, ((i11111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar11115.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i10 = C.ENCODING_PCM_32BIT;
            i5 |= i10;
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            if ((i5 & 1533916891) != 306783378) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf11116 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf11116) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11116 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11116);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller11116;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope11116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar11116, new a(dVar11116, coroutineScope11116, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11116, null), composerStartRestartGroup, 70);
                int i11111111115 = i5;
                c cVar11116 = new c(dVar11116, uri, seekToMillis, play, null);
                int i11111111116 = i11111111115 >> 3;
                EffectsKt.LaunchedEffect(dVar11116, uri, seekToMillis, cVar11116, composerStartRestartGroup, ((i11111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111116 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar11116, play, new d(dVar11116, play, null), composer2, (i11111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar11116, Boolean.valueOf(z2), new e(dVar11116, z2, null), composer2, ((i11111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar11116.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf11117 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf11117) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11117 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11117);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller11117;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope11117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar11117, new a(dVar11117, coroutineScope11117, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11117, null), composerStartRestartGroup, 70);
                int i11111111117 = i5;
                c cVar11117 = new c(dVar11117, uri, seekToMillis, play, null);
                int i11111111118 = i11111111117 >> 3;
                EffectsKt.LaunchedEffect(dVar11117, uri, seekToMillis, cVar11117, composerStartRestartGroup, ((i11111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111118 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar11117, play, new d(dVar11117, play, null), composer2, (i11111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar11117, Boolean.valueOf(z2), new e(dVar11117, z2, null), composer2, ((i11111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar11117.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
        }
        i7 = 1572864;
        i5 |= i7;
        if ((i4 & 128) != 0) {
            if ((29360128 & i2) == 0) {
                if (composerStartRestartGroup.changed(viewVisibilityTracker)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
            }
            if ((i4 & 256) != 0) {
                if ((234881024 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onProgressChanged)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i4 & 512) != 0) {
                    if ((1879048192 & i2) == 0) {
                        if (composerStartRestartGroup.changed(onError)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    i11 = i4 & 1024;
                    if (i11 != 0) {
                        i12 = i3 | 6;
                    } else if ((i3 & 14) == 0) {
                        if (composerStartRestartGroup.changed(modifier)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i3 | i13;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 1533916891) != 306783378) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf11118 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf11118) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11118 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11118);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller11118;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope11118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar11118, new a(dVar11118, coroutineScope11118, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11118, null), composerStartRestartGroup, 70);
                        int i11111111119 = i5;
                        c cVar11118 = new c(dVar11118, uri, seekToMillis, play, null);
                        int i111111111110 = i11111111119 >> 3;
                        EffectsKt.LaunchedEffect(dVar11118, uri, seekToMillis, cVar11118, composerStartRestartGroup, ((i11111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111110 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar11118, play, new d(dVar11118, play, null), composer2, (i111111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar11118, Boolean.valueOf(z2), new e(dVar11118, z2, null), composer2, ((i11111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar11118.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                        }
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                        Boolean boolValueOf11119 = Boolean.valueOf(z);
                        i14 = i12;
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(boolValueOf11119) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar11119 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11119);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller11119;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope11119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(dVar11119, new a(dVar11119, coroutineScope11119, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar11119, null), composerStartRestartGroup, 70);
                        int i111111111111 = i5;
                        c cVar11119 = new c(dVar11119, uri, seekToMillis, play, null);
                        int i111111111112 = i111111111111 >> 3;
                        EffectsKt.LaunchedEffect(dVar11119, uri, seekToMillis, cVar11119, composerStartRestartGroup, ((i111111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111112 & 896));
                        composer2 = composerStartRestartGroup;
                        EffectsKt.LaunchedEffect(dVar11119, play, new d(dVar11119, play, null), composer2, (i111111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        EffectsKt.LaunchedEffect(dVar11119, Boolean.valueOf(z2), new e(dVar11119, z2, null), composer2, ((i111111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                        viewM = dVar11119.M();
                        if (viewM != null) {
                            AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
                }
                i10 = C.ENCODING_PCM_32BIT;
                i5 |= i10;
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111110 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111110) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111110 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111110);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111110;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111110, new a(dVar111110, coroutineScope111110, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111110, null), composerStartRestartGroup, 70);
                    int i111111111113 = i5;
                    c cVar111110 = new c(dVar111110, uri, seekToMillis, play, null);
                    int i111111111114 = i111111111113 >> 3;
                    EffectsKt.LaunchedEffect(dVar111110, uri, seekToMillis, cVar111110, composerStartRestartGroup, ((i111111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111114 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111110, play, new d(dVar111110, play, null), composer2, (i111111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111110, Boolean.valueOf(z2), new e(dVar111110, z2, null), composer2, ((i111111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111110.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111111 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111111) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111111 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111111);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111111;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111111, new a(dVar111111, coroutineScope111111, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111111, null), composerStartRestartGroup, 70);
                    int i111111111115 = i5;
                    c cVar111111 = new c(dVar111111, uri, seekToMillis, play, null);
                    int i111111111116 = i111111111115 >> 3;
                    EffectsKt.LaunchedEffect(dVar111111, uri, seekToMillis, cVar111111, composerStartRestartGroup, ((i111111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111116 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111111, play, new d(dVar111111, play, null), composer2, (i111111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111111, Boolean.valueOf(z2), new e(dVar111111, z2, null), composer2, ((i111111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111111.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i9 = 100663296;
            i5 |= i9;
            if ((i4 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onError)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111112 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111112) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111112 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111112);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111112, new a(dVar111112, coroutineScope111112, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111112, null), composerStartRestartGroup, 70);
                    int i111111111117 = i5;
                    c cVar111112 = new c(dVar111112, uri, seekToMillis, play, null);
                    int i111111111118 = i111111111117 >> 3;
                    EffectsKt.LaunchedEffect(dVar111112, uri, seekToMillis, cVar111112, composerStartRestartGroup, ((i111111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111118 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111112, play, new d(dVar111112, play, null), composer2, (i111111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111112, Boolean.valueOf(z2), new e(dVar111112, z2, null), composer2, ((i111111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111112.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111113 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111113) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111113 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111113);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111113, new a(dVar111113, coroutineScope111113, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111113, null), composerStartRestartGroup, 70);
                    int i111111111119 = i5;
                    c cVar111113 = new c(dVar111113, uri, seekToMillis, play, null);
                    int i1111111111110 = i111111111119 >> 3;
                    EffectsKt.LaunchedEffect(dVar111113, uri, seekToMillis, cVar111113, composerStartRestartGroup, ((i111111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111111110 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111113, play, new d(dVar111113, play, null), composer2, (i1111111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111113, Boolean.valueOf(z2), new e(dVar111113, z2, null), composer2, ((i111111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111113.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i10 = C.ENCODING_PCM_32BIT;
            i5 |= i10;
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            if ((i5 & 1533916891) != 306783378) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf111114 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf111114) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111114 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111114);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller111114;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope111114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar111114, new a(dVar111114, coroutineScope111114, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111114, null), composerStartRestartGroup, 70);
                int i1111111111111 = i5;
                c cVar111114 = new c(dVar111114, uri, seekToMillis, play, null);
                int i1111111111112 = i1111111111111 >> 3;
                EffectsKt.LaunchedEffect(dVar111114, uri, seekToMillis, cVar111114, composerStartRestartGroup, ((i1111111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111111112 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar111114, play, new d(dVar111114, play, null), composer2, (i1111111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar111114, Boolean.valueOf(z2), new e(dVar111114, z2, null), composer2, ((i1111111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar111114.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf111115 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf111115) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111115 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111115);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller111115;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope111115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar111115, new a(dVar111115, coroutineScope111115, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111115, null), composerStartRestartGroup, 70);
                int i1111111111113 = i5;
                c cVar111115 = new c(dVar111115, uri, seekToMillis, play, null);
                int i1111111111114 = i1111111111113 >> 3;
                EffectsKt.LaunchedEffect(dVar111115, uri, seekToMillis, cVar111115, composerStartRestartGroup, ((i1111111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111111114 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar111115, play, new d(dVar111115, play, null), composer2, (i1111111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar111115, Boolean.valueOf(z2), new e(dVar111115, z2, null), composer2, ((i1111111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar111115.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
        }
        i8 = 12582912;
        i5 |= i8;
        if ((i4 & 256) != 0) {
            if ((234881024 & i2) == 0) {
                if (composerStartRestartGroup.changed(onProgressChanged)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
            }
            if ((i4 & 512) != 0) {
                if ((1879048192 & i2) == 0) {
                    if (composerStartRestartGroup.changed(onError)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111116 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111116) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111116 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111116);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111116;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111116, new a(dVar111116, coroutineScope111116, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111116, null), composerStartRestartGroup, 70);
                    int i1111111111115 = i5;
                    c cVar111116 = new c(dVar111116, uri, seekToMillis, play, null);
                    int i1111111111116 = i1111111111115 >> 3;
                    EffectsKt.LaunchedEffect(dVar111116, uri, seekToMillis, cVar111116, composerStartRestartGroup, ((i1111111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111111116 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111116, play, new d(dVar111116, play, null), composer2, (i1111111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111116, Boolean.valueOf(z2), new e(dVar111116, z2, null), composer2, ((i1111111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111116.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                    }
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                    Boolean boolValueOf111117 = Boolean.valueOf(z);
                    i14 = i12;
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(boolValueOf111117) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111117 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111117);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller111117;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope111117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(dVar111117, new a(dVar111117, coroutineScope111117, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111117, null), composerStartRestartGroup, 70);
                    int i1111111111117 = i5;
                    c cVar111117 = new c(dVar111117, uri, seekToMillis, play, null);
                    int i1111111111118 = i1111111111117 >> 3;
                    EffectsKt.LaunchedEffect(dVar111117, uri, seekToMillis, cVar111117, composerStartRestartGroup, ((i1111111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i1111111111118 & 896));
                    composer2 = composerStartRestartGroup;
                    EffectsKt.LaunchedEffect(dVar111117, play, new d(dVar111117, play, null), composer2, (i1111111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    EffectsKt.LaunchedEffect(dVar111117, Boolean.valueOf(z2), new e(dVar111117, z2, null), composer2, ((i1111111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                    viewM = dVar111117.M();
                    if (viewM != null) {
                        AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
            }
            i10 = C.ENCODING_PCM_32BIT;
            i5 |= i10;
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            if ((i5 & 1533916891) != 306783378) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf111118 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf111118) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111118 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111118);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller111118;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope111118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar111118, new a(dVar111118, coroutineScope111118, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111118, null), composerStartRestartGroup, 70);
                int i1111111111119 = i5;
                c cVar111118 = new c(dVar111118, uri, seekToMillis, play, null);
                int i11111111111110 = i1111111111119 >> 3;
                EffectsKt.LaunchedEffect(dVar111118, uri, seekToMillis, cVar111118, composerStartRestartGroup, ((i1111111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111111110 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar111118, play, new d(dVar111118, play, null), composer2, (i11111111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar111118, Boolean.valueOf(z2), new e(dVar111118, z2, null), composer2, ((i1111111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar111118.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf111119 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf111119) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar111119 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111119);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller111119;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope111119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar111119, new a(dVar111119, coroutineScope111119, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar111119, null), composerStartRestartGroup, 70);
                int i11111111111111 = i5;
                c cVar111119 = new c(dVar111119, uri, seekToMillis, play, null);
                int i11111111111112 = i11111111111111 >> 3;
                EffectsKt.LaunchedEffect(dVar111119, uri, seekToMillis, cVar111119, composerStartRestartGroup, ((i11111111111111 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111111112 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar111119, play, new d(dVar111119, play, null), composer2, (i11111111111112 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar111119, Boolean.valueOf(z2), new e(dVar111119, z2, null), composer2, ((i11111111111111 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar111119.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
        }
        i9 = 100663296;
        i5 |= i9;
        if ((i4 & 512) != 0) {
            if ((1879048192 & i2) == 0) {
                if (composerStartRestartGroup.changed(onError)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
            }
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            if ((i5 & 1533916891) != 306783378) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf1111110 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf1111110) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1111110 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111110);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111110;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope1111110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar1111110, new a(dVar1111110, coroutineScope1111110, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1111110, null), composerStartRestartGroup, 70);
                int i11111111111113 = i5;
                c cVar1111110 = new c(dVar1111110, uri, seekToMillis, play, null);
                int i11111111111114 = i11111111111113 >> 3;
                EffectsKt.LaunchedEffect(dVar1111110, uri, seekToMillis, cVar1111110, composerStartRestartGroup, ((i11111111111113 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111111114 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar1111110, play, new d(dVar1111110, play, null), composer2, (i11111111111114 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar1111110, Boolean.valueOf(z2), new e(dVar1111110, z2, null), composer2, ((i11111111111113 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar1111110.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                Boolean boolValueOf1111111 = Boolean.valueOf(z);
                i14 = i12;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(boolValueOf1111111) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1111111 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111111);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111111;
                }
                composerStartRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope1111111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(dVar1111111, new a(dVar1111111, coroutineScope1111111, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1111111, null), composerStartRestartGroup, 70);
                int i11111111111115 = i5;
                c cVar1111111 = new c(dVar1111111, uri, seekToMillis, play, null);
                int i11111111111116 = i11111111111115 >> 3;
                EffectsKt.LaunchedEffect(dVar1111111, uri, seekToMillis, cVar1111111, composerStartRestartGroup, ((i11111111111115 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111111116 & 896));
                composer2 = composerStartRestartGroup;
                EffectsKt.LaunchedEffect(dVar1111111, play, new d(dVar1111111, play, null), composer2, (i11111111111116 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                EffectsKt.LaunchedEffect(dVar1111111, Boolean.valueOf(z2), new e(dVar1111111, z2, null), composer2, ((i11111111111115 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
                viewM = dVar1111111.M();
                if (viewM != null) {
                    AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
        }
        i10 = C.ENCODING_PCM_32BIT;
        i5 |= i10;
        i11 = i4 & 1024;
        if (i11 != 0) {
            i12 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(modifier)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i3 | i13;
        } else {
            i12 = i3;
        }
        if ((i5 & 1533916891) != 306783378) {
            if (i11 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
            Boolean boolValueOf1111112 = Boolean.valueOf(z);
            i14 = i12;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(boolValueOf1111112) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1111112 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111112);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111112;
            }
            composerStartRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope1111112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(dVar1111112, new a(dVar1111112, coroutineScope1111112, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1111112, null), composerStartRestartGroup, 70);
            int i11111111111117 = i5;
            c cVar1111112 = new c(dVar1111112, uri, seekToMillis, play, null);
            int i11111111111118 = i11111111111117 >> 3;
            EffectsKt.LaunchedEffect(dVar1111112, uri, seekToMillis, cVar1111112, composerStartRestartGroup, ((i11111111111117 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i11111111111118 & 896));
            composer2 = composerStartRestartGroup;
            EffectsKt.LaunchedEffect(dVar1111112, play, new d(dVar1111112, play, null), composer2, (i11111111111118 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
            EffectsKt.LaunchedEffect(dVar1111112, Boolean.valueOf(z2), new e(dVar1111112, z2, null), composer2, ((i11111111111117 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
            viewM = dVar1111112.M();
            if (viewM != null) {
                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i11 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32444032, i5, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:35)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            lifecycle = ((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
            Boolean boolValueOf1111113 = Boolean.valueOf(z);
            i14 = i12;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(boolValueOf1111113) | composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(lifecycle);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, com.moloco.sdk.service_locator.a.g.f6474a.a(), lifecycle), viewVisibilityTracker);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d dVar1111113 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(f7041a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111113);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller1111113;
            }
            composerStartRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope1111113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(dVar1111113, new a(dVar1111113, coroutineScope1111113, (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) i.f7057a, composerStartRestartGroup, 3080, 6), (MutableState) RememberSaveableKt.m1299rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) h.f7056a, composerStartRestartGroup, 3080, 6), SnapshotStateKt.rememberUpdatedState(isPlaying, composerStartRestartGroup, (i5 >> 15) & 14), SnapshotStateKt.rememberUpdatedState(isVisible, composerStartRestartGroup, (i5 >> 18) & 14), SnapshotStateKt.rememberUpdatedState(onProgressChanged, composerStartRestartGroup, (i5 >> 24) & 14), SnapshotStateKt.rememberUpdatedState(onError, composerStartRestartGroup, (i5 >> 27) & 14)), composerStartRestartGroup, 8);
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(dVar1111113, null), composerStartRestartGroup, 70);
            int i11111111111119 = i5;
            c cVar1111113 = new c(dVar1111113, uri, seekToMillis, play, null);
            int i111111111111110 = i11111111111119 >> 3;
            EffectsKt.LaunchedEffect(dVar1111113, uri, seekToMillis, cVar1111113, composerStartRestartGroup, ((i11111111111119 << 3) & 112) | OguryBidTokenErrorCode.AD_DISABLED_UNSPECIFIED_REASON | (i111111111111110 & 896));
            composer2 = composerStartRestartGroup;
            EffectsKt.LaunchedEffect(dVar1111113, play, new d(dVar1111113, play, null), composer2, (i111111111111110 & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
            EffectsKt.LaunchedEffect(dVar1111113, Boolean.valueOf(z2), new e(dVar1111113, z2, null), composer2, ((i11111111111119 >> 9) & 112) | IronSourceError.ERROR_NO_INTERNET_CONNECTION);
            viewM = dVar1111113.M();
            if (viewM != null) {
                AndroidView_androidKt.AndroidView(new f(viewM), modifier2, null, composer2, (i14 << 3) & 112, 4);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new g(uri, z, play, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier2, i2, i3, i4));
    }

    public static final Function1<Boolean, Unit> a(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }
}
