package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f6607a;
    public final Flow<c> b;
    public Function1<? super File, Unit> c;
    public Function2<? super File, ? super c.d, Unit> d;
    public Function1<? super c.a, Unit> e;
    public Function1<? super c.b, Unit> f;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.MediaStreamListenerFlow$streamStatusFlow$1", f = "MediaStreamListenerFlow.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6608a;
        public /* synthetic */ Object b;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$a, reason: collision with other inner class name */
        public static final class C0603a extends Lambda implements Function1<File, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f6609a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0603a(ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> producerScope) {
                super(1);
                this.f6609a = producerScope;
            }

            public final void a(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                this.f6609a.mo9408trySendJP2dKIU(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(file, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.d(0L, 0L)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                a(file);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$b, reason: collision with other inner class name */
        public static final class C0604b extends Lambda implements Function2<File, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.d, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f6610a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0604b(ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> producerScope) {
                super(2);
                this.f6610a = producerScope;
            }

            public final void a(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.d progress) {
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(progress, "progress");
                this.f6610a.mo9408trySendJP2dKIU(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c(file, progress));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.d dVar) {
                a(file, dVar);
                return Unit.INSTANCE;
            }
        }

        public static final class c extends Lambda implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f6611a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> producerScope) {
                super(1);
                this.f6611a = producerScope;
            }

            public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a complete) {
                Intrinsics.checkNotNullParameter(complete, "complete");
                this.f6611a.mo9408trySendJP2dKIU(complete);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a aVar) {
                a(aVar);
                return Unit.INSTANCE;
            }
        }

        public static final class d extends Lambda implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f6612a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> producerScope) {
                super(1);
                this.f6612a = producerScope;
            }

            public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b error) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.f6612a.mo9408trySendJP2dKIU(error);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b bVar) {
                a(bVar);
                return Unit.INSTANCE;
            }
        }

        public static final class e extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f6613a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(b bVar) {
                super(0);
                this.f6613a = bVar;
            }

            public final void a() {
                this.f6613a.c = null;
                this.f6613a.d = null;
                this.f6613a.e = null;
                this.f6613a.f = null;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> producerScope, Continuation<? super Unit> continuation) {
            return ((a) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = b.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6608a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.b;
                b.this.c = new C0603a(producerScope);
                b.this.d = new C0604b(producerScope);
                b.this.e = new c(producerScope);
                b.this.f = new d(producerScope);
                e eVar = new e(b.this);
                this.f6608a = 1;
                if (ProduceKt.awaitClose(producerScope, eVar, this) == coroutine_suspended) {
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

    public b(c initialStatus) {
        Intrinsics.checkNotNullParameter(initialStatus, "initialStatus");
        this.f6607a = initialStatus;
        this.b = FlowKt.callbackFlow(new a(null));
    }

    public final Flow<c> b() {
        return this.b;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public c a() {
        return this.f6607a;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f6607a = new c.C0605c(file, new c.d(0L, 0L));
        Function1<? super File, Unit> function1 = this.c;
        if (function1 != null) {
            function1.invoke(file);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(File file, c.d progress) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.f6607a = new c.C0605c(file, progress);
        Function2<? super File, ? super c.d, Unit> function2 = this.d;
        if (function2 != null) {
            function2.invoke(file, progress);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(c.a result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f6607a = result;
        Function1<? super c.a, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(result);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(c.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f6607a = error;
        Function1<? super c.b, Unit> function1 = this.f;
        if (function1 != null) {
            function1.invoke(error);
        }
    }
}
