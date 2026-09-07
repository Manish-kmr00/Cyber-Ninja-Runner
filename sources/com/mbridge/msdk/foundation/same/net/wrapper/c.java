package com.mbridge.msdk.foundation.same.net.wrapper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.json.b9;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.tracker.network.k;
import com.mbridge.msdk.tracker.network.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonAsyncHttpRequest.java */
/* JADX INFO: loaded from: classes10.dex */
public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().d();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb.append(b9.i.c).append(str).append("=").append(str2);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(TAG, e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    private static com.mbridge.msdk.tracker.network.h<?> createRequest(int i, int i2, String str, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        if (i == 0) {
            return new k(i2, str, str2, j, new i(bVar));
        }
        if (i != 1) {
            return null;
        }
        return new com.mbridge.msdk.tracker.network.i(i2, str, str2, j, new i(bVar));
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0059  */
    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab A[Catch: Exception -> 0x00fa, TRY_ENTER, TryCatch #2 {Exception -> 0x00fa, blocks: (B:35:0x00ab, B:37:0x00b1, B:41:0x00bc, B:48:0x00df, B:53:0x00fe), top: B:95:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b1 A[Catch: Exception -> 0x00fa, TryCatch #2 {Exception -> 0x00fa, blocks: (B:35:0x00ab, B:37:0x00b1, B:41:0x00bc, B:48:0x00df, B:53:0x00fe), top: B:95:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #2 {Exception -> 0x00fa, blocks: (B:35:0x00ab, B:37:0x00b1, B:41:0x00bc, B:48:0x00df, B:53:0x00fe), top: B:95:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x012a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0163  */
    /* JADX WARN: Code duplicated, block: B:68:0x016f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0171  */
    /* JADX WARN: Code duplicated, block: B:70:0x018d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0198  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:98:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void post(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, boolean z2, String str2, long j) {
        e eVar2;
        e eVar3;
        String str3;
        JSONArray jSONArrayB;
        String str4;
        com.mbridge.msdk.setting.g gVarD;
        com.mbridge.msdk.setting.a aVarJ;
        com.mbridge.msdk.tracker.network.h<?> hVarCreateRequest;
        String str5;
        com.mbridge.msdk.setting.g gVarD2;
        int iY0;
        String strK;
        int iK;
        String str6;
        if (eVar == null) {
            try {
                eVar2 = new e();
            } catch (Exception e) {
                e = e;
                eVar2 = eVar;
                o0.a(TAG, e.getMessage());
                eVar3 = eVar2;
                o0.c(TAG, "post url = " + str);
                if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d)) {
                    gVarD2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                    if (gVarD2 != null) {
                        iK = gVarD2.K();
                        try {
                            str6 = eVar3.a().get("data");
                            if (!z2) {
                                try {
                                    if (!com.mbridge.msdk.foundation.same.report.b.a(gVarD2, str6)) {
                                        return;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str6 = "";
                        }
                        strK = gVarD2.k();
                        iY0 = gVarD2.y0();
                        eVar3.a("a_stid", gVarD2.a());
                    } else {
                        iY0 = 0;
                        strK = "UNKNOWN";
                        iK = 1;
                        str6 = "";
                    }
                    eVar3.a("country_code", strK);
                    try {
                        if (iK == 2) {
                            if (!TextUtils.isEmpty(str6)) {
                                return;
                            }
                            if (com.mbridge.msdk.foundation.same.report.b.a(gVarD2, str6)) {
                                if (iY0 != 1) {
                                }
                                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                                return;
                            } else if (z2) {
                                if (iY0 != 1) {
                                    return;
                                }
                                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                                return;
                            }
                        } else if (iK == 1) {
                            com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                            return;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } else {
                    if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().h)) {
                        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d0)) {
                            if (eVar3 != null) {
                                str3 = str + "?" + eVar3.toString();
                            } else {
                                str3 = str;
                            }
                            jSONArrayB = com.mbridge.msdk.foundation.db.middle.b.a().b();
                            if (jSONArrayB != null) {
                                String string = jSONArrayB.toString();
                                eVar3 = new e();
                                eVar3.a(e.k, string);
                            }
                            str4 = str3;
                        }
                        hVarCreateRequest = createRequest(i, 1, str4, bVar, str2, j);
                        if (hVarCreateRequest != null) {
                            if (eVar3 != null) {
                                str5 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "";
                                }
                                hVarCreateRequest.a("local_id", str5);
                                String str7 = eVar3.a().get("ad_type");
                                hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str7) ? "" : str7);
                                hVarCreateRequest.a(eVar3.a());
                            }
                            hVarCreateRequest.d(canTrack());
                            hVarCreateRequest.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                            l.a().b().a(hVarCreateRequest);
                        }
                    }
                    gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                    if (gVarD != null) {
                        com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().l, com.mbridge.msdk.foundation.same.net.utils.d.h().p, eVar3.toString(), false, bVar);
                        return;
                    }
                }
                str4 = str;
                hVarCreateRequest = createRequest(i, 1, str4, bVar, str2, j);
                if (hVarCreateRequest != null) {
                    if (eVar3 != null) {
                        str5 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (TextUtils.isEmpty(str5)) {
                            str5 = "";
                        }
                        hVarCreateRequest.a("local_id", str5);
                        String str8 = eVar3.a().get("ad_type");
                        hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str8) ? "" : str8);
                        hVarCreateRequest.a(eVar3.a());
                    }
                    hVarCreateRequest.d(canTrack());
                    hVarCreateRequest.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    l.a().b().a(hVarCreateRequest);
                }
            }
        } else {
            eVar2 = eVar;
        }
        try {
            addExtraParams(str, eVar2);
            f.k(eVar2);
            com.mbridge.msdk.foundation.same.net.e eVarA = com.mbridge.msdk.foundation.same.net.utils.c.b().a(eVar2);
            if (eVarA != null && bVar != null) {
                bVar.onSuccess(eVarA);
                return;
            }
        } catch (Exception e5) {
            e = e5;
            o0.a(TAG, e.getMessage());
        }
        eVar3 = eVar2;
        o0.c(TAG, "post url = " + str);
        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d)) {
            gVarD2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD2 != null) {
                iK = gVarD2.K();
                str6 = eVar3.a().get("data");
                if (!z2) {
                    if (!com.mbridge.msdk.foundation.same.report.b.a(gVarD2, str6)) {
                        return;
                    }
                }
                strK = gVarD2.k();
                iY0 = gVarD2.y0();
                eVar3.a("a_stid", gVarD2.a());
            } else {
                iY0 = 0;
                strK = "UNKNOWN";
                iK = 1;
                str6 = "";
            }
            eVar3.a("country_code", strK);
            if (iK == 2) {
                if (!TextUtils.isEmpty(str6)) {
                    return;
                }
                if (com.mbridge.msdk.foundation.same.report.b.a(gVarD2, str6)) {
                    if (iY0 != 1 || iY0 == 3) {
                        com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                        return;
                    }
                } else if (z2) {
                    if (iY0 != 1 && iY0 != 3) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                    return;
                }
            } else if (iK == 1) {
                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar3.toString(), false, bVar);
                return;
            }
        } else {
            if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().h)) {
                if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d0)) {
                    if (eVar3 != null) {
                        str3 = str + "?" + eVar3.toString();
                    } else {
                        str3 = str;
                    }
                    jSONArrayB = com.mbridge.msdk.foundation.db.middle.b.a().b();
                    if (jSONArrayB != null) {
                        String string2 = jSONArrayB.toString();
                        eVar3 = new e();
                        eVar3.a(e.k, string2);
                    }
                    str4 = str3;
                }
                hVarCreateRequest = createRequest(i, 1, str4, bVar, str2, j);
                if (hVarCreateRequest != null) {
                    if (eVar3 != null && eVar3.a() != null) {
                        str5 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (TextUtils.isEmpty(str5)) {
                            str5 = "";
                        }
                        hVarCreateRequest.a("local_id", str5);
                        String str9 = eVar3.a().get("ad_type");
                        hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str9) ? "" : str9);
                        hVarCreateRequest.a(eVar3.a());
                    }
                    hVarCreateRequest.d(canTrack());
                    hVarCreateRequest.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    l.a().b().a(hVarCreateRequest);
                }
            }
            gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD != null && (aVarJ = gVarD.j()) != null && aVarJ.h() == 1) {
                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().l, com.mbridge.msdk.foundation.same.net.utils.d.h().p, eVar3.toString(), false, bVar);
                return;
            }
        }
        str4 = str;
        hVarCreateRequest = createRequest(i, 1, str4, bVar, str2, j);
        if (hVarCreateRequest != null) {
            if (eVar3 != null) {
                str5 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                hVarCreateRequest.a("local_id", str5);
                String str10 = eVar3.a().get("ad_type");
                hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str10) ? "" : str10);
                hVarCreateRequest.a(eVar3.a());
            }
            hVarCreateRequest.d(canTrack());
            hVarCreateRequest.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            l.a().b().a(hVarCreateRequest);
        }
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar == null) {
            o0.b(TAG, "addExtraParams error, params is null,frame work error");
            return;
        }
        String strA = Aa.a();
        if (strA == null) {
            strA = "";
        }
        eVar.a("channel", strA);
        eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.b().a() + "");
        eVar.a("open", com.mbridge.msdk.foundation.same.a.S);
        if (com.mbridge.msdk.util.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
            String strB = Aa.b();
            if (!TextUtils.isEmpty(strB)) {
                eVar.a("keyword", strB);
            }
        }
        String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (str2 != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.setting.l lVarE = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
            if (lVarE != null && !TextUtils.isEmpty(lVarE.a())) {
                eVar.a("u_stid", lVarE.a());
            }
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            eVar.a("dev_source", "2");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            eVar.a("re_domain", "1");
        }
    }

    protected boolean canTrack() {
        return true;
    }

    public void choiceV3OrV5BySetting(int i, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str, long j) {
        e eVar2;
        com.mbridge.msdk.setting.g gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        int iP0 = TextUtils.isEmpty(str) ? gVarB.p0() : gVarB.B();
        String strA = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, iP0);
        if (iP0 < 2) {
            postV5(i, strA, eVar, bVar, "campaign", j);
            return;
        }
        if (iP0 % 2 == 0) {
            eVar2 = eVar == null ? new e() : eVar;
            JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.middle.b.a().b();
            if (jSONArrayB != null) {
                String string = jSONArrayB.toString();
                int i2 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                if (i2 > 0 && string.length() > i2) {
                    post(i, strA, eVar2, bVar, "campaign", j);
                    return;
                }
                eVar2.a(e.k, string);
            }
        } else {
            eVar2 = eVar;
        }
        getLoadOrSetting(i, strA, eVar2, bVar, "campaign", j);
    }

    public void get(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        get(i, str, eVar, bVar, false, false, str2, j);
    }

    public void getCampaign(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, long j) {
        e eVar2;
        try {
            com.mbridge.msdk.setting.g gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            int iP0 = TextUtils.isEmpty(str) ? gVarB.p0() : gVarB.B();
            String strA = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, iP0);
            if (iP0 < 2) {
                postV5(i, strA, eVar, bVar, true, "campaign", j);
                return;
            }
            if (iP0 % 2 == 0) {
                eVar2 = eVar == null ? new e() : eVar;
                JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.middle.b.a().b();
                if (jSONArrayB != null) {
                    String string = jSONArrayB.toString();
                    int i2 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                    if (i2 > 0 && string.length() > i2) {
                        post(i, strA, eVar2, bVar, true, false, "campaign", j);
                        return;
                    }
                    eVar2.a(e.k, string);
                }
            } else {
                eVar2 = eVar;
            }
            get(i, strA, eVar2, bVar, true, true, "campaign", j);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, e.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        getLoadOrSetting(i, str, eVar, bVar, true, str2, j);
    }

    public void postFocusReport(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        post(i, str, eVar, bVar, false, true, str2, j);
    }

    public void postV5(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
        post(i, str, eVar, bVar, false, false, str2, j);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0198  */
    /* JADX WARN: Code duplicated, block: B:52:0x019e  */
    /* JADX WARN: Code duplicated, block: B:54:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    public void get(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, boolean z2, String str2, long j) {
        e eVar2;
        e eVar3;
        String str3;
        com.mbridge.msdk.setting.g gVarB;
        com.mbridge.msdk.tracker.network.h<?> hVarCreateRequest;
        String str4;
        if (eVar == null) {
            try {
                eVar2 = new e();
            } catch (Exception e) {
                e = e;
                eVar2 = eVar;
                o0.a(TAG, e.getMessage());
                eVar3 = eVar2;
                if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().i)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("uri", com.mbridge.msdk.foundation.same.net.utils.d.h().m + Uri.parse(str).getPath());
                            jSONObject.put("data", eVar3.b());
                        } catch (Throwable th) {
                            o0.b(TAG, th.getMessage());
                        }
                        com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().m, com.mbridge.msdk.foundation.same.net.utils.d.h().q, jSONObject.toString(), true, bVar);
                        return;
                    } catch (Throwable th2) {
                        o0.b(TAG, th2.getMessage());
                    }
                }
                str3 = str + "?" + eVar3.toString();
                gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
                if (str3.length() < gVarB.m0()) {
                }
                if (str3.length() < gVarB.L()) {
                }
                hVarCreateRequest = createRequest(i, 0, str, bVar, str2, j);
                if (hVarCreateRequest != null) {
                    if (eVar3.a() != null) {
                        str4 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (TextUtils.isEmpty(str4)) {
                            str4 = "";
                        }
                        hVarCreateRequest.a("local_id", str4);
                        String str5 = eVar3.a().get("ad_type");
                        hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
                        hVarCreateRequest.a(eVar3.a());
                    }
                    hVarCreateRequest.d(canTrack());
                    l.a().b().a(hVarCreateRequest);
                }
            }
        } else {
            eVar2 = eVar;
        }
        try {
            addExtraParams(str, eVar2);
            f.k(eVar2);
            String str6 = eVar2.a().get("sign");
            if (TextUtils.isEmpty(str6)) {
                str6 = "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            eVar2.a("ts", jCurrentTimeMillis + "");
            if (com.mbridge.msdk.util.b.a()) {
                eVar2.a("st", SameMD5.getMD5(str6 + jCurrentTimeMillis));
            } else {
                eVar2.a("st", SameMD5.getMD5(jCurrentTimeMillis + str6));
            }
            com.mbridge.msdk.foundation.same.net.e eVarA = com.mbridge.msdk.foundation.same.net.utils.c.b().a(eVar2);
            if (eVarA != null && bVar != null) {
                bVar.onSuccess(eVarA);
                return;
            }
        } catch (Exception e2) {
            e = e2;
            o0.a(TAG, e.getMessage());
        }
        eVar3 = eVar2;
        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().i) && com.mbridge.msdk.foundation.same.net.utils.d.h().s) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uri", com.mbridge.msdk.foundation.same.net.utils.d.h().m + Uri.parse(str).getPath());
            jSONObject2.put("data", eVar3.b());
            com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().m, com.mbridge.msdk.foundation.same.net.utils.d.h().q, jSONObject2.toString(), true, bVar);
            return;
        }
        str3 = str + "?" + eVar3.toString();
        gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        if (str3.length() < gVarB.m0() && str3.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().i)) {
            post(i, str, eVar3, bVar, z2, false, str2, j);
            return;
        }
        if (str3.length() < gVarB.L() && z) {
            post(i, str, eVar3, bVar, z2, false, str2, j);
            return;
        }
        hVarCreateRequest = createRequest(i, 0, str, bVar, str2, j);
        if (hVarCreateRequest != null) {
            if (eVar3.a() != null) {
                str4 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                hVarCreateRequest.a("local_id", str4);
                String str7 = eVar3.a().get("ad_type");
                hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str7) ? "" : str7);
                hVarCreateRequest.a(eVar3.a());
            }
            hVarCreateRequest.d(canTrack());
            l.a().b().a(hVarCreateRequest);
        }
    }

    public void getLoadOrSetting(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, String str2, long j) {
        get(i, str, eVar, bVar, z, false, str2, j);
    }

    public void postV5(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, String str2, long j) {
        String str3 = eVar.a().get("sign");
        if (str3 == null) {
            str3 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
        post(i, str, eVar, bVar, z, false, str2, j);
    }

    public void get(int i, String str, Map<String, String> map, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("app_id", com.mbridge.msdk.foundation.controller.c.m().b());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put("platform", "1");
        String strAsUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(strAsUrlParams)) {
            str = str + "?" + strAsUrlParams;
        }
        String str3 = str;
        if (MBridgeConstans.DEBUG) {
            o0.a("AppletsModel", "get wx scheme url = " + str3);
        }
        com.mbridge.msdk.tracker.network.h<?> hVarCreateRequest = createRequest(i, 0, str3, bVar, str2, j);
        if (hVarCreateRequest != null) {
            String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            hVarCreateRequest.a("local_id", str4);
            String str5 = map.get("ad_type");
            hVarCreateRequest.a("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
            hVarCreateRequest.a(map);
            hVarCreateRequest.d(canTrack());
            l.a().b().a(hVarCreateRequest);
        }
    }

    public void post(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        post(i, str, eVar, bVar, false, false, str2, j);
    }
}
