package io.bidmachine.displays;

import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.TrackEventType;
import io.bidmachine.displays.mapper.LabelDataMapper;
import io.bidmachine.displays.mapper.PositionDataMapper;
import io.bidmachine.displays.mapper.PrivacySheetDataMapper;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;

/* JADX INFO: loaded from: classes3.dex */
final class NativeAdObjectParams extends DisplayAdObjectParams {
    private final LabelDataMapper labelDataMapper;
    private final PositionDataMapper positionDataMapper;
    private final PrivacySheetDataMapper privacySheetDataMapper;

    @Override // io.bidmachine.displays.IabAdObjectParams, io.bidmachine.models.AdObjectParams
    public boolean isValid() {
        return true;
    }

    NativeAdObjectParams(Ad ad) {
        super(ad);
        PositionDataMapper positionDataMapper = new PositionDataMapper();
        this.positionDataMapper = positionDataMapper;
        LabelDataMapper labelDataMapper = new LabelDataMapper(positionDataMapper);
        this.labelDataMapper = labelDataMapper;
        this.privacySheetDataMapper = new PrivacySheetDataMapper(labelDataMapper);
        Ad.Display.Native r6 = ad.getDisplay().getNative();
        Ad.Display.Native.LinkAsset link = r6.getLink();
        if (link != null && link != Ad.Display.Native.LinkAsset.getDefaultInstance()) {
            getData().put("clickUrl", link.getUrl());
            for (int i = 0; i < link.getTrkrCount(); i++) {
                addEvent(TrackEventType.Click, link.getTrkr(i));
            }
        }
        for (Ad.Display.Native.Asset asset : r6.getAssetList()) {
            int id = asset.getId();
            if (id == 4) {
                Ad.Display.Native.Asset.VideoAsset defaultInstance = Ad.Display.Native.Asset.VideoAsset.getDefaultInstance();
                if (!asset.getVideo().getCurl().equals(defaultInstance.getCurl())) {
                    getData().put(UnifiedMediationParams.KEY_VIDEO_URL, asset.getVideo().getCurl());
                }
                if (!asset.getVideo().getAdm().equals(defaultInstance.getAdm())) {
                    getData().put(UnifiedMediationParams.KEY_VIDEO_ADM, asset.getVideo().getAdm());
                }
            } else if (id == 7) {
                try {
                    getData().put("rating", Float.valueOf(asset.getData().getValue()));
                } catch (NumberFormatException unused) {
                }
            } else if (id == 8) {
                getData().put("cta", asset.getData().getValue());
            } else if (id == 101) {
                Utils.ifNotNull(this.labelDataMapper.map(asset.getLabel()), new Executable() { // from class: io.bidmachine.displays.NativeAdObjectParams$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.util.Executable
                    public final void execute(Object obj) {
                        this.f$0.m7424lambda$new$0$iobidmachinedisplaysNativeAdObjectParams((LabelData) obj);
                    }
                });
            } else if (id == 102) {
                Utils.ifNotNull(this.privacySheetDataMapper.map(asset), new Executable() { // from class: io.bidmachine.displays.NativeAdObjectParams$$ExternalSyntheticLambda1
                    @Override // io.bidmachine.util.Executable
                    public final void execute(Object obj) {
                        this.f$0.m7425lambda$new$1$iobidmachinedisplaysNativeAdObjectParams((PrivacySheetData) obj);
                    }
                });
            } else if (id == 123) {
                getData().put("title", asset.getTitle().getText());
            } else if (id == 124) {
                getData().put(UnifiedMediationParams.KEY_ICON_URL, asset.getImage().getUrl());
            } else if (id == 127) {
                getData().put("description", asset.getData().getValue());
            } else if (id == 128) {
                getData().put(UnifiedMediationParams.KEY_IMAGE_URL, asset.getImage().getUrl());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$io-bidmachine-displays-NativeAdObjectParams, reason: not valid java name */
    /* synthetic */ void m7424lambda$new$0$iobidmachinedisplaysNativeAdObjectParams(LabelData labelData) {
        getData().put(UnifiedMediationParams.KEY_AD_LABEL, labelData);
    }

    /* JADX INFO: renamed from: lambda$new$1$io-bidmachine-displays-NativeAdObjectParams, reason: not valid java name */
    /* synthetic */ void m7425lambda$new$1$iobidmachinedisplaysNativeAdObjectParams(PrivacySheetData privacySheetData) {
        getData().put(UnifiedMediationParams.KEY_PRIVACY_SHEET, privacySheetData);
    }
}
