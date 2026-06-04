class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // even indices
        long odd = n / 2;        // odd indices

        long ans = (power(5, even) * power(4, odd)) % MOD;
        return (int) ans;
    }
    private long power(long base, long exp) {
    long result = 1;

    // Keep base within MOD to avoid overflow
    base = base % MOD;

    while (exp > 0) {

        // If exponent is odd → multiply result with base
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        // Square the base
        base = (base * base) % MOD;

        // Divide exponent by 2
        exp = exp / 2;
    }

        return result;
        }
    }