package com.chartboost.sdk.impl;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class pc extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1109a;
    public final b b;

    public interface a {
        void a(pc pcVar);
    }

    public interface b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public pc(b bVar) {
        this.b = bVar;
    }

    public void a(a aVar) {
        this.f1109a = aVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f1109a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
