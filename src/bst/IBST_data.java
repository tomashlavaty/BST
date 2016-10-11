/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 * @author tomas
 */
public interface IBST_data {
    
    public String toString();
    
    public int compare(Object paKey);
    public int compare(BST_node paHodnota);
    public Object getKey();
    
}
