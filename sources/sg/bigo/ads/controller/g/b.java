package sg.bigo.ads.controller.g;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes12.dex */
public class b extends a<sg.bigo.ads.controller.a.f> implements i {
    protected final sg.bigo.ads.api.a.h i;
    protected final sg.bigo.ads.api.b j;
    protected final sg.bigo.ads.api.a.l k;
    protected final sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> l;

    public b(sg.bigo.ads.api.a.h hVar, sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, sg.bigo.ads.api.b bVar2, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar) {
        super(gVar, bVar, ((long) lVar.d()) * 1000);
        this.i = hVar;
        this.j = bVar2;
        this.k = lVar;
        this.l = eVar;
        bVar2.a(this.e, this.f, this.g);
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final StringBuilder a(long j, String str) {
        StringBuilder sbA = super.a(j, str);
        sbA.append(StringUtils.COMMA).append(q.a(this.k.l()));
        sbA.append(StringUtils.COMMA).append(q.a(this.k.n()));
        return sbA;
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(int i, int i2, String str) {
        sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar = this.l;
        if (eVar != null) {
            eVar.a(a(), i, i2, str, this.k);
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    protected void a(String str, Map<String, Object> map) {
        if (this.l != null) {
            Object obj = map.get("logid");
            sg.bigo.ads.controller.c.b bVarA = sg.bigo.ads.controller.c.b.a(obj instanceof Long ? ((Long) obj).longValue() : 0L, this.j.g, this.k, str);
            if (bVarA != null) {
                this.l.a(a(), this.j, bVarA);
            } else {
                a(1005, 0, "Invalid ad data.");
            }
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(a.b bVar) {
        bVar.a("slot", q.a(this.k.l()));
        bVar.a(Reporting.Key.PLACEMENT_ID, q.a(this.k.n()));
        bVar.a("strategy_id", this.k.a());
        bVar.a("support_adx_types", sg.bigo.ads.api.core.b.a(this.j.c()));
        bVar.a("lat_enable", Integer.valueOf(this.b.z() ? 1 : 0));
        bVar.a("hw_lat_enable", Integer.valueOf(this.b.F() ? 1 : 0));
        bVar.a("fire_lat_enable", Integer.valueOf(this.b.ad() ? 1 : 0));
        bVar.a("token", this.i.l());
        bVar.a("slot_abflags", this.k.o());
        bVar.a("global_abflags", this.i.j());
        bVar.a("support_playable_ad", Integer.valueOf(this.k.r()));
        bVar.a(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.j.g.b);
        int iC = sg.bigo.ads.common.f.b.c();
        bVar.a("req_status", Integer.valueOf(iC));
        this.j.c(iC);
        this.j.b(this.b.X());
        if (sg.bigo.ads.controller.e.h.a().f13462a) {
            bVar.a("algo_info", sg.bigo.ads.controller.e.h.a().e.a(q.a(this.k.l())));
        }
        bVar.a("auc_mode", Integer.valueOf(this.k.v()));
        bVar.a("orientation", Integer.valueOf(sg.bigo.ads.api.core.b.d(this.k.b()) ? this.k.q().a("splash_orientation") : sg.bigo.ads.api.a.i.f13093a == null ? 0 : sg.bigo.ads.api.a.i.f13093a.u()));
        Map<String, Object> mapD = this.j.d();
        if (mapD != null) {
            for (Map.Entry<String, Object> entry : mapD.entrySet()) {
                bVar.a(entry.getKey(), entry.getValue());
            }
        }
        String str = this.j.g.f13095a;
        if (!q.a((CharSequence) str)) {
            bVar.a("load_ext", str);
        }
        String strA = d.a(this.j, this.b);
        if (!TextUtils.isEmpty(strA)) {
            bVar.a("ad_info", strA);
        }
        sg.bigo.ads.common.b bVarAc = this.b.ac();
        bVar.a("bat_stat", bVarAc != null ? String.valueOf(bVarAc.c) : "");
        bVar.a("bat_num", bVarAc != null ? String.valueOf(bVarAc.f13130a) : "");
        bVar.a("bat_scale", bVarAc != null ? String.valueOf(bVarAc.b) : "");
        bVar.a("tc_string", sg.bigo.ads.common.m.b.e());
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.d();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final long e() {
        return this.c != null ? this.c.f13381a.l.b : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected void i() {
        sg.bigo.ads.common.x.a.x();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected boolean j() {
        return sg.bigo.ads.api.a.i.f13093a.d() && sg.bigo.ads.common.x.a.w();
    }

    @Override // sg.bigo.ads.controller.g.i
    public final sg.bigo.ads.api.b k() {
        return this.j;
    }

    @Override // sg.bigo.ads.controller.g.i
    public final sg.bigo.ads.api.a.l l() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sg.bigo.ads.controller.g.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public sg.bigo.ads.controller.a.f f() {
        return this.c.a("/Ad/GetUniAd");
    }
}
