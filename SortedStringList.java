import java.io.*; 
import java.util.*; 

/*  
 *  Joseph Gress CS340
 *  Programming Project 1
 */

public class SortedStringList {
//Implements a list of strings
//the strings can be accessed in ascending lexical order 
//or descending length order 
//there is only 1 node for each string
    private class Node { 
        private String data; 
        private Node next[]; //next[0] is the next reference for ascending lexical order
                             //next[1] is the next reference for descending length order
        private Node(String s, Node aN, Node dN) { 
        data = s; 
        next = new Node[2]; 
        next[0] = aN; 
        next[1] = dN;
        }
    }

    private Node heads[]; //heads[0] is the head of the ascending lexical order list 
                          //heads[1] is the head of the descending length order list
    public SortedStringList() { 
        heads = new Node[2]; //no sentinel nodes
    } 
    public void insert(String s) { 
        //if a string matching s is not in the list, insert s into the list maintaining the 
        //ascending lexical and descending length orders 
        //otherwise no changes to the list are made 


    } 
 
    public void remove(int d) { 
        //if a string matching s is in the list, remove s from the list maintaining the 
        //ascending lexical and descending length orders 
        //otherwise no changes to the list are made 
    }
    public void ascPrint() { 
        //print a comma delimited list of the strings in ascending lexical order 
    } 
 
    public void descPrint() { 
        //print a comma delimited list of the strings in descending length order 
    }
 
}
