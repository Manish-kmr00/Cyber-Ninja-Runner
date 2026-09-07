package sg.bigo.ads.controller.c;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements sg.bigo.ads.api.core.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13418a;
    private final int b;
    private final List<Object> c = new ArrayList();

    public f(JSONObject jSONObject) {
        this.f13418a = jSONObject.optInt(CampaignEx.JSON_KEY_CLICK_MODE, 2);
        this.b = jSONObject.optInt("wrong_click_time", 500);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reconfirm_click_region");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    this.c.add(new g(jSONObjectOptJSONObject));
                }
            }
        }
    }

    @Override // sg.bigo.ads.api.core.c.a
    public final int a() {
        return this.f13418a;
    }

    @Override // sg.bigo.ads.api.core.c.a
    public final int b() {
        return this.b;
    }
}
