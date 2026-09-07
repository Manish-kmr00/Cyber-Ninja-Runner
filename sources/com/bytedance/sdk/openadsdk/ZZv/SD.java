package com.bytedance.sdk.openadsdk.ZZv;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class SD {
    private long KZx;
    private long ML;
    private long Og;
    private long ZZv;
    private long pA;

    public void pA(long j) {
        if (this.pA <= 0) {
            this.pA = j;
        }
    }

    public void Og(long j) {
        if (this.Og <= 0) {
            this.Og = j;
        }
    }

    public void KZx(long j) {
        if (this.KZx <= 0) {
            this.KZx = j;
        }
    }

    public void ZZv(long j) {
        if (this.ZZv <= 0) {
            this.ZZv = j;
        }
    }

    public void ML(long j) {
        if (this.ML <= 0) {
            this.ML = j;
        }
    }

    public boolean pA() {
        return this.pA > 0;
    }

    public void pA(long j, float f) {
        if (f > 0.0f) {
            pA(j);
        }
        double d = f;
        if (d >= 0.25d) {
            pA(j);
            Og(j);
        }
        if (d >= 0.5d) {
            pA(j);
            Og(j);
            KZx(j);
        }
        if (d >= 0.75d) {
            pA(j);
            Og(j);
            KZx(j);
            ZZv(j);
        }
        if (f >= 1.0f) {
            pA(j);
            Og(j);
            KZx(j);
            ZZv(j);
            ML(j);
        }
    }

    public JSONObject Og() {
        return pA((JSONObject) null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:12:0x0031 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x003c A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:6:0x0010 A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001b A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x001b, B:10:0x0026, B:12:0x0031, B:14:0x003c), top: B:17:0x0002 }] */
    public JSONObject pA(JSONObject jSONObject) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                j = this.pA;
                if (j > 0) {
                    jSONObject.put("show_start", j);
                    j2 = this.Og;
                    if (j2 > 0) {
                        jSONObject.put("show_firstQuartile", j2);
                        j3 = this.KZx;
                        if (j3 > 0) {
                            jSONObject.put("show_mid", j3);
                            j4 = this.ZZv;
                            if (j4 > 0) {
                                jSONObject.put("show_thirdQuartile", j4);
                                j5 = this.ML;
                                if (j5 > 0) {
                                    jSONObject.put("show_full", j5);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            j = this.pA;
            if (j > 0) {
                jSONObject.put("show_start", j);
                j2 = this.Og;
                if (j2 > 0) {
                    jSONObject.put("show_firstQuartile", j2);
                    j3 = this.KZx;
                    if (j3 > 0) {
                        jSONObject.put("show_mid", j3);
                        j4 = this.ZZv;
                        if (j4 > 0) {
                            jSONObject.put("show_thirdQuartile", j4);
                            j5 = this.ML;
                            if (j5 > 0) {
                                jSONObject.put("show_full", j5);
                            }
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
