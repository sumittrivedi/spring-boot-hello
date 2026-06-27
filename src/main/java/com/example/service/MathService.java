package com.example.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class MathService {

    public BigInteger add(long a, long b) {
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b));
    }

    public BigInteger subtract(long a, long b) {
        return BigInteger.valueOf(a).subtract(BigInteger.valueOf(b));
    }

    public BigInteger multiply(long a, long b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
    }

    public Double divide(long a, long b) {
        if (b == 0) return null;
        return (double) a / (double) b;
    }

    public BigInteger gcd(long a, long b) {
        BigInteger A = BigInteger.valueOf(a).abs();
        BigInteger B = BigInteger.valueOf(b).abs();
        if (A.equals(BigInteger.ZERO) && B.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        return A.gcd(B);
    }

    public BigInteger lcm(long a, long b) {
        if (a == 0 || b == 0) return BigInteger.ZERO;
        BigInteger A = BigInteger.valueOf(a).abs();
        BigInteger B = BigInteger.valueOf(b).abs();
        BigInteger gcd = A.gcd(B);
        return A.divide(gcd).multiply(B);
    }

    public Map<String, Object> compute(long a, long b) {
        Map<String, Object> result = new HashMap<>();
        result.put("a", a);
        result.put("b", b);
        result.put("addition", add(a, b).toString());
        result.put("subtraction", subtract(a, b).toString());
        result.put("multiplication", multiply(a, b).toString());
        Double division = divide(a, b);
        result.put("division", division == null ? null : division);
        result.put("gcd", gcd(a, b).toString());
        result.put("lcm", lcm(a, b).toString());
        // extras
        result.put("absA", BigInteger.valueOf(a).abs().toString());
        result.put("absB", BigInteger.valueOf(b).abs().toString());
        return result;
    }
}
