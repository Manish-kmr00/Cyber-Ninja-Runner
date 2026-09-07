package com.amazon.device.ads;

/* JADX INFO: compiled from: MraidProperty.java */
/* JADX INFO: loaded from: classes11.dex */
class SupportsProperty extends MraidDictionaryProperty {
    SupportsProperty() {
        super("supports");
        try {
            this.data.put("tel", SDKUtilities.isTelSupported());
            this.data.put("sms", false);
            this.data.put("calendar", false);
            this.data.put("storePicture", false);
            this.data.put("inlineVideo", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
