/**
 * Created by ScorpionOrange on 2016/12/01.
 */
public class PolyList {
    PNode head;
    PNode current;

    public PolyList(){
        head = new PNode();
        current = head;
        head.setNext(null);
    }

    public boolean isEmpty(){
        // 如果链表头部的next不为空（代表有数据）
        if(head.getNext() != null){
            return true;
        }
        return false;
    }

    public void insert(PNode node){
        current.setNext(node);
        current = node;
    }

    public String print(){
        StringBuilder rst = new StringBuilder("");
        StringBuilder rat = new StringBuilder("");
        StringBuilder exp = new StringBuilder("");
        StringBuilder tmp = new StringBuilder("");

        current = head.getNext();

        return rst.toString();
    }
}
