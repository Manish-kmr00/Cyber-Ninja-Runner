package com.json;

import android.os.Handler;
import android.os.Message;
import com.json.sdk.utils.IronSourceStorageUtils;

/* JADX INFO: loaded from: classes9.dex */
class pt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f4169a;
    private final db b;

    pt(db dbVar, Handler handler) {
        this.b = dbVar;
        this.f4169a = handler;
    }

    Message a() {
        return new Message();
    }

    yc a(db dbVar, String str, long j) {
        return new yc(dbVar, str, j);
    }

    String a(String str) {
        return IronSourceStorageUtils.makeDir(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        int iB;
        nh nhVar = new nh(this.b.b().getParent(), this.b.b().getName());
        Message messageA = a();
        messageA.obj = nhVar;
        String strA = a(nhVar.getParent());
        if (strA == null) {
            iB = 1020;
        } else {
            eb ebVarA = a(new db(nhVar, this.b.e(), this.b.a(), this.b.c(), this.b.f(), this.b.d()), strA, 3L).call();
            iB = ebVarA.b() == 200 ? 1016 : ebVarA.b();
        }
        messageA.what = iB;
        this.f4169a.sendMessage(messageA);
    }
}
