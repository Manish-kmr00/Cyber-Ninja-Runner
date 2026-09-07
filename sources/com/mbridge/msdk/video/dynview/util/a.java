package com.mbridge.msdk.video.dynview.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;

/* JADX INFO: compiled from: UIControlUtil.java */
/* JADX INFO: loaded from: classes11.dex */
public class a {
    public static int a(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return 1;
        }
        return campaignEx.getRewardTemplateMode().b();
    }

    public static int b(CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
            int iF = campaignEx.getRewardTemplateMode().f();
            if (iF != 302 && iF != 802 && iF != 902) {
                if (iF == 904) {
                    if (!a(campaignEx.getRewardTemplateMode().e())) {
                        return -1;
                    }
                }
            }
            return -3;
        }
        return 100;
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static String a(long j, Context context) {
        String strP = k0.p(context);
        if (strP.startsWith("zh")) {
            if (!strP.contains("TW") && !strP.contains("HK")) {
                return j + " 秒后自动播放";
            }
            return j + " 秒後自動播放";
        }
        if (strP.startsWith("ja")) {
            return j + " 秒後自動的に再生 ";
        }
        if (strP.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "Automatische Wiedergabe nach " + j + " Sekunden";
        }
        if (strP.startsWith("ko")) {
            return j + " 초 후 자동 재생 ";
        }
        if (strP.startsWith("fr")) {
            return "Lecture de vidéo dans " + j + " secondes";
        }
        if (strP.startsWith("ar")) {
            return " ثوان" + j + "لعب تلقائيا بعد ";
        }
        if (strP.startsWith("ru")) {
            return "Автовоспроизведение через " + j + " секунд";
        }
        return "Auto play after " + j + " s";
    }

    public static String a(Context context, int i) {
        String str;
        if (i == 1) {
            str = "_por";
        } else {
            str = "_land";
        }
        String strP = k0.p(context);
        if (strP.startsWith("zh")) {
            if (!strP.contains("TW") && !strP.contains("HK")) {
                return "mbridge_reward_two_title_zh";
            }
            return "mbridge_reward_two_title_zh_trad";
        }
        if (strP.startsWith("ja")) {
            return "mbridge_reward_two_title_japan".concat(str);
        }
        if (strP.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "mbridge_reward_two_title_germany".concat(str);
        }
        if (strP.startsWith("ko")) {
            return "mbridge_reward_two_title_korea".concat(str);
        }
        if (strP.startsWith("fr")) {
            return "mbridge_reward_two_title_france".concat(str);
        }
        if (strP.startsWith("ar")) {
            return "mbridge_reward_two_title_arabia".concat(str);
        }
        if (strP.startsWith("ru")) {
            return "mbridge_reward_two_title_russian".concat(str);
        }
        return "mbridge_reward_two_title_en".concat(str);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter("alecfc");
            return !TextUtils.isEmpty(queryParameter) && queryParameter.equals("1");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
