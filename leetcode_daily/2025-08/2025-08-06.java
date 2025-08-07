"""
Date: August 6, 2025
Problem:fruit-into-baskets-iii (LeetCode #3479)
Link:https://leetcode.com/problems/fruits-into-baskets-iii/description/
"""
 class SegmentTree{
    int[] tree;
    int n;

    SegmentTree(int[] nums){
        n=nums.length;
        tree=new int[4*n];  //  it's a standard trick to avoid dynamic resizing. we don’t always use all of it, but it guarantees no index out of bounds.
        buildTree(tree,0,nums,0,n-1);
    }

    void buildTree(int[] tree,int node, int[] nums, int left, int right){
        if(left==right){
            tree[node] = nums[left];
            return;
        }

        int mid = (right + left) / 2;
        buildTree(tree,2*node+1,nums,left,mid);
        buildTree(tree,2*node+2,nums,mid+1,right);

        tree[node] = Math.max(tree[2*node+1],tree[2*node+2]);
    }

    int searchRange(int l, int r){
        return searchUtil(0,0,n-1,l,r);
    }

    int searchUtil(int node,int left,int right,int l,int r){
        if(r<left || l>right) return 0; // The current node's range [left, right] is completely outside the query range [l, r]

        if(l<=left && r>=right){
            return tree[node];
        }

        int mid = (right+left)/2;
        int leftMax = searchUtil(2*node+1,left,mid,l,r);
        int rightMax = searchUtil(2*node+2,mid+1,right,l,r);

        return Math.max(leftMax,rightMax);
    }

    void update(int idx, int val){
        updateUtil(tree,0,0,n-1,idx,val);
    }

    void updateUtil(int[] tree, int node, int left, int right, int idx, int val){
        if(left==right){
            tree[node]=val;
            return;
        }
        int mid = (right+left)/2;

        if(idx<=mid){
            updateUtil(tree,2*node+1,left,mid,idx,val);
        }else{
            updateUtil(tree,2*node+2,mid+1,right,idx,val);
        }

        tree[node]=Math.max(tree[2*node+1],tree[2*node+2]);
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int cnt=0;
        SegmentTree s =  new SegmentTree(baskets);
        
        for(int i=0;i<n;i++){
            int res =-1, left = 0, right = n-1;
            while(left<=right){ // Is there any basket in the range [left, mid] that can hold the current fruit?
                int mid = (right + left)/2;
                if(s.searchRange(left,mid)>=fruits[i]){
                    res = mid;
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            if(res!=-1 && baskets[res]>=fruits[i]){
                s.update(res,0);
            }else{
                cnt++;
            }
        }
       return cnt;
    }
}

 
