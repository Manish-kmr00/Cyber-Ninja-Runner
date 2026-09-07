package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements f {
    public final HttpClient b;
    public final CoroutineScope c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$send$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {48, 52}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7198a;
        public int b;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new a(this.d, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        /* JADX WARN: Code duplicated, block: B:15:0x0059  */
        /* JADX WARN: Code duplicated, block: B:17:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x0073  */
        /* JADX WARN: Code duplicated, block: B:21:0x0076  */
        /* JADX WARN: Code duplicated, block: B:23:0x0079  */
        /* JADX WARN: Code duplicated, block: B:25:0x0085 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:26:0x0086). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                int r1 = r12.f7198a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L86
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                int r1 = r12.f7198a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L6c
            L24:
                kotlin.ResultKt.throwOnFailure(r13)
                r1 = r3
            L28:
                r13 = 5
                if (r1 >= r13) goto L88
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r5 = 0
                android.content.Context r5 = com.moloco.sdk.internal.android_context.b.a(r5, r4, r5)
                boolean r13 = r13.a(r5)
                com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Network available: "
                r6.<init>(r7)
                java.lang.StringBuilder r6 = r6.append(r13)
                java.lang.String r7 = " for non persistent request"
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.String r7 = r6.toString()
                r10 = 12
                r11 = 0
                java.lang.String r6 = "NonPersistentRequest"
                r8 = 0
                r9 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r5, r6, r7, r8, r9, r10, r11)
                if (r13 == 0) goto L73
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                io.ktor.client.HttpClient r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a(r13)
                java.lang.String r5 = r12.d
                r12.f7198a = r1
                r12.b = r4
                java.lang.Object r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r13, r5, r12)
                if (r13 != r0) goto L6c
                return r0
            L6c:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                goto L74
            L73:
                r13 = r3
            L74:
                if (r13 == 0) goto L79
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L79:
                r12.f7198a = r1
                r12.b = r2
                r5 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r5, r12)
                if (r13 != r0) goto L86
                return r0
            L86:
                int r1 = r1 + r4
                goto L28
            L88:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$sendPost$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {63, 67}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7199a;
        public int b;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ ContentType f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, byte[] bArr, ContentType contentType, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = bArr;
            this.f = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new b(this.d, this.e, this.f, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        /* JADX WARN: Code duplicated, block: B:15:0x0059  */
        /* JADX WARN: Code duplicated, block: B:17:0x006f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x0077  */
        /* JADX WARN: Code duplicated, block: B:21:0x007a  */
        /* JADX WARN: Code duplicated, block: B:23:0x007d  */
        /* JADX WARN: Code duplicated, block: B:25:0x0089 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0087 -> B:26:0x008a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                int r1 = r12.f7199a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L8a
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                int r1 = r12.f7199a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L70
            L24:
                kotlin.ResultKt.throwOnFailure(r13)
                r1 = r3
            L28:
                r13 = 5
                if (r1 >= r13) goto L8c
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r5 = 0
                android.content.Context r5 = com.moloco.sdk.internal.android_context.b.a(r5, r4, r5)
                boolean r13 = r13.a(r5)
                com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Network available: "
                r6.<init>(r7)
                java.lang.StringBuilder r6 = r6.append(r13)
                java.lang.String r7 = " for non persistent request"
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.String r7 = r6.toString()
                r10 = 12
                r11 = 0
                java.lang.String r6 = "NonPersistentRequest"
                r8 = 0
                r9 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r5, r6, r7, r8, r9, r10, r11)
                if (r13 == 0) goto L77
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                io.ktor.client.HttpClient r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a(r13)
                java.lang.String r5 = r12.d
                byte[] r6 = r12.e
                io.ktor.http.ContentType r7 = r12.f
                r12.f7199a = r1
                r12.b = r4
                java.lang.Object r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r13, r5, r6, r7, r12)
                if (r13 != r0) goto L70
                return r0
            L70:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                goto L78
            L77:
                r13 = r3
            L78:
                if (r13 == 0) goto L7d
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L7d:
                r12.f7199a = r1
                r12.b = r2
                r5 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r5, r12)
                if (r13 != r0) goto L8a
                return r0
            L8a:
                int r1 = r1 + r4
                goto L28
            L8c:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public g(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.b = httpClient;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault());
    }

    public final boolean b(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(url, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(url, body, contentType, null), 3, null);
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return b((ConnectivityManager) systemService);
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }
}
