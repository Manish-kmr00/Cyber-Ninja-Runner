package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.moloco.sdk.acm.db.MetricsDb;
import io.ktor.http.HeadersBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0006\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/moloco/sdk/acm/eventprocessing/DBRequestWorker;", "Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Ljava/lang/String;", "TAG", "Lcom/moloco/sdk/acm/db/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/moloco/sdk/acm/db/d;", "metricsDAO", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "url", "", "d", "Ljava/util/Map;", "clientOptions", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "e", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "headers", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0})
public final class DBRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final com.moloco.sdk.acm.db.d metricsDAO;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Map<String, String> clientOptions;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function1<HeadersBuilder, Unit> headers;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.DBRequestWorker", f = "DBWorkRequest.kt", i = {0}, l = {110}, m = "doWork", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6019a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return DBRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBRequestWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.TAG = "DBRequestWorker";
        this.metricsDAO = MetricsDb.INSTANCE.b(context).b();
        this.url = getInputData().getString("url");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(com.moloco.sdk.acm.b.e, getInputData().getString(com.moloco.sdk.acm.b.e)), TuplesKt.to(com.moloco.sdk.acm.b.f, getInputData().getString(com.moloco.sdk.acm.b.f)), TuplesKt.to(com.moloco.sdk.acm.b.g, getInputData().getString(com.moloco.sdk.acm.b.g)), TuplesKt.to(com.moloco.sdk.acm.b.d, getInputData().getString(com.moloco.sdk.acm.b.d)), TuplesKt.to("osv", getInputData().getString("osv")), TuplesKt.to(com.moloco.sdk.acm.b.h, getInputData().getString(com.moloco.sdk.acm.b.h)), TuplesKt.to(com.moloco.sdk.acm.b.b, getInputData().getString(com.moloco.sdk.acm.b.b)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapMapOf.entrySet()) {
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.clientOptions = linkedHashMap;
        this.headers = new com.moloco.sdk.acm.http.a().a((String) linkedHashMap.get(com.moloco.sdk.acm.b.h), (String) linkedHashMap.get("osv"), (String) linkedHashMap.get(com.moloco.sdk.acm.b.e), (String) linkedHashMap.get(com.moloco.sdk.acm.b.f), (String) linkedHashMap.get(com.moloco.sdk.acm.b.g), (String) linkedHashMap.get(com.moloco.sdk.acm.b.b));
    }

    public final Function1<HeadersBuilder, Unit> a() {
        return this.headers;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) throws Throwable {
        a aVar;
        DBRequestWorker dBRequestWorker;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                if (this.url != null) {
                    com.moloco.sdk.acm.http.b bVar = com.moloco.sdk.acm.http.b.f6037a;
                    bVar.a(com.moloco.sdk.acm.http.c.b(), this.url);
                    k kVar = new k(bVar.c(), this.metricsDAO, new f(new com.moloco.sdk.acm.services.h(), 720L), this.headers);
                    aVar.f6019a = this;
                    aVar.d = 1;
                    if (kVar.a(aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dBRequestWorker = this;
            } catch (Exception e) {
                e = e;
                dBRequestWorker = this;
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, dBRequestWorker.TAG, "Work Manager failure: " + e.getMessage(), null, false, 12, null);
                ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(resultFailure, "{\n            MolocoMetr…esult.failure()\n        }");
                return resultFailure;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dBRequestWorker = (DBRequestWorker) aVar.f6019a;
            try {
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            } catch (Exception e2) {
                e = e2;
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, dBRequestWorker.TAG, "Work Manager failure: " + e.getMessage(), null, false, 12, null);
                ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(resultFailure2, "{\n            MolocoMetr…esult.failure()\n        }");
                return resultFailure2;
            }
        }
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "{\n            if (url !=…esult.success()\n        }");
        return resultSuccess;
    }
}
