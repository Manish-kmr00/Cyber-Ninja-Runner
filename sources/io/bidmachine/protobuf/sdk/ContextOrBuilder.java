package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface ContextOrBuilder extends MessageOrBuilder {
    App getApp();

    AppOrBuilder getAppOrBuilder();

    Device getDevice();

    DeviceOrBuilder getDeviceOrBuilder();

    SDK getSdk();

    SDKOrBuilder getSdkOrBuilder();

    Session getSession();

    SessionOrBuilder getSessionOrBuilder();

    User getUser();

    UserOrBuilder getUserOrBuilder();

    boolean hasApp();

    boolean hasDevice();

    boolean hasSdk();

    boolean hasSession();

    boolean hasUser();
}
