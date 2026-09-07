package com.fyber.inneractive.sdk.network;

import android.os.Environment;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.C3284x;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.DTExchangeFilesBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 extends U {
    public final String p;

    public b0(C3284x c3284x, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(c3284x, G.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        String string;
        O o = new O();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                InputStream inputStream = c3136l.c;
                File file = new File(Environment.getExternalStorageDirectory(), "Pictures");
                file.mkdirs();
                String strA = a(URI.create(this.p), map);
                if (TextUtils.isEmpty(strA)) {
                    string = null;
                } else {
                    File file2 = new File(file, strA);
                    string = file2.toString();
                    fileOutputStreamFileOutputStreamCtor = DTExchangeFilesBridge.fileOutputStreamCtor(file2);
                    try {
                        AbstractC3256u.a(inputStream, fileOutputStreamFileOutputStreamCtor);
                        fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                        IAlog.a("failed to download and save the image file.", new Object[0]);
                    } catch (Throwable th) {
                        th = th;
                        AbstractC3256u.b(fileOutputStreamFileOutputStreamCtor);
                        throw th;
                    }
                }
                o.f1911a = string;
            } catch (Exception unused2) {
            }
            AbstractC3256u.b(fileOutputStream);
            return o;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamFileOutputStreamCtor = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return false;
    }

    public static String a(URI uri, Map map) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        String name = new File(path).getName();
        List list = map != null ? (List) map.get("Content-Type") : null;
        String str = list != null ? (String) list.get(0) : null;
        if (str == null) {
            return name;
        }
        for (String str2 : str.split(";")) {
            if (str2.contains("image/")) {
                String str3 = "." + str2.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
                return !name.endsWith(str3) ? name + str3 : name;
            }
        }
        return name;
    }
}
