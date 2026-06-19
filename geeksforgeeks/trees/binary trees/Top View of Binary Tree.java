/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Nodeinfo{
        int col;
        int row;
        int val;
        Nodeinfo(int col,int row,int val){
            this.col=col;
            this.row=row;
            this.val=val;
        }
    }
    List<Nodeinfo> Nodes=new ArrayList<>();
    public ArrayList<Integer> topView(Node root) {
        dfs(root,0,0);
        Collections.sort(Nodes,(a,b)->{
            if(a.col!=b.col) return a.col-b.col;
            return a.row-b.row;
        });
        ArrayList<Integer> result=new ArrayList<>();
        int prevcol=Integer.MIN_VALUE;
        for(Nodeinfo node:Nodes){
            if(node.col!=prevcol){
                result.add(node.val);
                prevcol=node.col;
            }
        }
        return result;
    }
    private void dfs(Node root,int col,int row){
        if(root==null)return;
        Nodes.add(new Nodeinfo(col,row,root.data));
        dfs(root.left,col-1,row+1);
        dfs(root.right,col+1,row+1);
    }
}
