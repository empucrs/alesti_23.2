import java.util.ArrayList;
import java.util.List;

public class ArvoreGenerica {

    private class Node {
        public Integer value;
        public Node father;
        public List<Node> subtrees;
        public Node(Integer e){
            value=e;
            father=null;
            subtrees = new ArrayList<>();
        }
        public void addSubtree(Node n){
            subtrees.add(n);
            n.father=this;
        }
        public boolean removeSubtree(Node n){
            return false;
        }
        public Node getSubtree(int i){
            return null;
        }
        public int getSubtreeSize(){
            return subtrees.size();
        }
        public String toString(){
            return this.value.toString();
        }
    }

    //-=-=-=-=-=-= 
    // Detalhamento da árvore
    private int nElements;
    private Node root;

    public ArvoreGenerica(){
        nElements=0;
        root=null;
    }

    public boolean add(Integer e, Integer father){
        if(father==null){
            if(nElements==0){
                setRoot(e);
                return true;
            }
        }
        else{
            // investigar se o pai existe
            if(father==root.value){
            // adicionar o e como filho de father
                root.addSubtree(new Node(e));
                nElements++;
                return true;                
            }
        }
        return false;      
    }

    public String toString(){
        if(root==null)
            return "[árvore vazia]";
        else{
            return "root: " + root.value + " ("+root.subtrees.size()+") -> " + root.subtrees;
        }
    }

    public Integer getRoot(){        
        if(root==null)
            return null;
        else
            return root.value;
    }
    
    public void setRoot(Integer e){
        if(root==null){
            root = new Node(e);
            nElements++;
        }
    }

    public Integer getParent(Integer e){
        return 0;
    }

    public boolean removeBranch(Integer e){
        return false;
    }

    public boolean contains(Integer e){
        return false;
    }
    public boolean isInternal(Integer e){
        return false;
    }
    public boolean isExternal(Integer e){
        return false;
    }
    public boolean isRoot(Integer e){
        if(root==null) return false;
        return (root.value==e);
    }
    public boolean isEmpty(){
        return (nElements==0);
    }
    public int size(){
        return nElements;
    }
    public void clear(){
        root=null;
        nElements=0;
    }
    public List<Integer> positionPos(){
        return null;
    }
    public List<Integer> positionPre(){
        return null;
    }
    public List<Integer> positionWidth(){
        return null;
    }    
}