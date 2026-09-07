package com.smaato.sdk.core.network;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_HttpBody extends HttpBody {
    private final long contentLength;
    private final InputStream source;

    private AutoValue_HttpBody(InputStream inputStream, long j) {
        this.source = inputStream;
        this.contentLength = j;
    }

    @Override // com.smaato.sdk.core.network.Response.Body
    public InputStream source() {
        return this.source;
    }

    @Override // com.smaato.sdk.core.network.Response.Body
    public long contentLength() {
        return this.contentLength;
    }

    public String toString() {
        return "HttpBody{source=" + this.source + ", contentLength=" + this.contentLength + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpBody)) {
            return false;
        }
        HttpBody httpBody = (HttpBody) obj;
        return this.source.equals(httpBody.source()) && this.contentLength == httpBody.contentLength();
    }

    public int hashCode() {
        int iHashCode = (this.source.hashCode() ^ 1000003) * 1000003;
        long j = this.contentLength;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    static final class Builder extends HttpBody.Builder {
        private Long contentLength;
        private InputStream source;

        Builder() {
        }

        @Override // com.smaato.sdk.core.network.HttpBody.Builder
        HttpBody.Builder source(InputStream inputStream) {
            if (inputStream == null) {
                throw new NullPointerException("Null source");
            }
            this.source = inputStream;
            return this;
        }

        @Override // com.smaato.sdk.core.network.HttpBody.Builder
        HttpBody.Builder contentLength(long j) {
            this.contentLength = Long.valueOf(j);
            return this;
        }

        @Override // com.smaato.sdk.core.network.HttpBody.Builder
        HttpBody build() {
            String str;
            if (this.source != null) {
                str = "";
            } else {
                str = " source";
            }
            if (this.contentLength == null) {
                str = str + " contentLength";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_HttpBody(this.source, this.contentLength.longValue());
        }
    }
}
