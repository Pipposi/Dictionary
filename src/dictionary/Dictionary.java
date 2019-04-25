/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wils0496
 */
public class Dictionary {

    private Map<String, DictionaryData> dictionaryMap = null;

    public Dictionary() {
        dictionaryMap = new TreeMap<>();
    }
    
    public void insert(String s, DictionaryData data) {
         dictionaryMap.put(s.toLowerCase(), data);
    }

    public DictionaryData remove(String s) {
        return dictionaryMap.remove(s.toLowerCase());
    }

    public DictionaryData lookup(String s) {
        return dictionaryMap.get(s.toLowerCase());
    }
    
    public boolean contains(String key) {
        return dictionaryMap.containsKey(key.toLowerCase());
    }

    public static Dictionary readInDictionary(String fileName) {
        Dictionary d = new Dictionary();
        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                // System.out.println("nextLine: " + nextLine); uncomment if you want to see what is read in
                DictionaryData data = new DictionaryData(nextLine);
                d.insert(data.getDataOut(), data);

                // TODO: call insert() here to insert the data object into the dictionary! 
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return d;
    }

    public List<String> spellCheck(String fileName) {

        Scanner fileScanner;
        ArrayList<String> retList = new ArrayList<>();
        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream(fileName));
            fileScanner.useDelimiter(" |\\n");

            while (fileScanner.hasNext()) {
                String nextEle = fileScanner.next();
                if (!dictionaryMap.containsKey(nextEle.toLowerCase())){
                    if (nextEle.length()!=0){ 
                        retList.add(nextEle);
                    }
                    
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return retList;
    }

    public Collection<DictionaryData> alphabeticalList() {
        return dictionaryMap.values();
    }

    public Collection<DictionaryData> frequencyOrderedList() {
      ArrayList<DictionaryData> freqdic = new ArrayList<>();
      freqdic.addAll(dictionaryMap.values());
      Collections.sort(freqdic, new Comparator<DictionaryData>(){
          @Override
          public int compare(DictionaryData t, DictionaryData t1) {
           if (Integer.parseInt(t.getFreqOut()) < Integer.parseInt(t1.getFreqOut())){
               return -1;
           }
           else if (Integer.parseInt(t.getFreqOut()) > Integer.parseInt(t1.getFreqOut())){
               return 1;
           }
           else{
               return -1*(t.getDataOut().compareTo(t1.getDataOut()));                   
               }    
          }      
      });              
        return freqdic;
    }
    }

