package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class dv {
    private NetworkSettings b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f3634a = new ArrayList<>();
    private JSONObject c = null;
    private boolean d = true;

    dv() {
    }

    public static dv a() {
        return new dv();
    }

    public void a(NetworkSettings networkSettings) {
        this.b = networkSettings;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3634a.add(str);
    }

    public void a(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public JSONObject b() {
        return this.c;
    }

    public NetworkSettings c() {
        return this.b;
    }

    public ArrayList<String> d() {
        return this.f3634a;
    }

    public boolean e() {
        return this.d;
    }
}
