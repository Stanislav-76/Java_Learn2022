// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

package DZ_Java;

public class DZ6 {
    public static class BooleanHolder {
        public Boolean value;
    }

    public static void result(char[] a1, char[] b1, char[] c1, BooleanHolder flag) {
        char[] a = a1.clone();
        char[] b = b1.clone();
        char[] c = c1.clone();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (c[i] == '?') {
                        for (int i1 = 48; i1 < 58; i1++) {
                            c[i] = (char) i1;
                            result(a, b, c, flag);
                        }
                    }
                    if (b[j] == '?') {
                        for (int j1 = 48; j1 < 58; j1++) {
                            b[j] = (char) j1;
                            result(a, b, c, flag);
                        }
                    }
                    if (a[k] == '?') {
                        for (int k1 = 48; k1 < 58; k1++) {
                            a[k] = (char) k1;
                            result(a, b, c, flag);
                        }
                    }
                }
            }
        }
        if (Integer.parseInt(String.valueOf(a[0])) * 10
                + Integer.parseInt(String.valueOf(a[1]))
                + Integer.parseInt(String.valueOf(b[0])) * 10
                + Integer.parseInt(String.valueOf(b[1])) 
                == Integer.parseInt(String.valueOf(c[0])) * 10
                + Integer.parseInt(String.valueOf(c[1]))) {
            System.out.println(String.valueOf(a[0]) + String.valueOf(a[1]) + " + "
                    + String.valueOf(b[0]) + String.valueOf(b[1])
                    + " = " + String.valueOf(c[0]) + String.valueOf(c[1]));
            flag.value = true;
        }
    }

    public static void main(String[] args) {
        String q = "2?";
        String w = "?5";
        String e = "69";
        char[] q_array = q.toCharArray();
        char[] w_array = w.toCharArray();
        char[] e_array = e.toCharArray();
        BooleanHolder flag = new BooleanHolder();
        flag.value = false;
        result(q_array, w_array, e_array, flag);
        if (flag.value != true) {
            System.out.println("Решений нет");
        }
    }
}