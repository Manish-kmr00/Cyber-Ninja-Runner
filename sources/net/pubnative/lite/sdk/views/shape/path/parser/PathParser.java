package net.pubnative.lite.sdk.views.shape.path.parser;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes13.dex */
class PathParser {
    private static final String TAG = SvgToPath.TAG;

    PathParser() {
    }

    public static Path doPath(String str) {
        char c;
        char c2;
        float f;
        float f2;
        String str2 = str;
        int length = str.length();
        ParserHelper parserHelper = new ParserHelper(str2);
        parserHelper.skipWhitespace();
        Path path = new Path();
        RectF rectF = new RectF();
        float f3 = 0.0f;
        char c3 = 'x';
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parserHelper.pos < length) {
            char cCharAt = str2.charAt(parserHelper.pos);
            if (Character.isDigit(cCharAt) || cCharAt == '.' || cCharAt == '-') {
                if (c3 == 'M') {
                    c3 = 'L';
                } else if (c3 == 'm') {
                    c = 'l';
                }
                c = c3;
            } else {
                parserHelper.advance();
                c = cCharAt;
            }
            boolean z = true;
            path.computeBounds(rectF, true);
            switch (c) {
                case 'A':
                case 'a':
                    float fNextFloat = parserHelper.nextFloat();
                    float fNextFloat2 = parserHelper.nextFloat();
                    float fNextFloat3 = parserHelper.nextFloat();
                    int iNextFloat = (int) parserHelper.nextFloat();
                    int iNextFloat2 = (int) parserHelper.nextFloat();
                    float fNextFloat4 = parserHelper.nextFloat();
                    float fNextFloat5 = parserHelper.nextFloat();
                    if (c == 'a') {
                        fNextFloat4 += f4;
                        fNextFloat5 += f5;
                    }
                    length = length;
                    float f10 = fNextFloat5;
                    float f11 = fNextFloat4;
                    c2 = c;
                    f3 = 0.0f;
                    path = path;
                    rectF = rectF;
                    drawArc(path, f4, f5, f11, f10, fNextFloat, fNextFloat2, fNextFloat3, iNextFloat == 1, iNextFloat2 == 1);
                    f5 = f10;
                    z = false;
                    f4 = f11;
                    break;
                case 'C':
                case 'c':
                    float fNextFloat6 = parserHelper.nextFloat();
                    float fNextFloat7 = parserHelper.nextFloat();
                    float fNextFloat8 = parserHelper.nextFloat();
                    float fNextFloat9 = parserHelper.nextFloat();
                    float fNextFloat10 = parserHelper.nextFloat();
                    float fNextFloat11 = parserHelper.nextFloat();
                    if (c == 'c') {
                        fNextFloat6 += f4;
                        fNextFloat8 += f4;
                        fNextFloat10 += f4;
                        fNextFloat7 += f5;
                        fNextFloat9 += f5;
                        fNextFloat11 += f5;
                    }
                    f8 = fNextFloat8;
                    f9 = fNextFloat9;
                    float f12 = fNextFloat11;
                    float f13 = fNextFloat10;
                    path.cubicTo(fNextFloat6, fNextFloat7, f8, f9, f13, f12);
                    length = length;
                    f4 = f13;
                    f5 = f12;
                    c2 = c;
                    path = path;
                    rectF = rectF;
                    f3 = 0.0f;
                    break;
                case 'H':
                case 'h':
                    float fNextFloat12 = parserHelper.nextFloat();
                    if (c == 'h') {
                        path.rLineTo(fNextFloat12, f3);
                        f4 += fNextFloat12;
                    } else {
                        path.lineTo(fNextFloat12, f5);
                        f4 = fNextFloat12;
                    }
                    c2 = c;
                    z = false;
                    break;
                case 'L':
                case 'l':
                    float fNextFloat13 = parserHelper.nextFloat();
                    float fNextFloat14 = parserHelper.nextFloat();
                    if (c == 'l') {
                        path.rLineTo(fNextFloat13, fNextFloat14);
                        f4 += fNextFloat13;
                        f5 += fNextFloat14;
                    } else {
                        path.lineTo(fNextFloat13, fNextFloat14);
                        f4 = fNextFloat13;
                        f5 = fNextFloat14;
                    }
                    c2 = c;
                    z = false;
                    break;
                case 'M':
                case 'm':
                    float fNextFloat15 = parserHelper.nextFloat();
                    float fNextFloat16 = parserHelper.nextFloat();
                    if (c == 'm') {
                        path.rMoveTo(fNextFloat15, fNextFloat16);
                        f4 += fNextFloat15;
                        f5 += fNextFloat16;
                    } else {
                        path.moveTo(fNextFloat15, fNextFloat16);
                        f4 = fNextFloat15;
                        f5 = fNextFloat16;
                    }
                    f6 = f4;
                    f7 = f5;
                    c2 = c;
                    z = false;
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT /* 81 */:
                case 'q':
                    float fNextFloat17 = parserHelper.nextFloat();
                    float fNextFloat18 = parserHelper.nextFloat();
                    float fNextFloat19 = parserHelper.nextFloat();
                    float fNextFloat20 = parserHelper.nextFloat();
                    if (c == 'q') {
                        fNextFloat19 += f4;
                        fNextFloat20 += f5;
                        fNextFloat17 += f4;
                        fNextFloat18 += f5;
                    }
                    f8 = fNextFloat17;
                    f9 = fNextFloat18;
                    f = fNextFloat19;
                    f2 = fNextFloat20;
                    path.cubicTo(f4, f5, f8, f9, f, f2);
                    length = length;
                    f4 = f;
                    f3 = f3;
                    c2 = c;
                    path = path;
                    rectF = rectF;
                    f5 = f2;
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT /* 83 */:
                case 's':
                    float fNextFloat21 = parserHelper.nextFloat();
                    float fNextFloat22 = parserHelper.nextFloat();
                    float fNextFloat23 = parserHelper.nextFloat();
                    float fNextFloat24 = parserHelper.nextFloat();
                    if (c == 's') {
                        fNextFloat21 += f4;
                        fNextFloat23 += f4;
                        fNextFloat22 += f5;
                        fNextFloat24 += f5;
                    }
                    float f14 = fNextFloat21;
                    float f15 = fNextFloat22;
                    float f16 = fNextFloat23;
                    float f17 = fNextFloat24;
                    path.cubicTo((f4 * 2.0f) - f8, (f5 * 2.0f) - f9, f14, f15, f16, f17);
                    length = length;
                    f8 = f14;
                    f3 = f3;
                    c2 = c;
                    path = path;
                    rectF = rectF;
                    f9 = f15;
                    f4 = f16;
                    f5 = f17;
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST /* 84 */:
                case 't':
                    float fNextFloat25 = parserHelper.nextFloat();
                    float fNextFloat26 = parserHelper.nextFloat();
                    if (c == 't') {
                        fNextFloat25 += f4;
                        fNextFloat26 += f5;
                    }
                    f = fNextFloat25;
                    f2 = fNextFloat26;
                    f8 = (f4 * 2.0f) - f8;
                    f9 = (2.0f * f5) - f9;
                    path.cubicTo(f4, f5, f8, f9, f, f2);
                    length = length;
                    f4 = f;
                    f3 = f3;
                    c2 = c;
                    path = path;
                    rectF = rectF;
                    f5 = f2;
                    break;
                case 'V':
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    float fNextFloat27 = parserHelper.nextFloat();
                    if (c == 'v') {
                        path.rLineTo(f3, fNextFloat27);
                        f5 += fNextFloat27;
                    } else {
                        path.lineTo(f4, fNextFloat27);
                        f5 = fNextFloat27;
                    }
                    c2 = c;
                    z = false;
                    break;
                case 'Z':
                case INVALID_ADS_ENDPOINT_VALUE:
                    path.close();
                    length = length;
                    c2 = c;
                    f4 = f6;
                    f5 = f7;
                    z = false;
                    break;
                default:
                    length = length;
                    c2 = c;
                    Log.w(TAG, "Invalid path command: " + c2);
                    parserHelper.advance();
                    z = false;
                    break;
            }
            if (!z) {
                f8 = f4;
                f9 = f5;
            }
            parserHelper.skipWhitespace();
            str2 = str;
            c3 = c2;
            length = length;
            f3 = f3;
            path = path;
            rectF = rectF;
        }
        return path;
    }

    private static void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9 = (d - d3) / 2.0d;
        double d10 = (d2 - d4) / 2.0d;
        double radians = Math.toRadians(d7 % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d11 = (dCos * d9) + (dSin * d10);
        double d12 = ((-dSin) * d9) + (d10 * dCos);
        double dAbs = Math.abs(d5);
        double dAbs2 = Math.abs(d6);
        double d13 = dAbs * dAbs;
        double d14 = dAbs2 * dAbs2;
        double d15 = d11 * d11;
        double d16 = d12 * d12;
        double d17 = (d15 / d13) + (d16 / d14);
        if (d17 > 1.0d) {
            dAbs *= Math.sqrt(d17);
            dAbs2 *= Math.sqrt(d17);
            d13 = dAbs * dAbs;
            d14 = dAbs2 * dAbs2;
        }
        double d18 = z == z2 ? -1.0d : 1.0d;
        double d19 = d13 * d14;
        double d20 = d13 * d16;
        double d21 = d14 * d15;
        double d22 = ((d19 - d20) - d21) / (d20 + d21);
        if (d22 < 0.0d) {
            d22 = 0.0d;
        }
        double dSqrt = d18 * Math.sqrt(d22);
        double d23 = ((dAbs * d12) / dAbs2) * dSqrt;
        double d24 = dSqrt * (-((dAbs2 * d11) / dAbs));
        double d25 = ((d + d3) / 2.0d) + ((dCos * d23) - (dSin * d24));
        double d26 = ((d2 + d4) / 2.0d) + (dSin * d23) + (dCos * d24);
        double d27 = (d11 - d23) / dAbs;
        double d28 = (d12 - d24) / dAbs2;
        double d29 = ((-d11) - d23) / dAbs;
        double d30 = ((-d12) - d24) / dAbs2;
        double d31 = (d27 * d27) + (d28 * d28);
        double degrees = Math.toDegrees((d28 < 0.0d ? -1.0d : 1.0d) * Math.acos(d27 / Math.sqrt(d31)));
        double degrees2 = Math.toDegrees(((d27 * d30) - (d28 * d29) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d27 * d29) + (d28 * d30)) / Math.sqrt(d31 * ((d29 * d29) + (d30 * d30)))));
        if (z2 || degrees2 <= 0.0d) {
            d8 = 360.0d;
            if (z2 && degrees2 < 0.0d) {
                degrees2 += 360.0d;
            }
        } else {
            d8 = 360.0d;
            degrees2 -= 360.0d;
        }
        path.addArc(new RectF((float) (d25 - dAbs), (float) (d26 - dAbs2), (float) (d25 + dAbs), (float) (d26 + dAbs2)), (float) (degrees % d8), (float) (degrees2 % d8));
    }
}
