package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NY {
    public static String[] A02 = {"d9bWAIWZ3t55n7VG0ySjSq4xoYZpbq1b", "7MJirIHVABfLK3DP7UaOMUsa55TIUC", "22tucT2Y7zfDTKiyUUSmSqn4gOdR2yl4", "i5CYewNz", "XFSF4qq1", "7dDfBoxAg5KF2dY0vp9IiHHy4Idk68pj", "mCftV9S0ueMeTE4Z7VbLiHJU6BDSmxWi", "HfXtsxQJIt1YapnmMEg8PbxSrUXYfddj"};
    public final float A00;
    public final int A01;

    public NY(int i, float f) {
        this.A01 = i;
        this.A00 = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NY ny = (NY) obj;
        if (this.A01 == ny.A01) {
            int iCompare = Float.compare(ny.A00, this.A00);
            if (A02[1].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "iDdO84RB";
            strArr[4] = "y69vAWvZ";
            if (iCompare == 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        return (((17 * 31) + result) * 31) + Float.floatToIntBits(this.A00);
    }
}
