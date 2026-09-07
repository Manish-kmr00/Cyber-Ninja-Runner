package io.appmetrica.analytics.network.internal;

import android.text.TextUtils;
import io.appmetrica.analytics.network.impl.e;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11932a;
    private final String b;
    private final byte[] c;
    private final Map d;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11933a;
        private String b;
        private byte[] c = new byte[0];
        private final HashMap d = new HashMap();

        public Builder(String str) {
            this.f11933a = str;
        }

        public Builder addHeader(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this.f11933a, this.b, this.c, this.d, 0);
        }

        public Builder post(byte[] bArr) {
            this.c = bArr;
            return withMethod("POST");
        }

        public Builder withMethod(String str) {
            this.b = str;
            return this;
        }
    }

    /* synthetic */ Request(String str, String str2, byte[] bArr, HashMap map, int i) {
        this(str, str2, bArr, map);
    }

    public byte[] getBody() {
        return this.c;
    }

    public Map<String, String> getHeaders() {
        return this.d;
    }

    public String getMethod() {
        return this.b;
    }

    public String getUrl() {
        return this.f11932a;
    }

    public String toString() {
        return "Request{url=" + this.f11932a + ", method='" + this.b + "', bodyLength=" + this.c.length + ", headers=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    private Request(String str, String str2, byte[] bArr, HashMap map) {
        this.f11932a = str;
        this.b = TextUtils.isEmpty(str2) ? "GET" : str2;
        this.c = bArr;
        this.d = e.a(map);
    }
}
