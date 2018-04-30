/* File: WordSalad.java - April 2018 */
package week09;

/**
 *  Skeleton implementation of the WordSalad class.
 *
 *  @author Nathan Laing and Hugo Baird
 */
public class WordSalad implements Iterable<String> {

    private WordNode first;
    private WordNode last;
     
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }
  
    private class WordNode {
        private String word;
        private WordNode next;
                
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
        
    }
  
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;
      
            public boolean hasNext() {
                return current != null;
            }
      
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }
      
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
                
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }
    ////////////////////////////////////////////////////////////////////
    /**
     * Helper method: creates and returns an array of WordSalad objects.
     * @param size the number of blocks you want
     * @return blocks an array of WordSalad obj's
     */
     public WordSalad[] divide(int size) {
        
        WordSalad[] blocks = new WordSalad[size];
        
        for(int blocksadded = 0; blocksadded < size; blocksadded++){
            
            blocks[blocksadded] = new WordSalad();
        }
        return blocks;
    }
     
    /**
     * Optional method: Like a combination of chop and distribute.
     * @param k the number of blocks
     * @return blocks[] array of WordSalad obj's
     */
    public WordSalad[] split(int size) {
      return null;
    }
    
    /**
     * Optional method: The opposite of split.
     * @param blocks an array of WordSalad objects to be merged.
     * @param k the size of the inserts
     * @return result a single WordSalad obj
     */
    public static WordSalad recombine(WordSalad[] blocks, int k){
      return null;
    }
    
    /**
     * WORKING.
     * Required method: Distributes words into k blocks as if dealing cards.
     * @param k the number of blocks.
     * @return WordSalad[] array of split WordSalads.
     */
    public WordSalad[] distribute(int k){

        WordSalad[] blocks = this.divide(k);
        
        WordNode position = this.first;

        int i = 0;  // To check which block we are adding into
        while(position != null){
            
            if(i >= k){  // If we are at the last block switch back
                i = 0;
            }
            
            blocks[i].addLast(position.word);
            i++;
            
            if(position.next == null){
                return blocks;
            } else {               
                position = position.next;
            }
        }
        return blocks;
    }
    
    /**
     * NOT WORKING.
     * Required method: Distributes the words into k nearly even length blocks.
     * @param k the number of blocks.
     * @return cellBlock is a WordSalad[] array of split words.
     */
     public WordSalad[] chop(int k) {
       //Creates new WordSalad of number of blocks.
       WordSalad[] cellBlock = this.divide(k);
       
       //Counts number of words in list
       int i = 0;
       WordNode curr = first;
       while(curr != null){
         curr = curr.next;
         i++;
       }
       
       for(int x = 0; x < k; x++){
         cellBlock[x] = new WordSalad();
       }
       // Counts until wordLimit of block has been reached.
       int wordLimitCount = 1;
       //The word limit of each WordSalad based off words and blocks.
       int wordLimit = i / k;
       //Finds the remainder to check if extra words need to be added
       int remainder = i % k;
       
       //Adds words into WordSalad block until block limit has been reached.
       int count = 0;
       for(String word : this){
         if(word != null){
           cellBlock[count].addLast(word);
         }
         if(wordLimitCount < (wordLimit + (count < remainder ? 1 : 0))){
           wordLimitCount++;
         } else {
           count++;
           wordLimitCount = 1; 
         }
       }
       return cellBlock;
     }
      
    /**
     * NOT WORKING.
     * Required method: The opposite of distribute, this removes the n then n + 1 etc words from all blocks adding it to a singular one.
     * @param blocks an array of WordSalad objects each with their own words
     * @return result a singular WordSalad object with all the merged words in it
     */
    public static WordSalad merge(WordSalad[] blocks) {
      WordSalad result = new WordSalad();
      
      int sentenceLen = 0;
      for( WordSalad block : blocks){
        WordNode position = block.first;
        while(position != null){
            sentenceLen++;
            if(position.next == null){
                break;
            } else {
                position = position.next;
            }
        }
      }
      WordNode blockIndex = null;
      for(int added = 0; added < sentenceLen; added++){
            for(WordSalad block : blocks){
                WordNode currentWord = blockIndex;
            }
      }
      return null;
    }

    /**
     * WORKING.
     * Required method: Rejoins a sequence of blocks one after the other.
     * @param blocks the blocks of words that are to be rejoined.
     * @return w the result of rejoining the blocks into one WordSalad.
     */    
    public static WordSalad join(WordSalad[] blocks) {
      WordSalad joined = new WordSalad();
      for(WordSalad block: blocks){
        for(String s: block){
          joined.addLast(s);
        }
      }
      return joined;
    }
}