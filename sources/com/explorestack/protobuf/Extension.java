package com.explorestack.protobuf;

import com.explorestack.protobuf.MessageLite;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    protected enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    protected abstract Object fromReflectionType(Object obj);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    protected abstract ExtensionType getExtensionType();

    @Override // com.explorestack.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    @Override // com.explorestack.protobuf.ExtensionLite
    final boolean isLite() {
        return false;
    }

    protected abstract Object singularFromReflectionType(Object obj);

    protected abstract Object singularToReflectionType(Object obj);

    protected abstract Object toReflectionType(Object obj);

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
