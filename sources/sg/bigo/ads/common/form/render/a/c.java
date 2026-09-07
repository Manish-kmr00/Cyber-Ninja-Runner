package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.view.PrivacyCheckBox;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements a.InterfaceC0864a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13165a;
    public Map<String, Object> b;
    public e c;
    public e.c[] d;
    public View e;
    public PrivacyCheckBox f;
    public sg.bigo.ads.common.form.render.c.a h;
    private Map<String, String> i = new ConcurrentHashMap();
    public List<a> g = new ArrayList();

    public c(e eVar, Map<String, Object> map, Context context, sg.bigo.ads.common.form.render.c.a aVar) {
        this.f13165a = context;
        this.c = eVar;
        this.b = map;
        this.d = eVar.m();
        this.h = aVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.i.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    @Override // sg.bigo.ads.common.form.render.a.a.InterfaceC0864a
    public final void a(String str, String str2) {
        this.i.put(str, str2);
        sg.bigo.ads.common.form.render.c.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final boolean b() {
        PrivacyCheckBox privacyCheckBox = this.f;
        return privacyCheckBox != null && privacyCheckBox.f13319a;
    }
}
