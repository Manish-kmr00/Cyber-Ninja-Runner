package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import io.bidmachine.unified.UnifiedMediationParams;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/x1;", "", "", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/graphics/Bitmap;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlin/Function1;", "Ljava/net/URL;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/jvm/functions/Function1;", "urlFactory", "Ljava/io/InputStream;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "bitmapFactory", "", "d", "J", com.json.m5.t, "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CoroutineDispatcher ioDispatcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Function1<String, URL> urlFactory;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<InputStream, Bitmap> bitmapFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long loadTimeout;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Ljava/net/URL;", "a", "(Ljava/lang/String;)Ljava/net/URL;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<String, URL> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final URL invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new URL(it);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/io/InputStream;", "it", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "a", "(Ljava/io/InputStream;)Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<InputStream, Bitmap> {
        public static final b b = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap invoke(InputStream it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return BitmapFactory.decodeStream(it);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.Networking.CBImageDownloader$downloadImage$2", f = "CBImageDownloader.kt", i = {0, 0, 0}, l = {30}, m = "invokeSuspend", n = {"infoIconBitmap", "connection", "inputStream"}, s = {"L$0", "L$1", "L$2"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String g;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.chartboost.sdk.internal.Networking.CBImageDownloader$downloadImage$2$1", f = "CBImageDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int b;
            public final /* synthetic */ Ref.ObjectRef<HttpsURLConnection> c;
            public final /* synthetic */ URL d;
            public final /* synthetic */ Ref.ObjectRef<Bitmap> e;
            public final /* synthetic */ Ref.ObjectRef<InputStream> f;
            public final /* synthetic */ x1 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Ref.ObjectRef<HttpsURLConnection> objectRef, URL url, Ref.ObjectRef<Bitmap> objectRef2, Ref.ObjectRef<InputStream> objectRef3, x1 x1Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = objectRef;
                this.d = url;
                this.e = objectRef2;
                this.f = objectRef3;
                this.g = x1Var;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, this.e, this.f, this.g, continuation);
            }

            /* JADX WARN: Type inference failed for: r0v10, types: [T, android.graphics.Bitmap] */
            /* JADX WARN: Type inference failed for: r0v4, types: [T, java.net.URLConnection, javax.net.ssl.HttpsURLConnection] */
            /* JADX WARN: Type inference failed for: r2v1, types: [T, java.io.InputStream] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                ?? r0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<HttpsURLConnection> objectRef = this.c;
                URLConnection uRLConnectionOpenConnection = this.d.openConnection();
                Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                ?? r1 = (HttpsURLConnection) uRLConnectionOpenConnection;
                Ref.ObjectRef<InputStream> objectRef2 = this.f;
                r1.setDoInput(true);
                objectRef2.element = ChartboostNetworkBridge.urlConnectionGetInputStream(r1);
                objectRef.element = r1;
                Ref.ObjectRef<Bitmap> objectRef3 = this.e;
                InputStream inputStream = this.f.element;
                if (inputStream == null || (r0 = (Bitmap) this.g.bitmapFactory.invoke(inputStream)) == 0) {
                    throw new IOException("Bitmap decoded to null");
                }
                objectRef3.element = r0;
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.g = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return x1.this.new c(this.g, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0072  */
        /* JADX WARN: Code duplicated, block: B:32:0x008d  */
        /* JADX WARN: Code duplicated, block: B:35:0x0096 A[PHI: r2 r15
  0x0096: PHI (r2v5 kotlin.jvm.internal.Ref$ObjectRef) = (r2v4 kotlin.jvm.internal.Ref$ObjectRef), (r2v7 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:34:0x0094, B:23:0x0079] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r15v11 javax.net.ssl.HttpsURLConnection) = (r15v10 javax.net.ssl.HttpsURLConnection), (r15v16 javax.net.ssl.HttpsURLConnection) binds: [B:34:0x0094, B:23:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:41:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            Ref.ObjectRef objectRef3;
            Exception e;
            Ref.ObjectRef objectRef4;
            InputStream inputStream;
            HttpsURLConnection httpsURLConnection;
            InputStream inputStream2;
            HttpsURLConnection httpsURLConnection2;
            InputStream inputStream3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                objectRef2 = new Ref.ObjectRef();
                try {
                    URL url = (URL) x1.this.urlFactory.invoke(this.g);
                    long j = x1.this.loadTimeout;
                    a aVar = new a(objectRef, url, objectRef5, objectRef2, x1.this, null);
                    this.b = objectRef5;
                    this.c = objectRef;
                    this.d = objectRef2;
                    this.e = 1;
                    if (TimeoutKt.withTimeout(j, aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef3 = objectRef5;
                    objectRef4 = objectRef2;
                    inputStream3 = (InputStream) objectRef4.element;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    httpsURLConnection2 = (HttpsURLConnection) objectRef.element;
                    if (httpsURLConnection2 != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection2);
                    }
                } catch (Exception e2) {
                    objectRef3 = objectRef5;
                    e = e2;
                    objectRef4 = objectRef2;
                    b7.e("Unable to download the info icon image", e);
                    inputStream2 = (InputStream) objectRef4.element;
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    httpsURLConnection2 = (HttpsURLConnection) objectRef.element;
                    if (httpsURLConnection2 != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection2);
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = (InputStream) objectRef2.element;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpsURLConnection = (HttpsURLConnection) objectRef.element;
                    if (httpsURLConnection != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
                    }
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef4 = (Ref.ObjectRef) this.d;
                objectRef = (Ref.ObjectRef) this.c;
                objectRef3 = (Ref.ObjectRef) this.b;
                try {
                    try {
                        ResultKt.throwOnFailure(obj);
                        inputStream3 = (InputStream) objectRef4.element;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        httpsURLConnection2 = (HttpsURLConnection) objectRef.element;
                        if (httpsURLConnection2 != null) {
                            ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectRef2 = objectRef4;
                        inputStream = (InputStream) objectRef2.element;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        httpsURLConnection = (HttpsURLConnection) objectRef.element;
                        if (httpsURLConnection != null) {
                            ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    b7.e("Unable to download the info icon image", e);
                    inputStream2 = (InputStream) objectRef4.element;
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    httpsURLConnection2 = (HttpsURLConnection) objectRef.element;
                    if (httpsURLConnection2 != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection2);
                    }
                }
            }
            return objectRef3.element;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x1(CoroutineDispatcher ioDispatcher, Function1<? super String, URL> urlFactory, Function1<? super InputStream, Bitmap> bitmapFactory) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(urlFactory, "urlFactory");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        this.ioDispatcher = ioDispatcher;
        this.urlFactory = urlFactory;
        this.bitmapFactory = bitmapFactory;
        this.loadTimeout = 1000L;
    }

    public /* synthetic */ x1(CoroutineDispatcher coroutineDispatcher, Function1 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i & 2) != 0 ? a.b : function1, (i & 4) != 0 ? b.b : function2);
    }

    public final Object a(String str, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new c(str, null), continuation);
    }
}
