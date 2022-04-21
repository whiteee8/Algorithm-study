package math;

import java.io.*;

public class BJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        boolean[] num = new boolean[n+1];
        int p=2;
        int count=0;
        while (count<k){
            for (int i=p; i<=n; i+=p) {
                if (num[i]==false) {
                    num[i] = true;
                    count++;
                    if (count==k) {
                        bw.write(i+"");
                        bw.flush();
                        bw.close();
                    }
                }
            }

            for (int i=p; i<=n; i++){
                if (num[i]==false){
                    p=i;
                    break;
                }
            }

        }
    }
}
