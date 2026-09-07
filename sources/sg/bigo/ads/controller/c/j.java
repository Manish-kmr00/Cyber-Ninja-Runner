package sg.bigo.ads.controller.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements sg.bigo.ads.api.core.o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13422a;
    private final long b;
    private final int c;
    private final long d;

    public j(JSONObject jSONObject) {
        this.f13422a = jSONObject.optInt("video_impression_area_rate", 0);
        this.b = jSONObject.optLong("video_impression_time", 0L);
        this.c = jSONObject.optInt("image_impression_area_rate", 0);
        this.d = jSONObject.optLong("image_impression_time", 0L);
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final int a() {
        return this.f13422a;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final long b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final int c() {
        return this.c;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final long d() {
        return this.d;
    }
}
