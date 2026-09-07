package com.json;

import com.json.sdk.utils.IronSourceStorageUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class pm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4162a;

    public pm(String str) {
        this.f4162a = str;
    }

    private nh a() throws Exception {
        nh nhVar = new nh(this.f4162a, "metadata.json");
        if (!nhVar.exists()) {
            a(nhVar);
        }
        return nhVar;
    }

    private void a(nh nhVar) throws Exception {
        IronSourceStorageUtils.saveFile(IronSourceNetworkBridge.jsonObjectInit().toString().getBytes(), nhVar.getPath());
    }

    private boolean a(JSONObject jSONObject) throws Exception {
        return IronSourceStorageUtils.saveFile(jSONObject.toString().getBytes(), a().getPath()) != 0;
    }

    synchronized boolean a(String str) throws Exception {
        JSONObject jSONObjectB = b();
        if (!jSONObjectB.has(str)) {
            return true;
        }
        jSONObjectB.remove(str);
        return a(jSONObjectB);
    }

    synchronized boolean a(String str, JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectB;
        jSONObjectB = b();
        jSONObjectB.put(str, jSONObject);
        return a(jSONObjectB);
    }

    boolean a(ArrayList<nh> arrayList) throws Exception {
        Iterator<nh> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!a(it.next().getName())) {
                z = false;
            }
        }
        return z;
    }

    synchronized JSONObject b() throws Exception {
        return IronSourceNetworkBridge.jsonObjectInit(IronSourceStorageUtils.readFile(a()));
    }

    synchronized boolean b(String str, JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectB;
        jSONObjectB = b();
        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectOptJSONObject.putOpt(next, jSONObject.opt(next));
            }
        } else {
            jSONObjectB.putOpt(str, jSONObject);
        }
        return a(jSONObjectB);
    }
}
