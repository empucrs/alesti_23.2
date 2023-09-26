public class SetList {

    private class Nodo{
        public int value;
        public Nodo prox;
        public Nodo(int v){
            value=v;
            prox=null;
        }
    }

    private Nodo header;
    private int nElementos;

    public SetList(){
        header=null;
        nElementos=0;
    }

    public boolean insere(int value){
        if(nElementos==0){
            header = new Nodo(value);
            nElementos++;
            return true;
        }
        else{
            Nodo aux = header;
            while(aux!=null && aux.value!=value)
                aux=aux.prox;
            if(aux==null){
                aux=header;
                while(aux.prox!=null)
                    aux = aux.prox;
                aux.prox=new Nodo(value);
                nElementos++;
                return true;
            }
            return false;
        }
    }

    public boolean pertence(int value){

        return false;
        
    }

    public boolean retira(int value){
        return false;
    }

    public SetList interseccao(SetList segundoConjunto){
        return null;
    }

    
}