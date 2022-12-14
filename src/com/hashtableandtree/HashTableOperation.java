package com.hashtableandtree;
    class myMapNode {
        String key;
        int data;
        myMapNode next;
        myMapNode(String key, int data)
        {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }
public class HashTableOperation {
        myMapNode head = null;
        myMapNode tail = null;

        public void insert(String data, int count)
        {
            myMapNode newNode = new myMapNode(data, count);
            if (head == null)
            {
                head = newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.next = null;
            }
            tail = newNode;
        }
        public void display()
        {
            myMapNode current = head;
            if (head == null) {
                return;
            }
            else
            {
                while (current != null)
                {
                    System.out.println(current.key + "=" + current.data);
                    current = current.next;
                }
            }
        }

        public static void hashTableOperation(String sentence, HashTableOperation hashTable) {
            String[] string = sentence.toLowerCase().split(" ");// spliting words and store them in array

            int count = 1;
            for (int i = 0; i < string.length; i++) {

                for (int j = i + 1; j < string.length; j++)//checking element at index equals sentence
                {
                    if (string[i].equals(string[j]) && string[i] != "-1")//  it is then increment
                    {
                        string[j] = "-1";
                        count++;

                    }
                }
                if (count > 0 && string[i] != "-1") { // print count string with repeating count
                    System.out.println(string[i] + " : " + count);
                    string[i] = "-1";
                }
                count = 1;
            }
            for (int i = 0; i < string.length; i++) {

                if ( string[i] != "-1"){
                    hashTable.insert(string[i],count);
                }
            }
        }
    static void remove(String string, String word){
        String msg[] =string.split(" "); //split string
        String newString=" ";
        for (String words : msg){ //iterating the string
            if (!words.equals(word)){ // if word found
                newString+=words+" ";// concat word not equal to given word
            }
        }
        System.out.println(newString);

    }
      public static void main(String[] args) {
        HashTableOperation hashTable = new HashTableOperation();
        System.out.println("HashTable Operation");
        String string = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        hashTableOperation(string,hashTable);
        hashTable.display();
          System.out.println("\nAfter removing the word Avoidable from the Paragraph");
          remove(string,"avoidable");
          hashTable.display();
    }
    }
