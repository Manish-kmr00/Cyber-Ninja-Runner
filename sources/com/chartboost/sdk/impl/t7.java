package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.R;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020%\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\b\b\u0002\u0010.\u001a\u00020,¢\u0006\u0004\b/\u00100J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u001cJ!\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0013\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u0015R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-¨\u00061"}, d2 = {"Lcom/chartboost/sdk/impl/t7;", "", "", "e", "()V", "", InneractiveMediationDefs.GENDER_FEMALE, "()Z", "g", "h", "", "Lcom/chartboost/sdk/impl/eb;", "d", "()Ljava/util/List;", "Lcom/chartboost/sdk/impl/n7;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/n7;", "", "html", "a", "(Ljava/lang/String;)Ljava/lang/String;", "()Ljava/lang/String;", "Lcom/chartboost/sdk/impl/f8;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/f8;", "", "resourceId", "sharedPrefsKey", "(ILjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;I)Ljava/lang/String;", "i", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/u9;", "Lcom/chartboost/sdk/impl/u9;", "sharedPrefsHelper", "Lcom/chartboost/sdk/impl/g9;", "Lcom/chartboost/sdk/impl/g9;", "resourcesLoader", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/u9;Lcom/chartboost/sdk/impl/g9;Ljava/util/concurrent/atomic/AtomicReference;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final u9 sharedPrefsHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final g9 resourcesLoader;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final AtomicReference<o9> sdkConfig;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final CoroutineDispatcher mainDispatcher;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.measurement.OpenMeasurementManager$initialize$1", f = "OpenMeasurementManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return t7.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                p7.a(t7.this.context);
                b7.a("OMSDK is initialized successfully!", (Throwable) null, 2, (Object) null);
            } catch (Exception e) {
                b7.b("OMSDK initialization exception", e);
            }
            return Unit.INSTANCE;
        }
    }

    public t7(Context context, u9 sharedPrefsHelper, g9 resourcesLoader, AtomicReference<o9> sdkConfig, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPrefsHelper, "sharedPrefsHelper");
        Intrinsics.checkNotNullParameter(resourcesLoader, "resourcesLoader");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.context = context;
        this.sharedPrefsHelper = sharedPrefsHelper;
        this.resourcesLoader = resourcesLoader;
        this.sdkConfig = sdkConfig;
        this.mainDispatcher = mainDispatcher;
    }

    public final boolean f() {
        try {
            return p7.b();
        } catch (Exception e) {
            b7.a("OMSDK error when checking isActive", e);
            return false;
        }
    }

    public final String i() {
        return "Chartboost";
    }

    public final void e() {
        if (!g()) {
            b7.a("OMSDK initialize is disabled by the cb config!", (Throwable) null, 2, (Object) null);
            return;
        }
        if (!f()) {
            try {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new a(null), 3, null);
                return;
            } catch (Exception e) {
                b7.b("Error launching om activate job", e);
                return;
            }
        }
        b7.a("OMSDK initialize is already active!", (Throwable) null, 2, (Object) null);
    }

    public /* synthetic */ t7(Context context, u9 u9Var, g9 g9Var, AtomicReference atomicReference, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, u9Var, g9Var, atomicReference, (i & 16) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    public final boolean g() {
        n7 n7VarB;
        o9 o9Var = this.sdkConfig.get();
        if (o9Var == null || (n7VarB = o9Var.b()) == null) {
            return false;
        }
        return n7VarB.getIsEnabled();
    }

    public final boolean h() {
        n7 n7VarB;
        o9 o9Var = this.sdkConfig.get();
        if (o9Var == null || (n7VarB = o9Var.b()) == null) {
            return false;
        }
        return n7VarB.getVerificationEnabled();
    }

    public final List<eb> d() {
        n7 n7VarB;
        List<eb> listE;
        o9 o9Var = this.sdkConfig.get();
        return (o9Var == null || (n7VarB = o9Var.b()) == null || (listE = n7VarB.e()) == null) ? CollectionsKt.emptyList() : listE;
    }

    public final n7 b() {
        o9 o9Var = this.sdkConfig.get();
        n7 n7VarB = o9Var != null ? o9Var.b() : null;
        return n7VarB == null ? new n7(false, false, 0, 0, 0L, 0, null, 127, null) : n7VarB;
    }

    public final f8 c() {
        try {
            return f8.a(i(), "9.8.3");
        } catch (Exception e) {
            b7.b("Omid Partner exception", e);
            return null;
        }
    }

    public final String a() {
        return a(R.raw.omsdk_v1, "com.chartboost.sdk.omidjs");
    }

    public final String a(int resourceId, String sharedPrefsKey) {
        try {
            String strA = this.sharedPrefsHelper.a(sharedPrefsKey);
            return strA == null ? a(sharedPrefsKey, resourceId) : strA;
        } catch (Exception e) {
            b7.b("OmidJS exception", e);
            return null;
        }
    }

    public final String a(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        if (!g()) {
            b7.b("OMSDK injectOmidJsIntoHtml is disabled by the cb config!", null, 2, null);
            return html;
        }
        if (!p7.b()) {
            return html;
        }
        try {
            String strA = m9.a(a(), html);
            Intrinsics.checkNotNullExpressionValue(strA, "{\n            ScriptInje…kJsLib(), html)\n        }");
            return strA;
        } catch (Exception e) {
            b7.b("OmidJS injection exception", e);
            return html;
        }
    }

    public final String a(String sharedPrefsKey, int resourceId) {
        try {
            String strA = this.resourcesLoader.a(resourceId);
            if (strA == null) {
                return null;
            }
            this.sharedPrefsHelper.a(sharedPrefsKey, strA);
            return strA;
        } catch (Exception e) {
            b7.b("OmidJS resource file exception", e);
            return null;
        }
    }
}
