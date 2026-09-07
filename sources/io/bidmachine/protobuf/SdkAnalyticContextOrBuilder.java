package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SdkAnalyticContextOrBuilder extends MessageOrBuilder {
    String getAppVer();

    ByteString getAppVerBytes();

    String getBmIfv();

    ByteString getBmIfvBytes();

    String getBundle();

    ByteString getBundleBytes();

    ConnectionType getContype();

    int getContypeValue();

    String getDcid();

    ByteString getDcidBytes();

    DeviceType getDeviceType();

    int getDeviceTypeValue();

    String getExperiments(int i);

    ByteString getExperimentsBytes(int i);

    int getExperimentsCount();

    List<String> getExperimentsList();

    Struct getExt();

    StructOrBuilder getExtOrBuilder();

    Context.Geo getGeo();

    Context.GeoOrBuilder getGeoOrBuilder();

    String getIfa();

    ByteString getIfaBytes();

    String getIfv();

    ByteString getIfvBytes();

    OS getOs();

    int getOsValue();

    String getOsv();

    ByteString getOsvBytes();

    String getSdk();

    ByteString getSdkBytes();

    String getSdkver();

    ByteString getSdkverBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getSourceId();

    ByteString getSourceIdBytes();

    boolean hasExt();

    boolean hasGeo();
}
