class principal {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String readFile(String readArq) {
        // String elemento;
        String retornar = "";
        readArq = MyIO.readLine();
        Arq.openRead("./series/" + readArq);
        while ((Arq.hasNext())) {
            retornar+=Arq.readLine();
            // retornar+="\n";
            // MyIO.println(readArq);
            // readArq = Arq.readLine();
        }
        Arq.close();

        return retornar;
    }

    public static String lendoPosicao(String posicao) {

        // String procura[] = posicao.split("scope");
        if(posicao.contains("<tr>")&& 
        posicao.contains("</tr>")&& 
        posicao.contains("<td>")&& 
        posicao.contains("</td>")&&
        posicao.contains("</a>")){
        // String  posicao.split("style");
            String procura[] = posicao.split("title=");
            posicao.split(";");
            for (int i = 0; i < procura.length; i++) {
                MyIO.println("[" + i + "]");
                MyIO.println(procura[i]);
            }
        }
        return posicao;

    }

    public static void main(String[] args) {
        //series teste = new series();
        String readArq = "";
        String posicao = readFile(readArq);
        // readFile(readArq);
        //teste.imprimir();
        // MyIO.println(lendoPosicao(posicao));
        lendoPosicao(posicao);

    }
}