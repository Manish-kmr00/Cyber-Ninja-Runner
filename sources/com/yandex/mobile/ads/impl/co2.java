package com.yandex.mobile.ads.impl;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public abstract class co2 extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8630a;
    protected final b b;

    public interface a {
    }

    public interface b {
    }

    public co2(b bVar) {
        this.b = bVar;
    }

    public final void a(a aVar) {
        this.f8630a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f8630a;
        if (aVar != null) {
            ((go2) aVar).a();
        }
    }

    public final void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
