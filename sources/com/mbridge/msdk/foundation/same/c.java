package com.mbridge.msdk.foundation.same;

import android.content.Context;
import android.text.TextUtils;
import com.json.b9;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.smaato.sdk.core.dns.DnsName;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameCommon.java */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: compiled from: SameCommon.java */
    public static abstract class a {
        public abstract void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar);
    }

    public static long a(long j, long j2) {
        return j >= 0 ? j : j2;
    }

    public static boolean a(Context context, CampaignEx campaignEx) {
        if (context != null && campaignEx != null) {
            boolean zC = t0.c(context, campaignEx.getPackageName());
            boolean zC2 = t0.c(campaignEx);
            if (campaignEx.getWtick() == 1) {
                return true;
            }
            if (zC2 && zC) {
                return true;
            }
            if (!zC2 && !zC) {
                return true;
            }
        }
        return false;
    }

    public static String b(List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null && campaignEx.getCreativeId() != 0) {
                arrayList.add(campaignEx);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) arrayList.get(i);
                if (campaignEx2 != null) {
                    long creativeId = campaignEx2.getCreativeId();
                    if (i == arrayList.size() - 1) {
                        sb.append(creativeId);
                    } else {
                        sb.append(creativeId).append(StringUtils.COMMA);
                    }
                }
            } catch (Exception e) {
                o0.b("SameCommon", "getCreativeID", e);
            }
        }
        return sb.toString();
    }

    public static void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, a aVar) {
        a(campaignEx, context, cVar, aVar, 1);
    }

    public static void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, a aVar, int i) {
        int i2;
        if (campaignEx == null || aVar == null) {
            return;
        }
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        boolean zC = t0.c(campaignEx);
        int iD = t0.d(context, campaignEx.getPackageName());
        if (context != null) {
            try {
                i2 = f.b(context) ? 1 : 2;
            } catch (Exception e2) {
                o0.b("SameCommon", e2.getMessage());
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        e eVar = new e();
        eVar.a("cid", campaignEx.getId());
        eVar.a(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
        eVar.a(CampaignEx.JSON_KEY_RETARGET_OFFER, Integer.valueOf(campaignEx.getRetarget_offer()));
        eVar.a("ind", Integer.valueOf(iD));
        eVar.a(b9.h.q, Integer.valueOf(i));
        eVar.a(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, 0);
        eVar.a("per", Integer.valueOf(i2));
        if (zC) {
            if (iD != 1) {
                cVar.a("m_campaign_filtered", eVar);
                aVar.a("m_campaign_filtered", cVar);
            }
            cVar.a("m_campaign_ind_retarget", eVar);
            aVar.a("m_campaign_ind_retarget", cVar);
            return;
        }
        if (iD == 1) {
            cVar.a("m_campaign_filtered", eVar);
            aVar.a("m_campaign_filtered", cVar);
        }
        cVar.a("m_campaign_ind_unretarget", eVar);
        aVar.a("m_campaign_ind_unretarget", cVar);
    }

    public static boolean b(Context context, CampaignEx campaignEx) {
        if (context != null && campaignEx != null) {
            boolean zC = t0.c(context, campaignEx.getPackageName());
            if (t0.c(campaignEx) || campaignEx.getWtick() == 1 || !zC) {
                return true;
            }
        }
        return false;
    }

    public static byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
            if (strArrSplit.length != 4) {
                return null;
            }
            byte[] bArr = new byte[4];
            for (int i = 0; i < 4; i++) {
                int i2 = Integer.parseInt(strArrSplit[i]);
                if (i2 >= 0 && i2 <= 255) {
                    bArr[i] = (byte) i2;
                }
                return null;
            }
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : str.split(b9.i.c)) {
                String[] strArrSplit = str2.split("=");
                String str3 = "";
                if (strArrSplit.length == 2) {
                    String str4 = strArrSplit[0];
                    if (!TextUtils.isEmpty(str4)) {
                        String str5 = strArrSplit[1];
                        if (str5 != null) {
                            str3 = str5;
                        }
                        jSONObject.put(str4, str3);
                    }
                } else if (strArrSplit.length == 1) {
                    String str6 = strArrSplit[0];
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject.put(str6, "");
                    }
                }
            }
            return jSONObject;
        } catch (Exception e) {
            o0.a("SameCommon", "coverReportMessage", e);
            return null;
        } catch (Throwable th) {
            o0.a("SameCommon", "coverReportMessage", th);
            return null;
        }
    }

    public static String a(List<CampaignEx> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                try {
                    CampaignEx campaignEx = list.get(i);
                    if (campaignEx != null) {
                        String id = campaignEx.getId();
                        if (i == list.size() - 1) {
                            sb.append(id);
                        } else {
                            sb.append(id).append(StringUtils.COMMA);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    sb.append(new String(bArr, 0, i));
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
