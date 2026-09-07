package io.ktor.http;

import com.mbridge.msdk.foundation.download.database.DownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationResponseProperties.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {DownloadModel.ETAG, "", "Lio/ktor/http/HeadersBuilder;", "entityTag", "", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ApplicationResponsePropertiesKt {
    public static final void etag(HeadersBuilder headersBuilder, String entityTag) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        Intrinsics.checkNotNullParameter(entityTag, "entityTag");
        headersBuilder.set(HttpHeaders.INSTANCE.getETag(), entityTag);
    }
}
