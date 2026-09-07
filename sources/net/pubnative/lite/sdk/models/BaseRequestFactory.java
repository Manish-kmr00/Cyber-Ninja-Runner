package net.pubnative.lite.sdk.models;

import java.util.List;
import java.util.TimeZone;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.models.bidstream.DeviceExtension;
import net.pubnative.lite.sdk.models.bidstream.Extension;
import net.pubnative.lite.sdk.models.bidstream.Signal;

/* JADX INFO: loaded from: classes12.dex */
public class BaseRequestFactory {
    protected Integer formatUTCTime() {
        return Integer.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000);
    }

    protected Signal fillExtensionsObject(DeviceInfo deviceInfo) {
        Integer numValueOf = null;
        if (deviceInfo == null) {
            return null;
        }
        List<String> inputLanguages = deviceInfo.getInputLanguages();
        Integer numIsBatteryCharging = deviceInfo.isBatteryCharging();
        Integer batteryLevel = deviceInfo.getBatteryLevel();
        Integer numIsPowerSaveMode = deviceInfo.isPowerSaveMode();
        Integer freeMemoryMb = deviceInfo.getFreeMemoryMb();
        Integer totalMemoryMb = deviceInfo.getTotalMemoryMb();
        Integer numIsDarkMode = deviceInfo.isDarkMode();
        Integer numIsHeadsetOn = deviceInfo.isHeadsetOn();
        if (deviceInfo.getSoundSetting() != null) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt(deviceInfo.getSoundSetting()));
            } catch (Exception unused) {
            }
        }
        return new Extension(inputLanguages, numIsBatteryCharging, batteryLevel, numIsPowerSaveMode, freeMemoryMb, totalMemoryMb, numIsDarkMode, deviceInfo.isDndEnabled(), deviceInfo.isAirplaneModeEnabled(), numIsHeadsetOn, numValueOf);
    }

    protected DeviceExtension fillBidStreamExtensionsObject(DeviceInfo deviceInfo) {
        Integer numValueOf = null;
        if (deviceInfo == null) {
            return null;
        }
        List<String> inputLanguages = deviceInfo.getInputLanguages();
        Integer numIsBatteryCharging = deviceInfo.isBatteryCharging();
        Integer batteryLevel = deviceInfo.getBatteryLevel();
        Integer numIsPowerSaveMode = deviceInfo.isPowerSaveMode();
        Integer freeMemoryMb = deviceInfo.getFreeMemoryMb();
        Integer totalMemoryMb = deviceInfo.getTotalMemoryMb();
        Integer numIsDarkMode = deviceInfo.isDarkMode();
        Integer numIsHeadsetOn = deviceInfo.isHeadsetOn();
        if (deviceInfo.getSoundSetting() != null) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt(deviceInfo.getSoundSetting()));
            } catch (Exception unused) {
            }
        }
        return new DeviceExtension(inputLanguages, numIsBatteryCharging, batteryLevel, numIsPowerSaveMode, freeMemoryMb, totalMemoryMb, numIsDarkMode, deviceInfo.isDndEnabled(), deviceInfo.isAirplaneModeEnabled(), numIsHeadsetOn, numValueOf);
    }
}
