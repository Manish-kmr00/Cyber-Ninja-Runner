package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.a.i;
import sg.bigo.ads.controller.a.k;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends g implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f13375a = r.c.a(2);
    private long e;
    private List<a> d = c();
    private long b = f13375a;

    static class a extends sg.bigo.ads.controller.a.a.a {
        private static final sg.bigo.ads.common.f.a<a> e = new sg.bigo.ads.common.f.a<a>() { // from class: sg.bigo.ads.controller.a.a.f.a.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new a();
            }
        };
        private String f;

        public a() {
        }

        public a(String str, String str2, boolean z, String str3) {
            super(str, str2, z);
            this.f = str3;
        }

        @Override // sg.bigo.ads.controller.a.k, sg.bigo.ads.common.f
        public final void a(Parcel parcel) {
            super.a(parcel);
            parcel.writeString(this.f);
        }

        @Override // sg.bigo.ads.controller.a.k, sg.bigo.ads.common.f
        public final void b(Parcel parcel) {
            super.b(parcel);
            this.f = n.a(parcel, "");
        }
    }

    private k b(final String str) {
        synchronized (this) {
            if (sg.bigo.ads.common.utils.k.a((Collection) this.d)) {
                return null;
            }
            a aVar = (a) a(sg.bigo.ads.common.utils.k.a(this.d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.1
                @Override // java.lang.Comparable
                public final /* synthetic */ int compareTo(a aVar2) {
                    a aVar3 = aVar2;
                    return (aVar3 == null || !aVar3.d || aVar3.b || !TextUtils.equals(aVar3.f, str)) ? 0 : 1;
                }
            }));
            if (aVar != null) {
                return aVar;
            }
            List listA = sg.bigo.ads.common.utils.k.a(this.d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.2
                @Override // java.lang.Comparable
                public final /* synthetic */ int compareTo(a aVar2) {
                    a aVar3 = aVar2;
                    return (aVar3 != null && aVar3.d && aVar3.b && TextUtils.equals(aVar3.f, str)) ? 1 : 0;
                }
            });
            if (!sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                return a(listA);
            }
            List listA2 = sg.bigo.ads.common.utils.k.a(this.d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.3
                @Override // java.lang.Comparable
                public final /* bridge */ /* synthetic */ int compareTo(a aVar2) {
                    a aVar3 = aVar2;
                    return (aVar3 == null || !aVar3.d || aVar3.b) ? 0 : 1;
                }
            });
            if (!sg.bigo.ads.common.utils.k.a((Collection) listA2)) {
                return a(listA2);
            }
            a aVar2 = (a) a(sg.bigo.ads.common.utils.k.a(this.d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.4
                @Override // java.lang.Comparable
                public final /* bridge */ /* synthetic */ int compareTo(a aVar3) {
                    a aVar4 = aVar3;
                    return (aVar4 != null && aVar4.d && aVar4.b) ? 1 : 0;
                }
            }));
            if (aVar2 != null) {
                return aVar2;
            }
            return null;
        }
    }

    private static List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("AWS", "https://ad-host-backup-asia.s3.ap-southeast-1.amazonaws.com/uni/v2/au.pj", true, "asia"));
        arrayList.add(new a("AWS", "https://ad-host-backup-europe.s3.eu-central-1.amazonaws.com/uni/v2/au.pj", true, "europe"));
        arrayList.add(new a("AWS", "https://ad-host-backup-america.s3.us-west-1.amazonaws.com/uni/v2/au.pj", true, "america"));
        return arrayList;
    }

    @Override // sg.bigo.ads.controller.a.a.g
    public final k a(String str) {
        if (sg.bigo.ads.common.utils.k.a((Collection) this.d)) {
            return null;
        }
        return b(i.a(str));
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        synchronized (this) {
            parcel.writeLong(this.b);
            n.a(parcel, this.d);
            parcel.writeLong(this.e);
        }
    }

    public final void a(JSONObject jSONObject) {
        synchronized (this) {
            long jMax = Math.max(jSONObject.optLong("interval", f13375a / 1000) * 1000, c);
            List<a> listC = c();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urls");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject.optString("name", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("url", "");
                    String strOptString3 = jSONObjectOptJSONObject.optString("region", "");
                    if (URLUtil.isNetworkUrl(strOptString2)) {
                        listC.add(new a(strOptString, strOptString2, false, strOptString3));
                    }
                }
            }
            this.b = jMax;
            this.d = listC;
        }
    }

    public final boolean a() {
        return Math.abs(System.currentTimeMillis() - this.e) > this.b;
    }

    public final void b() {
        this.e = System.currentTimeMillis();
        synchronized (this) {
            if (sg.bigo.ads.common.utils.k.a((Collection) this.d)) {
                return;
            }
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().d = true;
            }
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        synchronized (this) {
            this.b = n.a(parcel, f13375a);
            List<a> listA = n.a(parcel, a.e);
            this.d = listA;
            if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                this.d = c();
            }
            this.e = n.a(parcel, 0L);
        }
    }
}
