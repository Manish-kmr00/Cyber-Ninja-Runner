package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.io.CloseableKt;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C4648y implements g0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f12181a;

    public C4648y(File file) {
        this.f12181a = file;
    }

    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) throws IOException {
        BytesValue.Builder builderNewBuilder = BytesValue.newBuilder();
        FileInputStream fileInputStream = new FileInputStream(new File(this.f12181a, s0.b(aVar.a())));
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
