package pl.coderstrust.isthatfibonaccinumber;

import org.junit.jupiter.api.Test;

public class FibonacciCheckerTest {
    
    FibonacciChecker isThisFibonacciNumber = new FibonacciChecker ();

    @Test
    public void returnTrueIfNumberIsFibonacciNumber() {
        assertTrue(isThisFibonacciNumber.isFibonacciNumber(125L));
    }

    private void assertTrue(boolean fibbonaciNumber) {
    }

    @Test
    public void returnFalseIfNumberIsFibonacciNumber() {
        assertFalse(isThisFibonacciNumber.isFibonacciNumber(43566L));
    }

    private void assertFalse(boolean fibbonaciNumber) {
    }
}