package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1905a;
    public final com.fyber.inneractive.sdk.cache.a b;
    public SharedPreferences c;

    public D(Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        this.f1905a = context;
        this.b = aVar;
    }

    public final com.fyber.inneractive.sdk.cache.k a() throws Throwable {
        try {
            if (!this.b.d()) {
                new C();
                return new com.fyber.inneractive.sdk.cache.k();
            }
            Object objA = this.b.a(a(this.b.c()));
            if (this.c == null) {
                this.c = this.f1905a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            return new com.fyber.inneractive.sdk.cache.k(objA, this.c.getString(this.b.b(), null));
        } catch (Exception unused) {
            if (this.c == null) {
                this.c = this.f1905a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            this.c.edit().remove(this.b.b()).apply();
            return new com.fyber.inneractive.sdk.cache.k();
        }
    }

    public final String a(String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        IAlog.a("reading local file: %s", str);
        FileInputStream fileInputStream = null;
        str = null;
        str = null;
        String str2 = null;
        try {
            fileInputStreamOpenFileInput = this.f1905a.openFileInput(str);
            try {
                try {
                    byte[] bArr = new byte[fileInputStreamOpenFileInput.available()];
                    fileInputStreamOpenFileInput.read(bArr);
                    String str3 = new String(bArr, "UTF-8");
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e) {
                        IAlog.f("Failed closing local file: %s", e.getMessage());
                    }
                    str2 = str3;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStreamOpenFileInput;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            IAlog.f("Failed closing local file: %s", e2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                if (!(e instanceof FileNotFoundException)) {
                    IAlog.a("Failed reading local file: %s", e.getMessage());
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Exception e4) {
                            IAlog.f("Failed closing local file: %s", e4.getMessage());
                        }
                    }
                } else {
                    throw new FileNotFoundException();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th2) {
            th = th2;
        }
        IAlog.a("local file %s read successfully", str);
        return str2;
    }
}
