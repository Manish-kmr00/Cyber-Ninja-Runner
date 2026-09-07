package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacementOrBuilder;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.protobuf.sdk.AppOrBuilder;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.protobuf.sdk.DeviceOrBuilder;
import io.bidmachine.protobuf.sdk.SDK;
import io.bidmachine.protobuf.sdk.SDKOrBuilder;
import io.bidmachine.protobuf.sdk.User;
import io.bidmachine.protobuf.sdk.UserOrBuilder;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface RequestTokenPayloadOrBuilder extends MessageOrBuilder {
    boolean containsCustomData(String str);

    String getAdType();

    ByteString getAdTypeBytes();

    App getAppData();

    AppOrBuilder getAppDataOrBuilder();

    @Deprecated
    Map<String, String> getCustomData();

    int getCustomDataCount();

    Map<String, String> getCustomDataMap();

    String getCustomDataOrDefault(String str, String str2);

    String getCustomDataOrThrow(String str);

    Device getDeviceData();

    DeviceOrBuilder getDeviceDataOrBuilder();

    Struct getExt();

    StructOrBuilder getExtOrBuilder();

    HeaderBiddingPlacement getHbPlacement();

    HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder();

    SDK getPlacementData();

    SDKOrBuilder getPlacementDataOrBuilder();

    io.bidmachine.protobuf.sdk.Session getSession();

    @Deprecated
    RequestTokenPayload.SessionData getSessionData();

    @Deprecated
    RequestTokenPayload.SessionDataOrBuilder getSessionDataOrBuilder();

    io.bidmachine.protobuf.sdk.SessionOrBuilder getSessionOrBuilder();

    String getTokenHashValue();

    ByteString getTokenHashValueBytes();

    User getUserData();

    UserOrBuilder getUserDataOrBuilder();

    boolean hasAppData();

    boolean hasDeviceData();

    boolean hasExt();

    boolean hasHbPlacement();

    boolean hasPlacementData();

    boolean hasSession();

    @Deprecated
    boolean hasSessionData();

    boolean hasUserData();
}
