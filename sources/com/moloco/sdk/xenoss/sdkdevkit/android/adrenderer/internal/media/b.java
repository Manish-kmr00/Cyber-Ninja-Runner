package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6577a;
    public final u b;
    public final com.moloco.sdk.internal.error.b c;
    public final HttpClient d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 1, 1, 1}, l = {293, 293}, m = "downloadFullFile", n = {"this", "dstFile", "response", "this", "dstFile", "response"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6578a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.a((File) null, (HttpResponse) null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl$downloadMedia$2", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {94, 105, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 148}, m = "invokeSuspend", n = {"previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "hasMoreData", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk"}, s = {"L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "I$0", "I$1", "J$0", "I$2"})
    public static final class C0597b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6579a;
        public int b;
        public int c;
        public int d;
        public long e;
        public Object f;
        public int g;
        public final /* synthetic */ String i;
        public final /* synthetic */ File j;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a k;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0597b(String str, File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, String str2, Continuation<? super C0597b> continuation) {
            super(2, continuation);
            this.i = str;
            this.j = file;
            this.k = aVar;
            this.l = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((C0597b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0597b(this.i, this.j, this.k, this.l, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0169 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x0183 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x0184  */
        /* JADX WARN: Code duplicated, block: B:52:0x0190 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0194 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01a1 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x01f6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x01f7  */
        /* JADX WARN: Code duplicated, block: B:63:0x020d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x020e A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x026f A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:68:0x02cd A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:69:0x02d2  */
        /* JADX WARN: Code duplicated, block: B:72:0x02fb  */
        /* JADX WARN: Code duplicated, block: B:73:0x02fd  */
        /* JADX WARN: Code duplicated, block: B:75:0x0300 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x0354  */
        /* JADX WARN: Code duplicated, block: B:79:0x0356  */
        /* JADX WARN: Code duplicated, block: B:82:0x0371 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:83:0x0372  */
        /* JADX WARN: Code duplicated, block: B:86:0x0379 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x038d  */
        /* JADX WARN: Code duplicated, block: B:89:0x0391 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x03a7 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:92:0x03c3 A[Catch: Exception -> 0x0434, TryCatch #0 {Exception -> 0x0434, blocks: (B:9:0x002d, B:46:0x0169, B:50:0x0188, B:52:0x0190, B:54:0x0194, B:55:0x019e, B:57:0x01a1, B:61:0x01fd, B:64:0x020e, B:66:0x026f, B:68:0x02cd, B:70:0x02d4, B:76:0x031e, B:80:0x0357, B:84:0x0375, B:86:0x0379, B:89:0x0391, B:90:0x03a7, B:75:0x0300, B:92:0x03c3, B:93:0x03c8, B:94:0x03c9, B:100:0x0429, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b1, B:27:0x00bb, B:29:0x00cf, B:31:0x00d7, B:37:0x00fc, B:39:0x0100, B:40:0x0109, B:42:0x0138, B:44:0x0158, B:35:0x00df), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x041f -> B:98:0x0421). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instruction units count: 1137
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.C0597b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c extends Lambda implements Function1<HttpRequestRetry.Configuration, Unit> {

        public static final class a extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f6581a = new a();

            public a() {
                super(2);
            }

            public final Long a(HttpRequestRetry.DelayContext delayMillis, int i) {
                Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
                return 100L;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(HttpRequestRetry.DelayContext delayContext, Integer num) {
                return a(delayContext, num.intValue());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$c$b, reason: collision with other inner class name */
        public static final class C0598b extends Lambda implements Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f6582a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0598b(b bVar) {
                super(2);
                this.f6582a = bVar;
            }

            public final void a(HttpRequestRetry.ModifyRequestContext modifyRequest, HttpRequestBuilder it) {
                Intrinsics.checkNotNullParameter(modifyRequest, "$this$modifyRequest");
                Intrinsics.checkNotNullParameter(it, "it");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f6582a.e, "Retry attempt #" + modifyRequest.getRetryCount() + " for " + modifyRequest.getRequest().getUrl(), null, false, 12, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestRetry.ModifyRequestContext modifyRequestContext, HttpRequestBuilder httpRequestBuilder) {
                a(modifyRequestContext, httpRequestBuilder);
                return Unit.INSTANCE;
            }
        }

        public c() {
            super(1);
        }

        public final void a(HttpRequestRetry.Configuration retry) {
            Intrinsics.checkNotNullParameter(retry, "$this$retry");
            retry.setMaxRetries(10);
            HttpRequestRetry.Configuration.delayMillis$default(retry, false, a.f6581a, 1, null);
            retry.retryOnException(10, true);
            retry.retryOnServerErrors(10);
            retry.modifyRequest(new C0598b(b.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpRequestRetry.Configuration configuration) {
            a(configuration);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<HeadersBuilder, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6583a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j, b bVar, int i, String str) {
            super(1);
            this.f6583a = j;
            this.b = bVar;
            this.c = i;
            this.d = str;
        }

        public final void a(HeadersBuilder headers) {
            Intrinsics.checkNotNullParameter(headers, "$this$headers");
            String str = "bytes=" + this.f6583a + '-' + Math.min(this.f6583a + ((long) this.b.f6577a.e()), this.c);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str2 = this.b.e;
            StringBuilder sb = new StringBuilder("Adding ");
            HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
            MolocoLogger.info$default(molocoLogger, str2, sb.append(httpHeaders.getRange()).append(" header: ").append(str).toString(), null, false, 12, null);
            headers.append(httpHeaders.getRange(), str);
            if (this.d != null) {
                MolocoLogger.info$default(molocoLogger, this.b.e, "Adding " + httpHeaders.getIfRange() + " header: " + this.d, null, false, 12, null);
                headers.append(httpHeaders.getIfRange(), this.d);
                MolocoLogger.info$default(molocoLogger, this.b.e, "Adding " + httpHeaders.getETag() + " header: " + this.d, null, false, 12, null);
                headers.append(httpHeaders.getETag(), this.d);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
            a(headersBuilder);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 1, 1, 1}, l = {275, 277}, m = "writeChunkToFile", n = {"this", "dstFile", "this", "dstFile", "channel"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6584a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.b(null, null, this);
        }
    }

    public b(l mediaConfig, u connectivityService, com.moloco.sdk.internal.error.b errorReportingService, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f6577a = mediaConfig;
        this.b = connectivityService;
        this.c = errorReportingService;
        this.d = httpClient;
        this.e = "ChunkedMediaDownloader";
    }

    public final String e(File file) {
        File fileF = f(file);
        if (fileF.exists()) {
            return FilesKt.readText$default(fileF, null, 1, null);
        }
        return null;
    }

    public final File f(File file) {
        return new File(file.getParent(), file.getName() + ".range");
    }

    public final void g(File file) {
        c(file).delete();
    }

    public final void h(File file) {
        f(file).delete();
    }

    public final String d(File file) {
        File fileC = c(file);
        if (fileC.exists()) {
            return FilesKt.readText$default(fileC, null, 1, null);
        }
        return null;
    }

    public final File c(File file) {
        return new File(file.getParent(), file.getName() + ".etag");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean b(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && !f(file).exists();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code duplicated, block: B:25:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0095 A[LOOP:0: B:27:0x008f->B:29:0x0095, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:26:0x008d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(java.io.File r19, io.ktor.client.statement.HttpResponse r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.e
            if (r2 == 0) goto L17
            r2 = r1
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$e r2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.e) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f = r3
            goto L1c
        L17:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$e r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$e
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L55
            if (r4 == r6) goto L44
            if (r4 != r5) goto L3c
            java.lang.Object r4 = r2.c
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            java.lang.Object r7 = r2.b
            java.io.File r7 = (java.io.File) r7
            java.lang.Object r8 = r2.f6584a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b r8 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b) r8
            kotlin.ResultKt.throwOnFailure(r1)
            goto L8d
        L3c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L44:
            java.lang.Object r4 = r2.b
            java.io.File r4 = (java.io.File) r4
            java.lang.Object r7 = r2.f6584a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b r7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r4
            r4 = r1
            r1 = r17
            goto L6a
        L55:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.f6584a = r0
            r1 = r19
            r2.b = r1
            r2.f = r6
            r4 = r20
            java.lang.Object r4 = io.ktor.client.statement.HttpResponseKt.bodyAsChannel(r4, r2)
            if (r4 != r3) goto L69
            return r3
        L69:
            r7 = r0
        L6a:
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            r8 = r7
            r7 = r1
        L6e:
            boolean r1 = r4.isClosedForRead()
            if (r1 != 0) goto Lc5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l r1 = r8.f6577a
            int r1 = r1.e()
            long r9 = (long) r1
            r11 = 2
            long r9 = r9 * r11
            r2.f6584a = r8
            r2.b = r7
            r2.c = r4
            r2.f = r5
            java.lang.Object r1 = r4.readRemaining(r9, r2)
            if (r1 != r3) goto L8d
            return r3
        L8d:
            io.ktor.utils.io.core.ByteReadPacket r1 = (io.ktor.utils.io.core.ByteReadPacket) r1
        L8f:
            boolean r9 = r1.getEndOfInput()
            if (r9 != 0) goto L6e
            r9 = 0
            r10 = 0
            byte[] r9 = io.ktor.utils.io.core.StringsKt.readBytes$default(r1, r9, r6, r10)
            kotlin.io.FilesKt.appendBytes(r7, r9)
            com.moloco.sdk.internal.MolocoLogger r10 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r11 = r8.e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r12 = "dst file length: "
            r9.<init>(r12)
            long r12 = r7.length()
            java.lang.StringBuilder r9 = r9.append(r12)
            java.lang.String r12 = " bytes"
            java.lang.StringBuilder r9 = r9.append(r12)
            java.lang.String r12 = r9.toString()
            r15 = 12
            r16 = 0
            r13 = 0
            r14 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r10, r11, r12, r13, r14, r15, r16)
            goto L8f
        Lc5:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.b(java.io.File, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && f(file).exists();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public Object a(String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new C0597b(str, file, aVar, str2, null), continuation);
    }

    public final i.a a(File file, HttpResponse httpResponse, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        int value = httpResponse.getStatus().getValue();
        if (400 <= value && value < 500) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.e.c));
            }
            return i.a.AbstractC0600a.e.c;
        }
        if (500 <= value && value < 600) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b(i.a.AbstractC0600a.h.c));
            }
            return i.a.AbstractC0600a.h.c;
        }
        return new i.a.b(file);
    }

    public final i.a a(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        g(file);
        h(file);
        if (aVar != null) {
            aVar.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a(file));
        }
        return new i.a.b(file);
    }

    public final Object a(String str, long j, int i, String str2, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.d;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestRetryKt.retry(httpRequestBuilder, new c());
        HttpRequestKt.headers(httpRequestBuilder, new d(j, this, i, str2));
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final void a(File file, String str) {
        FilesKt.writeText$default(f(file), str, null, 2, null);
    }

    public final void a(File file, HttpResponse httpResponse) {
        Headers headers = httpResponse.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headers.get(httpHeaders.getETag());
        if (str != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, httpHeaders.getETag() + ": " + str, null, false, 12, null);
            FilesKt.writeText$default(c(file), str, null, 2, null);
        } else {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.e, "No " + httpHeaders.getETag() + " in header", null, false, 12, null);
            g(file);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(File file, HttpResponse httpResponse, Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        File file2;
        Object objBodyAsChannel;
        b bVar;
        File file3;
        b bVar2;
        HttpResponse httpResponse2 = httpResponse;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        a aVar2 = aVar;
        Object obj = aVar2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar2.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, this.e, "Range header not supported, downloading full file", null, false, 12, null);
            if (file.exists()) {
                MolocoLogger.info$default(molocoLogger, this.e, "Deleting existing file and fully re-downloading it", null, false, 12, null);
                file.delete();
            }
            aVar2.f6578a = this;
            file2 = file;
            aVar2.b = file2;
            aVar2.c = httpResponse2;
            aVar2.f = 1;
            objBodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse2, aVar2);
            if (objBodyAsChannel == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = this;
        } else {
            if (i2 == 1) {
                httpResponse2 = (HttpResponse) aVar2.c;
                File file4 = (File) aVar2.b;
                b bVar3 = (b) aVar2.f6578a;
                ResultKt.throwOnFailure(obj);
                bVar = bVar3;
                objBodyAsChannel = obj;
                file2 = file4;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                httpResponse2 = (HttpResponse) aVar2.c;
                file3 = (File) aVar2.b;
                bVar2 = (b) aVar2.f6578a;
                ResultKt.throwOnFailure(obj);
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar2.e, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj).longValue() + " bytes, file size: " + file3.length(), null, false, 12, null);
            return Unit.INSTANCE;
        }
        ByteWriteChannel byteWriteChannelWriteChannel$default = FileChannelsKt.writeChannel$default(file2, null, 1, null);
        aVar2.f6578a = bVar;
        aVar2.b = file2;
        aVar2.c = httpResponse2;
        aVar2.f = 2;
        Object objCopyAndClose$default = ByteReadChannelKt.copyAndClose$default((ByteReadChannel) objBodyAsChannel, byteWriteChannelWriteChannel$default, 0L, aVar2, 2, null);
        if (objCopyAndClose$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        file3 = file2;
        obj = objCopyAndClose$default;
        bVar2 = bVar;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar2.e, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj).longValue() + " bytes, file size: " + file3.length(), null, false, 12, null);
        return Unit.INSTANCE;
    }
}
