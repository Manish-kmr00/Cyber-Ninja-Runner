package io.bidmachine.nativead;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.AdRequestParameters;
import io.bidmachine.AdsFormat;
import io.bidmachine.MediaAssetType;
import io.bidmachine.utils.ProtoUtils;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class NativeAdRequestParameters extends AdRequestParameters {
    private final List<MediaAssetType> mediaAssetTypes;
    private boolean validateAssets;

    public NativeAdRequestParameters(List<MediaAssetType> list) {
        super(AdsFormat.Native);
        this.validateAssets = true;
        this.mediaAssetTypes = list;
    }

    public List<MediaAssetType> getMediaAssetTypes() {
        return this.mediaAssetTypes;
    }

    public boolean containsAssetType(MediaAssetType mediaAssetType) {
        return this.mediaAssetTypes.isEmpty() || this.mediaAssetTypes.contains(mediaAssetType) || this.mediaAssetTypes.contains(MediaAssetType.All);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isPlacementObjectValid(Placement placement) throws Throwable {
        return ProtoUtils.isNativePlacement(placement);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return super.isParametersMatched(adRequestParameters) && (adRequestParameters instanceof NativeAdRequestParameters) && isParametersMatchedInternal((NativeAdRequestParameters) adRequestParameters);
    }

    public boolean isValidateAssets() {
        return this.validateAssets;
    }

    void setValidateAssets(boolean z) {
        this.validateAssets = z;
    }

    private boolean isParametersMatchedInternal(NativeAdRequestParameters nativeAdRequestParameters) {
        return MediaAssetType.isAll(nativeAdRequestParameters.mediaAssetTypes) || nativeAdRequestParameters.mediaAssetTypes.containsAll(this.mediaAssetTypes);
    }
}
