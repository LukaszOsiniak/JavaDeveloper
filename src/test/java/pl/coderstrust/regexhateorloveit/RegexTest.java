package pl.coderstrust.regexhateorloveit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RegexTest {
    @Disabled("The test took 38 min 23 sec.")
    @Test
    public void shouldReturnTrueForAllValidIpAdresses() {
        for (int pos1 = 0; pos1 <= 255; pos1++) {
            for (int pos2 = 0; pos2 <= 255; pos2++) {
                for (int pos3 = 0; pos3 <= 255; pos3++) {
                    for (int pos4 = 0; pos4 <= 255; pos4++) {
                        //given
                        String ipAdress = pos1 + "." + pos2 + "." + pos3 + "." + pos4;
                        //when
                        boolean checkedIp = Regex.isIpAdress(ipAdress);
                        //then
                        assertTrue(checkedIp);
                    }
                }
            }
        }
    }

    @Test
    public void shouldReturnTrueWhenValidIpNumbers() {
        for (int i = 0; i <= 255; i++) {
            //when
            boolean checkedIp = Regex.isIpAdress(i + ".0.0.0");
            //then
            System.out.println(i + " " + checkedIp);
            assertTrue(checkedIp);
        }
    }

    @ParameterizedTest
    @MethodSource("getIpFormula")
    public void shouldReturnFalseForInvalidIp(String input, boolean output) {
        //when
        boolean checkedIp = Regex.isIpAdress(input);
        //then
        assertEquals(output, checkedIp);
    }

    static Stream<Arguments> getIpFormula() {
        return Stream.of(
                arguments("-1.1.1.1", false),
                arguments("a.b.c.d", false),
                arguments("1.1.*.1", false),
                arguments("1.1", false),
                arguments("....", false)
        );
    }
}
