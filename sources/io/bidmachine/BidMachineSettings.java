package io.bidmachine;

/* JADX INFO: loaded from: classes9.dex */
class BidMachineSettings {
    private static boolean showWithoutInternet;

    BidMachineSettings() {
    }

    static boolean isShowWithoutInternet() {
        return showWithoutInternet;
    }

    static void setShowWithoutInternet(boolean z) {
        showWithoutInternet = z;
    }
}
