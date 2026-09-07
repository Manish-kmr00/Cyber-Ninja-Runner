package com.mbridge.msdk.advanced.signal;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.playon.bridge.Ad;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedJsUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4719a = "NativeAdvancedJsUtils";

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        JSONArray jSONArray;
        int i;
        boolean z;
        String str3;
        String str4 = "";
        JSONObject jSONObject2 = new JSONObject();
        String str5 = "message";
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                o0.a(f4719a, e.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray2 = jSONObject.getJSONArray(Ad.VERIFICATIONRESOURCE);
            try {
                if (jSONArray2 != null) {
                    try {
                        if (jSONArray2.length() > 0) {
                            JSONArray jSONArray3 = new JSONArray();
                            int length = jSONArray2.length();
                            int i3 = 0;
                            while (i3 < length) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                                String strOptString = jSONObject3.optString("ref", str4);
                                int i4 = jSONObject3.getInt("type");
                                JSONObject jSONObject4 = new JSONObject();
                                if (i4 != i2 || TextUtils.isEmpty(strOptString)) {
                                    str4 = str4;
                                    str2 = str5;
                                    jSONArray = jSONArray2;
                                    i = length;
                                    z = false;
                                    if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("type", 2);
                                        jSONObject5.put("path", H5DownLoadManager.getInstance().getH5ResAddress(strOptString) == null ? str4 : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
                                        jSONObject4.put(strOptString, jSONObject5);
                                        jSONArray3.put(jSONObject4);
                                    } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                                        try {
                                            File file = new File(strOptString);
                                            if (file.exists() && file.isFile() && file.canRead()) {
                                                o0.a(f4719a, "getFileInfo Mraid file " + strOptString);
                                                str3 = "file:////" + strOptString;
                                            } else {
                                                str3 = str4;
                                            }
                                        } catch (Throwable th) {
                                            o0.b(f4719a, th.getMessage());
                                        }
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("type", 3);
                                        jSONObject6.put("path", str3);
                                        jSONObject4.put(strOptString, jSONObject6);
                                        jSONArray3.put(jSONObject4);
                                    } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put("type", 4);
                                        jSONObject7.put("path", s0.a(strOptString) == null ? str4 : s0.a(strOptString));
                                        jSONObject4.put(strOptString, jSONObject7);
                                        jSONArray3.put(jSONObject4);
                                    }
                                } else {
                                    JSONObject jSONObject8 = new JSONObject();
                                    l lVarB = m.a(g.a(c.m().d())).b(strOptString);
                                    if (lVarB != null) {
                                        jSONArray = jSONArray2;
                                        i = length;
                                        o0.a(f4719a, "VideoBean not null");
                                        jSONObject8.put("type", 1);
                                        jSONObject8.put("videoDataLength", lVarB.d());
                                        String strE = lVarB.e();
                                        str2 = str5;
                                        if (TextUtils.isEmpty(strE)) {
                                            o0.a(f4719a, "VideoPath null");
                                            jSONObject8.put("path", str4);
                                            jSONObject8.put("path4Web", str4);
                                        } else {
                                            o0.a(f4719a, "VideoPath not null");
                                            jSONObject8.put("path", strE);
                                            jSONObject8.put("path4Web", strE);
                                        }
                                        if (lVarB.b() == 5) {
                                            jSONObject8.put("downloaded", 1);
                                            z = false;
                                        } else {
                                            z = false;
                                            jSONObject8.put("downloaded", 0);
                                        }
                                        jSONObject4.put(strOptString, jSONObject8);
                                        jSONArray3.put(jSONObject4);
                                    } else {
                                        str4 = str4;
                                        str2 = str5;
                                        jSONArray = jSONArray2;
                                        i = length;
                                        z = false;
                                        o0.a(f4719a, "VideoBean null");
                                    }
                                }
                                i3++;
                                jSONArray2 = jSONArray;
                                length = i;
                                str5 = str2;
                                str4 = str4;
                                i2 = 1;
                            }
                            jSONObject2.put(Ad.VERIFICATIONRESOURCE, jSONArray3);
                            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = str5;
                        str = str2;
                        try {
                            jSONObject2.put("code", 1);
                            jSONObject2.put(str, th.getLocalizedMessage());
                            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (JSONException e2) {
                            o0.a(f4719a, e2.getMessage());
                            return;
                        }
                    }
                }
                try {
                    jSONObject2.put("code", 1);
                    str = "message";
                    try {
                        try {
                            jSONObject2.put(str, "resource is null");
                            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (Throwable th3) {
                            th = th3;
                            jSONObject2.put("code", 1);
                            jSONObject2.put(str, th.getLocalizedMessage());
                            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        o0.a(f4719a, e.getMessage());
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str = "message";
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            str = "message";
        }
    }

    public static void a(WebView webView, String str, String str2) {
        f.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            f.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            o0.b(f4719a, e.getMessage());
        }
    }

    public static void a(WebView webView) {
        o0.b(f4719a, "fireOnJSBridgeConnected");
        f.a().a(webView);
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", d.b);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            o0.a(f4719a, e.getMessage());
        }
    }
}
