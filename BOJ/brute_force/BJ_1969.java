//22.05.22

package brute_force;

import java.io.*;

public class BJ_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] dna = new String[n];
        for (int i=0; i<n; i++) {
            dna[i] = br.readLine();
        }

        int[][] count = new int[m][20];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                count[j][dna[i].charAt(j)-'A']++;
            }
        }

        char[] list = {'A', 'C', 'G', 'T'};
        int totalDist=0;
        char[] result = new char[m];
        for (int i=0; i<m; i++) {
            int max = 0;
            char maxC = 'A';
            for (int j=0; j<4; j++) {
                if (count[i][list[j]-'A']>max) {
                    max = count[i][list[j]-'A'];
                    maxC = list[j];
                }
            }

            totalDist+=(n-max);
            result[i] = maxC;
        }

        for(char c:result) {
            bw.write(c);
        }
        bw.write("\n");
        bw.write(totalDist+"\n");
        bw.flush();
        bw.close();
    }
}