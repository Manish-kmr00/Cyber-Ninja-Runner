package com.moloco.sdk.acm.http;

import io.ktor.client.HttpClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static HttpClient b;
    public static String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6037a = new b();
    public static final Lazy d = LazyKt.lazy(a.f6038a);

    public static final class a extends Lambda implements Function0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6038a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f invoke() {
            HttpClient httpClient = b.b;
            String str = null;
            if (httpClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("httpClient");
                httpClient = null;
            }
            String str2 = b.c;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("apiUrl");
            } else {
                str = str2;
            }
            return new f(httpClient, str);
        }
    }

    public final e c() {
        return (e) d.getValue();
    }

    public final void a(HttpClient httpClient, String apiUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        if (b == null) {
            b = httpClient;
            c = apiUrl;
        }
    }
}
