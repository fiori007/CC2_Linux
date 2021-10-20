/*nome:lucas fiori magalhaes machado
matricula:727937*/

//import java.util.Scanner;
//criando classe
public class extra1c{
    //criando funcao decimal
    public static String decimal(int x){

        //codigo que transforma decimal em binario
        String binaria = Integer.toBinaryString(x);
        return binaria;
    }//fim da funcao

    //incio main
    public static void main(String[] args){
        int x = 0;
        x = MyIO.readInt();
        MyIO.println(decimal(x));//printando resultado da funcao
        


    }
    //fim main



}//fim classe