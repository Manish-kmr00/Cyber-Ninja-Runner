package com.moloco.sdk.service_locator;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.a0;
import com.moloco.sdk.internal.b0;
import com.moloco.sdk.internal.services.SingleObserverBackgroundThenForegroundAnalyticsListener;
import com.moloco.sdk.internal.services.c0;
import com.moloco.sdk.internal.services.d0;
import com.moloco.sdk.internal.services.f0;
import com.moloco.sdk.internal.services.g0;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.internal.services.j0;
import com.moloco.sdk.internal.services.n;
import com.moloco.sdk.internal.services.o;
import com.moloco.sdk.internal.services.q;
import com.moloco.sdk.internal.services.r;
import com.moloco.sdk.internal.services.s;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.internal.services.v;
import com.moloco.sdk.internal.services.w;
import com.moloco.sdk.internal.services.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.m;
import io.ktor.client.HttpClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6451a = new a();

    /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$a, reason: collision with other inner class name */
    public static final class C0569a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0569a f6452a = new C0569a();
        public static final int b = 0;

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j a() {
            return l.a(g.f6474a.a(), b.f6453a.c());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6453a = new b();
        public static final Lazy b = LazyKt.lazy(C0570a.f6454a);
        public static final Lazy c = LazyKt.lazy(d.f6457a);
        public static final Lazy d = LazyKt.lazy(C0571b.f6455a);
        public static final Lazy e = LazyKt.lazy(c.f6456a);
        public static final int f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$b$a, reason: collision with other inner class name */
        public static final class C0570a extends Lambda implements Function0<com.moloco.sdk.internal.services.analytics.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0570a f6454a = new C0570a();

            public C0570a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.analytics.b invoke() {
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = i.f6483a.c();
                k kVar = k.f6490a;
                return new com.moloco.sdk.internal.services.analytics.b(iVarC, kVar.a(), kVar.b());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$b$b, reason: collision with other inner class name */
        public static final class C0571b extends Lambda implements Function0<com.moloco.sdk.internal.services.g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0571b f6455a = new C0571b();

            public C0571b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.g invoke() {
                return new com.moloco.sdk.internal.services.g(ProcessLifecycleOwner.INSTANCE.get().getLifecycle(), b.f6453a.d());
            }
        }

        public static final class c extends Lambda implements Function0<com.moloco.sdk.internal.error.c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6456a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.error.c invoke() {
                return new com.moloco.sdk.internal.error.c(c.f6458a.a(), new com.moloco.sdk.internal.error.api.b(h.f6477a.f(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a()));
            }
        }

        public static final class d extends Lambda implements Function0<SingleObserverBackgroundThenForegroundAnalyticsListener> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f6457a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SingleObserverBackgroundThenForegroundAnalyticsListener invoke() {
                return new SingleObserverBackgroundThenForegroundAnalyticsListener(b.f6453a.a(), h.f6477a.f());
            }
        }

        public final com.moloco.sdk.internal.services.analytics.a a() {
            return (com.moloco.sdk.internal.services.analytics.a) b.getValue();
        }

        public final com.moloco.sdk.internal.services.f b() {
            return (com.moloco.sdk.internal.services.f) d.getValue();
        }

        public final com.moloco.sdk.internal.error.b c() {
            return (com.moloco.sdk.internal.error.b) e.getValue();
        }

        public final SingleObserverBackgroundThenForegroundAnalyticsListener d() {
            return (SingleObserverBackgroundThenForegroundAnalyticsListener) c.getValue();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6458a = new c();
        public static final Lazy b = LazyKt.lazy(C0572a.f6459a);
        public static final int c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$c$a, reason: collision with other inner class name */
        public static final class C0572a extends Lambda implements Function0<com.moloco.sdk.internal.services.config.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0572a f6459a = new C0572a();

            public C0572a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.config.b invoke() {
                return new com.moloco.sdk.internal.services.config.b();
            }
        }

        public final com.moloco.sdk.internal.services.config.a a() {
            return (com.moloco.sdk.internal.services.config.a) b.getValue();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6460a = new d();
        public static final Lazy b = LazyKt.lazy(C0573a.f6461a);
        public static final int c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$d$a, reason: collision with other inner class name */
        public static final class C0573a extends Lambda implements Function0<com.moloco.sdk.internal.error.crash.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0573a f6461a = new C0573a();

            public C0573a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.error.crash.b invoke() {
                return new com.moloco.sdk.internal.error.crash.b(new com.moloco.sdk.internal.error.crash.d(CollectionsKt.listOf(new com.moloco.sdk.internal.error.crash.filters.b()), new com.moloco.sdk.internal.error.api.b(h.f6477a.f(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a())));
            }
        }

        public final com.moloco.sdk.internal.error.crash.a a() {
            return (com.moloco.sdk.internal.error.crash.a) b.getValue();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6462a = new e();
        public static final Lazy b = LazyKt.lazy(b.f6464a);
        public static final Lazy c = LazyKt.lazy(f.f6468a);
        public static final Lazy d = LazyKt.lazy(c.f6465a);
        public static final Lazy e = LazyKt.lazy(g.f6469a);
        public static final Lazy f = LazyKt.lazy(C0575e.f6467a);
        public static final Lazy g = LazyKt.lazy(d.f6466a);
        public static final Lazy h = LazyKt.lazy(C0574a.f6463a);
        public static final int i = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$e$a, reason: collision with other inner class name */
        public static final class C0574a extends Lambda implements Function0<com.moloco.sdk.internal.services.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0574a f6463a = new C0574a();

            public C0574a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.b invoke() {
                return new com.moloco.sdk.internal.services.b(a.f6451a.a());
            }
        }

        public static final class b extends Lambda implements Function0<com.moloco.sdk.internal.services.l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6464a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.l invoke() {
                return new com.moloco.sdk.internal.services.l(a.f6451a.a());
            }
        }

        public static final class c extends Lambda implements Function0<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6465a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final o invoke() {
                return new o(a.f6451a.a());
            }
        }

        public static final class d extends Lambda implements Function0<r> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f6466a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r invoke() {
                return new r(a.f6451a.a());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$e$e, reason: collision with other inner class name */
        public static final class C0575e extends Lambda implements Function0<v> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0575e f6467a = new C0575e();

            public C0575e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final v invoke() {
                return new v(a.f6451a.a());
            }
        }

        public static final class f extends Lambda implements Function0<com.moloco.sdk.internal.services.i> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f6468a = new f();

            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.i invoke() {
                return new com.moloco.sdk.internal.services.i(a.f6451a.a());
            }
        }

        public static final class g extends Lambda implements Function0<g0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f6469a = new g();

            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g0 invoke() {
                return new g0(a.f6451a.a());
            }
        }

        public final com.moloco.sdk.internal.services.a a() {
            return (com.moloco.sdk.internal.services.a) h.getValue();
        }

        public final com.moloco.sdk.internal.services.k b() {
            return (com.moloco.sdk.internal.services.k) b.getValue();
        }

        public final n c() {
            return (n) d.getValue();
        }

        public final q d() {
            return (q) g.getValue();
        }

        public final u e() {
            return (u) f.getValue();
        }

        public final y f() {
            return (y) c.getValue();
        }

        public final f0 g() {
            return (f0) e.getValue();
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6474a = new g();
        public static final Lazy b = LazyKt.lazy(b.f6476a);
        public static final Lazy c = LazyKt.lazy(C0577a.f6475a);
        public static final int d = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$g$a, reason: collision with other inner class name */
        public static final class C0577a extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0577a f6475a = new C0577a();

            public C0577a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j invoke() {
                g gVar = g.f6474a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l lVarB = gVar.b();
                e eVar = e.f6462a;
                u uVarE = eVar.e();
                b bVar = b.f6453a;
                com.moloco.sdk.internal.error.b bVarC = bVar.c();
                i iVar = i.f6483a;
                return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j(gVar.b(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d(eVar.e(), bVar.c(), iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b(lVarB, uVarE, bVarC, iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g(a.f6451a.a(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.k.f6603a));
            }
        }

        public static final class b extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6476a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l invoke() {
                return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l) c.f6458a.a().a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l.class, m.a());
            }
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i a() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i) c.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l) b.getValue();
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f6477a = new h();
        public static final Lazy b = LazyKt.lazy(d.f6481a);
        public static final Lazy c = LazyKt.lazy(c.f6480a);
        public static final Lazy d = LazyKt.lazy(b.f6479a);
        public static final Lazy e = LazyKt.lazy(e.f6482a);
        public static final Lazy f = LazyKt.lazy(C0578a.f6478a);
        public static final int g = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$h$a, reason: collision with other inner class name */
        public static final class C0578a extends Lambda implements Function0<ActivityManager> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0578a f6478a = new C0578a();

            public C0578a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ActivityManager invoke() {
                Object systemService = a.f6451a.a().getSystemService("activity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                return (ActivityManager) systemService;
            }
        }

        public static final class b extends Lambda implements Function0<com.moloco.sdk.internal.services.e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6479a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.e invoke() {
                return new com.moloco.sdk.internal.services.e(a.f6451a.a());
            }
        }

        public static final class c extends Lambda implements Function0<com.moloco.sdk.internal.services.proto.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6480a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.proto.b invoke() {
                return new com.moloco.sdk.internal.services.proto.b();
            }
        }

        public static final class d extends Lambda implements Function0<j0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f6481a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final j0 invoke() {
                return new j0();
            }
        }

        public static final class e extends Lambda implements Function0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f6482a = new e();

            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b0 invoke() {
                return new b0();
            }
        }

        public final ActivityManager a() {
            return (ActivityManager) f.getValue();
        }

        public final com.moloco.sdk.internal.services.d b() {
            return (com.moloco.sdk.internal.services.d) d.getValue();
        }

        public final s c() {
            return new t(d(), k.f6490a.a());
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m d() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n(a.f6451a.a());
        }

        public final com.moloco.sdk.internal.services.proto.a e() {
            return (com.moloco.sdk.internal.services.proto.a) c.getValue();
        }

        public final i0 f() {
            return (i0) b.getValue();
        }

        public final a0 g() {
            return (a0) e.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0 h() {
            return new k0();
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f6483a = new i();
        public static final Lazy b = LazyKt.lazy(C0579a.f6484a);
        public static final Lazy c = LazyKt.lazy(b.f6485a);
        public static final Lazy d = LazyKt.lazy(d.f6487a);
        public static final Lazy e = LazyKt.lazy(c.f6486a);
        public static final int f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$i$a, reason: collision with other inner class name */
        public static final class C0579a extends Lambda implements Function0<HttpClient> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0579a f6484a = new C0579a();

            public C0579a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final HttpClient invoke() {
                e eVar = e.f6462a;
                return com.moloco.sdk.internal.http.a.a(eVar.b().invoke(), eVar.f().invoke());
            }
        }

        public static final class b extends Lambda implements Function0<c0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6485a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c0 invoke() {
                return new c0(a.f6451a.a(), e.f6462a.f());
            }
        }

        public static final class c extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6486a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i invoke() {
                return com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i.f7202a.a(i.f6483a.d());
            }
        }

        public static final class d extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f6487a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m invoke() {
                return new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m(a.f6451a.a());
            }
        }

        public final HttpClient a() {
            return (HttpClient) b.getValue();
        }

        public final com.moloco.sdk.internal.services.b0 b() {
            return (com.moloco.sdk.internal.services.b0) c.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i c() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i) e.getValue();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l d() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l) d.getValue();
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f6488a = new j();
        public static final Lazy b = LazyKt.lazy(C0580a.f6489a);
        public static final int c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$j$a, reason: collision with other inner class name */
        public static final class C0580a extends Lambda implements Function0<d0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0580a f6489a = new C0580a();

            public C0580a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d0 invoke() {
                SharedPreferences sharedPreferences = a.f6451a.a().getSharedPreferences("moloco_sdk_preferences", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
                return new d0(sharedPreferences);
            }
        }

        public final w a() {
            return (w) b.getValue();
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f6490a = new k();
        public static final Lazy b = LazyKt.lazy(b.f6492a);
        public static final Lazy c = LazyKt.lazy(c.f6493a);
        public static final Lazy d = LazyKt.lazy(C0581a.f6491a);
        public static final int e = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$k$a, reason: collision with other inner class name */
        public static final class C0581a extends Lambda implements Function0<com.moloco.sdk.internal.services.events.c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0581a f6491a = new C0581a();

            public C0581a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.events.c invoke() {
                return new com.moloco.sdk.internal.services.events.c();
            }
        }

        public static final class b extends Lambda implements Function0<com.moloco.sdk.internal.services.usertracker.c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6492a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.usertracker.c invoke() {
                return new com.moloco.sdk.internal.services.usertracker.c(j.f6488a.a());
            }
        }

        public static final class c extends Lambda implements Function0<com.moloco.sdk.internal.services.usertracker.g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6493a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.usertracker.g invoke() {
                k kVar = k.f6490a;
                return new com.moloco.sdk.internal.services.usertracker.g(kVar.d(), kVar.c());
            }
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a a() {
            e eVar = e.f6462a;
            com.moloco.sdk.internal.services.k kVarB = eVar.b();
            com.moloco.sdk.internal.services.b0 b0VarB = i.f6483a.b();
            y yVarF = eVar.f();
            f0 f0VarG = eVar.g();
            com.moloco.sdk.internal.services.usertracker.f fVarE = e();
            h hVar = h.f6477a;
            return new com.moloco.sdk.internal.services.events.a(kVarB, b0VarB, yVarF, f0VarG, fVarE, hVar.b(), hVar.e(), b(), BuildConfig.SDK_VERSION_NAME);
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c b() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c) d.getValue();
        }

        public final com.moloco.sdk.internal.services.usertracker.b c() {
            return (com.moloco.sdk.internal.services.usertracker.b) b.getValue();
        }

        public final com.moloco.sdk.internal.services.usertracker.e d() {
            return new com.moloco.sdk.internal.services.usertracker.a();
        }

        public final com.moloco.sdk.internal.services.usertracker.f e() {
            return (com.moloco.sdk.internal.services.usertracker.f) c.getValue();
        }
    }

    public final Context a() {
        return com.moloco.sdk.internal.android_context.b.a(null, 1, null);
    }

    public static final class f {
        public static volatile com.moloco.sdk.internal.a b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6470a = new f();
        public static final Lazy c = LazyKt.lazy(c.f6473a);
        public static final Lazy d = LazyKt.lazy(C0576a.f6471a);
        public static final Lazy e = LazyKt.lazy(b.f6472a);
        public static final int f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$f$a, reason: collision with other inner class name */
        public static final class C0576a extends Lambda implements Function0<com.moloco.sdk.internal.services.init.e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0576a f6471a = new C0576a();

            public C0576a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.e invoke() {
                e eVar = e.f6462a;
                return new com.moloco.sdk.internal.services.init.e(eVar.f(), eVar.b(), k.f6490a.e(), BuildConfig.SDK_VERSION_NAME, BuildConfig.MOLOCO_ENDPOINT_INIT_CONFIG, 3000L, i.f6483a.a());
            }
        }

        public static final class b extends Lambda implements Function0<com.moloco.sdk.internal.services.init.l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6472a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.l invoke() {
                com.moloco.sdk.internal.services.init.d dVarA = f.f6470a.a();
                com.moloco.sdk.internal.services.init.g.a aVar = com.moloco.sdk.internal.services.init.g.f6401a;
                SharedPreferences sharedPreferences = a.f6451a.a().getSharedPreferences("moloco_sdk_init_cache", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…e\", Context.MODE_PRIVATE)");
                return new com.moloco.sdk.internal.services.init.l(dVarA, aVar.a(sharedPreferences), CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))));
            }
        }

        public static final class c extends Lambda implements Function0<com.moloco.sdk.internal.services.init.o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6473a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.o invoke() {
                return new com.moloco.sdk.internal.services.init.o(BuildConfig.MOLOCO_ENDPOINT_INIT_TRACKING, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a());
            }
        }

        public final com.moloco.sdk.internal.a a(Init.SDKInitResponse initResponse) {
            Intrinsics.checkNotNullParameter(initResponse, "initResponse");
            com.moloco.sdk.internal.a bVar = b;
            if (bVar == null) {
                synchronized (this) {
                    bVar = b;
                    if (bVar == null) {
                        bVar = new com.moloco.sdk.internal.b(initResponse, k.f6490a.a(), h.f6477a.c());
                        b = bVar;
                    }
                }
            }
            return bVar;
        }

        public final com.moloco.sdk.internal.services.init.k b() {
            return (com.moloco.sdk.internal.services.init.k) e.getValue();
        }

        public final com.moloco.sdk.internal.services.init.n c() {
            return (com.moloco.sdk.internal.services.init.n) c.getValue();
        }

        public final com.moloco.sdk.internal.services.init.d a() {
            return (com.moloco.sdk.internal.services.init.d) d.getValue();
        }
    }
}
