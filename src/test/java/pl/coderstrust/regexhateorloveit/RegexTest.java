package pl.coderstrust.regexhateorloveit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
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
            boolean isValidIpPos1 = Regex.isIpAdress(i + ".0.0.0");
            boolean isValidIpPos2 = Regex.isIpAdress("0." + i + ".0.0");
            boolean isValidIpPos3 = Regex.isIpAdress("0.0." + i + ".0");
            boolean isValidIpPos4 = Regex.isIpAdress("0.0.0." + i);
            //then
            assertTrue(isValidIpPos1);
            assertTrue(isValidIpPos2);
            assertTrue(isValidIpPos3);
            assertTrue(isValidIpPos4);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidIpAdresses")
    public void shouldReturnFalseForInvalidIp(String input) {
        //when
        boolean isValidIp = Regex.isIpAdress(input);
        //then
        assertFalse(isValidIp);
    }

    static Stream<Arguments> provideInvalidIpAdresses() {
        return Stream.of(
                arguments("-1.1.1.1"),
                arguments("a.b.c.d"),
                arguments("abcd"),
                arguments(""),
                arguments("1.1.*.1"),
                arguments("1.1"),
                arguments("....")
        );
    }

    @Test
    public void shouldReturnFalseForNullValue() {
        //when
        boolean isValidIp = Regex.isIpAdress(null);
        //then
        assertFalse(isValidIp);
    }

    @ParameterizedTest
    @MethodSource("provideValidIpAdresses")
    public void shouldReturnTrueForValidIp(String ipAdress) {
        //when
        boolean isValidIp = Regex.isIpAdress(ipAdress);
        //then
        assertTrue(isValidIp);
    }

    static Stream<Arguments> provideValidIpAdresses() {
        return Stream.of(
                arguments("0.0.0.0"),
                arguments("1.10.100.101"),
                arguments("11.110.111.120"),
                arguments("200.201.210.250"),
                arguments("255.255.255.255")
        );
    }
}
