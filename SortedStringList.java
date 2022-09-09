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
        if(heads[0] == null && heads[1] == null){ //If the list is empty 
            heads[0] = heads[1] = new Node(s,null,null); //Creates the first node in the list
                                                                //This node is both heads
        }else if(heads[0].next == null && heads[1].next == null ){ //If there is only one node in the list
            //Puts the new node in list with regards to heads[0]
            if(heads[0].data.compareTo(s)<0){ //value is - therefore the new node containing s comes after heads[0]
                heads[0].next[0] = new Node(s,null,null);
            }else{ //the value is + therefore the new node containing s becomes heads[0]
                Node temp = heads[0]; //temperary value for heads[0]
                heads[0] = new Node(s,temp,null); //Node containing s is now heads[0] and its next reference (next[0]) is the previous heads[0]
            }  
            //Changing to make sure heads[1] is accurate too
            if(heads[1].next[1].data.length() > heads[1].data.length()){
                heads[1] = heads[0].next[0];
                heads[1].next[1] = heads[0];
            }
                
            
        
        }else{
            //inserting changing the ascending lexical order list
            Node temp = heads[0];
            if(heads[0].data.compareTo(s)<0){//this is the case where the node containing s must be the head
                heads[0] = new Node(s,temp.next[0],null);
                //insert part that sets what next[1] is
            }
            else{
                while(temp.next[0].data.compareTo(s)>0){ //all other cases
                    temp = temp.next[0];
                    if(temp.next[0] == null){ //end of the list
                        temp.next[0] = new Node(s,null,null);
                    }
                }
                Node temp2 = temp.next[0]; //adds node at the correct position in the list
                temp.next[0] = new Node(s,temp2,null);
                //Now finding what next[1] will be for this node
                Node temp3 = heads[1];
                if(heads[1].data.length()<s.length()){ //setting the new node containing s as head[1]
                    heads[1] = temp.next[0];
                }else{ 
                    while(temp3.next[1].data.length()>s.length()){
                        temp3 = temp3.next[1];
                        if(temp3.next[1] == null){ //end of list
                            temp3.next[1] = temp;
                        }
                    }
                    temp.next[1] = temp3;
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
    } 
 
    public void descPrint() { 
        //print a comma delimited list of the strings in descending length order 
    }

    public String toString(){ //Making debugging easier
        String ret = "The list in ascending lexical order:";
        Node temp = heads[0];
        ret = ret + heads[0];

        while(temp.next[0]!= null){
            ret = ret + temp.data;
        }
        ret = ret + "\n";
        temp = heads[1];

        ret = ret + heads[1];
        while(temp.next[1] != null){
            ret = ret + temp.data;
        }
        return ret; 
    }

    public static void main(String[] args){
        SortedStringList newList = new SortedStringList();
        newList.insert("Joe");
        System.out.println(newList);
    }
 
}
