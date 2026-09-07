package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/UrlPostRequestWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moloco-sdk_release", "url", ""}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UrlPostRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f7189a = {Reflection.property0(new PropertyReference0Impl(UrlPostRequestWorker.class, "url", "<v#0>", 0))};

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlPostRequestWorker", f = "PersistentHttpRequest.kt", i = {0, 0}, l = {103}, m = "doWork", n = {"this", "url$delegate"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7190a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return UrlPostRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlPostRequestWorker(Context context, WorkerParameters params) {
        super(com.moloco.sdk.internal.android_context.b.a(context), params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public static final String a(Map<String, Object> map) {
        Intrinsics.checkNotNullExpressionValue(map, "doWork$lambda$0(...)");
        return (String) MapsKt.getOrImplicitDefaultNullable(map, f7189a[0].getName());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) throws Throwable {
        a aVar;
        ContentType contentType;
        UrlPostRequestWorker urlPostRequestWorker;
        Map<String, Object> map;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            HttpClient httpClientA = com.moloco.sdk.service_locator.a.i.f6483a.a();
            Map<String, Object> keyValueMap = getInputData().getKeyValueMap();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Sending request to " + a(keyValueMap), null, false, 12, null);
            byte[] byteArray = getInputData().getByteArray("body");
            if (byteArray == null) {
                ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(resultFailure, "failure()");
                return resultFailure;
            }
            String string = getInputData().getString("contentType");
            if (string == null || (contentType = ContentType.INSTANCE.parse(string)) == null) {
                ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(resultFailure2, "failure()");
                return resultFailure2;
            }
            String strA = a(keyValueMap);
            aVar.f7190a = this;
            aVar.b = keyValueMap;
            aVar.e = 1;
            objA = e.a(httpClientA, strA, byteArray, contentType, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            urlPostRequestWorker = this;
            map = keyValueMap;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) aVar.b;
            urlPostRequestWorker = (UrlPostRequestWorker) aVar.f7190a;
            ResultKt.throwOnFailure(objA);
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Request to " + a(map) + " was successful: " + zBooleanValue, null, false, 12, null);
        if (zBooleanValue) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(resultSuccess, "success()");
            return resultSuccess;
        }
        if (urlPostRequestWorker.getRunAttemptCount() >= 5) {
            ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure3, "failure()");
            return resultFailure3;
        }
        ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
        Intrinsics.checkNotNullExpressionValue(resultRetry, "retry()");
        return resultRetry;
    }
}
