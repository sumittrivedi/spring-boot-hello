# Add utility compute endpoints

This pull request adds MathService and UtilsController to provide GET and POST endpoints at /api/utils/compute that compute addition, subtraction, multiplication, division (safe for divide-by-zero), gcd, lcm, and related utilities.

Files added:
- src/main/java/com/example/service/MathService.java
- src/main/java/com/example/controller/UtilsController.java

Usage:
- GET /api/utils/compute?a={a}&b={b}
- POST /api/utils/compute with JSON body { "a": number, "b": number }
