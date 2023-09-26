import java.io.IOException;

/**
 * ListaEstatica
 */
public class ListaEstatica {

    int base[];
    int nElements;

    public ListaEstatica() {
        base = new int[4];
        nElements = 0;
    }

    public boolean add(int value){
        if(nElements>=base.length)
            grow();
        base[nElements]=value;
        nElements++;
        return true;
    }

    private void grow(){
        System.out.println("Vetor incrementado");
        int aux [] = new int [base.length*2];
        for(int i=0; i<base.length; i++)
            aux[i]=base[i];
        base=aux;
    }

    public boolean add(int value, int index){
        if( (index >=0) && (index<=nElements) ){
            if(nElements>=base.length)
                grow();
            for(int i=nElements; i>index; i--)
                base[i]=base[i-1];
            base[index]=value;
            nElements++;
            return true;
        }        
        return false;
    }
    
    public int get(int index){
        if( (index >=0) && (index<nElements) )
            return base[index];
        throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
    }
    
    public void remove(int index){
        if( (index<0) || (index>=nElements) )
            throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
        
        for(int i=index; i<nElements-1; i++)
            base[i]=base[i+1];

        nElements--;

        if(nElements<=base.length/4){
            int [] arrayAuxiliar = new int[base.length/2];
            for(int i=0; i<nElements; i++)
                arrayAuxiliar[i]=base[i];
            base=arrayAuxiliar;
        }

    }
    
    public int set(int value, int index){
        if( (index<0) || (index>=nElements) )
            throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
        
        int aux=base[index];
        base[index]=value;
        return aux;
    }
    
    public void clear(){
        nElements=0;
    }

    public boolean contains(int value){
        for(int i=0; i<nElements; i++)
            if(base[i]==value)
              return true;
        return false;
    }
    
    public int indexOf(int value){
        for(int i=0; i<nElements; i++)
            if(base[i]==value)
              return i;
        return -1;
    }
    
    public boolean isEmpty(){
        return (nElements==0);
    }
    
    public int lastIndexOf(int value){
        for(int i=nElements-1; i>=0; i--)
            if(base[i]==value)
              return i;
        return -1;
    }
    
    public int size(){
        return nElements;
    }

    public int maiorDasListas(ListaEstatica segundaLista) throws Exception{
        ListaEstatica resultado = new ListaEstatica();
        // intersecção das listas
          // escolhe uma das listas
          for(int i=0; i<nElements; i++){
          // percorre esta lista e compara se o valor existe na segunda lista
            if(segundaLista.contains(base[i])){
                // vejo se o valor já esta anotado
                if(!resultado.contains(base[i]))
                    // salvo na interseccao
                    resultado.add(base[i]);
            }
        }

        // busca o maior
          // se nao tem interseccao, gero uma exceção
        if(resultado.size()==0)
            throw new Exception("Não existe intersecção nas listas");
        
          // se tem inteseccao
        // capturo o primeiro valor
        int maior=resultado.get(0);
        // comparo com os demais
        for(int i=1; i<resultado.size(); i++)
            if(resultado.get(i)>maior)
                maior=resultado.get(i);
        
        return maior;

    }

}