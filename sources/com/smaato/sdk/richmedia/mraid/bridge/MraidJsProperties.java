package com.smaato.sdk.richmedia.mraid.bridge;

import android.graphics.Rect;
import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeSender;
import com.smaato.sdk.core.util.notifier.ChangeSenderUtils;
import com.smaato.sdk.richmedia.mraid.MraidUtils;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidAppOrientation;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExpandProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidLocationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidOrientationProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidResizeProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.PlacementType;
import com.smaato.sdk.richmedia.mraid.exception.MraidException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class MraidJsProperties {
    private ErrorListener errorCallback;
    private MraidExpandProperties expandProperties;
    private final MraidJsBridge jsBridge;
    private final Logger logger;
    private final ChangeSender orientationProperties = ChangeSenderUtils.createUniqueValueChangeSender(MraidOrientationProperties.createDefault());
    private MraidResizeProperties resizeProperties;

    public MraidJsProperties(Logger logger, MraidJsBridge mraidJsBridge) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.jsBridge = (MraidJsBridge) Objects.requireNonNull(mraidJsBridge);
        subscribeOnEvents();
    }

    private void subscribeOnEvents() {
        this.jsBridge.addCommandHandler("setOrientationProperties", new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
            public final void handle(Map map, boolean z) {
                this.f$0.m5660x3de2de96(map, z);
            }
        });
        this.jsBridge.addCommandHandler("setResizeProperties", new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
            public final void handle(Map map, boolean z) {
                this.f$0.m5661x6376e797(map, z);
            }
        });
        this.jsBridge.addCommandHandler("setExpandProperties", new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
            public final void handle(Map map, boolean z) {
                this.f$0.m5662x890af098(map, z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$subscribeOnEvents$0$com-smaato-sdk-richmedia-mraid-bridge-MraidJsProperties, reason: not valid java name */
    /* synthetic */ void m5660x3de2de96(Map map, boolean z) {
        onSetOrientationProperties(map);
    }

    /* JADX INFO: renamed from: lambda$subscribeOnEvents$1$com-smaato-sdk-richmedia-mraid-bridge-MraidJsProperties, reason: not valid java name */
    /* synthetic */ void m5661x6376e797(Map map, boolean z) {
        onSetResizePropertiesCommand(map);
    }

    /* JADX INFO: renamed from: lambda$subscribeOnEvents$2$com-smaato-sdk-richmedia-mraid-bridge-MraidJsProperties, reason: not valid java name */
    /* synthetic */ void m5662x890af098(Map map, boolean z) {
        onSetExpandPropertiesCommand(map);
    }

    private void onSetResizePropertiesCommand(Map map) {
        try {
            this.resizeProperties = new MraidResizeProperties.Builder(map).build();
        } catch (MraidException e) {
            this.logger.error(LogDomain.MRAID, "Failed to handle a command: setResizeProperties, reason: " + e.getMessage(), new Object[0]);
            Objects.onNotNull(this.errorCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((ErrorListener) obj).onError("setResizeProperties", e.getMessage());
                }
            });
        }
    }

    private void onSetExpandPropertiesCommand(Map map) {
        try {
            this.expandProperties = new MraidExpandProperties.Builder(map).build();
        } catch (MraidException e) {
            this.logger.error(LogDomain.MRAID, "Failed to handle a command: setExpandProperties, reason: " + e.getMessage(), new Object[0]);
            Objects.onNotNull(this.errorCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsProperties$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((ErrorListener) obj).onError("setExpandProperties", e.getMessage());
                }
            });
        }
    }

    private void onSetOrientationProperties(Map map) {
        String str = (String) map.get("allowOrientationChange");
        this.orientationProperties.newValue(new MraidOrientationProperties(!TextUtils.isEmpty(str) ? Boolean.valueOf(str).booleanValue() : true, PropertiesUtils.stringToScreenOrientation((String) map.get("forceOrientation"))));
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.errorCallback = errorListener;
    }

    public ChangeSender<MraidOrientationProperties> getOrientationPropertiesChangeSender() {
        return this.orientationProperties;
    }

    public MraidResizeProperties getResizeProperties() {
        return this.resizeProperties;
    }

    public MraidExpandProperties getExpandProperties() {
        return this.expandProperties;
    }

    public void setCurrentAppOrientation(MraidAppOrientation mraidAppOrientation) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setCurrentAppOrientation('%s', %b);", PropertiesUtils.screenOrientationToString(mraidAppOrientation.orientation), Boolean.valueOf(mraidAppOrientation.isLocked)));
    }

    public void setCurrentPosition(Rect rect) {
        if (rect.isEmpty()) {
            return;
        }
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setCurrentPosition(%d, %d, %d, %d);", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())));
    }

    public void setDefaultPosition(Rect rect) {
        if (rect.isEmpty()) {
            return;
        }
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setDefaultPosition(%d, %d, %d, %d);", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())));
    }

    public void setMaxSize(Size size) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setMaxSize(%d, %d);", Integer.valueOf(size.width), Integer.valueOf(size.height)));
    }

    public void setScreenSize(Size size) {
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setScreenSize(%d, %d);", Integer.valueOf(size.width), Integer.valueOf(size.height)));
    }

    public void setLocation(MraidLocationProperties mraidLocationProperties) {
        LatLng latLng = mraidLocationProperties.latLng;
        if (latLng == null) {
            return;
        }
        this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setCurrentLocation(%.2f, %.2f, %d, %f, %d);", Double.valueOf(latLng.getLatitude()), Double.valueOf(mraidLocationProperties.latLng.getLongitude()), mraidLocationProperties.locationServiceType, Float.valueOf(mraidLocationProperties.latLng.getLocationAccuracy()), Long.valueOf(mraidLocationProperties.latLng.getLocationTimestamp() / 1000)));
    }

    public void setPlacementType(PlacementType placementType) {
        try {
            this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setPlacementType('%s');", PropertiesUtils.placementTypeToString(placementType)));
        } catch (IllegalArgumentException e) {
            this.logger.error(LogDomain.MRAID, "Failed to call MRAID's setPlacementType method, reason: " + e.getMessage(), new Object[0]);
        }
    }

    public void setSupportedFeatures(List<String> list, String[] strArr) {
        for (String str : strArr) {
            this.jsBridge.runScript(MraidUtils.format("window.mraidbridge.setSupports('%s', %b);", str, Boolean.valueOf(list.contains(str))));
        }
    }
}
