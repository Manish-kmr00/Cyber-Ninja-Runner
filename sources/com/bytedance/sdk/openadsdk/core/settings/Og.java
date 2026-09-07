package com.bytedance.sdk.openadsdk.core.settings;

import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public List<String> BF;
    public int BSW;
    public String Bf;
    public int Bzk;
    public int CIG;
    public int DX;
    public long FQ;
    public String Gx;
    public List<omh> HSv;
    public boolean IG;
    public List<omh> JBA;
    public int JG;
    public int KZx;
    public int ML;
    public boolean Mc;
    public int Og;
    public int SD;
    public int SGo;
    public boolean Sd;
    public int Sn;
    public int SzT;
    public int TV;
    public int TX;
    public int Vgu;
    public int WQf;
    public int WV;
    public int Wx;
    public int XT;
    public int ZZv;
    public int aBv;
    public JSONObject agB;
    public int du;
    public int eG;
    public int gbA;
    public boolean lT;
    public int oX;
    public int omh;
    public String pA;
    public boolean qmB;
    public int rB;
    public int roi;
    public int vZF;
    public int xy;
    public int yFO;

    private static boolean pA(int i) {
        return i == 1 || i == 2;
    }

    public Og(JSONObject jSONObject) {
        this.Og = 1;
        this.KZx = 1;
        this.ZZv = 2;
        this.ML = 1;
        this.JG = 100;
        this.SD = 0;
        this.omh = 2;
        this.Bzk = 1;
        this.SGo = 3;
        this.BSW = 30;
        this.WV = 30;
        this.Wx = 1;
        this.Sn = 1;
        this.DX = 2;
        this.oX = 1500;
        this.aBv = 2;
        this.XT = IronSourceConstants.BN_AUCTION_REQUEST;
        this.yFO = 0;
        this.vZF = 5;
        this.Sd = false;
        this.TX = 0;
        this.WQf = 2;
        this.TV = -1;
        this.du = 0;
        this.eG = 0;
        this.roi = 5;
        this.Mc = true;
        this.IG = false;
        this.lT = false;
        this.rB = 0;
        this.xy = -1;
        this.qmB = false;
        this.gbA = 60000;
        this.Vgu = 2;
        this.CIG = 1000;
        this.SzT = 1;
        this.HSv = new ArrayList();
        this.JBA = new ArrayList();
        new JSONObject();
        this.agB = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.pA = jSONObject.optString("code_id");
        this.Og = jSONObject.optInt("auto_play", 1);
        this.xy = jSONObject.optInt("endcard_close_time", -1);
        this.KZx = jSONObject.optInt("voice_control", 1);
        this.ZZv = jSONObject.optInt("rv_preload", 2);
        this.ML = jSONObject.optInt("nv_preload", 1);
        this.JG = Math.min(100, Math.max(0, jSONObject.optInt("proportion_watching", 100)));
        this.SD = jSONObject.optInt("skip_time_displayed", 0);
        this.omh = jSONObject.optInt("video_skip_result", 2);
        this.Bzk = jSONObject.optInt("reg_creative_control", 1);
        this.SGo = jSONObject.optInt("play_bar_show_time", 3);
        int iOptInt = jSONObject.optInt("rv_skip_time", 30);
        this.BSW = iOptInt;
        if (iOptInt < 0) {
            this.BSW = 30;
        }
        this.Wx = jSONObject.optInt("voice_control", 2);
        this.Sn = jSONObject.optInt("if_show_win", 1);
        this.DX = jSONObject.optInt("sp_preload", 2);
        this.oX = jSONObject.optInt("stop_time", 1500);
        this.aBv = jSONObject.optInt("native_playable_delay", 2);
        this.XT = jSONObject.optInt("time_out_control", -1);
        this.TV = jSONObject.optInt("playable_close_time", -1);
        this.yFO = jSONObject.optInt("playable_reward_type", 0);
        this.TX = jSONObject.optInt("reward_is_callback", 0);
        int iOptInt2 = jSONObject.optInt("iv_skip_time", 5);
        this.vZF = iOptInt2;
        if (iOptInt2 < 0) {
            this.vZF = 5;
        }
        pA(jSONObject.optJSONArray("parent_tpl_ids"));
        this.WQf = jSONObject.optInt("slot_type", 2);
        this.Sd = jSONObject.optBoolean("close_on_click", false);
        this.du = jSONObject.optInt("allow_system_back", 0);
        this.eG = jSONObject.optInt("splash_skip_time", 0);
        this.roi = jSONObject.optInt("splash_image_count_down_time", 5);
        this.IG = jSONObject.optBoolean("splash_count_down_time_off", false);
        this.lT = jSONObject.optBoolean("splash_close_on_click", false);
        int iOptInt3 = jSONObject.optInt("splash_load_strategy", 0);
        this.rB = iOptInt3;
        if (iOptInt3 < 0 || iOptInt3 > 1) {
            this.rB = 0;
        }
        this.Mc = jSONObject.optBoolean("allow_mediaview_click", true);
        int iOptInt4 = jSONObject.optInt("total_time_out", 60000);
        this.gbA = iOptInt4;
        if (iOptInt4 <= 0 || iOptInt4 > 1800000) {
            this.gbA = 60000;
        }
        int iOptInt5 = jSONObject.optInt("req_parallel_num", 2);
        this.Vgu = iOptInt5;
        if (iOptInt5 <= 0 || iOptInt5 > 4) {
            this.Vgu = 2;
        }
        this.CIG = jSONObject.optInt("bidding_token_tmax", 1000);
        int iOptInt6 = jSONObject.optInt("ad_load_type", 1);
        this.SzT = iOptInt6;
        if (iOptInt6 <= 0 || iOptInt6 > 2) {
            this.SzT = 1;
        }
        boolean zOptBoolean = jSONObject.optBoolean("is_mediation", false);
        this.qmB = zOptBoolean;
        if (zOptBoolean) {
            oX.vkV().lx();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mediation_config");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("adn_name");
                String strOptString2 = jSONObjectOptJSONObject.optString("adn_slot_id");
                int iOptInt7 = jSONObjectOptJSONObject.optInt("ad_expired_time", 3600000);
                int iOptInt8 = jSONObjectOptJSONObject.optInt("req_bidding_type", 2);
                String strOptString3 = jSONObjectOptJSONObject.optString("rit_cpm");
                int iOptInt9 = jSONObjectOptJSONObject.optInt("show_sort");
                int iOptInt10 = jSONObjectOptJSONObject.optInt("layer_time_out", 2000);
                int i2 = (iOptInt10 <= 0 || iOptInt10 > 60000) ? 2000 : iOptInt10;
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("server_params");
                if (iOptInt8 == 2) {
                    arrayList.add(new omh(strOptString, strOptString2, iOptInt7, iOptInt8, strOptString3, iOptInt9, i2, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                } else if (iOptInt8 == 0) {
                    arrayList2.add(new omh(strOptString, strOptString2, iOptInt7, iOptInt8, strOptString3, iOptInt9, i2, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                }
            }
            this.HSv = arrayList;
            this.JBA = arrayList2;
            Collections.sort(arrayList);
            Collections.sort(this.JBA);
        }
        if (!pA(this.KZx)) {
            this.KZx = 1;
        }
        if (!pA(this.Wx)) {
            this.Wx = 1;
        }
        this.FQ = jSONObject.optLong("waterfall_id");
        String strOptString4 = jSONObject.optString("waterfall_version");
        this.Gx = strOptString4;
        this.Bf = strOptString4;
        this.WV = jSONObject.optInt("multi_rv_skip_time", 30);
    }

    public Og(String str, int i) {
        this.Og = 1;
        this.KZx = 1;
        this.ZZv = 2;
        this.ML = 1;
        this.JG = 100;
        this.SD = 0;
        this.omh = 2;
        this.Bzk = 1;
        this.SGo = 3;
        this.BSW = 30;
        this.WV = 30;
        this.Wx = 1;
        this.Sn = 1;
        this.DX = 2;
        this.oX = 1500;
        this.aBv = 2;
        this.XT = IronSourceConstants.BN_AUCTION_REQUEST;
        this.yFO = 0;
        this.vZF = 5;
        this.Sd = false;
        this.TX = 0;
        this.WQf = 2;
        this.TV = -1;
        this.du = 0;
        this.eG = 0;
        this.roi = 5;
        this.Mc = true;
        this.IG = false;
        this.lT = false;
        this.rB = 0;
        this.xy = -1;
        this.qmB = false;
        this.gbA = 60000;
        this.Vgu = 2;
        this.CIG = 1000;
        this.SzT = 1;
        this.HSv = new ArrayList();
        this.JBA = new ArrayList();
        this.agB = new JSONObject();
        this.pA = str;
        this.KZx = i;
    }

    public void pA(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.BF = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.BF.add(jSONArray.get(i).toString());
            } catch (Exception unused) {
                return;
            }
        }
    }
}
