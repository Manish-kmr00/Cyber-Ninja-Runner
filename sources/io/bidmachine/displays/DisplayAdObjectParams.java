package io.bidmachine.displays;

import com.explorestack.protobuf.adcom.Ad;

/* JADX INFO: loaded from: classes9.dex */
class DisplayAdObjectParams extends IabAdObjectParams {
    DisplayAdObjectParams(Ad ad) {
        super(ad);
        prepareEvents(ad.getDisplay().getEventList());
    }

    void setWidth(int i) {
        getData().put("width", Integer.valueOf(i));
    }

    void setHeight(int i) {
        getData().put("height", Integer.valueOf(i));
    }
}
