package io.bidmachine.utils;

/* JADX INFO: loaded from: classes13.dex */
public enum Gender {
    Female("F", 1),
    Male("M", 2),
    Omitted("O", 0);

    private final String ortbValue;
    private final int serverValue;

    Gender(String str, int i) {
        this.ortbValue = str;
        this.serverValue = i;
    }

    public String getOrtbValue() {
        return this.ortbValue;
    }

    public int getServerValue() {
        return this.serverValue;
    }

    public static Gender fromInt(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return Omitted;
        }
        if (iIntValue == 1) {
            return Female;
        }
        if (iIntValue != 2) {
            return null;
        }
        return Male;
    }
}
