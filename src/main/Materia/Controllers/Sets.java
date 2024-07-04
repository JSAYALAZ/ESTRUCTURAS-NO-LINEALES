package main.Materia.Controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public Sets() {
        construirSet();
        construirHashSet();
        construirLinkedSet();
        construirTreeSet();
        construirTreeSetConComparacion();
    }

    public void construirSet() {
        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Papaya");
        conjunto.add("Naranja");
        conjunto.add("Manzana");
        conjunto.add("Uva");
        conjunto.add("Piña");
        conjunto.add("Guayaba");

        System.out.println("HashSet: " + conjunto);

        conjunto.remove("Banana");
        System.out.println("Luego de eliminar la banana: " + conjunto);
        conjunto.remove("Uva");
        conjunto.remove("Guayaba");
        System.out.println("Luego de eliminar el set: " + conjunto);

        boolean contain = conjunto.contains("Guayaba");
        System.out.println("¿Contiene Guayaba?: " + contain);

        int sizeSet = conjunto.size();
        System.out.println("Tamaño del set: " + sizeSet);
    }

    public void construirHashSet() {
        LinkedHashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Papaya");
        conjunto.add("Naranja");
        conjunto.add("Manzana");
        conjunto.add("Uva");
        conjunto.add("Piña");
        conjunto.add("Guayaba");

        System.out.println("LinkedHashSet: " + conjunto);
    }

    public void construirLinkedSet() {
        LinkedHashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Papaya");
        conjunto.add("Naranja");
        conjunto.add("Manzana");
        conjunto.add("Uva");
        conjunto.add("Piña");
        conjunto.add("Guayaba");

        System.out.println("LinkedHashSet (mismo que HashSet en este contexto): " + conjunto);
    }

    public void construirTreeSet() {
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Papaya");
        conjunto.add("Naranja");
        conjunto.add("Manzana");
        conjunto.add("Uva");
        conjunto.add("Piña");
        conjunto.add("Guayaba");

        System.out.println("TreeSet: " + conjunto);
    }

    public void construirTreeSetConComparacion() {
        Comparator<String> comparadorOrderInverso = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        TreeSet<String> conjunto = new TreeSet<>(comparadorOrderInverso);
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Papaya");
        conjunto.add("Naranja");
        conjunto.add("Manzana");
        conjunto.add("Uva");
        conjunto.add("Piña");
        conjunto.add("Guayaba");

        System.out.println("TreeSet con comparación personalizada (orden inverso): " + conjunto);
    }
}
