package com.moloco.sdk.internal.http;

import com.moloco.sdk.internal.services.j;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.DefaultRequestKt;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.UserAgent;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a, reason: collision with other inner class name */
    public static final class C0533a extends Lambda implements Function1<HttpClientConfig<?>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f6100a;
        public final /* synthetic */ x b;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$a, reason: collision with other inner class name */
        public static final class C0534a extends Lambda implements Function1<UserAgent.Config, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0534a f6101a = new C0534a();

            public C0534a() {
                super(1);
            }

            public final void a(UserAgent.Config install) {
                Intrinsics.checkNotNullParameter(install, "$this$install");
                install.setAgent(com.moloco.sdk.xenoss.sdkdevkit.android.core.b.a().invoke());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserAgent.Config config) {
                a(config);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$b */
        public static final class b extends Lambda implements Function1<DefaultRequest.DefaultRequestBuilder, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f6102a;
            public final /* synthetic */ x b;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$b$a, reason: collision with other inner class name */
            public static final class C0535a extends Lambda implements Function1<HeadersBuilder, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ j f6103a;
                public final /* synthetic */ x b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0535a(j jVar, x xVar) {
                    super(1);
                    this.f6103a = jVar;
                    this.b = xVar;
                }

                public final void a(HeadersBuilder headers) {
                    String str;
                    Intrinsics.checkNotNullParameter(headers, "$this$headers");
                    StringBuilder sbAppend = new StringBuilder("AppBundle/").append(this.f6103a.b()).append("; AppVersion/").append(this.f6103a.c()).append("; AppKey/");
                    Moloco moloco = Moloco.INSTANCE;
                    headers.append("X-Moloco-App-Info", sbAppend.append(moloco.getAppKey$moloco_sdk_release()).append(';').toString());
                    headers.append("X-Moloco-Device-Info", "make/" + this.b.p() + "; model/" + this.b.r() + "; hwv/" + this.b.n() + "; osv/" + this.b.t() + "; OS/Android;");
                    MediationInfo mediationInfo$moloco_sdk_release = moloco.getMediationInfo$moloco_sdk_release();
                    if (mediationInfo$moloco_sdk_release == null || (str = "Mediator/" + mediationInfo$moloco_sdk_release.getName() + ';') == null) {
                        str = "";
                    }
                    headers.append("X-Moloco-SDK-Info", "SdkVersion/3.8.0; " + str);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
                    a(headersBuilder);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(j jVar, x xVar) {
                super(1);
                this.f6102a = jVar;
                this.b = xVar;
            }

            public final void a(DefaultRequest.DefaultRequestBuilder defaultRequest) {
                Intrinsics.checkNotNullParameter(defaultRequest, "$this$defaultRequest");
                HttpRequestKt.headers(defaultRequest, new C0535a(this.f6102a, this.b));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DefaultRequest.DefaultRequestBuilder defaultRequestBuilder) {
                a(defaultRequestBuilder);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0533a(j jVar, x xVar) {
            super(1);
            this.f6100a = jVar;
            this.b = xVar;
        }

        public final void a(HttpClientConfig<?> HttpClient) {
            Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
            HttpClient.install(UserAgent.INSTANCE, C0534a.f6101a);
            HttpClientConfig.install$default(HttpClient, HttpTimeout.INSTANCE, null, 2, null);
            HttpClientConfig.install$default(HttpClient, HttpRequestRetry.INSTANCE, null, 2, null);
            DefaultRequestKt.defaultRequest(HttpClient, new b(this.f6100a, this.b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
            a(httpClientConfig);
            return Unit.INSTANCE;
        }
    }

    public static final HttpClient a(j appInfo, x deviceInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return HttpClientJvmKt.HttpClient(new C0533a(appInfo, deviceInfo));
    }
}
