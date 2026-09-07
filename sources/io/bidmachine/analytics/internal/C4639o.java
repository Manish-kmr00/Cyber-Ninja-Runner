package io.bidmachine.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C4639o {
    public static final i k = new i(null);
    private static final Lazy l = LazyKt.lazy(d.f12132a);
    private static final Lazy m = LazyKt.lazy(e.f12133a);
    private static final Lazy n = LazyKt.lazy(f.f12134a);
    private static final Lazy o = LazyKt.lazy(b.f12130a);
    private static final Lazy p = LazyKt.lazy(h.f12136a);
    private static final Lazy q = LazyKt.lazy(c.f12131a);
    private static final Lazy r = LazyKt.lazy(g.f12135a);
    private static final Lazy s = LazyKt.lazy(a.f12129a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12128a;
    private volatile C4640p b;
    private volatile boolean c;
    private volatile boolean d;
    private final Lazy e = LazyKt.lazy(new l());
    private final Lazy f = LazyKt.lazy(new m());
    private final Lazy g = LazyKt.lazy(new n());
    private final Lazy h = LazyKt.lazy(new C0775o());
    private final Lazy i = LazyKt.lazy(new j());
    private final ServiceConnection j = new p();

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$a */
    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12129a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("cGxheUJpbGxpbmdMaWJyYXJ5VmVyc2lvbg==");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$b */
    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12130a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("VkVSU0lPTl9OQU1F");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$c */
    static final class c extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12131a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5iaWxsaW5nLkluQXBwQmlsbGluZ1NlcnZpY2UuQklORA==");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$d */
    static final class d extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12132a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQuYmlsbGluZ2NsaWVudC5CdWlsZENvbmZpZw==");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$e */
    static final class e extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f12133a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQuYmlsbGluZ2NsaWVudC5rdHguQnVpbGRDb25maWc=");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$f */
    static final class f extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f12134a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmdvb2dsZS5hbmRyb2lkLnBsYXkuYmlsbGluZ2NsaWVudC52ZXJzaW9u");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$g */
    static final class g extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f12135a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZw==");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$h */
    static final class h extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f12136a = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5CSUxMSU5H");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$i */
    public static final class i {
        private i() {
        }

        public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return (String) C4639o.s.getValue();
        }

        public final String b() {
            return (String) C4639o.o.getValue();
        }

        public final String c() {
            return (String) C4639o.q.getValue();
        }

        public final String d() {
            return (String) C4639o.l.getValue();
        }

        public final String e() {
            return (String) C4639o.m.getValue();
        }

        public final String f() {
            return (String) C4639o.n.getValue();
        }

        public final String g() {
            return (String) C4639o.r.getValue();
        }

        public final String h() {
            return (String) C4639o.p.getValue();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$j */
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t0 invoke() {
            Object objM7904constructorimpl;
            t0 t0VarA;
            C4639o c4639o = C4639o.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                String strP = c4639o.p();
                if (strP == null || (t0VarA = t0.d.a(strP)) == null) {
                    String strN = c4639o.n();
                    t0VarA = strN != null ? t0.d.a(strN) : null;
                }
                objM7904constructorimpl = Result.m7904constructorimpl(t0VarA);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            return (t0) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$k */
    static final class k extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12138a;

        k(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return C4639o.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12138a;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (C4639o.this.b == null) {
                this.f12138a = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            C4640p c4640p = C4639o.this.b;
            if (c4640p != null) {
                return c4640p.n();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$l */
    static final class l extends Lambda implements Function0 {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C4639o.this.a(C4639o.k.d());
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$m */
    static final class m extends Lambda implements Function0 {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C4639o.this.a(C4639o.k.e());
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$n */
    static final class n extends Lambda implements Function0 {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C4639o.this.m();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$o, reason: collision with other inner class name */
    static final class C0775o extends Lambda implements Function0 {
        C0775o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String strO = C4639o.this.o();
            if (strO != null) {
                return strO;
            }
            String strN = C4639o.this.n();
            return strN == null ? C4639o.this.p() : strN;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.o$p */
    public static final class p implements ServiceConnection {
        p() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C4640p c4640p;
            t0 t0VarL = C4639o.this.l();
            if (t0VarL == null) {
                throw new IllegalArgumentException("Version not found in connected callback".toString());
            }
            C4639o c4639o = C4639o.this;
            String strQ = c4639o.q();
            if (strQ != null) {
                c4640p = new C4640p(new InterfaceC4647x.a(iBinder, InterfaceC4647x.a.d.a(t0VarL), null, 4, null), C4639o.this.f12128a.getPackageName(), strQ);
            } else {
                c4640p = null;
            }
            c4639o.b = c4640p;
            C4639o c4639o2 = C4639o.this;
            c4639o2.c = c4639o2.b != null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C4639o.this.c = false;
            C4639o.this.b = null;
        }
    }

    public C4639o(Context context) {
        this.f12128a = context;
    }

    private final Intent k() {
        i iVar = k;
        Intent intent = new Intent(iVar.c());
        intent.setPackage(iVar.g());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundle = this.f12128a.getPackageManager().getApplicationInfo(this.f12128a.getPackageName(), 128).metaData;
            objM7904constructorimpl = Result.m7904constructorimpl(bundle != null ? bundle.getString(k.f()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        return (String) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        return (String) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        return (String) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q() {
        return (String) this.h.getValue();
    }

    private final ComponentName r() {
        ServiceInfo serviceInfo;
        List<ResolveInfo> listQueryIntentServices = this.f12128a.getPackageManager().queryIntentServices(k(), 0);
        if (listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            return null;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!Intrinsics.areEqual(k.g(), str) || str2 == null) {
            return null;
        }
        return new ComponentName(str, str2);
    }

    public final void i() {
        ComponentName componentNameR = r();
        if (componentNameR == null) {
            throw new IllegalArgumentException("Component name not found".toString());
        }
        String strQ = q();
        if (strQ == null) {
            throw new IllegalArgumentException("Library version not found".toString());
        }
        Context context = this.f12128a;
        Intent intentK = k();
        intentK.setComponent(componentNameR);
        intentK.putExtra(k.a(), strQ);
        if (!context.bindService(intentK, this.j, 1)) {
            throw new IllegalStateException("Can't connect".toString());
        }
        this.d = true;
    }

    public final void j() {
        if (this.d) {
            this.f12128a.unbindService(this.j);
        }
        this.d = false;
    }

    public final t0 l() {
        return (t0) this.i.getValue();
    }

    public final boolean s() {
        return this.f12128a.getPackageManager().checkPermission(k.h(), this.f12128a.getPackageName()) == 0;
    }

    public final boolean t() {
        return r() != null;
    }

    public final Object a(long j2, Continuation continuation) {
        return TimeoutKt.withTimeoutOrNull(j2, new k(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object obj = Class.forName(str).getField(k.b()).get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            objM7904constructorimpl = Result.m7904constructorimpl((String) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }
}
