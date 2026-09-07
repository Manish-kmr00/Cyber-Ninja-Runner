package com.bytedance.sdk.component.Og.pA.pA.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Sn;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public class Og implements com.bytedance.sdk.component.Og.pA.Og {
    private AtomicBoolean KZx = new AtomicBoolean(false);
    com.bytedance.sdk.component.Og.pA.ZZv Og;
    Wx pA;

    Og(Wx wx, com.bytedance.sdk.component.Og.pA.ZZv zZv) {
        this.pA = wx;
        this.Og = zZv;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og
    public Wx pA() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og
    public DX Og() throws IOException {
        Wx wx = this.pA;
        if (wx != null && wx.Og != null) {
            if (this.pA.Og.Sn() == 0) {
                this.pA.Og.DX();
            }
            this.pA.Og.pA();
        }
        this.Og.KZx().remove(this);
        this.Og.ZZv().add(this);
        com.bytedance.sdk.component.Og.pA.ZZv zZv = this.Og;
        if ((zZv instanceof ML) && (zZv.KZx().size() + this.Og.ZZv().size() > this.Og.pA() || this.KZx.get())) {
            this.Og.ZZv().remove(this);
            return new SD(SD.pA, "Maximum number of requests exceeded", this.pA);
        }
        try {
            if (this.pA.pA != null && this.pA.pA.pA != null && this.pA.pA.pA.size() > 0) {
                ArrayList arrayList = new ArrayList(this.pA.pA.pA);
                arrayList.add(new com.bytedance.sdk.component.Og.pA.omh() { // from class: com.bytedance.sdk.component.Og.pA.pA.pA.Og.1
                    @Override // com.bytedance.sdk.component.Og.pA.omh
                    public DX pA(com.bytedance.sdk.component.Og.pA.omh.pA pAVar) throws IOException {
                        return Og.this.pA(pAVar.pA());
                    }
                });
                return ((com.bytedance.sdk.component.Og.pA.omh) arrayList.get(0)).pA(new KZx(arrayList, this.pA));
            }
            return pA(this.pA);
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    private boolean pA(Sn sn) {
        Wx wx;
        return sn != null && (wx = this.pA) != null && "POST".equalsIgnoreCase(wx.KZx()) && sn.JG == Sn.pA.BYTE_ARRAY_TYPE && sn.ML != null && sn.ML.length > 0;
    }

    private boolean Og(Sn sn) {
        Wx wx;
        return (sn == null || (wx = this.pA) == null || !"POST".equalsIgnoreCase(wx.KZx()) || sn.JG != Sn.pA.STRING_TYPE || TextUtils.isEmpty(sn.ZZv)) ? false : true;
    }

    public DX pA(Wx wx) throws IOException {
        HttpURLConnection httpURLConnection;
        Exception e;
        String message;
        int iHttpUrlConnectionGetResponseCode = SD.pA;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(wx.Og().pA().toString()).openConnection();
                try {
                    if (wx.ZZv() != null && wx.ZZv().size() > 0) {
                        for (Map.Entry<String, List<String>> entry : wx.ZZv().entrySet()) {
                            String key = entry.getKey();
                            for (String str : entry.getValue()) {
                                if ("_disable_retry".equals(key) && "1".equals(str)) {
                                    pA(httpURLConnection);
                                } else {
                                    httpURLConnection.addRequestProperty(key, str);
                                }
                            }
                        }
                    }
                    if (wx.pA != null) {
                        if (wx.pA.KZx != null) {
                            httpURLConnection.setConnectTimeout((int) wx.pA.KZx.toMillis(wx.pA.Og));
                        }
                        if (wx.pA.KZx != null) {
                            httpURLConnection.setReadTimeout((int) wx.pA.ML.toMillis(wx.pA.ZZv));
                        }
                    }
                    if (wx.omh() == null) {
                        httpURLConnection.setRequestMethod("GET");
                    } else {
                        if (!ML() && wx.omh().KZx != null) {
                            httpURLConnection.addRequestProperty("Content-Type", wx.omh().KZx.pA());
                        }
                        httpURLConnection.setRequestMethod(wx.KZx());
                        if ("POST".equalsIgnoreCase(wx.KZx())) {
                            OutputStream outputStreamUrlConnectionGetOutputStream = PangleNetworkBridge.urlConnectionGetOutputStream(httpURLConnection);
                            if (pA(wx.omh())) {
                                outputStreamUrlConnectionGetOutputStream.write(wx.omh().ML);
                            } else if (Og(wx.omh())) {
                                outputStreamUrlConnectionGetOutputStream.write(wx.omh().ZZv.getBytes());
                            }
                            outputStreamUrlConnectionGetOutputStream.flush();
                            outputStreamUrlConnectionGetOutputStream.close();
                        }
                    }
                    if (wx != null && wx.Og != null) {
                        wx.Og.Og();
                    }
                    httpURLConnection.connect();
                    if (wx != null && wx.Og != null) {
                        wx.Og.KZx();
                    }
                    iHttpUrlConnectionGetResponseCode = PangleNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    if (wx != null && wx.Og != null) {
                        wx.Og.ML();
                    }
                    if (!this.KZx.get()) {
                        SD sd = new SD(httpURLConnection, wx);
                        this.Og.ZZv().remove(this);
                        return sd;
                    }
                    PangleNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    this.Og.ZZv().remove(this);
                    message = "internal error";
                    return new SD(iHttpUrlConnectionGetResponseCode, message, wx);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        message = httpURLConnection.getErrorStream().toString();
                    } catch (Throwable unused) {
                        message = e.getMessage();
                    }
                    this.Og.ZZv().remove(this);
                }
            } catch (Throwable th) {
                this.Og.ZZv().remove(this);
                throw th;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
        }
    }

    private static void pA(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            obj2.getClass().getDeclaredMethod("setRetryOnConnectionFailure", Boolean.TYPE).invoke(obj2, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    private boolean ML() {
        if (this.pA.ZZv() == null) {
            return false;
        }
        return this.pA.ZZv().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og
    public void pA(final com.bytedance.sdk.component.Og.pA.KZx kZx) {
        Wx wx = this.pA;
        if (wx != null && wx.Og != null) {
            this.pA.Og.DX();
        }
        this.Og.Og().submit(new com.bytedance.sdk.component.omh.KZx.Og(this.pA.SD(), this.pA.JG()) { // from class: com.bytedance.sdk.component.Og.pA.pA.pA.Og.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DX dxOg = Og.this.Og();
                    if (dxOg == null) {
                        kZx.pA(Og.this, new IOException("response is null"));
                    } else {
                        kZx.pA(Og.this, dxOg);
                    }
                } catch (IOException e) {
                    kZx.pA(Og.this, e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og
    public void KZx() {
        this.KZx.set(true);
    }

    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.Og.pA.Og clone() {
        return new Og(this.pA, this.Og);
    }
}
