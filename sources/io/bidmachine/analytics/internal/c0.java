package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 implements g0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f12080a;

    public c0(e0 e0Var) {
        this.f12080a = e0Var;
    }

    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) throws FileNotFoundException {
        C4638n c4638nA = this.f12080a.a();
        if (c4638nA == null) {
            throw new FileNotFoundException("No data received yet");
        }
        if (c4638nA.e()) {
            throw new FileNotFoundException("Empty data");
        }
        return BytesValue.newBuilder().setValue(ByteString.readFrom(new ByteArrayInputStream(c4638nA.toString().getBytes(Charsets.UTF_8)))).build();
    }
}
