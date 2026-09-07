package com.smaato.sdk.core.network;

import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Response implements Closeable {

    public interface Body {
        long contentLength();

        InputStream source();
    }

    public static abstract class Builder {
        public abstract Builder body(Body body);

        public abstract Response build();

        public abstract Builder connection(HttpURLConnection httpURLConnection);

        public abstract Builder encoding(String str);

        public abstract Builder headers(Headers headers);

        public abstract Builder mimeType(MimeType mimeType);

        public abstract Builder request(Request request);

        public abstract Builder responseCode(int i);
    }

    public abstract Body body();

    abstract HttpURLConnection connection();

    public abstract String encoding();

    public abstract Headers headers();

    public abstract MimeType mimeType();

    public abstract Request request();

    public abstract int responseCode();

    public static Builder builder() {
        return new AutoValue_Response.Builder().headers(Headers.of(Collections.emptyMap()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SmaatoNetworkBridge.httpUrlConnectionDisconnect(connection());
    }

    public boolean isRedirect() {
        int iResponseCode = responseCode();
        if (iResponseCode == 307 || iResponseCode == 308) {
            String strMethod = request().method();
            return "GET".equalsIgnoreCase(strMethod) || "HEAD".equalsIgnoreCase(strMethod);
        }
        switch (iResponseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public Builder buildUpon() {
        return builder().request(request()).responseCode(responseCode()).headers(headers()).mimeType(mimeType()).body(body()).encoding(encoding()).connection(connection());
    }
}
