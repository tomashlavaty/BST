/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
  * @author tomas
 */
public class BST_node {

    private IBST_data data;
    private BST_node Left;
    private BST_node Right;

    public BST_node(IBST_data data) {

        this.data = data;
    }

    public int getPocetDeti() {
        if (this.Left != null && this.Right != null) {
            return 2;
        }
        else if(this.Left != null || this.Right != null){
            return 1;
        }
        else {
            return 0;
        }       

    }

    public IBST_data getData() {
        return data;
    }

    public void setData(IBST_data data) {
        this.data = data;
    }

    public BST_node getLeft() {
        return Left;
    }

    public void setLeft(BST_node Left) {
        this.Left = Left;
    }

    public BST_node getRight() {
        return Right;
    }

    public void setRight(BST_node Right) {
        this.Right = Right;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
