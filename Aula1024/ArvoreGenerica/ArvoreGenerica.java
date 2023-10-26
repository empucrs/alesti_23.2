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
            // adicionar o e como filho de father
                aux.addSubtree(new Node(e));
                nElements++;
                return true;                
            }
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

    private void myDump(Node ref, List<String> result){
        if(ref.getSubtreeSize()!=0)
            for(Node n: ref.subtrees){
                result.add("  "+ref.value+" -> "+ n.value+";\n");
                myDump(n, result);
            }
    }

    public String toString(){
        if(root==null){
            return "[árvore vazia]";
        }
        else{
            List<String> resultado = new ArrayList<>();
            resultado.add("digraph G {\n");
            myDump(root, resultado);
            resultado.add("}\n");
            String aux="";
            for(String s: resultado)
                aux += s;
            return aux;
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
        if((e==null) || (root==null))
            return null;
        
        Node aux = findNode(root, e);

        if((aux==null)||(aux==root))
            return null;
        else
            return aux.father.value;
    }

    private void removeBranch_EliminaTodoRamo(Node ref){
        if(ref==root)
            clear();
        else{

            List<Integer> listBranch = new ArrayList<>();
            internalPositionPos(ref, listBranch);
            nElements-=listBranch.size();
            for(int i=0; i<ref.father.getSubtreeSize(); i++)
                if(ref.father.getSubtree(i)==ref){
                    ref.father.subtrees.remove(i);
                    break;
                }
            ref.father=null;
        }
    }

    public boolean removeBranch(Integer e){
        if((e==null)||(root==null))
            return false;
        Node aux = findNode(root, e);        
        removeBranch_EliminaTodoRamo(aux);
        return true;
    }

    public boolean contains(Integer e){
        if((e==null) || (root==null))
            return false;
        
        Node aux = findNode(root, e);

        return (aux!=null);
    }

    public boolean isInternal(Integer e){
        if((e==null) || (root==null))
            return false;
        
        Node aux = findNode(root, e);

        if(aux==null)
            return false;
        else
            return (aux.getSubtreeSize()>0);            
    }

    public boolean isExternal(Integer e){
        if((e==null) || (root==null))
            return false;
        
        Node aux = findNode(root, e);

        if(aux==null)
            return false;
        else
            return (aux.getSubtreeSize()==0);            
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

    private void internalPositionPos(Node ref, List<Integer> refList){

        if(ref!=null){
            for(int i=0; i<ref.getSubtreeSize(); i++)
                internalPositionPos(ref.getSubtree(i), refList);
            refList.add(ref.value);
        }

    }

    public List<Integer> positionPos(){
        if(root==null)
            return null;

        List<Integer> listPos = new ArrayList<>();

        internalPositionPos(root, listPos);

        return listPos;
    }

    private void internalPositionPre(Node ref, List<Integer> refList){

        if(ref!=null){
            refList.add(ref.value);
            for(int i=0; i<ref.getSubtreeSize(); i++)
                internalPositionPre(ref.getSubtree(i), refList);
        }
    }

    public List<Integer> positionPre(){
        if(root==null)
            return null;

        List<Integer> listPre = new ArrayList<>();

        internalPositionPre(root, listPre);

        return listPre;
    }

    public List<Integer> positionWidth(){
        if(root==null)
            return null;

        List<Integer> listWid = new ArrayList<>();
        List<Node> investigados = new ArrayList<>();
        investigados.add(root);
        while(investigados.size()>0){
            Node aux = investigados.remove(0);
            investigados.addAll(aux.subtrees);
            listWid.add(aux.value);
        }

        return listWid;
    }    
}