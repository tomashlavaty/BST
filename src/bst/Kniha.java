/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 * @author tomas
 */
public class Kniha implements IBST_data{
    
    private String ISBN;

    public Kniha(String ISBN) {
        this.ISBN = ISBN;
    }

  
    
     @Override
    public int compare(BST_node paNode) {
        String isbn=((Kniha)paNode.getData()).ISBN;
      if(isbn.compareToIgnoreCase(this.ISBN)<0){
          return -1;
      }
      else if(isbn.compareToIgnoreCase(this.ISBN)>0){
          return 1;
      }
      else{
           return 0; 
      } 
    
    }
    
    public int compare(Object paKey){
    String key=((String)paKey);
    
    if(((String)this.getKey()).compareToIgnoreCase(key)<0){
          return -1;
      }
      else if(((String)this.getKey()).compareToIgnoreCase(key)>0){
          return 1;
      }
      else{
           return 0; 
      }           
    
    }
    
    public String toString(){
        return "Kniha ISBN:"+this.ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public Object getKey() {
        return this.ISBN;
    }
    
    

  
    
    
    
    
}
