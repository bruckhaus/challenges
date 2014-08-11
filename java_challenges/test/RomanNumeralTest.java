import org.junit.Test;

public class RomanNumeralTest {
    @Test
    public void testRomanToArabic() {
        assert RomanNumeral.romanToArabic("I") == 1;
        assert RomanNumeral.romanToArabic("II") == 2;
        assert RomanNumeral.romanToArabic("III") == 3;
        assert RomanNumeral.romanToArabic("IV") == 4;
        assert RomanNumeral.romanToArabic("V") == 5;
        assert RomanNumeral.romanToArabic("VI") == 6;
        assert RomanNumeral.romanToArabic("VII") == 7;
        assert RomanNumeral.romanToArabic("VIII") == 8;
        assert RomanNumeral.romanToArabic("IX") == 9;
        assert RomanNumeral.romanToArabic("X") == 10;
        assert RomanNumeral.romanToArabic("XI") == 11;
        assert RomanNumeral.romanToArabic("XII") == 12;
        assert RomanNumeral.romanToArabic("XIII") == 13;
        assert RomanNumeral.romanToArabic("XIV") == 14;
        assert RomanNumeral.romanToArabic("XV") == 15;
        assert RomanNumeral.romanToArabic("XVI") == 16;
        assert RomanNumeral.romanToArabic("XVII") == 17;
        assert RomanNumeral.romanToArabic("XVIII") == 18;
        assert RomanNumeral.romanToArabic("XIX") == 19;
        assert RomanNumeral.romanToArabic("XX") == 20;
        assert RomanNumeral.romanToArabic("XXI") == 21;
        assert RomanNumeral.romanToArabic("XXII") == 22;
        assert RomanNumeral.romanToArabic("XXIII") == 23;
        assert RomanNumeral.romanToArabic("XXIV") == 24;
        assert RomanNumeral.romanToArabic("XXV") == 25;
        assert RomanNumeral.romanToArabic("XXVI") == 26;
        assert RomanNumeral.romanToArabic("XXVII") == 27;
        assert RomanNumeral.romanToArabic("XXVIII") == 28;
        assert RomanNumeral.romanToArabic("XXIX") == 29;
        assert RomanNumeral.romanToArabic("XXX") == 30;
        assert RomanNumeral.romanToArabic("XXXI") == 31;
        assert RomanNumeral.romanToArabic("XXXII") == 32;
        assert RomanNumeral.romanToArabic("XXXIII") == 33;
        assert RomanNumeral.romanToArabic("XXXIV") == 34;
        assert RomanNumeral.romanToArabic("XXXV") == 35;
        assert RomanNumeral.romanToArabic("XXXVI") == 36;
        assert RomanNumeral.romanToArabic("XXXVII") == 37;
        assert RomanNumeral.romanToArabic("XXXVIII") == 38;
        assert RomanNumeral.romanToArabic("IXL") == 39;
        assert RomanNumeral.romanToArabic("XL") == 40;
        assert RomanNumeral.romanToArabic("XLI") == 41;
        assert RomanNumeral.romanToArabic("XLII") == 42;
        assert RomanNumeral.romanToArabic("XLIII") == 43;
        assert RomanNumeral.romanToArabic("XLIV") == 44;
        assert RomanNumeral.romanToArabic("XLV") == 45;
        assert RomanNumeral.romanToArabic("XLVI") == 46;
        assert RomanNumeral.romanToArabic("XLVII") == 47;
        assert RomanNumeral.romanToArabic("XLVIII") == 48;
        assert RomanNumeral.romanToArabic("IL") == 49;
        assert RomanNumeral.romanToArabic("L") == 50;
    }
}