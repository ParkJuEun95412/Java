// Recursion : 순환, 재귀함수
// 자기 자신을 호출하는 함수(메소드)
void func(...)
{
  ...
  func(...);
  ...
}

// 메인메소드 
public class Code01 {
  public static void main(String [] args) {
    func(); // 호출시 무한루프에 빠지게 된다.
  }

# 함수func정의  
  public static void func() {
    System.out.println("Hello...");
    func();
  }
}

// recursion은 항상 무한루프에 빠질까? 
public class Code02 {
    public static void main(String [] args) {
        int n = 4;
        func(n);
    }
    
    public static void func(int k) {
        if (k<=0)
            return; // Base case: 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 함
        else {
            System.out.println("Hello...");
            func(n-1); // Recursive case: recursion을 반복하다보면 결국 basecase로 수렴
    }
}

public class Code03 { 
    public static void main(String [] args) {
        int result = func(4);
    }
    
    // 0~n까지의 합을 구함
    public static int func(int n) { 
        if (n==0)
            return 0;
        else
            return n + func(n-1);
     }
}

// recursion의 해석

public static int func(int n) { // 함수의 미션은 0~n까지의 합을 구하는 것
    if (n==0) 
        return 0; // n=0이라면 합은 0
    else
        return n + func(n-1); // n이 0보다 크다면 0에서 n까지의 합은 0에서 n-1까지의 합에 n을 더한 것
}

// 순환함수와 수학적 귀납법

/* Factorial : n!
 0! = 1
 n! = nx(n-1)! n>0
*/
  
public static int factorial(int n)
{  
    if (n==0)
        return 1:
    else
        return n*factorial(n-1);
}

// x의 n승

public static double power(double x, int n) {
    if (n==0)
        return 1;
    else
        return x*power(x,n-1);
}

// Fibonacci number

public int fibonacci(int n){
    if (n>2)
        return n;
    else
        return fibonacci(n-1) + fibonacci(n-2);
}


/* 최대공약수: Euclid Method
 m>=n인 두 양의 정수 m과 n에 대해서 m이 n의 배수이면 gcd(m,n)=n이고, 그렇지 않으면 gcd(m,n)=gcd(n,m%n)
*/
  
public static double gcd(int m, int n) {
    if (m<n) {
        int tmp=m; m=n; n=tmp; //swap m and n
    }
    if (m%n==0)
        return n;
    else 
        return gcd(n, m%n);        
}
    
    
public static int gcd(int p, int q) {
    if (q==0)
        return p;
    else
        return gcd(q,p%q);
 }
