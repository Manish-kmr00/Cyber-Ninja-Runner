package io.bidmachine.analytics.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4638n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12118a;
    private final a b;
    private final Lazy c = LazyKt.lazy(new c());
    private final Lazy d = LazyKt.lazy(new b());

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.n$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f12119a;
        private final List b;
        private final List c;

        public a(List list, List list2, List list3) {
            this.f12119a = list;
            this.b = list2;
            this.c = list3;
        }

        public final a a(List list, List list2, List list3) {
            return new a(list, list2, list3);
        }

        public final List b() {
            return this.c;
        }

        public final List c() {
            return this.b;
        }

        public final boolean d() {
            return this.f12119a.isEmpty() && this.b.isEmpty() && this.c.isEmpty();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f12119a, aVar.f12119a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.f12119a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return super.toString();
        }

        public /* synthetic */ a(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
        }

        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.f12119a;
            }
            if ((i & 2) != 0) {
                list2 = aVar.b;
            }
            if ((i & 4) != 0) {
                list3 = aVar.c;
            }
            return aVar.a(list, list2, list3);
        }

        public final List a() {
            return this.f12119a;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.n$b */
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C4638n.this.c().hashCode() + '_' + CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C4638n.this.b().a().size()), Integer.valueOf(C4638n.this.b().c().size()), Integer.valueOf(C4638n.this.b().b().size()), Integer.valueOf(C4638n.this.d().a().size()), Integer.valueOf(C4638n.this.d().c().size()), Integer.valueOf(C4638n.this.d().b().size())}), "_", null, null, 0, null, null, 62, null);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.n$c */
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            C4638n c4638n = C4638n.this;
            jSONObject.put("iaa", new JSONArray((Collection) c4638n.b().a()));
            jSONObject.put("iah", new JSONArray((Collection) c4638n.b().c()));
            jSONObject.put("iad", new JSONArray((Collection) c4638n.b().b()));
            jSONObject.put("sua", new JSONArray((Collection) c4638n.d().a()));
            jSONObject.put("suh", new JSONArray((Collection) c4638n.d().c()));
            jSONObject.put("sud", new JSONArray((Collection) c4638n.d().b()));
            return jSONObject.toString();
        }
    }

    public C4638n(a aVar, a aVar2) {
        this.f12118a = aVar;
        this.b = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return (String) this.c.getValue();
    }

    public final a b() {
        return this.f12118a;
    }

    public final a d() {
        return this.b;
    }

    public final boolean e() {
        return this.f12118a.d() && this.b.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4638n)) {
            return false;
        }
        C4638n c4638n = (C4638n) obj;
        return Intrinsics.areEqual(this.f12118a, c4638n.f12118a) && Intrinsics.areEqual(this.b, c4638n.b);
    }

    public int hashCode() {
        return (this.f12118a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return c();
    }

    public final String a() {
        return (String) this.d.getValue();
    }
}
