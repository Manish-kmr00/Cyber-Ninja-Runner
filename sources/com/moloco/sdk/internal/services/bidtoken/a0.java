package com.moloco.sdk.internal.services.bidtoken;

import android.os.Build;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.j0;
import io.ktor.client.HttpClient;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6307a = LazyKt.lazy(a.f6308a);

    public static final class a extends Lambda implements Function0<z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6308a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z invoke() {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ServerBidTokenService", "Creating BidTokenService instance", null, false, 12, null);
            com.moloco.sdk.service_locator.a.e eVar = com.moloco.sdk.service_locator.a.e.f6462a;
            HttpClient httpClientA = com.moloco.sdk.internal.http.a.a(eVar.b().invoke(), eVar.f().invoke());
            j jVar = new j(2800L, 3, 200L);
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            String str = Build.MANUFACTURER;
            String str2 = str == null ? "" : str;
            String str3 = Build.MODEL;
            String str4 = str3 == null ? "" : str3;
            String str5 = Build.HARDWARE;
            return new z(new c(BuildConfig.SDK_VERSION_NAME, httpClientA, jVar, new g(language, RELEASE, str2, str4, str5 == null ? "" : str5)), CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(com.moloco.sdk.internal.scheduling.b.a().getIo())), v.f6344a.a(new com.moloco.sdk.internal.bidtoken.c(), new j0()));
        }
    }

    public static final z b() {
        return (z) f6307a.getValue();
    }
}
