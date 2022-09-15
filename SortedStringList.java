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
//        s = s.toLowerCase(); 
        if(heads[0] == null || heads[1] == null){ //If the list is empty 
            heads[0] = heads[1] = new Node(s,null,null); //Creates the first node in the list
                                                                //This node is both heads
        }else if(heads[0].next[0] == null){ //If there is only one node in the list
            //Puts the new node in list with regards to heads[0]
            if(heads[0].data.toLowerCase().compareTo(s.toLowerCase())<=0){ //value is - therefore the new node containing s comes after heads[0]
                heads[0].next[0] = new Node(s,null,null);
            }else{ //the value is + therefore the new node containing s becomes heads[0]
                Node temp = heads[0];
                heads[0] = new Node(s,temp,null); //Node containing s is now heads[0] and its next reference (next[0]) is the previous heads[0]
            }
            
            //Changing to make sure heads[1] is accurate too
            if(heads[0].next[0].data.length() > heads[0].data.length()){
                heads[1] = heads[0].next[0];
                heads[1].next[1] = heads[0];
            }else if(heads[0].next[0].data.length()<= heads[0].data.length()){
                heads[1] = heads[0];
                heads[1].next[1] = heads[0].next[0];
            }

                
            
        
        }else{

            Node temp0 = heads[0];
            Node temp1 = heads[1];
            if(heads[0].data.toLowerCase().compareTo(s.toLowerCase())>0){//this is the case where the node containing s must be the head
                heads[0] = new Node(s,temp0,null);
                Node temp = heads[0];
                //insert part that sets what next[1] is
                if(heads[1].data.length()<=s.length()){
                    temp.next[1] = heads[1];
                    temp = heads[1];

                }else{
                    while(temp1.next[1] != null && s.length()<temp1.next[1].data.length()){
                        temp1 = temp1.next[1];
                    }
                    if(temp1.next[1] == null){
                        temp1.next[1] = heads[0];
                    }else{
                        Node where = temp1.next[1];
                        temp1.next[1] = heads[0];
                        heads[0].next[1] = where;
                    }
                    
                }
            }
            else{
                while(temp0.next[0].data.toLowerCase().compareTo(s.toLowerCase())<0){ //all other cases
                    temp0 = temp0.next[0];
                    if(temp0.next[0] == null){ //end of the list
                        break;
                    }
                }
                Node temp2 = temp0.next[0];
                //figure out next[1] here
                if(s.length()>heads[1].data.length()){
                    temp0.next[0] = new Node(s,temp2,heads[1]);
                    Node j = temp0.next[0];
                    heads[1] = j;
                    
                }else{
                    while(temp1.next[1].data.length() > s.length()){
                        temp1 = temp1.next[1];
                        if(temp1.next[1] == null){
                            break;
                        }
                    }
                    temp0.next[0] = new Node(s,temp2,null);
                    Node insert = temp0.next[0];
                    Node where = temp1.next[1];
                    temp1.next[1] = insert;
                    insert.next[1] = where;
                    

            
                }
            
            }

        }

    } 
 
    public void remove(int d) { 
        //if a string matching s is in the list, remove s from the list maintaining the 
        //ascending lexical and descending length orders 
        //otherwise no changes to the list are made 
    }
    public void ascPrint() { 
        //print a comma delimited list of the strings in ascending lexical order
         String ret = "The list in ascending lexical order:";
        Node temp = heads[0];

        ret = ret + temp.data;

        while(temp.next[0]!= null){
            ret = ret + ", " + temp.next[0].data;
            temp = temp.next[0];
        }
        System.out.println(ret);
    } 
 
    public void descPrint() { 
        //print a comma delimited list of the strings in descending length order
        Node temp = heads[1];

        String ret = "The list in descending length order:" + temp.data;

        while(temp.next[1] != null){
            ret = ret + ", " + temp.next[1].data;
            temp = temp.next[1];
        }
        System.out.println(ret);
    }

    public String toString(){ //Making debugging easier
        String ret = "The list in ascending lexical order:";
        Node temp = heads[0];

        ret = ret + temp.data;

        while(temp.next[0]!= null){
            ret = ret + ", " + temp.next[0].data;
            temp = temp.next[0];
        }
        temp = heads[1];

        ret = ret + "\n The list in descending length order:" + temp.data;

        while(temp.next[1] != null){
            ret = ret + ", " + temp.next[1].data;
            temp = temp.next[1];
        }
        return ret; 
    }

    public static void main(String[] args){
        SortedStringList newList = new SortedStringList();
        newList.insert("ca");
        newList.insert("baa");
        newList.insert("a");
        newList.ascPrint();
        newList.descPrint();
    }
 
}
