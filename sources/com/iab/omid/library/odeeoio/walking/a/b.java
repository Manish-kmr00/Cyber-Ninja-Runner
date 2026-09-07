package com.iab.omid.library.odeeoio.walking.a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2791a;
    protected final InterfaceC0365b d;

    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: com.iab.omid.library.odeeoio.walking.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0365b {
        void a(JSONObject jSONObject);

        JSONObject b();
    }

    public b(InterfaceC0365b interfaceC0365b) {
        this.d = interfaceC0365b;
    }

    public void a(a aVar) {
        this.f2791a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f2791a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
