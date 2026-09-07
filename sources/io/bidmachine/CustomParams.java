package io.bidmachine;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import io.bidmachine.models.ICustomParams;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class CustomParams implements ICustomParams<CustomParams> {
    private final Map<String, String> customMap = new HashMap();

    @Override // io.bidmachine.models.ICustomParams
    public /* bridge */ /* synthetic */ CustomParams addParams(Map map) {
        return addParams((Map<String, String>) map);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String str, String str2) {
        this.customMap.put(str, str2);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParams(Map<String, String> map) {
        this.customMap.putAll(map);
        return this;
    }

    void fillStructBuilder(Struct.Builder builder) {
        for (Map.Entry<String, String> entry : this.customMap.entrySet()) {
            builder.putFields(entry.getKey(), Value.newBuilder().setStringValue(entry.getValue()).build());
        }
    }
}
