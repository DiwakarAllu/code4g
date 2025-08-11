class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        HashSet<Character>[] rows=new HashSet[n];
        HashSet<Character>[] cols=new HashSet[n];
        HashSet<Character>[] boxes=new HashSet[n];
        
        for(int i=0;i<n;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            boxes[i]=new HashSet<>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char x=board[i][j];

                if(x=='.') continue;

                if(rows[i].contains(x)) return false;
                rows[i].add(x);

                if(cols[j].contains(x)) return false;
                cols[j].add(x);

                int bi = (i / 3) * 3 + (j / 3); // Why (i / 3) * 3 + (j / 3)?	Gives unique index (0–8) for each box
                if(boxes[bi].contains(x)) return false;
                boxes[bi].add(x);
                
            }
        }
        return true;
    }
}
