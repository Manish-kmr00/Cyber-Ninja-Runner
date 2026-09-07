package com.safedk.android.a;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.utils.Logger;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    FileUploadManager.a f7946a;

    public a(String str, String str2, int i, FileUploadManager.a aVar) {
        super(str, str2, i);
        this.f7946a = aVar;
        this.d = "AwsS3UploadFile";
        Logger.d(this.d, "AwsS3UploadFile object created, File path=" + str + ", hash=" + str2 + ", params =" + aVar.toString());
    }

    @Override // com.safedk.android.a.g
    public g.a a() throws IOException {
        if (this.j == null) {
            Logger.d(this.d, "File to upload is null");
            return null;
        }
        String str = this.f7946a.f() + RemoteSettings.FORWARD_SLASH_STRING;
        Logger.d(this.d, "About to upload File to " + str + ", prefix=" + this.f7946a.d() + ",File path: " + this.j);
        d dVar = new d("POST", str, "UTF-8", this.i, new HashMap());
        File file = new File(this.j);
        if (!file.exists()) {
            Logger.d(this.d, "File file to upload not found " + this.j);
            return null;
        }
        dVar.a("key", this.f7946a.d() + RemoteSettings.FORWARD_SLASH_STRING + this.k + ".jpg");
        dVar.a("AWSAccessKeyId", this.f7946a.a());
        dVar.a("acl", this.f7946a.g());
        dVar.a("Content-Type", this.f7946a.l());
        dVar.a("policy", this.f7946a.b());
        dVar.a(InAppPurchaseMetaData.KEY_SIGNATURE, this.f7946a.c());
        dVar.a("x-amz-server-side-encryption", this.f7946a.j());
        dVar.a("X-Amz-Credential", this.f7946a.k());
        dVar.a("X-Amz-Algorithm", this.f7946a.h());
        dVar.a("X-Amz-Date", this.f7946a.i());
        dVar.a("file", file, true);
        dVar.a();
        String str2 = this.f7946a.f() + RemoteSettings.FORWARD_SLASH_STRING + this.f7946a.d() + RemoteSettings.FORWARD_SLASH_STRING + this.k + ".jpg";
        Logger.d(this.d, "File uploaded successfully to AWS");
        return new g.a(str2, dVar.b(), this.k);
    }
}
