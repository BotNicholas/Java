package com.sample.news_jsoap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main 
{
    public static void main( String[] args ) {
    	try{
    		Document doc = Jsoup.connect("https://lenta.ru/").get();
    		
    		Elements images = doc.select("img");
    		
    		LinkedList<String> urls = new LinkedList<String>();
    		
    		images.forEach((image)->{
    			String [] attr = image.attr("src").split("/");
    			if(attr[attr.length - 1].matches(".+[.]....?"))
    				urls.add(image.attr("abs:src"));
    		}); //getting absolute path
    		
    		System.out.println(urls.size() + " images found:");
    		urls.forEach((url) -> System.out.println("\t"+url));
    		
//    		Images manes
//    		System.out.println("\n\n");
//    		urls.forEach((url)->System.out.println(url.split("/")[(url.split("/")).length-1].matches(".+[.]....?") ? url.split("/")[(url.split("/")).length-1] : ""));
    		
    		
			/**
			 * 		Example of reading data from an URL (non binary) 
			 * URL url = new URL("https://google.com");
			 * 
			 * Files.copy(url.openStream(), Paths.get("Test.html")); 
			 * 		or... 
			 * 
			 * BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); //if we read from a file, we would use FileReader, but now we are working with a stream, so we have to use some stream reader. For example InputStreamReader
			 * 
			 * while(reader.ready()) { System.out.println(reader.readLine()); }
			 * 
			 * 
			 * 
			 * FOR BINARY DATA USE BufferedInputStream
			 * 
			 */	
    		
    		
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		
    		
    		//input/outputStream-ы - абстрактные => нжно использовать их потомков
    		//Если ты работаешь с файлами, то это FileInput/Outputstream и др. (в параматрах они получают или сам File (объект), или путь до него)
    		//А если потоки , то Input/OutputStream...
    		
    		//BufferedReader br = new BufferedReader(new FileReader("someFile.txt"));
    		//BufferedInputStream bis = new BufferedInputStream(url.openStream());
    		
    		//Отличие в том, что Input/OutputStream-ы и их наследники (нет слов Reader/Writer) работают с битами, а Reader/Writer-ы и их потомки (есть слова Reader/Writer) работают конкретно с символами, что гораздо удобнее
    		    		
    		//!!!!!!!!!!!!!!!!!!!!!!ВЫВОД!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			/*
			*  Если тебе надо работать именно на битовом уроввне, то используй Input/OutputStream и их потомки (приставка Buffered в BufferedInput/OutputStream говорит о том, что считанные изи записываемые данные сначала помещаются в буфер, что позволяет считывать или записывать сразу строку,а не посимвольно)
			*  Но а если тебе надо работать именно с символами, то тут уже используй Reader/Writer и их потомки
			*  
			*  Зацени разницу:
			*
    		*
    		*	работа с битами => неочень удобно...
    		*URL url = new URL("https://google.com");
    		*
    		*BufferedInputStream bis = new BufferedInputStream(url.openStream());
    		*
    		*byte [] bytes = bis.readAllBytes();
    		*
    		*for(byte bit : bytes) {
    		*	System.out.print((char)bit);
    		*}
    		*
    		*
    		*	работа с символами напрямую
    		*	Так не получится => укажем класс, которй умеет с этим работать
    		*	BufferedReader reader = new BufferedReader(url.openStream());
    		*
    		*	BufferedReader работает только с Reader или с его потомками => не подходит; FileReader - только с файлами, а нам нужно именно с потоком вывода (InputStream => не подходит), а вот InputStreamReader подходит => используем его
    		*BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    		*
    		*while(reader.ready()) {
    		*	System.out.println(reader.readLine());
    		*}
    		*
    		*
    		*/
  
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		
    		
    		
    		System.out.println("\nSaving them in \"images\" folder...");
    		urls.forEach((url)->saveImage(url, "images"));
    		
    		System.out.println("Done!");
    		
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    public static void saveImage(String u, String folderName) {
    	try {
    		URL url = new URL(u);
    		File folder = new File(folderName);
    		
    		String imageName = u.split("/")[u.split("/").length-1];
    		
    		if(imageName.matches(".+[.]....?")) {
    			folder.mkdir();
    			BufferedInputStream from = new BufferedInputStream(url.openStream());
        		FileOutputStream to = new FileOutputStream(folderName+"/"+imageName);
        		
        		to.write(from.readAllBytes());
        		to.flush();
        		
        		System.out.println("Image " + imageName + " saved!");
        		from.close();
        		to.close();
    		}
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
