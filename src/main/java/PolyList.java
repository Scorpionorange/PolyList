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

        while (current != null){
            rat.delete(0, rat.length());
            exp.delete(0, exp.length());
            tmp.delete(0, tmp.length());

            if(current.getRat() == 1){
                rat.append("");
            }
            else {
                rat.append(String.valueOf(current.getRat()));
            }

            if(current.getExp() == 1){
                exp.append("");
                tmp.append(rat.toString()).append("x").append(exp.toString());
            }
            else {
                exp.append(String.valueOf(current.getExp()));
            }

            if(current.getExp() > 0){
                tmp.append(rat.toString()).append("x^").append(exp.toString());
            }
            else {
                // 指数为负数时加括号
                tmp.append(rat.toString()).append("x^(").append(exp.toString()).append(")");
            }

            if(current == head.getNext()){
                rst.append(tmp.toString());
            }
            else {
                if(current.getRat() > 0){
                    rst.append("+").append(tmp.toString());
                }
                else {
                    // 系数<0时自动带有负号
                    rst.append(tmp.toString());
                }
            }
            current = current.getNext();
        }
        return rst.toString();
    }

    public static PolyList add(PolyList pl1, PolyList pl2){
        PolyList result = new PolyList();
        // 分别指向pl1，pl2的第一个元素
        pl1.current = pl1.head.getNext();
        pl2.current = pl2.head.getNext();

        while (pl1.current != null && pl2.current != null){
            if(pl1.current.getExp() == pl2.current.getExp()){
                result.insert(new PNode(pl1.current.getRat() + pl2.current.getRat(), pl1.current.getExp()));
                pl1.current = pl1.current.getNext();
                pl2.current = pl2.current.getNext();
            }
            else if(pl1.current.getExp() < pl2.current.getExp()){
                result.insert(pl1.current);
                pl1.current = pl1.current.getNext();
            }
            else {
                result.insert(pl2.current);
                pl2.current = pl2.current.getNext();
            }
        }

        while (pl1.current != null){
            result.insert(pl1.current);
            pl1.current = pl1.current.getNext();
        }

        while (pl2.current != null){
            result.insert(pl2.current);
            pl2.current = pl2.current.getNext();
        }

        return result;
    }

    public static void main(String[] args){
        PolyList polyList1 = new PolyList();
        PolyList polyList2 = new PolyList();

        // 设置第一组第一个节点值
        PNode pNode1 = new PNode();
        pNode1.setExp(2);
        pNode1.setRat(2);
        // 设置第一组第二个节点值
        PNode pNode2 = new PNode();
        pNode2.setExp(3);
        pNode2.setRat(100);
        // 插入数据
        polyList1.insert(pNode1);
        polyList1.insert(pNode2);

        // 设置第二组第一个节点值
        PNode pNode3 = new PNode();
        pNode3.setExp(50);
        pNode3.setRat(33);
        // 插入数据
        polyList2.insert(pNode3);

        System.out.println("打印第一组数据：" + polyList1.print());
        System.out.println("打印第二组数据：" + polyList2.print());
    }
}
