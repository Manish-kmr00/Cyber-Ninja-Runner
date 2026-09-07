package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;

/* JADX INFO: loaded from: classes11.dex */
public interface ExtrasOrBuilder extends MessageOrBuilder {
    Struct getInternal();

    StructOrBuilder getInternalOrBuilder();

    Struct getPrivate();

    StructOrBuilder getPrivateOrBuilder();

    Struct getPublic();

    StructOrBuilder getPublicOrBuilder();

    boolean hasInternal();

    boolean hasPrivate();

    boolean hasPublic();
}
