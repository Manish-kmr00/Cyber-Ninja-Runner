package com.iab.omid.library.pubnativenet.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2899a;
    protected final InterfaceC0377b b;

    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: com.iab.omid.library.pubnativenet.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0377b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0377b interfaceC0377b) {
        this.b = interfaceC0377b;
    }

    public void a(a aVar) {
        this.f2899a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f2899a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
