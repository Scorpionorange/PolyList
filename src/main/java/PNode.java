/**
 * Created by ScorpionOrange on 2016/12/01.
 */
public class PNode {
    double rat; // 系数
    double exp; // 指数
    PNode next; // 指向下一个结点对象的引用

    public PNode(double rat, double exp){
        this.rat = rat;
        this.exp = exp;
        this.next = null;
    }

    public PNode(){
        this(0, 0);
    }

    public double getRat(){
        return rat;
    }

    public double getExp(){
        return exp;
    }

    public PNode getNext(){
        return next;
    }

    public void setRat(int rat){
        this.rat = rat;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void setNext(PNode node){
        this.next = node;
    }
}
