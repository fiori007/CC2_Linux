import java.io.*;


class Lista {
    private String[] array;
    private int n;
    private int contador;

    /**
     * Construtor da classe.
     */
    //  public Lista() {
    //      this(6);
    //  }

    /**
     * Construtor da classe.
     * 
     * @param tamanho Tamanho da lista.
     */
    public Lista() {
        this(6);
    }

    public Lista(int tamanho){
        array = new String [tamanho];
        n=0;
    }

    public void inserirFim(String x) throws Exception {
        //String n = "";
        if (n >= array.length)
            throw new Exception("Erro!");
        array[n] = x;
        n++;
    }

    public void sort() throws Exception {
        //int array[];
        for (int i = 1; i < n; i++) {
            String tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j].compareTo(tmp)>0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    public  boolean pesqBin(String x) throws Exception {
        boolean resp = false;
        int dir = (array.length- 1), esq = 0, meio;
    
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (x.compareTo(array[meio])==0) {
                resp = true;
                esq = dir + 1;
            } else if (x.compareTo(array[meio]) > 0) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
        return resp;
    }

    // public boolean searching(String x){
    //     boolean retorno = false;
    //     for(int i=0; i < n && retorno == false; i++){
    //         if(array[i].equals(x)){
    //             retorno=true;
    //         }
    //         retorno = (array[i]==x);
    //     }
    //     return retorno;
    // }
}

public class tp2q4 {

    
    // método para tratar o nome do arquivo e retornar o nome da série
    public static String searchName(String fileName) {
        String resp = "";
        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.charAt(i) == '_') { // caso o caracter na posição i seja igual ao '_' a variável resp recebe um
                                             // espaço em branco
                resp += ' ';
            } else { // caso não tenha espaço em branco o caracter é concatenado à string resp
                resp += fileName.charAt(i);
            }
        }
        return resp.substring(0, resp.length() - 5); // retorno da substring resp retirando os 5 últimos caracteres
                                                     // relacionados à extensão do arquivo
    }

    // funcao para o input FIM como ponto de parada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args)throws Exception {
        //int contador = 0;
        String[] nomeFile = new String[100];
        int  count =0;
        Lista lista;
        String recebe="";
        nomeFile[count] = MyIO.readLine();
        while (isFim(nomeFile[count]) == false) {
            //contador++;
            nomeFile[++count]= MyIO.readLine();//aqui
            
        }
        lista= new Lista (count);
        for(int i = 0; i < count; i++){
            recebe= searchName(nomeFile[i]);
            lista.inserirFim(recebe);
        }

        lista.sort();

        nomeFile[count] = MyIO.readLine();
        while(isFim(nomeFile[count])==false){
            if(lista.pesqBin(nomeFile[count])==false){
                System.out.println("NÃO");
            }else{
                System.out.println("SIM");
            }

            nomeFile[++count]=MyIO.readLine();

            //contador++;
            //count++;
        }
    }
}