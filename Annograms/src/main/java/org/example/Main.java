package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dictionaryLink="https://anagram.poncy.ru/?inword=WORD&answer_type=1";
        System.out.print("Enter a word: ");
        String word = scanner.nextLine().toLowerCase().trim();
        dictionaryLink = dictionaryLink.replace("WORD", word);

        try {
            Document document = Jsoup.connect(dictionaryLink).maxBodySize(0).get();
            Elements elements = document.select(".resultquery");
            List<String> anogramms = new ArrayList<>();

            elements.forEach((e)->{
                if(!e.html().toLowerCase().equals(word)){
                    anogramms.add(e.html().toLowerCase());
                }
            });

            if(anogramms.size() > 0){
                System.out.println("Annograms for word \"" + word + "\": ");
                anogramms.forEach((a)->System.out.println("-> " + a));
            }
            else
                System.out.println("Word \"" + word + "\" don't have anogramms!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}