package com.bytedance.sdk.openadsdk.multipro.pA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ML;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes13.dex */
public class Og implements com.bytedance.sdk.openadsdk.multipro.pA {
    private static final Object Og = new Object();
    private Context pA;

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA() {
        return "t_db";
    }

    private boolean Og(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context Og() {
        Context context = this.pA;
        return context == null ? aBv.pA() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        synchronized (Og) {
            if (Og(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str3 = strArrSplit[2];
                String str4 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str3)) {
                    return null;
                }
                return ML.pA(Og()).pA().pA(str4, strArr, str, strArr2, null, null, str2);
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA(Uri uri) {
        synchronized (Og) {
            if (Og(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 5) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[4];
                if ("ttopensdk.db".equals(str)) {
                    if ("execSQL".equals(str2)) {
                        String queryParameter = uri.getQueryParameter("sql");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            ML.pA(Og()).pA().pA(Uri.decode(queryParameter));
                        }
                    } else if ("transactionBegin".equals(str2)) {
                        ML.pA(Og()).pA().Og();
                    } else if ("transactionSetSuccess".equals(str2)) {
                        ML.pA(Og()).pA().KZx();
                    } else if ("transactionEnd".equals(str2)) {
                        ML.pA(Og()).pA().ZZv();
                    }
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Uri pA(Uri uri, ContentValues contentValues) {
        synchronized (Og) {
            if (Og(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                if ("ttopensdk.db".equals(str)) {
                    ML.pA(Og()).pA().pA(str2, (String) null, contentValues);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, String str, String[] strArr) {
        synchronized (Og) {
            if (Og(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return ML.pA(Og()).pA().pA(str3, str, strArr);
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        synchronized (Og) {
            if (Og(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return ML.pA(Og()).pA().pA(str3, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
