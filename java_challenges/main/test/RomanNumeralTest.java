import org.junit.Test;

public class RomanNumeralTest {

    @Test
    public void testArabicToRoman() {
        RomanNumeral r = new RomanNumeral();
        for (int i = 1; i <= 3999; i++) {
            int arabic = r.romanToArabic(r.arabicToRoman(i));
            assert arabic == i;
        }
    }

    @Test
    public void testRomanToArabic() {
        RomanNumeral r = new RomanNumeral();
        int arabic;
        //noinspection SpellCheckingInspection
        final String[][] testCases = {
                {"I", "1"}, {"II", "2"}, {"III", "3"}, {"IV", "4"}, {"V", "5"}, {"VI", "6"}, {"VII", "7"},
                {"VIII", "8"}, {"IX", "9"}, {"X", "10"}, {"XI", "11"}, {"XII", "12"}, {"XIII", "13"}, {"XIV", "14"},
                {"XV", "15"}, {"XVI", "16"}, {"XVII", "17"}, {"XVIII", "18"}, {"XIX", "19"}, {"XX", "20"},
                {"XXI", "21"}, {"XXII", "22"}, {"XXIII", "23"}, {"XXIV", "24"}, {"XXV", "25"}, {"XXVI", "26"},
                {"XXVII", "27"}, {"XXVIII", "28"}, {"XXIX", "29"}, {"XXX", "30"}, {"XXXI", "31"}, {"XXXII", "32"},
                {"XXXIII", "33"}, {"XXXIV", "34"}, {"XXXV", "35"}, {"XXXVI", "36"}, {"XXXVII", "37"},
                {"XXXVIII", "38"}, {"IXL", "39"}, {"XL", "40"}, {"XLI", "41"}, {"XLII", "42"}, {"XLIII", "43"},
                {"XLIV", "44"}, {"XLV", "45"}, {"XLVI", "46"}, {"XLVII", "47"}, {"XLVIII", "48"}, {"IL", "49"},
                {"L", "50"}, {"LVII", "57"}, {"LXIV", "64"}, {"LXXI", "71"}, {"LXXVII", "77"}, {"LXXXIV", "84"},
                {"XCI", "91"}, {"IC", "99"}, {"C", "100"}, {"CI", "101"}, {"CVIII", "108"}, {"CXI", "111"},
                {"CXXVIII", "128"}, {"CXLIV", "144"}, {"CLXXI", "171"}, {"MCMXIV", "1914"}, {"MCMXVIII", "1918"},
                {"MCMXXXIII", "1933"}, {"MCMXLV", "1945"}, {"MCMLXVI", "1966"}, {"MCMLXIX", "1969"},
                {"MXMVII", "1997"}, {"MM", "2000"}, {"MMXIV", "2014"}, {"MMMDLV", "3555"}};
        for (String[] test : testCases) {
            arabic = r.romanToArabic(test[0]);
            assert arabic == Integer.valueOf(test[1]);
        }
    }
}