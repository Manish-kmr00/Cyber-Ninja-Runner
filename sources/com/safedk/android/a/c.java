package com.safedk.android.a;

import android.os.Bundle;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class c extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    FileUploadManager.b f7948a;
    String b;
    String c;

    public c(String str, int i, FileUploadManager.b bVar, String str2) {
        super(null, str, i);
        this.b = null;
        this.c = "GcsUploadFile";
        this.f7948a = bVar;
        this.b = str2;
        Logger.d(this.c, "GcsUploadFile object created for File upload, hash=" + str + ", params =" + bVar.toString());
    }

    public c(String str, String str2, int i, FileUploadManager.b bVar) {
        super(str, str2, i);
        this.b = null;
        this.c = "GcsUploadFile";
        this.f7948a = bVar;
        Logger.d(this.c, "GcsUploadFile object created, File path=" + str + ", hash=" + str2 + ", params =" + bVar.toString());
    }

    @Override // com.safedk.android.a.g
    public g.a a() throws IOException {
        if (this.j == null) {
            Logger.d(this.c, "File to upload is null");
            return null;
        }
        File file = new File(this.j);
        if (!file.exists()) {
            Logger.d(this.c, "File to upload not found " + this.j);
            return null;
        }
        String strD = this.f7948a.d();
        Logger.d(this.c, "About to upload File to " + strD + ", prefix=" + this.f7948a.a() + ", File path: " + this.j);
        Bundle bundleC = this.f7948a.c();
        n.b(this.c, "Uploading File with headers: " + bundleC);
        HashMap map = new HashMap();
        for (String str : bundleC.keySet()) {
            Logger.d(this.c, "adding field key: " + str + " with value: " + bundleC.getString(str));
            map.put(str, bundleC.getString(str));
        }
        d dVar = new d(g.f, strD, "UTF-8", this.i, map);
        dVar.a("file", file, false);
        dVar.a();
        String str2 = this.f7948a.a() + this.f7948a.b();
        Logger.d(this.c, "File uploaded successfully to GCS");
        return new g.a(str2, dVar.b(), this.k);
    }

    public g.a b() throws IOException {
        String strD = this.f7948a.d();
        Logger.d(this.c, "About to upload File to " + strD + ", prefix=" + this.f7948a.a());
        Bundle bundleC = this.f7948a.c();
        n.b(this.c, "Uploading File with headers: " + bundleC);
        HashMap map = new HashMap();
        for (String str : bundleC.keySet()) {
            Logger.d(this.c, "adding field key: " + str + " with value: " + bundleC.getString(str));
            map.put(str, bundleC.getString(str));
        }
        d dVar = new d(g.f, strD, "UTF-8", this.i, map);
        a(dVar);
        dVar.a();
        Logger.d(this.c, "File uploaded successfully to GCS");
        return new g.a(strD, dVar.b(), this.k);
    }

    public void a(d dVar) throws IOException {
        File fileCreateTempFile = null;
        try {
            fileCreateTempFile = File.createTempFile("file", ".gz");
            Logger.d(this.c, "created temp file in: " + fileCreateTempFile.getAbsolutePath());
            new FileOutputStream(fileCreateTempFile).write(this.b.getBytes("UTF-8"));
            dVar.a(fileCreateTempFile);
        } catch (IOException e) {
            Logger.d(this.c, "Error adding gzip file: " + e);
        } finally {
            if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                fileCreateTempFile.delete();
            }
        }
    }
}
