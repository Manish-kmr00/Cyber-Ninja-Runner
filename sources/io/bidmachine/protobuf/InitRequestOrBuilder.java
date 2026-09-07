package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.ContextOrBuilder;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;

/* JADX INFO: loaded from: classes12.dex */
public interface InitRequestOrBuilder extends MessageOrBuilder {
    InitRequest.AndroidPlatformData getAndroid();

    InitRequest.AndroidPlatformDataOrBuilder getAndroidOrBuilder();

    String getAppVer();

    ByteString getAppVerBytes();

    String getBmIfv();

    ByteString getBmIfvBytes();

    String getBundle();

    ByteString getBundleBytes();

    Context getContext();

    ContextOrBuilder getContextOrBuilder();

    ConnectionType getContype();

    int getContypeValue();

    DeviceType getDeviceType();

    int getDeviceTypeValue();

    Struct getExt();

    StructOrBuilder getExtOrBuilder();

    Context.Geo getGeo();

    Context.GeoOrBuilder getGeoOrBuilder();

    String getHwv();

    ByteString getHwvBytes();

    String getIfa();

    ByteString getIfaBytes();

    String getIfv();

    ByteString getIfvBytes();

    InitRequest.iOSPlatformData getIos();

    InitRequest.iOSPlatformDataOrBuilder getIosOrBuilder();

    String getMake();

    ByteString getMakeBytes();

    String getModel();

    ByteString getModelBytes();

    OS getOs();

    int getOsValue();

    String getOsv();

    ByteString getOsvBytes();

    InitRequest.PlatformDataCase getPlatformDataCase();

    String getSdk();

    ByteString getSdkBytes();

    String getSdkver();

    ByteString getSdkverBytes();

    String getSellerId();

    ByteString getSellerIdBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasAndroid();

    boolean hasContext();

    boolean hasExt();

    boolean hasGeo();

    boolean hasIos();
}
