package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: H5DownLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static d h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f5963a;
    private ConcurrentMap<String, Object> b;
    private i c;
    private f d;
    private boolean e;
    private final String f = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private final String g = "down_type";

    private d() {
        this.e = false;
        try {
            this.c = i.a();
            this.d = f.a();
            this.f5963a = new CopyOnWriteArrayList<>();
            this.b = new ConcurrentHashMap();
            com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD != null) {
                this.e = gVarD.b(1);
            }
        } catch (Throwable th) {
            o0.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized d a() {
        if (h == null) {
            h = new d();
        }
        return h;
    }

    private String b(String str) {
        f fVar = this.d;
        return fVar != null ? fVar.b(str) : str;
    }

    public String c(String str) {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    public String a(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri uri = Uri.parse(str);
                String path = uri.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return c(str);
                }
                return b(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
