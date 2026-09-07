package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.a$a, reason: collision with other inner class name */
    public static final class C0704a extends Lambda implements Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7177a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0704a(long j) {
            super(1);
            this.f7177a = j;
        }

        public final void a(HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
            Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
            timeout.setRequestTimeoutMillis(Long.valueOf(this.f7177a));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
            a(httpTimeoutCapabilityConfiguration);
            return Unit.INSTANCE;
        }
    }

    public static final void a(HttpRequestBuilder httpRequestBuilder, long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpTimeoutKt.timeout(httpRequestBuilder, new C0704a(j));
    }
}
