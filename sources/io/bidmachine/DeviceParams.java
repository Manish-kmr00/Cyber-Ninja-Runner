package io.bidmachine;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.utils.BluetoothUtils;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ProtoUtils;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
final class DeviceParams {
    private final DeviceConnectionParams deviceConnectionParams;

    public DeviceParams(DeviceConnectionParams deviceConnectionParams) {
        this.deviceConnectionParams = deviceConnectionParams;
    }

    void build(Context context, final RequestTokenPayload.Builder builder, DataRestrictions dataRestrictions) {
        Device.Builder builderCreateDeviceBuilder = createDeviceBuilder(context, dataRestrictions);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(builderCreateDeviceBuilder, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda14
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setDeviceData((Device.Builder) obj);
            }
        });
    }

    void build(Context context, com.explorestack.protobuf.adcom.Context.Builder builder, TargetingParams targetingParams, TargetingParams targetingParams2, DataRestrictions dataRestrictions, ConnectionType connectionType) {
        com.explorestack.protobuf.adcom.Context.Device.Builder builderCreateDeviceContextBuilder = createDeviceContextBuilder(context, targetingParams, targetingParams2, dataRestrictions, connectionType);
        if (builderCreateDeviceContextBuilder != null) {
            Device.Builder builderCreateDeviceBuilder = createDeviceBuilder(context, dataRestrictions);
            if (builderCreateDeviceBuilder != null) {
                builderCreateDeviceContextBuilder.addExtProto(Any.pack(builderCreateDeviceBuilder.build()));
            }
            builder.setDevice(builderCreateDeviceContextBuilder);
        }
    }

    private Device.Builder createDeviceBuilder(Context context, DataRestrictions dataRestrictions) {
        try {
            Device.Builder builderNewBuilder = Device.newBuilder();
            fillDeviceBuilder(context, builderNewBuilder, dataRestrictions);
            return builderNewBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void fillDeviceBuilder(Context context, final Device.Builder builder, DataRestrictions dataRestrictions) throws Throwable {
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        String ifv = bidMachineImpl.getIFV();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(ifv, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda19
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setIfv((String) obj);
            }
        });
        builder.setBmIfv(bidMachineImpl.obtainBMIFV(context));
        Set<String> inputLanguageSet = DeviceUtils.getInputLanguageSet(context);
        if (!inputLanguageSet.isEmpty()) {
            builder.addAllInputlanguage(inputLanguageSet);
        }
        Boolean boolIsCharging = DeviceUtils.isCharging(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsCharging, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda4
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setCharging(((Boolean) obj).booleanValue());
            }
        });
        Boolean boolIsHeadsetConnected = BluetoothUtils.isHeadsetConnected(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsHeadsetConnected, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda5
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setHeadset(((Boolean) obj).booleanValue());
            }
        });
        Double batteryLevel = DeviceUtils.getBatteryLevel(context);
        if (batteryLevel != null) {
            builder.setBatterylevel(batteryLevel.floatValue());
        }
        Boolean boolIsBatterySaverEnabled = DeviceUtils.isBatterySaverEnabled(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsBatterySaverEnabled, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda6
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setBatterysaver(((Boolean) obj).booleanValue());
            }
        });
        builder.setDarkmode(DeviceUtils.isDarkModeEnabled(context));
        Boolean boolIsAirplaneModeOn = DeviceUtils.isAirplaneModeOn(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsAirplaneModeOn, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda7
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setAirplane(((Boolean) obj).booleanValue());
            }
        });
        Boolean boolIsDoNotDisturbOn = DeviceUtils.isDoNotDisturbOn(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsDoNotDisturbOn, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda8
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setDnd(((Boolean) obj).booleanValue());
            }
        });
        if (dataRestrictions.canSendDeviceInfo()) {
            String deviceName = DeviceUtils.getDeviceName(context);
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(deviceName, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda9
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setDevicename((String) obj);
                }
            });
            this.deviceConnectionParams.build(context, builder, DeviceUtils.getConnectionType(context));
        }
        Double screenBrightnessRatio = DeviceUtils.getScreenBrightnessRatio(context);
        if (screenBrightnessRatio != null) {
            builder.setScreenbright(screenBrightnessRatio.floatValue());
        }
        builder.setLastbootup(SystemClock.elapsedRealtime());
        Set<String> connectedHeadsets = BluetoothUtils.getConnectedHeadsets(context);
        if (connectedHeadsets != null && !connectedHeadsets.isEmpty()) {
            String next = connectedHeadsets.iterator().next();
            Objects.requireNonNull(builder);
            Utils.ifNotNull(next, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda10
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setHeadsetname((String) obj);
                }
            });
        }
        builder.setApilevel(Build.VERSION.SDK_INT);
        builder.setTime(TimeManager.currentTimeMillis());
        String timezoneId = TimeManager.getTimezoneId();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(timezoneId, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda12
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setTimezone((String) obj);
            }
        });
        DeviceInfo deviceInfoObtain = DeviceInfo.obtain(context);
        Long availableDiskSpaceInMB = deviceInfoObtain.getAvailableDiskSpaceInMB();
        if (availableDiskSpaceInMB != null) {
            builder.setDiskspace(availableDiskSpaceInMB.intValue());
        }
        Long totalDiskSpaceInMB = deviceInfoObtain.getTotalDiskSpaceInMB();
        if (totalDiskSpaceInMB != null) {
            builder.setTotaldisk(totalDiskSpaceInMB.intValue());
        }
        builder.setJailbreak(deviceInfoObtain.isDeviceRooted());
        Boolean boolIsRingMuted = deviceInfoObtain.getAudio().isRingMuted(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(boolIsRingMuted, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda13
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setRingmute(((Boolean) obj).booleanValue());
            }
        });
        Float volumeLevel = deviceInfoObtain.getAudio().getVolumeLevel(context);
        if (volumeLevel != null) {
            builder.setAudioContext(com.explorestack.protobuf.adcom.Context.Device.AudioContext.newBuilder().setVolumelevel(volumeLevel.floatValue()).build());
        }
        deviceInfoObtain.updateHwInfo(context);
        Long totalMemBytes = deviceInfoObtain.getRam().getTotalMemBytes();
        Objects.requireNonNull(builder);
        Utils.ifNotNull(totalMemBytes, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda20
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setTotalmem(((Long) obj).longValue());
            }
        });
        Long freeMemBytes = deviceInfoObtain.getRam().getFreeMemBytes();
        Objects.requireNonNull(builder);
        Utils.ifNotNull(freeMemBytes, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda21
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setFreemem(((Long) obj).longValue());
            }
        });
        String name = deviceInfoObtain.getCpu().getName();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(name, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda22
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setCpuname((String) obj);
            }
        });
        String vendor = deviceInfoObtain.getCpu().getVendor();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(vendor, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setCpuvendor((String) obj);
            }
        });
        String name2 = deviceInfoObtain.getGpu().getName();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(name2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda2
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setGpuname((String) obj);
            }
        });
        String vendor2 = deviceInfoObtain.getGpu().getVendor();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(vendor2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda3
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                builder.setGpuvendor((String) obj);
            }
        });
    }

    private com.explorestack.protobuf.adcom.Context.Device.Builder createDeviceContextBuilder(Context context, TargetingParams targetingParams, TargetingParams targetingParams2, DataRestrictions dataRestrictions, ConnectionType connectionType) {
        try {
            com.explorestack.protobuf.adcom.Context.Device.Builder builderNewBuilder = com.explorestack.protobuf.adcom.Context.Device.newBuilder();
            fillDeviceContextBuilder(context, builderNewBuilder, targetingParams, targetingParams2, dataRestrictions, connectionType);
            return builderNewBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void fillDeviceContextBuilder(Context context, final com.explorestack.protobuf.adcom.Context.Device.Builder builder, TargetingParams targetingParams, TargetingParams targetingParams2, DataRestrictions dataRestrictions, ConnectionType connectionType) throws Throwable {
        DeviceType deviceType;
        DeviceInfo deviceInfoObtain = DeviceInfo.obtain(context);
        if (deviceInfoObtain.isTablet) {
            deviceType = DeviceType.DEVICE_TYPE_TABLET;
        } else {
            deviceType = DeviceType.DEVICE_TYPE_PHONE_DEVICE;
        }
        builder.setType(deviceType);
        builder.setOs(OS.OS_ANDROID);
        builder.setOsv(DeviceUtils.getOsVersion());
        builder.setPxratio(deviceInfoObtain.screenDensity);
        builder.setPpi(deviceInfoObtain.screenDpi);
        Point screenSize = Utils.getScreenSize(context);
        builder.setW(screenSize.x);
        builder.setH(screenSize.y);
        builder.setIfa(AdvertisingDataManager.getAdvertisingId(context, !dataRestrictions.canSendIfa()));
        builder.setLmt(AdvertisingDataManager.isLimitAdTrackingEnabled());
        if (dataRestrictions.canSendDeviceInfo()) {
            if (connectionType == null) {
                connectionType = DeviceUtils.getConnectionType(context);
            }
            builder.setContype(connectionType);
            builder.setMake(DeviceUtils.getManufacturer());
            String userAgent = UserAgentManager.getUserAgent(context);
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(userAgent, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setUa((String) obj);
                }
            });
            String str = deviceInfoObtain.model;
            Objects.requireNonNull(builder);
            Utils.ifNotNull(str, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda11
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setModel((String) obj);
                }
            });
            String hwv = deviceInfoObtain.getHWV();
            Objects.requireNonNull(builder);
            Utils.ifNotNull(hwv, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda15
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setHwv((String) obj);
                }
            });
            String language = Locale.getDefault().getLanguage();
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(language, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda16
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setLang((String) obj);
                }
            });
            String str2 = deviceInfoObtain.phoneMCCMNC;
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(str2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda17
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setMccmnc((String) obj);
                }
            });
            String str3 = deviceInfoObtain.phoneCarrier;
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(str3, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda18
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builder.setCarrier((String) obj);
                }
            });
            this.deviceConnectionParams.build(context, builder, connectionType);
        }
        if (dataRestrictions.canSendGeoPosition()) {
            builder.setGeo(ProtoUtils.createGeoBuilderWithLocation(context, targetingParams.getDeviceLocation(), targetingParams2.getDeviceLocation(), true));
        }
    }
}
