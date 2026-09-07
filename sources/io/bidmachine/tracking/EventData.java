package io.bidmachine.tracking;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import io.bidmachine.utils.ProtoUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class EventData {
    private Struct.Builder customParamsBuilder;
    private String networkName;
    private Double price;

    public String getNetworkName() {
        return this.networkName;
    }

    public EventData setNetworkName(String str) {
        this.networkName = str;
        return this;
    }

    public Double getPrice() {
        return this.price;
    }

    public EventData setPrice(Double d) {
        this.price = d;
        return this;
    }

    public Struct getCustomParams() {
        Struct.Builder builder = this.customParamsBuilder;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    public EventData setCustomParams(Map<String, Object> map) {
        this.customParamsBuilder = ProtoUtils.toStructBuilderOrNull(map);
        return this;
    }

    public EventData setCustomParam(String str, String str2) {
        if (this.customParamsBuilder == null) {
            this.customParamsBuilder = Struct.newBuilder();
        }
        this.customParamsBuilder.putFields(str, Value.newBuilder().setStringValue(str2).build());
        return this;
    }

    public EventData setCustomParam(String str, double d) {
        if (this.customParamsBuilder == null) {
            this.customParamsBuilder = Struct.newBuilder();
        }
        this.customParamsBuilder.putFields(str, Value.newBuilder().setNumberValue(d).build());
        return this;
    }

    public EventData setCustomParam(String str, boolean z) {
        if (this.customParamsBuilder == null) {
            this.customParamsBuilder = Struct.newBuilder();
        }
        this.customParamsBuilder.putFields(str, Value.newBuilder().setBoolValue(z).build());
        return this;
    }
}
