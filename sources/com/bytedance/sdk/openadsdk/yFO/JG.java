package com.bytedance.sdk.openadsdk.yFO;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.json.b9;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JG {
    private WeakReference<omh> Og;
    private Context pA;
    private Map<String, pA> KZx = new HashMap();
    private SensorEventListener ZZv = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            omh omhVarKZx;
            if (sensorEvent.sensor.getType() != 1 || (omhVarKZx = JG.this.KZx()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, f);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, f2);
                jSONObject.put("z", f3);
                omhVarKZx.pA("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ML = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            omh omhVarKZx;
            if (sensorEvent.sensor.getType() != 4 || (omhVarKZx = JG.this.KZx()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, degrees);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, degrees2);
                jSONObject.put("z", degrees3);
                omhVarKZx.pA("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener JG = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            omh omhVarKZx;
            if (sensorEvent.sensor.getType() != 10 || (omhVarKZx = JG.this.KZx()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, f);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, f2);
                jSONObject.put("z", f3);
                omhVarKZx.pA("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener SD = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, SGo.Og, 0, SGo.Og.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, SGo.KZx, 0, SGo.KZx.length);
            }
            SensorManager.getRotationMatrix(SGo.ZZv, null, SGo.Og, SGo.KZx);
            SensorManager.getOrientation(SGo.ZZv, SGo.ML);
            omh omhVarKZx = JG.this.KZx();
            if (omhVarKZx == null) {
                return;
            }
            float f = SGo.ML[0];
            float f2 = SGo.ML[1];
            float f3 = SGo.ML[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                omhVarKZx.pA("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    interface pA {
        JSONObject pA(JSONObject jSONObject) throws Throwable;
    }

    public JG(omh omhVar) {
        this.pA = omhVar.pA();
        this.Og = new WeakReference<>(omhVar);
        Og();
    }

    public Set<String> pA() {
        return this.KZx.keySet();
    }

    private void Og() {
        this.KZx.put("adInfo", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.45
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                if (omhVarKZx != null) {
                    JSONObject jSONObjectYFO = omhVarKZx.yFO();
                    if (jSONObjectYFO != null) {
                        jSONObjectYFO.put("code", 1);
                        return jSONObjectYFO;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.KZx.put("appInfo", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.56
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = JG.this.pA().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                omh omhVarKZx = JG.this.KZx();
                if (omhVarKZx != null) {
                    jSONObject2.put("deviceId", omhVarKZx.SD());
                    jSONObject2.put("netType", omhVarKZx.oX());
                    jSONObject2.put("innerAppName", omhVarKZx.ZZv());
                    jSONObject2.put("appName", omhVarKZx.ML());
                    jSONObject2.put("appVersion", omhVarKZx.JG());
                    Map<String, String> mapOg = omhVarKZx.Og();
                    for (String str : mapOg.keySet()) {
                        jSONObject2.put(str, mapOg.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.KZx.put("playableSDKInfo", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.61
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.KZx.put("subscribe_app_ad", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.62
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("download_app_ad", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.63
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put(b9.h.o, new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.2
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                if (omhVarKZx == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", omhVarKZx.Bzk());
                return jSONObject3;
            }
        });
        this.KZx.put("getVolume", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.3
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                if (omhVarKZx == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", omhVarKZx.omh());
                return jSONObject3;
            }
        });
        this.KZx.put("getScreenSize", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.4
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                if (omhVarKZx == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectXT = omhVarKZx.XT();
                jSONObjectXT.put("code", 1);
                return jSONObjectXT;
            }
        });
        this.KZx.put("start_accelerometer_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.5
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        SD.pA("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                SGo.pA(JG.this.pA, JG.this.ZZv, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("close_accelerometer_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.6
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, JG.this.ZZv);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("start_gyro_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.7
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        SD.pA("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                SGo.Og(JG.this.pA, JG.this.ML, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("close_gyro_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.8
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, JG.this.ML);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("start_accelerometer_grativityless_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.9
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        SD.pA("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                SGo.KZx(JG.this.pA, JG.this.JG, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("close_accelerometer_grativityless_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.10
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, JG.this.JG);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("start_rotation_vector_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.11
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        SD.pA("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                SGo.ZZv(JG.this.pA, JG.this.SD, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("close_rotation_vector_observer", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.13
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, JG.this.SD);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("device_shake", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.14
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("device_shake_short", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.15
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SGo.pA(JG.this.pA, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    SD.pA("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.KZx.put("playable_style", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.16
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx != null) {
                    JSONObject jSONObjectKZx = omhVarKZx.KZx();
                    jSONObjectKZx.put("code", 1);
                    return jSONObjectKZx;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.KZx.put("sendReward", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.17
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx != null) {
                    omhVarKZx.Sd();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.KZx.put("webview_time_track", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.18
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.KZx.put("playable_event", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.19
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.Og(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("reportAd", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.20
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("close", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.21
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("openAdLandPageLinks", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.22
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("get_viewport", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.24
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectVZF = omhVarKZx.vZF();
                jSONObjectVZF.put("code", 1);
                return jSONObjectVZF;
            }
        });
        this.KZx.put("jssdk_load_finish", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.25
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.IG();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_material_render_result", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.26
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.Bzk(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("detect_change_playable_click", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.27
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSGo = omhVarKZx.SGo();
                jSONObjectSGo.put("code", 1);
                return jSONObjectSGo;
            }
        });
        this.KZx.put("check_camera_permission", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.28
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectWx = omhVarKZx.Wx();
                jSONObjectWx.put("code", 1);
                return jSONObjectWx;
            }
        });
        this.KZx.put("check_external_storage", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.29
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSn = omhVarKZx.Sn();
                if (jSONObjectSn.isNull("result")) {
                    jSONObjectSn.put("code", -1);
                } else {
                    jSONObjectSn.put("code", 1);
                }
                return jSONObjectSn;
            }
        });
        this.KZx.put("playable_open_camera", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.30
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_pick_photo", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.31
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_download_media_in_photos", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.32
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.pA(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_preventTouchEvent", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.33
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.Og(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_settings_info", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.35
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectDX = omhVarKZx.DX();
                jSONObjectDX.put("code", 1);
                return jSONObjectDX;
            }
        });
        this.KZx.put("playable_load_main_scene", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.36
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.TX();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_enter_section", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.37
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.ZZv(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_end", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.38
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.BF();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_finish_play_playable", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.39
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.WQf();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_transfrom_module_show", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.40
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.TV();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_transfrom_module_change_color", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.41
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.du();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_set_scroll_rect", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.42
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_click_area", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.43
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.ML(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_real_play_start", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.44
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_material_first_frame_show", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.46
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.eG();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_stuck_check_pong", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.47
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.roi();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_material_adnormal_mask", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.48
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                omhVarKZx.JG(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_long_press_panel", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.49
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_alpha_player_play", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.50
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_transfrom_module_highlight", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.51
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_send_click_event", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.52
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_query_media_permission_declare", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.53
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSD = omhVarKZx.SD(jSONObject);
                jSONObjectSD.put("code", 1);
                return jSONObjectSD;
            }
        });
        this.KZx.put("playable_query_media_permission_enable", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.54
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                omh omhVarKZx = JG.this.KZx();
                JSONObject jSONObject2 = new JSONObject();
                if (omhVarKZx == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectOmh = omhVarKZx.omh(jSONObject);
                jSONObjectOmh.put("code", 1);
                return jSONObjectOmh;
            }
        });
        this.KZx.put("playable_apply_media_permission", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.55
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_start_kws", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.57
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_close_kws", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.58
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_video_preload_task_add", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.59
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.KZx.put("playable_video_preload_task_cancel", new pA() { // from class: com.bytedance.sdk.openadsdk.yFO.JG.60
            @Override // com.bytedance.sdk.openadsdk.yFO.JG.pA
            public JSONObject pA(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.yFO.pA pAVarZZv = JG.this.ZZv();
                JSONObject jSONObject2 = new JSONObject();
                if (pAVarZZv == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public omh KZx() {
        WeakReference<omh> weakReference = this.Og;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.yFO.pA ZZv() {
        omh omhVarKZx = KZx();
        if (omhVarKZx == null) {
            return null;
        }
        return omhVarKZx.aBv();
    }

    public JSONObject pA(String str, JSONObject jSONObject) {
        try {
            pA pAVar = this.KZx.get(str);
            if (pAVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return pAVar.pA(jSONObject);
        } catch (Throwable th) {
            SD.pA("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void Fba() {
        SGo.pA(this.pA, this.ZZv);
        SGo.pA(this.pA, this.ML);
        SGo.pA(this.pA, this.JG);
        SGo.pA(this.pA, this.SD);
    }
}
