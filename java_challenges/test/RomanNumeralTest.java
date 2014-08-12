import org.junit.Test;

public class RomanNumeralTest {

    @Test
    public void testArabicToRoman() {
        RomanNumeral r = new RomanNumeral();
        for (int i = 1; i <= 3999; i++) {
            assert r.romanToArabic(r.arabicToRoman(i)) == i;
        }
    }

    @Test
    public void testRomanToArabic() {
        RomanNumeral r = new RomanNumeral();
        assert r.romanToArabic("I") == 1;
        assert r.romanToArabic("II") == 2;
        assert r.romanToArabic("III") == 3;
        assert r.romanToArabic("IV") == 4;
        assert r.romanToArabic("V") == 5;
        assert r.romanToArabic("VI") == 6;
        assert r.romanToArabic("VII") == 7;
        assert r.romanToArabic("VIII") == 8;
        assert r.romanToArabic("IX") == 9;
        assert r.romanToArabic("X") == 10;
        assert r.romanToArabic("XI") == 11;
        assert r.romanToArabic("XII") == 12;
        assert r.romanToArabic("XIII") == 13;
        assert r.romanToArabic("XIV") == 14;
        assert r.romanToArabic("XV") == 15;
        assert r.romanToArabic("XVI") == 16;
        assert r.romanToArabic("XVII") == 17;
        assert r.romanToArabic("XVIII") == 18;
        assert r.romanToArabic("XIX") == 19;
        assert r.romanToArabic("XX") == 20;
        assert r.romanToArabic("XXI") == 21;
        assert r.romanToArabic("XXII") == 22;
        assert r.romanToArabic("XXIII") == 23;
        assert r.romanToArabic("XXIV") == 24;
        assert r.romanToArabic("XXV") == 25;
        assert r.romanToArabic("XXVI") == 26;
        assert r.romanToArabic("XXVII") == 27;
        assert r.romanToArabic("XXVIII") == 28;
        assert r.romanToArabic("XXIX") == 29;
        assert r.romanToArabic("XXX") == 30;
        assert r.romanToArabic("XXXI") == 31;
        assert r.romanToArabic("XXXII") == 32;
        assert r.romanToArabic("XXXIII") == 33;
        assert r.romanToArabic("XXXIV") == 34;
        assert r.romanToArabic("XXXV") == 35;
        assert r.romanToArabic("XXXVI") == 36;
        assert r.romanToArabic("XXXVII") == 37;
        assert r.romanToArabic("XXXVIII") == 38;
        assert r.romanToArabic("IXL") == 39;
        assert r.romanToArabic("XL") == 40;
        assert r.romanToArabic("XLI") == 41;
        assert r.romanToArabic("XLII") == 42;
        assert r.romanToArabic("XLIII") == 43;
        assert r.romanToArabic("XLIV") == 44;
        assert r.romanToArabic("XLV") == 45;
        assert r.romanToArabic("XLVI") == 46;
        assert r.romanToArabic("XLVII") == 47;
        assert r.romanToArabic("XLVIII") == 48;
        assert r.romanToArabic("IL") == 49;
        assert r.romanToArabic("L") == 50;
        assert r.romanToArabic("LVII") == 57;
        assert r.romanToArabic("LXIV") == 64;
        assert r.romanToArabic("LXXI") == 71;
        assert r.romanToArabic("LXXVII") == 77;
        assert r.romanToArabic("LXXXIV") == 84;
        assert r.romanToArabic("XCI") == 91;
        assert r.romanToArabic("IC") == 99;
        assert r.romanToArabic("C") == 100;
        assert r.romanToArabic("CI") == 101;
        assert r.romanToArabic("CVIII") == 108;
        assert r.romanToArabic("CXI") == 111;
        assert r.romanToArabic("CXXVIII") == 128;
        assert r.romanToArabic("CXLIV") == 144;
        assert r.romanToArabic("CLXXI") == 171;
        assert r.romanToArabic("MCMXIV") == 1914;
        assert r.romanToArabic("MCMXVIII") == 1918;
        assert r.romanToArabic("MCMXXXIII") == 1933;
        assert r.romanToArabic("MCMXLV") == 1945;
        assert r.romanToArabic("MCMLXVI") == 1966;
        assert r.romanToArabic("MCMLXIX") == 1969;
        assert r.romanToArabic("MXMVII") == 1997;
        assert r.romanToArabic("MM") == 2000;
        assert r.romanToArabic("MMXIV") == 2014;
        assert r.romanToArabic("MMMDLV") == 3555;
    }
}