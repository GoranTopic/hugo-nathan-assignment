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
	//append to the beguining ofthe linked list
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    public void addLast(String word) {
	//append to the last of the linked list
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
								WordNode previous = current;
								String result = current.word;
								current = current.next;
								previous.next = current.next;
								return; 
                //throw new UnsupportedOperationException();
            }
											
        };
    }

		public String getWordAt(int index){
			//returns the word at the location of the index,
				//if the linked list is too short it returns null
			int count = 0;
    	WordNode node = first;

			while(node != null){
				if(count == index) return node.word;
				node = node.next;
				count++;
			}

			return null;
			
			}

		public String removeAt(int index){
			//returns the word at the location of the index,
				//if the linked list is too short it returns null
			int count = 0;
    	WordNode node = first;
			WordNode prevNode = first;
			println("removing " + index);
	
			if(index == 0){ //case for removing the first element
				first = first.next;
				return node.word;
			}
		
			while(node != null){
				if(count == index){
						prevNode = node.next;
						println("word: " + node.word);
						println("prevWord: " + prevNode.word);
						println(this);
					 return node.word;
				}
					prevNode = node;
					node = node.next;
					count++;
			}

			return null;
			
		}
		
	public int length(){
			//returns the lengths of the word salad
			int len = 0;
			WordNode node  = first;
			while(node != null){
				node = node.next;
				len++;
			}
			return len;
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

	public void println(Object obj){
		//fuction for making printing easier
		System.out.println(obj);
	}


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour. 
    public WordSalad[] distribute(int k) {
			println("distibuted fuction called with " + k); 
			int i;
			//make k nodes an d start dealing the words.
			WordSalad[] multi = new WordSalad[k];
    	java.util.Iterator<String> iter = this.iterator();
			for(i = 0; i < k; i++) multi[i] =  new WordSalad();
			i = 0;
		
			while(iter.hasNext()){
				multi[i++].addLast(iter.next());
				if(i >= k) i = 0;
			}
    		return multi;
    }


    public WordSalad[] chop(int k) {
			//for every wordSalad, if the index is less than reminder
			//it adds the averger + 1, otherwise, it only add the averger 
			WordSalad[] multi = new WordSalad[k];
    	java.util.Iterator<String> iter = this.iterator();
			int len =  this.length();
			int aver = len / k;
			int reminder = len % k;
			int to_add = aver + 1;
				
			for(int i = 0; i < k; i++){
					multi[i] = new WordSalad();
				if(i >= reminder) to_add = aver; 
				for(int ii = 0; ii < to_add; ii++){
					multi[i].addLast(iter.next());
				}
  		}
        return multi;
    }

    public WordSalad[] split(int k) {
  	 	WordSalad[] multi = new WordSalad[k];
			for(int i = 0; i < k; i++) multi[i] =  new WordSalad();
			//ditristribute the first block

			for(int i = 0; i < this.length(); i++){
				if(i % k == 0) multi[0].addLast(this.removeAt(i));
			}
			
			println(this);


	     return multi;
    }

    public static WordSalad merge(WordSalad[] blocks) {
        return null;
    }

    public static WordSalad join(WordSalad[] blocks) {
			//joins the words separeted by chop
			WordSalad concat = new WordSalad();
			
			for(int i = 0; i < blocks.length; i++){
				java.util.Iterator<String> block = blocks[i].iterator();
				while(block.hasNext()) concat.addLast(block.next());
			}
        return concat;
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
				//recontructs a word of salads that has been distributed 
				//it fins it own length of te array of wordsald thus it does not need 
				//parameter k
				WordSalad concat = new WordSalad();
      	int blockIndex = 0;
				int errorCount = 0;
				String word;
			
			while(errorCount < blocks.length){
				//tries to read a worde from each block, 
				//if it fails in all of the block it returns the words it has read
				errorCount = 0;
				for( WordSalad wordBlock : blocks){
					word = wordBlock.getWordAt(blockIndex);
					if(word == null) errorCount++;
					else concat.addLast(word); 
				}
		  	blockIndex++;
			}
			return concat;
    }

}
