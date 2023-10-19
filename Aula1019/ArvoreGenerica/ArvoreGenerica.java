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
            if(i>=0 && i<subtrees.size())
                return subtrees.get(i);
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

    private Node findNode(Node ref, Integer value){
        if(ref!=null){
            if(ref.value==value)
                return ref;
            else{
                Node aux = null;
                for(int i=0; i< ref.getSubtreeSize(); i++){
                    aux=findNode(ref.getSubtree(i), value);
                    if(aux!=null) return aux;
                }                                
            }
        }

        return null;
    }

    public boolean add(Integer e, Integer father){
        if(father==null){
            if(nElements==0){
                setRoot(e);
                return true;
            }
        }
        else{
            Node aux = findNode(root, father);
            if(aux!=null){
                System.out.println("Achou o pai");
            // adicionar o e como filho de father
                aux.addSubtree(new Node(e));
                nElements++;
                return true;                
            }
            System.out.println("NÃO Achou o pai");
        }
        return false;      
    }

    private void print(Node ref){
        if(ref.father==null)
            System.out.print("("+ref.value+"- RAIZ), ");
        else
            System.out.print("("+ref.value+"-"+ref.father.value+"), ");

        for(Node aux: ref.subtrees)
            print(aux);
    }
    public void print(){
        print(root);
        System.out.println();
    }

    public String toString(){
        return "[árvore vazia]";
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