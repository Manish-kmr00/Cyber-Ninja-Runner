package sg.bigo.ads.api;

import java.util.LinkedHashMap;
import java.util.Map;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes10.dex */
public class IconAdsRequest extends sg.bigo.ads.api.b implements sg.bigo.ads.api.b.c {
    private final l h;
    private final sg.bigo.ads.api.core.c i;
    private final int j;
    private final int k;
    private final int l;
    private final b m;

    public static class a extends c<a, IconAdsRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f13085a;
        public sg.bigo.ads.api.core.c b;
        public int c;
        public int d = 1;
        public int e = 20;
        public b f;

        @Override // sg.bigo.ads.api.c
        protected final /* synthetic */ sg.bigo.ads.api.b createAdRequest() {
            if (this.f13085a == null) {
                return null;
            }
            return new IconAdsRequest(this, (byte) 0);
        }
    }

    public interface b {
        int a();
    }

    private IconAdsRequest(a aVar) {
        super(aVar.mSlotId, null);
        this.h = aVar.f13085a;
        this.i = aVar.b;
        this.j = aVar.c;
        this.k = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
    }

    /* synthetic */ IconAdsRequest(a aVar, byte b2) {
        this(aVar);
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return this.h.b();
    }

    @Override // sg.bigo.ads.api.b
    public final Map<String, Object> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        sg.bigo.ads.api.core.c cVar = this.i;
        if (cVar != null) {
            linkedHashMap.put("host_slot", cVar.b());
            linkedHashMap.put("host_placement", this.i.c());
            linkedHashMap.put("host_ad_type", Integer.valueOf(this.i.x()));
            linkedHashMap.put("host_adx_type", Integer.valueOf(this.i.w()));
            linkedHashMap.put("dsp_source", this.i.v());
            linkedHashMap.put("main_domain", this.i.i());
            linkedHashMap.put("main_bundle", this.i.n());
            linkedHashMap.put("main_adx_sid", Long.valueOf(this.i.y()));
            linkedHashMap.put("main_ad_id", this.i.r());
            linkedHashMap.put("dsp_extra", this.i.an());
        }
        linkedHashMap.put("adx_type", 5);
        linkedHashMap.put("ad_type", Integer.valueOf(c()));
        linkedHashMap.put("icon_ads_type", Integer.valueOf(this.k));
        linkedHashMap.put("scene_page", Integer.valueOf(this.j));
        linkedHashMap.put("icon_num", Integer.valueOf(this.l));
        return linkedHashMap;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean e() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean f() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean g() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final l h() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.b.b
    public final sg.bigo.ads.api.core.c i() {
        return this.i;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int j() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int k() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int l() {
        b bVar = this.m;
        if (bVar != null) {
            return bVar.a();
        }
        return 1;
    }
}
