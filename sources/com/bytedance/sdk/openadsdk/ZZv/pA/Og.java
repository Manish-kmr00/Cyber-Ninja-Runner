package com.bytedance.sdk.openadsdk.ZZv.pA;

import com.json.b9;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    public int ZZv;
    public AtomicInteger pA = new AtomicInteger(0);
    public AtomicInteger Og = new AtomicInteger(0);
    public AtomicLong KZx = new AtomicLong(0);
    public AtomicInteger ML = new AtomicInteger(0);
    public Map<Integer, Integer> JG = new HashMap();
    public AtomicBoolean SD = new AtomicBoolean(false);

    public Og(int i) {
        this.ZZv = i;
    }

    JSONObject pA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.pA.get());
            jSONObject.put(b9.f.e, this.Og.get());
            jSONObject.put("type", this.ZZv);
            jSONObject.put("duration", this.KZx.get() / ((long) this.pA.get()));
            JSONObject jSONObject2 = new JSONObject();
            if (this.JG.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : this.JG.entrySet()) {
                    jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            jSONObject.put("fail_error_code", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    JSONObject Og() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.pA.get());
            jSONObject.put(b9.f.e, this.Og.get());
            jSONObject.put("type", this.ZZv);
            jSONObject.put("time", this.ML.get());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
