package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.json.fe;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010&\u001a\u00020#¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0012¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0012¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0012¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0012¢\u0006\u0004\b\f\u0010\rJ#\u0010\f\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0012¢\u0006\u0004\b\f\u0010\u0011J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0012¢\u0006\u0004\b\f\u0010\u0014J\u000f\u0010\f\u001a\u00020\u0015H\u0012¢\u0006\u0004\b\f\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b$\u0010%R#\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0'8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b \u0010)R\u001b\u0010-\u001a\u00020+8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b$\u0010,R#\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020'8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b\u001c\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0012@\u0012X\u0092\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/chartboost/sdk/impl/w1;", "", "Lcom/chartboost/sdk/impl/r5;", "h", "()Lcom/chartboost/sdk/impl/r5;", "", InneractiveMediationDefs.GENDER_FEMALE, "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "g", "Landroid/content/Context;", "context", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/r5;", "", "advertisingID", CommonUrlParts.UUID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/google/android/gms/appset/AppSetIdInfo;", "appSetInfo", "(Lcom/google/android/gms/appset/AppSetIdInfo;)V", "", "()Z", "Landroid/content/Context;", "Lcom/chartboost/sdk/impl/v0;", "Lcom/chartboost/sdk/impl/v0;", "android", "Lcom/chartboost/sdk/impl/q5;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/q5;", POBConstants.KEY_IFA, "Lcom/chartboost/sdk/impl/n1;", "d", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/Lazy;", "()Ljava/util/concurrent/atomic/AtomicReference;", "setId", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setIdScope", "identityBodyFields", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "identityJob", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/v0;Lcom/chartboost/sdk/impl/q5;Lcom/chartboost/sdk/impl/n1;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final v0 android;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final q5 ifa;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final n1 base64Wrapper;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final CoroutineDispatcher ioDispatcher;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy setId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Lazy setIdScope;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy identityBodyFields;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public volatile Job identityJob;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/r5;", "a", "()Ljava/util/concurrent/atomic/AtomicReference;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<AtomicReference<r5>> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicReference<r5> invoke() {
            return new AtomicReference<>(null);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.identity.CBIdentity$launchIdentityJob$1", f = "CBIdentity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return w1.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            w1.this.b();
            w1.this.identityJob = null;
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/atomic/AtomicReference;", "", "a", "()Ljava/util/concurrent/atomic/AtomicReference;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<AtomicReference<String>> {
        public static final d b = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicReference<String> invoke() {
            return new AtomicReference<>(null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/atomic/AtomicInteger;", "a", "()Ljava/util/concurrent/atomic/AtomicInteger;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<AtomicInteger> {
        public static final e b = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicInteger invoke() {
            return new AtomicInteger();
        }
    }

    public w1(Context context, v0 android2, q5 ifa, n1 base64Wrapper, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(android2, "android");
        Intrinsics.checkNotNullParameter(ifa, "ifa");
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.context = context;
        this.android = android2;
        this.ifa = ifa;
        this.base64Wrapper = base64Wrapper;
        this.ioDispatcher = ioDispatcher;
        this.setId = LazyKt.lazy(d.b);
        this.setIdScope = LazyKt.lazy(e.b);
        this.identityBodyFields = LazyKt.lazy(a.b);
        f();
    }

    public final AtomicReference<String> d() {
        return (AtomicReference) this.setId.getValue();
    }

    public final AtomicInteger e() {
        return (AtomicInteger) this.setIdScope.getValue();
    }

    public final AtomicReference<r5> c() {
        return (AtomicReference) this.identityBodyFields.getValue();
    }

    public r5 h() {
        if (this.identityJob == null) {
            f();
            Unit unit = Unit.INSTANCE;
        }
        r5 r5Var = c().get();
        return r5Var == null ? a(this.context) : r5Var;
    }

    public final void f() {
        try {
            this.identityJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new b(null), 3, null);
        } catch (Throwable th) {
            b7.b("Error launching identity job", th);
        }
    }

    public final void b() {
        g();
        c().set(a(this.context));
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/google/android/gms/appset/AppSetIdInfo;", "appSetInfo", "", "a", "(Lcom/google/android/gms/appset/AppSetIdInfo;)V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<AppSetIdInfo, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppSetIdInfo appSetIdInfo) {
            a(appSetIdInfo);
            return Unit.INSTANCE;
        }

        public final void a(AppSetIdInfo appSetIdInfo) {
            w1.this.a(appSetIdInfo);
        }
    }

    public final void g() {
        try {
            if (a()) {
                Task<AppSetIdInfo> taskA = this.android.a(this.context);
                if (taskA != null) {
                    final c cVar = new c();
                    taskA.addOnSuccessListener(new OnSuccessListener() { // from class: com.chartboost.sdk.impl.w1$$ExternalSyntheticLambda0
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            w1.a(cVar, obj);
                        }
                    });
                }
            } else {
                b7.b("AppSetId dependency not present", null, 2, null);
            }
        } catch (Exception e2) {
            b7.b("Error requesting AppSetId", e2);
        }
    }

    public /* synthetic */ w1(Context context, v0 v0Var, q5 q5Var, n1 n1Var, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, v0Var, q5Var, n1Var, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final String a(String advertisingID, String uuid) {
        JSONObject jSONObject = new JSONObject();
        if (advertisingID != null) {
            z1.a(jSONObject, fe.Q0, advertisingID);
        } else if (uuid != null) {
            z1.a(jSONObject, CommonUrlParts.UUID, uuid);
        }
        String str = d().get();
        if (str != null) {
            z1.a(jSONObject, "appsetid", str);
        }
        n1 n1Var = this.base64Wrapper;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "obj.toString()");
        return n1Var.c(string);
    }

    public final r5 a(Context context) {
        try {
            r0 r0VarA = this.ifa.a();
            b7.b("IFA: " + r0VarA, null, 2, null);
            String advertisingID = r0VarA.getAdvertisingID();
            qa advertisingIDState = r0VarA.getAdvertisingIDState();
            String strA = this.ifa.a(context, advertisingIDState == qa.TRACKING_LIMITED);
            if (advertisingID != null) {
                strA = "000000000";
            }
            String str = strA;
            if (k9.f1061a.d()) {
                k9.b(advertisingID);
                k9.c(str);
            }
            return new r5(advertisingIDState, a(advertisingID, str), str, advertisingID, d().get(), Integer.valueOf(e().get()));
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null) {
                b7.b(message, null, 2, null);
            }
            return new r5(null, null, null, null, null, null, 63, null);
        }
    }

    public final void a(AppSetIdInfo appSetInfo) {
        if (appSetInfo != null) {
            d().set(appSetInfo.getId());
            e().set(appSetInfo.getScope());
        }
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final boolean a() {
        try {
            Class.forName("com.google.android.gms.appset.AppSet");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
