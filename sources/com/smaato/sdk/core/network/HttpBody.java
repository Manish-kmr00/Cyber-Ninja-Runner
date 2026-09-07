package com.smaato.sdk.core.network;

import java.io.InputStream;

/* JADX INFO: loaded from: classes9.dex */
abstract class HttpBody implements Response.Body {
    HttpBody() {
    }

    static Builder builder() {
        return new AutoValue_HttpBody.Builder();
    }

    static abstract class Builder {
        abstract HttpBody build();

        abstract Builder contentLength(long j);

        abstract Builder source(InputStream inputStream);

        Builder() {
        }
    }
}
