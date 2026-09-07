package com.applovin.impl;

import com.adjust.sdk.Constants;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f411a;

    public f1(JSONObject jSONObject) {
        this.f411a = jSONObject;
    }

    protected Integer a() {
        return JsonUtils.getInteger(this.f411a, "dark_mode_toolbar_color", null);
    }

    protected String b() {
        return JsonUtils.getString(this.f411a, "digital_asset_link_url", null);
    }

    protected Boolean c() {
        return JsonUtils.getBoolean(this.f411a, "instant_apps_enabled", null);
    }

    protected String d() {
        return JsonUtils.getString(this.f411a, Constants.REFERRER, null);
    }

    protected Integer e() {
        return JsonUtils.getInteger(this.f411a, "session_url_relation", null);
    }

    protected Integer f() {
        return JsonUtils.getInteger(this.f411a, "share_state", null);
    }

    protected Boolean g() {
        return JsonUtils.getBoolean(this.f411a, "should_show_title", null);
    }

    protected Integer h() {
        return JsonUtils.getInteger(this.f411a, "toolbar_color", null);
    }

    protected Boolean i() {
        return JsonUtils.getBoolean(this.f411a, "url_bar_hiding_enabled", null);
    }
}
