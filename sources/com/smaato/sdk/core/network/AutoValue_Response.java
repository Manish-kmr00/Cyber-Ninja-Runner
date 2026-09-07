package com.smaato.sdk.core.network;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Response extends Response {
    private final Response.Body body;
    private final HttpURLConnection connection;
    private final String encoding;
    private final Headers headers;
    private final MimeType mimeType;
    private final Request request;
    private final int responseCode;

    private AutoValue_Response(Request request, int i, Headers headers, MimeType mimeType, Response.Body body, String str, HttpURLConnection httpURLConnection) {
        this.request = request;
        this.responseCode = i;
        this.headers = headers;
        this.mimeType = mimeType;
        this.body = body;
        this.encoding = str;
        this.connection = httpURLConnection;
    }

    @Override // com.smaato.sdk.core.network.Response
    public Request request() {
        return this.request;
    }

    @Override // com.smaato.sdk.core.network.Response
    public int responseCode() {
        return this.responseCode;
    }

    @Override // com.smaato.sdk.core.network.Response
    public Headers headers() {
        return this.headers;
    }

    @Override // com.smaato.sdk.core.network.Response
    public MimeType mimeType() {
        return this.mimeType;
    }

    @Override // com.smaato.sdk.core.network.Response
    public Response.Body body() {
        return this.body;
    }

    @Override // com.smaato.sdk.core.network.Response
    public String encoding() {
        return this.encoding;
    }

    @Override // com.smaato.sdk.core.network.Response
    HttpURLConnection connection() {
        return this.connection;
    }

    public String toString() {
        return "Response{request=" + this.request + ", responseCode=" + this.responseCode + ", headers=" + this.headers + ", mimeType=" + this.mimeType + ", body=" + this.body + ", encoding=" + this.encoding + ", connection=" + this.connection + "}";
    }

    public boolean equals(Object obj) {
        MimeType mimeType;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return this.request.equals(response.request()) && this.responseCode == response.responseCode() && this.headers.equals(response.headers()) && ((mimeType = this.mimeType) != null ? mimeType.equals(response.mimeType()) : response.mimeType() == null) && this.body.equals(response.body()) && ((str = this.encoding) != null ? str.equals(response.encoding()) : response.encoding() == null) && this.connection.equals(response.connection());
    }

    public int hashCode() {
        int iHashCode = (((((this.request.hashCode() ^ 1000003) * 1000003) ^ this.responseCode) * 1000003) ^ this.headers.hashCode()) * 1000003;
        MimeType mimeType = this.mimeType;
        int iHashCode2 = (((iHashCode ^ (mimeType == null ? 0 : mimeType.hashCode())) * 1000003) ^ this.body.hashCode()) * 1000003;
        String str = this.encoding;
        return ((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.connection.hashCode();
    }

    static final class Builder extends Response.Builder {
        private Response.Body body;
        private HttpURLConnection connection;
        private String encoding;
        private Headers headers;
        private MimeType mimeType;
        private Request request;
        private Integer responseCode;

        Builder() {
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder request(Request request) {
            if (request == null) {
                throw new NullPointerException("Null request");
            }
            this.request = request;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder responseCode(int i) {
            this.responseCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder headers(Headers headers) {
            if (headers == null) {
                throw new NullPointerException("Null headers");
            }
            this.headers = headers;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder mimeType(MimeType mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder body(Response.Body body) {
            if (body == null) {
                throw new NullPointerException("Null body");
            }
            this.body = body;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder encoding(String str) {
            this.encoding = str;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response.Builder connection(HttpURLConnection httpURLConnection) {
            if (httpURLConnection == null) {
                throw new NullPointerException("Null connection");
            }
            this.connection = httpURLConnection;
            return this;
        }

        @Override // com.smaato.sdk.core.network.Response.Builder
        public Response build() {
            String str;
            if (this.request != null) {
                str = "";
            } else {
                str = " request";
            }
            if (this.responseCode == null) {
                str = str + " responseCode";
            }
            if (this.headers == null) {
                str = str + " headers";
            }
            if (this.body == null) {
                str = str + " body";
            }
            if (this.connection == null) {
                str = str + " connection";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_Response(this.request, this.responseCode.intValue(), this.headers, this.mimeType, this.body, this.encoding, this.connection);
        }
    }
}
