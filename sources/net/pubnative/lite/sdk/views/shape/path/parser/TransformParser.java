package net.pubnative.lite.sdk.views.shape.path.parser;

import android.graphics.Matrix;
import android.util.Log;

/* JADX INFO: loaded from: classes12.dex */
class TransformParser {
    private static final String TAG = "SvgToPath";

    TransformParser() {
    }

    static Matrix parseTransform(String str) {
        int i;
        Matrix matrix = new Matrix();
        while (true) {
            parseTransformItem(str, matrix);
            int iIndexOf = str.indexOf(")");
            if (iIndexOf <= 0 || str.length() <= (i = iIndexOf + 1)) {
                break;
            }
            str = str.substring(i).replaceFirst("[\\s,]*", "");
        }
        return matrix;
    }

    private static void parseTransformItem(String str, Matrix matrix) {
        float fFloatValue;
        float fFloatValue2 = 0.0f;
        if (str.startsWith("matrix(")) {
            NumberParse numbers = NumberParse.parseNumbers(str.substring("matrix(".length()));
            if (numbers.numbers.size() == 6) {
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{numbers.numbers.get(0).floatValue(), numbers.numbers.get(2).floatValue(), numbers.numbers.get(4).floatValue(), numbers.numbers.get(1).floatValue(), numbers.numbers.get(3).floatValue(), numbers.numbers.get(5).floatValue(), 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
                return;
            }
            return;
        }
        if (str.startsWith("translate(")) {
            NumberParse numbers2 = NumberParse.parseNumbers(str.substring("translate(".length()));
            if (numbers2.numbers.size() > 0) {
                matrix.preTranslate(numbers2.numbers.get(0).floatValue(), numbers2.numbers.size() > 1 ? numbers2.numbers.get(1).floatValue() : 0.0f);
                return;
            }
            return;
        }
        if (str.startsWith("scale(")) {
            NumberParse numbers3 = NumberParse.parseNumbers(str.substring("scale(".length()));
            if (numbers3.numbers.size() > 0) {
                float fFloatValue3 = numbers3.numbers.get(0).floatValue();
                matrix.preScale(fFloatValue3, numbers3.numbers.size() > 1 ? numbers3.numbers.get(1).floatValue() : fFloatValue3);
                return;
            }
            return;
        }
        if (str.startsWith("skewX(")) {
            NumberParse numbers4 = NumberParse.parseNumbers(str.substring("skewX(".length()));
            if (numbers4.numbers.size() > 0) {
                matrix.preSkew((float) Math.tan(numbers4.numbers.get(0).floatValue()), 0.0f);
                return;
            }
            return;
        }
        if (str.startsWith("skewY(")) {
            NumberParse numbers5 = NumberParse.parseNumbers(str.substring("skewY(".length()));
            if (numbers5.numbers.size() > 0) {
                matrix.preSkew(0.0f, (float) Math.tan(numbers5.numbers.get(0).floatValue()));
                return;
            }
            return;
        }
        if (str.startsWith("rotate(")) {
            NumberParse numbers6 = NumberParse.parseNumbers(str.substring("rotate(".length()));
            if (numbers6.numbers.size() > 0) {
                float fFloatValue4 = numbers6.numbers.get(0).floatValue();
                if (numbers6.numbers.size() > 2) {
                    fFloatValue2 = numbers6.numbers.get(1).floatValue();
                    fFloatValue = numbers6.numbers.get(2).floatValue();
                } else {
                    fFloatValue = 0.0f;
                }
                matrix.preTranslate(fFloatValue2, fFloatValue);
                matrix.preRotate(fFloatValue4);
                matrix.preTranslate(-fFloatValue2, -fFloatValue);
                return;
            }
            return;
        }
        Log.w(TAG, "Invalid transform (" + str + ")");
    }
}
