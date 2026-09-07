package com.amazon.device.ads;

/* JADX INFO: compiled from: MraidProperty.java */
/* JADX INFO: loaded from: classes10.dex */
class StateProperty extends MraidStringProperty {
    MraidStateType stateType;

    StateProperty(MraidStateType mraidStateType) {
        super("state");
        this.stateType = mraidStateType;
    }

    @Override // com.amazon.device.ads.MraidStringProperty
    String getValue() {
        return this.stateType.toString();
    }
}
