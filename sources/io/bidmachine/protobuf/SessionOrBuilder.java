package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public interface SessionOrBuilder extends MessageOrBuilder {
    String getId();

    ByteString getIdBytes();

    long getUptime();
}
