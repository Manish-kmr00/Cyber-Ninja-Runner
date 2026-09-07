package com.moloco.sdk.acm.http;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.UserAgent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6039a = LazyKt.lazy(a.f6040a);

    public static final class a extends Lambda implements Function0<HttpClient> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6040a = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.acm.http.c$a$a, reason: collision with other inner class name */
        public static final class C0529a extends Lambda implements Function1<HttpClientConfig<?>, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0529a f6041a = new C0529a();

            public C0529a() {
                super(1);
            }

            public final void a(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClientConfig.install$default(HttpClient, UserAgent.INSTANCE, null, 2, null);
                HttpClientConfig.install$default(HttpClient, HttpTimeout.INSTANCE, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                a(httpClientConfig);
                return Unit.INSTANCE;
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HttpClient invoke() {
            return HttpClientJvmKt.HttpClient(C0529a.f6041a);
        }
    }

    public static final HttpClient a() {
        return (HttpClient) f6039a.getValue();
    }

    public static final HttpClient b() {
        return a();
    }
}
