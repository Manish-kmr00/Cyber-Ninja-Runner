package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ML implements pA {
    private static final List<pA> KZx;
    private static WeakReference<Context> Og;
    private static volatile ML pA;

    private boolean KZx(Uri uri) {
        return true;
    }

    static {
        List<pA> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        KZx = listSynchronizedList;
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.ZZv.KZx());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.pA.Og());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.KZx.pA());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.ZZv.pA.ML(new com.bytedance.sdk.component.JG.pA.Og.Og.Og()));
        Iterator<pA> it = listSynchronizedList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static ML pA(Context context) {
        if (context != null) {
            Og = new WeakReference<>(context.getApplicationContext());
        }
        if (pA == null) {
            synchronized (ML.class) {
                if (pA == null) {
                    pA = new ML();
                }
            }
        }
        return pA;
    }

    private ML() {
    }

    private pA Og(Uri uri) {
        if (uri == null || !KZx(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (pA pAVar : KZx) {
            if (str.equals(pAVar.pA())) {
                return pAVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            pA pAVarOg = Og(uri);
            if (pAVarOg != null) {
                return pAVarOg.pA(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA(Uri uri) {
        try {
            pA pAVarOg = Og(uri);
            if (pAVarOg != null) {
                return pAVarOg.pA(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Uri pA(Uri uri, ContentValues contentValues) {
        try {
            pA pAVarOg = Og(uri);
            if (pAVarOg != null) {
                return pAVarOg.pA(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, String str, String[] strArr) {
        try {
            pA pAVarOg = Og(uri);
            if (pAVarOg != null) {
                return pAVarOg.pA(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            pA pAVarOg = Og(uri);
            if (pAVarOg != null) {
                return pAVarOg.pA(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
