package io.bidmachine.analytics.internal;

import android.util.Base64;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.analytics.BidMachineAnalytics;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
public abstract class Y {
    public static final a e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o0 f12073a;
    private final String b;
    private final p0 c;
    private final C4642s d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f12074a;
        int c;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f12074a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = Y.this.a(this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12075a;

        static final class a extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f12076a;
            final /* synthetic */ Y b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Y y, Continuation continuation) {
                super(2, continuation);
                this.b = y;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f12076a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Y y = this.b;
                return y.a(y.d, this.b.b());
            }
        }

        c(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Y.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7904constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12075a;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (Y.this.d == null) {
                            Result.Companion companion = Result.INSTANCE;
                            return Result.m7903boximpl(Result.m7904constructorimpl(Y.this.a()));
                        }
                        CoroutineDispatcher coroutineDispatcherB = Y.this.c.b();
                        a aVar = new a(Y.this, null);
                        this.f12075a = 1;
                        obj = BuildersKt.withContext(coroutineDispatcherB, aVar, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    byte[] bArr = (byte[]) obj;
                    Y y = Y.this;
                    y.a(y.b, bArr);
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(Y.this.a());
                } catch (Throwable unused) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m7903boximpl(Result.m7904constructorimpl(Y.this.a()));
                }
            } catch (Throwable th) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m7903boximpl(objM7904constructorimpl);
        }
    }

    public Y(o0 o0Var, String str, p0 p0Var, C4642s c4642s) {
        this.f12073a = o0Var;
        this.b = str;
        this.c = p0Var;
        this.d = c4642s;
    }

    public abstract Y a();

    public abstract byte[] b();

    public /* synthetic */ Y(o0 o0Var, String str, p0 p0Var, C4642s c4642s, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(o0Var, str, p0Var, (i & 8) != 0 ? BidMachineAnalytics.INSTANCE.getEncryptionManager$bidmachine_android_sdk_analytics_b_2_2_4() : c4642s);
    }

    private final int b(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            return BidMachineNetworkBridge.httpUrlConnectionGetResponseCode((HttpURLConnection) uRLConnection);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[Catch: all -> 0x00bd, TryCatch #3 {all -> 0x00bd, blocks: (B:4:0x0013, B:6:0x0029, B:8:0x003d, B:12:0x0044, B:15:0x0053, B:20:0x0060, B:22:0x0069, B:23:0x0070, B:24:0x0071, B:34:0x0089, B:43:0x00a2, B:44:0x00b8, B:36:0x008d, B:38:0x0095, B:40:0x009b), top: B:58:0x0013 }] */
    public final void a(String str, byte[] bArr) throws Throwable {
        String headerField;
        URLConnection uRLConnection = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                this.f12073a.a(httpURLConnection);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(40000);
                httpURLConnection.setReadTimeout(40000);
                C4642s c4642s = this.d;
                if (c4642s != null) {
                    httpURLConnection.setRequestProperty("bm-data", Base64.encodeToString(c4642s.a().b(), 2));
                }
                if (bArr != null) {
                    if (!(bArr.length == 0)) {
                        httpURLConnection.setDoOutput(true);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(BidMachineNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
                            try {
                                bufferedOutputStream2.write(bArr);
                                s0.a((Flushable) bufferedOutputStream2);
                                s0.a((Closeable) bufferedOutputStream2);
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (bufferedOutputStream != null) {
                                    Result.m7903boximpl(s0.a((Flushable) bufferedOutputStream));
                                }
                                if (bufferedOutputStream != null) {
                                    Result.m7903boximpl(s0.a((Closeable) bufferedOutputStream));
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                int iB = b(httpURLConnection);
                if (iB == 200 || iB == 204) {
                    a(httpURLConnection);
                    return;
                }
                if (iB != 305 && iB != 307 && iB != 308) {
                    switch (iB) {
                        case 301:
                        case 302:
                        case 303:
                            headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField != null) {
                                a(headerField, bArr);
                                a(httpURLConnection);
                                return;
                            }
                            break;
                    }
                } else {
                    headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null && headerField.length() > 0) {
                        a(headerField, bArr);
                        a(httpURLConnection);
                        return;
                    }
                }
                throw new IllegalStateException(("Invalid response code: " + iB).toString());
            } catch (Throwable th3) {
                th = th3;
                uRLConnection = httpURLConnection;
                a(uRLConnection);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final Object a(URLConnection uRLConnection) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (uRLConnection instanceof HttpURLConnection) {
                BidMachineNetworkBridge.httpUrlConnectionDisconnect((HttpURLConnection) uRLConnection);
            }
            return Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(C4642s c4642s, byte[] bArr) {
        if (bArr != null) {
            return AbstractC4643t.a(bArr, c4642s);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation continuation) throws Throwable {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.c = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objWithContext = bVar.f12074a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher coroutineDispatcherC = this.c.c();
            c cVar = new c(null);
            bVar.c = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcherC, cVar, bVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }
}
