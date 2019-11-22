
package avtoparse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class AvtoParse {
    static ArrayList<String> arr= new ArrayList<>();
       
    public static void main(String[] args) {
        try{
            String URL = "https://www.lada.ru/";
                 getdataFromURL(URL);
             for(int i = 0;i<arr.size();i++){
                 getdat(arr.get(i));
                 
             }
        }
        catch(Exception e){
        //     java.util.logging.Logger.getLogger(TestJSoup.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void getdataFromURL(String URL) throws IOException{
     
        Document doc;   
       
            doc = Jsoup.connect(URL).get();
            Elements news = doc.select(".cars-menu__base-name.menu_models_a");
            
              for (Element element : news){ 
              //  System.out.println(element.text()+": "+element.absUrl("href"));
              arr.add(element.absUrl("href"));
              }
        }
  
            public static void getdat(String URL) throws IOException{
               int i = 0;
               String[] compl;
               String[] prices;
               Document doc;
               doc = Jsoup.connect(URL).get();
               String title = doc.title(); 
               System.out.println(title);
               Elements news = doc.select("#configurator");
               compl = new String[30];
               prices = new String[30];
       
               for (Element element : news.select(".kompl_name")){ 
               compl[i] = element.text();
               i = i + 1;
               }
               i = 0;
               for (Element element : news.select(".kompl_price")){ 
               prices[i] = element.text();
               i = i + 1;       
               }
               for(i = 0;i<30;i++){
               System.out.println(compl[i]+" "+prices[i]);
               }
            }
  
}


