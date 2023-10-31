import java.util.ArrayList;
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
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if((aux!=null) && (aux.right!=null))
                return true;
        }
        return false;
    }
    public boolean hasLeft(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if((aux!=null) && (aux.left!=null))
                return true;
        }
        return false;
    }
    public Integer getParent(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if((aux!=null)&&(aux!=root))
                return aux.father.element;
        }
        return null;
    }
    public boolean isInternal(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if(aux!=null)
                return ((aux.left!=null) || (aux.right!=null));
        }
        return false;
    }
    public boolean isExternal(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if(aux!=null)
                return ((aux.left==null) && (aux.right==null));
        }
        return false;
    }
    public boolean removeBranch(Integer e){
        return false;
    }
    public boolean contains(Integer element){
        if( (element!=null) )
            return (findNode(root, element)!=null);
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
    public Integer getLeft(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if((aux!=null)&&(aux.left!=null))
                return aux.left.element;
        }
        return null;
    }
    public Integer getRight(Integer element){
        if( (element!=null) ){
            Node aux = findNode(root, element);
            if((aux!=null)&&(aux.right!=null))
                return aux.right.element;
        }
        return null;
    }
    public List<Integer> positionsPre(){
        return null;
    }

    private void caminhamentoCentral(Node refNode, List<Integer> listCentral){

        if(refNode!=null){

            if(refNode.left!=null)
                caminhamentoCentral(refNode.left, listCentral);
            
            listCentral.add(refNode.element);

            if(refNode.right!=null)
                caminhamentoCentral(refNode.right, listCentral);

        }

    }

/*
    private void caminhamentoCentralNaoRecursivo(Node refNode, List<Integer> listCentral){
        List<Node> listaDeNodos = new ArrayList<>();

        listaDeNodos.add(root);

        while(listaDeNodos.size()!=0){
            Node aux = listaDeNodos.get(listaDeNodos.size()-1);

            if(aux.left!=null) listaDeNodos.add(aux.left);

            if(aux.right!=null) listaDeNodos.add(aux.right);              

        }

    }
*/
    public List<Integer> positionsCentral(){
        if(root==null)
            return null;
        
        List<Integer> result = new ArrayList<>();

        //popular a lista
        caminhamentoCentral(root, result);
//        caminhamentoCentralNaoRecursivo(root, result);

        return result;
    }
    public List<Integer> positionsPos(){
        return null;
    }
    public List<Integer> positionsWidth(){
        return null;
    }

    private void print(Node ref){
        if(ref.father==null)
            System.out.print("("+ref.element+"- RAIZ), ");
        else
            System.out.print("("+ref.element+"-"+ref.father.element+"), ");

        if(ref.left!=null) print(ref.left);
        if(ref.right!=null) print(ref.right);
    }

    public void print(){
        print(root);
        System.out.println();
    }

    private void myDump(Node ref, StringBuilder result){
        if(ref.left!=null){
            result.append("  "+ref.element+" -> "+ ref.left.element+";\n");
            myDump(ref.left, result);
        }
        if(ref.right!=null){
            result.append("  "+ref.element+" -> "+ ref.right.element+";\n");
            myDump(ref.right, result);
        }        
    }

    public String toString(){
        if(root==null){
            return "[árvore vazia]";
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("digraph G {\n");
            myDump(root, sb);
            sb.append("}\n");
            return sb.toString();
        }
    }

    private boolean isComplete(Node refNode){
        if(
            ((refNode.left!=null) && (refNode.right==null)) ||
            ((refNode.left==null) && (refNode.right!=null))
        )
            return false;

        boolean result=true;

        if(refNode.left!=null)
            result&=isComplete(refNode.left);
        if(refNode.right!=null)
            result&=isComplete(refNode.right);

        return result;

    }

    public boolean isComplete(){
        if(root==null)
            return false;

        return isComplete(root);
    }


}