package com.fyber.marketplace.fairbid.impl;

/* JADX INFO: loaded from: classes10.dex */
public enum f {
    KEY_AVAILABLE_DISK_SPACE("available_disk", "dsk_a", Integer.class),
    KEY_HEADSET("headset", "headset", Boolean.class),
    KEY_BATTERY_CONNECTED("battery_charging", "btry_c", Boolean.class),
    KEY_BATTERY_LEVEL("battery_level", "btry_l", Integer.class),
    KEY_BLUETOOTH_CONNECTED("bluetooth_connected", "bt_con", Boolean.class),
    KEY_ANDROID_LEVEL("d_api", "d_api", Integer.class),
    KEY_AIRPLANE_MODE("apnm", "apnm", Boolean.class),
    KEY_DO_NOT_DISTURB("dnd", "dnd", Boolean.class),
    KEY_IS_MUTED("is_muted", "is_muted", Boolean.class),
    KEY_TOTAL_DISK_SPACE("total_disk", "dsk_t", Integer.class),
    KEY_TIME_OF_DAY("time_difference", "tod", Integer.class),
    KEY_LOW_POWER_MODE("low_power_mode", "low_power_mode", Boolean.class),
    KEY_COUNTRY_CODE("ciso", "ciso", String.class),
    KEY_DARK_MODE("dark_mode", "dark_mode", Boolean.class),
    KEY_LAST_DOMAIN_SHOWED("last_adomain", "ldomain", String.class),
    KEY_LAST_BUNDLE_SHOWED("last_bundle", "lbundle", String.class),
    KEY_IGNITE_VERSION("version", "ignitev", String.class),
    KEY_IGNITE_PACKAGE_NAME("package_name", "ignitep", String.class),
    KEY_MEDIA_MUTED("media_muted", "media_muted", Boolean.class),
    KEY_AD_SERVICES_VERSION("asv", "asv", Integer.class);

    public String fairBidParam;
    public String marketPlaceParam;
    public Object type;

    f(String str, String str2, Class cls) {
        this.fairBidParam = str;
        this.marketPlaceParam = str2;
        this.type = cls;
    }
}
