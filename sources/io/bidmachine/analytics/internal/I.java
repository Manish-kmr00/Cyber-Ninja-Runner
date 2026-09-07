package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J f12048a;
    private final G.a b;
    private Map c;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements G.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final J f12049a;

        public a(J j) {
            this.f12049a = j;
        }

        @Override // io.bidmachine.analytics.internal.G.a
        public G a() {
            return new G(this.f12049a, new K(), CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(Executors.newSingleThreadExecutor())));
        }
    }

    public I(J j, G.a aVar) {
        this.f12048a = j;
        this.b = aVar;
    }

    public final void a(AbstractC4633i.a aVar) {
        List listC = aVar.c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((ReaderConfig.Rule) it.next()).getPath());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(obj, this.b.a());
        }
        this.c = MapsKt.toMutableMap(linkedHashMap);
    }

    public final void b() {
        Map map = this.c;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                ((G) entry.getValue()).a((String) entry.getKey());
            }
        }
    }

    public /* synthetic */ I(J j, G.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new a(j) : aVar);
    }

    public final String a(ReaderConfig.Rule rule) throws FileNotFoundException {
        String strB = this.f12048a.b(rule.getPath());
        if (strB != null) {
            return strB;
        }
        throw new FileNotFoundException();
    }

    public final void a() {
        Map map = this.c;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((G) ((Map.Entry) it.next()).getValue()).a();
            }
        }
    }
}
