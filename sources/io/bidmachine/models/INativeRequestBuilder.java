package io.bidmachine.models;

import io.bidmachine.MediaAssetType;
import io.bidmachine.models.INativeRequestBuilder;

/* JADX INFO: loaded from: classes12.dex */
public interface INativeRequestBuilder<SelfType extends INativeRequestBuilder> {
    SelfType setMediaAssetTypes(MediaAssetType... mediaAssetTypeArr);
}
