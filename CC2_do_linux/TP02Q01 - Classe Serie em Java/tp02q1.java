/*Classe Séries em Java: Crie uma classe Séries seguindo todas as regras apresentadas
no slide unidade01g conceitosBasicos introducaoOO.pdf. Sua classe terá os atributos priva-
dos Nome (String), Formato (String), Duração (String), Paı́s de origem (String), Idioma ori-
ginal (String), Emissora de televisão original(String), Transmissão original (String), N. º de
temporadas (Inteiro), N. º de episódios (Inteiro).
Ela terá também pelo menos dois cons-
trutores, e os métodos gets, sets, clone e imprimir e ler.
O método imprimir mostra
a String ‘‘nome formato duracao paisDeOrigem idiomaOriginal emissoraDeTelevisao
transmissaoOriginal numeroTemporadas numeroEpisodio’’, contendo todos os atributos da
1
Quando reiniciamos o Linux, ele normalmente apaga os arquivos existentes na pasta /tmp/.classe. 
O método ler deve efetuar a leitura dos atributos de um registro. Veja que os dados estão
divididos em vários arquivos.
A entrada padrão é composta por várias linhas e cada uma contém o nome de um arquivo .html.
A última linha da entrada contém F IM . A saı́da padrão também contém várias linhas, uma
para cada registro contido em uma linha da entrada padrão.*/

import java.io.*;

class series {
    private String nome = "", formato = "", duracao = "", pais = "", idioma = "", emissora = "", transmissao = "";
    private int temporadas = 0, episodios = 0;

    // construtor
    series(String nome, String formato, String duracao, String pais, String idioma, String emissora, String transmissao,
            int temporadas, int episodios) {
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.pais = pais;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.temporadas = temporadas;
        this.episodios = episodios;

    }

    // construtor
    series() {
    }

    // sets
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // gets
    public String getNome() {
        return nome;
    }

    public String getFormato() {
        return formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getPais() {
        return pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getEmissora() {
        return emissora;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    // funcao para imprimir
    /*
     * void imprimir() { MyIO.println(nome); MyIO.println(formato);
     * MyIO.println(duracao); MyIO.println(pais); MyIO.println(idioma);
     * MyIO.println(emissora); MyIO.println(transmissao); MyIO.println(temporadas);
     * MyIO.println(episodios);
     * 
     * }
     */

    // funcao de remover o lixo desnecessario para o output
    public static String removerTags(String posicao) {
        // MyIO.println(posicao);
        String newline = "";
        int i = 0;
        while (i < posicao.length()) {
            if (posicao.charAt(i) == '<') {
                i++;
                while (posicao.charAt(i) != '>')
                    i++;
            } else {
                newline += posicao.charAt(i);
            }
            i++;
        }
        // MyIO.println(newline);
        return newline;
    }

    // segunda funcao para remover lixos para o output
    public String removerTags2(String posicao) {

        String newline2 = "";
        int i = 0;
        while (i < posicao.length()) {
            if (posicao.charAt(i) == '&') {
                i++;
                while (posicao.charAt(i) != ';')
                    i++;
            } else {
                newline2 += posicao.charAt(i);
            }
            i++;
        }

        return newline2;
    }

    // funcao que conserta a leitura do numero dos episodios
    public int parseVerme(String desgraca) {
        String tmp = "";
        for (int i = 0; i < desgraca.length(); i++) {
            if (desgraca.charAt(i) >= 48 && desgraca.charAt(i) <= 57) {
                tmp += desgraca.charAt(i);
            }
        }
        return Integer.parseInt(tmp);
    }
    /*
     * public void ler(String nomeArq) throws Exception {
     * 
     * InputStreamReader isr = new InputStremReader(new FileInputStrem(nomeArq));
     * 
     * BufferedReader br = new BufferReader(isr);
     * 
     * while (!br.readLine().contains("infobox_v2")); br.readLine(); this.nome =
     * removerTags(br.readLine());
     * 
     * br.close(); }
     */

    // funcao para a leitura do arquivo HTML
    public void lerArq(String nomeArq) throws Exception {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArq), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            // String splt[] =
            // for(int i=0; i<nomeArq.length();i++){
            // if(nomeArq.charAt(i)== 38 && nomeArq.charAt(i+1) == 35 &&
            // nomeArq.charAt(i+2)== 49 && nomeArq.charAt(i+3)==49 &&
            // nomeArq.charAt(i+4)==54 && nomeArq.charAt(i+5)== 48 && nomeArq.charAt(i+6) ==
            // 59){
            // nomeArq.replace("&#160;", "");
            // }
            // }

            while (!br.readLine().contains("infobox_v2"))
                ;
            br.readLine();
            this.nome = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("Formato"))
                ;
            // br.readLine();
            this.formato = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("Duração"))
                ;
            // br.readLine();
            this.duracao = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("País de origem"))
                ;
            // br.readLine();
            this.pais = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("Idioma original"))
                ;
            // br.readLine();
            this.idioma = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("Emissora de televisão original"))
                ;
            // br.readLine();
            this.emissora = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("Transmissão original"))
                ;
            // br.readLine();
            this.transmissao = removerTags2(removerTags(br.readLine()));

            while (!br.readLine().contains("N.º de temporadas"))
                ;
            // br.readLine();
            this.temporadas = Integer.parseInt(removerTags(br.readLine()));

            while (!br.readLine().contains("N.º de episódios"))
                ;
            // br.readLine();
            this.episodios = parseVerme(removerTags2(removerTags(br.readLine())));

            br.close();
        } catch (java.lang.NullPointerException erro) {
            MyIO.println("ocorrou o erro:" + erro);
        }
    }

    // funcao para o input FIM como ponto de parada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //
    public String readFile(String readArq) {
        // String elemento;
        String retornar = "";
        readArq = MyIO.readLine();
        Arq.openRead("./series/" + readArq);
        while ((Arq.hasNext())) {
            retornar += Arq.readLine();
            // retornar+="\n";
            // MyIO.print(readArq);
            // readArq = Arq.readLine();
        }
        Arq.close();

        return retornar;
    }

    // funcao para a leitura de pontos do arquivo HTML
    public String lendoPosicao(String posicao) {
        // String readArq = "";
        // readFile(readArq);
        String procura[] = posicao.split("td");
        for (int i = 0; i < procura.length; i++) {

            MyIO.println("[" + i + "]");
            MyIO.println(procura[i]);
        }
        return posicao;

    }

    // funcao que imprime concatenado as informacoes do output
    void imprimir() {
        System.out.print(nome + " " + formato + " " + duracao + " " + pais + " " + idioma + " " + emissora + " "
                + transmissao + " " + temporadas + " " + episodios + "\n");
    }
}
// fim classe series

// classe do main
class tp02q1 {

    // funcao para o input FIM como ponto de parada
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args) throws Exception {
        series teste = new series();
        String s = "";
        do {
            s = MyIO.readLine();
            if (isFim(s) == false) {
                try {
                    teste.lerArq("/tmp/series/" + s);
                } catch (Exception e) {
                }
                teste.imprimir();
            }
        } while (isFim(s) == false);
        // ponto de parada
        // teste.imprimir();
    }
}
// fim classe main