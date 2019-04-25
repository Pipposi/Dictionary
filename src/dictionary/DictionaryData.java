/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author wils0496
 */
public class DictionaryData {

    private String dataOut;
    private String freqOut;
    
    /**
     * Creates a new DictionaryData object based upon the the String line that
     * contains the data about the new data item.
     * 
     * @param line the data about the new data item 
     */
    public DictionaryData(String line)
    {
        String[] data = line.split("\\s+");
        //System.out.println("line: " + line + " d[1]: " + data[1] + " d[2]:" + data[2]);
        dataOut = data[1];
        freqOut = data[2];
        /*for(int i = 0; i<3; i++){
            data[i] = null;
        }
        System.out.println("d[0]:" + data[0] + " d[1]:" + data[1] + " d[2]:" + data[2]);*/
    }
    /**`
     * A string representation of the DataDictionary object. For example
     *
     *     "orange: frequency = 518"
     * 
     * @return a string representation of the DataDictionary object
     */
    @Override
    public String toString() {
        return getDataOut() + ": frequency = " + getFreqOut();
    }

    /**
     * @return the dataOut
     */
    public String getDataOut() {
        return dataOut;
    }
    /**
     * @return the freqOut
     */
    public String getFreqOut() {
        return freqOut;
    }
}
