package com.bykv.vk.openvk.preload.geckox.e;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: VersionedResLoader.java */
/* JADX INFO: loaded from: classes11.dex */
public final class b {
    private String b;
    private String d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f934a = new HashMap();
    private AtomicBoolean c = new AtomicBoolean(false);

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        this.b = str;
        if (file == null) {
            this.d = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
        } else {
            this.d = new File(file, str).getAbsolutePath();
        }
    }

    public final String a() {
        return this.d;
    }

    public final InputStream a(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final int b(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final boolean c(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }

    private a d(String str) {
        a aVar;
        int iIndexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
        if (iIndexOf == -1) {
            new RuntimeException("channel：".concat(String.valueOf(str)));
        }
        String strSubstring = str.substring(0, iIndexOf);
        synchronized (this.f934a) {
            aVar = this.f934a.get(strSubstring);
            if (aVar == null) {
                aVar = new a(this.d, strSubstring);
                this.f934a.put(strSubstring, aVar);
            }
        }
        return aVar;
    }

    public final Map<String, Long> b() {
        HashMap map = new HashMap();
        synchronized (this.f934a) {
            Collection<a> collectionValues = this.f934a.values();
            if (collectionValues == null) {
                return map;
            }
            for (a aVar : collectionValues) {
                map.put(aVar.b(), aVar.a());
            }
            return map;
        }
    }

    public final void c() throws Exception {
        if (this.c.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.f934a) {
            Iterator<a> it = this.f934a.values().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f934a.clear();
        }
    }
}
