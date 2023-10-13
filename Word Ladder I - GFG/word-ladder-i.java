//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        ArrayDeque<pair>q=new ArrayDeque<>();
        q.add(new pair(1,beginWord));
        Set<String>set=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        // set.remove(beginWord);

        while(!q.isEmpty()){
            pair cur=q.poll();
            String w=cur.word;
            int s=cur.step;
            if(w.equals(endWord))
                return s;

            for(int i=0;i<w.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedChar[]=w.toCharArray();
                    replacedChar[i]=ch;
                    String newW=new String(replacedChar);
                    if(set.contains(newW)){
                        set.remove(newW);
                        q.add(new pair(s+1,newW));
                    }

                }
            }    


        }
        return 0;
    }
}
class pair{
    String word;
    int step;
    pair(int step,String word){
        this.step=step;
        this.word=word;
    }
}