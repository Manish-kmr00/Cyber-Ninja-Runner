package com.fyber.inneractive.sdk.network;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class V extends U {
    public final Context p;
    public final com.fyber.inneractive.sdk.cache.a q;
    public D r;

    public V(E e, Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        super(e, G.c.a(), null);
        this.p = context;
        this.q = aVar;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public O a(C3136l c3136l, Map map, int i) throws Exception {
        O o = new O();
        try {
            String string = AbstractC3256u.a(c3136l.c).toString();
            o.f1911a = this.q.a(string);
            o.b = string;
            return o;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            if (e instanceof InvalidAppIdException) {
                throw e;
            }
            throw new N(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String f() {
        return this.q.c();
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final C3125a g() throws Throwable {
        D d = new D(this.p, this.q);
        this.r = d;
        com.fyber.inneractive.sdk.cache.k kVarA = d.a();
        String str = kVarA.b;
        Object obj = kVarA.f1642a;
        this.q.c();
        return new C3125a(obj, str);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.q.a();
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void a(O o, String str, String str2) {
        boolean z;
        D d = this.r;
        if (d != null) {
            if (d.c == null) {
                d.c = d.f1905a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            d.c.edit().putString(d.b.b(), str2).apply();
            if (o == null || o.b.isEmpty() || str.isEmpty()) {
                return;
            }
            D d2 = this.r;
            String str3 = o.b;
            d2.getClass();
            IAlog.a("caching file %s", str);
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    fileOutputStreamOpenFileOutput = d2.f1905a.openFileOutput(str, 0);
                    fileOutputStreamOpenFileOutput.write(str3.getBytes());
                    z = true;
                    try {
                        IAlog.a("File cached successfully", new Object[0]);
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (Exception e) {
                            IAlog.f("Failed closing cache file: %s", e.getMessage());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        IAlog.f("Failed caching file: %s", e.getMessage());
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (Exception e3) {
                                IAlog.f("Failed closing cache file: %s", e3.getMessage());
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
                if (!z) {
                    IAlog.b("Failed to cache file", new Object[0]);
                } else {
                    this.q.a(o.f1911a);
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e5) {
                        IAlog.f("Failed closing cache file: %s", e5.getMessage());
                    }
                }
                throw th;
            }
        }
    }
}
