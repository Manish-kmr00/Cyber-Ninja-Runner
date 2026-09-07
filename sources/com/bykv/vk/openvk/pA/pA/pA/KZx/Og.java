package com.bykv.vk.openvk.pA.pA.pA.KZx;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.ktor.http.ContentDisposition;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Og {
    private double BSW;
    private String Bzk;
    private String JG;
    private long KZx;
    private String ML;
    private int Og;
    private String SD;
    private String SGo;
    private int WV;
    private int Wx;
    private double ZZv;
    private String omh;
    private int pA;
    private float Sn = -1.0f;
    private int DX = 0;
    private int oX = 0;
    private int aBv = 0;
    private int XT = 0;
    private int yFO = 307200;
    private int vZF = 1;

    public int pA() {
        return this.WV;
    }

    public void pA(int i) {
        this.WV = i;
    }

    public int Og() {
        return this.pA;
    }

    public void Og(int i) {
        this.pA = i;
    }

    public int KZx() {
        return this.Og;
    }

    public void KZx(int i) {
        this.Og = i;
    }

    public int ZZv() {
        return this.Wx;
    }

    public void ZZv(int i) {
        this.Wx = i;
    }

    public long ML() {
        return this.KZx;
    }

    public void pA(long j) {
        this.KZx = j;
    }

    public double JG() {
        return this.ZZv;
    }

    public void pA(double d) {
        this.ZZv = d;
    }

    public double SD() {
        return this.BSW;
    }

    public float omh() {
        return this.Sn;
    }

    public String Bzk() {
        return this.ML;
    }

    public void pA(String str) {
        this.ML = str;
    }

    public String SGo() {
        return this.JG;
    }

    public void Og(String str) {
        this.JG = str;
    }

    public String BSW() {
        return this.SD;
    }

    public void KZx(String str) {
        this.SD = str;
    }

    public String WV() {
        return this.omh;
    }

    public void ZZv(String str) {
        this.omh = str;
    }

    public String Wx() {
        return this.Bzk;
    }

    public void ML(String str) {
        this.Bzk = str;
    }

    public String Sn() {
        if (TextUtils.isEmpty(this.SGo)) {
            this.SGo = com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(this.SD);
        }
        return this.SGo;
    }

    public void JG(String str) {
        this.SGo = str;
    }

    public int DX() {
        if (this.yFO < 0) {
            this.yFO = 307200;
        }
        long j = this.yFO;
        long j2 = this.KZx;
        if (j > j2) {
            this.yFO = (int) j2;
        }
        return this.yFO;
    }

    public void ML(int i) {
        this.yFO = i;
    }

    public int oX() {
        return this.aBv;
    }

    public void JG(int i) {
        this.aBv = i;
    }

    public int aBv() {
        return this.XT;
    }

    public void SD(int i) {
        this.XT = i;
    }

    public JSONObject XT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", Og());
            jSONObject.put("cover_url", SGo());
            jSONObject.put("cover_width", KZx());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, WV());
            jSONObject.put("file_hash", Sn());
            jSONObject.put("resolution", Bzk());
            jSONObject.put(ContentDisposition.Parameters.Size, ML());
            jSONObject.put("video_duration", JG());
            jSONObject.put("video_url", BSW());
            jSONObject.put("playable_download_url", Wx());
            jSONObject.put("if_playable_loading_show", yFO());
            jSONObject.put("remove_loading_page_type", vZF());
            jSONObject.put("fallback_endcard_judge", pA());
            jSONObject.put("video_preload_size", DX());
            jSONObject.put("reward_video_cached_type", oX());
            jSONObject.put("execute_cached_type", aBv());
            jSONObject.put("endcard_render", ZZv());
            jSONObject.put("replay_time", TX());
            jSONObject.put("play_speed_ratio", omh());
            if (SD() > 0.0d) {
                jSONObject.put("start", SD());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int yFO() {
        return this.DX;
    }

    public void omh(int i) {
        this.DX = i;
    }

    public int vZF() {
        return this.oX;
    }

    public void Bzk(int i) {
        this.oX = i;
    }

    public boolean Sd() {
        return this.aBv == 0;
    }

    public void SGo(int i) {
        this.vZF = Math.min(4, Math.max(1, i));
    }

    public int TX() {
        return this.vZF;
    }
}
