package com.safedk.android.a;

import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.safedk.android.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7949a = "MultipartUtility";
    private static final String c = "\r\n";
    private final String b;
    private final f d;
    private final String e;
    private final OutputStream f;
    private final PrintWriter g;
    private int h = 0;

    public d(String str, String str2, String str3, int i, Map<String, String> map) throws IOException {
        Logger.d(f7949a, "ctor started, requestURL = " + str2);
        this.e = str3;
        this.b = "BOUNDARY-BOUNDARY" + System.currentTimeMillis() + "BOUNDARY";
        this.d = new f(new URL(str2).openConnection());
        this.d.a(str);
        this.d.a(false);
        this.d.b(true);
        this.d.d(true);
        this.d.a("Content-Type", "multipart/form-data; boundary=" + this.b);
        this.d.a("User-Agent", "AppLovinQualityService/5.10.0 (Android " + Build.VERSION.RELEASE + ")");
        this.d.a(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate");
        this.d.a("Connection", "close");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.d.a(entry.getKey(), entry.getValue());
        }
        this.d.a(i);
        this.d.b(i);
        this.f = this.d.a();
        this.g = new PrintWriter((Writer) new OutputStreamWriter(this.f, str3), true);
    }

    public void a(String str, String str2) {
        this.g.append((CharSequence) "--").append((CharSequence) this.b).append((CharSequence) c);
        this.g.append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) str).append((CharSequence) "\"").append((CharSequence) c);
        this.g.append((CharSequence) "Content-Type: text/plain; charset=").append((CharSequence) this.e).append((CharSequence) c);
        this.g.append((CharSequence) c);
        this.g.append((CharSequence) str2).append((CharSequence) c);
        this.g.flush();
    }

    public void a(String str, File file, boolean z) throws IOException {
        String name = file.getName();
        if (z) {
            this.g.append((CharSequence) "--").append((CharSequence) this.b).append((CharSequence) c);
            this.g.append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) str).append((CharSequence) "\"; filename=\"").append((CharSequence) name).append((CharSequence) "\"").append((CharSequence) c);
            this.g.append((CharSequence) "Content-Type: application/octet-stream").append((CharSequence) c);
            this.g.append((CharSequence) c);
        }
        this.g.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i != -1) {
                this.f.write(bArr, 0, i);
            } else {
                this.f.flush();
                fileInputStream.close();
                this.g.append((CharSequence) c);
                this.g.flush();
                return;
            }
        }
    }

    public void a(File file) throws IOException {
        this.g.flush();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(this.f);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                fileInputStream.close();
                this.g.append((CharSequence) c);
                this.g.flush();
                return;
            }
        }
    }

    public void b(String str, String str2) {
        this.g.append((CharSequence) str).append((CharSequence) ": ").append((CharSequence) str2).append((CharSequence) c);
        this.g.flush();
    }

    public List<String> a() throws IOException {
        Logger.d(f7949a, "finish started");
        ArrayList arrayList = new ArrayList();
        this.g.append((CharSequence) c).flush();
        this.g.append((CharSequence) "--").append((CharSequence) this.b).append((CharSequence) "--").append((CharSequence) c);
        this.g.close();
        this.h = this.d.b();
        Logger.d(f7949a, "Response code = " + this.h);
        if (this.h < 200 || this.h >= 300) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.d.g()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    Logger.e(f7949a, "Error message: " + ((Object) sb));
                    throw new IOException("Server returned non-OK status: " + this.h);
                }
            }
        } else {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.d.e()));
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 != null) {
                    arrayList.add(line2);
                } else {
                    bufferedReader2.close();
                    this.d.d();
                    return arrayList;
                }
            }
        }
    }

    public int b() {
        return this.h;
    }
}
