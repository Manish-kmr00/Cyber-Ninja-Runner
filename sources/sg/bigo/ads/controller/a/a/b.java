package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import android.text.TextUtils;
import com.json.b9;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.controller.a.j;

/* JADX INFO: loaded from: classes6.dex */
public class b implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0883b f13368a;
    public C0883b b;
    public int c;
    private final String d;
    private final String e;
    private Map<a, C0883b> f;
    private Map<a, List<C0883b>> g;
    private int h = 3;
    private Map<a, C0883b> i = a();
    private Map<a, List<C0883b>> j;

    static class a implements sg.bigo.ads.common.f {
        private static final sg.bigo.ads.common.f.a<a> c = new sg.bigo.ads.common.f.a<a>() { // from class: sg.bigo.ads.controller.a.a.b.a.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new a("", 0);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13370a;
        public int b;

        protected a(String str, int i) {
            this.f13370a = TextUtils.isEmpty(str) ? "all" : str.toLowerCase();
            this.b = i;
        }

        @Override // sg.bigo.ads.common.f
        public final void a(Parcel parcel) {
            parcel.writeString(this.f13370a);
            parcel.writeInt(this.b);
        }

        @Override // sg.bigo.ads.common.f
        public final void b(Parcel parcel) {
            this.f13370a = n.a(parcel, "");
            this.b = n.a(parcel, 0);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.f13370a, aVar.f13370a) && this.b == aVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.f13370a + "_" + this.b).hashCode();
        }

        public final String toString() {
            return super.toString();
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.controller.a.a.b$b, reason: collision with other inner class name */
    public static class C0883b extends j implements sg.bigo.ads.common.f {
        private static final sg.bigo.ads.common.f.a<C0883b> e = new sg.bigo.ads.common.f.a<C0883b>() { // from class: sg.bigo.ads.controller.a.a.b.b.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new C0883b("", "", 0);
            }
        };
        boolean d;

        protected C0883b(String str, String str2, int i) {
            super(str, str2, i);
            this.d = true;
        }

        @Override // sg.bigo.ads.common.f
        public final void a(Parcel parcel) {
            parcel.writeString(this.f13397a);
            parcel.writeInt(this.c);
            n.a(parcel, this.d);
            parcel.writeString(this.b);
        }

        public final void a(String str) {
            this.b = str;
        }

        @Override // sg.bigo.ads.common.f
        public final void b(Parcel parcel) {
            this.f13397a = n.a(parcel, "");
            this.c = n.a(parcel, 1);
            this.d = n.b(parcel, true);
            this.b = n.a(parcel, "");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof j) {
                return TextUtils.equals(this.f13397a, ((j) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            if (this.f13397a != null) {
                return this.f13397a.hashCode();
            }
            return 0;
        }
    }

    public b(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    private static List<a> a(a aVar) {
        ArrayList arrayList = new ArrayList();
        a aVar2 = new a("all", 0);
        if (aVar2.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar2);
        a aVar3 = new a("all", aVar.b);
        if (aVar3.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar3);
        a aVar4 = new a(aVar.f13370a, 0);
        if (aVar4.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar4);
        arrayList.add(0, aVar);
        return arrayList;
    }

    private Map<a, C0883b> a() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.d)) {
            map.put(new a("all", 0), new C0883b(this.d, "", 0));
        }
        if (!TextUtils.isEmpty(this.e)) {
            map.put(new a("ru", 0), new C0883b(this.e, "", 0));
        }
        return map;
    }

    private static C0883b a(Map<a, C0883b> map, a aVar) {
        if (!k.a(map) && aVar != null) {
            Iterator<a> it = a(aVar).iterator();
            while (it.hasNext()) {
                C0883b c0883b = map.get(it.next());
                if (a(c0883b)) {
                    return c0883b;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0034 A[PHI: r0
  0x0034: PHI (r0v2 sg.bigo.ads.controller.a.a.b$b) = 
  (r0v1 sg.bigo.ads.controller.a.a.b$b)
  (r0v5 sg.bigo.ads.controller.a.a.b$b)
  (r0v7 sg.bigo.ads.controller.a.a.b$b)
  (r0v9 sg.bigo.ads.controller.a.a.b$b)
 binds: [B:3:0x000b, B:5:0x0017, B:7:0x0023, B:9:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    private C0883b a(a aVar, boolean z) {
        boolean z2;
        C0883b c0883bA = a(this.f, aVar);
        if (a(c0883bA)) {
            z2 = true;
        } else {
            c0883bA = b(this.g, aVar);
            if (a(c0883bA)) {
                z2 = true;
            } else {
                c0883bA = a(this.i, aVar);
                if (a(c0883bA)) {
                    z2 = true;
                } else {
                    c0883bA = b(this.j, aVar);
                    if (a(c0883bA)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBanHost", "getBestHost " + (z2 ? "success" : b9.f.e) + (z ? " after reset" : "") + ", countryKey=" + aVar + ", currentHost=" + this.b);
        if (a(c0883bA)) {
            return c0883bA;
        }
        return null;
    }

    private void a(Map<a, C0883b> map, Map<a, List<C0883b>> map2, String str, int i) {
        C0883b value;
        C0883b c0883b;
        synchronized (this) {
            if (!k.a(this.f) && !k.a(map)) {
                for (Map.Entry<a, C0883b> entry : this.f.entrySet()) {
                    a key = entry.getKey();
                    if (key != null && (value = entry.getValue()) != null && (c0883b = map.get(key)) != null && value.equals(c0883b)) {
                        value.a(c0883b.b());
                    }
                }
            }
            if (!k.a(this.g) && !k.a(map2)) {
                for (Map.Entry<a, List<C0883b>> entry2 : this.g.entrySet()) {
                    a key2 = entry2.getKey();
                    if (key2 != null) {
                        List<C0883b> value2 = entry2.getValue();
                        if (!k.a((Collection) value2)) {
                            List<C0883b> list = map2.get(key2);
                            if (!k.a((Collection) list)) {
                                for (C0883b c0883b2 : value2) {
                                    if (c0883b2 != null) {
                                        for (C0883b c0883b3 : list) {
                                            if (c0883b2.equals(c0883b3)) {
                                                c0883b2.a(c0883b3.b());
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            C0883b c0883b4 = this.b;
            if (c0883b4 != null) {
                if (c0883b4.d() != 1) {
                    if (this.b.d() == 2) {
                        List<C0883b> list2 = this.g.get(new a(str, i));
                        if (!k.a((Collection) list2)) {
                            for (C0883b c0883b5 : list2) {
                                if (this.b.equals(c0883b5)) {
                                    this.b.a(c0883b5.b());
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    C0883b c0883b6 = this.f.get(new a(str, i));
                    if (this.b.equals(c0883b6)) {
                        this.b.a(c0883b6.b());
                    }
                }
            }
        }
    }

    private static boolean a(C0883b c0883b) {
        return c0883b != null && c0883b.d;
    }

    private C0883b b(Map<a, List<C0883b>> map, a aVar) {
        if (!k.a(map) && aVar != null) {
            Iterator<a> it = a(aVar).iterator();
            while (it.hasNext()) {
                C0883b c0883b = (C0883b) k.a(k.a(map.get(it.next()), new Comparable<C0883b>() { // from class: sg.bigo.ads.controller.a.a.b.1
                    @Override // java.lang.Comparable
                    public final /* bridge */ /* synthetic */ int compareTo(C0883b c0883b2) {
                        C0883b c0883b3 = c0883b2;
                        return (c0883b3 == null || !c0883b3.d) ? 0 : 1;
                    }
                }));
                if (a(c0883b)) {
                    return c0883b;
                }
            }
        }
        return null;
    }

    public final sg.bigo.ads.controller.a.e a(String str, int i) {
        boolean z;
        synchronized (this) {
            if (this.b != null && this.c < this.h) {
                return new sg.bigo.ads.controller.a.e(this.b, false, false);
            }
            a aVar = new a(str, i);
            C0883b c0883bA = a(aVar, false);
            if (a(c0883bA)) {
                z = false;
            } else {
                Map<a, C0883b> map = this.f;
                if (map != null) {
                    Iterator<Map.Entry<a, C0883b>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        C0883b value = it.next().getValue();
                        if (value != null) {
                            value.d = true;
                        }
                    }
                }
                Map<a, List<C0883b>> map2 = this.g;
                if (map2 != null) {
                    Iterator<Map.Entry<a, List<C0883b>>> it2 = map2.entrySet().iterator();
                    while (it2.hasNext()) {
                        List<C0883b> value2 = it2.next().getValue();
                        if (!k.a((Collection) value2)) {
                            Iterator<C0883b> it3 = value2.iterator();
                            while (it3.hasNext()) {
                                it3.next().d = true;
                            }
                        }
                    }
                }
                Map<a, List<C0883b>> map3 = this.j;
                if (map3 != null) {
                    Iterator<Map.Entry<a, List<C0883b>>> it4 = map3.entrySet().iterator();
                    while (it4.hasNext()) {
                        List<C0883b> value3 = it4.next().getValue();
                        if (!k.a((Collection) value3)) {
                            Iterator<C0883b> it5 = value3.iterator();
                            while (it5.hasNext()) {
                                it5.next().d = true;
                            }
                        }
                    }
                }
                Map<a, C0883b> map4 = this.i;
                if (map4 != null) {
                    Iterator<Map.Entry<a, C0883b>> it6 = map4.entrySet().iterator();
                    while (it6.hasNext()) {
                        C0883b value4 = it6.next().getValue();
                        if (value4 != null) {
                            value4.d = true;
                        }
                    }
                }
                this.f13368a = this.b;
                this.b = null;
                this.c = 0;
                c0883bA = a(aVar, true);
                z = true;
            }
            if (a(c0883bA)) {
                c0883bA.d = false;
                this.f13368a = this.b;
                this.b = new C0883b(c0883bA.a(), c0883bA.b(), c0883bA.d());
                this.c = 0;
            }
            if (this.b == null) {
                this.b = new C0883b(this.d, "", 0);
            }
            return new sg.bigo.ads.controller.a.e(this.b, z, true);
        }
    }

    @Override // sg.bigo.ads.common.f
    public void a(Parcel parcel) {
        synchronized (this) {
            n.a(parcel, this.f);
            n.b(parcel, this.g);
            parcel.writeInt(this.h);
            n.a(parcel, this.i);
            n.b(parcel, this.j);
            n.a(parcel, this.f13368a);
            n.a(parcel, this.b);
            parcel.writeInt(this.c);
        }
    }

    public void a(JSONObject jSONObject, boolean z, String str, int i) {
        synchronized (this) {
            HashMap map = new HashMap();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("country_hosts");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("host", "");
                        if (sg.bigo.ads.controller.a.d.a(strOptString)) {
                            map.put(new a(jSONObjectOptJSONObject.optString("country", "all"), jSONObjectOptJSONObject.optInt("app_flag", 0)), new C0883b(strOptString, jSONObjectOptJSONObject.optString("domain_front", ""), 1));
                        }
                    }
                }
            }
            HashMap map2 = new HashMap();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("backup_hosts");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i3);
                    if (jSONObjectOptJSONObject2 != null) {
                        a aVar = new a(jSONObjectOptJSONObject2.optString("country", "all"), jSONObjectOptJSONObject2.optInt("app_flag", 0));
                        List<C0883b> arrayList = map2.get(aVar);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            map2.put(aVar, arrayList);
                        }
                        String strOptString2 = jSONObjectOptJSONObject2.optString("domain_front", "");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("hosts");
                        if (jSONArrayOptJSONArray3 != null) {
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                                String strOptString3 = jSONArrayOptJSONArray3.optString(i4, "");
                                if (sg.bigo.ads.controller.a.d.a(strOptString3)) {
                                    C0883b c0883b = new C0883b(strOptString3, strOptString2, 2);
                                    if (!arrayList.contains(c0883b)) {
                                        arrayList.add(c0883b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                a(map, map2, str, i);
            } else {
                int iOptInt = jSONObject.optInt("threshold", 3);
                this.f = map;
                this.g = map2;
                this.h = iOptInt;
                this.j = new HashMap();
                this.i = a();
                this.f13368a = this.b;
                this.b = null;
                this.c = 0;
            }
        }
    }

    public final boolean a(String str, String str2) {
        synchronized (this) {
            if (!sg.bigo.ads.controller.a.d.a(str2)) {
                return false;
            }
            a aVar = new a(str, 0);
            if (this.j == null) {
                this.j = new HashMap();
            }
            List<C0883b> arrayList = this.j.get(aVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.j.put(aVar, arrayList);
            }
            C0883b c0883b = new C0883b(str2, "", 3);
            if (arrayList.contains(c0883b)) {
                return false;
            }
            arrayList.add(c0883b);
            return true;
        }
    }

    @Override // sg.bigo.ads.common.f
    public void b(Parcel parcel) {
        synchronized (this) {
            this.f = n.a(parcel, a.c, C0883b.e);
            this.g = n.b(parcel, a.c, C0883b.e);
            this.h = n.a(parcel, 3);
            Map mapA = n.a(parcel, a.c, C0883b.e);
            this.j = n.b(parcel, a.c, C0883b.e);
            this.f13368a = (C0883b) n.b(parcel, C0883b.e);
            this.b = (C0883b) n.b(parcel, C0883b.e);
            this.c = n.a(parcel, 0);
            this.i = a();
            HashSet hashSet = new HashSet();
            for (C0883b c0883b : this.i.values()) {
                hashSet.add(c0883b.a());
                if (!k.a(mapA)) {
                    for (C0883b c0883b2 : mapA.values()) {
                        if (TextUtils.equals(c0883b.a(), c0883b2.a())) {
                            c0883b.d = c0883b2.d;
                        }
                    }
                }
            }
            C0883b c0883b3 = this.b;
            if (c0883b3 != null && c0883b3.d() == 0 && !hashSet.contains(this.b.a())) {
                this.f13368a = this.b;
                this.b = null;
                this.c = 0;
            }
        }
    }

    public String toString() {
        return super.toString();
    }
}
