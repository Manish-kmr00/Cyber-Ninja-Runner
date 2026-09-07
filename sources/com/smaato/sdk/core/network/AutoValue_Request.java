package com.smaato.sdk.core.network;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_Request extends Request {
    private final Request.Body body;
    private final boolean followRedirects;
    private final Headers headers;
    private final String method;
    private final Uri uri;

    private AutoValue_Request(Uri uri, String str, Headers headers, Request.Body body, boolean z) {
        this.uri = uri;
        this.method = str;
        this.headers = headers;
        this.body = body;
        this.followRedirects = z;
    }

    @Override // com.smaato.sdk.core.network.Request
    public Uri uri() {
        return this.uri;
    }

    @Override // com.smaato.sdk.core.network.Request
    public String method() {
        return this.method;
    }

    @Override // com.smaato.sdk.core.network.Request
    public Headers headers() {
        return this.headers;
    }

    @Override // com.smaato.sdk.core.network.Request
    public Request.Body body() {
        return this.body;
    }

    @Override // com.smaato.sdk.core.network.Request
    boolean followRedirects() {
        return this.followRedirects;
    }

    public String toString() {
        return "Request{uri=" + this.uri + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", followRedirects=" + this.followRedirects + "}";
    }

    public boolean equals(Object obj) {
        Request.Body body;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return this.uri.equals(request.uri()) && this.method.equals(request.method()) && this.headers.equals(request.headers()) && ((body = this.body) != null ? body.equals(request.body()) : request.body() == null) && this.followRedirects == request.followRedirects();
    }

    public int hashCode() {
        int iHashCode = (((((this.uri.hashCode() ^ 1000003) * 1000003) ^ this.method.hashCode()) * 1000003) ^ this.headers.hashCode()) * 1000003;
        Request.Body body = this.body;
        return ((iHashCode ^ (body == null ? 0 : body.hashCode())) * 1000003) ^ (this.followRedirects ? 1231 : 1237);
    }

    static final class Builder extends Request.Builder {
        private Request.Body body;
        private Boolean followRedirects;
        private Headers headers;
        private String method;
        private Uri uri;

        Builder() {
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request.Builder uri(Uri uri) {
            if (uri == null) {
                throw new NullPointerException("Null uri");
            }
            this.uri = uri;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request.Builder method(String str) {
            if (str == null) {
                throw new NullPointerException("Null method");
            }
            this.method = str;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request.Builder headers(Headers headers) {
            if (headers == null) {
                throw new NullPointerException("Null headers");
            }
            this.headers = headers;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request.Builder body(Request.Body body) {
            this.body = body;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request.Builder followRedirects(boolean z) {
            this.followRedirects = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.core.network.Request.Builder
        public Request build() {
            String str;
            if (this.uri != null) {
                str = "";
            } else {
                str = " uri";
            }
            if (this.method == null) {
                str = str + " method";
            }
            if (this.headers == null) {
                str = str + " headers";
            }
            if (this.followRedirects == null) {
                str = str + " followRedirects";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_Request(this.uri, this.method, this.headers, this.body, this.followRedirects.booleanValue());
        }
    }
}
