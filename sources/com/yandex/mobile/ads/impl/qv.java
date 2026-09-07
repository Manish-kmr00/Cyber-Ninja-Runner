package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface qv extends nv {

    public interface a {
        qv a();
    }

    long a(uv uvVar) throws IOException;

    void a(w62 w62Var);

    void close() throws IOException;

    default Map<String, List<String>> getResponseHeaders() {
        return Collections.emptyMap();
    }

    Uri getUri();
}
