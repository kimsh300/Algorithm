import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int answer = gcd(a, b);
            answer = Math.max(a, b) / answer * Math.min(a, b);
            System.out.println(answer);
        }

        sc.close();
    }

    /*
     * 유클리드 호제법 (기초 정수론 문제 자주 나온다.)
     * 1.큰 수를 작은 수로 나눈다.
     * 2.나누는 수를 나머지로 계속 나눈다.
     * 3.나머지가 0이 나오면 나누는 수가 최대공약수이다.
     * 최대공약수 구할 때 사용
     */
    public static int gcd(int a, int b) {

        int r = a % b;
        if (r == 0)
            return b;

        return gcd(b, r);
    }
}
