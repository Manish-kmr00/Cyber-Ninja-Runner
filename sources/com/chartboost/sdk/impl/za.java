package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00120\b\u0002\u0010\u001d\u001a*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00120\u001a\u0012\b\b\u0002\u0010!\u001a\u00020\u001eø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\"\u0010#J)\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\rJ#\u0010\t\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0002¢\u0006\u0004\b\t\u0010\u0011J\\\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2(\u0010\u0015\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018RB\u0010\u001d\u001a*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00120\u001a8\u0002X\u0082\u0004ø\u0001\u0002ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/chartboost/sdk/impl/za;", "", "", "url", "Lcom/chartboost/sdk/impl/b3;", "clkp", "Lcom/chartboost/sdk/impl/f3;", "clickTracking", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/b3;Lcom/chartboost/sdk/impl/f3;)Lcom/chartboost/sdk/internal/Model/CBError$a;", "Lkotlin/Result;", "originalUrl", "(Ljava/lang/Object;Ljava/lang/String;Lcom/chartboost/sdk/impl/f3;)Ljava/lang/Object;", "Lcom/chartboost/sdk/impl/va;", "args", "", "(Lcom/chartboost/sdk/impl/va;Lcom/chartboost/sdk/impl/f3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/chartboost/sdk/impl/ua;", "action", "(Lkotlin/jvm/functions/Function2;Lcom/chartboost/sdk/impl/va;Lcom/chartboost/sdk/impl/f3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/chartboost/sdk/impl/ya;", "Lcom/chartboost/sdk/impl/ya;", "urlRedirect", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "actions", "Lkotlinx/coroutines/CoroutineDispatcher;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/chartboost/sdk/impl/ya;Ljava/util/List;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class za {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ya urlRedirect;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final List<Function2<va, Continuation<? super Result<ua>>, Object>> actions;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CoroutineDispatcher ioDispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "it", "Lkotlin/Result;", "Lcom/chartboost/sdk/impl/ua;", "<anonymous>", "(Lcom/chartboost/sdk/impl/va;)Lkotlin/Result;"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver$1", f = "UrlResolver.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<va, Continuation<? super Result<? extends ua>>, Object> {
        public int b;
        public /* synthetic */ Object c;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(va vaVar, Continuation<? super Result<ua>> continuation) {
            return ((a) create(vaVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(continuation);
            aVar.c = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                va vaVar = (va) this.c;
                this.b = 1;
                objC = com.chartboost.sdk.internal.clickthrough.b.c(vaVar, null, null, null, null, this, 30, null);
                if (objC == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objC = ((Result) obj).getValue();
            }
            return Result.m7903boximpl(objC);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "it", "Lkotlin/Result;", "Lcom/chartboost/sdk/impl/ua;", "<anonymous>", "(Lcom/chartboost/sdk/impl/va;)Lkotlin/Result;"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver$2", f = "UrlResolver.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<va, Continuation<? super Result<? extends ua>>, Object> {
        public int b;
        public /* synthetic */ Object c;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(va vaVar, Continuation<? super Result<ua>> continuation) {
            return ((b) create(vaVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.c = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                va vaVar = (va) this.c;
                this.b = 1;
                objA = com.chartboost.sdk.internal.clickthrough.b.a(vaVar, null, null, null, null, null, this, 62, null);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objA = ((Result) obj).getValue();
            }
            return Result.m7903boximpl(objA);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "it", "Lkotlin/Result;", "Lcom/chartboost/sdk/impl/ua;", "<anonymous>", "(Lcom/chartboost/sdk/impl/va;)Lkotlin/Result;"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver$3", f = "UrlResolver.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<va, Continuation<? super Result<? extends ua>>, Object> {
        public int b;
        public /* synthetic */ Object c;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(va vaVar, Continuation<? super Result<ua>> continuation) {
            return ((c) create(vaVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.c = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                va vaVar = (va) this.c;
                this.b = 1;
                objA = com.chartboost.sdk.internal.clickthrough.b.a(vaVar, null, null, null, null, this, 30, null);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objA = ((Result) obj).getValue();
            }
            return Result.m7903boximpl(objA);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "it", "Lkotlin/Result;", "Lcom/chartboost/sdk/impl/ua;", "<anonymous>", "(Lcom/chartboost/sdk/impl/va;)Lkotlin/Result;"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver$4", f = "UrlResolver.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<va, Continuation<? super Result<? extends ua>>, Object> {
        public int b;
        public /* synthetic */ Object c;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(va vaVar, Continuation<? super Result<ua>> continuation) {
            return ((d) create(vaVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(continuation);
            dVar.c = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                va vaVar = (va) this.c;
                this.b = 1;
                objB = com.chartboost.sdk.internal.clickthrough.b.b(vaVar, null, null, null, null, this, 30, null);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objB = ((Result) obj).getValue();
            }
            return Result.m7903boximpl(objB);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver", f = "UrlResolver.kt", i = {0, 0}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT}, m = "executeAndTrackAction-BWLJW6A", n = {"args", "clickTracking"}, s = {"L$0", "L$1"})
    public static final class e extends ContinuationImpl {
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object objA = za.this.a((Function2<? super va, ? super Continuation<? super Result<ua>>, ? extends Object>) null, (va) null, (f3) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver", f = "UrlResolver.kt", i = {0, 0, 0}, l = {71}, m = "executeUrlActions", n = {"this", "args", "clickTracking"}, s = {"L$0", "L$1", "L$2"})
    public static final class f extends ContinuationImpl {
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return za.this.a((va) null, (f3) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlResolver$resolve$1", f = "UrlResolver.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ String d;
        public final /* synthetic */ f3 e;
        public final /* synthetic */ b3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, f3 f3Var, b3 b3Var, Continuation<? super g> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = f3Var;
            this.f = b3Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return za.this.new g(this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                za zaVar = za.this;
                Object objA = zaVar.a(ya.a(zaVar.urlRedirect, this.d, 0, 2, null), this.d, this.e);
                String url = this.d;
                Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
                if (thM7907exceptionOrNullimpl == null) {
                    url = (String) objA;
                } else if (thM7907exceptionOrNullimpl instanceof ya.b.e) {
                    url = ((ya.b.e) thM7907exceptionOrNullimpl).getUrl();
                }
                va vaVar = new va(url, this.f);
                za zaVar2 = za.this;
                f3 f3Var = this.e;
                this.b = 1;
                if (zaVar2.a(vaVar, f3Var, this) == coroutine_suspended) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public za(ya urlRedirect, List<? extends Function2<? super va, ? super Continuation<? super Result<ua>>, ? extends Object>> actions, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(urlRedirect, "urlRedirect");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.urlRedirect = urlRedirect;
        this.actions = actions;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ za(ya yaVar, List list, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(yaVar, (i & 2) != 0 ? CollectionsKt.listOf((Object[]) new Function2[]{new a(null), new b(null), new c(null), new d(null)}) : list, (i & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Function2<? super va, ? super Continuation<? super Result<ua>>, ? extends Object> function2, va vaVar, f3 f3Var, Continuation<? super Result<ua>> continuation) throws Throwable {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.f = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object objInvoke = eVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            eVar.b = vaVar;
            eVar.c = f3Var;
            eVar.f = 1;
            objInvoke = function2.invoke(vaVar, eVar);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f3Var = (f3) eVar.c;
            vaVar = (va) eVar.b;
            ResultKt.throwOnFailure(objInvoke);
        }
        Object value = ((Result) objInvoke).getValue();
        if (Result.m7911isSuccessimpl(value)) {
            f3Var.a("Url " + vaVar.getUrl() + " opened with action " + ((ua) value).getCom.ironsource.b9.h.v0 java.lang.String());
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(value);
        if (thM7907exceptionOrNullimpl != null && !(thM7907exceptionOrNullimpl instanceof com.chartboost.sdk.internal.clickthrough.a)) {
            f3Var.b("Url " + vaVar.getUrl() + " opening failed with error " + thM7907exceptionOrNullimpl);
        }
        return value;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0076 A[LOOP:0: B:15:0x0064->B:19:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x008b A[EDGE_INSN: B:23:0x008b->B:24:0x008f BREAK  A[LOOP:0: B:15:0x0064->B:19:0x0076]] */
    /* JADX WARN: Code duplicated, block: B:31:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008b -> B:24:0x008f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(com.chartboost.sdk.impl.va r9, com.chartboost.sdk.impl.f3 r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.chartboost.sdk.impl.za.f
            if (r0 == 0) goto L13
            r0 = r11
            com.chartboost.sdk.impl.za$f r0 = (com.chartboost.sdk.impl.za.f) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            com.chartboost.sdk.impl.za$f r0 = new com.chartboost.sdk.impl.za$f
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r9 = r0.e
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.d
            com.chartboost.sdk.impl.f3 r10 = (com.chartboost.sdk.impl.f3) r10
            java.lang.Object r2 = r0.c
            com.chartboost.sdk.impl.va r2 = (com.chartboost.sdk.impl.va) r2
            java.lang.Object r4 = r0.b
            com.chartboost.sdk.impl.za r4 = (com.chartboost.sdk.impl.za) r4
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.getValue()
            goto L8f
        L3f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L47:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List<kotlin.jvm.functions.Function2<com.chartboost.sdk.impl.va, kotlin.coroutines.Continuation<? super kotlin.Result<com.chartboost.sdk.impl.ua>>, java.lang.Object>> r11 = r8.actions
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m7904constructorimpl(r2)
            java.util.Iterator r11 = r11.iterator()
            r4 = r8
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
        L64:
            boolean r5 = r9.hasNext()
            if (r5 == 0) goto L94
            java.lang.Object r5 = r9.next()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Throwable r6 = kotlin.Result.m7907exceptionOrNullimpl(r2)
            if (r6 != 0) goto L7a
            r5 = r2
            com.chartboost.sdk.impl.ua r5 = (com.chartboost.sdk.impl.ua) r5
            goto L64
        L7a:
            r0.b = r4
            r0.c = r10
            r0.d = r11
            r0.e = r9
            r0.h = r3
            java.lang.Object r2 = r4.a(r5, r10, r11, r0)
            if (r2 != r1) goto L8b
            return r1
        L8b:
            r7 = r2
            r2 = r10
            r10 = r11
            r11 = r7
        L8f:
            r7 = r11
            r11 = r10
            r10 = r2
            r2 = r7
            goto L64
        L94:
            java.lang.Throwable r9 = kotlin.Result.m7907exceptionOrNullimpl(r2)
            if (r9 == 0) goto Lb0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "None of the actions was able to process URL "
            r9.<init>(r0)
            java.lang.String r10 = r10.getUrl()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            r11.b(r9)
        Lb0:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.za.a(com.chartboost.sdk.impl.va, com.chartboost.sdk.impl.f3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CBError.a a(String url, b3 clkp, f3 clickTracking) {
        Intrinsics.checkNotNullParameter(clkp, "clkp");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        if (url != null && url.length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new g(url, clickTracking, clkp, null), 3, null);
            return null;
        }
        return CBError.a.URI_INVALID;
    }

    public final Object a(Object obj, String str, f3 f3Var) {
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(obj);
        if (thM7907exceptionOrNullimpl == null) {
            f3Var.a("Redirection successful from " + str + " to " + ((String) obj));
        } else {
            f3Var.b("Redirection failed for " + str + ": " + thM7907exceptionOrNullimpl);
        }
        return obj;
    }
}
