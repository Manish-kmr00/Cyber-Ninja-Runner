package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.e0;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.out.Frame;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCampaignUnit.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_C_I = "c_i";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SECOND_REQUEST_INDEX = "r_index";
    public static final String JSON_KEY_SECOND_SHOW_INDEX = "s_show_index";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "b";
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private double ecppv;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private com.mbridge.msdk.foundation.same.report.metrics.c metricsData;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    protected StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";
    private String msg = "";
    private int activitySwitch = 1;
    private int secondRequestIndex = 0;
    private int secondShowIndex = 0;

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKVBuild = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), i0.a("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKVBuild != null) {
            try {
                Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
                if (jSONObject == null || contextD == null) {
                    return;
                }
                String strOptString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString)) {
                    com.mbridge.msdk.foundation.same.a.V = strOptString;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("b", com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKVBuild.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String strOptString2 = jSONObject.optString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
                if (TextUtils.isEmpty(strOptString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.g = strOptString2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, com.mbridge.msdk.foundation.same.a.g);
                try {
                    fastKVBuild.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context contextD2 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (jSONObject == null || contextD2 == null) {
                return;
            }
            String strOptString3 = jSONObject.optString("b");
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString3)) {
                com.mbridge.msdk.foundation.same.a.V = strOptString3;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("b", com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = contextD2.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    editorEdit.apply();
                }
            }
            String strOptString4 = jSONObject.optString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
            if (TextUtils.isEmpty(strOptString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.g = strOptString4;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, com.mbridge.msdk.foundation.same.a.g);
            SharedPreferences sharedPreferences2 = contextD2.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                editorEdit2.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                editorEdit2.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public abstract String assembCParams();

    public int getActivitySwitch() {
        return this.activitySwitch;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public com.mbridge.msdk.foundation.same.report.metrics.c getMetricsData() {
        return this.metricsData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri uri = Uri.parse(this.onlyImpressionUrl);
            if (uri != null) {
                this.requestId = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public int getSecondRequestIndex() {
        return this.secondRequestIndex;
    }

    public int getSecondShowIndex() {
        return this.secondShowIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.sh;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 1) {
            return i;
        }
        return 1;
    }

    protected Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public void setActivitySwitch(int i) {
        this.activitySwitch = i;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEcppv(double d) {
        this.ecppv = d;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> map) {
        this.epMap = map;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i) {
        this.ia_ori = i;
    }

    public void setIa_rst(int i) {
        this.ia_rst = i;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i) {
        this.jmDo = i;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        Iterator<CampaignEx> it = getAds().iterator();
        while (it.hasNext()) {
            it.next().setLocalRequestId(str);
        }
    }

    public void setMetricsData(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        this.metricsData = cVar;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> map) {
        this.rks = map;
    }

    public void setSecondRequestIndex(int i) {
        this.secondRequestIndex = i;
    }

    public void setSecondShowIndex(int i) {
        this.secondShowIndex = i;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0330  */
    /* JADX WARN: Code duplicated, block: B:61:0x0359 A[Catch: Exception -> 0x03f2, TRY_LEAVE, TryCatch #3 {Exception -> 0x03f2, blocks: (B:50:0x02a2, B:49:0x029f, B:51:0x02be, B:52:0x0323, B:56:0x0346, B:58:0x034c, B:59:0x0353, B:61:0x0359, B:69:0x03d9, B:68:0x03d6, B:71:0x03ed), top: B:81:0x01aa }] */
    /* JADX WARN: Code duplicated, block: B:65:0x039e A[Catch: Exception -> 0x03ea, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ea, blocks: (B:44:0x021e, B:46:0x0224, B:63:0x0398, B:65:0x039e), top: B:81:0x01aa }] */
    /* JADX WARN: Code duplicated, block: B:67:0x03d3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x03ea: MOVE (r11 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY]), block:B:70:0x03ea */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.mbridge.msdk.foundation.entity.CampaignUnit] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r11v15, types: [com.mbridge.msdk.foundation.entity.b] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25, types: [com.mbridge.msdk.foundation.entity.b] */
    /* JADX WARN: Type inference failed for: r11v28, types: [com.mbridge.msdk.foundation.entity.b] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r30v3, types: [com.mbridge.msdk.foundation.entity.CampaignUnit, com.mbridge.msdk.foundation.entity.b] */
    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        ?? OptJSONArray;
        ArrayList arrayList;
        Object obj;
        String str2;
        CampaignUnit campaignUnit;
        int i;
        int i2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        String str7;
        int i4;
        ArrayList arrayList2;
        int i5;
        int i6;
        ?? r30;
        String str8;
        int i7;
        CampaignEx campaign;
        ?? r11;
        String str9 = "ads";
        String str10 = "ad_type";
        String str11 = "a";
        String str12 = CampaignEx.JSON_KEY_ECPPV;
        String str13 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str14 = JSON_KEY_HTML_URL;
        if (jSONObject != null) {
            try {
                CampaignUnit campaignUnit2 = new CampaignUnit();
                try {
                    String strOptString = jSONObject.optString(JSON_KEY_RKS);
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(strOptString);
                        Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
                        HashMap<String, String> map = new HashMap<>();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObjectJsonObjectInit.optString(next));
                        }
                        campaignUnit2.setRks(map);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashMap<String, String> map2 = new HashMap<>();
                        map2.put("encrypt_p", "");
                        map2.put(KEY_IRLFA, "");
                        campaignUnit2.setEpMap(map2);
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                    int iOptInt = jSONObject.optInt(JSON_KEY_NSCPT, 1);
                    String strOptString2 = jSONObject.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                    int iOptInt2 = jSONObject.optInt(JSON_KEY_MOF_TPLID, 0);
                    String string = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "";
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList3 = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                            arrayList3.add(jSONArrayOptJSONArray.getString(i8));
                        }
                        arrayList = arrayList3;
                    }
                    com.mbridge.msdk.foundation.db.middle.b.a().a(jSONObject.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                    getSysIDAndBKUPID(jSONObject);
                    campaignUnit2.setSessionId(jSONObject.optString("a"));
                    campaignUnit2.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                    campaignUnit2.setAdType(jSONObject.optInt("ad_type"));
                    campaignUnit2.setUnitSize(jSONObject.optString(JSON_KEY_UNIT_SIZE));
                    campaignUnit2.setHtmlUrl(jSONObject.optString(JSON_KEY_HTML_URL));
                    campaignUnit2.setOnlyImpressionUrl(jSONObject.optString(JSON_KEY_ONLY_IMPRESSION_URL));
                    campaignUnit2.setActivitySwitch(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH));
                    campaignUnit2.setEcppv(jSONObject.optDouble(CampaignEx.JSON_KEY_ECPPV));
                    campaignUnit2.setTemplate(jSONObject.optInt("template"));
                    campaignUnit2.setJmDo(jSONObject.optInt(JSON_KEY_JM_DO));
                    campaignUnit2.setIa_icon(jSONObject.optString("ia_icon"));
                    campaignUnit2.setIa_rst(jSONObject.optInt("ia_rst"));
                    campaignUnit2.setIa_url(jSONObject.optString("ia_url"));
                    campaignUnit2.setIa_ori(jSONObject.optInt("ia_ori"));
                    campaignUnit2.setIa_all_ext1(jSONObject.optString(JSON_KEY_IA_EXT1));
                    campaignUnit2.setIa_all_ext2(jSONObject.optString(JSON_KEY_IA_EXT2));
                    campaignUnit2.setVcn(jSONObject.optInt("vcn"));
                    campaignUnit2.setTokenRule(jSONObject.optInt("token_r"));
                    campaignUnit2.setEncryptPrice(jSONObject.optString("encrypt_p"));
                    campaignUnit2.setSecondRequestIndex(jSONObject.optInt("r_index", 0));
                    campaignUnit2.setSecondShowIndex(jSONObject.optInt("s_show_index", 0));
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ads");
                    OptJSONArray = jSONObject.optJSONArray(JSON_KEY_FRAME_ADS);
                    String strOptString3 = jSONObject.optString(JSON_KEY_C_I, "");
                    e0.a().a(strOptString3);
                    String str15 = "web env is not support";
                    CampaignUnit campaignUnit3 = campaignUnit2;
                    String str16 = JSON_KEY_END_SCREEN_URL;
                    try {
                        try {
                            if (OptJSONArray != 0) {
                                try {
                                    if (OptJSONArray.length() > 0) {
                                        String str17 = "template";
                                        ArrayList arrayList4 = new ArrayList();
                                        int i9 = 0;
                                        ?? r12 = OptJSONArray;
                                        while (i9 < r12.length()) {
                                            JSONObject jSONObjectOptJSONObject2 = r12.optJSONObject(i9);
                                            int i10 = i9;
                                            JSONArray jSONArray = jSONObjectOptJSONObject2.getJSONArray(str9);
                                            String str18 = str9;
                                            ArrayList arrayList5 = new ArrayList();
                                            String str19 = str11;
                                            ?? r28 = r12;
                                            int i11 = 0;
                                            while (i11 < jSONArray.length()) {
                                                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i11);
                                                String strOptString4 = jSONObject.optString(JSON_KEY_ONLY_IMPRESSION_URL);
                                                String strOptString5 = jSONObject.optString(str14);
                                                String strOptString6 = jSONObject.optString(str16);
                                                String strOptString7 = jSONObject.optString(str12);
                                                JSONObject jSONObject2 = jSONObjectOptJSONObject2;
                                                ArrayList arrayList6 = arrayList4;
                                                String str20 = str15;
                                                int i12 = iOptInt;
                                                int i13 = iOptInt2;
                                                JSONArray jSONArray2 = jSONArray;
                                                String str21 = str12;
                                                String str22 = str14;
                                                String str23 = strOptString3;
                                                String str24 = strOptString2;
                                                String str25 = str16;
                                                CampaignUnit campaignUnit4 = campaignUnit3;
                                                CampaignEx campaign2 = CampaignEx.parseCampaign(jSONObjectOptJSONObject3, strOptString4, strOptString5, strOptString6, false, campaignUnit4, str, strOptString7);
                                                if (campaign2 != null) {
                                                    campaign2.setNetAddress(str23);
                                                    campaign2.setKeyIaUrl(campaignUnit4.getIa_url());
                                                    campaign2.setKeyIaOri(campaignUnit4.getIa_ori());
                                                    campaign2.setKeyIaRst(campaignUnit4.getIa_rst());
                                                    campaign2.setKeyIaIcon(campaignUnit4.getIa_icon());
                                                    campaign2.setAdType(jSONObject.optInt(str10));
                                                    campaign2.setIa_ext1(jSONObject.optString(CampaignEx.KEY_IA_EXT1));
                                                    campaign2.setIa_ext2(jSONObject.optString(CampaignEx.KEY_IA_EXT2));
                                                    campaign2.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                                    campaign2.setVcn(campaignUnit4.getVcn());
                                                    campaign2.setTokenRule(campaignUnit4.getTokenRule());
                                                    campaign2.setEncryptPrice(campaignUnit4.getEncryptPrice());
                                                    i2 = i13;
                                                    campaign2.setMof_tplid(i2);
                                                    campaign2.setMof_template_url(str24);
                                                    i = i12;
                                                    campaign2.setNscpt(i);
                                                    campaign2.setPv_urls(arrayList);
                                                    str2 = string;
                                                    campaign2.setReq_ext_data(str2);
                                                    arrayList5.add(campaign2);
                                                    campaignUnit = campaignUnit4;
                                                    str3 = str20;
                                                } else {
                                                    str2 = string;
                                                    campaignUnit = campaignUnit4;
                                                    i = i12;
                                                    i2 = i13;
                                                    str3 = str20;
                                                    campaignUnit.setMsg(str3);
                                                }
                                                i11++;
                                                strOptString2 = str24;
                                                campaignUnit3 = campaignUnit;
                                                string = str2;
                                                iOptInt = i;
                                                jSONArray = jSONArray2;
                                                str14 = str22;
                                                arrayList4 = arrayList6;
                                                strOptString3 = str23;
                                                str15 = str3;
                                                str12 = str21;
                                                jSONObjectOptJSONObject2 = jSONObject2;
                                                iOptInt2 = i2;
                                                str16 = str25;
                                            }
                                            String str26 = str16;
                                            ArrayList arrayList7 = arrayList4;
                                            Frame frame = new Frame();
                                            frame.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                                            String str27 = str10;
                                            frame.setSessionId(jSONObject.optString(str19));
                                            frame.setCampaigns(arrayList5);
                                            String str28 = str17;
                                            frame.setTemplate(jSONObjectOptJSONObject2.optInt(str28));
                                            arrayList7.add(frame);
                                            arrayList4 = arrayList7;
                                            strOptString2 = strOptString2;
                                            str17 = str28;
                                            i9 = i10 + 1;
                                            str11 = str19;
                                            campaignUnit3 = campaignUnit3;
                                            string = string;
                                            iOptInt = iOptInt;
                                            str10 = str27;
                                            str9 = str18;
                                            r12 = r28;
                                            str14 = str14;
                                            strOptString3 = strOptString3;
                                            str15 = str15;
                                            str12 = str12;
                                            iOptInt2 = iOptInt2;
                                            str16 = str26;
                                        }
                                        OptJSONArray = campaignUnit3;
                                        OptJSONArray.setListFrames(arrayList4);
                                    } else {
                                        str4 = JSON_KEY_HTML_URL;
                                        str5 = JSON_KEY_END_SCREEN_URL;
                                        i3 = iOptInt2;
                                        str6 = string;
                                        OptJSONArray = campaignUnit3;
                                        str7 = CampaignEx.JSON_KEY_ECPPV;
                                        i4 = iOptInt;
                                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                            arrayList2 = new ArrayList();
                                            i5 = 0;
                                            OptJSONArray = OptJSONArray;
                                            while (i5 < jSONArrayOptJSONArray2.length()) {
                                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i5);
                                                String strOptString8 = jSONObject.optString(str13);
                                                i6 = i3;
                                                String str29 = str4;
                                                String strOptString9 = jSONObject.optString(str29);
                                                String str30 = str5;
                                                String strOptString10 = jSONObject.optString(str30);
                                                String str31 = str7;
                                                r30 = OptJSONArray;
                                                JSONArray jSONArray3 = jSONArrayOptJSONArray2;
                                                str8 = str6;
                                                i7 = i4;
                                                String str32 = str13;
                                                campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject4, strOptString8, strOptString9, strOptString10, false, r30, str, jSONObject.optString(str31));
                                                if (campaign != null) {
                                                    campaign.setNetAddress(strOptString3);
                                                    campaign.setMof_tplid(i6);
                                                    campaign.setMof_template_url(strOptString2);
                                                    campaign.setNscpt(i7);
                                                    campaign.setPv_urls(arrayList);
                                                    campaign.setReq_ext_data(str8);
                                                    campaign.setVcn(r30.getVcn());
                                                    campaign.setTokenRule(r30.getTokenRule());
                                                    campaign.setEncryptPrice(r30.getEncryptPrice());
                                                    campaign.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                                    arrayList2.add(campaign);
                                                    r11 = r30;
                                                } else {
                                                    r11 = r30;
                                                    r11.setMsg("web env is not support");
                                                }
                                                i5++;
                                                i4 = i7;
                                                i3 = i6;
                                                str6 = str8;
                                                jSONArrayOptJSONArray2 = jSONArray3;
                                                str13 = str32;
                                                str4 = str29;
                                                str7 = str31;
                                                str5 = str30;
                                                OptJSONArray = r11;
                                            }
                                            OptJSONArray.setAds(arrayList2);
                                        }
                                    }
                                } catch (Exception unused) {
                                    OptJSONArray = campaignUnit3;
                                }
                            } else {
                                str4 = JSON_KEY_HTML_URL;
                                str5 = JSON_KEY_END_SCREEN_URL;
                                i3 = iOptInt2;
                                str6 = string;
                                OptJSONArray = campaignUnit3;
                                str7 = CampaignEx.JSON_KEY_ECPPV;
                                i4 = iOptInt;
                                if (jSONArrayOptJSONArray2 != null) {
                                    arrayList2 = new ArrayList();
                                    i5 = 0;
                                    OptJSONArray = OptJSONArray;
                                    while (i5 < jSONArrayOptJSONArray2.length()) {
                                        JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i5);
                                        String strOptString11 = jSONObject.optString(str13);
                                        i6 = i3;
                                        String str210 = str4;
                                        String strOptString12 = jSONObject.optString(str210);
                                        String str33 = str5;
                                        String strOptString13 = jSONObject.optString(str33);
                                        String str34 = str7;
                                        r30 = OptJSONArray;
                                        JSONArray jSONArray4 = jSONArrayOptJSONArray2;
                                        str8 = str6;
                                        i7 = i4;
                                        String str35 = str13;
                                        campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject5, strOptString11, strOptString12, strOptString13, false, r30, str, jSONObject.optString(str34));
                                        if (campaign != null) {
                                            campaign.setNetAddress(strOptString3);
                                            campaign.setMof_tplid(i6);
                                            campaign.setMof_template_url(strOptString2);
                                            campaign.setNscpt(i7);
                                            campaign.setPv_urls(arrayList);
                                            campaign.setReq_ext_data(str8);
                                            campaign.setVcn(r30.getVcn());
                                            campaign.setTokenRule(r30.getTokenRule());
                                            campaign.setEncryptPrice(r30.getEncryptPrice());
                                            campaign.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                            arrayList2.add(campaign);
                                            r11 = r30;
                                        } else {
                                            r11 = r30;
                                            r11.setMsg("web env is not support");
                                        }
                                        i5++;
                                        i4 = i7;
                                        i3 = i6;
                                        str6 = str8;
                                        jSONArrayOptJSONArray2 = jSONArray4;
                                        str13 = str35;
                                        str4 = str210;
                                        str7 = str34;
                                        str5 = str33;
                                        OptJSONArray = r11;
                                    }
                                    OptJSONArray.setAds(arrayList2);
                                }
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Exception unused3) {
                        OptJSONArray = obj;
                    }
                } catch (Exception unused4) {
                    OptJSONArray = campaignUnit2;
                }
                return OptJSONArray;
            } catch (Exception unused5) {
            }
        }
        return null;
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }
}
