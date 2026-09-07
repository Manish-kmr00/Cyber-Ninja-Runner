package io.bidmachine.utils.data;

import com.explorestack.protobuf.Struct;
import io.bidmachine.utils.ProtoUtils;

/* JADX INFO: loaded from: classes13.dex */
public class StructDataRetriever extends MapDataRetriever<String> {
    public void setStruct(Struct struct) {
        setParams(ProtoUtils.toMapOrNull(struct));
    }
}
