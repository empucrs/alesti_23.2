import java.util.List;

public class ArvoreBinaria {

    private class Node{
        public Integer element;
        public Node father;
        public Node left;
        public Node right;
        public Node(Integer e){
            element=e;
            father=left=right=null;
        }
    }

    Node root;
    int nElements;

    public ArvoreBinaria(){
        root=null;
        nElements=0;
    }

    public boolean addRoot(Integer e){
        if((root==null)&&(e!=null)){
            root=new Node(e);
            nElements=1;
            return true;
        }
        return false;
    }
    private Node findNode(Node ref, Integer value){

        if(ref!=null){
            if(ref.element==value)
                return ref;
            else{
                Node aux;
                aux = findNode(ref.left, value);
                if(aux!=null) return aux;
                aux = findNode(ref.right, value);
                return aux;
            }
        }
        return null;

    }

    public boolean addLeft(Integer e, Integer father){
        if( (father!=null)&& (e!=null) ){
            Node findIt = findNode(root, father);
            if((findIt!=null) && (findIt.left==null) ){
                Node aux = new Node(e);
                findIt.left=aux;
                aux.father=findIt;
                nElements++;
                return true;
            }
        }
        return false;
    }
    public boolean addRight(Integer e, Integer father){
        if( (father!=null)&& (e!=null) ){
            Node findIt = findNode(root, father);
            if((findIt!=null) && (findIt.right==null) ){
                Node aux = new Node(e);
                findIt.right=aux;
                aux.father=findIt;
                nElements++;
                return true;
            }
        }
        return false;
    }
    public boolean hasRight(Integer element){
        if( (element!=null)&&
            (root!=null)&&
            (root.element==element)&&
            (root.right!=null))
            return true;
        return false;
    }
    public boolean hasLeft(Integer element){
        if( (element!=null)&&
            (root!=null)&&
            (root.element==element)&&
            (root.left!=null))
            return true;
        return false;
    }
    public Integer getParent(Integer e){
        return null;
    }
    public boolean isInternal(Integer e){
        if((root.left!=null) || (root.right!=null))
            return true;
        return false;
    }
    public boolean isExternal(Integer e){
        if((root.left==null) && (root.right==null))
            return true;
        return false;
    }
    public boolean removeBranch(Integer e){
        return false;
    }
    public boolean contains(Integer e){
        if( (e!=null)&&
            (root!=null)&&
            (root.element==e))
            return true;
        return false;
    }
    public boolean isEmpty(){
        return (nElements==0);
    }
    public void clear(){
        root=null;
        nElements=0;
    }
    public int size(){
        return nElements;
    }
    public Integer getRoot(){
        if(root==null)
            return null;
        return root.element;
    }
    public void setRoot(Integer e){
        if( (e!=null)&&(root!=null))
            root.element=e;
    }
    public Integer getLeft(Integer e){
        if( (e!=null)&&
            (root!=null)&&
            (root.element==e)&&
            (root.left!=null))
            return root.left.element;
        return null;
    }
    public Integer getRight(Integer e){
        if( (e!=null)&&
            (root!=null)&&
            (root.element==e)&&
            (root.right!=null))
            return root.right.element;
        return null;
    }
    public List<Integer> positionsPre(){
        return null;
    }
    public List<Integer> positionsCentral(){
        return null;
    }
    public List<Integer> positionsPos(){
        return null;
    }
    public List<Integer> positionsWidth(){
        return null;
    }
}