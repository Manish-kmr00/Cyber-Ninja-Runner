package com.bytedance.sdk.component.JG.pA.Og.Og;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.JG;
import com.bytedance.sdk.component.JG.pA.ZZv;
import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.pA.SD;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    public static JG pA;

    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int pA(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri pA(Uri uri, ContentValues contentValues) {
        return null;
    }

    public static JG pA(Context context) {
        try {
            if (pA == null) {
                pA = omh.SD().oX().BSW();
            }
        } catch (Exception unused) {
        }
        return pA;
    }

    public static void pA() {
        if (omh.SD().JG() == null) {
            return;
        }
        try {
            JG jgPA = pA(omh.SD().JG());
            if (jgPA != null) {
                jgPA.pA(Uri.parse(ZZv() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void Og() {
        if (omh.SD().JG() == null) {
            return;
        }
        try {
            JG jgPA = pA(omh.SD().JG());
            if (jgPA != null) {
                jgPA.pA(Uri.parse(ZZv() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        if (pAVar == null) {
            return;
        }
        try {
            JG jgPA = pA(omh.SD().JG());
            if (jgPA != null) {
                jgPA.pA(Uri.parse(ZZv() + "adLogDispatch?event=" + com.bytedance.sdk.component.JG.pA.pA.pA.JG.pA(pAVar.JG())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void pA(String str, List<String> list, boolean z, int i, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.JG.pA.pA.pA.JG.pA(it.next())).append(StringUtils.COMMA);
            }
            String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.JG.pA.pA.pA.JG.pA(sb.toString())) + "&replace=" + String.valueOf(z) + "&urlType=" + String.valueOf(i) + "&adId=" + str2;
            JG jgPA = pA(omh.SD().JG());
            if (jgPA != null) {
                jgPA.pA(Uri.parse(ZZv() + "trackAdUrl" + str3));
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(String str, boolean z) {
        if (omh.SD().oX().JG() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JG jgPA = pA(omh.SD().JG());
            if (jgPA != null) {
                jgPA.pA(Uri.parse(ZZv() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z));
            }
        } catch (Throwable unused) {
        }
    }

    private static String ZZv() {
        return SD.Og + "/ad_log_event/";
    }

    public String KZx() {
        return "ad_log_event";
    }

    public String pA(Uri uri) {
        com.bytedance.sdk.component.JG.pA.ZZv.pA pAVarKZx;
        byte b = 2;
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        str.hashCode();
        int i = 0;
        switch (str.hashCode()) {
            case -482705237:
                b = str.equals("trackAdFailed") ? (byte) 0 : (byte) -1;
                break;
            case -171493183:
                b = str.equals("adLogStart") ? (byte) 1 : (byte) -1;
                break;
            case 964299715:
                if (!str.equals("adLogStop")) {
                    b = -1;
                }
                break;
            case 1025736635:
                b = str.equals("adLogDispatch") ? (byte) 3 : (byte) -1;
                break;
            case 1131732929:
                b = str.equals("trackAdUrl") ? (byte) 4 : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                com.bytedance.sdk.component.JG.pA.JG.pA.pA().pA(uri.getQueryParameter("did"), uri.getBooleanQueryParameter("triggerOnInit", false));
                break;
            case 1:
                omh.SD().Bzk();
                break;
            case 2:
                omh.SD().BSW();
                break;
            case 3:
                String queryParameter = uri.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter) && (pAVarKZx = com.bytedance.sdk.component.JG.pA.ZZv.pA.pA.KZx(com.bytedance.sdk.component.JG.pA.pA.pA.JG.Og(queryParameter))) != null) {
                    ZZv.pA.pA(pAVarKZx);
                    break;
                }
                break;
            case 4:
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter3 = uri.getQueryParameter("track");
                    String queryParameter4 = uri.getQueryParameter("urlType");
                    String queryParameter5 = uri.getQueryParameter("adId");
                    String[] strArrSplit = com.bytedance.sdk.component.JG.pA.pA.pA.JG.Og(queryParameter3).split(StringUtils.COMMA);
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strOg = com.bytedance.sdk.component.JG.pA.pA.pA.JG.Og(str2);
                            if (!TextUtils.isEmpty(strOg)) {
                                arrayList.add(strOg);
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                i = Integer.parseInt(queryParameter4);
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.component.JG.pA.JG.pA.pA().pA(queryParameter2, arrayList, zBooleanValue, null, i, queryParameter5);
                    }
                } catch (Throwable unused2) {
                    return null;
                }
                break;
        }
        return null;
    }
}
