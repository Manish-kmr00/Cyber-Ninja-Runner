package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.io.CloseableKt;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C4644u implements g0.a {
    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) throws IOException {
        BytesValue.Builder builderNewBuilder = BytesValue.newBuilder();
        FileInputStream fileInputStream = new FileInputStream(s0.b(aVar.a()));
        try {
            ByteString from = ByteString.readFrom(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return builderNewBuilder.setValue(from).build();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }
}
