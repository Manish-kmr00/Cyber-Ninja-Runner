package com.moloco.sdk.internal.publisher.nativead.parser;

import android.content.Context;
import android.net.Uri;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6245a = "PrepareNativeAssets";

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0}, l = {113}, m = "prepareImageAsset", n = {"asset"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6246a;
        public /* synthetic */ Object b;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return c.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {37, TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER}, m = "prepareNativeAssets-exY8QGI", n = {"loadVast", "optionalAssetsGroup", "timeout", "preparedRequiredAssets"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6247a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.a((Context) null, (List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a>) null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c, reason: collision with other inner class name */
    public static final class C0552c extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6248a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0552c(Context context) {
            super(0);
            this.f6248a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d invoke() {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(this.f6248a);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6249a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<com.moloco.sdk.internal.publisher.nativead.model.b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f6250a;
            public int b;
            public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.b.a c;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(com.moloco.sdk.internal.publisher.nativead.model.b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = aVar;
                this.d = lazy;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                com.moloco.sdk.internal.publisher.nativead.model.b.a aVar;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.publisher.nativead.model.b.a aVar2 = this.c;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                    long j = this.e;
                    this.f6250a = aVar2;
                    this.b = 1;
                    Object objB = c.b(aVar2, lazy, j, this);
                    if (objB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                    obj = objB;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (com.moloco.sdk.internal.publisher.nativead.model.b.a) this.f6250a;
                    ResultKt.throwOnFailure(obj);
                }
                return TuplesKt.to(aVar, obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, this.d, this.e, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6249a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                List<com.moloco.sdk.internal.publisher.nativead.model.b.a> list = this.c;
                Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                long j = this.e;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((com.moloco.sdk.internal.publisher.nativead.model.b.a) it.next(), lazy, j, null), 3, null));
                }
                this.f6249a = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6251a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<com.moloco.sdk.internal.publisher.nativead.model.b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6252a;
            public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.b.a b;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> c;
            public final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(com.moloco.sdk.internal.publisher.nativead.model.b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = lazy;
                this.d = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6252a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.publisher.nativead.model.b.a aVar = this.b;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.c;
                    long j = this.d;
                    this.f6252a = 1;
                    obj = c.b(aVar, lazy, j, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                v vVar = (v) obj;
                if (vVar instanceof v.b) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, c.f6245a, "Successfully prepared native asset: " + this.b.a(), null, false, 12, null);
                    return TuplesKt.to(this.b, vVar);
                }
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, c.f6245a, "Failed to prepare required native asset: " + this.b.a(), null, false, 12, null);
                throw new com.moloco.sdk.internal.publisher.nativead.parser.b(this.b.a(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.c, this.d, this.e, continuation);
            eVar.b = obj;
            return eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6251a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                List<com.moloco.sdk.internal.publisher.nativead.model.b.a> list = this.c;
                Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                long j = this.e;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((com.moloco.sdk.internal.publisher.nativead.model.b.a) it.next(), lazy, j, null), 3, null));
                }
                this.f6251a = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {148, 155}, m = "prepareVideoAsset-exY8QGI", n = {"asset", "loadVast", "timeout", "asset"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class f extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6253a;
        public Object b;
        public long c;
        public /* synthetic */ Object d;
        public int e;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.b((com.moloco.sdk.internal.publisher.nativead.model.b.a.d) null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d) null, 0L, this);
        }
    }

    public static final Object b(com.moloco.sdk.internal.publisher.nativead.model.b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        if (aVar instanceof com.moloco.sdk.internal.publisher.nativead.model.b.a.C0548a) {
            return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.c.a((com.moloco.sdk.internal.publisher.nativead.model.b.a.C0548a) aVar));
        }
        if (aVar instanceof com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b) {
            return a((com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b) aVar, null, continuation, 2, null);
        }
        if (aVar instanceof com.moloco.sdk.internal.publisher.nativead.model.b.a.c) {
            return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.c.C0551c((com.moloco.sdk.internal.publisher.nativead.model.b.a.c) aVar));
        }
        if (aVar instanceof com.moloco.sdk.internal.publisher.nativead.model.b.a.d) {
            return b((com.moloco.sdk.internal.publisher.nativead.model.b.a.d) aVar, lazy.getValue(), j, continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x010b  */
    /* JADX WARN: Code duplicated, block: B:69:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x015f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:80:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0105 A[SYNTHETIC] */
    public static final Object a(Context context, List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> list, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> continuation) throws Throwable {
        b bVar;
        Lazy lazy;
        List list2;
        List list3;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        ArrayList arrayList;
        com.moloco.sdk.internal.publisher.nativead.model.b.a aVar;
        v vVar;
        com.moloco.sdk.internal.publisher.nativead.model.c cVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objCoroutineScope = bVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objCoroutineScope);
                Lazy lazy2 = LazyKt.lazy(new C0552c(context));
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                for (Object obj : list) {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(((com.moloco.sdk.internal.publisher.nativead.model.b.a) obj).b());
                    Object arrayList2 = linkedHashMap5.get(boolBoxBoolean);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap5.put(boolBoxBoolean, arrayList2);
                    }
                    ((List) arrayList2).add(obj);
                }
                List listEmptyList = (List) linkedHashMap5.get(Boxing.boxBoolean(true));
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List list4 = listEmptyList;
                List listEmptyList2 = (List) linkedHashMap5.get(Boxing.boxBoolean(false));
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                e eVar = new e(list4, lazy2, j, null);
                bVar.b = lazy2;
                bVar.c = listEmptyList2;
                bVar.f6247a = j;
                bVar.e = 1;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(eVar, bVar);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lazy = lazy2;
                list2 = listEmptyList2;
            } else {
                if (i2 == 1) {
                    j = bVar.f6247a;
                    List list5 = (List) bVar.c;
                    Lazy lazy3 = (Lazy) bVar.b;
                    ResultKt.throwOnFailure(objCoroutineScope);
                    list2 = list5;
                    lazy = lazy3;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list3 = (List) bVar.b;
                    ResultKt.throwOnFailure(objCoroutineScope);
                }
                linkedHashMap = new LinkedHashMap();
                linkedHashMap2 = new LinkedHashMap();
                linkedHashMap3 = new LinkedHashMap();
                linkedHashMap4 = new LinkedHashMap();
                arrayList = new ArrayList();
                for (Pair pair : CollectionsKt.plus((Collection) list3, (Iterable) objCoroutineScope)) {
                    aVar = (com.moloco.sdk.internal.publisher.nativead.model.b.a) pair.component1();
                    vVar = (v) pair.component2();
                    if (vVar instanceof v.a) {
                        arrayList.add(TuplesKt.to(aVar, ((v.a) vVar).a()));
                    } else if (vVar instanceof v.b) {
                        cVar = (com.moloco.sdk.internal.publisher.nativead.model.c) ((v.b) vVar).a();
                        if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.a) {
                            Pair pair2 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                            linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
                        } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.b) {
                            Pair pair3 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                            linkedHashMap2.put(pair3.getFirst(), pair3.getSecond());
                        } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.C0551c) {
                            Pair pair4 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                            linkedHashMap3.put(pair4.getFirst(), pair4.getSecond());
                        } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.d) {
                            Pair pair5 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                            linkedHashMap4.put(pair5.getFirst(), pair5.getSecond());
                        }
                    }
                }
                return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.d(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, arrayList));
            }
            list3 = (List) objCoroutineScope;
            d dVar = new d(list2, lazy, j, null);
            bVar.b = list3;
            bVar.c = null;
            bVar.e = 2;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(dVar, bVar);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
            linkedHashMap = new LinkedHashMap();
            linkedHashMap2 = new LinkedHashMap();
            linkedHashMap3 = new LinkedHashMap();
            linkedHashMap4 = new LinkedHashMap();
            arrayList = new ArrayList();
            while (r11.hasNext()) {
                aVar = (com.moloco.sdk.internal.publisher.nativead.model.b.a) pair.component1();
                vVar = (v) pair.component2();
                if (vVar instanceof v.a) {
                    arrayList.add(TuplesKt.to(aVar, ((v.a) vVar).a()));
                } else if (vVar instanceof v.b) {
                    cVar = (com.moloco.sdk.internal.publisher.nativead.model.c) ((v.b) vVar).a();
                    if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.a) {
                        Pair pair6 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                        linkedHashMap.put(pair6.getFirst(), pair6.getSecond());
                    } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.b) {
                        Pair pair7 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                        linkedHashMap2.put(pair7.getFirst(), pair7.getSecond());
                    } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.C0551c) {
                        Pair pair8 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                        linkedHashMap3.put(pair8.getFirst(), pair8.getSecond());
                    } else if (cVar instanceof com.moloco.sdk.internal.publisher.nativead.model.c.d) {
                        Pair pair9 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                        linkedHashMap4.put(pair9.getFirst(), pair9.getSecond());
                    }
                }
            }
            return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.d(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, arrayList));
        } catch (com.moloco.sdk.internal.publisher.nativead.parser.b e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f6245a, "Failed to prepare required assets", e2, false, 8, null);
            return new v.a(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b c0549b, i iVar, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) throws Throwable {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            String strE = c0549b.e();
            aVar.f6246a = c0549b;
            aVar.c = 1;
            objA = iVar.a(strE, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0549b = (com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b) aVar.f6246a;
            ResultKt.throwOnFailure(objA);
        }
        i.a aVar2 = (i.a) objA;
        if (aVar2 instanceof i.a.b) {
            try {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f6245a, "Successfully loaded image asset media", null, false, 12, null);
                String absolutePath = ((i.a.b) aVar2).a().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "mediaCacheResult.file.absolutePath");
                Uri uri = Uri.parse(absolutePath);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
                return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.c.b(c0549b, uri));
            } catch (Exception e2) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, f6245a, "Failed to prepare image asset", e2, false, 8, null);
                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_IMAGE_PREPARE_ASSET_UNKNOWN_ERROR);
            }
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f6245a, "Failed to fetch image asset media", null, false, 12, null);
        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_IMAGE_ASSET_MEDIA_FETCH_ERROR);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0099  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:29:0x00be  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(com.moloco.sdk.internal.publisher.nativead.model.b.a.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) throws Throwable {
        f fVar;
        v vVar;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i = fVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                fVar.e = i - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuation);
            }
        } else {
            fVar = new f(continuation);
        }
        Object objA = fVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = fVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            String strC = dVar.c();
            fVar.f6253a = dVar;
            fVar.b = dVar2;
            fVar.c = j;
            fVar.e = 1;
            objA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d.a.a(dVar2, strC, null, true, fVar, 2, null);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                j = fVar.c;
                dVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d) fVar.b;
                dVar = (com.moloco.sdk.internal.publisher.nativead.model.b.a.d) fVar.f6253a;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dVar = (com.moloco.sdk.internal.publisher.nativead.model.b.a.d) fVar.f6253a;
                ResultKt.throwOnFailure(objA);
            }
            vVar = (v) objA;
            if (vVar instanceof v.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f6245a, "Successfully loaded video asset media", null, false, 12, null);
                return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.c.d(dVar, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a()));
            }
            if (vVar instanceof v.a) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, f6245a, "Failed to fetch video asset media: " + ((v.a) vVar).a(), null, false, 12, null);
                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_VIDEO_ASSET_MEDIA_NOT_ENOUGH_ERROR);
            }
            throw new NoWhenBranchMatchedException();
        }
        v vVar2 = (v) objA;
        if (vVar2 instanceof v.b) {
            long duration = DurationKt.toDuration(Duration.m9250getInWholeMillisecondsimpl(j) * 0.9d, DurationUnit.MILLISECONDS);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar2).a();
            fVar.f6253a = dVar;
            fVar.b = null;
            fVar.e = 2;
            objA = dVar2.a(aVar, duration, fVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar = (v) objA;
            if (vVar instanceof v.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f6245a, "Successfully loaded video asset media", null, false, 12, null);
                return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.c.d(dVar, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a()));
            }
            if (vVar instanceof v.a) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, f6245a, "Failed to fetch video asset media: " + ((v.a) vVar).a(), null, false, 12, null);
                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_VIDEO_ASSET_MEDIA_NOT_ENOUGH_ERROR);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(vVar2 instanceof v.a)) {
            throw new NoWhenBranchMatchedException();
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f6245a, "Failed to fetch video asset media: " + ((v.a) vVar2).a(), null, false, 12, null);
        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_VIDEO_ASSET_MEDIA_FETCH_ERROR);
    }

    public static /* synthetic */ Object a(com.moloco.sdk.internal.publisher.nativead.model.b.a.C0549b c0549b, i iVar, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = com.moloco.sdk.service_locator.a.g.f6474a.a();
        }
        return b(c0549b, iVar, continuation);
    }
}
