/* File: WordSalad.java - April 2018 */
package week09;

/**
 *  Skeleton implementation of the WordSalad class.
 *
 *  @author Michael Albert
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


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour.

    
    /**
     * Distributes words into k blocks as if dealing cards.
     * @param k the number of blocks.
     * @return WordSalad[] array of split WordSalads.
     */
    public WordSalad[] distribute(int k){
        
        WordSalad[] blocks = new WordSalad[k];
        
        for(int j = 0; j < k; j++){
            blocks[j] = new WordSalad();
	}
        
	WordNode position = this.first;

        int i = 0;
        while(position != null){
            
            if(i >= k){
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
     * Distributes the words into k nearly even length blocks.
     * @param k the number of blocks.
     * @return cell is a WordSalad[] array of split words.
     */
    public WordSalad[] chop(int k) {
	int i = 0;
	WordNode curr = first;
	while(curr!=null){
	    curr=curr.next;
	    i++;
	}

	//how many words each WordSalad should have
	int each = i/k;
	//remainder of words after each WordSalad is of equal length
	int remainder = i%k;
	int a = 0;
	int b = 1;
	
	WordSalad[] cell = new WordSalad[k];
	for(int j = 0;j<k;j++){
	    cell[j] = new WordSalad();
	}

        for(String s: this){
	    if(s != null){
		cell[a].addLast(s);
	    }
	    if(b<each+(a<remainder?1:0)){
		b++;
	    }else{
		b = 1;
		a++;
	    }
	}
	return cell;
    }
        
    public WordSalad[] split(int k) {
        return null;
    }
        
    public static WordSalad merge(WordSalad[] blocks) {
        return null;
    }
    /**
     * Rejoins a sequence of blocks one after the other.
     * @param blocks the blocks of words that are to be rejoined.
     * @return w the result of rejoining the blocks into one WordSalad.
     */    
    public static WordSalad join(WordSalad[] blocks) {
	WordSalad w = new WordSalad();
	for(WordSalad block: blocks){
	    for(String s: block){
		w.addLast(s);
	    }
	}
	return w;	
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }

}
