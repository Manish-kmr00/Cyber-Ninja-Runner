package com.bytedance.sdk.openadsdk.multipro.ZZv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.l;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class KZx implements com.bytedance.sdk.openadsdk.multipro.pA {
    private Context pA;

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA() {
        return "t_sp";
    }

    private Context Og() {
        Context context = this.pA;
        return context == null ? aBv.pA() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapKZx;
        if (!uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2].equals("get_all") || (mapKZx = Og.KZx(Og(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapKZx.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = mapKZx.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = l.w;
            } else if (obj instanceof Long) {
                objArr[1] = Constants.LONG;
            } else if (obj instanceof Float) {
                objArr[1] = TypedValues.Custom.S_FLOAT;
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA(Uri uri) {
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return String.valueOf(Og.pA(aBv.pA(), uri.getQueryParameter("sp_file_name"), str2));
        }
        return Og.pA(Og(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Uri pA(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            Og.pA(Og(), uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit[2].equals("clean")) {
            Og.Og(Og(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (Og.pA(Og(), uri.getQueryParameter("sp_file_name"), str2)) {
            Og.Og(Og(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        pA(uri, contentValues);
        return 0;
    }
}
