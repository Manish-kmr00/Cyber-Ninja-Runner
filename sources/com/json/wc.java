package com.json;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class wc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4559a;
    private final gb b;
    private final vc c;
    private final pm d;
    private final nf e = mm.S().f();

    class a implements po {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ po f4560a;

        /* JADX INFO: renamed from: com.ironsource.wc$a$a, reason: collision with other inner class name */
        class C0413a extends JSONObject {
            C0413a() throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        a(po poVar) {
            this.f4560a = poVar;
        }

        @Override // com.json.po
        public void a(nh nhVar) {
            this.f4560a.a(nhVar);
            try {
                wc.this.d.a(nhVar.getName(), SafeIronSourceronsourceBridge.com_ironsource_wc$a$a_jsonObjectInit(this));
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.json.po
        public void a(nh nhVar, fh fhVar) {
            this.f4560a.a(nhVar, fhVar);
        }
    }

    public wc(Context context, gb gbVar, vc vcVar, pm pmVar) {
        this.f4559a = context;
        this.b = gbVar;
        this.c = vcVar;
        this.d = pmVar;
    }

    public void a(nh nhVar) throws Exception {
        if (nhVar.exists()) {
            if (!nhVar.delete()) {
                throw new Exception("Failed to delete file");
            }
            this.d.a(nhVar.getName());
        }
    }

    public void a(nh nhVar, String str, int i, int i2, po poVar) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new Exception(uc.a.f4485a);
        }
        if (this.e.a(this.b.a()) <= 0) {
            throw new Exception(d9.A);
        }
        if (!x8.h(this.f4559a)) {
            throw new Exception(d9.C);
        }
        this.c.a(nhVar.getPath(), new a(poVar));
        if (!nhVar.exists()) {
            this.b.a(nhVar, str, i, i2, this.c);
            return;
        }
        Message message = new Message();
        message.obj = nhVar;
        message.what = 1015;
        this.c.sendMessage(message);
    }

    public void a(nh nhVar, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            throw new Exception("Missing attributes to update");
        }
        if (!nhVar.exists()) {
            throw new Exception("File does not exist");
        }
        if (!this.d.b(nhVar.getName(), jSONObject)) {
            throw new Exception("Failed to update attribute");
        }
    }

    public void b(nh nhVar) throws Exception {
        if (nhVar.exists()) {
            ArrayList<nh> filesInFolderRecursive = IronSourceStorageUtils.getFilesInFolderRecursive(nhVar);
            if (!IronSourceStorageUtils.deleteFolderContentRecursive(nhVar) || !nhVar.delete()) {
                throw new Exception("Failed to delete folder");
            }
            this.d.a(filesInFolderRecursive);
        }
    }

    public JSONObject c(nh nhVar) throws Exception {
        if (nhVar.exists()) {
            return IronSourceStorageUtils.buildFilesMapOfDirectory(nhVar, this.d.b());
        }
        throw new Exception("Folder does not exist");
    }

    public long d(nh nhVar) throws Exception {
        if (nhVar.exists()) {
            return IronSourceStorageUtils.getTotalSizeOfDir(nhVar);
        }
        throw new Exception("Folder does not exist");
    }
}
