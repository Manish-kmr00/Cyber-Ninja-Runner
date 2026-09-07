package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public interface DeviceOrBuilder extends MessageOrBuilder {
    String getAccess();

    ByteString getAccessBytes();

    boolean getAirplane();

    int getApilevel();

    int getAtts();

    com.explorestack.protobuf.adcom.Context.Device.AudioContext getAudioContext();

    com.explorestack.protobuf.adcom.Context.Device.AudioContextOrBuilder getAudioContextOrBuilder();

    float getBatterylevel();

    boolean getBatterysaver();

    String getBmIfv();

    ByteString getBmIfvBytes();

    boolean getCharging();

    com.explorestack.protobuf.adcom.Context.Device.Connection getConnection();

    com.explorestack.protobuf.adcom.Context.Device.ConnectionOrBuilder getConnectionOrBuilder();

    String getCpuname();

    ByteString getCpunameBytes();

    String getCpuvendor();

    ByteString getCpuvendorBytes();

    boolean getDarkmode();

    String getDevicename();

    ByteString getDevicenameBytes();

    long getDiskspace();

    boolean getDnd();

    long getFreemem();

    String getGpuname();

    ByteString getGpunameBytes();

    String getGpuvendor();

    ByteString getGpuvendorBytes();

    boolean getHeadset();

    String getHeadsetname();

    ByteString getHeadsetnameBytes();

    String getIfv();

    ByteString getIfvBytes();

    String getInputlanguage(int i);

    ByteString getInputlanguageBytes(int i);

    int getInputlanguageCount();

    List<String> getInputlanguageList();

    boolean getJailbreak();

    long getLastbootup();

    boolean getRingmute();

    float getScreenbright();

    long getTime();

    String getTimezone();

    ByteString getTimezoneBytes();

    long getTotaldisk();

    long getTotalmem();

    boolean hasAudioContext();

    boolean hasConnection();
}
