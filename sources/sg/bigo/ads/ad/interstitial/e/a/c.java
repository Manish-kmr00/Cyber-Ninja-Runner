package sg.bigo.ads.ad.interstitial.e.a;

import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12795a;

    public c(m mVar, boolean z) {
        super(mVar.a("icon_ads.is_display_layer", 0), mVar.a("icon_ads.ad_component_layout_layer", 1), mVar.a("icon_ads.cta_color_layer", 1), mVar.a("icon_ads.icon_color_layer", 1), mVar.a("icon_ads.icon_num_layer", 20), mVar.a("icon_ads.ad_component_show_time_layer", 0), mVar.a("icon_ads.rotate_time_layer", 2), mVar.a("icon_ads.click_type_layer", 3));
        this.f12795a = z;
    }

    @Override // sg.bigo.ads.ad.interstitial.e.a.b
    public final int c() {
        if (!this.f12795a) {
            return super.c();
        }
        switch (this.c) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.c;
            default:
                return 1;
        }
    }
}
