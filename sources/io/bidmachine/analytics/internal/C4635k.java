package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C4635k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4635k f12101a = new C4635k();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static Map c = MapsKt.emptyMap();
    private static final C4636l d = new C4636l();

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$a */
    private static final class a implements InterfaceC4630f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12102a;
        private final String b;

        public a(String str, String str2) {
            this.f12102a = str;
            this.b = str2;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4630f
        public void a(Map map) {
            C4637m.f12113a.a(new Q(null, this.f12102a, this.b, 0L, map, null, 41, null));
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4630f
        public void a(q0 q0Var) {
            C4637m.f12113a.a(new Q(null, this.f12102a, this.b, 0L, null, q0Var, 25, null));
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$b */
    private static final class b implements InterfaceC4632h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12103a;

        public b(String str) {
            this.f12103a = str;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4632h
        public void a(List list) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                InterfaceC4632h.a aVar = (InterfaceC4632h.a) it.next();
                String str = this.f12103a;
                String strA = aVar.a();
                if (strA == null) {
                    strA = "";
                }
                arrayList.add(new h0(null, str, 0L, strA, new h0.a(aVar.c().getTag(), aVar.c().getPath()), aVar.b(), false, 69, null));
            }
            C4637m.f12113a.a(this.f12103a, arrayList);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$c */
    static final class c extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12104a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4631g invoke() {
            return new O();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$d */
    static final class d extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12105a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4631g invoke() {
            return new A();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$e */
    static final class e extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12106a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context) {
            super(0);
            this.f12106a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4633i invoke() {
            return new C4649z(this.f12106a.getFilesDir().getParentFile());
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$f */
    static final class f extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f12107a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4633i invoke() {
            return new C4645v();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$g */
    static final class g extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f12108a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4633i invoke() {
            return new H(C4635k.f12101a.a().a(), null, 2, null);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.k$h */
    static final class h extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f12109a = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4633i invoke() {
            return new d0(C4635k.f12101a.a().b(), null, 2, 0 == true ? 1 : 0);
        }
    }

    private C4635k() {
    }

    public final void a(Context context, AnalyticsConfig analyticsConfig) {
        a(context, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), c.keySet());
        HashSet hashSet = new HashSet();
        a(analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getMonitorConfigList(), hashSet);
        a(analyticsConfig.getReaderConfigList(), hashSet);
        b(context, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), hashSet);
    }

    public final void b(Context context, Map map, String str, Function0 function0) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbstractC4633i abstractC4633i = (AbstractC4633i) function0.invoke();
            abstractC4633i.a(context);
            map.put(abstractC4633i.a(), abstractC4633i);
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            f12101a.a(str, thM7907exceptionOrNullimpl);
        }
    }

    private final void a(String str, List list, Set set) {
        Object objM7904constructorimpl;
        Unit unit;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String name = ((MonitorConfig) it.next()).getName();
            try {
                Result.Companion companion = Result.INSTANCE;
                AbstractC4634j abstractC4634j = (AbstractC4634j) c.get(name);
                if (abstractC4634j != null) {
                    if (abstractC4634j instanceof AbstractC4631g) {
                        ((AbstractC4631g) abstractC4634j).a(new AbstractC4631g.a(new a(name, str)));
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                objM7904constructorimpl = Result.m7904constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                set.add(name);
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                f12101a.a(name, str, thM7907exceptionOrNullimpl);
            }
        }
    }

    private final void b(Context context, String str, Set set) {
        Object objM7904constructorimpl;
        Context applicationContext = context.getApplicationContext();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC4634j abstractC4634j = (AbstractC4634j) c.get((String) it.next());
            if (abstractC4634j != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    abstractC4634j.c(applicationContext);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                if (thM7907exceptionOrNullimpl != null) {
                    f12101a.a(abstractC4634j, str, thM7907exceptionOrNullimpl);
                }
            }
        }
    }

    private final void a(List list, Set set) {
        Object objM7904constructorimpl;
        Unit unit;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReaderConfig readerConfig = (ReaderConfig) it.next();
            String name = readerConfig.getName();
            try {
                Result.Companion companion = Result.INSTANCE;
                AbstractC4634j abstractC4634j = (AbstractC4634j) c.get(name);
                if (abstractC4634j != null) {
                    if (abstractC4634j instanceof AbstractC4633i) {
                        ((AbstractC4633i) abstractC4634j).a((Object) new AbstractC4633i.a(readerConfig.getInterval(), readerConfig.getRules(), new b(name)));
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                objM7904constructorimpl = Result.m7904constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                set.add(name);
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                f12101a.a(name, thM7907exceptionOrNullimpl);
            }
        }
    }

    public final void b(Context context) {
        if (b.compareAndSet(false, true) && !s0.a(context)) {
            c = a(context);
        }
    }

    public final void a(Context context, Map map, String str, Function0 function0) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbstractC4631g abstractC4631g = (AbstractC4631g) function0.invoke();
            abstractC4631g.a(context);
            map.put(abstractC4631g.a(), abstractC4631g);
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            f12101a.a(str, "", thM7907exceptionOrNullimpl);
        }
    }

    public final Map a(Context context) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(context, linkedHashMap, "mimp", c.f12104a);
        a(context, linkedHashMap, "isimp", d.f12105a);
        b(context, linkedHashMap, "aints", new e(context));
        b(context, linkedHashMap, "aexs", f.f12107a);
        b(context, linkedHashMap, "alog", g.f12108a);
        b(context, linkedHashMap, "apur", h.f12109a);
        return linkedHashMap;
    }

    private final void a(Context context, String str, Set set) {
        Object objM7904constructorimpl;
        Context applicationContext = context.getApplicationContext();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC4634j abstractC4634j = (AbstractC4634j) c.get((String) it.next());
            if (abstractC4634j != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    abstractC4634j.b(applicationContext);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                if (thM7907exceptionOrNullimpl != null) {
                    f12101a.a(abstractC4634j, str, thM7907exceptionOrNullimpl);
                }
            }
        }
    }

    public final Map a(AbstractC4629e.a aVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : c.entrySet()) {
            String str = (String) entry.getKey();
            AbstractC4634j abstractC4634j = (AbstractC4634j) entry.getValue();
            if (abstractC4634j instanceof AbstractC4629e) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                AbstractC4629e abstractC4629e = (AbstractC4629e) abstractC4634j;
                AbstractC4629e.b bVarB = abstractC4629e.b();
                if (bVarB != null) {
                    linkedHashMap2.put("imd", Integer.valueOf(bVarB.a()));
                    linkedHashMap2.put("wp", Float.valueOf(bVarB.b()));
                    linkedHashMap2.put("agency", bVarB.c());
                }
                AbstractC4629e.b bVarA = abstractC4629e.a(aVar);
                if (bVarA != null) {
                    linkedHashMap2.put("imimd", Integer.valueOf(bVarA.a()));
                    linkedHashMap2.put("imwp", Float.valueOf(bVarA.b()));
                    linkedHashMap2.put("imagency", bVarA.c());
                }
                linkedHashMap.put(str, linkedHashMap2);
            }
        }
        return linkedHashMap;
    }

    public final C4636l a() {
        return d;
    }

    private final void a(String str, String str2, Throwable th) {
        C4637m.f12113a.a(new Q(null, str, str2, 0L, null, new q0(str, q0.a.MONITOR_INVALID, s0.a(th)), 25, null));
    }

    private final void a(String str, Throwable th) {
        C4637m.f12113a.a(new h0(null, str, 0L, "", new h0.a("", ""), new q0(str, q0.a.READER_INVALID, s0.a(th)), false, 69, null));
    }

    private final void a(AbstractC4634j abstractC4634j, String str, Throwable th) {
        if (abstractC4634j instanceof AbstractC4631g) {
            a(abstractC4634j.a(), str, th);
        } else if (abstractC4634j instanceof AbstractC4633i) {
            a(abstractC4634j.a(), th);
        }
    }
}
