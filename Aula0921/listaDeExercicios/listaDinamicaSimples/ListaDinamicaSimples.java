import java.util.Collection;
import java.util.Collections;

public class ListaDinamicaSimples {

    private class Nodo{
        public int value;
        public Nodo prox;
        public Nodo(int v){
            value=v;
            prox=null;
        }
    }

    private Nodo header, tail;
    private int nElements;

    public ListaDinamicaSimples() {
        header=null;
        tail=null;
        nElements=0;
    }

    public boolean add(int value){
        Nodo aux = new Nodo(value);

        if(header==null)
            header=aux;
        else
            tail.prox=aux;
        tail=aux;

        nElements++;

        return true;
    }

    public boolean add(int value, int index){
        if((index<0) || (index>=nElements))
          return false;

        Nodo aux = new Nodo(value);
        if(index==0){
            aux.prox=header;
            header=aux;
        }
        else{
            Nodo navegador=header;
            while(index>1){
                navegador=navegador.prox;
                index--;
            }
            aux.prox=navegador.prox;
            navegador.prox=aux;
        }
        nElements++;

        return true;
    }
    
    public int get(int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux;
        if(index==0)
            aux=header;
        else if(index==nElements-1)
            aux=tail;
        else{
            int pos=0;
            aux=header;
            while(pos!=index){
                aux=aux.prox;
                pos++;
            }
        }

        return aux.value;

    }
    
    public void remove(int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux;
        if(index==0){
            aux=header;
            header=aux.prox;
            aux.prox=null;
        }
        else{
            aux=header;
            while(index>1){
                aux=aux.prox;
                index--;
            }
            Nodo tmp=aux.prox;
            aux.prox=tmp.prox;

            if(aux.prox==null)
                tail=aux;

            tmp.prox=null;

        }

        nElements--;
    }
    
    public int set(int value, int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux=header;
        while(index>0){
            aux=aux.prox;
            index--;
        }
        int tmp=aux.value;
        aux.value=value;
        return tmp;
    }
    
    public void clear(){
        nElements=0;
        header=null;
        tail=null;
    }

    public boolean contains(int value){
        Nodo aux=header;
        while(aux!=null){
            if(aux.value==value)
                return true;
            aux=aux.prox;
        }
        return false;
    }
    
    public int indexOf(int value){
        Nodo aux=header;
        int pos=0;
        while(aux!=null){
            if(aux.value==value)
                return pos;
            aux=aux.prox;
            pos++;
        }
        return -1;
    }
    
    public boolean isEmpty(){
        return (nElements==0);
    }
    
    public int lastIndexOf(int value){
        Nodo aux=header;
        int pos=0;
        int idx=-1;
        while(aux!=null){
            if(aux.value==value)
                idx=pos;
            aux=aux.prox;
            pos++;
        }
        return idx;
    }
    
    public int size(){
        return nElements;
    }

    public void reversePrint(){
/*
        for(int i=nElements; i>=0; i--)
            System.out.print(get(i)+"; ");
        System.out.println();
*/
        int vet [] = new int[nElements];
        Nodo aux=header;
        for(int idx=0; idx<nElements; idx++){
          vet[idx]=aux.value;
          aux=aux.prox;
        }
        for(int idx=nElements-1; idx>=0; idx--)
            System.out.print(vet[idx]+"; ");
        System.out.println();       

    }

    private void reversePrint(Nodo n){
        if(n!=null){
            reversePrint(n.prox);
            System.out.println(n.value+"; ");
        }

    }

    public void reversePrintRecursivo(){
        reversePrint(header);
    }

    public ListaDinamicaSimples getRepetidos(ListaDinamicaSimples li){

        ListaDinamicaSimples resultado = new ListaDinamicaSimples();
        for(int i=0; i<li.size()-1; i++)
          for(int j=i+1; j<li.size(); j++)
            if((li.get(i)== li.get(j)) && ! resultado.contains(li.get(i)))
                resultado.add(li.get(i));

        return resultado;

    }

}