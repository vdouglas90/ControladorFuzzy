package Interfaces;

import java.util.ArrayList;
import java.util.List;

public class Interfaces {

    static List<String> listaEntradas = new ArrayList<String>();

    public static void main(String[] args) {
        listaEntradas.add("luiz");
        listaEntradas.add("daniel");



        String s = "luiz";
        for (int i = 0; i < listaEntradas.size(); i++) {
            System.out.println(listaEntradas.get(i).equals("luiz"));
        }

        //if (listaEntradas.equals("luiz")) {
        //  System.out.println(listaEntradas.equals("luiz"));
        //} else {
        //   System.out.println(listaEntradas.equals("luiz"));
        //  System.out.println("FALSO");
        //s}


    }
}
