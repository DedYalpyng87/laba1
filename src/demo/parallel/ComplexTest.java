package demo.parallel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ComplexTest {

    private static final double EPS = 1e-9;

    @Test
    public void minusShouldSubtractRealAndImaginaryParts() {
        Complex a = new Complex(5.0, 3.0);
        a.minus(new Complex(2.0, 1.0));

        assertEquals(3.0, getRe(a), EPS);
        assertEquals(2.0, getIm(a), EPS);
    }

    @Test
    public void conjugateShouldInvertImaginarySign() {
        Complex a = new Complex(4.0, -7.0);
        a.conjugate();

        assertEquals(4.0, getRe(a), EPS);
        assertEquals(7.0, getIm(a), EPS);
    }

    // Вспомогательные методы через reflection, потому что поля re/im private
    private double getRe(Complex c) {
        try {
            java.lang.reflect.Field f = Complex.class.getDeclaredField("re");
            f.setAccessible(true);
            return f.getDouble(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private double getIm(Complex c) {
        try {
            java.lang.reflect.Field f = Complex.class.getDeclaredField("im");
            f.setAccessible(true);
            return f.getDouble(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}