package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.ContextOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface InitRequestV2OrBuilder extends MessageOrBuilder {
    Context getContext();

    ContextOrBuilder getContextOrBuilder();

    Struct getExt();

    StructOrBuilder getExtOrBuilder();

    boolean hasContext();

    boolean hasExt();
}
