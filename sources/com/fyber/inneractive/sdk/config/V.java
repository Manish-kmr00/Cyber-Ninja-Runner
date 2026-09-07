package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class V implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f1682a;
    public Integer b;
    public Integer c;
    public Boolean d;
    public Orientation e;
    public Integer f;
    public Integer g;
    public Skip h;
    public TapAction i;
    public UnitDisplayType j;
    public List k;

    public V() {
        Boolean bool = Boolean.TRUE;
        this.f1682a = bool;
        this.b = 5000;
        this.c = 0;
        this.d = bool;
        this.f = 0;
        this.g = 2048;
        this.h = Skip.fromValue(0);
        this.k = new ArrayList();
    }

    @Override // com.fyber.inneractive.sdk.util.c0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        d0.a(jSONObject, "autoPlay", this.f1682a);
        d0.a(jSONObject, "maxBitrate", this.b);
        d0.a(jSONObject, "minBitrate", this.c);
        d0.a(jSONObject, "muted", this.d);
        d0.a(jSONObject, "orientation", this.e);
        d0.a(jSONObject, VastAttributes.PADDING, this.f);
        d0.a(jSONObject, "pivotBitrate", this.g);
        d0.a(jSONObject, EventConstants.SKIP, this.h);
        d0.a(jSONObject, "tapAction", this.i);
        d0.a(jSONObject, "unitDisplayType", this.j);
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.k;
        if (list != null) {
            for (Integer num : list) {
                if (num != null) {
                    jSONArray.put(num);
                }
            }
        }
        d0.a(jSONObject, "filterApi", jSONArray);
        return jSONObject;
    }
}
