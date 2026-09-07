package com.bytedance.sdk.openadsdk.p002Sd;

import android.text.TextUtils;
import android.util.Log;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ML {
    private JG KZx;
    private ZZv Og;
    private KZx ZZv;
    private final String pA = "StrategyCenter";
    private int ML = 0;
    private Runnable JG = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sd.ML.2
        @Override // java.lang.Runnable
        public void run() {
            ML.this.Og();
        }
    };

    public ML(JG jg) {
        this.Og = null;
        SD sd = new SD(jg);
        this.KZx = sd;
        String strKZx = sd.KZx();
        if (!TextUtils.isEmpty(strKZx) && !strKZx.startsWith("pag")) {
            strKZx = "pag_".concat(String.valueOf(strKZx));
        }
        this.Og = new ZZv(this.KZx.Og(), strKZx);
    }

    public void pA(KZx kZx) {
        this.ZZv = kZx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        JG jg = this.KZx;
        if (jg == null || jg.ML() == null || this.KZx.JG() == null) {
            return;
        }
        this.KZx.pA().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sd.ML.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStreamUrlConnectionGetOutputStream;
                ML.this.ML++;
                try {
                    if (ML.this.ZZv != null) {
                        ML.this.ZZv.pA();
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(ML.this.KZx.ML()).openConnection();
                    if (ML.this.KZx.SD() != null && ML.this.KZx.SD().size() > 0) {
                        for (Map.Entry<String, String> entry : ML.this.KZx.SD().entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    try {
                        outputStreamUrlConnectionGetOutputStream = PangleNetworkBridge.urlConnectionGetOutputStream(httpURLConnection);
                        try {
                            outputStreamUrlConnectionGetOutputStream.write(ML.this.KZx.JG().toString().getBytes());
                            if (outputStreamUrlConnectionGetOutputStream != null) {
                                outputStreamUrlConnectionGetOutputStream.close();
                            }
                            int iHttpUrlConnectionGetResponseCode = PangleNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                            Log.i("StrategyCenter", "executing strategy fetch");
                            if (iHttpUrlConnectionGetResponseCode != 200) {
                                if (ML.this.ZZv != null) {
                                    ML.this.ZZv.pA(iHttpUrlConnectionGetResponseCode, httpURLConnection.getResponseMessage());
                                }
                            } else {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(PangleNetworkBridge.urlConnectionGetInputStream(httpURLConnection)));
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    } else {
                                        stringBuffer.append(line);
                                    }
                                }
                                bufferedReader.close();
                                JSONObject jSONObjectPA = ML.this.KZx.pA(PangleNetworkBridge.jsonObjectInit(stringBuffer.toString()));
                                ML.this.Og.pA();
                                ML.this.Og.pA(jSONObjectPA);
                                if (ML.this.ZZv != null) {
                                    ML.this.ZZv.Og();
                                }
                            }
                            ML.this.Og.pA("local_last_update_time", System.currentTimeMillis());
                            ML.this.pA();
                        } catch (Throwable th) {
                            th = th;
                            if (outputStreamUrlConnectionGetOutputStream != null) {
                                outputStreamUrlConnectionGetOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStreamUrlConnectionGetOutputStream = null;
                    }
                } catch (Throwable th3) {
                    Log.e("StrategyCenter", th3.getMessage() == null ? "error " : th3.getMessage());
                    if (ML.this.ZZv != null) {
                        ML.this.ZZv.pA(-1, th3.getMessage());
                    }
                }
            }
        });
    }

    public void pA() {
        if (this.KZx != null) {
            int i = 3600000;
            int iPA = this.Og.pA("req_interval", 3600000);
            long j = 0;
            long jOg = this.Og.Og("local_last_update_time", 0L);
            if (iPA >= 600000 && iPA <= 86400000) {
                i = iPA;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jOg;
            Log.i("StrategyCenter", "before  realInterval=".concat(String.valueOf(jCurrentTimeMillis)));
            if (jCurrentTimeMillis >= 0) {
                long j2 = i;
                if (jCurrentTimeMillis <= j2) {
                    j = j2 - jCurrentTimeMillis;
                }
            }
            Log.i("StrategyCenter", "after  realInterval=".concat(String.valueOf(j)));
            this.KZx.ZZv().removeCallbacks(this.JG);
            if (this.ML > 24) {
                return;
            }
            this.KZx.ZZv().postDelayed(this.JG, j);
        }
    }

    public int pA(String str, int i) {
        ZZv zZv = this.Og;
        return zZv == null ? i : zZv.pA(str, i);
    }

    public String pA(String str, String str2) {
        ZZv zZv = this.Og;
        return zZv == null ? str2 : zZv.pA(str, str2);
    }

    public boolean pA(String str, boolean z) {
        ZZv zZv = this.Og;
        return zZv == null ? z : zZv.pA(str, z);
    }
}
