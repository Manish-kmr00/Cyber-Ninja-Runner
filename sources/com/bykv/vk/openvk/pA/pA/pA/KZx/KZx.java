package com.bykv.vk.openvk.pA.pA.pA.KZx;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class KZx implements Serializable {
    private String BSW;
    private long DX;
    private Og JG;
    private Og ML;
    public int Og;
    private String SD;
    private String Sn;
    private int WV;
    private int Wx;
    private int XT;
    public int ZZv;
    private boolean aBv;
    private boolean oX;
    public String pA;
    private int yFO;
    private int omh = 204800;
    private int Bzk = 0;
    private int SGo = 0;
    public final HashMap<String, Object> KZx = new HashMap<>();
    private int vZF = 10000;
    private int Sd = 10000;
    private int TX = 10000;
    private int BF = 0;
    private JSONObject WQf = new JSONObject();

    public KZx(String str, Og og, Og og2, int i, int i2) {
        this.XT = 0;
        this.yFO = 0;
        this.SD = str;
        this.ML = og;
        this.JG = og2;
        this.XT = i;
        this.yFO = i2;
    }

    public int pA() {
        return this.WQf.optInt("pitaya_cache_size", 0);
    }

    public String Og() {
        return this.SD;
    }

    public void pA(String str) {
        this.SD = str;
    }

    public int KZx() {
        if (BSW()) {
            return this.JG.DX();
        }
        Og og = this.ML;
        if (og != null) {
            return og.DX();
        }
        return 0;
    }

    public boolean ZZv() {
        return this.aBv;
    }

    public void Og(String str) {
        this.BSW = str;
    }

    public int ML() {
        return this.WV;
    }

    public void pA(int i) {
        this.WV = i;
    }

    public int JG() {
        return this.Wx;
    }

    public void Og(int i) {
        this.Wx = i;
    }

    public void KZx(String str) {
        this.Sn = str;
    }

    public long SD() {
        return this.DX;
    }

    public void pA(long j) {
        this.DX = j;
    }

    public boolean omh() {
        return this.oX;
    }

    public void pA(boolean z) {
        this.oX = z;
    }

    public long Bzk() {
        if (BSW()) {
            return this.JG.ML();
        }
        Og og = this.ML;
        if (og != null) {
            return og.ML();
        }
        return 0L;
    }

    public boolean SGo() {
        if (BSW()) {
            return this.JG.Sd();
        }
        Og og = this.ML;
        if (og != null) {
            return og.Sd();
        }
        return true;
    }

    public void ZZv(String str) {
        this.pA = str;
    }

    public void KZx(int i) {
        this.Og = i;
    }

    public boolean BSW() {
        Og og;
        if (this.yFO == 1 && (og = this.JG) != null && !TextUtils.isEmpty(og.BSW())) {
            if (com.bykv.vk.openvk.pA.pA.pA.KZx.JG() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.XT == 1) {
                return true;
            }
        }
        return false;
    }

    public float WV() {
        if (BSW()) {
            return this.JG.omh();
        }
        Og og = this.ML;
        if (og != null) {
            return og.omh();
        }
        return -1.0f;
    }

    public String Wx() {
        if (BSW()) {
            return this.JG.BSW();
        }
        Og og = this.ML;
        if (og != null) {
            return og.BSW();
        }
        return null;
    }

    public String Sn() {
        if (BSW()) {
            return this.JG.Sn();
        }
        Og og = this.ML;
        if (og != null) {
            return og.Sn();
        }
        return null;
    }

    public int DX() {
        return this.XT;
    }

    public synchronized void pA(String str, Object obj) {
        this.KZx.put(str, obj);
    }

    public synchronized Object ML(String str) {
        return this.KZx.get(str);
    }

    public int oX() {
        return this.vZF;
    }

    public void ZZv(int i) {
        this.vZF = i;
    }

    public int aBv() {
        return this.Sd;
    }

    public void ML(int i) {
        this.Sd = i;
    }

    public int XT() {
        return this.TX;
    }

    public void JG(int i) {
        this.TX = i;
    }

    public int yFO() {
        return this.BF;
    }

    public void SD(int i) {
        this.BF = i;
    }

    public Og vZF() {
        return this.ML;
    }

    public Og Sd() {
        return this.JG;
    }
}
