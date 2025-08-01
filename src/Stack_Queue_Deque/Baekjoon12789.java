package Stack_Queue_Deque;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon12789 {

    /*
     * 1. 총 인원 수와 현재 줄에 서 있는 사람들의 번호를 입력받는다.
     * 2. 간식 배부 순서(order)는 항상 1번부터 시작하여 1씩 증가한다.
     * 3. 줄을 순서대로 순회하면서,
     * - 현재 사람이 순서(order)에 해당되면 바로 간식을 받는다.
     * - 순서가 아니면 스택(임시 대기 공간)에 넣는다.
     * 4. 사람을 처리하기 전, 스택에 있는 사람이 간식 받을 순서(order)라면
     * 스택에서 꺼내서 간식을 받게 한다 (여러 명일 경우 반복해서 처리).
     */
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int people[] = new int[total];
        for (int i = 0; i < total; i++) {
            people[i] = sc.nextInt();
        }
        solve(people);
        sc.close();
    }

    public static void solve(int people[]) {
        Stack<Integer> waiting = new Stack<Integer>();
        int order = 1;

        for (int i = 0; i < people.length; i++) {
            if (people[i] == order) {
                order++;
            } else {
                while (!waiting.isEmpty() && waiting.peek() == order) {
                    waiting.pop();
                    order++;
                }
                waiting.push(people[i]);
            }
            // 기존 코드
            // if (people[i] == order) {
            // order++;
            // 여기서 스택에 있는 순서를 계속 확인해 봐야 하지만, 한번만 스택에 있는걸 꺼내기 때문에, 틀렸다.
            // } else if (!waiting.empty() && waiting.peek() == order) {
            // waiting.pop();
            // order++;
            // } else {
            // waiting.push(people[i]);
            // }
        }

        while (!waiting.isEmpty() && waiting.peek() == order) {
            waiting.pop();
            order++;
        }

        if (waiting.empty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }

}
