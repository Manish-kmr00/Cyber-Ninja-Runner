package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.adcom.ConnectionType;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.utils.DeviceUtils;

/* JADX INFO: loaded from: classes6.dex */
final class DeviceConnectionParams {
    DeviceConnectionParams() {
    }

    void build(Context context, com.explorestack.protobuf.adcom.Context.Device.Builder builder, ConnectionType connectionType) {
        builder.setConnection(buildConnection(context, connectionType));
    }

    void build(Context context, Device.Builder builder, ConnectionType connectionType) {
        builder.setConnection(buildConnection(context, connectionType));
    }

    private com.explorestack.protobuf.adcom.Context.Device.Connection buildConnection(Context context, ConnectionType connectionType) {
        com.explorestack.protobuf.adcom.Context.Device.Connection.Builder builderNewBuilder = com.explorestack.protobuf.adcom.Context.Device.Connection.newBuilder();
        builderNewBuilder.setType(connectionType);
        builderNewBuilder.setVpn(DeviceUtils.getVpnStatus(context));
        builderNewBuilder.setProxy(DeviceUtils.getProxyStatus(context));
        return builderNewBuilder.build();
    }
}
