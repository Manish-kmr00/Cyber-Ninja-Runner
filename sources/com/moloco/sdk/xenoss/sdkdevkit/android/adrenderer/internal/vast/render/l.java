package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.app.Activity;
import android.content.Context;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt", f = "PreparedVastResource.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {73, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, m = "prepareVastResource", n = {"$this$prepareVastResource", "context", "customUserEventBuilderService", "externalLinkHandler", "onWebViewClick", "onWebViewError", "mraidHtml", "mraidInline", "staticWebView", "staticWebViewListenerScope"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7077a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int i;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.i |= Integer.MIN_VALUE;
            return l.a(null, null, null, null, 0, 0, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$2", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7078a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ y c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<String> objectRef, y yVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7078a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.element = l.a(this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f7079a;
        public final /* synthetic */ Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> b;
        public final /* synthetic */ Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d> c;
        public final /* synthetic */ Ref.ObjectRef<CoroutineScope> d;

        public c(Integer num, Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> objectRef, Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d> objectRef2, Ref.ObjectRef<CoroutineScope> objectRef3) {
            this.f7079a = num;
            this.b = objectRef;
            this.c = objectRef2;
            this.d = objectRef3;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
        public void destroy() {
            Integer num = this.f7079a;
            if (num != null) {
                l0.f6576a.b(num.intValue());
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m mVar = this.b.element;
            if (mVar != null) {
                mVar.destroy();
            }
            this.b.element = null;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d dVar = this.c.element;
            if (dVar != null) {
                dVar.destroy();
            }
            this.c.element = null;
            CoroutineScope coroutineScope = this.d.element;
            if (coroutineScope != null) {
                CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
            }
            this.d.element = null;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$1", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7080a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0<Unit> function0, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((d) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7080a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.invoke();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2", f = "PreparedVastResource.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7081a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a b;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2$1", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7082a;
            public /* synthetic */ Object b;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, Continuation<? super Boolean> continuation) {
                return ((a) create(gVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7082a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.b) != null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function1, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = aVar;
            this.c = function1;
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
            int i = this.f7081a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.b.getUnrecoverableError();
                a aVar = new a(null);
                this.f7081a = 1;
                obj = FlowKt.first(unrecoverableError, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
            if (gVar != null) {
                this.c.invoke(gVar);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f7083a = new f();

        public f() {
            super(0);
        }

        public final void a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f7084a = new g();

        public g() {
            super(0);
        }

        public final void a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final j a(y yVar, int i, int i2) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        if (yVar instanceof y.c) {
            y.c cVar = (y.c) yVar;
            if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.Image) {
                return new j.b(cVar.a().b(), i, i2);
            }
        }
        return null;
    }

    public static final String a(y yVar) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        if (yVar instanceof y.a) {
            y.a aVar = (y.a) yVar;
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h.f6567a.a(aVar.a().a())) {
                return aVar.a().a();
            }
        } else if (yVar instanceof y.b) {
            y.b bVar = (y.b) yVar;
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h.f6567a.a(bVar.a().a())) {
                return bVar.a().a();
            }
        } else if (yVar instanceof y.c) {
            y.c cVar = (y.c) yVar;
            if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.JS && com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h.f6567a.a(cVar.a().b())) {
                return cVar.a().b();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x018f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0196  */
    /* JADX WARN: Code duplicated, block: B:36:0x019c  */
    /* JADX WARN: Code duplicated, block: B:37:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x01af  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d] */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object a(y yVar, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, int i, int i2, Function0<Unit> function0, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function1, Continuation<? super k> continuation) throws Throwable {
        a aVar2;
        Context context2;
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar3;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar2;
        Function0<Unit> function2;
        Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function3;
        y yVar2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        ?? aVar4;
        ?? r0;
        Integer numBoxInt;
        c cVar;
        if (continuation instanceof a) {
            aVar2 = (a) continuation;
            int i3 = aVar2.i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                aVar2.i = i3 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(continuation);
            }
        } else {
            aVar2 = new a(continuation);
        }
        Object obj = aVar2.h;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = aVar2.i;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            j jVarA = a(yVar, i, i2);
            if (jVarA != null) {
                return new k(jVarA, null);
            }
            Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
            b bVar = new b(objectRef8, yVar, null);
            aVar2.f7077a = yVar;
            context2 = context;
            aVar2.b = context2;
            aVar3 = aVar;
            aVar2.c = aVar3;
            aVar2.d = mVar;
            aVar2.e = function0;
            aVar2.f = function1;
            aVar2.g = objectRef8;
            aVar2.i = 1;
            if (BuildersKt.withContext(coroutineContext, bVar, aVar2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mVar2 = mVar;
            function2 = function0;
            function3 = function1;
            yVar2 = yVar;
            objectRef = objectRef8;
        } else {
            if (i4 == 1) {
                objectRef = (Ref.ObjectRef) aVar2.g;
                function3 = (Function1) aVar2.f;
                function2 = (Function0) aVar2.e;
                mVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m) aVar2.d;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar5 = (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a) aVar2.c;
                Context context3 = (Context) aVar2.b;
                yVar2 = (y) aVar2.f7077a;
                ResultKt.throwOnFailure(obj);
                aVar3 = aVar5;
                context2 = context3;
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef6 = (Ref.ObjectRef) aVar2.c;
                objectRef5 = (Ref.ObjectRef) aVar2.b;
                objectRef7 = (Ref.ObjectRef) aVar2.f7077a;
                ResultKt.throwOnFailure(obj);
            }
            if (obj instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d) {
                objectRef4 = objectRef6;
                r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d) obj;
                objectRef2 = objectRef7;
                objectRef3 = objectRef5;
            } else {
                objectRef4 = objectRef6;
                objectRef2 = objectRef7;
                objectRef3 = objectRef5;
                r0 = 0;
            }
            if (r0 != 0) {
                r0 = aVar4;
                numBoxInt = Boxing.boxInt(l0.f6576a.a(r0));
            } else {
                r0 = aVar4;
                numBoxInt = null;
            }
            cVar = new c(numBoxInt, objectRef2, objectRef3, objectRef4);
            if (numBoxInt != null) {
                return new k(new j.a(numBoxInt.intValue()), cVar);
            }
            return null;
        }
        objectRef2 = new Ref.ObjectRef();
        objectRef3 = new Ref.ObjectRef();
        objectRef4 = new Ref.ObjectRef();
        String str = (String) objectRef.element;
        if (str == null) {
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            aVar4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(applicationContext, null, new t(mVar2, aVar3), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a(), false, null, 50, null);
            objectRef3.element = aVar4;
            ?? CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
            objectRef4.element = CoroutineScope;
            FlowKt.launchIn(FlowKt.onEach(aVar4.getClickthroughEvent(), new d(function2, null)), CoroutineScope);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new e(aVar4, function3, null), 3, null);
            q.a(aVar4, yVar2);
        } else {
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ?? mVar3 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m((Activity) context2, str, f.f7083a, g.f7084a, function2, function3, true, mVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context2, CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain())), null, 512, null);
            objectRef2.element = mVar3;
            aVar2.f7077a = objectRef2;
            aVar2.b = objectRef3;
            aVar2.c = objectRef4;
            aVar2.d = null;
            aVar2.e = null;
            aVar2.f = null;
            aVar2.g = null;
            aVar2.i = 2;
            Object objC = mVar3.c(aVar2);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef5 = objectRef3;
            objectRef6 = objectRef4;
            objectRef7 = objectRef2;
            obj = objC;
            if (obj instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d) {
                objectRef4 = objectRef6;
                r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d) obj;
                objectRef2 = objectRef7;
                objectRef3 = objectRef5;
            } else {
                objectRef4 = objectRef6;
                objectRef2 = objectRef7;
                objectRef3 = objectRef5;
                r0 = 0;
            }
        }
        if (r0 != 0) {
            r0 = aVar4;
            numBoxInt = Boxing.boxInt(l0.f6576a.a(r0));
        } else {
            r0 = aVar4;
            numBoxInt = null;
        }
        cVar = new c(numBoxInt, objectRef2, objectRef3, objectRef4);
        if (numBoxInt != null) {
            return new k(new j.a(numBoxInt.intValue()), cVar);
        }
        return null;
    }
}
