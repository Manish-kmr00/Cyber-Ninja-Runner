package com.bytedance.sdk.component.SD.KZx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes8.dex */
public class JG {
    private pA KZx;
    private Og ML;
    private Context SD;
    private boolean ZZv;
    private ML omh;
    private int yFO;
    private long Og = 0;
    private boolean JG = false;
    private int Bzk = 0;
    private long SGo = 19700101000L;
    private int BSW = 0;
    private HashMap<String, Integer> WV = new HashMap<>();
    private HashMap<String, Integer> Wx = new HashMap<>();
    private int Sn = 0;
    private HashMap<String, Integer> DX = new HashMap<>();
    private HashMap<String, Integer> oX = new HashMap<>();
    private boolean aBv = true;
    private Map<String, Integer> XT = new HashMap();
    Handler pA = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.SD.KZx.JG.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            JG.this.Og(message.arg1 != 0);
        }
    };

    private boolean pA(int i) {
        return i >= 200 && i < 400;
    }

    private JG() {
    }

    public JG(int i) {
        this.yFO = i;
    }

    public String pA() {
        return "ttnet_tnc_config" + this.yFO;
    }

    public pA Og() {
        return this.KZx;
    }

    public void pA(boolean z) {
        this.ZZv = z;
    }

    public void pA(Og og) {
        this.ML = og;
    }

    public boolean KZx() {
        return this.ZZv;
    }

    public Og ZZv() {
        return this.ML;
    }

    public void ML() {
        this.XT.clear();
    }

    public synchronized void pA(Context context, boolean z) {
        if (!this.JG) {
            this.SD = context;
            this.aBv = z;
            this.omh = new ML(context, z, this.yFO);
            if (z) {
                Bzk();
            }
            this.KZx = omh.pA().pA(this.yFO, this.SD);
            this.JG = true;
        }
    }

    private void Bzk() {
        SharedPreferences sharedPreferences = this.SD.getSharedPreferences(pA(), 0);
        this.Bzk = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.SGo = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    public ZZv JG() {
        ML ml = this.omh;
        if (ml != null) {
            return ml.KZx();
        }
        return null;
    }

    public Map<String, String> SD() {
        ZZv zZvJG = JG();
        if (zZvJG != null) {
            return zZvJG.ZZv;
        }
        return null;
    }

    public ML omh() {
        return this.omh;
    }

    public String pA(String str) {
        String protocol;
        Map<String, String> mapSD;
        if (TextUtils.isEmpty(str) || str.contains("/network/get_network") || str.contains("/get_domains/v4") || str.contains("/ies/speed")) {
            return str;
        }
        String host = null;
        try {
            URL url = new URL(str);
            protocol = url.getProtocol();
            try {
                host = url.getHost();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            protocol = null;
        }
        if (TextUtils.isEmpty(protocol)) {
            return str;
        }
        if ((!"http".equals(protocol) && !"https".equals(protocol)) || TextUtils.isEmpty(host) || ZZv(host) || (mapSD = SD()) == null || !mapSD.containsKey(host)) {
            return str;
        }
        String str2 = mapSD.get(host);
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = protocol + "://" + host;
        return str.startsWith(str3) ? str.replaceFirst(str3, protocol + "://" + str2) : str;
    }

    public synchronized void pA(Wx wx, DX dx) {
        URL urlPA;
        if (wx == null || dx == null) {
            return;
        }
        if (this.aBv) {
            if (com.bytedance.sdk.component.SD.ZZv.ML.pA(this.SD)) {
                try {
                    urlPA = wx.Og().pA();
                } catch (Exception unused) {
                    urlPA = null;
                }
                if (urlPA == null) {
                    return;
                }
                String protocol = urlPA.getProtocol();
                String host = urlPA.getHost();
                String path = urlPA.getPath();
                String strPA = pA(wx);
                int iKZx = dx.KZx();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strPA)) {
                        return;
                    }
                    ZZv zZvJG = JG();
                    if (zZvJG != null && zZvJG.Og) {
                        pA(dx, host);
                    }
                    if (zZvJG == null) {
                        return;
                    }
                    this.WV.size();
                    this.Wx.size();
                    this.DX.size();
                    this.oX.size();
                    if (iKZx > 0) {
                        if (pA(iKZx)) {
                            if (this.BSW > 0 || this.Sn > 0) {
                                SGo();
                            }
                            KZx(host);
                            return;
                        }
                        if (!Og(iKZx)) {
                            this.Sn++;
                            this.DX.put(path, 0);
                            this.oX.put(strPA, 0);
                            if (this.Sn >= zZvJG.omh && this.DX.size() >= zZvJG.Bzk && this.oX.size() >= zZvJG.SGo) {
                                pA(false, 0L);
                                SGo();
                            }
                            Og(host);
                        }
                    }
                }
            }
        }
    }

    private String pA(Wx wx) {
        if (wx == null || wx.Og() == null || wx.Og().pA() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(wx.Og().pA().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void Og(String str) {
        Map<String, String> mapSD;
        if (TextUtils.isEmpty(str) || (mapSD = SD()) == null || !mapSD.containsValue(str)) {
            return;
        }
        if (this.XT.get(str) == null) {
            this.XT.put(str, 1);
        } else {
            this.XT.put(str, Integer.valueOf(this.XT.get(str).intValue() + 1));
        }
    }

    private void KZx(String str) {
        if (!TextUtils.isEmpty(str) && this.XT.containsKey(str)) {
            this.XT.put(str, 0);
        }
    }

    private boolean ZZv(String str) {
        Map<String, String> mapSD = SD();
        if (mapSD == null) {
            return false;
        }
        String str2 = mapSD.get(str);
        return (TextUtils.isEmpty(str2) || this.XT.get(str2) == null || this.XT.get(str2).intValue() < 3) ? false : true;
    }

    public synchronized void pA(Wx wx, Exception exc) {
        URL urlPA;
        if (wx != null) {
            if (wx.Og() != null && exc != null) {
                if (this.aBv) {
                    if (com.bytedance.sdk.component.SD.ZZv.ML.pA(this.SD)) {
                        try {
                            urlPA = wx.Og().pA();
                        } catch (Exception unused) {
                            urlPA = null;
                        }
                        if (urlPA == null) {
                            return;
                        }
                        String protocol = urlPA.getProtocol();
                        String host = urlPA.getHost();
                        String path = urlPA.getPath();
                        String strPA = pA(wx);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            ZZv zZvJG = JG();
                            if (zZvJG == null) {
                                return;
                            }
                            this.WV.size();
                            this.Wx.size();
                            this.DX.size();
                            this.oX.size();
                            this.BSW++;
                            this.WV.put(path, 0);
                            this.Wx.put(strPA, 0);
                            if (this.BSW >= zZvJG.ML && this.WV.size() >= zZvJG.JG && this.Wx.size() >= zZvJG.SD) {
                                pA(false, 0L);
                                SGo();
                            }
                            Og(host);
                        }
                    }
                }
            }
        }
    }

    private void pA(DX dx, String str) {
        String[] strArrSplit;
        int i;
        long j;
        ZZv zZvJG;
        if (dx != null && this.aBv) {
            String strPA = dx.pA("tnc-cmd", null);
            if (TextUtils.isEmpty(strPA) || (strArrSplit = strPA.split("@")) == null || strArrSplit.length != 2) {
                return;
            }
            try {
                i = Integer.parseInt(strArrSplit[0]);
                try {
                    j = Long.parseLong(strArrSplit[1]);
                } catch (Throwable unused) {
                    j = 0;
                }
            } catch (Throwable unused2) {
                i = 0;
            }
            if (j <= this.SGo) {
                return;
            }
            this.Bzk = i;
            this.SGo = j;
            this.SD.getSharedPreferences(pA(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
            if (this.Bzk != 10000 || (zZvJG = JG()) == null) {
                return;
            }
            pA(true, zZvJG.WV > 0 ? ((long) new Random(System.currentTimeMillis()).nextInt(zZvJG.WV)) * 1000 : 0L);
        }
    }

    private void pA(boolean z, long j) {
        if (this.pA.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.pA.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.pA.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.pA.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z) {
        ZZv zZvJG = JG();
        if (zZvJG == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z || this.Og + (((long) zZvJG.BSW) * 1000) <= jElapsedRealtime) {
            this.Og = jElapsedRealtime;
            omh.pA().pA(this.yFO, this.SD).KZx();
        }
    }

    private void SGo() {
        this.BSW = 0;
        this.WV.clear();
        this.Wx.clear();
        this.Sn = 0;
        this.DX.clear();
        this.oX.clear();
    }

    private boolean Og(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        ZZv zZvJG = JG();
        return (zZvJG == null || TextUtils.isEmpty(zZvJG.Wx) || !zZvJG.Wx.contains(String.valueOf(i))) ? false : true;
    }
}
