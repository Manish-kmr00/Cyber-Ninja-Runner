package com.moloco.sdk.acm.services;

import android.util.Log;
import com.json.b9;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6053a = new e();
    public static final CoroutineScope b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    public static final ArrayList<a> c = new ArrayList<>();
    public static boolean d = com.moloco.sdk.acm.services.a.f6049a.a("debug.moloco.enable_logs");
    public static final String e = "ACM";

    public interface a {
        void a(String str, String str2);
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.services.MolocoMetricsLogger$fireListeners$1", f = "MolocoMetricsLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6054a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6054a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = e.c;
            String str = this.b;
            String str2 = this.c;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(e.f6053a.b(str), str2);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void b(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = e;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.b(str, str2, z);
    }

    public static final boolean c() {
        return d;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    public final void b(String tag, String msg, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (d || z) {
            String strB = b(tag);
            String strA = a(msg);
            Log.i(strB, strA);
            a(strB, strA);
        }
    }

    public final void c(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.i("==tlog==", a(msg));
    }

    public static final void a(boolean z) {
        d = z;
    }

    @JvmStatic
    public static final void a(a loggerListener) {
        Intrinsics.checkNotNullParameter(loggerListener, "loggerListener");
        c.add(loggerListener);
    }

    public static /* synthetic */ void a(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = e;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.a(str, str2, z);
    }

    public final void a(String tag, String msg, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (d || z) {
            String strB = b(tag);
            String strA = a(msg);
            Log.d(strB, strA);
            a(strB, strA);
        }
    }

    public static /* synthetic */ void b(e eVar, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = e;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        eVar.b(str, str2, th, z);
    }

    public final void b(String tag, String msg, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (d || z) {
            String strB = b(tag);
            String strA = a(msg);
            Log.w(strB, strA, th);
            a(strB, strA);
        }
    }

    public static /* synthetic */ void a(e eVar, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = e;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        eVar.a(str, str2, th, z);
    }

    public final void a(String tag, String msg, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (d || z) {
            String strB = b(tag);
            String strA = a(msg);
            Log.e(strB, strA, th);
            a(strB, strA);
        }
    }

    public final String b() throws ClassNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
        StackTraceElement stackTraceElementA = a(stackTrace);
        String className = stackTraceElementA.getClassName();
        stackTraceElementA.getMethodName();
        Class<?> cls = Class.forName(className);
        cls.isAnonymousClass();
        cls.getDeclaredMethods();
        String methodName = stackTraceElementA.getMethodName();
        if (Intrinsics.areEqual(methodName, "invokeSuspend")) {
            String className2 = stackTraceElementA.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            methodName = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(className2, (CharSequence) "$1"), "$", (String) null, 2, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(methodName, "stackTraceElement.method…t\n            }\n        }");
        return methodName;
    }

    public final void a(String str, String str2) {
        BuildersKt__Builders_commonKt.launch$default(b, null, null, new b(str, str2, null), 3, null);
    }

    public final String a(String str) {
        try {
            return b9.i.d + b() + "] " + str;
        } catch (Exception unused) {
            return str;
        }
    }

    public final StackTraceElement a(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (!Intrinsics.areEqual(stackTraceElement.getClassName(), f6053a.getClass().getCanonicalName())) {
                return stackTraceElement;
            }
        }
        return (StackTraceElement) ArraysKt.first(stackTraceElementArr);
    }

    public final String b(String str) {
        return StringsKt.startsWith$default(str, e, false, 2, (Object) null) ? str : e + str;
    }
}
