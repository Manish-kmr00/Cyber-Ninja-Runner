package io.bidmachine.analytics;

import android.content.Context;
import android.util.Base64;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.bidmachine.analytics.internal.AbstractC4629e;
import io.bidmachine.analytics.internal.C;
import io.bidmachine.analytics.internal.C4625a;
import io.bidmachine.analytics.internal.C4635k;
import io.bidmachine.analytics.internal.C4637m;
import io.bidmachine.analytics.internal.C4642s;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\t\u0010\rJ/\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00100\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rR \u0010\u001f\u001a\u00020\u00198\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00118\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lio/bidmachine/analytics/BidMachineAnalytics;", "", "Landroid/content/Context;", "context", "", MobileAdsBridgeBase.initializeMethodName, "(Landroid/content/Context;)V", "Lio/bidmachine/analytics/AnalyticsConfig;", "analyticsConfig", "configure", "(Landroid/content/Context;Lio/bidmachine/analytics/AnalyticsConfig;)V", "Lio/bidmachine/analytics/ConfigureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/content/Context;Lio/bidmachine/analytics/AnalyticsConfig;Lio/bidmachine/analytics/ConfigureListener;)V", "", "typeId", "", "", "getImpData", "(I)Ljava/util/Map;", "", "outPublicKey", "Lio/bidmachine/analytics/internal/s;", "a", "([B)Lio/bidmachine/analytics/internal/s;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "getScope$bidmachine_android_sdk_analytics_b_2_2_4", "()Lkotlinx/coroutines/CoroutineScope;", "getScope$bidmachine_android_sdk_analytics_b_2_2_4$annotations", "()V", "scope", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getSessionId$bidmachine_android_sdk_analytics_b_2_2_4", "()Ljava/lang/String;", JsonStorageKeyNames.SESSION_ID_KEY, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lio/bidmachine/analytics/internal/s;", "getEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4", "()Lio/bidmachine/analytics/internal/s;", "setEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4", "(Lio/bidmachine/analytics/internal/s;)V", "encryptionManager", "<init>", "bidmachine-android-sdk-analytics_b_2_2_4"}, k = 1, mv = {1, 7, 1})
public final class BidMachineAnalytics {
    public static final BidMachineAnalytics INSTANCE = new BidMachineAnalytics();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(ExecutorsKt.from(Executors.newSingleThreadExecutor())));

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static String sessionId = "";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static C4642s encryptionManager;

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12037a;
        private /* synthetic */ Object b;
        final /* synthetic */ AnalyticsConfig c;
        final /* synthetic */ String d;
        final /* synthetic */ Context e;
        final /* synthetic */ ConfigureListener f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AnalyticsConfig analyticsConfig, String str, Context context, ConfigureListener configureListener, Continuation continuation) {
            super(2, continuation);
            this.c = analyticsConfig;
            this.d = str;
            this.e = context;
            this.f = configureListener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = new a(this.c, this.d, this.e, this.f, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7904constructorimpl;
            Object objM7904constructorimpl2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12037a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnalyticsConfig analyticsConfig = this.c;
            try {
                Result.Companion companion = Result.INSTANCE;
                BidMachineAnalytics bidMachineAnalytics = BidMachineAnalytics.INSTANCE;
                bidMachineAnalytics.setEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4(bidMachineAnalytics.a(Base64.decode(analyticsConfig.getBpk(), 2)));
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
            }
            Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            Context context = this.e;
            AnalyticsConfig analyticsConfig2 = this.c;
            ConfigureListener configureListener = this.f;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                BidMachineAnalytics.INSTANCE.a(context, analyticsConfig2, configureListener);
                objM7904constructorimpl2 = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m7911isSuccessimpl(objM7904constructorimpl2)) {
            }
            Result.m7907exceptionOrNullimpl(objM7904constructorimpl2);
            return Unit.INSTANCE;
        }
    }

    private BidMachineAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, AnalyticsConfig analyticsConfig, ConfigureListener listener) {
        C4637m.f12113a.a(context, analyticsConfig);
        C4635k.f12101a.a(context, analyticsConfig);
        if (listener != null) {
            listener.onConfigured();
        }
    }

    @JvmStatic
    public static final void configure(Context context, AnalyticsConfig analyticsConfig) {
        configure(context, analyticsConfig, null);
    }

    @JvmStatic
    public static final Map<String, Map<String, Object>> getImpData(int typeId) {
        AbstractC4629e.a aVar = (AbstractC4629e.a) ArraysKt.getOrNull(AbstractC4629e.a.values(), typeId);
        return aVar == null ? MapsKt.emptyMap() : C4635k.f12101a.a(aVar);
    }

    public static /* synthetic */ void getScope$bidmachine_android_sdk_analytics_b_2_2_4$annotations() {
    }

    @JvmStatic
    public static final void initialize(Context context) {
        C4635k.f12101a.b(context.getApplicationContext());
    }

    public final C4642s getEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4() {
        return encryptionManager;
    }

    public final CoroutineScope getScope$bidmachine_android_sdk_analytics_b_2_2_4() {
        return scope;
    }

    public final String getSessionId$bidmachine_android_sdk_analytics_b_2_2_4() {
        return sessionId;
    }

    public final void setEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4(C4642s c4642s) {
        encryptionManager = c4642s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4642s a(byte[] outPublicKey) {
        C4625a c4625a = new C4625a();
        return new C4642s(c4625a, new C(outPublicKey, c4625a.getName(), null, false, 12, null));
    }

    @JvmStatic
    public static final void configure(Context context, AnalyticsConfig analyticsConfig, ConfigureListener listener) {
        String str = analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String();
        sessionId = str;
        initialize(context);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new a(analyticsConfig, str, context.getApplicationContext(), listener, null), 3, null);
    }
}
