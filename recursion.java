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

  // 문자열의 길이 계산

if the string is empty
  return 0;
else 
  return 1 plus the length of the string that excludes the first character;

public static int length(String str) {
    if (str.equals(""))
        return 0;
    else
        return 1+length(str.substring(1));
}

// 문자열의 프린트
public static void printChars(String str) {
    if (str.length () == 0)
        return;
    else {
        System.put.print(str.charAt(0));
        printChars(str.substring(1));
    }
}

// 문자열을 뒤집어 프린트
public static void printCharsReverse(String str) {
    if (str.length()==0)
        return;
    else {
        printCharsReverse(str.substring(1));
        Sysyem.out.print(str.charAt(0));
    }
}

// 2진수로 변환하여 출력
public void printInBinary(int n) {
    if (n<2)
        System.out.print(n);
    else {
        printInBinary(n/2);
        System.out.print(n%2);
    }
}

/* 배열의 합 구하기
data[0]에서 data[n-1]까지의 합을 구하여 반환 
*/

public static int sum(int n, int [] data) {
    if (n<=0)
        return 0;
    else
        return sum(n-1, data) + data[n-1];
    
/* 데이터파일로 부터 n개의 정수 읽어오기
Scanner in이 참조하는 파일로 부터 n개의 정수를 입력받아 배열 data의 data[0],...,data[n-1]에 저장
*/
public void readFrom(int n , int [] data, Scanner in){
    if (n==0)
        return;
    else {
        readFrom(n-1, data, in);
        data[n-1] = in.nextInt();
    }
}
    
/* Recursion vs Iteration
- 모든 순환함수는 반복문(Iteration)으로 변경 가능
- 그 역도 성립함. 모든 반복문은 recursion으로 표현 가능
- 순환함수는 복잡한 알고리즘을 단순하고 알기쉽게 표현하는 것을 가능하게 함
- 하지만 함수 호출에 따른 오버헤드가 있음 (매개변수 전달, 액티베이션 프레임 생성 등)
*/

  /* 순환적 알고리즘 설계
- 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야 함
- 모든 case는 결국 base case로 수렴해야 함
*/

/* 암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꾸어라 */

// 순차 탐색

/* 함수의 미션은 data[0]에서 data[n-1] 사이에서 target 을 검색하는 것. 하지만 검색 구간의 시작 인덱스 0은 보통 생략
즉, 암시적 매개변수 */

int search(int [] data, int n, int target) {
  for (int i=0; i<n; i++)
    if (data[i]==target)
      return i;
  return -1;
}

// 매개변수의 명시화: 순차 탐색

/* 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색. 즉, 검색 구간의 시작점을 명시적(explicit)으로 지정
이 함수를 search(data, 0, n-1, target)으로 호출한다면 앞 페이지의 함수와 완전히 동일한 일을 수행 */

int search(int [] data, int begin, int end, int target) {
    if (begin>end) //데이터0, begin==end 데이터 한개
        return -1;
    else if (target=items[begin])
        return begin;
    else
        return search(data, begin+1, end, target);
}

/* 순차 탐색: 다른 버전
data[begin]에서 data[end] 사이에서 target을 검색. 즉, 검색구간의 시작점을 명시적(explicit)으로 지정
*/

int search(int [] data, int begin, int end, int target) {
    if (begin>end) //데이터0, begin==end 데이터 한개
        return -1;
    else if (target=items[end])
        return end;
    else
        return search(data, begin, end-1, target);
}

int search(int [] data, int begin, int end, int target) {
    if (begin>end) //데이터0, begin==end 데이터 한개
        return -1;
    else {
        int middle = (begin+end)/2;
        if (items[middle]==target)
            return middle;
        int index = search(data, begin, middle-1,target);
        if (index != -1)
            return index;
        else
            return search(data, middle+1, end, target);
    else
        return search(data, begin, end-1, target);
    }
}// binary search와는 다름


/* 매개변수의 명시화: 최대값 찾기
data[begin]에서 data[end] 사이에서 최대값을 찾아 변환한다. begin<=end라고 가정 
*/

int findMax(int [] data, int begin, int end) {
    if (begin==end)
        return data[begin];
    else
        return Math.max(data[begin], findMax(data, begin+1, end));
}

// 최대값 찾기: 다른 버전
int findMax(int [] data, int begin, int end) {
    if (begin==end)
        return data[begin];
    else
        int middle=(begin+end)/2;
        int max1=findMax(data,begin,middle);
        int max2=findMax(data, middle+1,end);
        return Math.max(max1,max2));
}


/* Binart Search
items[begin]에서 items[end]사이에서 target을 검색
*/

public static int binarySearch(String[] items, String target, int begin, int end) {
    if (begin>end)
        return -1;
    else
        int middle = (begin+end)/2;
        int compResult=target.compareTo(items[middle]);
        if (compResult ==0)
            return middle;
        else if (compResult<0)
            return binarySearch(items, target, begin, middle-1);
        else
            return binarySearch(items, target, middle+1,end);
    }
}
