package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4637m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4637m f12113a = new C4637m();
    private static final p0 b;
    private static final CoroutineScope c;
    private static C4627c d;
    private static V e;
    private static l0 f;
    private static Map g;
    private static Map h;
    private static final List i;

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.m$a */
    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12114a;
        final /* synthetic */ V b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(V v, String str, List list, Continuation continuation) {
            super(2, continuation);
            this.b = v;
            this.c = str;
            this.d = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12114a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.m$b */
    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12115a;
        final /* synthetic */ l0 b;
        final /* synthetic */ List c;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l0 l0Var, List list, List list2, Continuation continuation) {
            super(2, continuation);
            this.b = l0Var;
            this.c = list;
            this.d = list2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12115a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    static {
        p0 p0VarA = p0.g.a();
        b = p0VarA;
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(p0VarA.b()));
        g = MapsKt.emptyMap();
        h = MapsKt.emptyMap();
        i = Collections.synchronizedList(new ArrayList());
    }

    private C4637m() {
    }

    private final synchronized C4627c a(Context context) {
        C4627c c4627c;
        c4627c = d;
        if (c4627c == null) {
            c4627c = new C4627c(context);
            d = c4627c;
        }
        return c4627c;
    }

    private final synchronized l0 b(C4627c c4627c) {
        l0 l0Var;
        l0 l0Var2 = f;
        l0Var = l0Var2;
        if (l0Var2 == null) {
            m0 m0Var = new m0(c4627c);
            m0Var.b();
            f = m0Var;
            l0Var = m0Var;
        }
        return l0Var;
    }

    private final void a(V v, String str, List list) {
        BuildersKt__Builders_commonKt.launch$default(c, b.c(), null, new a(v, str, list, null), 2, null);
    }

    private final void a(l0 l0Var, List list, List list2) {
        BuildersKt__Builders_commonKt.launch$default(c, b.c(), null, new b(l0Var, list, list2, null), 2, null);
    }

    public final void a(Context context, AnalyticsConfig analyticsConfig) {
        synchronized (this) {
            C4637m c4637m = f12113a;
            C4627c c4627cA = c4637m.a(context);
            V vA = c4637m.a(c4627cA);
            l0 l0VarB = c4637m.b(c4627cA);
            c4637m.a(g);
            g = c4637m.a(analyticsConfig, vA);
            h = c4637m.a(context, analyticsConfig, l0VarB);
            c4637m.a(analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String());
            String str = analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String();
            List<MonitorConfig> monitorConfigList = analyticsConfig.getMonitorConfigList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(monitorConfigList, 10));
            Iterator<T> it = monitorConfigList.iterator();
            while (it.hasNext()) {
                arrayList.add(((MonitorConfig) it.next()).getName());
            }
            c4637m.a(vA, str, arrayList);
            C4637m c4637m2 = f12113a;
            List<ReaderConfig> readerConfigList = analyticsConfig.getReaderConfigList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(readerConfigList, 10));
            Iterator<T> it2 = readerConfigList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((ReaderConfig) it2.next()).getName());
            }
            List<ReaderConfig> readerConfigList2 = analyticsConfig.getReaderConfigList();
            ArrayList<List> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(readerConfigList2, 10));
            Iterator<T> it3 = readerConfigList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((ReaderConfig) it3.next()).getRules());
            }
            ArrayList arrayList4 = new ArrayList();
            for (List<ReaderConfig.Rule> list : arrayList3) {
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ReaderConfig.Rule rule : list) {
                    arrayList5.add(new h0.a(rule.getTag(), rule.getPath()));
                }
                CollectionsKt.addAll(arrayList4, arrayList5);
            }
            c4637m2.a(l0VarB, arrayList2, arrayList4);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Map a(AnalyticsConfig analyticsConfig, V v) {
        List<MonitorConfig> monitorConfigList = analyticsConfig.getMonitorConfigList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : monitorConfigList) {
            if (((MonitorConfig) obj).getIsReportEnabled()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new X(p0.g.a(), new X.b((MonitorConfig) it.next(), analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras()), v));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(((X) obj2).b(), obj2);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0087  */
    private final Map a(Context context, AnalyticsConfig analyticsConfig, l0 l0Var) {
        g0.a c4644u;
        n0 n0Var;
        List<ReaderConfig> readerConfigList = analyticsConfig.getReaderConfigList();
        ArrayList arrayList = new ArrayList();
        for (ReaderConfig readerConfig : readerConfigList) {
            String name = readerConfig.getName();
            int iHashCode = name.hashCode();
            if (iHashCode != 2990623) {
                if (iHashCode != 2997059) {
                    if (iHashCode != 3001100) {
                        if (iHashCode == 92819013 && name.equals("aints")) {
                            c4644u = new C4648y(context.getFilesDir().getParentFile());
                            n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c4644u), l0Var);
                        } else {
                            n0Var = null;
                        }
                    } else if (name.equals("apur")) {
                        c4644u = new c0(C4635k.f12101a.a().b());
                        n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c4644u), l0Var);
                    } else {
                        n0Var = null;
                    }
                } else if (name.equals("alog")) {
                    c4644u = new E(C4635k.f12101a.a().a());
                    n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c4644u), l0Var);
                } else {
                    n0Var = null;
                }
            } else if (name.equals("aexs")) {
                c4644u = new C4644u();
                n0Var = new n0(p0.g.a(), new n0.a(readerConfig, analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String(), analyticsConfig.getExtras(), c4644u), l0Var);
            } else {
                n0Var = null;
            }
            if (n0Var != null) {
                arrayList.add(n0Var);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((n0) obj).a(), obj);
        }
        return linkedHashMap;
    }

    private final void a(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((X) it.next()).a();
        }
    }

    private final V a(C4627c c4627c) {
        V v = e;
        if (v != null) {
            return v;
        }
        W w = new W(c4627c);
        w.b();
        e = w;
        return w;
    }

    public final void a(Q q) {
        if (Intrinsics.areEqual(q.e(), "")) {
            i.add(q);
            return;
        }
        X x = (X) g.get(q.d());
        if (x != null) {
            x.b(q);
        }
    }

    private final void a(String str) {
        List list = i;
        List list2 = CollectionsKt.toList(list);
        list.clear();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            f12113a.a(Q.a((Q) it.next(), null, null, str, 0L, null, null, 59, null));
        }
    }

    public final void a(h0 h0Var) {
        a(h0Var.d(), CollectionsKt.listOf(h0Var));
    }

    public final void a(String str, List list) {
        n0 n0Var = (n0) h.get(str);
        if (n0Var != null) {
            n0Var.b(str, list);
        }
    }
}
