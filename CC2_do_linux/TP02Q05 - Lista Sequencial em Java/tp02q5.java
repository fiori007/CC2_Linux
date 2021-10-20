import java.io.*;
import java.io.FileReader;


class Lista {

    private int contador;
    private Serie[] lista;

    public Lista() {
        this.contador = 0;
        lista = new Serie[1];

    }

    public Lista(int tamanho) {
        this.contador = 0;
        lista = new Serie[tamanho];
    }

    public int getcontador() {
        return this.contador;
    }

    public void inserirInicio(Serie serie) {
        // if (contador >= lista.length){
        // System.exit(0);
        // }

        for (int i = contador; i > 0; i--) {
            lista[i] = lista[i - 1];
        }
        lista[0] = serie;
        contador++;
    }

    public void inserirFim(Serie serie) {
        // if (contador >= lista.length) {
        // System.exit(0);
        // }

        lista[contador] = serie;
        contador++;
    }

    public void inserir(Serie serie, int pos) {
        // if (contador >= lista.length || pos < 0 || pos > contador ) {
        // System.exit(0);
        // }

        for (int i = contador; i > pos; i--) {
            lista[i] = lista[i - 1];
        }
        lista[pos] = serie;
        contador++;
    }

    public Serie removerInicio() {
        // if (contador == 0) {
        // System.exit(0);
        // }

        Serie resp = lista[0];
        contador--;

        for (int i = 0; i < contador; i++) {
            lista[i] = lista[i + 1];
        }
        return resp;
    }

    public Serie removerFim() {
        // if (contador == 0) {
        // System.exit(0);
        // }
        contador = contador - 1;
        return lista[contador];
    }

    public Serie remover(int pos) {
        // if (contador == 0 || pos < 0 || pos >= contador ) {
        // System.exit(0);
        // }

        Serie resp = lista[pos];
        contador--;

        for (int i = pos; i < contador; i++) {
            lista[i] = lista[i + 1];
        }

        return resp;
    }

    public void mostrar() {
        // System.out.println(contador);
        for (int i = 0; i < contador; i++) { // 15
            System.out.println(lista[i].toString());
        }

    }

    public Serie obterNaPosicao(int pos) {
        return lista[pos];
    }

}


class Series {
    String nome = "";
    String idioma = "";
    String formato = "";
    String duracao = "";
    String pais = "";
    String emissora = "";
    String transmissao = "";
    int Ntemporadas = 0;
    int Nepisodios = 0;

    Series() {
    }

    public Series clone() {
        Series resp = new Series();
        resp.nome = this.nome;
        resp.formato = this.formato;

        return resp;
    }

    Series(String nome, String idioma, String formato, String duracao, String pais, String emissora, String transmissao,
            int Ntemporadas, int Nepisodios) {
        this.nome = nome;
        this.idioma = idioma;
        this.formato = formato;
        this.duracao = duracao;
        this.pais = pais;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.Ntemporadas = Ntemporadas;
        this.Nepisodios = Nepisodios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public String getEmissora() {
        return emissora;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTemporada(int Ntemporadas) {
        this.Ntemporadas = Ntemporadas;
    }

    public int getTemporadas() {
        return Ntemporadas;
    }

    public void setEpisodio(int Nepisodios) {
        this.Nepisodios = Nepisodios;
    }

    public int getEpisodio() {
        return Nepisodios;
    }

    public void imprimir() {

        System.out.print(nome + " " + formato + " " + duracao + " " + pais + " " + idioma + " " + emissora + " "
                + transmissao + " " + Ntemporadas + " " + Nepisodios + "\n");
        /*
         * MyIO.print(nome); MyIO.print(formato); MyIO.print(duracao); MyIO.print(pais);
         * MyIO.print(idioma); MyIO.print(transmissao); MyIO.print(emissora);
         * MyIO.print(Ntemporadas); MyIO.print(Nepisodios);
         */
    }

    void lerArq(String nomeArq) throws Exception {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArq));
            BufferedReader br = new BufferedReader(isr);

            // String retorn = "";
            // entrada = MyIO.readLine();
            // Arq.openRead("./series/" + entrada);

            // while(Arq.hasNext()){
            // retorn = removeTags(Arq.readLine());
            // MyIO.print(entrada);
            // entrada = Arq.readLine();
            while (!br.readLine().contains("infobox_v2"))
                ;
            br.readLine();
            this.nome = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("Formato"))
                ;
            // br.readLine();
            this.formato = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("Duração"))
                ;
            // br.readLine();
            this.duracao = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("País de origem"))
                ;
            // br.readLine();
            this.pais = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("Idioma original"))
                ;
            // br.readLine();
            this.idioma = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("Emissora de televisão original"))
                ;
            // br.readLine();
            this.emissora = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("Transmissão original"))
                ;
            // br.readLine();
            this.transmissao = removeTags2(removeTags(br.readLine()));

            while (!br.readLine().contains("N.º de temporadas"))
                ;
            // br.readLine();
            this.Ntemporadas = Integer.parseInt(removeTags(br.readLine()));

            while (!br.readLine().contains("N.º de episódios"))
                ;
            // br.readLine();
            this.Nepisodios = sla(removeTags2(removeTags(br.readLine())));

            br.close();
        } catch (java.lang.NullPointerException erro) {
            MyIO.println("ocorrou o erro:" + erro);
        }
    }

    /*
     * public void lerarq(String entrada) throws Exception { InputStreamReader isr =
     * new InputStreamReader(new fileInputStream) }
     */
    public int sla(String s) {
        String cu = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                cu += s.charAt(i);
            }
        }
        return Integer.parseInt(cu);
    }

    String removeTags2(String line) {
        // MyIO.print(line);
        String newline = "";
        String teste = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '&') {
                i++;
                while (line.charAt(i) != ';')
                    i++;
            } else {
                newline += line.charAt(i);
            }
            i++;

        }

        return newline;
    }

    String lixo(String newline) {
        newline = newline.replace("&#160;", "");
        newline = newline.replace("&nbsp;", "");
        newline = newline.replace("?", "-");
        return newline;
    }

    String removeTags(String line) {
        // MyIO.print(line);
        String newline = "";
        String teste = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>')
                    i++;
            } else {
                newline += line.charAt(i);
            }
            i++;

        }

        return newline;
    }

    /*
     * public static String procurar(String posicao){
     * if((posicao.contains("<td>"))&&(posicao.contains("</td>"))&&(posicao.contains
     * ("<tr>"))&&(posicao.contains("</a>"))&&(posicao.contains("</tr>"))){ String
     * procura[]=posicao.split("title="); for(int i=0; i<procura.length;i++){
     * 
     * MyIO.println("["+i+"]"); MyIO.println(procura[i]); } } return posicao; }
     */
}

public class tp02q5 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Series obj = new Series();
        String entrada = "";
        do {
            entrada = MyIO.readLine();
            if (isFim(entrada) == false) {
                try {
                    obj.lerArq("/tmp/series/" + entrada);
                } catch (Exception e) {

                }
                obj.imprimir();

            }
        } while (isFim(entrada) == false);

    }
}
